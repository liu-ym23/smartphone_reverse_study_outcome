package com.obric.autogui.common.api.presentation;

import com.obric.autogui.common.api.agent.IAutoActionAgentEventListener;
import com.obric.autogui.common.api.agent.QueueStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class WidgetState {
    private final IAutoActionAgentEventListener.SessionInfo sessionInfo;
    private final int widgetStateType;

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class CallUser extends WidgetState {
        private final String actionForUser;
        private final IAutoActionAgentEventListener.AgentStepInfo stepInfo;

        public final IAutoActionAgentEventListener.AgentStepInfo getStepInfo() {
            return this.stepInfo;
        }

        public final String getActionForUser() {
            return this.actionForUser;
        }

        public CallUser(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4, String r5) {
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
            super(WidgetStateType.CallUser.getValue(), r3, null);
            this.stepInfo = r4;
            this.actionForUser = r5;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Clarify extends WidgetState {
        private final IAutoAgentWidgetStateListener.ClarifyBlackListParams clarifyBlackListParams;
        private final List<IAutoAgentWidgetStateListener.ClarifyOptions> guiClarifyOptions;
        private final IAutoActionAgentEventListener.AgentStepInfo stepInfo;
        private final IAutoAgentWidgetStateListener.ClarifyType type;

        public final IAutoActionAgentEventListener.AgentStepInfo getStepInfo() {
            return this.stepInfo;
        }

        public final List<IAutoAgentWidgetStateListener.ClarifyOptions> getGuiClarifyOptions() {
            return this.guiClarifyOptions;
        }

        public final IAutoAgentWidgetStateListener.ClarifyType getType() {
            return this.type;
        }

        public final IAutoAgentWidgetStateListener.ClarifyBlackListParams getClarifyBlackListParams() {
            return this.clarifyBlackListParams;
        }

        public Clarify(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4, List<IAutoAgentWidgetStateListener.ClarifyOptions> r5, IAutoAgentWidgetStateListener.ClarifyType r6, IAutoAgentWidgetStateListener.ClarifyBlackListParams r7) {
            List<IAutoAgentWidgetStateListener.ClarifyOptions> r8 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
            o.e(r6, "type");
            super(WidgetStateType.Clarify.getValue(), r3, null);
            this.stepInfo = r4;
            this.guiClarifyOptions = r8;
            this.type = r6;
            this.clarifyBlackListParams = r7;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class LastStep extends WidgetState {
        private final int endType;
        private final boolean isPureTimerTask;
        private final IAutoActionAgentEventListener.OperatingAppInfo operatingApp;
        private final IAutoActionAgentEventListener.AgentStepInfo stepInfo;

        public final IAutoActionAgentEventListener.AgentStepInfo getStepInfo() {
            return this.stepInfo;
        }

        public final IAutoActionAgentEventListener.OperatingAppInfo getOperatingApp() {
            return this.operatingApp;
        }

        public final boolean isPureTimerTask() {
            return this.isPureTimerTask;
        }

        public final int getEndType() {
            return this.endType;
        }

        public LastStep(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.AgentStepInfo r4, IAutoActionAgentEventListener.OperatingAppInfo r5, boolean r6, int r7) {
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
            super(WidgetStateType.LastStep.getValue(), r3, null);
            this.stepInfo = r4;
            this.operatingApp = r5;
            this.isPureTimerTask = r6;
            this.endType = r7;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Operating extends WidgetState {
        private final IAutoActionAgentEventListener.OperatingAppInfo operatingApp;
        private final int operatingReason;
        private final IAutoActionAgentEventListener.AgentStepInfo stepInfo;

        public final IAutoActionAgentEventListener.OperatingAppInfo getOperatingApp() {
            return this.operatingApp;
        }

        public final IAutoActionAgentEventListener.AgentStepInfo getStepInfo() {
            return this.stepInfo;
        }

        public final int getOperatingReason() {
            return this.operatingReason;
        }

        public Operating(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.OperatingAppInfo r4, IAutoActionAgentEventListener.AgentStepInfo r5, int r6) {
            o.e(r3, "sessionInfo");
            super(WidgetStateType.Operating.getValue(), r3, null);
            this.operatingApp = r4;
            this.stepInfo = r5;
            this.operatingReason = r6;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Prepared extends WidgetState {
        public Prepared(IAutoActionAgentEventListener.SessionInfo r3) {
            o.e(r3, "sessionInfo");
            super(WidgetStateType.Prepared.getValue(), r3, null);
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Preparing extends WidgetState {
        public Preparing(IAutoActionAgentEventListener.SessionInfo r3) {
            o.e(r3, "sessionInfo");
            super(WidgetStateType.Preparing.getValue(), r3, null);
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Queue extends WidgetState {
        private final QueueStatus queueStatus;

        public final QueueStatus getQueueStatus() {
            return this.queueStatus;
        }

        public Queue(IAutoActionAgentEventListener.SessionInfo r3, QueueStatus r4) {
            o.e(r3, "sessionInfo");
            o.e(r4, "queueStatus");
            super(WidgetStateType.Queue.getValue(), r3, null);
            this.queueStatus = r4;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class SetTimerTask extends WidgetState {
        private final IAutoAgentWidgetStateListener.TimerTask timerTask;

        public final IAutoAgentWidgetStateListener.TimerTask getTimerTask() {
            return this.timerTask;
        }

        public SetTimerTask(IAutoActionAgentEventListener.SessionInfo r3, IAutoAgentWidgetStateListener.TimerTask r4) {
            o.e(r3, "sessionInfo");
            super(WidgetStateType.SetTimerTask.getValue(), r3, null);
            this.timerTask = r4;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Terminated extends WidgetState {
        public Terminated(IAutoActionAgentEventListener.SessionInfo r3) {
            o.e(r3, "sessionInfo");
            super(WidgetStateType.Terminated.getValue(), r3, null);
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class UserInterrupt extends WidgetState {
        private final IAutoActionAgentEventListener.OperatingAppInfo operatingApp;

        public final IAutoActionAgentEventListener.OperatingAppInfo getOperatingApp() {
            return this.operatingApp;
        }

        public UserInterrupt(IAutoActionAgentEventListener.SessionInfo r3, IAutoActionAgentEventListener.OperatingAppInfo r4) {
            o.e(r3, "sessionInfo");
            super(WidgetStateType.UserInterrupt.getValue(), r3, null);
            this.operatingApp = r4;
        }
    }

    public /* synthetic */ WidgetState(int r1, IAutoActionAgentEventListener.SessionInfo r2, h r3) {
        this(r1, r2);
    }

    private WidgetState(int r1, IAutoActionAgentEventListener.SessionInfo r2) {
        this.widgetStateType = r1;
        this.sessionInfo = r2;
    }

    public final int getWidgetStateType() {
        return this.widgetStateType;
    }

    public final IAutoActionAgentEventListener.SessionInfo getSessionInfo() {
        return this.sessionInfo;
    }
}
