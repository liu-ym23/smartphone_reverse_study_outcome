package com.bytedance.android.anniex.monitor.salamander;

import android.os.Build;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import b36.l;
import b36.q;
import com.bytedance.salamander.anniex.i7;
import com.ss.android.lark.camera_export.CameraParam;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class h extends q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f41022a;

    public h(String r100) {
        this.f41022a = r100;
    }

    @Override // b36.q
    public final boolean a(WebView r100, l r101) {
        SLMonitorCompat r102 = SLMonitorCompat.f41001a;
        r102.getClass();
        if (SLMonitorCompat.f41002b == true) goto L5;
        super.a(r100, r101);
        throw null;
    L5:
        if (Build.VERSION.SDK_INT < 26) goto L18;
        String r103 = this.f41022a;
        if (r103 == null) goto L18;
        i7 r104 = new i7();
        r104.f268125a = -1;
        if (r101 == null) goto L13;
        boolean r105 = true;
        if (r101.a() != true) goto L13;
    L14:
        if (r105 == false) goto L16;
        String r106 = "crash";
    L17:
        String r107 = "cause by ".concat(r106);
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r104.f268126b = r107;
        String r108 = SLMonitorCompat.NativeErrorScene.WebProcessTerminate.getValue();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r104.f268127c = r108;
        Unit r109 = Unit.INSTANCE;
        r102.getClass();
        SLMonitorCompat.o(r103, r104);
        goto L18
    L16:
        r106 = CameraParam.TYPE_SYSTEM_CAMERA;
    L13:
        r105 = false;
    L18:
        super.a(r100, r101);
        throw null;
    }

    @Override // b36.q, android.webkit.WebViewClient
    public final void onReceivedError(WebView r100, WebResourceRequest r101, WebResourceError r102) {
        super.onReceivedError(r100, r101, r102);
        SLMonitorCompat r103 = SLMonitorCompat.f41001a;
        r103.getClass();
        if (SLMonitorCompat.f41002b == true) goto L6;
        return;
    L6:
        if (Build.VERSION.SDK_INT < 23) goto L20;
        if (r101 == null) goto L11;
        boolean r104 = true;
        if (r101.isForMainFrame() != true) goto L11;
    L12:
        if (r104 == false) goto L21;
        String r105 = this.f41022a;
        if (r105 == null) goto L22;
        i7 r106 = new i7();
        if (r102 == null) goto L18;
        r106.f268125a = r102.getErrorCode();
        String r107 = r102.getDescription().toString();
        Intrinsics.checkNotNullParameter(r107, "<set-?>");
        r106.f268126b = r107;
        String r108 = SLMonitorCompat.NativeErrorScene.WebError.getValue();
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r106.f268127c = r108;
    L18:
        Unit r109 = Unit.INSTANCE;
        r103.getClass();
        SLMonitorCompat.o(r105, r106);
        return;
    L22:
        return;
    L21:
        return;
    L11:
        r104 = false;
        goto L12
    }

    @Override // b36.q, android.webkit.WebViewClient
    public final void onReceivedHttpError(WebView r100, WebResourceRequest r101, WebResourceResponse r102) {
        super.onReceivedHttpError(r100, r101, r102);
        SLMonitorCompat r103 = SLMonitorCompat.f41001a;
        r103.getClass();
        if (SLMonitorCompat.f41002b == true) goto L5;
        return;
    L5:
        int r104 = 0;
        if (r101 == null) goto L10;
        boolean r105 = true;
        if (r101.isForMainFrame() != true) goto L10;
    L11:
        if (r105 == false) goto L25;
        String r106 = this.f41022a;
        if (r106 == null) goto L26;
        i7 r107 = new i7();
        if (r102 == null) goto L17;
        r104 = r102.getStatusCode();
    L17:
        r107.f268125a = r104;
        if (r102 == null) goto L20;
        String r108 = r102.getReasonPhrase();
    L21:
        if (r108 != null) goto L23;
        r108 = "";
    L23:
        Intrinsics.checkNotNullParameter(r108, "<set-?>");
        r107.f268126b = r108;
        String r109 = SLMonitorCompat.NativeErrorScene.WebError.getValue();
        Intrinsics.checkNotNullParameter(r109, "<set-?>");
        r107.f268127c = r109;
        Unit r110 = Unit.INSTANCE;
        r103.getClass();
        SLMonitorCompat.o(r106, r107);
        return;
    L20:
        r108 = null;
        goto L21
    L26:
        return;
    L25:
        return;
    L10:
        r105 = false;
        goto L11
    }
}
