package com.bytedance.android.livesdk.chatroom.record;

import com.bytedance.android.livesdkapi.depend.live.ILiveRecordService;

/* JADX INFO: loaded from: classes7.dex */
public final /* synthetic */ class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int[] f108074a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int[] f108075b = null;

    static {
        int[] r100 = new int[ILiveRecordService.PublishStatus.values().length];
        f108074a = r100;
        r100[ILiveRecordService.PublishStatus.PUBLISH_START.ordinal()] = 1;
        r100[ILiveRecordService.PublishStatus.PUBLISH_FAILED.ordinal()] = 2;
        r100[ILiveRecordService.PublishStatus.ADMIN_RECORD_ANCHOR_PUBLISH_SUCCESS.ordinal()] = 3;
        r100[ILiveRecordService.PublishStatus.PUBLISH_FINISH.ordinal()] = 4;
        r100[ILiveRecordService.PublishStatus.PUBLISH_PROGRESS.ordinal()] = 5;
        r100[ILiveRecordService.PublishStatus.SAVE_DRAFT_FAILED.ordinal()] = 6;
        r100[ILiveRecordService.PublishStatus.SAVE_DRAFT_SUCCESS.ordinal()] = 7;
        r100[ILiveRecordService.PublishStatus.UNKNOW.ordinal()] = 8;
        int[] r101 = new int[ILiveRecordService.RecordStatus.values().length];
        f108075b = r101;
        r101[ILiveRecordService.RecordStatus.RECORDING.ordinal()] = 1;
    }
}
