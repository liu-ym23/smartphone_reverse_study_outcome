package com.obric.autogui.session.state;

import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.livecard.api.impl.IslandImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ax;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.x;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f31399a = null;
    private static final Set<String> h = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d.h.a.b<String, x> f31400b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d.h.a.b<String, Boolean> f31401c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Map<String, b> f31402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LinkedHashSet<String> f31403e;
    private String f;
    private String g;

    /* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
    private static final class a {
        public /* synthetic */ a(h r1) {
            this();
        }

        private a() {
        }
    }

    /* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
    private static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BizStatus f31404a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f31405b;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f31404a == r6.f31404a) goto L12;
            return false;
        L12:
            if (o.a(this.f31405b, r6.f31405b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            BizStatus r0 = this.f31404a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f31405b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SessionState(bizStatus=" + this.f31404a + ", targetPackage=" + this.f31405b + ')';
        }

        public b(BizStatus r1, String r2) {
            this.f31404a = r1;
            this.f31405b = r2;
        }

        public /* synthetic */ b(BizStatus r2, String r3, int r4, h r5) {
            if ((r4 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }

        public final BizStatus a() {
            return this.f31404a;
        }

        public final void a(BizStatus r1) {
            this.f31404a = r1;
        }

        public final void a(String r1) {
            this.f31405b = r1;
        }

        public final String b() {
            return this.f31405b;
        }
    }

    /* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
    private static abstract class c {

        /* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
        public static final class a extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f31406a = null;

            static {
                f31406a = new a();
            }

            private a() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
        public static final class b extends c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final String f31407a;

            public boolean equals(Object r5) {
                if (this != r5) goto L6;
                return true;
            L6:
                if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
                return false;
            L8:
                b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
                if (o.a(this.f31407a, r6.f31407a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public int hashCode() {
                String r0 = this.f31407a;
                if (r0 != null) goto L6;
                return 0;
            L6:
                return r0.hashCode();
            }

            public String toString() {
                return "Set(packageName=" + this.f31407a + ')';
            }

            public b(String r2) {
                super(null);
                this.f31407a = r2;
            }

            public final String a() {
                return this.f31407a;
            }
        }

        public /* synthetic */ c(h r1) {
            this();
        }

        private c() {
        }
    }

    /* JADX INFO: compiled from: AgentOperationStateCoordinator.kt */
    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f31408a = null;

        static {
            int[] r0 = new int[BizStatus.values().length];
            r0[BizStatus.OPERATING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r0[BizStatus.TERMINATED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r0[BizStatus.IDLE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f31408a = r0;
        }
    }

    public f(d.h.a.b<? super String, x> r3, d.h.a.b<? super String, Boolean> r4) {
        d.h.a.b<String, x> r5 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r3, d.h.a.b.class, "com.obric.aiagent.plugin");
        d.h.a.b<String, Boolean> r6 = (d.h.a.b) ZeusTransformUtils.wrapperContextForParams(r4, d.h.a.b.class, "com.obric.aiagent.plugin");
        o.e(r5, "onDesiredTargetChanged");
        o.e(r6, "isCurrentSession");
        this.f31400b = r5;
        this.f31401c = r6;
        this.f31402d = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
        this.f31403e = new LinkedHashSet();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void a(String r5, BizStatus r6) {
        monitor-enter(this);
        o.e(r5, "sessionKey");     // Catch: Throwable -> L32
        o.e(r6, "status");     // Catch: Throwable -> L32
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
    L30:
        monitor-exit(this);
        return;
    L6:
        if (this.f31403e.contains(r5) == true) goto L30;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f31401c.invoke(r5), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L30;
        Map<String, b> r0 = this.f31402d;     // Catch: Throwable -> L32
        b r1 = r0.get(r5);     // Catch: Throwable -> L32
        int r2 = 3;
        if (r1 != null) goto L13;
        r1 = new b(null, 0 == true ? 1 : 0, r2, 0 == true ? 1 : 0);     // Catch: Throwable -> L32
        r0.put(r5, r1);     // Catch: Throwable -> L32
    L13:
        ((b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin")).a(r6);     // Catch: Throwable -> L32
        int r7 = d.f31408a[r6.ordinal()];     // Catch: Throwable -> L32
        if (r7 != 1) goto L16;
        String r8 = this.f;     // Catch: Throwable -> L32
        if (r8 != null) goto L25;
    L27:
        this.f = r5;     // Catch: Throwable -> L32
        a();     // Catch: Throwable -> L32
    L28:
        monitor-exit(this);
        return;
    L25:
        if (o.a(r8, r5) == true) goto L27;
        c(r8);     // Catch: Throwable -> L32
        goto L27
    L16:
        if (r7 == 2) goto L21;
        if (r7 == 3) goto L21;
        if (o.a(this.f, r5) == false) goto L28;
        a();     // Catch: Throwable -> L32
    L21:
        a(r5);     // Catch: Throwable -> L32
    L32:
        th = move-exception;
        throw th;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final synchronized void a(String r5, String r6) {
        monitor-enter(this);
        o.e(r5, "sessionKey");     // Catch: Throwable -> L28
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
    L26:
        monitor-exit(this);
        return;
    L6:
        if (this.f31403e.contains(r5) == true) goto L26;
        if (((Boolean) ZeusTransformUtils.preCheckCast(this.f31401c.invoke(r5), Boolean.class, "com.obric.aiagent.plugin")).booleanValue() == false) goto L26;
        Map<String, b> r0 = this.f31402d;     // Catch: Throwable -> L28
        b r1 = r0.get(r5);     // Catch: Throwable -> L28
        if (r1 != null) goto L13;
        BizStatus r3 = null;
        Object[] r4 = 0 == true ? 1 : 0;
        r1 = new b(r3, r4, 3, 0 == true ? 1 : 0);     // Catch: Throwable -> L28
        r0.put(r5, r1);     // Catch: Throwable -> L28
    L13:
        b r2 = (b) ZeusTransformUtils.preCheckCast(r1, b.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L28
        c r7 = d(r6);     // Catch: Throwable -> L28
        if (o.a(r7, c.a.f31406a) == false) goto L18;
        monitor-exit(this);
        return;
    L18:
        if (ZeusTransformUtils.instanceOf(r7, c.b.class) == false) goto L25;
        r2.a(((c.b) ZeusTransformUtils.preCheckCast(r7, c.b.class, "com.obric.aiagent.plugin")).a());     // Catch: Throwable -> L28
        if (o.a(this.f, r5) == false) goto L22;
        a();     // Catch: Throwable -> L28
    L22:
        monitor-exit(this);
        return;
    L25:
        throw new k();     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        throw th;
    }

    public final synchronized void a(String r3) {
        monitor-enter(this);
        o.e(r3, "sessionKey");     // Catch: Throwable -> L16
        if (d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")) == false) goto L6;
    L14:
        monitor-exit(this);
        return;
    L6:
        if (this.f31403e.contains(r3) == true) goto L14;
        if (o.a(this.f, r3) == false) goto L11;
        b(null);     // Catch: Throwable -> L16
        this.f = null;     // Catch: Throwable -> L16
    L11:
        c(r3);     // Catch: Throwable -> L16
        monitor-exit(this);
        return;
    L16:
        th = move-exception;
        throw th;
    }

    private final void a() {
        String r0 = this.f;
        String r1 = null;
        if (r0 == null) goto L5;
        b r2 = (b) ZeusTransformUtils.preCheckCast(this.f31402d.get(r0), b.class, "com.obric.aiagent.plugin");
    L6:
        if (r2 != null) goto L8;
    L16:
        b(r1);
        return;
    L8:
        if (r2.a() != BizStatus.OPERATING) goto L10;
        boolean r3 = true;
    L11:
        if (r3 == true) goto L14;
        r2 = null;
    L14:
        if (r2 == null) goto L16;
        r1 = r2.b();
        goto L16
    L10:
        r3 = false;
        goto L11
    L5:
        r2 = null;
        goto L6
    }

    private final void b(String r2) {
        if (o.a(this.g, r2) == false) goto L5;
        return;
    L5:
        this.g = r2;
        this.f31400b.invoke(r2);
    }

    private final void c(String r2) {
        this.f31402d.remove(r2);
        this.f31403e.add(r2);
    L4:
        if (this.f31403e.size() <= 64) goto L9;
        Iterator<String> r3 = this.f31403e.iterator();
        o.c(r3, "iterator(...)");
        if (r3.hasNext() == false) goto L12;
        r3.next();
        r3.remove();
        goto L4
    L12:
        return;
    }

    private final c d(String r3) {
        if (r3 == null) goto L27;
        String r4 = d.o.o.a((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin")).toString();
        if (r4 == null) goto L27;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.aiagent.plugin")).length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == true) goto L13;
        r4 = null;
    L13:
        if (r4 == null) goto L27;
        if (o.a(r4, "com.android.permissioncontroller") == true) goto L25;
        if (o.a(r4, "com.android.virtualdevicemanager") == true) goto L25;
        if (h.contains(r4) == false) goto L29;
        return (c) ZeusTransformUtils.preCheckCast(new c.b(null), c.class, "com.obric.aiagent.plugin");
    L29:
        return (c) ZeusTransformUtils.preCheckCast(new c.b(r4), c.class, "com.obric.aiagent.plugin");
    L25:
        return (c) ZeusTransformUtils.preCheckCast(c.a.f31406a, c.class, "com.obric.aiagent.plugin");
    L9:
        r1 = false;
    L27:
        return (c) ZeusTransformUtils.preCheckCast(new c.b(null), c.class, "com.obric.aiagent.plugin");
    }

    static {
        f31399a = new a(null);
        h = ax.a(new String[]{"com.android.launcher3", "com.miui.home", IslandImpl.LIVE_CARD_HOST});
    }
}
