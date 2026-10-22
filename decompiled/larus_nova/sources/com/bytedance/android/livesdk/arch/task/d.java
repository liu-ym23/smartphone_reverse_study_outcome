package com.bytedance.android.livesdk.arch.task;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes7.dex */
public interface d {
    Observable<TaskResult> a(e r100);

    TaskId getId();

    boolean isComplete();
}
