package com.bytedance.android.livesdk.widgetdescriptor.delegate;

import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;

/* JADX INFO: loaded from: classes11.dex */
public final /* synthetic */ class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f162363a = null;

    static {
        int[] r100 = new int[ILiveRecordService.RecordStatus.values().length];
        f162363a = r100;
        r100[ILiveRecordService.RecordStatus.RECORDING.ordinal()] = 1;
        r100[ILiveRecordService.RecordStatus.FINISH.ordinal()] = 2;
    }
}
