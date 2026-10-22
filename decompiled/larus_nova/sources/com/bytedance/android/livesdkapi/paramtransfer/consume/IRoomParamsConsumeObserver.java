package com.bytedance.android.livesdkapi.paramtransfer.consume;

import android.os.Bundle;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\b\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001a\u0010\t\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/paramtransfer/consume/IRoomParamsConsumeObserver;", "", "onClickDataReady", "", "params", "Landroid/os/Bundle;", "roomId", "", "onCommonDataReady", "onFirstShowDataReady", "room_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IRoomParamsConsumeObserver {
    void onClickDataReady(Bundle r100, long r101);

    void onCommonDataReady(Bundle r100, long r101);

    void onFirstShowDataReady(Bundle r100, long r101);
}
