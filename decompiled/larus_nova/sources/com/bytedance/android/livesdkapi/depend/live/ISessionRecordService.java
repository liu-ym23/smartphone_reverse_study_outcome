package com.bytedance.android.livesdkapi.depend.live;

import com.bytedance.android.livesdk.ability.IAbility;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ISessionRecordService;", "Lcom/bytedance/android/livesdk/ability/IAbility;", "addRecordStatsChangeListener", "", "listener", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "callRecordStatsChangeListener", "recording", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatus;", "release", "removeRecordStatsChangeListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ISessionRecordService extends IAbility {
    void addRecordStatsChangeListener(ILiveRecordService.RecordStatusChangeListener r100);

    void callRecordStatsChangeListener(ILiveRecordService.RecordStatus r100);

    void release();

    void removeRecordStatsChangeListener(ILiveRecordService.RecordStatusChangeListener r100);
}
