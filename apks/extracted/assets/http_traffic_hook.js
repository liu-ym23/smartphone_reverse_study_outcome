(function () {
    console.info('start hook post method!!!');
    const requestBodyMap = new Map()

    function getRequestBody(reqId, isOptions) {
        var result = requestBodyMap.get(reqId);
        if (!isOptions) {
            requestBodyMap.delete(reqId)
        }
        return result
    }
    function insertRequestBody(reqId, base64Body) {
        if (window.parent != window.self) {
            const message = {
                type: 'insertRequestBody',
                reqId: reqId,
                base64Body: base64Body
            };

            window.parent.postMessage(message, '*');
        } else {
            requestBodyMap.set(reqId, base64Body);
        }
    }

    function getUrlWithoutLarkProxyParam(urlStr) {
        const url = new URL(urlStr);
        url.searchParams.delete('lark_app_proxy_req_id'); // 删除参数
        return url.toString(); // 返回新 URL
    }

    window.addEventListener('message', (event) => {
        if (event.data.type === 'insertRequestBody') {
            insertRequestBody(event.data.reqId, event.data.base64Body);
        }
    });
    window.getRequestBody = getRequestBody;
    window.requestBodyMap = requestBodyMap;

    async function convertBodyToBase64(body) {
        try {
            if (body == null) return '';

            if (typeof body === 'string') {
                return btoa(unescape(encodeURIComponent(body)));
            }

            if (body instanceof Blob) {
                return await blobToBase64(body);
            }

            if (body instanceof ArrayBuffer || ArrayBuffer.isView(body)) {
                return arrayBufferToBase64(body);
            }

            if (body instanceof FormData) {
                return await formDataToBase64(body);
            }

            if (typeof body === 'object') {
                return btoa(unescape(encodeURIComponent(JSON.stringify(body))));
            }

            return btoa(unescape(encodeURIComponent(String(body))));
        } catch (e) {
            console.error('Convert body to base64 failed:', e);
            return '';
        }
    }
    // 新增的 FormData 处理函数
    async function formDataToBase64(formData) {
        if (hasFile(formData)) {
            let body = await formFileDataToBody(formData);
            return btoa(unescape(encodeURIComponent(JSON.stringify(body))));
        } else {
            // 方案1: 简单键值对字符串化
            const entries = [];
            for (const [key, value] of formData.entries()) {
                if (value instanceof Blob) {
                    let blob = `[Blob ${value.type} ${value.size}bytes]`;
                    entries.push(`${encodeURIComponent(key)}=${encodeURIComponent(String(blob))}`);
                } else {
                    entries.push(`${encodeURIComponent(key)}=${encodeURIComponent(String(value))}`);
                }
            }
            return btoa(entries.join('&'));
        }
    }
    function arrayBufferToBase64(buffer) {
        let binary = '';
        const bytes = new Uint8Array(buffer);
        for (let i = 0; i < bytes.byteLength; i++) {
            binary += String.fromCharCode(bytes[i]);
        }
        return btoa(binary);
    }
    function blobToBase64(blob) {
        return new Promise((resolve, reject) => {
            const reader = new FileReader();
            reader.onload = () => resolve(reader.result.split(',')[1]);
            reader.onerror = reject;
            reader.readAsDataURL(blob);
        });
    }
    async function formFileDataToBody(formData) {
        const chunks = [];
        const encoder = new TextEncoder();
        const boundary = '----WebKitFormBoundary' + Math.random().toString(36).substring(2);
        for await (const [key, value] of formData.entries()) {
            chunks.push(encoder.encode(`--${boundary}\r\n`));
            chunks.push(encoder.encode(`Content-Disposition: form-data; name="${key}"`));


            if (value instanceof File) {
                chunks.push(encoder.encode(`; filename="${value.name}"\r\n`));
                chunks.push(encoder.encode(`Content-Type: ${value.type || 'application/octet-stream'}\r\n\r\n`));
                chunks.push(new Uint8Array(await value.arrayBuffer()));
            } else {
                chunks.push(encoder.encode('\r\n\r\n'));
            }
            chunks.push(encoder.encode('\r\n'));
        }

        chunks.push(encoder.encode(`--${boundary}--\r\n`));
        // 合并所有数据块
        const totalLength = chunks.reduce((sum, chunk) => sum + chunk.length, 0);
        const body = new Uint8Array(totalLength);
        let offset = 0;
        for (const chunk of chunks) {
            body.set(chunk, offset);
            offset += chunk.length;
        }
        return {
            body: arrayBufferToBase64(body.buffer),
            contentType: `multipart/form-data; boundary=${boundary}`
        };
    }

    function hasFile(formData) {
        for (const value of formData.values()) {
            if (value instanceof File) {
                return true;
            }
        }
        return false;
    }

    // hook XMLHttpRequest的方法
    var oldXHROpen = window.XMLHttpRequest.prototype.open;
    window.XMLHttpRequest.prototype.open = function () {
        this._url = arguments[1];
        this._method = arguments[0];

        if (this._method != "GET" && this._method != "HEAD") {
            // 给URL添加param，android_req_id
            var requestId = genRequestId();
            this._reqId = requestId;
            this._url = getUrlWithoutLarkProxyParam(this._url) + (this._url.indexOf('?') === -1 ? '?' : '&') + 'lark_app_proxy_req_id=' + encodeURIComponent(requestId);
            arguments[1] = this._url;
        }

        console.log('XMLHttpRequest open request', JSON.stringify(arguments));
        oldXHROpen.apply(this, arguments);
    };

    var oldXHRSend = window.XMLHttpRequest.prototype.send;
    window.XMLHttpRequest.prototype.send = function () {
        console.log('XMLHttpRequest send request', this._method, this._url, arguments[0]);
        var method = this._method.toUpperCase();
        if (method != "GET" && method != "HEAD") {
            console.log('XMLHttpRequest send request add body to', this._url, arguments[0]);
            // js中记录<requestId-body>关系，等待native过来查询
            convertBodyToBase64(arguments[0]).then(base64Body => {
                console.log('XMLHttpRequest send base64body', base64Body)
                insertRequestBody(this._reqId, base64Body);
            }).catch(console.error);
        }
        oldXHRSend.apply(this, arguments);
    };


    // hook fetch方法
    var oldFetch = window.fetch;
    window.fetch = function () {
        if (arguments[1] == null) {
            return oldFetch.apply(window, arguments);
        }
        console.log('Hook fetch: ', arguments[1].method, arguments[0]);
        if (arguments[1].method == null) {
            return oldFetch.apply(window, arguments);
        }
        var method = arguments[1].method.toUpperCase();
        if (method != "GET" && method != "HEAD") {
            console.log('Hook fetch add body to', arguments[1].method, arguments[1].body);
            //给URL添加param，android_req_id
            var requestId = genRequestId();
            var _url = arguments[0];
            arguments[0] = getUrlWithoutLarkProxyParam(_url) + (_url.indexOf('?') === -1 ? '?' : '&') + 'lark_app_proxy_req_id=' + encodeURIComponent(requestId);
            // js中记录<requestId-body>关系，等待native过来查询
            convertBodyToBase64(arguments[1].body).then(base64Body => {
                console.log('Hook fetch: ', arguments[1].method, arguments[0], base64Body);
                insertRequestBody(requestId, base64Body);
            }).catch(console.error);
        }
        return oldFetch.apply(window, arguments);
    };

    // 新增 MutationObserver 监听器
    function observeForms() {
        const observer = new MutationObserver((mutations) => {
            mutations.forEach(mutation => {
                if (mutation.addedNodes.length) {
                    Array.from(mutation.addedNodes).forEach(node => {
                        if (node.nodeName === 'FORM') {
                            addFormSubmitListener(node);
                        } else if (node.querySelectorAll) {
                            node.querySelectorAll('form').forEach(form => {
                                addFormSubmitListener(form);
                            });
                        }
                    });
                }
            });
        });

        observer.observe(document, {
            childList: true,
            subtree: true
        });
    }

    function addFormSubmitListener(form) {
        if (form.action != "" && form.action != null) {
            console.log("start foreach form", form.action);

            var originAction = form.action;
            if (originAction.indexOf('lark_app_proxy_req_id') == -1) {
                var requestId = genRequestId();
                var newAction = getUrlWithoutLarkProxyParam(originAction) + (originAction.indexOf('?') === -1 ? '?' : '&') + 'lark_app_proxy_req_id=' + encodeURIComponent(requestId);
                form.action = newAction;

                form.addEventListener("submit", function (event) {
                    console.log("Hook start form submit direct to: ", form.action);
                    if (form.action != "" && form.action != null) {
                        // 获取表单数据
                        const formData = new FormData(event.target);
                        console.log("form submit1: ", form.action);
                        console.log("form submit2: ", event.target);
                        console.log("form submit3: ", formData);
                        formDataToBase64(formData).then(base64Body => {
                            console.log("jackjack", base64Body);
                            insertRequestBody(requestId, base64Body);
                        })
                    }
                });
            }

        }
    }

    // 对页面上已有的form添加监听器
    document.addEventListener('DOMContentLoaded', function () {
        for (let i = 0; i < document.forms.length; i++) {
            console.log("start foreach forms");
            var form = document.forms[i];
            addFormSubmitListener(form);
        }
        observeForms();
        // 保存原始的submit方法
        const originalSubmit = HTMLFormElement.prototype.submit;
        // 重写表单的submit方法
        HTMLFormElement.prototype.submit = function () {

            // 创建FormData对象（此时append方法已被hook）
            const formData = new FormData(this);

            // 这里打印formData的所有数据
            console.group('FormData 所有字段:');
            for (let [key, value] of formData.entries()) {
                console.log(`%c${key}:`, 'font-weight: bold', value);
            }
            console.groupEnd();

            // 从 this.action 中提取 lark_app_proxy_req_id 的值
            let reqId = '';
            try {
                const url = new URL(this.action);
                reqId = url.searchParams.get('lark_app_proxy_req_id') || '';
                console.log('提取的 lark_app_proxy_req_id:', reqId);
            } catch (error) {
                console.error('解析 URL 时出错:', error);
            }
            if (reqId == '') {
                var originAction = this.action;
                reqId = genRequestId();
                console.log("genRequestId", reqId);
                var newAction = getUrlWithoutLarkProxyParam(originAction) + (originAction.indexOf('?') === -1 ? '?' : '&') + 'lark_app_proxy_req_id=' + encodeURIComponent(reqId);
                console.log("newAction", newAction);
                this.action = newAction;
            }

            formDataToBase64(formData).then(base64Body => {
                console.log("jackjack", base64Body);
                insertRequestBody(reqId, base64Body);
            })
            // 调用原始的submit方法继续提交
            originalSubmit.apply(this, arguments);
        };
    });

    function genRequestId() {
        return 'reqid_' + Date.now() + '_' + (Math.floor(Math.random() * 90000) + 10000);
    }
})();