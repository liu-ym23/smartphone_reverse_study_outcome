package a5a;

import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* JADX INFO: loaded from: classes32.dex */
public final class i extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ h f1880a;

    public i(h r100) {
        this.f1880a = r100;
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        h r102 = this.f1880a;
        int r103 = h.f1873c;
        r102.a("if (!window.logbox) {  (function () {    var id = 0, callbacks = {}, eventListeners = {};    var nativeBridge = window.nativeBridge || window.webkit.messageHandlers.nativeBridge;    window.logbox = {      call: function(bridgeName, callback, data) {        var thisId = id++;        callbacks[thisId] = callback;        nativeBridge.postMessage(JSON.stringify({          bridgeName: bridgeName,          data: data ? JSON.stringify(data) : {},          callbackId: thisId        }));      },      on: function(event, handler) {        eventListeners[event] = handler;      },      sendResult: function(msg) {        var callbackId = msg.callbackId;        if (callbacks[callbackId]) {          callbacks[callbackId](msg.data);        }      },      sendEvent: function(msg) {        if (eventListeners[msg.event]) {          eventListeners[msg.event](msg.data);        }      }    };  })();  setTimeout(function(){document.dispatchEvent(new Event('LogBoxReady'))}, 0);};");
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        ((b) this.f1880a).f1860g.booleanValue();
    }

    @Override // android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        ((b) this.f1880a).f1860g.booleanValue();
    }
}
