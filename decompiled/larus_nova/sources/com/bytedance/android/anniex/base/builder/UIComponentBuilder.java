package com.bytedance.android.anniex.base.builder;

import android.content.Context;
import android.os.Bundle;
import android.webkit.WebViewClient;
import com.lynx.tasm.q1;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import w26.e;
import w26.g;

/* JADX INFO: loaded from: classes43.dex */
public class UIComponentBuilder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f40258a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f40259b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Bundle f40260c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f40261d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, Object> f40262e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.bytedance.android.anniex.base.lifecycle.a f40263f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public WebViewClient f40264g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q1 f40265h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f40266i;

    public UIComponentBuilder() {
        this.f40259b = "default_bid";
        this.f40260c = new Bundle();
        this.f40261d = LazyKt.lazy(new UIComponentBuilder$contextProviderFactory$2(this));
        this.f40262e = new LinkedHashMap();
    }

    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "bid");
        this.f40259b = r100;
        Map<String, Map<Class<?>, Object>> r101 = x26.a.f562251a;
        g r102 = (g) x26.a.a(g.class);
        if (r102 == null) goto L9;
        e r103 = (e) r102.n0(e.class);
        if (r103 == null) goto L9;
        Boolean r104 = r103.G();
        if (r104 == null) goto L9;
        boolean r105 = r104.booleanValue();
    L10:
        if (r105 == false) goto L13;
        this.f40260c.putString("bundle_annie_x_bid", r100);
        return;
    L13:
        return;
    L9:
        r105 = true;
        goto L10
    }

    public final void b(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        this.f40260c.putAll(r100);
    }

    public final <T> void c(Class<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "clazz");
        ((m16.b) this.f40261d.getValue()).g(r100, r101);
    }
}
