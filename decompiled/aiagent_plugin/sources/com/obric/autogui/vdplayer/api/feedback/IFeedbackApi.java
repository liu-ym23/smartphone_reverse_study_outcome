package com.obric.autogui.vdplayer.api.feedback;

import android.content.Context;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import d.x;

/* JADX INFO: compiled from: IFeedbackApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IFeedbackApi {

    /* JADX INFO: compiled from: IFeedbackApi.kt */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IAutoActionAgentEventListener.SessionInfo f31705a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f31706b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final String f31707c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final String f31708d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f31709e;
        private final String f;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f31705a, r6.f31705a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f31706b, r6.f31706b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f31707c, r6.f31707c) == true) goto L18;
            return false;
        L18:
            if (o.a(this.f31708d, r6.f31708d) == true) goto L21;
            return false;
        L21:
            if (this.f31709e == r6.f31709e) goto L24;
            return false;
        L24:
            if (o.a(this.f, r6.f) == true) goto L26;
            return false;
        L26:
            return true;
        }

        public int hashCode() {
            IAutoActionAgentEventListener.SessionInfo r0 = this.f31705a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (((((((((r1 * 31) + this.f31706b.hashCode()) * 31) + this.f31707c.hashCode()) * 31) + this.f31708d.hashCode()) * 31) + Integer.hashCode(this.f31709e)) * 31) + this.f.hashCode();
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "FeedbackInfo(sessionInfo=" + this.f31705a + ", sessionId=" + this.f31706b + ", sessionKey=" + this.f31707c + ", journalPath=" + this.f31708d + ", reason=" + this.f31709e + ", taskQuery=" + this.f + ')';
        }

        public a(IAutoActionAgentEventListener.SessionInfo r2, String r3, String r4, String r5, int r6, String r7) {
            o.e(r3, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r4, "sessionKey");
            o.e(r5, "journalPath");
            o.e(r7, "taskQuery");
            this.f31705a = r2;
            this.f31706b = r3;
            this.f31707c = r4;
            this.f31708d = r5;
            this.f31709e = r6;
            this.f = r7;
        }

        public final IAutoActionAgentEventListener.SessionInfo a() {
            return this.f31705a;
        }

        public final String b() {
            return this.f31706b;
        }

        public final String c() {
            return this.f31707c;
        }

        public final String d() {
            return this.f31708d;
        }

        public final int e() {
            return this.f31709e;
        }

        public final String f() {
            return this.f;
        }
    }

    d.h.a.a<x> openFeedBack(Context r1, a r2);
}
