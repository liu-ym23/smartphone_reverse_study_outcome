package com.bytedance.android.livesdk.rank;

import android.content.DialogInterface;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes11.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialogInterface.OnDismissListener f156963a;

    public f(DialogInterface.OnDismissListener r100) {
        this.f156963a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ((zy0.d) r100).m1(new RankService$openRankDialogV2$2$$special$$inlined$apply$lambda$1(this));
    }
}
