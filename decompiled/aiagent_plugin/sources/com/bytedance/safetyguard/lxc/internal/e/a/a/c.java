package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.internal.e.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public interface c<P> {

    /* JADX INFO: compiled from: OAuthPollingModels.kt */
    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f10306a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10306a, r6.f10306a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10306a.hashCode();
        }

        public String toString() {
            return "FatalFailure(error=" + this.f10306a + ')';
        }

        public a(m r2) {
            o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
            this.f10306a = r2;
        }

        public final m a() {
            return this.f10306a;
        }
    }

    /* JADX INFO: compiled from: OAuthPollingModels.kt */
    public static final class b<P> implements c<P> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final P f10307a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10307a, r6.f10307a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            P r0 = this.f10307a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Response(payload=" + this.f10307a + ')';
        }

        public b(P r1) {
            this.f10307a = r1;
        }

        public final P a() {
            return this.f10307a;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.safetyguard.lxc.internal.e.a.a.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OAuthPollingModels.kt */
    public static final class C0234c implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Throwable f10308a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0234c.class) == true) goto L8;
            return false;
        L8:
            C0234c r6 = (C0234c) ZeusTransformUtils.preCheckCast(r5, C0234c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10308a, r6.f10308a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10308a.hashCode();
        }

        public String toString() {
            return "TransientFailure(cause=" + this.f10308a + ')';
        }

        public C0234c(Throwable r2) {
            o.e(r2, "cause");
            this.f10308a = r2;
        }
    }
}
