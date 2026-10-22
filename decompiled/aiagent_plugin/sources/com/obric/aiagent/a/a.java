package com.obric.aiagent.a;

import com.obric.aiagent.platform.depend.IAppContext;
import com.obric.aiagent.platform.depend.ILogDepend;
import d.a.ax;
import d.a.p;
import d.n;
import d.n.m;
import d.o;
import java.util.Collection;
import java.util.Locale;
import java.util.Set;

/* JADX INFO: compiled from: AiAgentGlobalNetworkGate.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private static final String TAG = "AiAgentNetGate";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f16093a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile boolean f16094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Set<String> f16095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile Set<String> f16096d;

    /* JADX INFO: renamed from: com.obric.aiagent.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AiAgentGlobalNetworkGate.kt */
    public static final enum EnumC0324a extends Enum<EnumC0324a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final EnumC0324a f16097a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final EnumC0324a f16098b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final EnumC0324a f16099c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ EnumC0324a[] f16100d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f16101e = null;

        private static final /* synthetic */ EnumC0324a[] a() {
            return new EnumC0324a[]{f16097a, f16098b, f16099c};
        }

        static {
            f16097a = new EnumC0324a("ALLOW", 0);
            f16098b = new EnumC0324a("BLOCK_DROP", 1);
            f16099c = new EnumC0324a("BLOCK_DELAY", 2);
            EnumC0324a[] r0 = a();
            f16100d = r0;
            f16101e = d.d.b.a(r0);
        }

        private EnumC0324a(String r1, int r2) {
            super(r1, r2);
        }

        public static EnumC0324a valueOf(String r1) {
            return (EnumC0324a) Enum.valueOf(EnumC0324a.class, r1);
        }

        public static EnumC0324a[] values() {
            return (EnumC0324a[]) f16100d.clone();
        }
    }

    /* JADX INFO: renamed from: lambda$ECwAZC4-Zwuq4WBhBgagpIbVQmk, reason: not valid java name */
    public static /* synthetic */ boolean m114lambda$ECwAZC4Zwuq4WBhBgagpIbVQmk(String r0) {
        return f(r0);
    }

    public static /* synthetic */ boolean lambda$dALWPAGqwAf1MWdWlG4gek0Q_Vs(String r0) {
        return d(r0);
    }

    public static /* synthetic */ String lambda$eJtXc8onObYFoq1kIo63yhIVdVY(String r0) {
        return c(r0);
    }

    public static /* synthetic */ String lambda$kVVOpNaHv3JHdKkLxbKPJA5bjVc(String r0) {
        return e(r0);
    }

    private a() {
    }

    static {
        f16093a = new a();
        f16094b = true;
        f16095c = ax.b();
        f16096d = ax.a("faas/services/ttsqtr/invoke/push_event_batch");
    }

    public static final EnumC0324a a(String r5, String r6) {
        a r0 = f16093a;
        if (r0.b() == false) goto L6;
        ILogDepend.Companion.d(TAG, "decide host=" + r5 + " path=" + r6 + " enable=" + f16094b + " hostWhitelist=" + f16095c + " pathWhitelist=" + f16096d);
    L6:
        if (f16094b == false) goto L8;
        String r1 = r5;
        boolean r2 = false;
        if (r1 != null) goto L12;
    L15:
        boolean r3 = true;
    L16:
        if (r3 == true) goto L18;
        if (r5 == null) goto L39;
        int r4 = r5.hashCode();
        if (r4 == (-1204607085)) goto L34;
        if (r4 == 57585) goto L31;
        if (r4 != 1505998205) goto L39;
        if (r5.equals("127.0.0.1") == false) goto L39;
    L37:
        return EnumC0324a.f16097a;
    L31:
        if (r5.equals("::1") == true) goto L37;
    L34:
        if (r5.equals("localhost") == true) goto L37;
    L39:
        if ((!f16095c.isEmpty()) == true) goto L41;
    L44:
        String r7 = r6;
        if (r7 != null) goto L47;
    L48:
        r2 = true;
    L49:
        if (r2 == true) goto L57;
        if ((!f16096d.isEmpty()) == false) goto L57;
        if (f16096d.contains(r0.b(r6)) == false) goto L57;
        return EnumC0324a.f16097a;
    L57:
        if (r0.a() == false) goto L61;
        return EnumC0324a.f16098b;
    L61:
        return EnumC0324a.f16097a;
    L47:
        if (r7.length() != 0) goto L49;
    L41:
        if (f16095c.contains(r0.a(r5)) == false) goto L44;
        return EnumC0324a.f16097a;
    L18:
        return EnumC0324a.f16097a;
    L12:
        if (r1.length() == 0) goto L15;
        r3 = false;
        goto L16
    L8:
        return EnumC0324a.f16097a;
    }

    private final boolean a() {
        n.a r0 = n.f38560a;     // Catch: Throwable -> L4
        a r1 = this;     // Catch: Throwable -> L4
        Object r2 = n.f(Boolean.valueOf(com.obric.aiagent.ttnet.a.f22195a.b()));     // Catch: Throwable -> L4
    L7:
        if (n.c(r2) == null) goto L11;
        r2 = false;
    L11:
        return ((Boolean) r2).booleanValue();
    L4:
        th = move-exception;
        n.a r3 = n.f38560a;
        r2 = n.f(o.a(th));
        goto L7
    }

    public static final void a(Collection<String> r1) {
        d.h.b.o.e(r1, "hosts");
        Set r2 = m.i(m.a(m.d(p.y(r1), $$Lambda$a$eJtXc8onObYFoq1kIo63yhIVdVY.INSTANCE), $$Lambda$a$dALWPAGqwAf1MWdWlG4gek0Q_Vs.INSTANCE));
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        f16095c = ax.b(f16095c, r2);
    }

    private static final String c(String r1) {
        d.h.b.o.e(r1, "it");
        return f16093a.a(r1);
    }

    private static final boolean d(String r1) {
        d.h.b.o.e(r1, "it");
        if (r1.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static final void b(Collection<String> r1) {
        d.h.b.o.e(r1, "paths");
        Set r2 = m.i(m.a(m.d(p.y(r1), $$Lambda$a$kVVOpNaHv3JHdKkLxbKPJA5bjVc.INSTANCE), $$Lambda$a$ECwAZC4Zwuq4WBhBgagpIbVQmk.INSTANCE));
        if (r2.isEmpty() == false) goto L5;
        return;
    L5:
        f16096d = ax.b(f16096d, r2);
    }

    private static final String e(String r1) {
        d.h.b.o.e(r1, "it");
        return f16093a.b(r1);
    }

    private static final boolean f(String r1) {
        d.h.b.o.e(r1, "it");
        if (r1.length() <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final String a(String r3) {
        String r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L12;
        return "";
    L12:
        String r2 = d.o.o.a(d.o.o.a(r4).toString(), new char[]{'/'}).toLowerCase(Locale.ROOT);
        d.h.b.o.c(r2, "toLowerCase(...)");
        return r2;
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    private final String b(String r3) {
        String r4 = r3;
        if (r4 != null) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == false) goto L13;
        return "";
    L13:
        return d.o.o.a(d.o.o.a(r4).toString(), new char[]{'/'});
    L5:
        if (r4.length() == 0) goto L8;
        r1 = false;
        goto L9
    }

    public static final void a(EnumC0324a r4, String r5, String r6) {
        d.h.b.o.e(r4, "decision");
        if (r4 != EnumC0324a.f16097a) goto L13;
        return;
    L13:
        if (f16093a.b() == false) goto L9;
        ILogDepend.Companion.i(TAG, "decision=" + r4 + " host=" + r5 + " path=" + r6);     // Catch: Throwable -> L11
    L12:
        return;
    L9:
        ILogDepend.Companion.i(TAG, "decision=" + r4);     // Catch: Throwable -> L11
    }

    private final boolean b() {
        if (IAppContext.Companion.isDebug() == true) goto L5;
        return false;
    L5:
        return true;
    }
}
