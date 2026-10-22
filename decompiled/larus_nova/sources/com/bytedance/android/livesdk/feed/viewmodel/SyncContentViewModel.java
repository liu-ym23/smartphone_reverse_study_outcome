package com.bytedance.android.livesdk.feed.viewmodel;

import com.bytedance.android.live.core.utils.rxutils.RxViewModel;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes8.dex */
public class SyncContentViewModel extends RxViewModel {
    private PublishSubject<Object> callSyncContentDialog;

    public void autoRefreshNum(int r100) {
    }

    public SyncContentViewModel() {
        this.callSyncContentDialog = PublishSubject.create();
    }
}
