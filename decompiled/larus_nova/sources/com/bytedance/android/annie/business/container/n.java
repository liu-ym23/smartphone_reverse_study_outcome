package com.bytedance.android.annie.business.container;

import android.graphics.Bitmap;
import android.os.Looper;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.jvm.internal.Intrinsics;
import y36.p;

/* JADX INFO: loaded from: classes43.dex */
public final class n extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f38999a;

    public n(i r100) {
        this.f38999a = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView r100, String r101) {
        super.onPageFinished(r100, r101);
        this.f38999a.f38971b.hideLoading();
        com.bytedance.android.annie.business.ability.schema.model.b r102 = this.f38999a.f38984o;
        ia.h r103 = null;
        if (r102 == null) goto L7;
        p r104 = r102.f38880h;
        if (r104 == null) goto L7;
        String r105 = (String) r104.f565862b;
    L8:
        if (r105 != null) goto L17;
        if (r100 == null) goto L17;
        String r106 = r100.getTitle();
        if (r106 == null) goto L17;
        ia.c r107 = this.f38999a.f38971b;
        if ((r107 instanceof ia.h) == false) goto L15;
        r103 = (ia.h) r107;
    L15:
        if (r103 == null) goto L17;
        r103.setTitle(r106);
    L17:
        i r108 = this.f38999a;
        if (r108.f38979j == true) goto L20;
    L26:
        i r109 = this.f38999a;
        ia.c.a.a(r109.f38971b, true);
        w8.d r110 = r109.f38973d;
        if (r110 == null) goto L29;
        r110.a(true);
    L29:
        this.f38999a.f38971b.sendEvent(new m(true));
        if (this.f38999a.f38981l == false) goto L34;
        if (r100 == null) goto L33;
        r100.clearHistory();
    L33:
        this.f38999a.f38981l = false;
    L34:
        if (r100 == null) goto L42;
        i r111 = this.f38999a;
        r111.getClass();
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()) == false) goto L38;
        r111.f(r100);
        return;
    L38:
        ViewGroup r112 = r111.f38985p;
        if (r112 == null) goto L44;
        r112.post(new k(r111, r100));
        return;
    L44:
        return;
    L42:
        return;
    L20:
        if (r108.f38980k.booleanValue() == true) goto L26;
        i r113 = this.f38999a;
        if (Intrinsics.areEqual(r113.f38971b.getViewType(), "page") == false) goto L26;
        ViewGroup r114 = r113.f38985p;
        if (r114 == null) goto L26;
        r114.setBackgroundColor(ColorProtector.parseColor("white"));
    L7:
        r105 = null;
        goto L8
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView r100, String r101, Bitmap r102) {
        super.onPageStarted(r100, r101, r102);
        if (this.f38999a.f38979j == false) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r101, "about:blank") == true) goto L11;
        ViewGroup r103 = this.f38999a.f38985p;
        if (r103 == null) goto L12;
        r103.setBackgroundColor(ColorProtector.parseColor("#00000000"));
        return;
    L12:
        return;
    }
}
