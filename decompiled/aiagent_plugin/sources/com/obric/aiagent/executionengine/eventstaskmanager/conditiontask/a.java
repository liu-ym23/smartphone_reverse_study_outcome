package com.obric.aiagent.executionengine.eventstaskmanager.conditiontask;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.c.b.a.f;
import d.c.b.a.l;
import d.c.d;
import d.h.a.m;
import d.h.b.h;
import d.h.b.o;
import kotlinx.coroutines.am;
import kotlinx.coroutines.b.j;
import kotlinx.coroutines.b.x;
import kotlinx.coroutines.dg;

/* JADX INFO: compiled from: AccountDatabaseReadyGate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0342a f16730a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final x<String> f16731b;

    /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AccountDatabaseReadyGate.kt */
    public static final class C0342a {
        public /* synthetic */ C0342a(h r1) {
            this();
        }

        private C0342a() {
        }

        public final boolean a(String r3) {
            CharSequence r2 = (CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin");
            if (r2 != null) goto L5;
        L8:
            boolean r4 = true;
        L9:
            if (r4 == false) goto L11;
            return false;
        L11:
            if (o.a(r3, "0") == false) goto L13;
            return false;
        L13:
            return true;
        L5:
            if (r2.length() == 0) goto L8;
            r4 = false;
            goto L9
        }
    }

    /* JADX INFO: compiled from: AccountDatabaseReadyGate.kt */
    @f(b = "AccountDatabaseReadyGate.kt", c = {28}, d = "invokeSuspend", e = "com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.AccountDatabaseReadyGate$await$4")
    static final class b extends l implements m<am, d<? super String>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f16732a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ a f16733b;

        /* JADX INFO: renamed from: com.obric.aiagent.executionengine.eventstaskmanager.conditiontask.a$b$1, reason: invalid class name */
        /* JADX INFO: compiled from: AccountDatabaseReadyGate.kt */
        /* synthetic */ class AnonymousClass1 extends d.h.b.a implements m<String, d<? super Boolean>, Object> {
            AnonymousClass1(Object r8) {
                super(2, r8, C0342a.class, "isValidUserId", "isValidUserId$manager_impl_release(Ljava/lang/String;)Z", 4);
            }

            public final Object a(String r3, d<? super Boolean> r4) {
                d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
                return b.a((C0342a) ZeusTransformUtils.preCheckCast(this.f38477a, C0342a.class, "com.obric.aiagent.plugin"), r3, r5);
            }

            @Override // d.h.a.m
            public /* synthetic */ Object invoke(String r3, d<? super Boolean> r4) {
                return a((String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
            }
        }

        b(a r3, d<? super b> r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            this.f16733b = r3;
            super(2, r5);
        }

        public static final /* synthetic */ Object a(C0342a r2, String r3, d r4) {
            return b(r2, r3, (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin"));
        }

        public final Object a(am r3, d<? super String> r4) {
            return ((b) ZeusTransformUtils.preCheckCast(create((am) ZeusTransformUtils.wrapperContextForParams(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin")), b.class, "com.obric.aiagent.plugin")).invokeSuspend(d.x.f38692a);
        }

        @Override // d.c.b.a.a
        public final d<d.x> create(Object r2, d<?> r3) {
            d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.aiagent.plugin");
            return (d) ZeusTransformUtils.preCheckCast(new b(this.f16733b, r4), d.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.m
        public /* synthetic */ Object invoke(am r3, d<? super String> r4) {
            return a((am) ZeusTransformUtils.preCheckCast(r3, am.class, "com.obric.aiagent.plugin"), (d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.aiagent.plugin"));
        }

        @Override // d.c.b.a.a
        public final Object invokeSuspend(Object r6) {
            Object r0 = d.c.a.b.a();
            int r1 = this.f16732a;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            d.o.a(r6);
        L11:
            return r6;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            d.o.a(r6);
            kotlinx.coroutines.b.h r7 = j.c((kotlinx.coroutines.b.h) ZeusTransformUtils.preCheckCast(a.a(this.f16733b), kotlinx.coroutines.b.h.class, "com.obric.aiagent.plugin"));
            m r2 = (m) ZeusTransformUtils.preCheckCast(new AnonymousClass1(a.f16730a), m.class, "com.obric.aiagent.plugin");
            d r3 = (d) ZeusTransformUtils.preCheckCast(this, d.class, "com.obric.aiagent.plugin");
            this.f16732a = 1;
            r6 = j.b(r7, r2, r3);
            if (r6 != r0) goto L11;
            return r0;
        }

        private static final /* synthetic */ Object b(C0342a r2, String r3, d r4) {
            d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r4, d.class, "com.obric.aiagent.plugin");
            return d.c.b.a.b.a(r2.a(r3));
        }
    }

    static {
        f16730a = new C0342a(null);
    }

    public a() {
        this.f16731b = kotlinx.coroutines.b.am.a(null);
    }

    public static final /* synthetic */ x a(a r0) {
        return r0.f16731b;
    }

    public final void a() {
        this.f16731b.b(null);
    }

    public final boolean a(String r2) {
        o.e(r2, "userId");
        if (f16730a.a(r2) == true) goto L6;
        return false;
    L6:
        this.f16731b.b(r2);
        return true;
    }

    public final Object a(long r5, d<? super String> r7) {
        d r8 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.aiagent.plugin");
        String r0 = (String) ZeusTransformUtils.preCheckCast(this.f16731b.c(), String.class, "com.obric.aiagent.plugin");
        if (r0 == null) goto L11;
        if (f16730a.a(r0) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L11;
        return r0;
    L11:
        return dg.b(r5, (m) ZeusTransformUtils.preCheckCast(new b(this, null), m.class, "com.obric.aiagent.plugin"), r8);
    }
}
