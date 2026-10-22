package com.obric.autogui.agents.vlm.models.impl.applist.black;

import android.util.EventsUtils;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.x;
import java.util.Collection;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlinx.coroutines.am;
import kotlinx.coroutines.an;
import kotlinx.coroutines.ax;
import kotlinx.coroutines.bp;
import kotlinx.coroutines.br;
import kotlinx.coroutines.cx;

/* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final p f27502a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final bp f27503b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final am f27504c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final q f27505d = null;

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSession.kt", c = {67}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSession$begin$2")
    static final class a extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27506a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f27507b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27508c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r f27509d;

        a(int r3, String r4, r r5, d.c.d<? super a> r6) {
            d.c.d r7 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27507b = r3;
            this.f27508c = r4;
            this.f27509d = r5;
            super(2, r7);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((a) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), a.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r4, d.c.d<?> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new a(this.f27507b, this.f27508c, this.f27509d, r6), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r10) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27506a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r10);
        L11:
            return r10;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r10);
            q r2 = p.a();
            String r11 = AOHostAppTools.INSTANCE.getHostAppPackage();
            int r3 = this.f27507b;
            int r4 = AOHostAppTools.INSTANCE.getUserHandle().hashCode();
            String r5 = this.f27508c;
            r r6 = this.f27509d;
            d.c.d<? super Boolean> r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27506a = 1;
            r10 = r2.a(r11, r3, r4, r5, r6, r7);
            if (r10 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
    public static final class b implements n {
        b() {
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.n
        public boolean a() {
            return AOPlatformTools.INSTANCE.display().supportsVirtualDisplayRecordSet();
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.n
        public long a(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3) {
            d.h.b.o.e(r3, "listener");
            return AOPlatformTools.INSTANCE.display().beginVirtualDisplayRecordSet(r1, r2, r3);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.n
        public boolean a(long r2, Collection<String> r4) {
            Collection<String> r1 = (Collection) ZeusTransformUtils.wrapperContextForParams(r4, Collection.class, "com.obric.aiagent.plugin");
            d.h.b.o.e(r1, "packageNames");
            return AOPlatformTools.INSTANCE.display().addVirtualDisplayRecordPackages(r2, r1);
        }

        @Override // com.obric.autogui.agents.vlm.models.impl.applist.black.n
        public void a(long r1) {
            AOPlatformTools.INSTANCE.display().endVirtualDisplayRecordSet(r1);
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSession.kt", c = {53}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSession$controller$2")
    static final class c extends d.c.b.a.l implements d.h.a.b<d.c.d<? super x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27510a;

        c(d.c.d<? super c> r3) {
            super(1, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(d.c.d<? super x> r3) {
            return ((c) ZeusTransformUtils.preCheckCast(create((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(d.c.d<?> r2) {
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c((d.c.d) ZeusTransformUtils.wrapperContextForParams(r2, d.c.d.class, "com.obric.aiagent.plugin")), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ Object invoke(d.c.d<? super x> r3) {
            return a((d.c.d) ZeusTransformUtils.preCheckCast(r3, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27510a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L12:
            return x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            d.c.d r7 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27510a = 1;
            if (ax.a(2000, r7) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSession.kt", c = {81}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSession$publishAuthorizedOpenAppPackage$2")
    static final class d extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27512b;

        d(String r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27512b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((d) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), d.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new d(this.f27512b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r8) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27511a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r8);
        L11:
            return r8;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r8);
            q r2 = p.a();
            String r9 = this.f27512b;
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27511a = 1;
            r8 = q.a(r2, r9, null, r4, 2, null);
            if (r8 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSession.kt", c = {EventsUtils.FEAT_TYPE_NFC_EVENT}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSession$publishAuthorizedOpenAppPackage$4")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27513a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27514b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27515c;

        e(String r3, String r4, d.c.d<? super e> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27514b = r3;
            this.f27515c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f27514b, this.f27515c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27513a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            q r8 = p.a();
            String r2 = this.f27514b;
            String r3 = this.f27515c;
            d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27513a = 1;
            r7 = r8.a(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: compiled from: VirtualDisplayRecordSetSession.kt */
    @d.c.b.a.f(b = "VirtualDisplayRecordSetSession.kt", c = {101}, d = "invokeSuspend", e = "com.obric.autogui.agents.vlm.models.impl.applist.black.VirtualDisplayRecordSetSession$publishStartInPlacePackage$2")
    static final class f extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super Boolean>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27516a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f27517b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f27518c;

        f(String r3, String r4, d.c.d<? super f> r5) {
            d.c.d r6 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27517b = r3;
            this.f27518c = r4;
            super(2, r6);
        }

        public final Object a(am r3, d.c.d<? super Boolean> r4) {
            return ((f) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), f.class, "com.obric.aiagent.plugin")).invokeSuspend(x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<x> create(Object r3, d.c.d<?> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new f(this.f27517b, this.f27518c, r5), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super Boolean> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f27516a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r7);
            q r8 = p.a();
            String r2 = this.f27517b;
            String r3 = this.f27518c;
            d.c.d<? super Boolean> r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f27516a = 1;
            r7 = r8.b(r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    public static /* synthetic */ Thread lambda$dMYZ63mBZbdzKm5fA6S2Ce6oCgk(Runnable r0) {
        return a(r0);
    }

    private p() {
    }

    public static final /* synthetic */ q a() {
        return f27505d;
    }

    static {
        f27502a = new p();
        ExecutorService r0 = Executors.newSingleThreadExecutor($$Lambda$p$dMYZ63mBZbdzKm5fA6S2Ce6oCgk.INSTANCE);
        d.h.b.o.c(r0, "newSingleThreadExecutor(...)");
        bp r1 = br.a(r0);
        f27503b = r1;
        am r7 = an.a(cx.a(null, 1, null).plus((d.c.g) ZeusTransformUtils.preCheckCast(r1, d.c.g.class, "com.obric.aiagent.plugin")));
        f27504c = r7;
        f27505d = new q((n) ZeusTransformUtils.preCheckCast(new b(), n.class, "com.obric.aiagent.plugin"), r7, (d.h.a.b) ZeusTransformUtils.preCheckCast(new c(null), d.h.a.b.class, "com.obric.aiagent.plugin"), null, 8, null);
    }

    private static final Thread a(Runnable r2) {
        return new Thread((Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.aiagent.plugin"), "VDRecordSet");
    }

    public final Object a(int r4, String r5, r r6, d.c.d<? super Boolean> r7) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r7, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(f27503b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new a(r4, r5, r6, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object a(String r4, d.c.d<? super Boolean> r5) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(f27503b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new d(r4, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object a(String r4, String r5, d.c.d<? super Boolean> r6) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(f27503b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final Object b(String r4, String r5, d.c.d<? super Boolean> r6) {
        d.c.d r3 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r6, d.c.d.class, "com.obric.aiagent.plugin");
        return kotlinx.coroutines.i.a((d.c.g) ZeusTransformUtils.preCheckCast(f27503b, d.c.g.class, "com.obric.aiagent.plugin"), (d.h.a.m) ZeusTransformUtils.preCheckCast(new f(r4, r5, null), d.h.a.m.class, "com.obric.aiagent.plugin"), r3);
    }

    public final void a(String r1) {
        d.h.b.o.e(r1, "ownerToken");
        f27505d.a(r1);
    }
}
