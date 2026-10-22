package com.bytedance.android.livesdk.dislike.preload.datamanager;

import io.reactivex.functions.Consumer;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes8.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LLPanelPreprocessor f122193a;

    public a(LLPanelPreprocessor r100) {
        this.f122193a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        Iterator<T> r102 = ((List) this.f122193a.f122182h.getValue()).iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((com.bytedance.android.livesdk.dislike.preload.loader.a) r102.next()).d();
        goto L4
    }
}
