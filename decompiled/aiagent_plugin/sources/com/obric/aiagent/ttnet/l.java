package com.obric.aiagent.ttnet;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: ITTNetFileTransfer.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l {

    /* JADX INFO: compiled from: ITTNetFileTransfer.kt */
    public static final class a extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final k f22281a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Integer f22282b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22283c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f22281a == r6.f22281a) goto L12;
            return false;
        L12:
            if (o.a(this.f22282b, r6.f22282b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f22283c, r6.f22283c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = this.f22281a.hashCode() * 31;
            Integer r1 = this.f22282b;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (r0 + r3) * 31;
            String r5 = this.f22283c;
            if (r5 == null) goto L11;
            r2 = r5.hashCode();
        L11:
            return r4 + r2;
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            return "Failure(reason=" + this.f22281a + ", httpCode=" + this.f22282b + ", ttLogId=" + this.f22283c + ')';
        }

        public final k a() {
            return this.f22281a;
        }

        public final Integer b() {
            return this.f22282b;
        }

        public a(k r2, Integer r3, String r4) {
            o.e(r2, "reason");
            super(null);
            this.f22281a = r2;
            this.f22282b = r3;
            this.f22283c = r4;
        }
    }

    /* JADX INFO: compiled from: ITTNetFileTransfer.kt */
    public static final class b extends l {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f22284a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f22285b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f22286c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (this.f22284a == r10.f22284a) goto L12;
            return false;
        L12:
            if (this.f22285b == r10.f22285b) goto L15;
            return false;
        L15:
            if (o.a(this.f22286c, r10.f22286c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            int r0 = ((Integer.hashCode(this.f22284a) * 31) + Long.hashCode(this.f22285b)) * 31;
            String r3 = this.f22286c;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r0 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public String toString() {
            return "Success(httpCode=" + this.f22284a + ", transferredBytes=" + this.f22285b + ", ttLogId=" + this.f22286c + ')';
        }

        public final int a() {
            return this.f22284a;
        }

        public final long b() {
            return this.f22285b;
        }

        public final String c() {
            return this.f22286c;
        }

        public b(int r2, long r3, String r5) {
            super(null);
            this.f22284a = r2;
            this.f22285b = r3;
            this.f22286c = r5;
        }
    }

    public /* synthetic */ l(d.h.b.h r1) {
        this();
    }

    private l() {
    }
}
