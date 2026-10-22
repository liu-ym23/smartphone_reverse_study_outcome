package b36;

import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.webkit.GeolocationPermissions;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.ies.bullet.service.base.YieldError;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class j extends WebChromeClient {
    public void c(ValueCallback<Uri> r100) {
        Intrinsics.checkNotNullParameter(r100, "uploadMsg");
    }

    public void d(ValueCallback<Uri> r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uploadMsg");
        Intrinsics.checkNotNullParameter(r101, "acceptType");
    }

    public void e(ValueCallback<Uri> r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "uploadMsg");
        Intrinsics.checkNotNullParameter(r101, "acceptType");
        Intrinsics.checkNotNullParameter(r102, "capture");
    }

    @Override // android.webkit.WebChromeClient
    public Bitmap getDefaultVideoPoster() {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public View getVideoLoadingProgressView() {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsHidePrompt() {
        throw new YieldError("An operation is not implemented");
    }

    public j() {
    }

    public void a(m r100) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public void onPermissionRequest(PermissionRequest r100) {
        if (r100 == null) goto L4;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        m r101 = new m(r100);
    L5:
        a(r101);
        return;
    L4:
        r101 = null;
        goto L5
    }

    @Override // android.webkit.WebChromeClient
    public void onGeolocationPermissionsShowPrompt(String r110, GeolocationPermissions.Callback r210) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r110, r210};
        f06.b r111 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(100003);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r112 = r103;
        int r104 = r112.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r112[r105];
        int r113 = r105;
        int r114 = r104;
        f06.d r107 = r106.preInvoke(100003, "com/bytedance/ies/bullet/service/base/web/WebChromeClientDelegate", "onGeolocationPermissionsShowPrompt", this, r101, "void", r111);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L20;
        return;
    L20:
        throw new YieldError("An operation is not implemented");
    L14:
        r105 = r113 + 1;
        r104 = r114;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    public boolean b(WebView r100, ValueCallback r101, n r102) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onShowFileChooser(WebView r100, ValueCallback<Uri[]> r101, WebChromeClient.FileChooserParams r102) {
        if (r102 == null) goto L4;
        Intrinsics.checkNotNullParameter(r102, "<this>");
        n r103 = new n(r102);
    L6:
        return b(r100, r101, r103);
    L4:
        r103 = null;
        goto L6
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsAlert(WebView r100, String r101, String r102, JsResult r103) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsBeforeUnload(WebView r100, String r101, String r102, JsResult r103) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsConfirm(WebView r100, String r101, String r102, JsResult r103) {
        throw new YieldError("An operation is not implemented");
    }

    @Override // android.webkit.WebChromeClient
    public boolean onJsPrompt(WebView r100, String r101, String r102, String r103, JsPromptResult r104) {
        throw new YieldError("An operation is not implemented");
    }
}
