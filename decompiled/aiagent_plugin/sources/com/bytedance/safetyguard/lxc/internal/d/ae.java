package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ActionEgressStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: ActionInterceptionController.kt */
/* JADX INFO: loaded from: classes.dex */
public interface ae {

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    public static final class a implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActionEgressStatus f10127a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10128b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f10129c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, a.class) == true) goto L8;
            return false;
        L8:
            a r10 = (a) ZeusTransformUtils.preCheckCast(r9, a.class, "com.obric.aiagent.plugin");
            if (this.f10127a == r10.f10127a) goto L12;
            return false;
        L12:
            if (this.f10128b == r10.f10128b) goto L15;
            return false;
        L15:
            if (this.f10129c == r10.f10129c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f10127a.hashCode() * 31) + Long.hashCode(this.f10128b)) * 31) + Long.hashCode(this.f10129c);
        }

        public String toString() {
            return "Allow(status=" + this.f10127a + ", activationSequence=" + this.f10128b + ", targetAttemptCount=" + this.f10129c + ')';
        }

        public a(ActionEgressStatus r2, long r3, long r5) {
            d.h.b.o.e(r2, "status");
            this.f10127a = r2;
            this.f10128b = r3;
            this.f10129c = r5;
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    public static final class b implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f10130a = null;

        static {
            f10130a = new b();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, b.class) == true) goto L9;
            return false;
        L9:
            b r2 = (b) ZeusTransformUtils.preCheckCast(r3, b.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return 1895755740;
        }

        public String toString() {
            return "AllowWithoutActiveAction";
        }

        private b() {
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    public static final class c implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ActionEgressStatus f10131a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10132b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final long f10133c;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, c.class) == true) goto L8;
            return false;
        L8:
            c r10 = (c) ZeusTransformUtils.preCheckCast(r9, c.class, "com.obric.aiagent.plugin");
            if (this.f10131a == r10.f10131a) goto L12;
            return false;
        L12:
            if (this.f10132b == r10.f10132b) goto L15;
            return false;
        L15:
            if (this.f10133c == r10.f10133c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f10131a.hashCode() * 31) + Long.hashCode(this.f10132b)) * 31) + Long.hashCode(this.f10133c);
        }

        public String toString() {
            return "Block(status=" + this.f10131a + ", activationSequence=" + this.f10132b + ", targetAttemptCount=" + this.f10133c + ')';
        }

        public c(ActionEgressStatus r2, long r3, long r5) {
            d.h.b.o.e(r2, "status");
            this.f10131a = r2;
            this.f10132b = r3;
            this.f10133c = r5;
        }

        public final ActionEgressStatus a() {
            return this.f10131a;
        }
    }

    /* JADX INFO: compiled from: ActionInterceptionController.kt */
    public static final class d implements ae {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f10134a = null;

        static {
            f10134a = new d();
        }

        public boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r3, d.class) == true) goto L9;
            return false;
        L9:
            d r2 = (d) ZeusTransformUtils.preCheckCast(r3, d.class, "com.obric.aiagent.plugin");
            return true;
        }

        public int hashCode() {
            return -1497469613;
        }

        public String toString() {
            return "BlockOrphaned";
        }

        private d() {
        }
    }
}
