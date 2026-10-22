package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes45.dex */
public final class e<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkSpeechServerRecognizer f70445a;

    public e(LinkSpeechServerRecognizer r100) {
        this.f70445a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        String r101 = ((pv0.c) r100).f530782a;
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        this.f70445a.onSei(r101);
    }
}
