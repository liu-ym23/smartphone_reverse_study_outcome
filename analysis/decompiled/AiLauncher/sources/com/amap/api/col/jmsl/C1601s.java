package com.amap.api.col.jmsl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import com.amap.api.maps.IAMapWebView;

/* renamed from: com.amap.api.col.jmsl.s, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C1601s {

    /* renamed from: a, reason: collision with root package name */
    public InterfaceC1552f1 f16862a;

    public C1601s(Context context, IAMapWebView iAMapWebView) {
        a(context, null, iAMapWebView);
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void a(Context context, AttributeSet attributeSet, IAMapWebView iAMapWebView) {
        C1570k.v("amap_3dmap_rendertime");
        C1570k.v("amap_3dmap_launchtime");
        this.f16862a = new N0(iAMapWebView, context);
    }
}
