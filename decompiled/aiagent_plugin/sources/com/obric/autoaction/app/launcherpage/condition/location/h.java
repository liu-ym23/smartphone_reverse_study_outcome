package com.obric.autoaction.app.launcherpage.condition.location;

import com.obric.autogui.common.api.logging.Loog;
import com.obric.eventkit.ITaskManagerApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.bd;

/* JADX INFO: compiled from: FrequentLocationSaver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    private static final String TAG = "FrequentLocationSaver";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f23191a = null;

    /* JADX INFO: compiled from: FrequentLocationSaver.kt */
    @d.c.b.a.f(b = "FrequentLocationSaver.kt", c = {43}, d = "save", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationSaver")
    static final class a extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23192a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23193b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ h f23194c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23195d;

        a(h r3, d.c.d<? super a> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23194c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23193b = r3;
            this.f23195d |= Integer.MIN_VALUE;
            return this.f23194c.a(null, null, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: FrequentLocationSaver.kt */
    @d.c.b.a.f(b = "FrequentLocationSaver.kt", c = {44}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.condition.location.FrequentLocationSaver$save$success$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23196a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f23197b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ ConditionLocationItemData f23198c;

        b(String r3, ConditionLocationItemData r4, d.c.d<? super b> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23197b = r3;
            this.f23198c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23197b, this.f23198c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r14) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23196a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r14);
        L13:
            boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r14, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        L16:
            return d.c.b.a.b.a(r13);
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r14);
            ITaskManagerApi r4 = (ITaskManagerApi) ZeusTransformUtils.preCheckCast(ServiceManager.get().getService(ITaskManagerApi.class), ITaskManagerApi.class, "com.obric.aiagent.plugin");
            if (r4 == null) goto L14;
            String r5 = this.f23197b;
            double r6 = this.f23198c.getLongitude();
            double r8 = this.f23198c.getLatitude();
            String r10 = this.f23198c.getName();
            String r11 = this.f23198c.getAddress();
            d.c.d<? super Boolean> r12 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23196a = 1;
            r14 = r4.setLocation(r5, r6, r8, r10, r11, r12);
            if (r14 != r0) goto L13;
            return r0;
        L14:
            r13 = false;
            goto L16
        }
    }

    static {
        f23191a = new h();
    }

    private h() {
    }

    public final Object a(ConditionLocationItemData r7, ConditionLocationItemData r8, d.c.d<? super Boolean> r9) {
        d.c.d r10 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r9, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r10, a.class) == false) goto L7;
        a r0 = (a) ZeusTransformUtils.preCheckCast(r10, a.class, "com.obric.aiagent.plugin");
        if ((r0.f23195d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23195d -= Integer.MIN_VALUE;
    L8:
        Object r6 = r0.f23193b;
        Object r11 = d.c.a.b.a();
        int r2 = r0.f23195d;
        if (r2 == 0) goto L14;
        if (r2 != 1) goto L13;
        String r12 = (String) ZeusTransformUtils.preCheckCast(r0.f23192a, String.class, "com.obric.aiagent.plugin");
        d.o.a(r6);
    L24:
        boolean r13 = ((Boolean) ZeusTransformUtils.preCheckCast(r6, Boolean.class, "com.obric.aiagent.plugin")).booleanValue();
        Loog.INSTANCE.i(TAG, "save type: " + r12 + ", success: " + r13);
        return d.c.b.a.b.a(r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        d.o.a(r6);
        int r14 = r7.getType();
        if (r14 == 0) goto L20;
        if (r14 == 1) goto L19;
        Loog.INSTANCE.w(TAG, "save ignore unsupported type: " + r7.getType());
        return d.c.b.a.b.a(false);
    L19:
        String r15 = "company";
    L21:
        r12 = r15;
        d.c.g r16 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");
        d.h.a.m r17 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(r12, r8, null), d.h.a.m.class, "com.obric.aiagent.plugin");
        r0.f23192a = r12;
        r0.f23195d = 1;
        r6 = kotlinx.coroutines.i.a(r16, r17, r0);
        if (r6 != r11) goto L24;
        return r11;
    L20:
        r15 = "home";
    L7:
        r0 = new a(this, r10);
        goto L8
    }

    public static /* synthetic */ List a(h r1, List r2, ConditionLocationItemData r3, ConditionLocationItemData r4, boolean r5, int r6, Object r7) {
        List<ConditionLocationItemData> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r2, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 8) == 0) goto L6;
        r5 = false;
    L6:
        return r1.a(r8, r3, r4, r5);
    }

    public final List<ConditionLocationItemData> a(List<ConditionLocationItemData> r17, ConditionLocationItemData r18, ConditionLocationItemData r19, boolean r20) {
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r0, "current");
        d.h.b.o.e(r18, "editingItem");
        d.h.b.o.e(r19, "selected");
        if (r20 == false) goto L5;
        String r2 = r19.getName();
    L6:
        ConditionLocationItemData r3 = ConditionLocationItemData.copy$default(r18, 0, null, r2, r19.getLongitude(), r19.getLatitude(), true, null, 67, null);
        Iterable r1 = (Iterable) ZeusTransformUtils.preCheckCast(r0, Iterable.class, "com.obric.aiagent.plugin");
        Collection r4 = (Collection) ZeusTransformUtils.preCheckCast(new ArrayList(p.a(r1, 10)), Collection.class, "com.obric.aiagent.plugin");
        Iterator r5 = r1.iterator();
    L8:
        if (r5.hasNext() == false) goto L14;
        ConditionLocationItemData r6 = (ConditionLocationItemData) ZeusTransformUtils.preCheckCast(r5.next(), ConditionLocationItemData.class, "com.obric.aiagent.plugin");
        if (r6.getType() != r18.getType()) goto L12;
        r6 = r3;
    L12:
        r4.add(r6);
        goto L8
    L14:
        return (List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin");
    L5:
        r2 = r19.getAddress();
        goto L6
    }
}
