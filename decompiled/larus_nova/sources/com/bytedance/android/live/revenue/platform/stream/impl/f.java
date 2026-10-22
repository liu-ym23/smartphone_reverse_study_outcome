package com.bytedance.android.live.revenue.platform.stream.impl;

import android.view.PixelCopy;
import io.reactivex.subjects.SingleSubject;

/* JADX INFO: loaded from: classes47.dex */
public final class f implements PixelCopy.OnPixelCopyFinishedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SingleSubject f91700a;

    public f(SingleSubject r100) {
        this.f91700a = r100;
    }

    @Override // android.view.PixelCopy.OnPixelCopyFinishedListener
    public final void onPixelCopyFinished(int r100) {
        this.f91700a.onSuccess(Integer.valueOf(r100));
    }
}
