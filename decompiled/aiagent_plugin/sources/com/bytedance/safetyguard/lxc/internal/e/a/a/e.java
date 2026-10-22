package com.bytedance.safetyguard.lxc.internal.e.a.a;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.safetyguard.lxc.internal.e.a.m;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OAuthPollingModels.kt */
/* JADX INFO: loaded from: classes.dex */
public interface e<S, R> {

    /* JADX INFO: compiled from: OAuthPollingModels.kt */
    public static final class a<R> implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final R f10314a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10314a, r6.f10314a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            R r0 = this.f10314a;
            if (r0 != null) goto L6;
            return 0;
        L6:
            return r0.hashCode();
        }

        public String toString() {
            return "Complete(result=" + this.f10314a + ')';
        }

        public a(R r1) {
            this.f10314a = r1;
        }

        public final R a() {
            return this.f10314a;
        }
    }

    /* JADX INFO: compiled from: OAuthPollingModels.kt */
    public static final class b<S> implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final S f10315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final com.bytedance.safetyguard.lxc.internal.e.a.a.b f10316b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10315a, r6.f10315a) == true) goto L12;
            return false;
        L12:
            if (this.f10316b == r6.f10316b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            S r0 = this.f10315a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + this.f10316b.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "Continue(state=" + this.f10315a + ", timing=" + this.f10316b + ')';
        }

        public b(S r2, com.bytedance.safetyguard.lxc.internal.e.a.a.b r3) {
            o.e(r3, "timing");
            this.f10315a = r2;
            this.f10316b = r3;
        }

        public final S a() {
            return this.f10315a;
        }

        public final com.bytedance.safetyguard.lxc.internal.e.a.a.b b() {
            return this.f10316b;
        }
    }

    /* JADX INFO: compiled from: OAuthPollingModels.kt */
    public static final class c implements e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final m f10317a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f10317a, r6.f10317a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f10317a.hashCode();
        }

        public String toString() {
            return "Fail(error=" + this.f10317a + ')';
        }

        public c(m r2) {
            o.e(r2, WsConstants.KEY_CONNECTION_ERROR);
            this.f10317a = r2;
        }

        public final m a() {
            return this.f10317a;
        }
    }
}
