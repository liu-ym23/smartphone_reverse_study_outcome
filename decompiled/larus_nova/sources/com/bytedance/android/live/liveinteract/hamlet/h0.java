package com.bytedance.android.live.liveinteract.hamlet;

import android.view.ViewGroup;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.xplay.basic.api.XplayBasicMessageType;
import io.reactivex.disposables.Disposable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class h0 implements g10.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ HamletAvatarWidget f73507a;

    public h0(HamletAvatarWidget r100) {
        this.f73507a = r100;
    }

    @Override // g10.d
    public final void a(com.bytedance.android.live.broadcastgame.api.xplay.f r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        Intrinsics.checkNotNullParameter(r100, "instance");
        ALogger.i("HamletAvatar", "onInstanceCreate");
        HamletAvatarWidget r101 = this.f73507a;
        r101.f73439b = r100;
        r101.cr();
    }

    @Override // g10.d
    public final void d(com.bytedance.android.live.broadcastgame.api.xplay.f r100) {
        Intrinsics.checkNotNullParameter(r100, "instance");
        ALogger.i("HamletAvatar", "onInstanceDestroy");
        HamletAvatarWidget r101 = this.f73507a;
        int r102 = HamletAvatarWidget.T;
        r101.getClass();
        if (gh0.a.d() == false) goto L5;
        UtilityKotlinExtentionsKt.s(0, false, false, HamletAvatarWidget$resetAnchorSeiData$1.INSTANCE, 7);
    L5:
        Disposable r103 = r101.f73442e;
        if (r103 == null) goto L8;
        r103.dispose();
    L8:
        ViewGroup r104 = r101.Q;
        if (r104 == null) goto L11;
        r104.removeAllViews();
    L11:
        gd1.b r105 = r101.f73441d;
        if (r105 == null) goto L14;
        r105.c(XplayBasicMessageType.Orser_Song_Message);
    L14:
        r101.f73440c = null;
        r101.Wq(false);
        r101.Aq("onXplayDestory", true);
        this.f73507a.f73439b = null;
    }
}
