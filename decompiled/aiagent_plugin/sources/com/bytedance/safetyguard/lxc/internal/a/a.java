package com.bytedance.safetyguard.lxc.internal.a;

import android.content.Context;
import android.util.Log;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.g;
import d.h.b.h;
import d.h.b.o;
import d.h.b.p;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: SafetyGuardLogger.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0222a f9703a = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final d.f<byte[]> f9704d = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9705b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final byte[] f9706c;

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: SafetyGuardLogger.kt */
    public static final class C0222a {
        public /* synthetic */ C0222a(h r1) {
            this();
        }

        private C0222a() {
        }

        public final a a(Context r3) {
            Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            o.e(r4, "context");
            if ((((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r4.getApplicationContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin")).getApplicationInfo().flags & 2) == 0) goto L5;
            boolean r5 = true;
        L7:
            return new a(r5, c(), null);
        L5:
            r5 = false;
            goto L7
        }

        public final a a() {
            boolean r1 = false;
            return new a(r1, c(), null);
        }

        private final byte[] b() {
            return (byte[]) ZeusTransformUtils.preCheckCast(a.a().b(), byte[].class, "com.obric.aiagent.plugin");
        }

        private final byte[] c() {
            byte[] r1 = b();
            byte[] r2 = Arrays.copyOf(r1, r1.length);
            o.c(r2, "copyOf(...)");
            return r2;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardLogger.kt */
    static final class b extends p implements d.h.a.a<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f9707a = null;

        static {
            f9707a = new b();
        }

        b() {
            super(0);
        }

        @Override // d.h.a.a
        public /* synthetic */ byte[] invoke() {
            return a();
        }

        public final byte[] a() {
            byte[] r1 = new byte[16];
            new SecureRandom().nextBytes(r1);
            return r1;
        }
    }

    /* JADX INFO: compiled from: SafetyGuardLogger.kt */
    static final class c extends p implements d.h.a.b<Byte, CharSequence> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f9708a = null;

        static {
            f9708a = new c();
        }

        c() {
            super(1);
        }

        public final CharSequence a(byte r3) {
            String r2 = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r3)}, 1));
            o.c(r2, "format(...)");
            return (CharSequence) ZeusTransformUtils.preCheckCast(r2, CharSequence.class, "com.obric.aiagent.plugin");
        }

        @Override // d.h.a.b
        public /* synthetic */ CharSequence invoke(Byte r3) {
            return a(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).byteValue());
        }
    }

    public /* synthetic */ a(boolean r1, byte[] r2, h r3) {
        this(r1, r2);
    }

    private a(boolean r1, byte[] r2) {
        this.f9705b = r1;
        this.f9706c = r2;
    }

    public static final /* synthetic */ d.f a() {
        return f9704d;
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void a(String r3, d.h.a.a<String> r4) {
        d.h.a.a r5 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r5, "message");
        String r6 = f.a(r3);
        if (b(r6) == true) goto L10;
        return;
    L10:
        a(r6, com.bytedance.safetyguard.lxc.internal.a.c.a((String) ZeusTransformUtils.preCheckCast(r5.invoke(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void b(String r2, d.h.a.a<String> r3) {
        d.h.a.a r1 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r2, "tag");
        o.e(r1, "message");
        String r4 = f.a(r2);
        b(r4, com.bytedance.safetyguard.lxc.internal.a.c.a((String) ZeusTransformUtils.preCheckCast(r1.invoke(), String.class, "com.obric.aiagent.plugin")));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void a(String r3, Throwable r4, d.h.a.a<String> r5) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r2, "message");
        c(f.a(r3), com.bytedance.safetyguard.lxc.internal.a.c.a(((String) ZeusTransformUtils.preCheckCast(r2.invoke(), String.class, "com.obric.aiagent.plugin")) + com.bytedance.safetyguard.lxc.internal.a.c.b(r4)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public void b(String r3, Throwable r4, d.h.a.a<String> r5) {
        d.h.a.a r2 = (d.h.a.a) ZeusTransformUtils.wrapperContextForParams(r5, d.h.a.a.class, "com.obric.aiagent.plugin");
        o.e(r3, "tag");
        o.e(r2, "message");
        d(f.a(r3), com.bytedance.safetyguard.lxc.internal.a.c.a(((String) ZeusTransformUtils.preCheckCast(r2.invoke(), String.class, "com.obric.aiagent.plugin")) + com.bytedance.safetyguard.lxc.internal.a.c.b(r4)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        com.bytedance.safetyguard.lxc.internal.a.c.a(th);
    }

    @Override // com.bytedance.safetyguard.lxc.internal.a.e
    public String a(String r13) {
        if (r13 != null) goto L6;
        r13 = "";
    L6:
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r13, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L9;
        return "empty";
    L9:
        MessageDigest r1 = MessageDigest.getInstance("SHA-256");
        r1.update(this.f9706c);
        byte[] r12 = r13.getBytes(d.o.d.f38623b);
        o.c(r12, "getBytes(...)");
        r1.update(r12);
        byte[] r3 = r1.digest();
        o.c(r3, "digest(...)");
        return d.o.o.e(i.a(r3, (CharSequence) ZeusTransformUtils.preCheckCast("", CharSequence.class, "com.obric.aiagent.plugin"), null, null, 0, null, (d.h.a.b) ZeusTransformUtils.preCheckCast(c.f9708a, d.h.a.b.class, "com.obric.aiagent.plugin"), 30, null), 8);
    }

    private final boolean b(String r1) {
        if (this.f9705b == false) goto L5;
    L10:
        return true;
    L5:
        if (a(r1, 3) == true) goto L10;
        if (a("SafetyGuard", 3) == true) goto L10;
        return false;
    }

    static {
        f9703a = new C0222a(null);
        f9704d = g.a((d.h.a.a) ZeusTransformUtils.preCheckCast(b.f9707a, d.h.a.a.class, "com.obric.aiagent.plugin"));
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static boolean a(String r1, int r2) {
        if (com.obric.aiagent.apm.impl.a.a() == true) goto L7;
        return Log.isLoggable(r1, r2);
    L7:
        if (r2 == 6) goto L9;
    L11:
        return false;
    L9:
        if (Log.isLoggable(r1, r2) == false) goto L11;
        return true;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int c(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.w(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int d(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
