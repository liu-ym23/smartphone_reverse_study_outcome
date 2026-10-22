package com.obric.autogui.vdplayer.api.a;

import android.graphics.Bitmap;
import com.obric.autogui.common.api.agent.BizStatus;
import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: AgentContext.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final IAutoActionAgentEventListener.SessionInfo f31697a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final BizStatus.StatusChangedReasonStruct f31698b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<IAutoActionAgentEventListener.OperatingAppInfo> f31699c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Bitmap f31700d;

    public static /* synthetic */ b a(b r1, IAutoActionAgentEventListener.SessionInfo r2, BizStatus.StatusChangedReasonStruct r3, List r4, Bitmap r5, int r6, Object r7) {
        List<IAutoActionAgentEventListener.OperatingAppInfo> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 1) == 0) goto L6;
        r2 = r1.f31697a;
    L6:
        if ((r6 & 2) == 0) goto L9;
        r3 = r1.f31698b;
    L9:
        if ((r6 & 4) == 0) goto L12;
        r8 = r1.f31699c;
    L12:
        if ((r6 & 8) == 0) goto L15;
        r5 = r1.f31700d;
    L15:
        return r1.a(r2, r3, r8, r5);
    }

    public final b a(IAutoActionAgentEventListener.SessionInfo r2, BizStatus.StatusChangedReasonStruct r3, List<IAutoActionAgentEventListener.OperatingAppInfo> r4, Bitmap r5) {
        List r1 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        o.e(r1, "operatingAppHistory");
        return new b(r2, r3, r1, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
        return false;
    L8:
        b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
        if (o.a(this.f31697a, r6.f31697a) == true) goto L12;
        return false;
    L12:
        if (o.a(this.f31698b, r6.f31698b) == true) goto L15;
        return false;
    L15:
        if (o.a(this.f31699c, r6.f31699c) == true) goto L18;
        return false;
    L18:
        if (o.a(this.f31700d, r6.f31700d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        IAutoActionAgentEventListener.SessionInfo r0 = this.f31697a;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        BizStatus.StatusChangedReasonStruct r4 = this.f31698b;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (((r3 + r5) * 31) + this.f31699c.hashCode()) * 31;
        Bitmap r7 = this.f31700d;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "AgentContext(sessionInfo=" + this.f31697a + ", termReason=" + this.f31698b + ", operatingAppHistory=" + this.f31699c + ", lastScreenShot=" + this.f31700d + ')';
    }

    public b(IAutoActionAgentEventListener.SessionInfo r3, BizStatus.StatusChangedReasonStruct r4, List<IAutoActionAgentEventListener.OperatingAppInfo> r5, Bitmap r6) {
        List<IAutoActionAgentEventListener.OperatingAppInfo> r7 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
        o.e(r7, "operatingAppHistory");
        this.f31697a = r3;
        this.f31698b = r4;
        this.f31699c = r7;
        this.f31700d = r6;
    }

    public final IAutoActionAgentEventListener.SessionInfo a() {
        return this.f31697a;
    }

    public final BizStatus.StatusChangedReasonStruct b() {
        return this.f31698b;
    }

    public /* synthetic */ b(IAutoActionAgentEventListener.SessionInfo r2, BizStatus.StatusChangedReasonStruct r3, List r4, Bitmap r5, int r6, h r7) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.aiagent.plugin");
        if ((r6 & 2) == 0) goto L6;
        r3 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r8 = p.b();
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = null;
    L11:
        this(r2, r3, r8, r5);
    }

    public final List<IAutoActionAgentEventListener.OperatingAppInfo> c() {
        return this.f31699c;
    }

    public final Bitmap d() {
        return this.f31700d;
    }
}
