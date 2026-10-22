package com.bytedance.android.livesdk.player.layout;

import android.content.Context;
import com.bytedance.android.livesdk.config.ow;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.LiveMode;
import com.bytedance.android.livesdkapi.depend.model.live.gamesticker.BottomContainerSize;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.roomplayer.LivePlayerScene;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class m {
    public static final rc0.o a(final com.bytedance.android.live.platformplayer.layout.f r110) {
        Function0<com.bytedance.android.live.platformplayer.layout.a> r100 = r110.f85628s;
        if (r100 == null) goto L5;
        com.bytedance.android.live.platformplayer.layout.a r101 = r100.invoke();
    L5:
        Function1<rc0.c, Unit> r102 = new RevenuePlayerLayoutManagerKt$toRevenuePlayerLayoutContext$2(r110);
        boolean r103 = r110.f85610a;
        boolean r104 = r110.f85612c;
        boolean r105 = r110.f85613d;
        if (ow.f120936a.getValue().booleanValue() == true) goto L8;
        boolean r106 = !Intrinsics.areEqual(r110.f85618i, ILivePlayerScene.Companion.innerDraw());
    L12:
        int r107 = r110.f85619j;
        int r111 = r110.f85620k;
        int r112 = r110.f85616g;
        int r113 = r110.f85617h;
        LiveMode r114 = r110.f85623n;
        Context r115 = r110.f85630u;
        IRoom r108 = r110.f85621l;
        BottomContainerSize r109 = r110.f85632w;
        if (r109 == null) goto L15;
        rc0.a r116 = new rc0.a(r109.getMode(), r109.getWidth(), r109.getHeight());
    L17:
        return new rc0.o(r102, r103, r104, r105, r108, r106, r107, r111, r112, r113, r114, r115, r116, 8192);
    L15:
        r116 = null;
        goto L17
    L8:
        if (LivePlayerScene.INSTANCE.getIN_ROOM_SCENE_LIST().contains(r110.f85618i) == true) goto L10;
        r106 = true;
        goto L12
    L10:
        r106 = false;
        goto L12
    }
}
