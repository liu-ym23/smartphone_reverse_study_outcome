package com.bytedance.android.shopping.prepurchase.arch.container.ability;

import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.google.gson.internal.LinkedTreeMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class ContainerTrackAbility implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<String> f180696a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<Function2<String, Map<String, ? extends Object>, Unit>> f180697b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f180698c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.intf.h f180699d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a f180700e;

    public final class a implements m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Map<String, ? extends Object> f180701a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, ? extends Object> f180702b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ ContainerTrackAbility f180703c;

        public a(ContainerTrackAbility r100) {
            this.f180703c = r100;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "actionName");
            if (this.f180703c.f180696a.contains(r100) == true) goto L5;
            return this;
        L5:
            return null;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m d(Map<String, ? extends Object> r100) {
            this.f180701a = r100;
            return this;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final m c(View r100, String r101, PageFinder r102) {
            Intrinsics.checkNotNullParameter(r101, "btmId");
            Map<String, Object> r103 = null;
            if (r102 != null) goto L6;
            if (r100 != null) goto L23;
        L22:
            return this;
        L23:
            r102 = PageFinder.via(r100);     // Catch: Exception -> L8
        L8:
            e = move-exception;
            ECExceptionMonitor.e(e);
            Map<String, Object> r104 = null;
        L11:
            if (r104 != null) goto L13;
        L16:
            boolean r105 = true;
        L18:
            if ((true ^ r105) == false) goto L20;
            r103 = r104;
        L20:
            if (r103 == null) goto L22;
            this.f180702b = r103;
            goto L22
        L13:
            if (r104.isEmpty() == true) goto L16;
            r105 = false;
        L6:
            r104 = BtmSDK.INSTANCE.createReportParams(r101, r102);     // Catch: Exception -> L8
            goto L11
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.m
        public final boolean a(String r100, boolean r101, String r102, PageFinder r103) {
            Intrinsics.checkNotNullParameter(r100, "actionName");
            if (r102 == null) goto L6;
            String r104 = r100 + r102;
            if (r104 == null) goto L6;
        L7:
            if (r101 == false) goto L9;
        L12:
            LinkedHashMap r105 = new LinkedHashMap();
            Map<String, ? extends Object> r106 = this.f180701a;
            if (r106 == null) goto L15;
            r105.putAll(r106);
        L15:
            Map<String, ? extends Object> r107 = this.f180702b;
            if (r107 == null) goto L19;
            r105.putAll(r107);
        L19:
            if (r105.get("btm") != null) goto L21;
        L23:
            this.f180703c.f180699d.q(r100, r103, r105);
            this.f180703c.f180696a.add(r104);
            Iterator<T> r108 = this.f180703c.f180697b.iterator();
        L25:
            if (r108.hasNext() == false) goto L27;
            ((Function2) r108.next()).invoke(r100, r105);
            goto L25
        L27:
            return true;
        L21:
            if ((!Intrinsics.areEqual(r105.get("btm"), "")) == false) goto L23;
            r105.put("saas_btm_id", r105.get("btm"));
            goto L23
        L9:
            if (this.f180703c.f180696a.contains(r104) == false) goto L12;
            return false;
        L6:
            r104 = r100;
            goto L7
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final PageFinder getPageFinder() {
        return (PageFinder) this.f180698c.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final a m() {
        return new a(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final Map<String, Object> u1() {
        return this.f180699d.getEventParams();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void appendEventParams(Pair<String, ? extends Object>... r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        this.f180699d.appendEventParams((Pair[]) Arrays.copyOf(r100, r100.length));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void y1(Function2<? super String, ? super Map<String, ? extends Object>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "interceptor");
        ((ArrayList) this.f180697b).add(r100);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void appendEventParams(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "paramsMap");
        this.f180699d.p((LinkedTreeMap) r100);
    }

    public ContainerTrackAbility(com.bytedance.android.shopping.prepurchase.arch.container.intf.h r100, com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.a r101) {
        Intrinsics.checkNotNullParameter(r100, "eventTrackerService");
        Intrinsics.checkNotNullParameter(r101, "containerDelegate");
        this.f180699d = r100;
        this.f180700e = r101;
        this.f180696a = new LinkedHashSet();
        this.f180697b = new ArrayList();
        this.f180698c = LazyKt.lazy(new ContainerTrackAbility$_pageFinder$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.i
    public final void appendEventParamToEntranceInfo(String r100, String r101) {
        Intrinsics.checkNotNullParameter(com.bytedance.android.ec.core.event.a.KEY_SHARE_WITH_HEAD, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f180699d.o(r101);
    }
}
