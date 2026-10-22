package com.stepos.aiengine.flow;

import h9.InterfaceC4149a;
import kotlin.Metadata;
import kotlin.enums.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/stepos/aiengine/flow/ModelFlowStage;", "", "<init>", "(Ljava/lang/String;I)V", "CHECKING", "CTA", "DOWNLOADING", "PAUSED", "DOWNLOAD_CONFIRM", "DOWNLOAD_CELLULAR_CONFIRM", "UPDATE_CONFIRM", "UPDATE_CELLULAR_CONFIRM", "UPDATE_WIFI_GUIDE", "shared-lib_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ModelFlowStage {
    private static final /* synthetic */ InterfaceC4149a $ENTRIES;
    private static final /* synthetic */ ModelFlowStage[] $VALUES;
    public static final ModelFlowStage CHECKING = new ModelFlowStage("CHECKING", 0);
    public static final ModelFlowStage CTA = new ModelFlowStage("CTA", 1);
    public static final ModelFlowStage DOWNLOADING = new ModelFlowStage("DOWNLOADING", 2);
    public static final ModelFlowStage PAUSED = new ModelFlowStage("PAUSED", 3);
    public static final ModelFlowStage DOWNLOAD_CONFIRM = new ModelFlowStage("DOWNLOAD_CONFIRM", 4);
    public static final ModelFlowStage DOWNLOAD_CELLULAR_CONFIRM = new ModelFlowStage("DOWNLOAD_CELLULAR_CONFIRM", 5);
    public static final ModelFlowStage UPDATE_CONFIRM = new ModelFlowStage("UPDATE_CONFIRM", 6);
    public static final ModelFlowStage UPDATE_CELLULAR_CONFIRM = new ModelFlowStage("UPDATE_CELLULAR_CONFIRM", 7);
    public static final ModelFlowStage UPDATE_WIFI_GUIDE = new ModelFlowStage("UPDATE_WIFI_GUIDE", 8);

    private static final /* synthetic */ ModelFlowStage[] $values() {
        return new ModelFlowStage[]{CHECKING, CTA, DOWNLOADING, PAUSED, DOWNLOAD_CONFIRM, DOWNLOAD_CELLULAR_CONFIRM, UPDATE_CONFIRM, UPDATE_CELLULAR_CONFIRM, UPDATE_WIFI_GUIDE};
    }

    static {
        ModelFlowStage[] modelFlowStageArr$values = $values();
        $VALUES = modelFlowStageArr$values;
        $ENTRIES = a.a(modelFlowStageArr$values);
    }

    private ModelFlowStage(String str, int i10) {
    }

    public static InterfaceC4149a<ModelFlowStage> getEntries() {
        return $ENTRIES;
    }

    public static ModelFlowStage valueOf(String str) {
        return (ModelFlowStage) Enum.valueOf(ModelFlowStage.class, str);
    }

    public static ModelFlowStage[] values() {
        return (ModelFlowStage[]) $VALUES.clone();
    }
}
