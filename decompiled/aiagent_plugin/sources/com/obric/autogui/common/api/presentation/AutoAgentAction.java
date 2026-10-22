package com.obric.autogui.common.api.presentation;

/* JADX INFO: compiled from: AutoAgentAction.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AutoAgentAction {
    public static final String ACTION_AUTO_TESTING_TASK = "ACTION_AUTOMATED_TESTING_TASK";
    public static final String ACTION_CANCEL_TASK = "ACTION_CANCEL_TASK";
    public static final String ACTION_CHECK_TASK = "ACTION_CHECK_TASK";
    public static final String ACTION_SET_TIMER_TASK = "ACTION_SET_TIMER_TASK";
    public static final String ACTION_SHOW_INPUT_WINDOW = "ACTION_SHOW_INPUT_WINDOW";
    public static final AutoAgentAction INSTANCE = null;

    static {
        INSTANCE = new AutoAgentAction();
    }

    private AutoAgentAction() {
    }
}
