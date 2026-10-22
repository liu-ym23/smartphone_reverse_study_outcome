package com.obric.autogui.common.api.presentation.api;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;
import java.util.Map;

/* JADX INFO: compiled from: IAssistInputStateManager.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAssistInputStateManager {
    public static final Companion Companion = null;
    public static final String EXTRA_STATE_CHANGE_INPUTTED_TEXT = "sc_inputted_text";

    /* JADX INFO: compiled from: IAssistInputStateManager.kt */
    public static final enum AssistInputMode extends Enum<AssistInputMode> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ AssistInputMode[] $VALUES = null;
        public static final AssistInputMode ADDITION = null;
        public static final AssistInputMode CLARIFY = null;
        public static final AssistInputMode NONE = null;

        private static final /* synthetic */ AssistInputMode[] $values() {
            return new AssistInputMode[]{NONE, CLARIFY, ADDITION};
        }

        public static a<AssistInputMode> getEntries() {
            return $ENTRIES;
        }

        private AssistInputMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            NONE = new AssistInputMode("NONE", 0);
            CLARIFY = new AssistInputMode("CLARIFY", 1);
            ADDITION = new AssistInputMode("ADDITION", 2);
            AssistInputMode[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static AssistInputMode valueOf(String r2) {
            return (AssistInputMode) ZeusTransformUtils.preCheckCast(Enum.valueOf(AssistInputMode.class, r2), AssistInputMode.class, "com.obric.aiagent.plugin");
        }

        public static AssistInputMode[] values() {
            return (AssistInputMode[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), AssistInputMode[].class, "com.obric.aiagent.plugin");
        }
    }

    /* JADX INFO: compiled from: IAssistInputStateManager.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String EXTRA_STATE_CHANGE_INPUTTED_TEXT = "sc_inputted_text";

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: IAssistInputStateManager.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void launchStateChange$default(IAssistInputStateManager r2, StateType r3, StateType r4, Map r5, int r6, Object r7) {
            IAssistInputStateManager r8 = (IAssistInputStateManager) ZeusTransformUtils.wrapperContextForParams(r2, IAssistInputStateManager.class, "com.obric.aiagent.plugin");
            Map<String, ? extends Object> r9 = (Map) ZeusTransformUtils.wrapperContextForParams(r5, Map.class, "com.obric.aiagent.plugin");
            if (r7 != null) goto L13;
            if ((r6 & 2) == 0) goto L8;
            r4 = StateType.Any;
        L8:
            if ((r6 & 4) == 0) goto L10;
            r9 = null;
        L10:
            r8.launchStateChange(r3, r4, r9);
            return;
        L13:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: launchStateChange");
        }
    }

    /* JADX INFO: compiled from: IAssistInputStateManager.kt */
    public static final enum StateType extends Enum<StateType> {
        private static final /* synthetic */ a $ENTRIES = null;
        private static final /* synthetic */ StateType[] $VALUES = null;
        public static final StateType Any = null;
        public static final StateType Idle = null;
        public static final StateType Inactivated = null;
        public static final StateType Init = null;
        public static final StateType InputCompleted = null;
        public static final StateType InputStarting = null;
        public static final StateType Inputting = null;

        private static final /* synthetic */ StateType[] $values() {
            return new StateType[]{Any, Inactivated, Init, Idle, InputStarting, Inputting, InputCompleted};
        }

        public static a<StateType> getEntries() {
            return $ENTRIES;
        }

        private StateType(String r1, int r2) {
            super(r1, r2);
        }

        static {
            Any = new StateType("Any", 0);
            Inactivated = new StateType("Inactivated", 1);
            Init = new StateType("Init", 2);
            Idle = new StateType("Idle", 3);
            InputStarting = new StateType("InputStarting", 4);
            Inputting = new StateType("Inputting", 5);
            InputCompleted = new StateType("InputCompleted", 6);
            StateType[] r0 = $values();
            $VALUES = r0;
            $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
        }

        public static StateType valueOf(String r2) {
            return (StateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(StateType.class, r2), StateType.class, "com.obric.aiagent.plugin");
        }

        public static StateType[] values() {
            return (StateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), StateType[].class, "com.obric.aiagent.plugin");
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    AssistInputMode getAssistInputMode();

    StateType getCurrentState();

    void launchStateChange(StateType r1, StateType r2, Map<String, ? extends Object> r3);
}
