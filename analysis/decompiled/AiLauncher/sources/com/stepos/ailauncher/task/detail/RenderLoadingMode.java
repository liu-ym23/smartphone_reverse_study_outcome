package com.stepos.ailauncher.task.detail;

import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import kotlin.Metadata;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/task/detail/RenderLoadingMode;", "", "<init>", "(Ljava/lang/String;I)V", "INITIAL", "VERSION_SWITCH", ModelFlowMeta.PLAN_NONE, "task_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class RenderLoadingMode {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ RenderLoadingMode[] $VALUES;
    public static final RenderLoadingMode INITIAL = new RenderLoadingMode("INITIAL", 0);
    public static final RenderLoadingMode VERSION_SWITCH = new RenderLoadingMode("VERSION_SWITCH", 1);
    public static final RenderLoadingMode NONE = new RenderLoadingMode(ModelFlowMeta.PLAN_NONE, 2);

    private static final /* synthetic */ RenderLoadingMode[] $values() {
        return new RenderLoadingMode[]{INITIAL, VERSION_SWITCH, NONE};
    }

    static {
        RenderLoadingMode[] renderLoadingModeArr$values = $values();
        $VALUES = renderLoadingModeArr$values;
        $ENTRIES = kotlin.enums.a.a(renderLoadingModeArr$values);
    }

    private RenderLoadingMode(String str, int i10) {
    }

    public static InterfaceC4149a<RenderLoadingMode> getEntries() {
        return $ENTRIES;
    }

    public static RenderLoadingMode valueOf(String str) {
        return (RenderLoadingMode) Enum.valueOf(RenderLoadingMode.class, str);
    }

    public static RenderLoadingMode[] values() {
        return (RenderLoadingMode[]) $VALUES.clone();
    }
}
