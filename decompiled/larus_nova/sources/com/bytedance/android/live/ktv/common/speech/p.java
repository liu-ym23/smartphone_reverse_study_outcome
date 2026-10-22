package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class p<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SpeechRecognizer f70468a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f70469b;

    public p(SpeechRecognizer r100, Ref.IntRef r101) {
        this.f70468a = r100;
        this.f70469b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Ref.IntRef r102 = this.f70469b;
        int r103 = r102.element;
        if (r103 > 0) goto L7;
        Disposable r104 = this.f70468a.f70431l;
        if (r104 == null) goto L9;
        r104.dispose();
        return;
    L9:
        return;
    L7:
        r102.element = r103 - 1;
        this.f70468a.getClass();
        this.f70468a.g(null, 0, 0);
    }
}
