package com.obric.agent.permission;

import com.obric.agent.permission.b.c;
import com.obric.agent.permission.bean.CheckPermissionReq;
import com.obric.agent.permission.bean.Permission;
import com.obric.agent.permission.bean.RequestPermissionReq;
import com.obric.agent.permission.bean.RequestPermissionResult;
import com.obric.agent.permission.bean.UpdatePermissionReq;
import com.obric.agent.permission.bean.UpdatePermissionResult;
import com.obric.capabilitykit.common.DispatchContext;
import com.obric.capabilitykit.common.Ext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.c.b.a.l;
import d.c.d;
import d.f;
import d.g;
import d.h.a.m;
import d.k;
import d.o;
import d.x;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.i;

/* JADX INFO: compiled from: PermissionProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final f f15394a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f15395b;

    /* JADX INFO: compiled from: PermissionProcessor.kt */
    @d.c.b.a.f(b = "PermissionProcessor.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.permission.PermissionProcessor$checkPermissions$1")
    static final class a extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15397b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<List<Permission>, x> f15398c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ CheckPermissionReq f15399d;

        a(b r3, d.h.a.b<? super List<Permission>, x> r4, CheckPermissionReq r5, d<? super a> r6) {
            d.h.a.b<List<Permission>, x> r7 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r6, d.class, "com.obric.aiagent.plugin");
            this.f15397b = r3;
            this.f15398c = r7;
            this.f15399d = r5;
            super(2, r8);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r4, d<?> r5) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r5, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new a(this.f15397b, this.f15398c, this.f15399d, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            d.c.a.b.a();
            if (this.f15396a != 0) goto L11;
            o.a(r6);
            ArrayList r7 = new ArrayList();
            Iterable r0 = (Iterable) ZeusTransformUtils.preCheckCast(b.a(this.f15397b), Iterable.class, "com.obric.aiagent.plugin");
            CheckPermissionReq r1 = this.f15399d;
            Iterator r2 = r0.iterator();
        L6:
            if (r2.hasNext() == false) goto L8;
            r7.addAll((Collection) ZeusTransformUtils.preCheckCast(((com.obric.agent.permission.b.b) ZeusTransformUtils.preCheckCast(r2.next(), com.obric.agent.permission.b.b.class, "com.obric.aiagent.plugin")).a(r1), Collection.class, "com.obric.aiagent.plugin"));
            goto L6
        L8:
            this.f15398c.invoke(r7);
            return x.f38692a;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.obric.agent.permission.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: PermissionProcessor.kt */
    @d.c.b.a.f(b = "PermissionProcessor.kt", c = {}, d = "invokeSuspend", e = "com.obric.agent.permission.PermissionProcessor$requestPermissions$1")
    static final class C0315b extends l implements m<am, d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f15400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ b f15401b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ d.h.a.b<RequestPermissionResult, x> f15402c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ RequestPermissionReq f15403d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ DispatchContext f15404e;

        /* JADX INFO: renamed from: com.obric.agent.permission.b$b$a */
        /* JADX INFO: compiled from: PermissionProcessor.kt */
        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f15405a = null;

            static {
                int[] r0 = new int[RequestPermissionResult.a.values().length];
                r0[RequestPermissionResult.a.f15408a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
            L9:
                r0[RequestPermissionResult.a.f15409b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
            L5:
                f15405a = r0;
            }
        }

        C0315b(b r3, d.h.a.b<? super RequestPermissionResult, x> r4, RequestPermissionReq r5, DispatchContext r6, d<? super C0315b> r7) {
            d.h.a.b<RequestPermissionResult, x> r8 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
            d r9 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
            this.f15401b = r3;
            this.f15402c = r8;
            this.f15403d = r5;
            this.f15404e = r6;
            super(2, r9);
        }

        public final Object a(am r3, d<? super x> r4) {
            return ((C0315b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), C0315b.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<x> create(Object r8, d<?> r9) {
            d r6 = (d) ZeusTransformUtils.wrapperContextForParams(r9, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new C0315b(this.f15401b, this.f15402c, this.f15403d, this.f15404e, r6), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            d.c.a.b.a();
            if (this.f15400a != 0) goto L17;
            o.a(r10);
            Iterable r11 = (Iterable) ZeusTransformUtils.preCheckCast(b.a(this.f15401b), Iterable.class, "com.obric.aiagent.plugin");
            RequestPermissionReq r0 = this.f15403d;
            DispatchContext r2 = this.f15404e;
            d.h.a.b<RequestPermissionResult, x> r3 = this.f15402c;
            Iterator r12 = r11.iterator();
        L6:
            if (r12.hasNext() == false) goto L14;
            RequestPermissionResult r4 = ((com.obric.agent.permission.b.b) ZeusTransformUtils.preCheckCast(r12.next(), com.obric.agent.permission.b.b.class, "com.obric.aiagent.plugin")).requestPermissions(r0, r2);
            RequestPermissionResult.a r7 = r4.getState();
            int r8 = a.f15405a[r7.ordinal()];
            if (r8 == 1) goto L6;
            if (r8 != 2) goto L13;
            r3.invoke(RequestPermissionResult.copy$default(r4, null, r0.getContent(), 1, null));
            return x.f38692a;
        L13:
            throw new k();
        L14:
            this.f15402c.invoke(new RequestPermissionResult(RequestPermissionResult.a.f15408a, null, 2, null));
            return x.f38692a;
        L17:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ ArrayList lambda$ysVNalMaf1Yxa38Jls0No78fXCU() {
        return b();
    }

    public b() {
        this.f15394a = g.a($$Lambda$b$ysVNalMaf1Yxa38Jls0No78fXCU.INSTANCE);
        this.f15395b = an.a((d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ ArrayList a(b r0) {
        return r0.a();
    }

    private final ArrayList<com.obric.agent.permission.b.b> a() {
        return (ArrayList) ZeusTransformUtils.preCheckCast(this.f15394a.b(), ArrayList.class, "com.obric.aiagent.plugin");
    }

    private static final ArrayList b() {
        return p.d(new com.obric.agent.permission.b.b[]{new com.obric.agent.permission.b.a(), new c(), new com.obric.agent.permission.b.d()});
    }

    public final void a(CheckPermissionReq r9, d.h.a.b<? super List<Permission>, x> r10) {
        d.h.a.b r11 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r10, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r9, Ext.KEY_REQUEST);
        d.h.b.o.e(r11, "callback");
        i.a(this.f15395b, null, null, (m) ZeusTransformUtils.preCheckCast(new a(this, r11, r9, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void requestPermissions(RequestPermissionReq r12, DispatchContext r13, d.h.a.b<? super RequestPermissionResult, x> r14) {
        d.h.a.b r4 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r14, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r12, Ext.KEY_REQUEST);
        d.h.b.o.e(r13, "dispatchContext");
        d.h.b.o.e(r4, "callback");
        i.a(this.f15395b, null, null, (m) ZeusTransformUtils.preCheckCast(new C0315b(this, r4, r12, r13, null), m.class, "com.obric.aiagent.plugin"), 3, null);
    }

    public final void a(UpdatePermissionReq r4, d.h.a.b<? super UpdatePermissionResult, x> r5) {
        d.h.a.b r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, Ext.KEY_REQUEST);
        d.h.b.o.e(r6, "callback");
        Iterator r3 = ((Iterable) ZeusTransformUtils.preCheckCast(a(), Iterable.class, "com.obric.aiagent.plugin")).iterator();
    L4:
        if (r3.hasNext() == false) goto L6;
        ((com.obric.agent.permission.b.b) ZeusTransformUtils.preCheckCast(r3.next(), com.obric.agent.permission.b.b.class, "com.obric.aiagent.plugin")).a(r4);
        goto L4
    L6:
        r6.invoke(new UpdatePermissionResult(true));
    }
}
