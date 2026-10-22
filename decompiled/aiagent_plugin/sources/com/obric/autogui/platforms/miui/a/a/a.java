package com.obric.autogui.platforms.miui.a.a;

import com.bytedance.apm.battery.dao.DBHelper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;

/* JADX INFO: compiled from: MiuiScanOutcome.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f29958a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f29959b;

    /* JADX INFO: renamed from: com.obric.autogui.platforms.miui.a.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MiuiScanOutcome.kt */
    public static final class C0784a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29960a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29961b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29962c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f29963d;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0784a.class) == true) goto L8;
            return false;
        L8:
            C0784a r6 = (C0784a) ZeusTransformUtils.preCheckCast(r5, C0784a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29960a, r6.f29960a) == true) goto L12;
            return false;
        L12:
            if (this.f29961b == r6.f29961b) goto L15;
            return false;
        L15:
            if (o.a(this.f29962c, r6.f29962c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f29960a.hashCode() * 31) + Boolean.hashCode(this.f29961b)) * 31) + this.f29962c.hashCode();
        }

        public String toString() {
            return "Done(packageName=" + this.f29960a + ", isVirus=" + this.f29961b + ", source=" + this.f29962c + ')';
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean a() {
            return this.f29961b;
        }

        public final String c() {
            return this.f29962c;
        }

        public C0784a(String r2, boolean r3, String r4) {
            o.e(r2, "packageName");
            o.e(r4, DBHelper.BATTERY_COL_SOURCE);
            super(r2, null);
            this.f29960a = r2;
            this.f29961b = r3;
            this.f29962c = r4;
            this.f29963d = true;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean b() {
            return this.f29963d;
        }
    }

    /* JADX INFO: compiled from: MiuiScanOutcome.kt */
    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29964a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f29965b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final boolean f29966c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29964a, r6.f29964a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f29965b, r6.f29965b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f29964a.hashCode() * 31) + this.f29965b.hashCode();
        }

        public String toString() {
            return "Error(packageName=" + this.f29964a + ", message=" + this.f29965b + ')';
        }

        public final String c() {
            return this.f29965b;
        }

        public b(String r2, String r3) {
            o.e(r2, "packageName");
            o.e(r3, "message");
            super(r2, null);
            this.f29964a = r2;
            this.f29965b = r3;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean a() {
            return this.f29966c;
        }
    }

    /* JADX INFO: compiled from: MiuiScanOutcome.kt */
    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f29968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f29969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final boolean f29970d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final boolean f29971e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29967a, r6.f29967a) == true) goto L12;
            return false;
        L12:
            if (this.f29968b == r6.f29968b) goto L15;
            return false;
        L15:
            if (o.a(this.f29969c, r6.f29969c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((this.f29967a.hashCode() * 31) + Integer.hashCode(this.f29968b)) * 31;
            String r2 = this.f29969c;
            if (r2 != null) goto L5;
            int r3 = 0;
        L7:
            return r0 + r3;
        L5:
            r3 = r2.hashCode();
            goto L7
        }

        public String toString() {
            return "FinishedNoItem(packageName=" + this.f29967a + ", code=" + this.f29968b + ", message=" + this.f29969c + ')';
        }

        public final int c() {
            return this.f29968b;
        }

        public final String d() {
            return this.f29969c;
        }

        public c(String r2, int r3, String r4) {
            o.e(r2, "packageName");
            super(r2, null);
            this.f29967a = r2;
            this.f29968b = r3;
            this.f29969c = r4;
            if (r3 != 0) goto L5;
            boolean r5 = true;
        L6:
            this.f29971e = r5;
            return;
        L5:
            r5 = false;
            goto L6
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean a() {
            return this.f29970d;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean b() {
            return this.f29971e;
        }
    }

    /* JADX INFO: compiled from: MiuiScanOutcome.kt */
    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29972a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29973b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, d.class) == true) goto L8;
            return false;
        L8:
            d r6 = (d) ZeusTransformUtils.preCheckCast(r5, d.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29972a, r6.f29972a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f29972a.hashCode();
        }

        public String toString() {
            return "NotSupported(packageName=" + this.f29972a + ')';
        }

        public d(String r2) {
            o.e(r2, "packageName");
            super(r2, null);
            this.f29972a = r2;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean a() {
            return this.f29973b;
        }
    }

    /* JADX INFO: compiled from: MiuiScanOutcome.kt */
    public static final class e extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f29974a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f29975b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f29974a, r6.f29974a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f29974a.hashCode();
        }

        public String toString() {
            return "Timeout(packageName=" + this.f29974a + ')';
        }

        public e(String r2) {
            o.e(r2, "packageName");
            super(r2, null);
            this.f29974a = r2;
        }

        @Override // com.obric.autogui.platforms.miui.a.a.a
        public boolean a() {
            return this.f29975b;
        }
    }

    public /* synthetic */ a(String r1, h r2) {
        this(r1);
    }

    public abstract boolean a();

    private a(String r1) {
        this.f29958a = r1;
    }

    public boolean b() {
        return this.f29959b;
    }
}
