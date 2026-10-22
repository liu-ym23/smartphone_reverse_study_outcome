package com.bytedance.android.livesdk.interactivity.comment.newinput.provider;

import com.bytedance.android.live.core.log.ALogger;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes9.dex */
public final class w0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MarkHighlightController f136003a;

    public w0(MarkHighlightController r100) {
        this.f136003a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        ALogger.d("HighlightBacktrackUtil", String.valueOf((Throwable) r100));
        this.f136003a.j(false);
        int r101 = e72.c.f471166a;
        e72.c.a(this.f136003a.f135695t);
    }
}
