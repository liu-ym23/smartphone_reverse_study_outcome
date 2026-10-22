package com.obric.autogui.common.api.platform.special;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: ActionSystemAnimationMonitor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum PageSwitchPhase extends Enum<PageSwitchPhase> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ PageSwitchPhase[] $VALUES = null;
    public static final PageSwitchPhase Ended = null;
    public static final PageSwitchPhase InProgress = null;
    public static final PageSwitchPhase NotStarted = null;

    private static final /* synthetic */ PageSwitchPhase[] $values() {
        return new PageSwitchPhase[]{NotStarted, InProgress, Ended};
    }

    public static a<PageSwitchPhase> getEntries() {
        return $ENTRIES;
    }

    private PageSwitchPhase(String r1, int r2) {
        super(r1, r2);
    }

    static {
        NotStarted = new PageSwitchPhase("NotStarted", 0);
        InProgress = new PageSwitchPhase("InProgress", 1);
        Ended = new PageSwitchPhase("Ended", 2);
        PageSwitchPhase[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static PageSwitchPhase valueOf(String r2) {
        return (PageSwitchPhase) ZeusTransformUtils.preCheckCast(Enum.valueOf(PageSwitchPhase.class, r2), PageSwitchPhase.class, "com.obric.aiagent.plugin");
    }

    public static PageSwitchPhase[] values() {
        return (PageSwitchPhase[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), PageSwitchPhase[].class, "com.obric.aiagent.plugin");
    }
}
