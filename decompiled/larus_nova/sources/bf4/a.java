package bf4;

import android.graphics.Bitmap;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import b36.e;
import c26.c;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import f06.b;
import f06.d;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public class a extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f18819b;

    @Override // b36.j, android.webkit.WebChromeClient
    public final Bitmap getDefaultVideoPoster() {
        return this.f18819b.getDefaultVideoPoster();
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final View getVideoLoadingProgressView() {
        return this.f18819b.getVideoLoadingProgressView();
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final void onGeolocationPermissionsHidePrompt() {
        this.f18819b.onGeolocationPermissionsHidePrompt();
    }

    @Override // android.webkit.WebChromeClient
    public final void onHideCustomView() {
        this.f18819b.onHideCustomView();
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onJsTimeout() {
        return this.f18819b.onJsTimeout();
    }

    public a(c r100) {
        Intrinsics.checkNotNullParameter(r100, "webChromeClient");
        this.f18819b = r100;
    }

    @Override // c26.c
    public final void f(e r100) {
        this.f18819b.f(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void getVisitedHistory(ValueCallback<String[]> r100) {
        this.f18819b.getVisitedHistory(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onCloseWindow(WebView r100) {
        this.f18819b.onCloseWindow(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage r100) {
        return this.f18819b.onConsoleMessage(r100);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final void onPermissionRequest(PermissionRequest r100) {
        this.f18819b.onPermissionRequest(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onPermissionRequestCanceled(PermissionRequest r100) {
        this.f18819b.onPermissionRequestCanceled(r100);
    }

    @Override // android.webkit.WebChromeClient
    public final void onRequestFocus(WebView r100) {
        this.f18819b.onRequestFocus(r100);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final void onGeolocationPermissionsShowPrompt(String r210, GeolocationPermissions.Callback r211) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r210, r211};
        b r110 = new b();
        g06.a r102 = ApiHookConfig.f245611b.get(100003);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r111 = r103;
        int r112 = r111.length;
        int r104 = 0;
    L8:
        if (r104 >= r112) goto L15;
        f06.a r105 = r111[r104];
        int r113 = r104;
        int r114 = r112;
        f06.a[] r115 = r111;
        d r106 = r105.preInvoke(100003, "com/bytedance/caijing/sdk/infra/base/impl/container/bidcommon/BulletWebChromeClientProxy", "onGeolocationPermissionsShowPrompt", this, r101, "void", r110);     // Catch: Exception -> L21
        if (r106.f474982a == true) goto L17;
        r100.add(r105);     // Catch: Exception -> L21
    L17:
        if (r106.f474982a == false) goto L19;
        return;
    L19:
        this.f18819b.onGeolocationPermissionsShowPrompt(r210, r211);
        return;
    L14:
        r104 = r113 + 1;
        r112 = r114;
        r111 = r115;
        goto L8
    L15:
        r106 = new d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public final void onProgressChanged(WebView r100, int r101) {
        this.f18819b.onProgressChanged(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedIcon(WebView r100, Bitmap r101) {
        this.f18819b.onReceivedIcon(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public void onReceivedTitle(WebView r100, String r101) {
        this.f18819b.onReceivedTitle(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onShowCustomView(View r100, WebChromeClient.CustomViewCallback r101) {
        this.f18819b.onShowCustomView(r100, r101);
    }

    @Override // android.webkit.WebChromeClient
    public final void onReceivedTouchIconUrl(WebView r100, String r101, boolean r102) {
        this.f18819b.onReceivedTouchIconUrl(r100, r101, r102);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onCreateWindow(WebView r100, boolean r101, boolean r102, Message r103) {
        return this.f18819b.onCreateWindow(r100, r101, r102, r103);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        return this.f18819b.onJsAlert(r100, r101, r102, r103);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        return this.f18819b.onJsBeforeUnload(r100, r101, r102, r103);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        return this.f18819b.onJsConfirm(r100, r101, r102, r103);
    }

    @Override // b36.j, android.webkit.WebChromeClient
    public final boolean onJsPrompt(WebView r100, String r101, String r102, String r110, JsPromptResult r111) {
        return this.f18819b.onJsPrompt(r100, r101, r102, r110, r111);
    }
}
