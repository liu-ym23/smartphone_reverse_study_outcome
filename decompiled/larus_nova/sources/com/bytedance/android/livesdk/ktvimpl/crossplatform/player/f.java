package com.bytedance.android.livesdk.ktvimpl.crossplatform.player;

import io.reactivex.functions.Consumer;
import java.util.Map;

/* JADX INFO: loaded from: classes10.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ KtvMusicPlayer f143815a;

    public f(KtvMusicPlayer r100) {
        this.f143815a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        KtvMusicPlayer r101 = this.f143815a;
        r101.b((Map) r100);
    }
}
