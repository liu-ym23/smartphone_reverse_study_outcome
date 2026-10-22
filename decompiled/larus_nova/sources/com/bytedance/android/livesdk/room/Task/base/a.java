package com.bytedance.android.livesdk.room.Task.base;

import ls2.c;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a<T extends ls2.c, R extends ls2.c> extends LiveTask {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public T f157564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public R f157565f;

    public final R g() {
        R r100 = this.f157565f;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new RuntimeException("bizContext is null, please check your task init:" + taskID());
    }

    public final T h() {
        T r100 = this.f157564e;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new RuntimeException("liveContext is null, please check your task init:" + taskID());
    }

    public a() {
    }
}
