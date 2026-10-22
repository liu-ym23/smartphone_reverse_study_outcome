package com.obric.autogui.common.api.presentation;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IAutoAgentWidgetStateListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum WidgetStateType extends Enum<WidgetStateType> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ WidgetStateType[] $VALUES = null;
    public static final WidgetStateType CallUser = null;
    public static final WidgetStateType Clarify = null;
    public static final WidgetStateType LastStep = null;
    public static final WidgetStateType Operating = null;
    public static final WidgetStateType Prepared = null;
    public static final WidgetStateType Preparing = null;
    public static final WidgetStateType Queue = null;
    public static final WidgetStateType SetTimerTask = null;
    public static final WidgetStateType Terminated = null;
    public static final WidgetStateType UserInterrupt = null;
    private final int value;

    private static final /* synthetic */ WidgetStateType[] $values() {
        return new WidgetStateType[]{Preparing, Queue, Prepared, Operating, LastStep, Terminated, UserInterrupt, CallUser, Clarify, SetTimerTask};
    }

    public static a<WidgetStateType> getEntries() {
        return $ENTRIES;
    }

    private WidgetStateType(String r1, int r2, int r3) {
        super(r1, r2);
        this.value = r3;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Preparing = new WidgetStateType("Preparing", 0, 0);
        Queue = new WidgetStateType("Queue", 1, 1);
        Prepared = new WidgetStateType("Prepared", 2, 2);
        Operating = new WidgetStateType("Operating", 3, 3);
        LastStep = new WidgetStateType("LastStep", 4, 4);
        Terminated = new WidgetStateType("Terminated", 5, 5);
        UserInterrupt = new WidgetStateType("UserInterrupt", 6, 6);
        CallUser = new WidgetStateType("CallUser", 7, 7);
        Clarify = new WidgetStateType("Clarify", 8, 8);
        SetTimerTask = new WidgetStateType("SetTimerTask", 9, 9);
        WidgetStateType[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static WidgetStateType valueOf(String r2) {
        return (WidgetStateType) ZeusTransformUtils.preCheckCast(Enum.valueOf(WidgetStateType.class, r2), WidgetStateType.class, "com.obric.aiagent.plugin");
    }

    public static WidgetStateType[] values() {
        return (WidgetStateType[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), WidgetStateType[].class, "com.obric.aiagent.plugin");
    }
}
