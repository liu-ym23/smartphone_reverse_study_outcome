package com.bytedance.android.live.service;

import com.bytedance.android.live.record.LiveScreenRecordPublishGuideDialog;
import com.bytedance.android.live.room.api.record.ILiveScreenRecordService;
import com.bytedance.android.live.room.api.record.guide.PublishDialogInfo;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public class a implements ILiveScreenRecordService {
    public a() {
        k.l(a.class, this);
    }

    @Override // com.bytedance.android.live.room.api.record.ILiveScreenRecordService
    public com.bytedance.android.live.room.api.record.guide.a getPublishGuideDialog(PublishDialogInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        int r101 = LiveScreenRecordPublishGuideDialog.G;
        Intrinsics.checkNotNullParameter(r100, "info");
        return new com.bytedance.android.live.room.api.record.guide.a(new LiveScreenRecordPublishGuideDialog(r100.getContext(), r100));
    }
}
