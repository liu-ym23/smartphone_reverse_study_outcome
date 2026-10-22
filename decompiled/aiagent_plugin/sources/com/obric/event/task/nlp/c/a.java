package com.obric.event.task.nlp.c;

import androidx.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: QueryTaskCreateMonitor.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f33013a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e<String, C0902a> f33014b = null;

    /* JADX INFO: renamed from: com.obric.event.task.nlp.c.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: QueryTaskCreateMonitor.kt */
    public static final class C0902a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final b f33015a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final b f33016b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final b f33017c;

        public C0902a() {
            this(null, null, null, 7, null);
        }

        public static /* synthetic */ C0902a a(C0902a r0, b r1, b r2, b r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.f33015a;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.f33016b;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.f33017c;
        L12:
            return r0.a(r1, r2, r3);
        }

        public final C0902a a(b r1, b r2, b r3) {
            return new C0902a(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0902a.class) == true) goto L8;
            return false;
        L8:
            C0902a r6 = (C0902a) ZeusTransformUtils.preCheckCast(r5, C0902a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f33015a, r6.f33015a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f33016b, r6.f33016b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f33017c, r6.f33017c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            b r0 = this.f33015a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            b r4 = this.f33016b;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (r3 + r5) * 31;
            b r7 = this.f33017c;
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
            return "Bucket(create=" + this.f33015a + ", update=" + this.f33016b + ", submit=" + this.f33017c + ')';
        }

        public C0902a(b r1, b r2, b r3) {
            this.f33015a = r1;
            this.f33016b = r2;
            this.f33017c = r3;
        }

        public /* synthetic */ C0902a(b r2, b r3, b r4, int r5, h r6) {
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

        public final b a() {
            return this.f33015a;
        }

        public final b b() {
            return this.f33016b;
        }

        public final b c() {
            return this.f33017c;
        }
    }

    /* JADX INFO: compiled from: QueryTaskCreateMonitor.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f33018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f33019b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f33018a == r6.f33018a) goto L12;
            return false;
        L12:
            if (o.a(this.f33019b, r6.f33019b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (Integer.hashCode(this.f33018a) * 31) + this.f33019b.hashCode();
        }

        public String toString() {
            return "StepResult(code=" + this.f33018a + ", msg=" + this.f33019b + ')';
        }

        public b(int r2, String r3) {
            o.e(r3, "msg");
            this.f33018a = r2;
            this.f33019b = r3;
        }

        public final String a() {
            return this.f33019b;
        }
    }

    private a() {
    }

    static {
        f33013a = new a();
        f33014b = new e(100);
    }

    public final void a(String r12, String r13, int r14, String r15) {
        o.e(r13, "step");
        if (r12 == null) goto L56;
        boolean r0 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r12, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L9:
        r0 = false;
    L10:
        if (r0 == true) goto L13;
        r12 = null;
    L13:
        if (r12 == null) goto L59;
        e<String, C0902a> r11 = f33014b;
        monitor-enter(r11);
        C0902a r1 = (C0902a) ZeusTransformUtils.preCheckCast(r11.a(r12), C0902a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        if (r14 != 0) goto L20;
        String r16 = "";
    L24:
        b r4 = new b(r14, r16);     // Catch: Throwable -> L53
        int r17 = r13.hashCode();     // Catch: Throwable -> L53
        if (r17 == (-891535336)) goto L44;
        if (r17 == (-838846263)) goto L38;
        if (r17 == 95844769) goto L32;
    L45:
        if (r1 != null) goto L50;
        r1 = new C0902a(null, null, null, 7, null);     // Catch: Throwable -> L53
    L50:
        C0902a r18 = (C0902a) ZeusTransformUtils.preCheckCast(r11.a(r12, r1), C0902a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L53
        monitor-exit(r11);
        return;
    L32:
        if (r13.equals("draft") == false) goto L45;
        if (r1 != null) goto L36;
        r1 = new C0902a(null, null, null, 7, null);     // Catch: Throwable -> L53
    L36:
        r1 = C0902a.a(r1, r4, null, null, 6, null);     // Catch: Throwable -> L53
        goto L50
    L38:
        if (r13.equals("update") == false) goto L45;
        if (r1 != null) goto L42;
        r1 = new C0902a(null, null, null, 7, null);     // Catch: Throwable -> L53
    L42:
        r1 = C0902a.a(r1, null, r4, null, 5, null);     // Catch: Throwable -> L53
        goto L50
    L44:
        if (r13.equals("submit") == false) goto L45;
        if (r1 != null) goto L49;
        r1 = new C0902a(null, null, null, 7, null);     // Catch: Throwable -> L53
    L49:
        r1 = C0902a.a(r1, null, null, r4, 3, null);     // Catch: Throwable -> L53
        goto L50
    L20:
        a r2 = f33013a;     // Catch: Throwable -> L53
        if (r15 != null) goto L23;
        r15 = "";
    L23:
        r16 = r2.b(r15);     // Catch: Throwable -> L53
    L53:
        th = move-exception;
        throw th;
    L59:
        return;
    L7:
        if (o.a(r12, "null") == true) goto L9;
    }

    public final C0902a a(String r3) {
        if (r3 == null) goto L23;
        boolean r1 = true;
        if ((!d.o.o.d((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.aiagent.plugin"))) == true) goto L7;
    L9:
        r1 = false;
    L10:
        if (r1 == true) goto L13;
        r3 = null;
    L13:
        if (r3 == null) goto L23;
        e<String, C0902a> r2 = f33014b;
        monitor-enter(r2);
        C0902a r4 = (C0902a) ZeusTransformUtils.preCheckCast(r2.b(r3), C0902a.class, "com.obric.aiagent.plugin");     // Catch: Throwable -> L20
        monitor-exit(r2);
        return r4;
    L20:
        th = move-exception;
        throw th;
    L7:
        if (o.a(r3, "null") == true) goto L9;
    L23:
        return null;
    }

    private final String b(String r2) {
        if (r2.length() <= 256) goto L6;
        String r3 = r2.substring(0, 256);
        o.c(r3, "substring(...)");
        return r3;
    L6:
        return r2;
    }
}
