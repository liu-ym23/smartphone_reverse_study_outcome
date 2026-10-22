package com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.viewholder;

import android.view.View;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.VSTextViewWapperBarrage;
import com.bytedance.android.livesdk.chatroom.replay.interactionmsg.danmaku.barrage.d;
import com.ss.ugc.live.barrage.barrage.AbsBarrage;
import com.ss.ugc.live.barrage.controller.ScrollBarrageController;
import jq1.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a extends VSTextViewWapperBarrage implements ScrollBarrageController.f, ScrollBarrageController.c, ScrollBarrageController.g {
    public float A;
    public final float B;
    public final float C;
    public final d D;
    public final b E;

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.c
    public final boolean a() {
        if (this.A >= this.C) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.g
    public final int[] d() {
        return this.D.f109001f;
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.f
    public final boolean c(int r100) {
        if (this.A < this.C) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs((this.f458058f.centerX() - (this.f458065m.f458068b * 2)) - (r100 / 2)) >= this.B) goto L7;
        return true;
    }

    @Override // com.ss.ugc.live.barrage.controller.ScrollBarrageController.f
    public final void f(float r100) {
        this.A += r100;
    }

    public a(View r100, AbsBarrage.b r101, d r102, CharSequence r103, b r104) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "config");
        Intrinsics.checkNotNullParameter(r102, "danmakuSettingConfig");
        Intrinsics.checkNotNullParameter(r103, "textContent");
        super(r100, r101);
        this.C = 5000.0f;
        this.D = r102;
        this.E = r104;
        this.B = 6.0f;
    }
}
