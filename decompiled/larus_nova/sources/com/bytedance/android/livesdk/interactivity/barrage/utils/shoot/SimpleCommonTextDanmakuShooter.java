package com.bytedance.android.livesdk.interactivity.barrage.utils.shoot;

import com.bytedance.android.livesdk.interactivity.zdanmaku.simplewidget.PortraitSimpleZDanmakuPresenter;
import java.util.LinkedList;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class SimpleCommonTextDanmakuShooter extends h {
    public SimpleCommonTextDanmakuShooter(PortraitSimpleZDanmakuPresenter.e r100) {
        Intrinsics.checkNotNullParameter(r100, "danmakuReceiver");
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h, r22.a
    public final /* bridge */ /* synthetic */ void e(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        l(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.barrage.utils.shoot.h
    public final void l(com.bytedance.android.livesdk.interactivity.api.publicscreen.d r100) {
        Intrinsics.checkNotNullParameter(r100, "danmaku");
        ((LinkedList) this.f133985c).add(r100);
        k();
    }

    public final void n(final long r100, final long r101) {
        CollectionsKt.removeAll(this.f133985c, new SimpleCommonTextDanmakuShooter$onDanmakuTimeout$1(r101, r100));
    }
}
