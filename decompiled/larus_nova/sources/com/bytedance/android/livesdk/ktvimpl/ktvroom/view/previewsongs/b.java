package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import io.reactivex.functions.Consumer;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes10.dex */
public final /* synthetic */ class b implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Function1 f145256a;

    public b(Function1 r100) {
        this.f145256a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final /* synthetic */ void accept(Object r100) {
        this.f145256a.invoke(r100);
    }
}
