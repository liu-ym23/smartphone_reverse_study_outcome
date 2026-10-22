package com.bytedance.android.livesdk.chatroom.gamestickerv2.componentv2;

import android.view.View;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.gamestickerv2.config.ComponentMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes7.dex */
public interface g {
    GameStickerInfo a();

    void b(GameStickerInfo r100, Function2<? super Integer, ? super String, Unit> r101, Function2<? super Integer, ? super String, Unit> r102);

    void c(Function0<Unit> r100, Function0<Unit> r101);

    int d();

    void e(GameStickerInfo r100, Function3<? super View, ? super Integer, ? super String, Unit> r101, Function2<? super Integer, ? super String, Unit> r102);

    ComponentMode mode();

    void onOrientationChanged(int r100);

    ComponentState state();

    void unload();
}
