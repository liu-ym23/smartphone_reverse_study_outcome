package com.obric.autoaction.presentation;

import android.os.Bundle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AgentEvent.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b {

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IAutoActionAgentEventListener.SessionInfo f24808a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IAutoActionAgentEventListener.AgentStepInfo f24809b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final IAutoActionAgentEventListener.AgentStepExecInfo f24810c;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24808a, r6.f24808a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f24809b, r6.f24809b) == true) goto L15;
            return false;
        L15:
            if (o.a(this.f24810c, r6.f24810c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.f24808a.hashCode() * 31) + this.f24809b.hashCode()) * 31) + this.f24810c.hashCode();
        }

        public String toString() {
            return "AgentAfterStepStatusEvent(sessionInfo=" + this.f24808a + ", stepInfo=" + this.f24809b + ", execInfo=" + this.f24810c + ')';
        }

        public final IAutoActionAgentEventListener.SessionInfo a() {
            return this.f24808a;
        }

        public final IAutoActionAgentEventListener.AgentStepInfo b() {
            return this.f24809b;
        }

        public a(IAutoActionAgentEventListener.SessionInfo r2, IAutoActionAgentEventListener.AgentStepInfo r3, IAutoActionAgentEventListener.AgentStepExecInfo r4) {
            o.e(r2, "sessionInfo");
            o.e(r3, "stepInfo");
            o.e(r4, "execInfo");
            super(null);
            this.f24808a = r2;
            this.f24809b = r3;
            this.f24810c = r4;
        }

        public final IAutoActionAgentEventListener.AgentStepExecInfo c() {
            return this.f24810c;
        }
    }

    /* JADX INFO: renamed from: com.obric.autoaction.presentation.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class C0576b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24811a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IAutoActionAgentEventListener.AgentStepInfo f24812b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, C0576b.class) == true) goto L8;
            return false;
        L8:
            C0576b r6 = (C0576b) ZeusTransformUtils.preCheckCast(r5, C0576b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24811a, r6.f24811a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f24812b, r6.f24812b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f24811a.hashCode() * 31) + this.f24812b.hashCode();
        }

        public String toString() {
            return "AgentStepStatusEvent(sessionId=" + this.f24811a + ", stepInfo=" + this.f24812b + ')';
        }

        public C0576b(String r2, IAutoActionAgentEventListener.AgentStepInfo r3) {
            o.e(r2, ObricMemoryConstants.KEY_SESSION_ID);
            o.e(r3, "stepInfo");
            super(null);
            this.f24811a = r2;
            this.f24812b = r3;
        }

        public final IAutoActionAgentEventListener.AgentStepInfo a() {
            return this.f24812b;
        }
    }

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IAutoActionAgentEventListener.SessionInfo f24813a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final BizStatus f24814b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final BizStatus f24815c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final Bundle f24816d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final int f24817e;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, c.class) == true) goto L8;
            return false;
        L8:
            c r6 = (c) ZeusTransformUtils.preCheckCast(r5, c.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24813a, r6.f24813a) == true) goto L12;
            return false;
        L12:
            if (this.f24814b == r6.f24814b) goto L15;
            return false;
        L15:
            if (this.f24815c == r6.f24815c) goto L18;
            return false;
        L18:
            if (o.a(this.f24816d, r6.f24816d) == true) goto L21;
            return false;
        L21:
            if (this.f24817e == r6.f24817e) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.f24813a.hashCode() * 31) + this.f24814b.hashCode()) * 31) + this.f24815c.hashCode()) * 31;
            Bundle r1 = this.f24816d;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((r0 + r2) * 31) + Integer.hashCode(this.f24817e);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "BizStatusEvent(sessionInfo=" + this.f24813a + ", fromStatus=" + this.f24814b + ", status=" + this.f24815c + ", extras=" + this.f24816d + ", reason=" + this.f24817e + ')';
        }

        public final IAutoActionAgentEventListener.SessionInfo a() {
            return this.f24813a;
        }

        public final BizStatus b() {
            return this.f24814b;
        }

        public final BizStatus c() {
            return this.f24815c;
        }

        public final Bundle d() {
            return this.f24816d;
        }

        public c(IAutoActionAgentEventListener.SessionInfo r2, BizStatus r3, BizStatus r4, Bundle r5, int r6) {
            o.e(r2, "sessionInfo");
            o.e(r3, "fromStatus");
            o.e(r4, "status");
            super(null);
            this.f24813a = r2;
            this.f24814b = r3;
            this.f24815c = r4;
            this.f24816d = r5;
            this.f24817e = r6;
        }

        public final int e() {
            return this.f24817e;
        }
    }

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final enum d extends Enum<d> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f24818a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f24819b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final /* synthetic */ d[] f24820c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private static final /* synthetic */ d.d.a f24821d = null;

        private static final /* synthetic */ d[] a() {
            return new d[]{f24818a, f24819b};
        }

        private d(String r1, int r2) {
            super(r1, r2);
        }

        static {
            f24818a = new d("STARTED", 0);
            f24819b = new d("STOPPED", 1);
            d[] r0 = a();
            f24820c = r0;
            f24821d = d.d.b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static d valueOf(String r2) {
            return (d) ZeusTransformUtils.preCheckCast(Enum.valueOf(d.class, r2), d.class, "com.obric.aiagent.plugin");
        }

        public static d[] values() {
            return (d[]) ZeusTransformUtils.preCheckCast(f24820c.clone(), d[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d f24823b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, e.class) == true) goto L8;
            return false;
        L8:
            e r6 = (e) ZeusTransformUtils.preCheckCast(r5, e.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24822a, r6.f24822a) == true) goto L12;
            return false;
        L12:
            if (this.f24823b == r6.f24823b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.f24822a.hashCode() * 31) + this.f24823b.hashCode();
        }

        public String toString() {
            return "FunctionStateEvent(functionName=" + this.f24822a + ", state=" + this.f24823b + ')';
        }

        public e(String r2, d r3) {
            o.e(r2, "functionName");
            o.e(r3, "state");
            super(null);
            this.f24822a = r2;
            this.f24823b = r3;
        }

        public final String a() {
            return this.f24822a;
        }

        public final d b() {
            return this.f24823b;
        }
    }

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IAutoActionAgentEventListener.OperatingAppInfo f24824a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, f.class) == true) goto L8;
            return false;
        L8:
            f r6 = (f) ZeusTransformUtils.preCheckCast(r5, f.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24824a, r6.f24824a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f24824a.hashCode();
        }

        public String toString() {
            return "OperatingAppChangedEvent(operatingApp=" + this.f24824a + ')';
        }

        public f(IAutoActionAgentEventListener.OperatingAppInfo r2) {
            o.e(r2, "operatingApp");
            super(null);
            this.f24824a = r2;
        }

        public final IAutoActionAgentEventListener.OperatingAppInfo a() {
            return this.f24824a;
        }
    }

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final QueueStatus f24825a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, g.class) == true) goto L8;
            return false;
        L8:
            g r6 = (g) ZeusTransformUtils.preCheckCast(r5, g.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24825a, r6.f24825a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f24825a.hashCode();
        }

        public String toString() {
            return "QueueStatusEvent(queueStatus=" + this.f24825a + ')';
        }

        public g(QueueStatus r2) {
            o.e(r2, "queueStatus");
            super(null);
            this.f24825a = r2;
        }
    }

    /* JADX INFO: compiled from: AgentEvent.kt */
    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f24826a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final boolean f24827b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, h.class) == true) goto L8;
            return false;
        L8:
            h r6 = (h) ZeusTransformUtils.preCheckCast(r5, h.class, "com.obric.aiagent.plugin");
            if (o.a(this.f24826a, r6.f24826a) == true) goto L12;
            return false;
        L12:
            if (this.f24827b == r6.f24827b) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            String r0 = this.f24826a;
            if (r0 != null) goto L5;
            int r1 = 0;
        L7:
            return (r1 * 31) + Boolean.hashCode(this.f24827b);
        L5:
            r1 = r0.hashCode();
            goto L7
        }

        public String toString() {
            return "StreamingThoughtEvent(reply=" + this.f24826a + ", endOfThought=" + this.f24827b + ')';
        }

        public h(String r2, boolean r3) {
            super(null);
            this.f24826a = r2;
            this.f24827b = r3;
        }

        public final String a() {
            return this.f24826a;
        }

        public final boolean b() {
            return this.f24827b;
        }
    }

    public /* synthetic */ b(d.h.b.h r1) {
        this();
    }

    private b() {
    }
}
