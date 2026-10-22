package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar_behavior;

import android.app.Dialog;
import com.bytedance.android.livesdkapi.business.ILiveRenQiBaoService;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes8.dex */
public final class r4<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ q4 f117358a;

    public r4(q4 r100) {
        this.f117358a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        zg1.n2 r101 = (zg1.n2) r100;
        Dialog r102 = this.f117358a.f117347a;
        if (r102 == null) goto L6;
        ((ILiveRenQiBaoService) jc1.k.n(ILiveRenQiBaoService.class)).showDialogContent(r102, !r101.f571888a);
        return;
    }
}
