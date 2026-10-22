package com.obric.autogui.common.api.space;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: RobotsScreenshotBlockReason.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum RobotsScreenshotBlockReason extends Enum<RobotsScreenshotBlockReason> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ RobotsScreenshotBlockReason[] $VALUES = null;
    public static final RobotsScreenshotBlockReason Inoperable = null;
    public static final RobotsScreenshotBlockReason Invisible = null;
    public static final RobotsScreenshotBlockReason None = null;

    private static final /* synthetic */ RobotsScreenshotBlockReason[] $values() {
        return new RobotsScreenshotBlockReason[]{None, Invisible, Inoperable};
    }

    public static a<RobotsScreenshotBlockReason> getEntries() {
        return $ENTRIES;
    }

    private RobotsScreenshotBlockReason(String r1, int r2) {
        super(r1, r2);
    }

    static {
        None = new RobotsScreenshotBlockReason("None", 0);
        Invisible = new RobotsScreenshotBlockReason("Invisible", 1);
        Inoperable = new RobotsScreenshotBlockReason("Inoperable", 2);
        RobotsScreenshotBlockReason[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static RobotsScreenshotBlockReason valueOf(String r2) {
        return (RobotsScreenshotBlockReason) ZeusTransformUtils.preCheckCast(Enum.valueOf(RobotsScreenshotBlockReason.class, r2), RobotsScreenshotBlockReason.class, "com.obric.aiagent.plugin");
    }

    public static RobotsScreenshotBlockReason[] values() {
        return (RobotsScreenshotBlockReason[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), RobotsScreenshotBlockReason[].class, "com.obric.aiagent.plugin");
    }
}
