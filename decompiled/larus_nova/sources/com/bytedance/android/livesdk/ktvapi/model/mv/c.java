package com.bytedance.android.livesdk.ktvapi.model.mv;

import android.view.Surface;
import com.bytedance.android.livesdkapi.depend.message.RoomSongInfo;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes9.dex */
public interface c {
    h<?> a();

    lb0.b b();

    void c(Surface r100);

    void f(boolean r100, com.bytedance.android.live.pushstream.d r101, boolean r102);

    void h(String r100);

    void i(RoomSongInfo r100, Function0<Unit> r101, Function1<? super Integer, Unit> r102);

    Float m();

    void release();

    void stop();
}
