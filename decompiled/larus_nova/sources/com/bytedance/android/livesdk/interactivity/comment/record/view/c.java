package com.bytedance.android.livesdk.interactivity.comment.record.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class c<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordTetris f136213a;

    public c(LiveHighlightRecordTetris r100) {
        this.f136213a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        LiveHighlightRecordTetris r102 = this.f136213a;
        LiveHighlightRecordTetris.StopType r103 = LiveHighlightRecordTetris.StopType.OverTime;
        r102.Z();
    }
}
