package com.bytedance.android.livesdk.ktvapi.model.mv;

import android.content.Context;
import com.ss.android.ugc.aweme.live.alphaplayer.player.AbsPlayer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public abstract class h<T extends AbsPlayer<?>> extends AbsPlayer<T> {
    public abstract int h();

    public abstract void i(Function1<? super Integer, Unit> r100);

    public abstract void j();

    public abstract void k(Function1<? super Integer, Unit> r100);

    public abstract void l(Function1<? super n, Unit> r100);

    public h(Context r100) {
        super(r100);
    }
}
