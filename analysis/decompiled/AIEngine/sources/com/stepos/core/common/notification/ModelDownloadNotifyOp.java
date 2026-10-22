package com.stepos.core.common.notification;

import sb.a;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class ModelDownloadNotifyOp {
    private static final /* synthetic */ a $ENTRIES;
    private static final /* synthetic */ ModelDownloadNotifyOp[] $VALUES;
    public static final ModelDownloadNotifyOp PAUSE = new ModelDownloadNotifyOp("PAUSE", 0);
    public static final ModelDownloadNotifyOp CANCEL = new ModelDownloadNotifyOp("CANCEL", 1);
    public static final ModelDownloadNotifyOp CONTINUE_DOWNLOAD = new ModelDownloadNotifyOp("CONTINUE_DOWNLOAD", 2);
    public static final ModelDownloadNotifyOp CONTINUE_WITH_MOBILE_DATA = new ModelDownloadNotifyOp("CONTINUE_WITH_MOBILE_DATA", 3);
    public static final ModelDownloadNotifyOp RETRY = new ModelDownloadNotifyOp("RETRY", 4);
    public static final ModelDownloadNotifyOp NETWORK_SETTING = new ModelDownloadNotifyOp("NETWORK_SETTING", 5);
    public static final ModelDownloadNotifyOp DISMISS = new ModelDownloadNotifyOp("DISMISS", 6);
    public static final ModelDownloadNotifyOp OPEN_MODEL_MANAGER = new ModelDownloadNotifyOp("OPEN_MODEL_MANAGER", 7);

    private static final /* synthetic */ ModelDownloadNotifyOp[] $values() {
        return new ModelDownloadNotifyOp[]{PAUSE, CANCEL, CONTINUE_DOWNLOAD, CONTINUE_WITH_MOBILE_DATA, RETRY, NETWORK_SETTING, DISMISS, OPEN_MODEL_MANAGER};
    }

    static {
        ModelDownloadNotifyOp[] modelDownloadNotifyOpArr$values = $values();
        $VALUES = modelDownloadNotifyOpArr$values;
        $ENTRIES = kotlin.enums.a.a(modelDownloadNotifyOpArr$values);
    }

    private ModelDownloadNotifyOp(String str, int i10) {
    }

    public static a<ModelDownloadNotifyOp> getEntries() {
        return $ENTRIES;
    }

    public static ModelDownloadNotifyOp valueOf(String str) {
        return (ModelDownloadNotifyOp) Enum.valueOf(ModelDownloadNotifyOp.class, str);
    }

    public static ModelDownloadNotifyOp[] values() {
        return (ModelDownloadNotifyOp[]) $VALUES.clone();
    }
}
