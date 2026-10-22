package com.bytedance.android.livesdk.chatroom.gamestickerv2;

import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerParams;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.gamestickerv2.ILandscapeLayoutCalculator;
import com.bytedance.android.livesdkapi.gamestickerv2.config.SizeMode;

/* JADX INFO: loaded from: classes7.dex */
public final class q implements ILandscapeLayoutCalculator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f106367a = null;

    public q() {
    }

    static {
        f106367a = new q();
    }

    @Override // com.bytedance.android.livesdkapi.gamestickerv2.ILandscapeLayoutCalculator
    public final BottomContainerParams calculate(BottomContainerSize r210, int r211, int r212, int r213, int r214) {
        if (r210 != null) goto L5;
        return null;
    L5:
        if (r210.getHeight() <= 0) goto L34;
        int r100 = r210.getMode();     // Catch: Exception -> L29
        float r101 = 0.0f;
        if (r100 != SizeMode.FIXED.ordinal()) goto L18;
        float r102 = (r213 * 1.0f) / r214;     // Catch: Exception -> L29
        float r103 = r211 * 1.0f;     // Catch: Exception -> L29
        float r104 = r212 * 1.0f;     // Catch: Exception -> L29
        float r105 = UtilityKotlinExtentionsKt.h(r210.getHeight());     // Catch: Exception -> L29
        float r106 = Math.min(1.0f * r103, (r104 - r105) * r102);     // Catch: Exception -> L29
        float r107 = r106 / r102;     // Catch: Exception -> L29
        if (r106 >= r103) goto L12;
        float r108 = (r103 - r106) / 2;     // Catch: Exception -> L29
    L14:
        if ((r107 + r105) >= r104) goto L16;
        r101 = ((r104 - r107) - r105) / 2;     // Catch: Exception -> L29
    L16:
        int r110 = (int) r108;     // Catch: Exception -> L29
        int r109 = (int) r106;     // Catch: Exception -> L29
        return new BottomContainerParams(r110, (int) r101, r109, (int) r107, r110, (int) (r101 + r107), r109, (int) r105, null, 256, null);
    L12:
        r108 = 0.0f;
        goto L14
    L18:
        if (r100 != SizeMode.AUTO.ordinal()) goto L33;
        float r111 = (r213 * 1.0f) / r214;     // Catch: Exception -> L29
        float r112 = r211 * 1.0f;     // Catch: Exception -> L29
        float r113 = r212 * 1.0f;     // Catch: Exception -> L29
        float r114 = (r210.getWidth() * 1.0f) / r210.getHeight();     // Catch: Exception -> L29
        float r115 = Math.min(1.0f * r112, ((r111 * r114) / (r111 + r114)) * r113);     // Catch: Exception -> L29
        float r116 = r115 / r111;     // Catch: Exception -> L29
        float r117 = r115 / r114;     // Catch: Exception -> L29
        if (r115 >= r112) goto L22;
        float r118 = (r112 - r115) / 2;     // Catch: Exception -> L29
    L24:
        if ((r114 + r116) >= r113) goto L26;
        r101 = ((r113 - r116) - r117) / 2;     // Catch: Exception -> L29
    L26:
        int r119 = (int) r118;     // Catch: Exception -> L29
        int r120 = (int) r115;     // Catch: Exception -> L29
        return new BottomContainerParams(r119, (int) r101, r120, (int) r116, r119, (int) (r101 + r116), r120, (int) r117, null, 256, null);
    L22:
        r118 = 0.0f;
        goto L24
    L33:
        return null;
    L35:
        return null;
    L34:
        return null;
    }
}
