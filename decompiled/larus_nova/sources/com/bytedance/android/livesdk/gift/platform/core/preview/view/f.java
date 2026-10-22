package com.bytedance.android.livesdk.gift.platform.core.preview.view;

import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ UgcGiftPoolDialog f131091a;

    public f(UgcGiftPoolDialog r100) {
        this.f131091a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a r101 = (com.bytedance.android.livesdk.gift.platform.core.preview.viewmodel.a) r100;
        if (r101 == null) goto L10;
        UgcGiftPoolDialog r102 = this.f131091a;
        BaseUgcGiftAdapter<? extends RecyclerView.ViewHolder> r103 = r102.f131013m;
        if (r103 == null) goto L9;
        r103.y2(r101, r102.f131004d, r102.f131005e);
        return;
    L9:
        return;
    }
}
