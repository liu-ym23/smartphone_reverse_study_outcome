package com.bytedance.android.live.liveinteract.chatroom.chatroom.seat;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.widget.HSImageView;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes46.dex */
public final class u<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HSImageView f72347a;

    public u(HSImageView r100) {
        this.f72347a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        this.f72347a.setVisibility(8);
        UtilityKotlinExtentionsKt.q(this.f72347a);
    }
}
