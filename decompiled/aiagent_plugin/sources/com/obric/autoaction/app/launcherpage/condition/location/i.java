package com.obric.autoaction.app.launcherpage.condition.location;

import android.content.Context;
import androidx.lifecycle.aj;
import com.obric.aiagent.sharedstate.SharedState;
import com.obric.aiagent.sharedstate.model.SharedValue;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
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

/* JADX INFO: compiled from: FrequentLocationViewModel.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i extends aj {
    private static final String TAG = "FrequentLocationViewModel";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23199a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.f f23200b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<List<ConditionLocationItemData>> f23201c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ak<List<ConditionLocationItemData>> f23202d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final x<Boolean> f23203e;
    private final ak<Boolean> f;
    private final x<Map<Integer, Integer>> g;
    private final ak<Map<Integer, Integer>> h;
    private long i;

    /* JADX INFO: compiled from: FrequentLocationViewModel.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: FrequentLocationViewModel.kt */
    @d.c.b.a.f(b = "FrequentLocationViewModel.kt", c = {63, ITaskManager.Stub.TRANSACTION_tryActiveAgent}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationViewModel$fetchFrequentLocations$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ i f23205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Context f23206c;

        b(i r3, Context r4, d.c.d<? super b> r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23205b = r3;
            this.f23206c = ZeusTransformUtils.wrapperContext(r6, "com.obric.aiagent.plugin");
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23205b, this.f23206c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r12) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23204a;
            if (r1 == 0) goto L10;
            if (r1 == 1) goto L9;
            if (r1 != 2) goto L8;
            d.o.a(r12);
        L29:
            return d.x.f38692a;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            d.o.a(r12);
        L13:
            Iterable r13 = (Iterable) ZeusTransformUtils.preCheckCast(r12, Iterable.class, "com.obric.aiagent.plugin");
            Collection r2 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(), Collection.class, "com.obric.aiagent.plugin");
            Iterator r14 = r13.iterator();
        L15:
            if (r14.hasNext() == false) goto L25;
            Object r5 = r14.next();
            ConditionLocationItemData r6 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r5, ConditionLocationItemData.class, "com.obric.aiagent.plugin");
            if (r6.getType() != 0) goto L19;
        L22:
            boolean r7 = true;
        L23:
            if (r7 == false) goto L15;
            r2.add(r5);
            goto L15
        L19:
            if (r6.getType() == 1) goto L22;
            r7 = false;
            goto L23
        L25:
            List r15 = (List) ZeusTransformUtils.preCheckCast(r2, List.class, "com.obric.aiagent.plugin");
            x r3 = i.b(this.f23205b);
            d.c.d<? super d.x> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23204a = 2;
            if (r3.emit(r15, r4) != r0) goto L29;
            return r0;
        L10:
            d.o.a(r12);
            k r8 = i.a(this.f23205b);
            Context r9 = this.f23206c;
            d.c.d<? super List<ConditionLocationItemData>> r10 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23204a = 1;
            r12 = r8.a(r9, true, false, true, r10);
            if (r12 != r0) goto L13;
            return r0;
        }
    }

    /* JADX INFO: compiled from: FrequentLocationViewModel.kt */
    @d.c.b.a.f(b = "FrequentLocationViewModel.kt", c = {92}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationViewModel$saveFrequentLocation$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ ConditionLocationItemData f23208b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionLocationItemData f23209c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ i f23210d;

        c(ConditionLocationItemData r3, ConditionLocationItemData r4, i r5, d.c.d<? super c> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23208b = r3;
            this.f23209c = r4;
            this.f23210d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23208b, this.f23209c, this.f23210d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23207a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L12:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r7, Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L15;
            i.b(this.f23210d).b(h.f23191a.a((List) ZeusTransformUtils.preCheckCast(i.b(this.f23210d).c(), List.class, "com.obric.aiagent.plugin"), this.f23208b, this.f23209c, true));
        L15:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            h r8 = h.f23191a;
            ConditionLocationItemData r2 = this.f23208b;
            ConditionLocationItemData r4 = this.f23209c;
            d.c.d<? super Boolean> r5 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23207a = 1;
            r7 = r8.a(r2, r4, r5);
            if (r7 != r0) goto L12;
            return r0;
        }
    }

    static {
        f23199a = new a(null);
    }

    /* JADX INFO: renamed from: lambda$MPWG-muAB5IRHKHZ2wvXE6RuwT0, reason: not valid java name */
    public static /* synthetic */ ConditionLocationRepo m463lambda$MPWGmuAB5IRHKHZ2wvXE6RuwT0() {
        return i();
    }

    /* JADX INFO: renamed from: lambda$bCvbVf-N5EuVl_teWsMg4kYw81o, reason: not valid java name */
    public static /* synthetic */ void m464lambda$bCvbVfN5EuVl_teWsMg4kYw81o(i r0, Context r1, String r2, SharedValue r3) {
        a(r0, r1, r2, r3);
    }

    public i() {
        this.f23200b = d.g.a($$Lambda$i$MPWGmuAB5IRHKHZ2wvXE6RuwT0.INSTANCE);
        x<List<ConditionLocationItemData>> r0 = kotlinx.coroutines.b.am.a(p.b());
        this.f23201c = r0;
        this.f23202d = kotlinx.coroutines.b.j.a(r0);
        x<Boolean> r1 = kotlinx.coroutines.b.am.a(false);
        this.f23203e = r1;
        this.f = kotlinx.coroutines.b.j.a(r1);
        x<Map<Integer, Integer>> r2 = kotlinx.coroutines.b.am.a(ao.b());
        this.g = r2;
        this.h = kotlinx.coroutines.b.j.a(r2);
    }

    public static final /* synthetic */ k a(i r0) {
        return r0.f();
    }

    public static final /* synthetic */ x b(i r0) {
        return r0.f23201c;
    }

    private final k f() {
        return (k) ZeusTransformUtils.preCheckCast(this.f23200b.b(), k.class, "com.obric.aiagent.plugin");
    }

    private static final ConditionLocationRepo i() {
        return new ConditionLocationRepo();
    }

    public final ak<List<ConditionLocationItemData>> b() {
        return this.f23202d;
    }

    public final ak<Boolean> c() {
        return this.f;
    }

    public final ak<Map<Integer, Integer>> e() {
        return this.h;
    }

    public final void a(Context r9) {
        Context r10 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r10, "context");
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, r10, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(ConditionLocationItemData r9, ConditionLocationItemData r10) {
        d.h.b.o.e(r9, "editingItem");
        d.h.b.o.e(r10, "selected");
        kotlinx.coroutines.i.a(androidx.lifecycle.ak.a((aj) ZeusTransformUtils.preCheckCast(this, aj.class, "com.obric.aiagent.plugin")), null, null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(r9, r10, this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void b(Context r5) {
        final Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "context");
        this.f23203e.b(Boolean.valueOf(g()));
        this.g.b(h());
        if (this.i == 0) goto L5;
        return;
    L5:
        List r0 = p.b(new String[]{HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE, HomeCompanyAddressLearningSharedState.KEY_HOME_LEARNING_STATUS, HomeCompanyAddressLearningSharedState.KEY_COMPANY_LEARNING_STATUS});
        this.i = SharedState.INSTANCE.registerObserver(r0, new $$Lambda$i$bCvbVfN5EuVl_teWsMg4kYw81o(this, r6));
    }

    private static final void a(i r4, Context r5, String r6, SharedValue r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        SharedValue r9 = (SharedValue) ZeusTransformUtils.wrapperContextForParams(r7, SharedValue.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r6, "key");
        d.h.b.o.e(r9, "value");
        Loog.INSTANCE.i(TAG, "onSharedStateChanged key=" + r6 + ", value=" + r9.getValue());
        int r0 = r6.hashCode();
        if (r0 == (-1396036590)) goto L28;
        if (r0 == 583011860) goto L13;
        if (r0 == 1899998748) goto L10;
        return;
    L10:
        if (r6.equals(HomeCompanyAddressLearningSharedState.KEY_HOME_LEARNING_STATUS) == false) goto L34;
    L30:
        r4.g.b(r4.h());
        r4.a(r8);
        return;
    L34:
        return;
    L13:
        if (r6.equals(HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE) == false) goto L35;
        Object r10 = r9.getValue();
        if (ZeusTransformUtils.instanceOf(r10, Integer.class) == false) goto L18;
        Integer r11 = (Integer) ZeusTransformUtils.preCheckCast(r10, Integer.class, "com.obric.aiagent.plugin");
    L19:
        boolean r12 = true;
        if (r11 != null) goto L23;
    L25:
        r12 = false;
    L26:
        r4.f23203e.b(Boolean.valueOf(r12));
        return;
    L23:
        if (r11.intValue() != 1) goto L25;
    L18:
        r11 = null;
        goto L19
    L35:
        return;
    L28:
        if (r6.equals(HomeCompanyAddressLearningSharedState.KEY_COMPANY_LEARNING_STATUS) == true) goto L30;
    }

    public final void a(boolean r4) {
        Loog.INSTANCE.i(TAG, "toggleAutoLearn enable=" + r4);
        SharedState.INSTANCE.putInt(HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE, r4 ? 1 : 0);
        this.f23203e.b(Boolean.valueOf(r4));
    }

    private final boolean g() {
        if (SharedState.INSTANCE.getInt(HomeCompanyAddressLearningSharedState.KEY_AUTO_LEARN_STATE, -1) == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private final Map<Integer, Integer> h() {
        return ao.a(new d.m[]{s.a(0, Integer.valueOf(SharedState.INSTANCE.getInt(HomeCompanyAddressLearningSharedState.KEY_HOME_LEARNING_STATUS, -1))), s.a(1, Integer.valueOf(SharedState.INSTANCE.getInt(HomeCompanyAddressLearningSharedState.KEY_COMPANY_LEARNING_STATUS, -1)))});
    }

    @Override // androidx.lifecycle.aj
    public void a() {
        super.a();
        if (this.i == 0) goto L6;
        SharedState.INSTANCE.unregisterObserver(this.i);
        this.i = 0;
        return;
    }
}
