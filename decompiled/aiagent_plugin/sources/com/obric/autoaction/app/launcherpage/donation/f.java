package com.obric.autoaction.app.launcherpage.donation;

import android.content.Context;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.obric.autoaction.app.launcherpage.donation.model.Question;
import com.obric.autogui.common.api.app.AOHostAppTools;
import com.obric.autogui.common.api.logging.Loog;
import com.obric.autogui.common.api.platform.AOPlatformTools;
import com.obric.autogui.common.api.platform.account.LoggedInUserInfo;
import com.obric.autogui.common.api.platform.screen.capture.OScreenEvent;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.a.p;
import d.o;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.bd;
import kotlinx.coroutines.ca;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {
    private static final String TAG = "DonationTaskRecordRepo";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f23739a = null;
    private static final d.f<Gson> i = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final am f23740b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final x<List<com.obric.autoaction.app.launcherpage.donation.e.c>> f23741c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f23742d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f23743e;
    private boolean f;
    private volatile ca g;
    private final x<h> h;

    /* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
    public static final class a {
        public /* synthetic */ a(d.h.b.h r1) {
            this();
        }

        private a() {
        }

        public static final /* synthetic */ Gson a(a r0) {
            return r0.a();
        }

        private final Gson a() {
            return (Gson) ZeusTransformUtils.preCheckCast(f.e().b(), Gson.class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
    @d.c.b.a.f(b = "DonationTaskRecordRepo.kt", c = {39}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordRepo$init$1")
    static final class b extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f23745b;

        b(f r3, d.c.d<? super b> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23745b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new b(this.f23745b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23744a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            f r6 = this.f23745b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23744a = 1;
            if (f.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
    @d.c.b.a.f(b = "DonationTaskRecordRepo.kt", c = {46}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordRepo$loadMore$1")
    static final class c extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super d.x>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f23747b;

        c(f r3, d.c.d<? super c> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23747b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super d.x> r4) {
            return ((c) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), c.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new c(this.f23747b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super d.x> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r5) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23746a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r5);
        L12:
            return d.x.f38692a;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r5);
            f r6 = this.f23747b;
            d.c.d r2 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23746a = 1;
            if (f.a(r6, r2) != r0) goto L12;
            return r0;
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
    @d.c.b.a.f(b = "DonationTaskRecordRepo.kt", c = {53}, d = "loadTaskRecord", e = "com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordRepo")
    static final class d extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23748a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23749b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f23750c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23751d;

        d(f r3, d.c.d<? super d> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23750c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23749b = r3;
            this.f23751d |= Integer.MIN_VALUE;
            return f.a(this.f23750c, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    /* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
    @d.c.b.a.f(b = "DonationTaskRecordRepo.kt", c = {54}, d = "invokeSuspend", e = "com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordRepo$loadTaskRecord$2$list$1")
    static final class e extends d.c.b.a.l implements d.h.a.m<am, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.donation.e.c>>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f23752a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ f f23753b;

        e(f r3, d.c.d<? super e> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23753b = r3;
            super(2, r5);
        }

        public final Object a(am r3, d.c.d<? super List<com.obric.autoaction.app.launcherpage.donation.e.c>> r4) {
            return ((e) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin")), e.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d.c.d<d.x> create(Object r2, d.c.d<?> r3) {
            d.c.d r4 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin");
            return (d.c.d) ZeusTransformUtils.preCheckCast(new e(this.f23753b, r4), d.c.d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d.c.d<? super List<? extends com.obric.autoaction.app.launcherpage.donation.e.c>> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d.c.d) ZeusTransformUtils.preCheckCast(r4, d.c.d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r7) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f23752a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            o.a(r7);
        L11:
            return r7;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            o.a(r7);
            f r8 = this.f23753b;
            int r2 = f.a(r8);
            int r3 = f.b(this.f23753b);
            d.c.d r4 = (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23752a = 1;
            r7 = f.a(r8, r2, r3, r4);
            if (r7 != r0) goto L11;
            return r0;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.app.launcherpage.donation.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: DonationTaskRecordRepo.kt */
    @d.c.b.a.f(b = "DonationTaskRecordRepo.kt", c = {79}, d = "realLoad", e = "com.obric.autoaction.app.launcherpage.donation.DonationTaskRecordRepo")
    static final class C0536f extends d.c.b.a.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Object f23754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f23755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f23756c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f23757d;

        C0536f(f r3, d.c.d<? super C0536f> r4) {
            d.c.d r5 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r4, d.c.d.class, "com.obric.aiagent.plugin");
            this.f23756c = r3;
            super(r5);
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r3) {
            this.f23755b = r3;
            this.f23757d |= Integer.MIN_VALUE;
            return f.a(this.f23756c, 0, 0, (d.c.d) ZeusTransformUtils.preCheckCast(this, d.c.d.class, "com.obric.aiagent.plugin"));
        }
    }

    public static /* synthetic */ Gson lambda$WukThn4vvQOaJ65RiDeEnqicpaM() {
        return f();
    }

    public f(am r3) {
        am r4 = (am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin");
        d.h.b.o.e(r4, "scope");
        this.f23740b = r4;
        this.f23741c = kotlinx.coroutines.b.am.a(p.b());
        this.f23743e = 15;
        this.f = true;
        this.h = kotlinx.coroutines.b.am.a(h.c.f23765a);
    }

    public static final /* synthetic */ int a(f r0) {
        return r0.f23743e;
    }

    public static final /* synthetic */ Object a(f r2, int r3, int r4, d.c.d r5) {
        return r2.a(r3, r4, (d.c.d) ZeusTransformUtils.wrapperContextForParams(r5, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ Object a(f r2, d.c.d r3) {
        return r2.a((d.c.d) ZeusTransformUtils.wrapperContextForParams(r3, d.c.d.class, "com.obric.aiagent.plugin"));
    }

    public static final /* synthetic */ int b(f r0) {
        return r0.f23742d;
    }

    public static final /* synthetic */ d.f e() {
        return i;
    }

    static {
        f23739a = new a(null);
        i = d.g.a($$Lambda$f$WukThn4vvQOaJ65RiDeEnqicpaM.INSTANCE);
    }

    private static final Gson f() {
        return new GsonBuilder().create();
    }

    public final x<List<com.obric.autoaction.app.launcherpage.donation.e.c>> a() {
        return this.f23741c;
    }

    public final x<h> b() {
        return this.h;
    }

    public final void c() {
        this.g = kotlinx.coroutines.i.a(this.f23740b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new b(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
    }

    public final void d() {
        if (this.f == true) goto L5;
        return;
    L5:
        if (this.g != null) goto L9;
        this.g = kotlinx.coroutines.i.a(this.f23740b, (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin"), null, (d.h.a.m) ZeusTransformUtils.preCheckCast(new c(this, null), d.h.a.m.class, "com.obric.aiagent.plugin"), 2, null);
        return;
    }

    private final Object a(d.c.d<? super d.x> r10) {
        d.c.d r11 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r10, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r11, d.class) == false) goto L7;
        d r0 = (d) ZeusTransformUtils.preCheckCast(r11, d.class, "com.obric.aiagent.plugin");
        if ((r0.f23751d & Integer.MIN_VALUE) == 0) goto L7;
        r0.f23751d -= Integer.MIN_VALUE;
    L8:
        Object r12 = r0.f23749b;
        Object r2 = d.c.a.b.a();
        int r3 = r0.f23751d;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        f this = (f) ZeusTransformUtils.preCheckCast(r0.f23748a, f.class, "com.obric.aiagent.plugin");
        o.a(r12);     // Catch: Throwable -> L45
    L20:
        List r13 = (List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        if (r13.size() >= this.f23743e) goto L23;
        this.f = false;     // Catch: Throwable -> L45
    L23:
        this.f23742d += r13.size();     // Catch: Throwable -> L45
        x<List<com.obric.autoaction.app.launcherpage.donation.e.c>> r1 = this.f23741c;     // Catch: Throwable -> L45
    L24:
        List<com.obric.autoaction.app.launcherpage.donation.e.c> r4 = r1.c();     // Catch: Throwable -> L45
        Iterable r5 = (Iterable) ZeusTransformUtils.preCheckCast(p.c((Collection) ZeusTransformUtils.preCheckCast((List) ZeusTransformUtils.preCheckCast(r4, List.class, "com.obric.aiagent.plugin"), Collection.class, "com.obric.aiagent.plugin"), (Iterable) ZeusTransformUtils.preCheckCast(r13, Iterable.class, "com.obric.aiagent.plugin")), Iterable.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        HashSet r6 = new HashSet();     // Catch: Throwable -> L45
        ArrayList r7 = new ArrayList();     // Catch: Throwable -> L45
        Iterator r8 = r5.iterator();     // Catch: Throwable -> L45
    L26:
        if (r8.hasNext() == false) goto L31;
        Object r9 = r8.next();     // Catch: Throwable -> L45
        if (r6.add(((com.obric.autoaction.app.launcherpage.donation.e.c) ZeusTransformUtils.preCheckCast(r9, com.obric.autoaction.app.launcherpage.donation.e.c.class, "com.obric.aiagent.plugin")).a().a()) == false) goto L26;
        r7.add(r9);     // Catch: Throwable -> L45
        goto L26
    L31:
        if (r1.a(r4, (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin")) == false) goto L24;
        if (this.f23742d == 0) goto L35;
    L40:
        x<h> r14 = this.h;     // Catch: Throwable -> L45
    L41:
        h r15 = r14.c();     // Catch: Throwable -> L45
        h r16 = (h) ZeusTransformUtils.preCheckCast(r15, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        if (r14.a(r15, (h) ZeusTransformUtils.preCheckCast(h.d.f23766a, h.class, "com.obric.aiagent.plugin")) == false) goto L41;
    L43:
        Object r17 = d.n.f(d.x.f38692a);     // Catch: Throwable -> L45
    L48:
        if (d.n.c(r17) == null) goto L52;
        x<h> r18 = this.h;
    L50:
        h r19 = r18.c();
        h r20 = (h) ZeusTransformUtils.preCheckCast(r19, h.class, "com.obric.aiagent.plugin");
        if (r18.a(r19, (h) ZeusTransformUtils.preCheckCast(h.b.f23764a, h.class, "com.obric.aiagent.plugin")) == false) goto L50;
    L52:
        this.g = null;
        return d.x.f38692a;
    L35:
        if (r13.isEmpty() == false) goto L40;
        x<h> r110 = this.h;     // Catch: Throwable -> L45
    L37:
        h r21 = r110.c();     // Catch: Throwable -> L45
        h r22 = (h) ZeusTransformUtils.preCheckCast(r21, h.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        if (r110.a(r21, (h) ZeusTransformUtils.preCheckCast(h.a.f23763a, h.class, "com.obric.aiagent.plugin")) == false) goto L37;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        o.a(r12);
        d.n.a r111 = d.n.f38560a;     // Catch: Throwable -> L45
        d.c.g r112 = (d.c.g) ZeusTransformUtils.preCheckCast(bd.c(), d.c.g.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        d.h.a.m r23 = (d.h.a.m) ZeusTransformUtils.preCheckCast(new e(this, null), d.h.a.m.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L45
        r0.f23748a = this;     // Catch: Throwable -> L45
        r0.f23751d = 1;     // Catch: Throwable -> L45
        r12 = kotlinx.coroutines.i.a(r112, r23, r0);     // Catch: Throwable -> L45
        if (r12 != r2) goto L20;
        return r2;
    L45:
        th = move-exception;
        d.n.a r24 = d.n.f38560a;
        r17 = d.n.f(o.a(th));
    L7:
        r0 = new d(this, r11);
        goto L8
    }

    private final Object a(int r21, int r22, d.c.d<? super List<com.obric.autoaction.app.launcherpage.donation.e.c>> r23) {
        f r0 = this;
        d.c.d r1 = (d.c.d) ZeusTransformUtils.wrapperContextForParams(r23, d.c.d.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r1, C0536f.class) == false) goto L7;
        C0536f r3 = (C0536f) ZeusTransformUtils.preCheckCast(r1, C0536f.class, "com.obric.aiagent.plugin");
        if ((r3.f23757d & Integer.MIN_VALUE) == 0) goto L7;
        r3.f23757d -= Integer.MIN_VALUE;
    L8:
        Object r2 = r3.f23755b;
        Object r4 = d.c.a.b.a();
        int r5 = r3.f23757d;
        if (r5 == 0) goto L18;
        if (r5 != 1) goto L17;
        r0 = (f) ZeusTransformUtils.preCheckCast(r3.f23754a, f.class, "com.obric.aiagent.plugin");
        o.a(r2);     // Catch: Throwable -> L14
    L30:
        com.obric.autogui.tools.api.net.a.InterfaceC0861a r6 = (com.obric.autogui.tools.api.net.a.InterfaceC0861a) ZeusTransformUtils.preCheckCast(r2, com.obric.autogui.tools.api.net.a.InterfaceC0861a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r6.a() == true) goto L35;
        com.obric.autogui.tools.api.net.b r7 = r6.a((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AOHostAppTools.INSTANCE.getAppContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));     // Catch: Throwable -> L14
        r7.b();     // Catch: Throwable -> L14
        Loog.INSTANCE.e(TAG, "realLoad failed: " + r7.getType());     // Catch: Throwable -> L14
        return p.b();
    L35:
        String r8 = (String) ZeusTransformUtils.preCheckCast(r6.c(), String.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        Loog.INSTANCE.i(TAG, "realLoad, response: " + r8);     // Catch: Throwable -> L14
        if (r6.a() == false) goto L65;
        if (r8 == null) goto L65;
        JSONArray r9 = new JSONObject(r8).optJSONObject("data").optJSONArray("upload_record");     // Catch: Throwable -> L14
        if (r9 == null) goto L41;
        List r10 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        int r11 = r9.length();     // Catch: Throwable -> L14
        int r12 = 0;
        int r13 = 0;
    L43:
        if (r13 >= r11) goto L64;
        JSONObject r14 = r9.getJSONObject(r13);     // Catch: Throwable -> L14
        String r15 = r14.optString("session_id");     // Catch: Throwable -> L14
        String r16 = r14.optString("target");     // Catch: Throwable -> L14
        JSONObject r17 = r14.optJSONObject("question");     // Catch: Throwable -> L14
        if (r17 == null) goto L47;
        String r18 = r17.toString();     // Catch: Throwable -> L14
    L48:
        if (r18 == null) goto L50;
        Question r19 = (Question) ZeusTransformUtils.preCheckCast(a.a(f23739a).fromJson(r18, Question.class), Question.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
    L51:
        int r110 = r0.a(r14.optInt("status", r12));     // Catch: Throwable -> L14
        int r24 = r13;
        long r111 = r14.optLong("upload_time", System.currentTimeMillis());     // Catch: Throwable -> L14
        String r112 = r14.optString("reject_reason");     // Catch: Throwable -> L14
        JSONArray r20 = r14.optJSONArray("answer");     // Catch: Throwable -> L14
        List r113 = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L14
        if (r20 == null) goto L60;
        int r25 = r20.length();     // Catch: Throwable -> L14
        int r26 = 0;
    L54:
        if (r26 >= r25) goto L60;
        JSONObject r27 = r20.getJSONObject(r26);     // Catch: Throwable -> L14
        String r114 = r27.optString("uri");     // Catch: Throwable -> L14
        String r115 = r27.optString("describe");     // Catch: Throwable -> L14
        f r28 = r0;
        JSONObject r29 = r27.optJSONObject("operation");     // Catch: Throwable -> L14
        if (r29 == null) goto L58;
        OScreenEvent r30 = OScreenEvent.Companion.fromJson(r29);     // Catch: Throwable -> L14
    L59:
        com.obric.autoaction.app.launcherpage.donation.model.c r31 = new com.obric.autoaction.app.launcherpage.donation.model.c(r30, null);     // Catch: Throwable -> L14
        r31.a(r114);     // Catch: Throwable -> L14
        r31.b(r115);     // Catch: Throwable -> L14
        r113.add(r31);     // Catch: Throwable -> L14
        r26 = r26 + 1;     // Catch: Throwable -> L14
        r0 = r28;
        r9 = r9;
        goto L54
    L58:
        r30 = null;
    L60:
        f r210 = r0;
        JSONArray r116 = r9;
        if (r15 != null) goto L63;
        r15 = "";
    L63:
        d.h.b.o.a(r16);     // Catch: Throwable -> L14
        r10.add(new com.obric.autoaction.app.launcherpage.donation.e.c(new com.obric.autoaction.app.launcherpage.donation.model.a(r15, r16, r19, r113, r110, r111, r112)));     // Catch: Throwable -> L14
        r13 = r24 + 1;     // Catch: Throwable -> L14
        r0 = r210;
        r9 = r116;
        r12 = 0;
        goto L43
    L50:
        r19 = null;
        goto L51
    L47:
        r18 = null;
        goto L48
    L64:
        return r10;
    L41:
        return p.b();
    L65:
        d.n.f(d.x.f38692a);     // Catch: Throwable -> L14
    L69:
        return p.b();
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        o.a(r2);
        com.obric.autogui.tools.api.net.a r32 = com.obric.autogui.tools.a.a.f31480a.a();
        if (r32 == null) goto L21;
        LoggedInUserInfo r33 = AOPlatformTools.INSTANCE.account().acquireUserInfo().getUserInfo();
        if (r33 == null) goto L26;
        String r34 = r33.getUserId();
        if (r34 == null) goto L26;
    L27:
        d.n.a r35 = d.n.f38560a;     // Catch: Throwable -> L14
        String r36 = com.obric.aiagent.product.a.a.f18769a.a("auto_action/api/donation/get_upload_record?page_size=" + r21 + "&offset=" + r22 + "&uid=" + r34);     // Catch: Throwable -> L14
        Map<String, String> r37 = ao.b();     // Catch: Throwable -> L14
        r3.f23754a = r0;     // Catch: Throwable -> L14
        r3.f23757d = 1;     // Catch: Throwable -> L14
        r2 = r32.a(r36, r37, 60000, r3);     // Catch: Throwable -> L14
        if (r2 != r4) goto L30;
        return r4;
    L26:
        r34 = "0";
        goto L27
    L21:
        return p.b();
    L14:
        th = move-exception;
        d.n.a r38 = d.n.f38560a;
        d.n.f(o.a(th));
    L7:
        r3 = new C0536f(r0, r1);
        goto L8
    }

    private final int a(int r1) {
        if (r1 == 1) goto L12;
        if (r1 == 2) goto L15;
        if (r1 == 3) goto L14;
        return m.a.e.f23790a.a();
    L14:
        return m.a.b.f23787a.a();
    L15:
        return m.a.C0537a.f23786a.a();
    L12:
        return m.a.c.f23788a.a();
    }
}
