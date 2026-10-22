package com.bytedance.android.livesdk.chatroom.replay.element;

import com.bytedance.android.livesdk.chatroom.vs_base.util.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class h<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ReplayLoadingWidget.g f108552a;

    public h(ReplayLoadingWidget.g r100) {
        this.f108552a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ReplayLoadingWidget.g r101 = (ReplayLoadingWidget.g) r100;
        UtilityKotlinExtentionsKt.i(ReplayLoadingWidget.yq(this.f108552a.f108401a));
    }
}
