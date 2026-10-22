package com.bytedance.android.shopping.skubuy.module;

import com.bytedance.android.shopping.abscontainer.common_biz.constant.WidgetName;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import u33.a;
import v43.b;

/* JADX INFO: loaded from: classes13.dex */
public final class TopBannerModule<STATE extends v43.b, PROPS extends u33.a> extends s33.b<STATE, PROPS> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f183125b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Function1<? super Boolean, Unit> f183126c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k43.c f183127d;

    @Override // s33.b
    public final void A() {
        if (this.f183127d == null) goto L10;
        Function1<? super Boolean, Unit> r100 = this.f183126c;
        if (r100 == null) goto L11;
        Map<Function1<Boolean, Unit>, ul.c> r101 = ai3.f.f3734a;
        Intrinsics.checkNotNullParameter(r100, "callback");
        Map<Function1<Boolean, Unit>, ul.c> r102 = ai3.f.f3734a;
        ul.c r103 = (ul.c) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L12;
        ul.b.a(r103);
        ul.c r104 = r102.remove(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // s33.b
    public final void y() {
        n43.c r100 = this.f540457a.f507251e.f527570g.get(WidgetName.TOP.getValue());
        if ((r100 instanceof k43.c) == true) goto L5;
        r100 = null;
    L5:
        k43.c r101 = (k43.c) r100;
        if (r101 != null) goto L8;
        return;
    L8:
        this.f183127d = r101;
        Function1<Boolean, Unit> r102 = new TopBannerModule$pageDidMount$1(this);
        this.f183126c = r102;
        Map<Function1<Boolean, Unit>, ul.c> r103 = ai3.f.f3734a;
        Intrinsics.checkNotNullParameter(r102, "callback");
        ai3.e r104 = new ai3.e(r102);
        ai3.f.f3734a.put(r102, r104);
        ul.b.b(r104);
    }

    @Override // s33.b
    public final String j() {
        return this.f183125b;
    }

    public TopBannerModule(l33.b<STATE, PROPS> r100) {
        Intrinsics.checkNotNullParameter(r100, "containerContext");
        super(r100);
        this.f183125b = "TopStrandModule";
    }
}
