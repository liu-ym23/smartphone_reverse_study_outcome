package com.bytedance.android.live.ktv.common.speech;

import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes45.dex */
public final class j<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkSpeechServerRecognizer f70451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f70452b;

    public j(LinkSpeechServerRecognizer r100, Ref.IntRef r101) {
        this.f70451a = r100;
        this.f70452b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Ref.IntRef r102 = this.f70452b;
        int r103 = r102.element;
        if (r103 > 0) goto L7;
        Disposable r104 = this.f70451a.f70381m;
        if (r104 == null) goto L11;
        r104.dispose();
        return;
    L11:
        return;
    L7:
        r102.element = r103 - 1;
        LinkSpeechServerRecognizer r105 = this.f70451a;
        if (r105.f70391w == true) goto L13;
        r105.s(null, 0, 0);
        return;
    }
}
