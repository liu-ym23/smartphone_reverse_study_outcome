package com.bytedance.android.livesdk.interactivity.comment.record.view;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveHighlightRecordTetris f136214a;

    public d(LiveHighlightRecordTetris r100) {
        this.f136214a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Boolean r101 = (Boolean) r100;
        this.f136214a.W();
    }
}
