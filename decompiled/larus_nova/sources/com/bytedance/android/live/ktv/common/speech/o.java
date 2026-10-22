package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class o<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpeechRecognizer f70467a;

    public o(SpeechRecognizer r100) {
        this.f70467a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = ((pv0.c) r100).f530782a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f70467a.onSei(r101);
    }
}
