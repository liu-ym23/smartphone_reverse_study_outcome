package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.x1;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameRoomStickerSize;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.GameStickerInfo;
import com.bytedance.android.livesdkapi.gamestickerv2.IPortraitLayoutCalculator;
import com.bytedance.android.livesdkapi.gamestickerv2.config.SizeMode;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class s implements IPortraitLayoutCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f106369a = null;

    public s() {
    }

    static {
        f106369a = new s();
    }

    public static Pair a(GameRoomStickerSize r100) {
        if (r100.getWidth() != 0) goto L6;
        return new Pair(-1, Integer.valueOf(s1.f(r100.getHeight())));
    L6:
        return new Pair(-1, Integer.valueOf((int) (((x1.h() * r100.getHeight()) * 1.0f) / r100.getWidth())));
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IPortraitLayoutCalculator
    public final Pair<Integer, Integer> calculate(GameStickerInfo r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        GameRoomStickerSize r101 = r100.getStickerSize();
        int r102 = r.f106368a[GameStickerSetting.f106270f.getSizeMode(r100).ordinal()];
        if (r102 == 1) goto L9;
        if (r102 == 2) goto L11;
        return a(r101);
    L11:
        return new Pair(-1, Integer.valueOf(s1.f(r101.getHeight())));
    L9:
        return a(r101);
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.IPortraitLayoutCalculator
    public final Pair<Integer, Integer> calculate(BottomContainerSize r100, int r101, int r102) {
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getHeight() <= 0) goto L28;
        int r103 = r100.getMode();     // Catch: Exception -> L23
        SizeMode r104 = SizeMode.AUTO;     // Catch: Exception -> L23
        if (r103 != r104.ordinal()) goto L10;
    L11:
        int r105 = r100.getMode();     // Catch: Exception -> L23
        if (r105 != SizeMode.FIXED.ordinal()) goto L16;
        Pair<Integer, Integer> r106 = new Pair(-1, Integer.valueOf(s1.f(r100.getHeight())));     // Catch: Exception -> L23
    L26:
        return r106;
    L16:
        if (r105 == r104.ordinal()) goto L18;
        return null;
    L18:
        if (r100.getWidth() > 0) goto L20;
        return null;
    L20:
        r106 = new Pair(-1, Integer.valueOf((int) (((r101 * r100.getHeight()) * 1.0f) / r100.getWidth())));     // Catch: Exception -> L23
        goto L26
    L10:
        if (r100.getMode() == SizeMode.FIXED.ordinal()) goto L11;
        return null;
    L29:
        return null;
    L28:
        return null;
    }
}
