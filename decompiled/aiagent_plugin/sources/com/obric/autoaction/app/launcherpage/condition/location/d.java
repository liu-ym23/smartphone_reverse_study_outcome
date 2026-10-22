package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import androidx.lifecycle.aj;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.memorydata.sdk.awareness.HomeCompanyAddressLearningSharedState;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.s;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.ak;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.ca;

/* JADX INFO: compiled from: ConditionEventLocationViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class d extends aj {
    private static final String TAG = "ConditionEventLocationViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23153a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.f f23154b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ca f23155c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final x<List<ConditionLocationItemData>> f23156d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ak<List<ConditionLocationItemData>> f23157e;
    private final x<ConditionLocationItemData> f;
    private final ak<ConditionLocationItemData> g;
    private final x<Map<Integer, Integer>> h;
    private final ak<Map<Integer, Integer>> i;
    private long j;

    /* JADX INFO: compiled from: ConditionEventLocationViewModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationViewModel.kt */
    @d.c.b.a.f(b = "ConditionEventLocationViewModel.kt", c = {64, 66, 68}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationViewModel$fetchUserLocation$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23158a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f23159b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d f23160c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f23161d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f23162e;

        b(d r3, Context r4, boolean r5, d.c.d<? super b> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23160c = r3;
            this.f23161d = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f23162e = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23160c, this.f23161d, this.f23162e, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r17) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23159b;
            if (r2 == 0) goto L12;
            if (r2 == 1) goto L11;
            if (r2 == 2) goto L10;
            if (r2 != 3) goto L9;
            d.o.a(r17);
        L34:
            return d.x.f38692a;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            List r3 = (List) ZeusTransformUtils.preCheckCast(this.f23158a, List.class, "com.obric.aiagent.plugin");
            d.o.a(r17);
        L30:
            x r5 = d.b(this.f23160c);
            d.c.d<? super d.x> r6 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23158a = null;
            this.f23159b = 3;
            if (r5.emit(r3, r6) != r1) goto L34;
            return r1;
        L11:
            d.o.a(r17);
            Object r4 = r17;
        L15:
            r3 = (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
            Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r3, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L17:
            if (r8.hasNext() == false) goto L24;
            Object r9 = r8.next();
            if (((ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r9, ConditionLocationItemData.class, "com.obric.aiagent.plugin")).getType() != 2) goto L21;
            boolean r10 = true;
        L22:
            if (r10 == false) goto L17;
        L25:
            ConditionLocationItemData r7 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r9, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
            if (r7 == null) goto L30;
            x r11 = d.c(this.f23160c);
            this.f23158a = r3;
            this.f23159b = 2;
            if (r11.emit(r7, this) != r1) goto L30;
            return r1;
        L21:
            r10 = false;
            goto L22
        L24:
            r9 = null;
            goto L25
        L12:
            d.o.a(r17);
            k r12 = d.a(this.f23160c);
            Context r13 = this.f23161d;
            boolean r14 = this.f23162e;
            d.c.d r15 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23159b = 1;
            r4 = k.a.a(r12, r13, r14, false, false, r15, 12, null);
            if (r4 != r1) goto L15;
            return r1;
        }
    }

    /* JADX INFO: compiled from: ConditionEventLocationViewModel.kt */
    @d.c.b.a.f(b = "ConditionEventLocationViewModel.kt", c = {77, 86}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationViewModel$getSearchLocation$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23163a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ d f23164b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f23165c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ String f23166d;

        c(d r3, Context r4, String r5, d.c.d<? super c> r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r8 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23164b = r3;
            this.f23165c = ZeusTransformUtils.wrapperContext(r7, "com.obric.aiagent.plugin");
            this.f23166d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23164b, this.f23165c, this.f23166d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r20) {
            Object r1 = d.c.a.b.a();
            int r2 = this.f23163a;
            if (r2 == 0) goto L10;
            if (r2 == 1) goto L9;
            if (r2 != 2) goto L8;
            d.o.a(r20);
        L27:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r20);
            Object r3 = r20;
        L13:
            n r4 = (n) ZeusTransformUtils.preCheckCast(((com.obric.autogui.common.d) ZeusTransformUtils.preCheckCast(r3, com.obric.autogui.common.d.class, "com.obric.aiagent.plugin")).a(), n.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L22;
            List<o> r5 = r4.a();
            if (r5 == null) goto L22;
            Iterable r6 = (Iterable) ZeusTransformUtils.preCheckCast(r5, Iterable.class, "com.obric.aiagent.plugin");
            Collection r7 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r6, 10)), Collection.class, "com.obric.aiagent.plugin");
            Iterator r8 = r6.iterator();
        L19:
            if (r8.hasNext() == false) goto L21;
            o r9 = (o) ZeusTransformUtils.preCheckCast(r8.next(), o.class, "com.obric.aiagent.plugin");
            r7.add(new ConditionLocationItemData(3, r9.a(), r9.b(), r9.c().a(), r9.c().b(), false, null, 96, null));
            goto L19
        L21:
            List r10 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
        L23:
            x r11 = d.b(this.f23164b);
            d.c.d<? super d.x> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23163a = 2;
            if (r11.emit(r10, r12) != r1) goto L27;
            return r1;
        L22:
            r10 = p.b();
            goto L23
        L10:
            d.o.a(r20);
            k r13 = d.a(this.f23164b);
            Context r14 = this.f23165c;
            String r15 = this.f23166d;
            d.c.d<? super com.obric.autogui.common.d<n>> r16 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23163a = 1;
            r3 = r13.a(r14, r15, r16);
            if (r3 != r1) goto L13;
            return r1;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.condition.location.d$d, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ConditionEventLocationViewModel.kt */
    @d.c.b.a.f(b = "ConditionEventLocationViewModel.kt", c = {105}, d = "saveFrequentLocation", e = "com.obric.autoaction.app.launcherpage.condition.location.ConditionEventLocationViewModel")
    static final class C0502d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23167a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f23168b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Object f23169c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        /* synthetic */ Object f23170d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ d f23171e;
        int f;

        C0502d(d r3, d.c.d<? super C0502d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23171e = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23170d = r3;
            this.f |= Integer.MIN_VALUE;
            return this.f23171e.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    static {
        f23153a = new a(null);
    }

    public static /* synthetic */ void lambda$U5SDgE2NCBH7ErRiqGuQaCMPCUk(d r0, Context r1, String r2, SharedValue r3) {
        a(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: lambda$u5Vq2M2-72EyPLsZFwX2TqkYckE, reason: not valid java name */
    public static /* synthetic */ ConditionLocationRepo m461lambda$u5Vq2M272EyPLsZFwX2TqkYckE() {
        return h();
    }

    public d() {
        this.f23154b = d.g.a($$Lambda$d$u5Vq2M272EyPLsZFwX2TqkYckE.INSTANCE);
        x<List<ConditionLocationItemData>> r0 = kotlinx.coroutines.b.am.a(p.b());
        this.f23156d = r0;
        this.f23157e = kotlinx.coroutines.b.j.a(r0);
        x<ConditionLocationItemData> r1 = kotlinx.coroutines.b.am.a(null);
        this.f = r1;
        this.g = kotlinx.coroutines.b.j.a(r1);
        x<Map<Integer, Integer>> r2 = kotlinx.coroutines.b.am.a(ao.b());
        this.h = r2;
        this.i = kotlinx.coroutines.b.j.a(r2);
    }

    public static final /* synthetic */ k a(d r0) {
        return r0.f();
    }

    public static final /* synthetic */ x b(d r0) {
        return r0.f23156d;
    }

    public static final /* synthetic */ x c(d r0) {
        return r0.f;
    }

    private final k f() {
        return (k) ZeusTransformUtils.preCheckCast(this.f23154b.b(), k.class, "com.obric.aiagent.plugin");
    }

    private static final ConditionLocationRepo h() {
        return new ConditionLocationRepo();
    }

    public final ak<List<ConditionLocationItemData>> b() {
        return this.f23157e;
    }

    public final ak<Map<Integer, Integer>> c() {
        return this.i;
    }

    public static /* synthetic */ void a(d r1, Context r2, boolean r3, boolean r4, int r5, Object r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if ((r5 & 2) == 0) goto L6;
        r3 = false;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = false;
    L8:
        r1.a(r7, r3, r4);
    }

    public final void a(Context r10, boolean r11, boolean r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r13, "context");
        ca r0 = this.f23155c;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        if (r12 == false) goto L7;
        this.f23156d.b(p.b());
        this.f.b(null);
    L7:
        this.f23155c = kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r13, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(Context r10, String r11) {
        Context r12 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, "context");
        d.h.b.o.e(r11, "searchText");
        ca r0 = this.f23155c;
        if (r0 == null) goto L5;
        ca.a.a(r0, null, 1, null);
    L5:
        this.f23155c = kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, r12, r11, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final Object a(ConditionLocationItemData r10, ConditionLocationItemData r11, d.c.d<? super Boolean> r12) {
        d.c.d r13 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r12, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r13, C0502d.class) == false) goto L7;
        C0502d r0 = (C0502d) ZeusTransformUtils.preCheckCast(r13, C0502d.class, "com.obric.aiagent.plugin");
        if ((r0.f & Integer.MIN_VALUE) == 0) goto L7;
        r0.f -= Integer.MIN_VALUE;
    L8:
        Object r14 = r0.f23170d;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r11 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r0.f23169c, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        r10 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r0.f23168b, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        d this = (d) ZeusTransformUtils.preCheckCast(r0.f23167a, d.class, "com.obric.aiagent.plugin");
        d.o.a(r14);
    L17:
        ConditionLocationItemData r4 = r10;
        ConditionLocationItemData r5 = r11;
        boolean r15 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        if (r15 == false) goto L21;
        this.f23156d.b(h.a(h.f23191a, (List) ZeusTransformUtils.preCheckCast(this.f23156d.c(), List.class, "com.obric.aiagent.plugin"), r4, r5, false, 8, null));
    L21:
        return d.c.b.a.b.a(r15);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r14);
        h r16 = h.f23191a;
        r0.f23167a = this;
        r0.f23168b = r10;
        r0.f23169c = r11;
        r0.f = 1;
        r14 = r16.a(r10, r11, r0);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new C0502d(this, r13);
        goto L8
    }

    public final void a(Context r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        this.h.b(g());
        if (this.j == 0) goto L5;
        return;
    L5:
        List r0 = p.b(new String[]{HomeCompanyAddressLearningSharedState.KEY_HOME_LEARNING_STATUS, HomeCompanyAddressLearningSharedState.KEY_COMPANY_LEARNING_STATUS});
        this.j = SharedState.INSTANCE.registerObserver(r0, new $$Lambda$d$U5SDgE2NCBH7ErRiqGuQaCMPCUk(this, r6));
    }

    private static final void a(d r8, Context r9, String r10, SharedValue r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        SharedValue r12 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r11, SharedValue.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "key");
        d.h.b.o.e(r12, "value");
        Loog.INSTANCE.i(TAG, "onSharedStateChanged key=" + r10 + ", value=" + r12.getValue());
        r8.h.b(r8.g());
        a(r8, r3, true, false, 4, null);
    }

    public final void e() {
        this.h.b(g());
    }

    private final Map<Integer, Integer> g() {
        return ao.a(new d.m[]{s.a(0, Integer.valueOf(SharedState.INSTANCE.getInt(HomeCompanyAddressLearningSharedState.KEY_HOME_LEARNING_STATUS, -1))), s.a(1, Integer.valueOf(SharedState.INSTANCE.getInt(HomeCompanyAddressLearningSharedState.KEY_COMPANY_LEARNING_STATUS, -1)))});
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        super.a();
        if (this.j == 0) goto L6;
        SharedState.INSTANCE.unregisterObserver(this.j);
        this.j = 0;
        return;
    }
}
