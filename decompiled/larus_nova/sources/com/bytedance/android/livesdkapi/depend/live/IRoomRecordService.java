package com.bytedance.android.livesdkapi.depend.live;

import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/IRoomRecordService;", "Lcom/bytedance/android/livesdk/ability/IAbility;", "isPreview", "", "isRecording", "setRecordStatus", "", "recording", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatus;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomRecordService extends IAbility {
    boolean isPreview();

    boolean isRecording();

    void setRecordStatus(ILiveRecordService.RecordStatus r100);
}
