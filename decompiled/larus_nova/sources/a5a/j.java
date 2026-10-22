package a5a;

import android.webkit.WebChromeClient;
import android.webkit.WebView;

/* JADX INFO: loaded from: classes32.dex */
public final class j extends WebChromeClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1881a;

    public j(h r100) {
        this.f1881a = r100;
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTitle(WebView r100, String r101) {
        super.onReceivedTitle(r100, r101);
        h r102 = this.f1881a;
        int r103 = h.f1873c;
        r102.a("if (!window.logbox) {  (function () {    var id = 0, callbacks = {}, eventListeners = {};    var nativeBridge = window.nativeBridge || window.webkit.messageHandlers.nativeBridge;    window.logbox = {      call: function(bridgeName, callback, data) {        var thisId = id++;        callbacks[thisId] = callback;        nativeBridge.postMessage(JSON.stringify({          bridgeName: bridgeName,          data: data ? JSON.stringify(data) : {},          callbackId: thisId        }));      },      on: function(event, handler) {        eventListeners[event] = handler;      },      sendResult: function(msg) {        var callbackId = msg.callbackId;        if (callbacks[callbackId]) {          callbacks[callbackId](msg.data);        }      },      sendEvent: function(msg) {        if (eventListeners[msg.event]) {          eventListeners[msg.event](msg.data);        }      }    };  })();  setTimeout(function(){document.dispatchEvent(new Event('LogBoxReady'))}, 0);};");
    }
}
