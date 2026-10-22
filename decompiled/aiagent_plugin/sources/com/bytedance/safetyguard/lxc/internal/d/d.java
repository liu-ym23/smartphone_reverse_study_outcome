package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.safetyguard.lxc.api.ProxySessionErrorCode;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppGatewayProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
public interface d {

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ProxySessionErrorCode f10187a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f10188b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (this.f10187a == r6.f10187a) goto L12;
            return false;
        L12:
            if (d.h.b.o.a(this.f10188b, r6.f10188b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f10187a.hashCode() * 31) + this.f10188b.hashCode();
        }

        public String toString() {
            return "Failed(errorCode=" + this.f10187a + ", message=" + this.f10188b + ')';
        }

        public a(ProxySessionErrorCode r2, String r3) {
            d.h.b.o.e(r2, "errorCode");
            d.h.b.o.e(r3, "message");
            this.f10187a = r2;
            this.f10188b = r3;
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f10189a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final long f10190b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f10191c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final int f10192d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f10193e;

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, b.class) == true) goto L8;
            return false;
        L8:
            b r10 = (b) ZeusTransformUtils.preCheckCast(r9, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f10189a, r10.f10189a) == true) goto L12;
            return false;
        L12:
            if (this.f10190b == r10.f10190b) goto L15;
            return false;
        L15:
            if (this.f10191c == r10.f10191c) goto L18;
            return false;
        L18:
            if (this.f10192d == r10.f10192d) goto L21;
            return false;
        L21:
            if (this.f10193e == r10.f10193e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            return (((((((this.f10189a.hashCode() * 31) + Long.hashCode(this.f10190b)) * 31) + Integer.hashCode(this.f10191c)) * 31) + Integer.hashCode(this.f10192d)) * 31) + Integer.hashCode(this.f10193e);
        }

        public String toString() {
            return "Ready(sessionId=" + this.f10189a + ", acceptedFeatureBitmap=" + this.f10190b + ", maxFramePayload=" + this.f10191c + ", dataChunkSize=" + this.f10192d + ", streamWindow=" + this.f10193e + ')';
        }

        public b(String r2, long r3, int r5, int r6, int r7) {
            d.h.b.o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            this.f10189a = r2;
            this.f10190b = r3;
            this.f10191c = r5;
            this.f10192d = r6;
            this.f10193e = r7;
        }

        public final String a() {
            return this.f10189a;
        }

        public final long b() {
            return this.f10190b;
        }

        public final int c() {
            return this.f10191c;
        }

        public final int d() {
            return this.f10192d;
        }

        public final int e() {
            return this.f10193e;
        }
    }
}
