package com.obric.autogui.common.api.agent;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import com.obric.autogui.common.AutoOperateTask;
import com.obric.autogui.effects.VDPlayerEffectProviderImpl;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.f;
import d.h.b.h;
import d.h.b.o;
import java.io.File;
import java.util.Date;

/* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionAgentEventListener {
    public static final Companion Companion = null;
    public static final String EXTRA_TERMINATION_SCREENSHOT = "termination_screenshot";

    /* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
    public static final class AgentStepExecInfo {
        private final Bitmap afterStepScreenshot;
        private final String afterStepScreenshotPath;
        private final String journalPath;
        private final Object payload;
        private final boolean succeeded;

        public static /* synthetic */ AgentStepExecInfo copy$default(AgentStepExecInfo r3, Bitmap r4, String r5, String r6, boolean r7, Object r8, int r9, Object r10) {
            if ((r9 & 1) == 0) goto L6;
            r4 = r3.afterStepScreenshot;
        L6:
            if ((r9 & 2) == 0) goto L8;
            r5 = r3.afterStepScreenshotPath;
        L8:
            String r11 = r5;
            if ((r9 & 4) == 0) goto L11;
            r6 = r3.journalPath;
        L11:
            String r0 = r6;
            if ((r9 & 8) == 0) goto L14;
            r7 = r3.succeeded;
        L14:
            boolean r1 = r7;
            if ((r9 & 16) == 0) goto L17;
            r8 = r3.payload;
        L17:
            Bitmap r12 = r4;
            return r3.copy(r12, r11, r0, r1, r8);
        }

        public final Bitmap component1() {
            return this.afterStepScreenshot;
        }

        public final String component2() {
            return this.afterStepScreenshotPath;
        }

        public final String component3() {
            return this.journalPath;
        }

        public final boolean component4() {
            return this.succeeded;
        }

        public final Object component5() {
            return this.payload;
        }

        public final AgentStepExecInfo copy(Bitmap r7, String r8, String r9, boolean r10, Object r11) {
            o.e(r9, "journalPath");
            return new AgentStepExecInfo(r7, r8, r9, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, AgentStepExecInfo.class) == true) goto L8;
            return false;
        L8:
            AgentStepExecInfo r6 = (AgentStepExecInfo) ZeusTransformUtils.preCheckCast(r5, AgentStepExecInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.afterStepScreenshot, r6.afterStepScreenshot) == true) goto L12;
            return false;
        L12:
            if (o.a(this.afterStepScreenshotPath, r6.afterStepScreenshotPath) == true) goto L15;
            return false;
        L15:
            if (o.a(this.journalPath, r6.journalPath) == true) goto L18;
            return false;
        L18:
            if (this.succeeded == r6.succeeded) goto L21;
            return false;
        L21:
            if (o.a(this.payload, r6.payload) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            Bitmap r0 = this.afterStepScreenshot;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            String r4 = this.afterStepScreenshotPath;
            if (r4 != null) goto L9;
            int r5 = 0;
        L10:
            int r6 = (((((r3 + r5) * 31) + this.journalPath.hashCode()) * 31) + Boolean.hashCode(this.succeeded)) * 31;
            Object r7 = this.payload;
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
            return "AgentStepExecInfo(afterStepScreenshot=" + this.afterStepScreenshot + ", afterStepScreenshotPath=" + this.afterStepScreenshotPath + ", journalPath=" + this.journalPath + ", succeeded=" + this.succeeded + ", payload=" + this.payload + ')';
        }

        public AgentStepExecInfo(Bitmap r2, String r3, String r4, boolean r5, Object r6) {
            o.e(r4, "journalPath");
            this.afterStepScreenshot = r2;
            this.afterStepScreenshotPath = r3;
            this.journalPath = r4;
            this.succeeded = r5;
            this.payload = r6;
        }

        public /* synthetic */ AgentStepExecInfo(Bitmap r7, String r8, String r9, boolean r10, Object r11, int r12, h r13) {
            if ((r12 & 16) == 0) goto L5;
            r11 = null;
        L5:
            this(r7, r8, r9, r10, r11);
        }

        public final Bitmap getAfterStepScreenshot() {
            return this.afterStepScreenshot;
        }

        public final String getAfterStepScreenshotPath() {
            return this.afterStepScreenshotPath;
        }

        public final String getJournalPath() {
            return this.journalPath;
        }

        public final boolean getSucceeded() {
            return this.succeeded;
        }

        public final Object getPayload() {
            return this.payload;
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
    public static final class AgentStepInfo {
        private final String action;
        private final String actionProtocolType;
        private final int actionType;
        private final long creationTimeMillis;
        private final transient Bundle extras;
        private long finishTimeMills;
        private final boolean isLastStep;
        private final boolean isSuccess;
        private final String rawAction;
        private final String rawThought;
        private final boolean supportsUserAddition;
        private final String thought;

        public static /* synthetic */ AgentStepInfo copy$default(AgentStepInfo r15, String r16, String r17, String r18, String r19, boolean r20, boolean r21, String r22, int r23, boolean r24, long r25, long r27, Bundle r29, int r30, Object r31) {
            if ((r30 & 1) == 0) goto L5;
            String r2 = r15.rawAction;
        L7:
            if ((r30 & 2) == 0) goto L9;
            String r3 = r15.action;
        L11:
            if ((r30 & 4) == 0) goto L13;
            String r4 = r15.rawThought;
        L15:
            if ((r30 & 8) == 0) goto L17;
            String r5 = r15.thought;
        L19:
            if ((r30 & 16) == 0) goto L21;
            boolean r6 = r15.isSuccess;
        L23:
            if ((r30 & 32) == 0) goto L25;
            boolean r7 = r15.isLastStep;
        L27:
            if ((r30 & 64) == 0) goto L29;
            String r8 = r15.actionProtocolType;
        L31:
            if ((r30 & 128) == 0) goto L33;
            int r9 = r15.actionType;
        L35:
            if ((r30 & 256) == 0) goto L37;
            boolean r10 = r15.supportsUserAddition;
        L39:
            if ((r30 & 512) == 0) goto L41;
            long r11 = r15.creationTimeMillis;
        L43:
            if ((r30 & 1024) == 0) goto L45;
            long r13 = r15.finishTimeMills;
        L47:
            if ((r30 & 2048) == 0) goto L49;
            Bundle r1 = r15.extras;
        L51:
            return r15.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r13, r1);
        L49:
            r1 = r29;
            goto L51
        L45:
            r13 = r27;
            goto L47
        L41:
            r11 = r25;
            goto L43
        L37:
            r10 = r24;
            goto L39
        L33:
            r9 = r23;
            goto L35
        L29:
            r8 = r22;
            goto L31
        L25:
            r7 = r21;
            goto L27
        L21:
            r6 = r20;
            goto L23
        L17:
            r5 = r19;
            goto L19
        L13:
            r4 = r18;
            goto L15
        L9:
            r3 = r17;
            goto L11
        L5:
            r2 = r16;
            goto L7
        }

        public final String component1() {
            return this.rawAction;
        }

        public final long component10() {
            return this.creationTimeMillis;
        }

        public final long component11() {
            return this.finishTimeMills;
        }

        public final Bundle component12() {
            return this.extras;
        }

        public final String component2() {
            return this.action;
        }

        public final String component3() {
            return this.rawThought;
        }

        public final String component4() {
            return this.thought;
        }

        public final boolean component5() {
            return this.isSuccess;
        }

        public final boolean component6() {
            return this.isLastStep;
        }

        public final String component7() {
            return this.actionProtocolType;
        }

        public final int component8() {
            return this.actionType;
        }

        public final boolean component9() {
            return this.supportsUserAddition;
        }

        public final AgentStepInfo copy(String r17, String r18, String r19, String r20, boolean r21, boolean r22, String r23, int r24, boolean r25, long r26, long r28, Bundle r30) {
            o.e(r17, "rawAction");
            o.e(r18, "action");
            o.e(r19, "rawThought");
            o.e(r20, VDPlayerEffectProviderImpl.KEY_THOUGHT);
            o.e(r23, "actionProtocolType");
            return new AgentStepInfo(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r28, r30);
        }

        public boolean equals(Object r9) {
            if (this != r9) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r9, AgentStepInfo.class) == true) goto L8;
            return false;
        L8:
            AgentStepInfo r10 = (AgentStepInfo) ZeusTransformUtils.preCheckCast(r9, AgentStepInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.rawAction, r10.rawAction) == true) goto L12;
            return false;
        L12:
            if (o.a(this.action, r10.action) == true) goto L15;
            return false;
        L15:
            if (o.a(this.rawThought, r10.rawThought) == true) goto L18;
            return false;
        L18:
            if (o.a(this.thought, r10.thought) == true) goto L21;
            return false;
        L21:
            if (this.isSuccess == r10.isSuccess) goto L24;
            return false;
        L24:
            if (this.isLastStep == r10.isLastStep) goto L27;
            return false;
        L27:
            if (o.a(this.actionProtocolType, r10.actionProtocolType) == true) goto L30;
            return false;
        L30:
            if (this.actionType == r10.actionType) goto L33;
            return false;
        L33:
            if (this.supportsUserAddition == r10.supportsUserAddition) goto L36;
            return false;
        L36:
            if (this.creationTimeMillis == r10.creationTimeMillis) goto L39;
            return false;
        L39:
            if (this.finishTimeMills == r10.finishTimeMills) goto L42;
            return false;
        L42:
            if (o.a(this.extras, r10.extras) == true) goto L44;
            return false;
        L44:
            return true;
        }

        public int hashCode() {
            int r0 = ((((((((((((((((((((this.rawAction.hashCode() * 31) + this.action.hashCode()) * 31) + this.rawThought.hashCode()) * 31) + this.thought.hashCode()) * 31) + Boolean.hashCode(this.isSuccess)) * 31) + Boolean.hashCode(this.isLastStep)) * 31) + this.actionProtocolType.hashCode()) * 31) + Integer.hashCode(this.actionType)) * 31) + Boolean.hashCode(this.supportsUserAddition)) * 31) + Long.hashCode(this.creationTimeMillis)) * 31) + Long.hashCode(this.finishTimeMills)) * 31;
            Bundle r3 = this.extras;
            if (r3 != null) goto L5;
            int r4 = 0;
        L7:
            return r0 + r4;
        L5:
            r4 = r3.hashCode();
            goto L7
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("AgentStepInfo(rawAction=").append(this.rawAction).append(", action=").append(this.action).append(", rawThought=").append(this.rawThought).append(", thought=").append(this.thought).append(", isSuccess=").append(this.isSuccess).append(", isLastStep=").append(this.isLastStep).append(", actionProtocolType=").append(this.actionProtocolType).append(", actionType=").append(this.actionType).append(", supportsUserAddition=").append(this.supportsUserAddition).append(", creationTimeMillis=").append(this.creationTimeMillis).append(", finishTimeMills=").append(this.finishTimeMills).append(", extras=");
            r0.append(this.extras).append(')');
            return r0.toString();
        }

        public AgentStepInfo(String r2, String r3, String r4, String r5, boolean r6, boolean r7, String r8, int r9, boolean r10, long r11, long r13, Bundle r15) {
            o.e(r2, "rawAction");
            o.e(r3, "action");
            o.e(r4, "rawThought");
            o.e(r5, VDPlayerEffectProviderImpl.KEY_THOUGHT);
            o.e(r8, "actionProtocolType");
            this.rawAction = r2;
            this.action = r3;
            this.rawThought = r4;
            this.thought = r5;
            this.isSuccess = r6;
            this.isLastStep = r7;
            this.actionProtocolType = r8;
            this.actionType = r9;
            this.supportsUserAddition = r10;
            this.creationTimeMillis = r11;
            this.finishTimeMills = r13;
            this.extras = r15;
        }

        public /* synthetic */ AgentStepInfo(String r18, String r19, String r20, String r21, boolean r22, boolean r23, String r24, int r25, boolean r26, long r27, long r29, Bundle r31, int r32, h r33) {
            if ((r32 & 1024) == 0) goto L5;
            long r14 = 0;
        L6:
            this(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r14, r31);
            return;
        L5:
            r14 = r29;
            goto L6
        }

        public final String getRawAction() {
            return this.rawAction;
        }

        public final String getAction() {
            return this.action;
        }

        public final String getRawThought() {
            return this.rawThought;
        }

        public final String getThought() {
            return this.thought;
        }

        public final boolean isSuccess() {
            return this.isSuccess;
        }

        public final boolean isLastStep() {
            return this.isLastStep;
        }

        public final String getActionProtocolType() {
            return this.actionProtocolType;
        }

        public final int getActionType() {
            return this.actionType;
        }

        public final boolean getSupportsUserAddition() {
            return this.supportsUserAddition;
        }

        public final long getCreationTimeMillis() {
            return this.creationTimeMillis;
        }

        public final long getFinishTimeMills() {
            return this.finishTimeMills;
        }

        public final void setFinishTimeMills(long r1) {
            this.finishTimeMills = r1;
        }

        public final Bundle getExtras() {
            return this.extras;
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String EXTRA_TERMINATION_SCREENSHOT = "termination_screenshot";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
    public static final class DefaultImpls {
        public static void afterAgentStep(IAutoActionAgentEventListener r2, SessionInfo r3, AgentStepInfo r4, AgentStepExecInfo r5) {
            IAutoActionAgentEventListener r6 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
            o.e(r5, "execInfo");
        }

        public static void onAgentStep(IAutoActionAgentEventListener r2, SessionInfo r3, AgentStepInfo r4) {
            IAutoActionAgentEventListener r5 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "stepInfo");
        }

        public static void onBizStatusChanged(IAutoActionAgentEventListener r0, SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6) {
            IAutoActionAgentEventListener r7 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r0, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r1, "sessionInfo");
            o.e(r2, "oldStatus");
            o.e(r3, "status");
            o.e(r5, "reasonDetails");
        }

        public static void onOperatingAppChanged(IAutoActionAgentEventListener r1, SessionInfo r2, OperatingAppInfo r3) {
            IAutoActionAgentEventListener r4 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r2, "sessionInfo");
        }

        public static void onQueueStatusChanged(IAutoActionAgentEventListener r2, SessionInfo r3, QueueStatus r4) {
            IAutoActionAgentEventListener r5 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
            o.e(r4, "queueStatus");
        }

        public static void onSessionEnqueued(IAutoActionAgentEventListener r2, SessionInfo r3) {
            IAutoActionAgentEventListener r4 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
        }

        public static void onUIOperationHangup(IAutoActionAgentEventListener r2, SessionInfo r3) {
            IAutoActionAgentEventListener r4 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "sessionInfo");
        }

        public static int order(IAutoActionAgentEventListener r2) {
            IAutoActionAgentEventListener r3 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r2, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            return 0;
        }

        public static /* synthetic */ void onBizStatusChanged$default(IAutoActionAgentEventListener r7, SessionInfo r8, BizStatus r9, BizStatus r10, int r11, BizStatus.StatusChangedReasonStruct r12, Bundle r13, int r14, Object r15) {
            IAutoActionAgentEventListener r0 = (IAutoActionAgentEventListener) ZeusTransformUtils.wrapperContextForParams(r7, IAutoActionAgentEventListener.class, "com.obric.aiagent.plugin");
            if (r15 != null) goto L10;
            if ((r14 & 32) == 0) goto L7;
            r13 = null;
        L7:
            r0.onBizStatusChanged(r8, r9, r10, r11, r12, r13);
            return;
        L10:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onBizStatusChanged");
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
    public static final class OperatingAppInfo {
        private final transient Drawable appIcon;
        private final CharSequence appLabel;
        private boolean isTaskIdChanged;
        private final String packageName;
        private final int taskId;

        public static /* synthetic */ OperatingAppInfo copy$default(OperatingAppInfo r6, String r7, Drawable r8, CharSequence r9, int r10, boolean r11, int r12, Object r13) {
            CharSequence r14 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
            if ((r12 & 1) == 0) goto L5;
            r7 = r6.packageName;
        L5:
            String r1 = r7;
            if ((r12 & 2) == 0) goto L8;
            r8 = r6.appIcon;
        L8:
            Drawable r2 = r8;
            if ((r12 & 4) == 0) goto L11;
            r14 = r6.appLabel;
        L11:
            CharSequence r3 = r14;
            if ((r12 & 8) == 0) goto L14;
            r10 = r6.taskId;
        L14:
            int r4 = r10;
            if ((r12 & 16) == 0) goto L18;
            r11 = r6.isTaskIdChanged;
        L18:
            return r6.copy(r1, r2, r3, r4, r11);
        }

        public final String component1() {
            return this.packageName;
        }

        public final Drawable component2() {
            return this.appIcon;
        }

        public final CharSequence component3() {
            return this.appLabel;
        }

        public final int component4() {
            return this.taskId;
        }

        public final boolean component5() {
            return this.isTaskIdChanged;
        }

        public final OperatingAppInfo copy(String r7, Drawable r8, CharSequence r9, int r10, boolean r11) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r7, "packageName");
            o.e(r3, "appLabel");
            return new OperatingAppInfo(r7, r8, r3, r10, r11);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, OperatingAppInfo.class) == true) goto L8;
            return false;
        L8:
            OperatingAppInfo r6 = (OperatingAppInfo) ZeusTransformUtils.preCheckCast(r5, OperatingAppInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.packageName, r6.packageName) == true) goto L12;
            return false;
        L12:
            if (o.a(this.appIcon, r6.appIcon) == true) goto L15;
            return false;
        L15:
            if (o.a(this.appLabel, r6.appLabel) == true) goto L18;
            return false;
        L18:
            if (this.taskId == r6.taskId) goto L21;
            return false;
        L21:
            if (this.isTaskIdChanged == r6.isTaskIdChanged) goto L23;
            return false;
        L23:
            return true;
        }

        public int hashCode() {
            int r0 = this.packageName.hashCode() * 31;
            Drawable r1 = this.appIcon;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return ((((((r0 + r2) * 31) + this.appLabel.hashCode()) * 31) + Integer.hashCode(this.taskId)) * 31) + Boolean.hashCode(this.isTaskIdChanged);
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "OperatingAppInfo(packageName=" + this.packageName + ", appIcon=" + this.appIcon + ", appLabel=" + this.appLabel + ", taskId=" + this.taskId + ", isTaskIdChanged=" + this.isTaskIdChanged + ')';
        }

        public OperatingAppInfo(String r3, Drawable r4, CharSequence r5, int r6, boolean r7) {
            CharSequence r8 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r5, CharSequence.class, "com.obric.aiagent.plugin");
            o.e(r3, "packageName");
            o.e(r8, "appLabel");
            this.packageName = r3;
            this.appIcon = r4;
            this.appLabel = r8;
            this.taskId = r6;
            this.isTaskIdChanged = r7;
        }

        public /* synthetic */ OperatingAppInfo(String r7, Drawable r8, CharSequence r9, int r10, boolean r11, int r12, h r13) {
            CharSequence r3 = (CharSequence) ZeusTransformUtils.wrapperContextForParams(r9, CharSequence.class, "com.obric.aiagent.plugin");
            if ((r12 & 8) == 0) goto L5;
            r10 = -1;
        L5:
            int r4 = r10;
            if ((r12 & 16) == 0) goto L8;
            r11 = false;
        L8:
            this(r7, r8, r3, r4, r11);
        }

        public final String getPackageName() {
            return this.packageName;
        }

        public final Drawable getAppIcon() {
            return this.appIcon;
        }

        public final CharSequence getAppLabel() {
            return this.appLabel;
        }

        public final int getTaskId() {
            return this.taskId;
        }

        public final boolean isTaskIdChanged() {
            return this.isTaskIdChanged;
        }

        public final void setTaskIdChanged(boolean r1) {
            this.isTaskIdChanged = r1;
        }
    }

    /* JADX INFO: compiled from: IAutoActionAgentEventListener.kt */
    public static final class SessionInfo {
        private final String actionType;
        private final Date createdTime;
        private final String instructionType;
        private final boolean isQueueInProgress;
        private final boolean isQueued;
        private final transient f<File> journalPath;
        private final transient boolean noActionStep;
        private final String recommendTaskType;
        private final Long refMsgId;
        private final String sessionId;
        private final String sessionKey;
        private final int stepIndex;
        private final AutoOperateTask task;
        private final String toolId;
        private final String toolName;

        public static /* synthetic */ SessionInfo copy$default(SessionInfo r16, Date r17, AutoOperateTask r18, String r19, String r20, int r21, boolean r22, boolean r23, f r24, boolean r25, String r26, String r27, String r28, String r29, Long r30, String r31, int r32, Object r33) {
            f<File> r2 = (f) ZeusTransformUtils.wrapperContextForParams(r24, f.class, "com.obric.aiagent.plugin");
            if ((r32 & 1) == 0) goto L5;
            Date r3 = r16.createdTime;
        L7:
            if ((r32 & 2) == 0) goto L9;
            AutoOperateTask r4 = r16.task;
        L11:
            if ((r32 & 4) == 0) goto L13;
            String r5 = r16.sessionKey;
        L15:
            if ((r32 & 8) == 0) goto L17;
            String r6 = r16.sessionId;
        L19:
            if ((r32 & 16) == 0) goto L21;
            int r7 = r16.stepIndex;
        L23:
            if ((r32 & 32) == 0) goto L25;
            boolean r8 = r16.isQueued;
        L27:
            if ((r32 & 64) == 0) goto L29;
            boolean r9 = r16.isQueueInProgress;
        L31:
            if ((r32 & 128) == 0) goto L34;
            r2 = r16.journalPath;
        L34:
            if ((r32 & 256) == 0) goto L36;
            boolean r10 = r16.noActionStep;
        L38:
            if ((r32 & 512) == 0) goto L40;
            String r11 = r16.toolId;
        L42:
            if ((r32 & 1024) == 0) goto L44;
            String r12 = r16.toolName;
        L46:
            if ((r32 & 2048) == 0) goto L48;
            String r13 = r16.instructionType;
        L50:
            if ((r32 & 4096) == 0) goto L52;
            String r14 = r16.actionType;
        L54:
            if ((r32 & 8192) == 0) goto L56;
            Long r15 = r16.refMsgId;
        L58:
            if ((r32 & 16384) == 0) goto L60;
            String r1 = r16.recommendTaskType;
        L62:
            return r16.copy(r3, r4, r5, r6, r7, r8, r9, r2, r10, r11, r12, r13, r14, r15, r1);
        L60:
            r1 = r31;
            goto L62
        L56:
            r15 = r30;
            goto L58
        L52:
            r14 = r29;
            goto L54
        L48:
            r13 = r28;
            goto L50
        L44:
            r12 = r27;
            goto L46
        L40:
            r11 = r26;
            goto L42
        L36:
            r10 = r25;
            goto L38
        L29:
            r9 = r23;
            goto L31
        L25:
            r8 = r22;
            goto L27
        L21:
            r7 = r21;
            goto L23
        L17:
            r6 = r20;
            goto L19
        L13:
            r5 = r19;
            goto L15
        L9:
            r4 = r18;
            goto L11
        L5:
            r3 = r17;
            goto L7
        }

        public final Date component1() {
            return this.createdTime;
        }

        public final String component10() {
            return this.toolId;
        }

        public final String component11() {
            return this.toolName;
        }

        public final String component12() {
            return this.instructionType;
        }

        public final String component13() {
            return this.actionType;
        }

        public final Long component14() {
            return this.refMsgId;
        }

        public final String component15() {
            return this.recommendTaskType;
        }

        public final AutoOperateTask component2() {
            return this.task;
        }

        public final String component3() {
            return this.sessionKey;
        }

        public final String component4() {
            return this.sessionId;
        }

        public final int component5() {
            return this.stepIndex;
        }

        public final boolean component6() {
            return this.isQueued;
        }

        public final boolean component7() {
            return this.isQueueInProgress;
        }

        public final f<File> component8() {
            return this.journalPath;
        }

        public final boolean component9() {
            return this.noActionStep;
        }

        public final SessionInfo copy(Date r18, AutoOperateTask r19, String r20, String r21, int r22, boolean r23, boolean r24, f<? extends File> r25, boolean r26, String r27, String r28, String r29, String r30, Long r31, String r32) {
            f r9 = (f) ZeusTransformUtils.wrapperContextForParams(r25, f.class, "com.obric.aiagent.plugin");
            o.e(r18, "createdTime");
            o.e(r19, "task");
            o.e(r20, "sessionKey");
            o.e(r9, "journalPath");
            o.e(r32, "recommendTaskType");
            return new SessionInfo(r18, r19, r20, r21, r22, r23, r24, r9, r26, r27, r28, r29, r30, r31, r32);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, SessionInfo.class) == true) goto L8;
            return false;
        L8:
            SessionInfo r6 = (SessionInfo) ZeusTransformUtils.preCheckCast(r5, SessionInfo.class, "com.obric.aiagent.plugin");
            if (o.a(this.createdTime, r6.createdTime) == true) goto L12;
            return false;
        L12:
            if (o.a(this.task, r6.task) == true) goto L15;
            return false;
        L15:
            if (o.a(this.sessionKey, r6.sessionKey) == true) goto L18;
            return false;
        L18:
            if (o.a(this.sessionId, r6.sessionId) == true) goto L21;
            return false;
        L21:
            if (this.stepIndex == r6.stepIndex) goto L24;
            return false;
        L24:
            if (this.isQueued == r6.isQueued) goto L27;
            return false;
        L27:
            if (this.isQueueInProgress == r6.isQueueInProgress) goto L30;
            return false;
        L30:
            if (o.a(this.journalPath, r6.journalPath) == true) goto L33;
            return false;
        L33:
            if (this.noActionStep == r6.noActionStep) goto L36;
            return false;
        L36:
            if (o.a(this.toolId, r6.toolId) == true) goto L39;
            return false;
        L39:
            if (o.a(this.toolName, r6.toolName) == true) goto L42;
            return false;
        L42:
            if (o.a(this.instructionType, r6.instructionType) == true) goto L45;
            return false;
        L45:
            if (o.a(this.actionType, r6.actionType) == true) goto L48;
            return false;
        L48:
            if (o.a(this.refMsgId, r6.refMsgId) == true) goto L51;
            return false;
        L51:
            if (o.a(this.recommendTaskType, r6.recommendTaskType) == true) goto L53;
            return false;
        L53:
            return true;
        }

        public int hashCode() {
            int r0 = ((((this.createdTime.hashCode() * 31) + this.task.hashCode()) * 31) + this.sessionKey.hashCode()) * 31;
            String r1 = this.sessionId;
            int r2 = 0;
            if (r1 != null) goto L5;
            int r3 = 0;
        L6:
            int r4 = (((((((((((r0 + r3) * 31) + Integer.hashCode(this.stepIndex)) * 31) + Boolean.hashCode(this.isQueued)) * 31) + Boolean.hashCode(this.isQueueInProgress)) * 31) + this.journalPath.hashCode()) * 31) + Boolean.hashCode(this.noActionStep)) * 31;
            String r5 = this.toolId;
            if (r5 != null) goto L9;
            int r6 = 0;
        L10:
            int r7 = (r4 + r6) * 31;
            String r8 = this.toolName;
            if (r8 != null) goto L13;
            int r9 = 0;
        L14:
            int r10 = (r7 + r9) * 31;
            String r11 = this.instructionType;
            if (r11 != null) goto L17;
            int r12 = 0;
        L18:
            int r13 = (r10 + r12) * 31;
            String r14 = this.actionType;
            if (r14 != null) goto L21;
            int r15 = 0;
        L22:
            int r16 = (r13 + r15) * 31;
            Long r17 = this.refMsgId;
            if (r17 == null) goto L27;
            r2 = r17.hashCode();
        L27:
            return ((r16 + r2) * 31) + this.recommendTaskType.hashCode();
        L21:
            r15 = r14.hashCode();
            goto L22
        L17:
            r12 = r11.hashCode();
            goto L18
        L13:
            r9 = r8.hashCode();
            goto L14
        L9:
            r6 = r5.hashCode();
            goto L10
        L5:
            r3 = r1.hashCode();
            goto L6
        }

        public String toString() {
            StringBuilder r0 = new StringBuilder();
            r0.append("SessionInfo(createdTime=").append(this.createdTime).append(", task=").append(this.task).append(", sessionKey=").append(this.sessionKey).append(", sessionId=").append(this.sessionId).append(", stepIndex=").append(this.stepIndex).append(", isQueued=").append(this.isQueued).append(", isQueueInProgress=").append(this.isQueueInProgress).append(", journalPath=").append(this.journalPath).append(", noActionStep=").append(this.noActionStep).append(", toolId=").append(this.toolId).append(", toolName=").append(this.toolName).append(", instructionType=");
            r0.append(this.instructionType).append(", actionType=").append(this.actionType).append(", refMsgId=").append(this.refMsgId).append(", recommendTaskType=").append(this.recommendTaskType).append(')');
            return r0.toString();
        }

        public SessionInfo(Date r9, AutoOperateTask r10, String r11, String r12, int r13, boolean r14, boolean r15, f<? extends File> r16, boolean r17, String r18, String r19, String r20, String r21, Long r22, String r23) {
            f<File> r5 = (f) ZeusTransformUtils.wrapperContextForParams(r16, f.class, "com.obric.aiagent.plugin");
            o.e(r9, "createdTime");
            o.e(r10, "task");
            o.e(r11, "sessionKey");
            o.e(r5, "journalPath");
            o.e(r23, "recommendTaskType");
            this.createdTime = r9;
            this.task = r10;
            this.sessionKey = r11;
            this.sessionId = r12;
            this.stepIndex = r13;
            this.isQueued = r14;
            this.isQueueInProgress = r15;
            this.journalPath = r5;
            this.noActionStep = r17;
            this.toolId = r18;
            this.toolName = r19;
            this.instructionType = r20;
            this.actionType = r21;
            this.refMsgId = r22;
            this.recommendTaskType = r23;
        }

        public /* synthetic */ SessionInfo(Date r19, AutoOperateTask r20, String r21, String r22, int r23, boolean r24, boolean r25, f r26, boolean r27, String r28, String r29, String r30, String r31, Long r32, String r33, int r34, h r35) {
            f r10 = (f) ZeusTransformUtils.wrapperContextForParams(r26, f.class, "com.obric.aiagent.plugin");
            if ((r34 & 8) == 0) goto L5;
            String r6 = null;
        L7:
            if ((r34 & 16) == 0) goto L9;
            int r7 = 0;
        L11:
            if ((r34 & 32) == 0) goto L13;
            boolean r8 = false;
        L15:
            if ((r34 & 64) == 0) goto L17;
            boolean r9 = false;
        L19:
            if ((r34 & 256) == 0) goto L21;
            boolean r11 = false;
        L23:
            if ((r34 & 512) == 0) goto L25;
            String r12 = null;
        L27:
            if ((r34 & 1024) == 0) goto L29;
            String r13 = null;
        L31:
            if ((r34 & 2048) == 0) goto L33;
            String r14 = null;
        L35:
            if ((r34 & 4096) == 0) goto L37;
            String r15 = null;
        L39:
            if ((r34 & 8192) == 0) goto L41;
            Long r16 = null;
        L43:
            if ((r34 & 16384) == 0) goto L45;
            String r17 = "";
        L46:
            this(r19, r20, r21, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17);
            return;
        L45:
            r17 = r33;
            goto L46
        L41:
            r16 = r32;
            goto L43
        L37:
            r15 = r31;
            goto L39
        L33:
            r14 = r30;
            goto L35
        L29:
            r13 = r29;
            goto L31
        L25:
            r12 = r28;
            goto L27
        L21:
            r11 = r27;
            goto L23
        L17:
            r9 = r25;
            goto L19
        L13:
            r8 = r24;
            goto L15
        L9:
            r7 = r23;
            goto L11
        L5:
            r6 = r22;
            goto L7
        }

        public final Date getCreatedTime() {
            return this.createdTime;
        }

        public final AutoOperateTask getTask() {
            return this.task;
        }

        public final String getSessionKey() {
            return this.sessionKey;
        }

        public final String getSessionId() {
            return this.sessionId;
        }

        public final int getStepIndex() {
            return this.stepIndex;
        }

        public final boolean isQueued() {
            return this.isQueued;
        }

        public final boolean isQueueInProgress() {
            return this.isQueueInProgress;
        }

        public final f<File> getJournalPath() {
            return this.journalPath;
        }

        public final boolean getNoActionStep() {
            return this.noActionStep;
        }

        public final String getToolId() {
            return this.toolId;
        }

        public final String getToolName() {
            return this.toolName;
        }

        public final String getInstructionType() {
            return this.instructionType;
        }

        public final String getActionType() {
            return this.actionType;
        }

        public final Long getRefMsgId() {
            return this.refMsgId;
        }

        public final String getRecommendTaskType() {
            return this.recommendTaskType;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void afterAgentStep(SessionInfo r1, AgentStepInfo r2, AgentStepExecInfo r3);

    void onAgentStep(SessionInfo r1, AgentStepInfo r2);

    void onBizStatusChanged(SessionInfo r1, BizStatus r2, BizStatus r3, int r4, BizStatus.StatusChangedReasonStruct r5, Bundle r6);

    void onOperatingAppChanged(SessionInfo r1, OperatingAppInfo r2);

    void onQueueStatusChanged(SessionInfo r1, QueueStatus r2);

    void onSessionEnqueued(SessionInfo r1);

    void onUIOperationHangup(SessionInfo r1);

    int order();
}
