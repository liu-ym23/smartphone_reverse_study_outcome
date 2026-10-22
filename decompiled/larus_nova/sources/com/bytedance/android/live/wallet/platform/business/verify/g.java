package com.bytedance.android.live.wallet.platform.business.verify;

import android.content.DialogInterface;
import io.reactivex.subjects.PublishSubject;

/* JADX INFO: loaded from: classes7.dex */
public final class g implements DialogInterface.OnCancelListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PublishSubject f102727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Throwable f102728b;

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface r100) {
        this.f102727a.onError(this.f102728b);
    }

    public g(PublishSubject r100, Throwable r101) {
        this.f102727a = r100;
        this.f102728b = r101;
    }
}
