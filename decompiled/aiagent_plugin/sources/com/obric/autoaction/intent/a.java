package com.obric.autoaction.intent;

import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import d.k;
import d.n;
import org.json.JSONObject;

/* JADX INFO: compiled from: GUIEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.obric.autoaction.intent.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GUIEventListener.kt */
    public static final class C0572a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Integer f24721a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f24722b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f24723c;

        public C0572a() {
            this(null, null, null, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0572a.class) == true) goto L8;
            return false;
        L8:
            C0572a r6 = (C0572a) ZeusTransformUtils.preCheckCast(r5, C0572a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24721a, r6.f24721a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f24722b, r6.f24722b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f24723c, r6.f24723c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Integer r0 = this.f24721a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.f24722b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.f24723c;
            if (r7 == null) goto L15;
            r1 = r7.hashCode();
        L15:
            return r6 + r1;
        L9:
            r5 = r4.hashCode();
            goto L10
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "Operating(operateType=" + this.f24721a + ", thought=" + this.f24722b + ", action=" + this.f24723c + ')';
        }

        public /* synthetic */ C0572a(Integer r2, String r3, String r4, int r5, h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = null;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = null;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = null;
        L11:
            this(r2, r3, r4);
        }

        public final Integer b() {
            return this.f24721a;
        }

        public final String c() {
            return this.f24722b;
        }

        public final String d() {
            return this.f24723c;
        }

        public C0572a(Integer r2, String r3, String r4) {
            super(null);
            this.f24721a = r2;
            this.f24722b = r3;
            this.f24723c = r4;
        }
    }

    /* JADX INFO: compiled from: GUIEventListener.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f24724a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f24724a == r6.f24724a) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return Integer.hashCode(this.f24724a);
        }

        public String toString() {
            return "Paused(pauseReason=" + this.f24724a + ')';
        }

        public final int b() {
            return this.f24724a;
        }

        public b(int r2) {
            super(null);
            this.f24724a = r2;
        }
    }

    /* JADX INFO: compiled from: GUIEventListener.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f24725a = null;

        static {
            f24725a = new c();
        }

        private c() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GUIEventListener.kt */
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f24726a = null;

        static {
            f24726a = new d();
        }

        private d() {
            super(null);
        }
    }

    /* JADX INFO: compiled from: GUIEventListener.kt */
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f24727a = null;

        static {
            f24727a = new e();
        }

        private e() {
            super(null);
        }
    }

    public /* synthetic */ a(h r1) {
        this();
    }

    private a() {
    }

    public final String a() {
        n.a r1 = n.f38560a;     // Catch: Throwable -> L27
        a r2 = (a) ZeusTransformUtils.preCheckCast(this, a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L27
        JSONObject r3 = new JSONObject();     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(this, c.class) == false) goto L7;
        String r4 = "PREPARING";
    L18:
        r3.put("status", r4);     // Catch: Throwable -> L27
        if (ZeusTransformUtils.instanceOf(this, C0572a.class) == false) goto L22;
        r3.put("operate_type", ((C0572a) ZeusTransformUtils.preCheckCast(this, C0572a.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L27
        r3.put(VDPlayerEffectProviderImpl.KEY_THOUGHT, ((C0572a) ZeusTransformUtils.preCheckCast(this, C0572a.class, "com.obric.aiagent.plugin")).c());     // Catch: Throwable -> L27
        r3.put("action", ((C0572a) ZeusTransformUtils.preCheckCast(this, C0572a.class, "com.obric.aiagent.plugin")).d());     // Catch: Throwable -> L27
    L22:
        if (ZeusTransformUtils.instanceOf(this, b.class) == false) goto L24;
        r3.put("pause_reason", ((b) ZeusTransformUtils.preCheckCast(this, b.class, "com.obric.aiagent.plugin")).b());     // Catch: Throwable -> L27
    L24:
        Object r5 = n.f(r3.toString());     // Catch: Throwable -> L27
    L30:
        if (n.b(r5) == false) goto L33;
        r5 = null;
    L33:
        return (String) ZeusTransformUtils.preCheckCast(r5, String.class, "com.obric.aiagent.plugin");
    L7:
        if (ZeusTransformUtils.instanceOf(this, d.class) == false) goto L10;
        r4 = "QUEUE";
        goto L18
    L10:
        if (ZeusTransformUtils.instanceOf(this, C0572a.class) == false) goto L13;
        r4 = "OPERATING";
        goto L18
    L13:
        if (ZeusTransformUtils.instanceOf(this, b.class) == false) goto L16;
        r4 = "PAUSED";
        goto L18
    L16:
        if (ZeusTransformUtils.instanceOf(this, e.class) == false) goto L26;
        r4 = "USER_INTERRUPTED";
        goto L18
    L26:
        throw new k();     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        n.a r6 = n.f38560a;
        r5 = n.f(d.o.a(th));
        goto L30
    }
}
