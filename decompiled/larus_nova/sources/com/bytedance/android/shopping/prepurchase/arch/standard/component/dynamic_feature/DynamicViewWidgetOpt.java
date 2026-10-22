package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes13.dex */
public final class DynamicViewWidgetOpt implements com.bytedance.android.shopping.prepurchase.arch.container.ability.h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public e f180917a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f180918b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f180919c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public List<? extends com.bytedance.android.ecom.arch.slice.g> f180920d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f180921e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final l f180922f;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ DynamicViewWidgetOpt f180923c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ List f180924d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Map f180925e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.ability.c f180926f;

        @Override // java.lang.Runnable
        public final void run() {
            this.f180923c.e(this.f180924d, this.f180925e, this.f180926f);
        }

        public a(DynamicViewWidgetOpt r100, List r101, Map r102, com.bytedance.android.shopping.prepurchase.arch.container.ability.c r103) {
            this.f180923c = r100;
            this.f180924d = r101;
            this.f180925e = r102;
            this.f180926f = r103;
            super("bind_lynx");
        }
    }

    public final SliceReuseHelper g() {
        return (SliceReuseHelper) this.f180921e.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final ti.l c() {
        Intrinsics.checkNotNullParameter("std_deal_button", "sliceId");
        g r100 = g().b().get("std_deal_button");
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f180944d;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final View b() {
        return g().c();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final void release() {
        g().d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final View f(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sliceKey");
        e r101 = this.f180917a;
        if (r101 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
    L6:
        return r101.c(this.f180918b, r100);
    }

    public DynamicViewWidgetOpt(Context r100, l r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "prefAbility");
        this.f180922f = r101;
        this.f180918b = new c(r100);
        this.f180921e = LazyKt.lazy(new DynamicViewWidgetOpt$helper$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final Boolean a(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return Boolean.valueOf(g().e(r100, r101));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final void d(String r100, Map<String, ? extends Object> r101) {
        g().f(this.f180920d, r100, r101);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final void e(List<? extends com.bytedance.android.ecom.arch.slice.g> r100, Map<String, ? extends Object> r101, com.bytedance.android.shopping.prepurchase.arch.container.ability.c r110) {
        Intrinsics.checkNotNullParameter(r100, "slices");
        Intrinsics.checkNotNullParameter(r110, "option");
        this.f180920d = r100;
        if (r110.f180706a == true) goto L5;
    L21:
        g().a(r100, r101);
        if (this.f180919c == true) goto L31;
        this.f180919c = true;
        this.f180922f.e1(new d(this));
        return;
    L31:
        return;
    L5:
        if (this.f180922f.e0() == true) goto L21;
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L8:
        if (r103.hasNext() == false) goto L19;
        Object r104 = r103.next();
        com.bytedance.android.ecom.arch.slice.g r105 = (com.bytedance.android.ecom.arch.slice.g) r104;
        if ((!Intrinsics.areEqual(r105.getSliceType(), "Lynx")) == false) goto L12;
    L15:
        boolean r106 = true;
    L16:
        if (r106 == false) goto L8;
        r102.add(r104);
        goto L8
    L12:
        if (Intrinsics.areEqual(r105.getSliceId(), "std_deal_button") == true) goto L15;
        r106 = false;
        goto L16
    L19:
        if (r100.size() == r102.size()) goto L21;
        this.f180922f.n0(new a(this, r100, r101, r110));
        r100 = r102;
        goto L21
    }
}
