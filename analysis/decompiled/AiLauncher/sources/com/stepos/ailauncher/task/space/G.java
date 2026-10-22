package com.stepos.ailauncher.task.space;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.chatcore.session.bean.AppUIData;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u000b\u0007B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/stepos/ailauncher/task/space/G;", "", "<init>", "()V", "Lcom/stepos/ailauncher/task/space/G$a;", "payload", "LY8/t;", Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/task/space/G$a;)V", "", "cardTaskId", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;)V", "Lcom/stepos/ailauncher/task/space/G$b;", "listener", "Lcom/stepos/ailauncher/task/space/G$b;", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class G {
    public static final G INSTANCE = new G();
    private static volatile b listener;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002À\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/task/space/G$b;", "", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface b {
    }

    public final void a(String cardTaskId) {
        kotlin.jvm.internal.p.i(cardTaskId, "cardTaskId");
        La.H.x0(cardTaskId);
    }

    public final void b(GuiHostPayload payload) {
        kotlin.jvm.internal.p.i(payload, "payload");
        La.H.x0(payload.getSessionId());
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0013\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0012\u001a\u00020\u0011HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0015\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0017\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0017\u001a\u0004\b\u0019\u0010\u0010R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0017\u001a\u0004\b\u001d\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0017\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010\u0017\u001a\u0004\b\u001f\u0010\u0010R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u0017\u001a\u0004\b \u0010\u0010R\u0017\u0010\f\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#¨\u0006$"}, d2 = {"Lcom/stepos/ailauncher/task/space/G$a;", "", "", "sessionId", "toolCallId", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "appUIData", "robotTaskId", "cardTaskId", DidiCardProvider.KEY_TRACE_ID, "requestSessionId", "", "finished", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "getToolCallId", "Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "getAppUIData", "()Lcom/stepos/agentframework/chatcore/session/bean/AppUIData;", "getRobotTaskId", "getCardTaskId", "getTraceId", "getRequestSessionId", "Z", "getFinished", "()Z", "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.task.space.G$a, reason: from toString */
    public static final /* data */ class GuiHostPayload {
        private final AppUIData appUIData;
        private final String cardTaskId;
        private final boolean finished;
        private final String requestSessionId;
        private final String robotTaskId;
        private final String sessionId;
        private final String toolCallId;
        private final String traceId;

        public GuiHostPayload(String sessionId, String toolCallId, AppUIData appUIData, String robotTaskId, String cardTaskId, String traceId, String requestSessionId, boolean z10) {
            kotlin.jvm.internal.p.i(sessionId, "sessionId");
            kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
            kotlin.jvm.internal.p.i(appUIData, "appUIData");
            kotlin.jvm.internal.p.i(robotTaskId, "robotTaskId");
            kotlin.jvm.internal.p.i(cardTaskId, "cardTaskId");
            kotlin.jvm.internal.p.i(traceId, "traceId");
            kotlin.jvm.internal.p.i(requestSessionId, "requestSessionId");
            this.sessionId = sessionId;
            this.toolCallId = toolCallId;
            this.appUIData = appUIData;
            this.robotTaskId = robotTaskId;
            this.cardTaskId = cardTaskId;
            this.traceId = traceId;
            this.requestSessionId = requestSessionId;
            this.finished = z10;
        }

        /* renamed from: a, reason: from getter */
        public final String getSessionId() {
            return this.sessionId;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof GuiHostPayload)) {
                return false;
            }
            GuiHostPayload guiHostPayload = (GuiHostPayload) other;
            return kotlin.jvm.internal.p.d(this.sessionId, guiHostPayload.sessionId) && kotlin.jvm.internal.p.d(this.toolCallId, guiHostPayload.toolCallId) && kotlin.jvm.internal.p.d(this.appUIData, guiHostPayload.appUIData) && kotlin.jvm.internal.p.d(this.robotTaskId, guiHostPayload.robotTaskId) && kotlin.jvm.internal.p.d(this.cardTaskId, guiHostPayload.cardTaskId) && kotlin.jvm.internal.p.d(this.traceId, guiHostPayload.traceId) && kotlin.jvm.internal.p.d(this.requestSessionId, guiHostPayload.requestSessionId) && this.finished == guiHostPayload.finished;
        }

        public int hashCode() {
            return (((((((((((((this.sessionId.hashCode() * 31) + this.toolCallId.hashCode()) * 31) + this.appUIData.hashCode()) * 31) + this.robotTaskId.hashCode()) * 31) + this.cardTaskId.hashCode()) * 31) + this.traceId.hashCode()) * 31) + this.requestSessionId.hashCode()) * 31) + Boolean.hashCode(this.finished);
        }

        public String toString() {
            return "GuiHostPayload(sessionId=" + this.sessionId + ", toolCallId=" + this.toolCallId + ", appUIData=" + this.appUIData + ", robotTaskId=" + this.robotTaskId + ", cardTaskId=" + this.cardTaskId + ", traceId=" + this.traceId + ", requestSessionId=" + this.requestSessionId + ", finished=" + this.finished + ")";
        }

        public /* synthetic */ GuiHostPayload(String str, String str2, AppUIData appUIData, String str3, String str4, String str5, String str6, boolean z10, int i10, kotlin.jvm.internal.i iVar) {
            this(str, str2, appUIData, (i10 & 8) != 0 ? "" : str3, (i10 & 16) != 0 ? "" : str4, (i10 & 32) != 0 ? "" : str5, (i10 & 64) != 0 ? "" : str6, (i10 & 128) != 0 ? false : z10);
        }
    }
}
