package com.obric.aiagent.skill.ovirt.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: IOVirtService.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class h {

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final f f21002a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f21003b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f21004c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f21002a == r6.f21002a) goto L12;
            return false;
        L12:
            if (o.a(this.f21003b, r6.f21003b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f21004c, r6.f21004c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f21002a.hashCode() * 31;
            String r1 = this.f21003b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + this.f21004c.hashCode();
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "Failure(reason=" + this.f21002a + ", message=" + this.f21003b + ", metrics=" + this.f21004c + ')';
        }

        public final f a() {
            return this.f21002a;
        }

        public final String b() {
            return this.f21003b;
        }

        public final g c() {
            return this.f21004c;
        }

        public a(f r2, String r3, g r4) {
            o.e(r2, "reason");
            o.e(r4, "metrics");
            super(null);
            this.f21002a = r2;
            this.f21003b = r3;
            this.f21004c = r4;
        }
    }

    /* JADX INFO: compiled from: IOVirtService.kt */
    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f21005a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f21006b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final g f21007c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f21005a, r6.f21005a) == true) goto L12;
            return false;
        L12:
            if (this.f21006b == r6.f21006b) goto L15;
            return false;
        L15:
            if (o.a(this.f21007c, r6.f21007c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f21005a.hashCode() * 31) + Boolean.hashCode(this.f21006b)) * 31) + this.f21007c.hashCode();
        }

        public String toString() {
            return "Success(uniqueId=" + this.f21005a + ", reused=" + this.f21006b + ", metrics=" + this.f21007c + ')';
        }

        public final boolean a() {
            return this.f21006b;
        }

        public final g b() {
            return this.f21007c;
        }

        public b(String r2, boolean r3, g r4) {
            o.e(r2, "uniqueId");
            o.e(r4, "metrics");
            super(null);
            this.f21005a = r2;
            this.f21006b = r3;
            this.f21007c = r4;
        }
    }

    public /* synthetic */ h(d.h.b.h r1) {
        this();
    }

    private h() {
    }
}
