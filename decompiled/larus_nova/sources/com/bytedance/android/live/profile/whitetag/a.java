package com.bytedance.android.live.profile.whitetag;

import com.bytedance.android.live.base.model.user.IBaseUser;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes47.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WhiteCertSubDialogFragment f87064a;

    public a(WhiteCertSubDialogFragment r100) {
        this.f87064a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        IBaseUser r101 = (IBaseUser) r100;
        WhiteCertSubDialogFragment r102 = this.f87064a;
        int r103 = WhiteCertSubDialogFragment.f87057j;
        r102.T90();
    }
}
