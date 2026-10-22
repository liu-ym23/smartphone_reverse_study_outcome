package com.bytedance.safetyguard.lxc.internal.d;

import com.bytedance.common.wschannel.WsConstants;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: compiled from: AppGatewayProxySession.kt */
/* JADX INFO: loaded from: classes.dex */
interface h {

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Exception f10232a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f10232a, r6.f10232a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10232a.hashCode();
        }

        public String toString() {
            return "Failed(error=" + this.f10232a + ')';
        }

        public a(Exception r2) {
            d.h.b.o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
            this.f10232a = r2;
        }

        public final Exception a() {
            return this.f10232a;
        }
    }

    /* JADX INFO: compiled from: AppGatewayProxySession.kt */
    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.c.f f10233a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (d.h.b.o.a(this.f10233a, r6.f10233a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            com.bytedance.safetyguard.lxc.internal.c.f r0 = this.f10233a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Frame(value=" + this.f10233a + ')';
        }

        public b(com.bytedance.safetyguard.lxc.internal.c.f r1) {
            this.f10233a = r1;
        }

        public final com.bytedance.safetyguard.lxc.internal.c.f a() {
            return this.f10233a;
        }
    }
}
