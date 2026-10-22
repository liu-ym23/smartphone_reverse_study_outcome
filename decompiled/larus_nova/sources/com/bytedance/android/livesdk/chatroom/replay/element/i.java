package com.bytedance.android.livesdk.chatroom.replay.element;

import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class i<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLoadingWidget.g f108553a;

    public i(ReplayLoadingWidget.g r100) {
        this.f108553a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        UtilityKotlinExtentionsKt.i(ReplayLoadingWidget.yq(this.f108553a.f108401a));
    }
}
