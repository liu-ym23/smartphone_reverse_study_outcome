package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import d.h.b.h;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoAgentWidgetStateListener {
    public static final Companion Companion = null;

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class ClarifyBlackListParams implements Serializable {
        private final String contentTitle;
        private final String negativeString;
        private final String positiveString;

        public static /* synthetic */ ClarifyBlackListParams copy$default(ClarifyBlackListParams r0, String r1, String r2, String r3, int r4, Object r5) {
            if ((r4 & 1) == 0) goto L6;
            r1 = r0.contentTitle;
        L6:
            if ((r4 & 2) == 0) goto L9;
            r2 = r0.positiveString;
        L9:
            if ((r4 & 4) == 0) goto L12;
            r3 = r0.negativeString;
        L12:
            return r0.copy(r1, r2, r3);
        }

        public final String component1() {
            return this.contentTitle;
        }

        public final String component2() {
            return this.positiveString;
        }

        public final String component3() {
            return this.negativeString;
        }

        public final ClarifyBlackListParams copy(String r1, String r2, String r3) {
            o.e(r1, "contentTitle");
            o.e(r2, "positiveString");
            o.e(r3, "negativeString");
            return new ClarifyBlackListParams(r1, r2, r3);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ClarifyBlackListParams.class) == true) goto L8;
            return false;
        L8:
            ClarifyBlackListParams r6 = (ClarifyBlackListParams) ZeusTransformUtils.preCheckCast(r5, ClarifyBlackListParams.class, "com.obric.aiagent.plugin");
            if (o.a(this.contentTitle, r6.contentTitle) == true) goto L12;
            return false;
        L12:
            if (o.a(this.positiveString, r6.positiveString) == true) goto L15;
            return false;
        L15:
            if (o.a(this.negativeString, r6.negativeString) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((this.contentTitle.hashCode() * 31) + this.positiveString.hashCode()) * 31) + this.negativeString.hashCode();
        }

        public String toString() {
            return "ClarifyBlackListParams(contentTitle=" + this.contentTitle + ", positiveString=" + this.positiveString + ", negativeString=" + this.negativeString + ')';
        }

        public ClarifyBlackListParams(String r2, String r3, String r4) {
            o.e(r2, "contentTitle");
            o.e(r3, "positiveString");
            o.e(r4, "negativeString");
            this.contentTitle = r2;
            this.positiveString = r3;
            this.negativeString = r4;
        }

        public final String getContentTitle() {
            return this.contentTitle;
        }

        public final String getPositiveString() {
            return this.positiveString;
        }

        public final String getNegativeString() {
            return this.negativeString;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class ClarifyOptions {
        private final boolean highLight;
        private final String option;

        public static /* synthetic */ ClarifyOptions copy$default(ClarifyOptions r0, String r1, boolean r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.option;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.highLight;
        L9:
            return r0.copy(r1, r2);
        }

        public final String component1() {
            return this.option;
        }

        public final boolean component2() {
            return this.highLight;
        }

        public final ClarifyOptions copy(String r1, boolean r2) {
            o.e(r1, "option");
            return new ClarifyOptions(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, ClarifyOptions.class) == true) goto L8;
            return false;
        L8:
            ClarifyOptions r6 = (ClarifyOptions) ZeusTransformUtils.preCheckCast(r5, ClarifyOptions.class, "com.obric.aiagent.plugin");
            if (o.a(this.option, r6.option) == true) goto L12;
            return false;
        L12:
            if (this.highLight == r6.highLight) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            return (this.option.hashCode() * 31) + Boolean.hashCode(this.highLight);
        }

        public String toString() {
            return "ClarifyOptions(option=" + this.option + ", highLight=" + this.highLight + ')';
        }

        public ClarifyOptions(String r2, boolean r3) {
            o.e(r2, "option");
            this.option = r2;
            this.highLight = r3;
        }

        public final String getOption() {
            return this.option;
        }

        public final boolean getHighLight() {
            return this.highLight;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final enum ClarifyType extends Enum<ClarifyType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ ClarifyType[] $VALUES = null;
        public static final ClarifyType BLACKLIST = null;
        public static final ClarifyType NORMAL = null;
        private final int value;

        private static final /* synthetic */ ClarifyType[] $values() {
            return new ClarifyType[]{NORMAL, BLACKLIST};
        }

        public static a<ClarifyType> getEntries() {
            return $ENTRIES;
        }

        private ClarifyType(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }

        public final int getValue() {
            return this.value;
        }

        static {
            NORMAL = new ClarifyType("NORMAL", 0, 0);
            BLACKLIST = new ClarifyType("BLACKLIST", 1, 1);
            ClarifyType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static ClarifyType valueOf(String r2) {
            return (ClarifyType) ZeusTransformUtils.preCheckCast(Enum.valueOf(ClarifyType.class, r2), ClarifyType.class, "com.obric.aiagent.plugin");
        }

        public static ClarifyType[] values() {
            return (ClarifyType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), ClarifyType[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        private static final AutoAgentWidgetStateDefaultListener Default = null;

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
            Default = new AutoAgentWidgetStateDefaultListener();
        }

        public final AutoAgentWidgetStateDefaultListener getDefault() {
            return Default;
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class DefaultImpls {
        public static void onStateChange(IAutoAgentWidgetStateListener r1, WidgetState r2, WidgetState r3) {
            IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "state");
        }

        public static void onStateWillChange(IAutoAgentWidgetStateListener r1, WidgetState r2, WidgetState r3) {
            IAutoAgentWidgetStateListener r4 = (IAutoAgentWidgetStateListener) ZeusTransformUtils.wrapperContextForParams(r1, IAutoAgentWidgetStateListener.class, "com.obric.aiagent.plugin");
            o.e(r3, "state");
        }
    }

    /* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
    public static final class TimerTask {
        private final String action;
        private final String cronExpr;
        private String id;
        private final boolean isRepeatTask;
        private final String timeCondition;

        public TimerTask(String r2, String r3, String r4, String r5, boolean r6) {
            o.e(r3, "cronExpr");
            o.e(r4, "action");
            o.e(r5, "timeCondition");
            this.id = r2;
            this.cronExpr = r3;
            this.action = r4;
            this.timeCondition = r5;
            this.isRepeatTask = r6;
        }

        public /* synthetic */ TimerTask(String r7, String r8, String r9, String r10, boolean r11, int r12, h r13) {
            if ((r12 & 1) == 0) goto L5;
            r7 = null;
        L5:
            this(r7, r8, r9, r10, r11);
        }

        public final String getId() {
            return this.id;
        }

        public final void setId(String r1) {
            this.id = r1;
        }

        public final String getCronExpr() {
            return this.cronExpr;
        }

        public final String getAction() {
            return this.action;
        }

        public final String getTimeCondition() {
            return this.timeCondition;
        }

        public final boolean isRepeatTask() {
            return this.isRepeatTask;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void onCallUser(WidgetState.CallUser r1);

    void onClarify(WidgetState.Clarify r1);

    void onLastStep(WidgetState.LastStep r1);

    void onOperating(WidgetState.Operating r1);

    void onPrepared(WidgetState.Prepared r1);

    void onPreparing(WidgetState.Preparing r1);

    void onQueue(WidgetState.Queue r1);

    void onSetTimerTask(WidgetState.SetTimerTask r1);

    void onStateChange(WidgetState r1, WidgetState r2);

    void onStateWillChange(WidgetState r1, WidgetState r2);

    void onTerminate(WidgetState.Terminated r1);

    void onUserInterrupt(WidgetState.UserInterrupt r1);
}
