package com.obric.autogui.common.api.platform.tracking;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.d.a;
import d.d.b;

/* JADX INFO: compiled from: IAutoActionTrackingApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public final enum TrackingReportTarget extends Enum<TrackingReportTarget> {
    private static final /* synthetic */ a $ENTRIES = null;
    private static final /* synthetic */ TrackingReportTarget[] $VALUES = null;
    public static final TrackingReportTarget DEFAULT = null;
    public static final TrackingReportTarget TEA_AGENT_ONLY = null;

    private static final /* synthetic */ TrackingReportTarget[] $values() {
        return new TrackingReportTarget[]{DEFAULT, TEA_AGENT_ONLY};
    }

    public static a<TrackingReportTarget> getEntries() {
        return $ENTRIES;
    }

    private TrackingReportTarget(String r1, int r2) {
        super(r1, r2);
    }

    static {
        DEFAULT = new TrackingReportTarget("DEFAULT", 0);
        TEA_AGENT_ONLY = new TrackingReportTarget("TEA_AGENT_ONLY", 1);
        TrackingReportTarget[] r0 = $values();
        $VALUES = r0;
        $ENTRIES = b.a((Enum[]) ZeusTransformUtils.preCheckCast(r0, Enum[].class, "com.obric.aiagent.plugin"));
    }

    public static TrackingReportTarget valueOf(String r2) {
        return (TrackingReportTarget) ZeusTransformUtils.preCheckCast(Enum.valueOf(TrackingReportTarget.class, r2), TrackingReportTarget.class, "com.obric.aiagent.plugin");
    }

    public static TrackingReportTarget[] values() {
        return (TrackingReportTarget[]) ZeusTransformUtils.preCheckCast($VALUES.clone(), TrackingReportTarget[].class, "com.obric.aiagent.plugin");
    }
}
