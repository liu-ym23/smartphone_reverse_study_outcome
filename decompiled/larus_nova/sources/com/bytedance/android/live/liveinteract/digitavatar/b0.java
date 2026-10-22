package com.bytedance.android.live.liveinteract.digitavatar;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class b0 implements y.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f72602a;

    public b0(a0 r100) {
        this.f72602a = r100;
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
    public final void a(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        ALogger.i("KtvDigitAvatar", "预下载recognition识别道具success，耗时 " + (System.currentTimeMillis() - this.f72602a.f72594a) + "ms");
        a0.b r101 = this.f72602a.f72597d;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    @Override // com.bytedance.android.live.liveinteract.digitavatar.y.a
    public final void onError(Exception r100) {
        Intrinsics.checkNotNullParameter(r100, "e");
        ALogger.w("KtvDigitAvatar", "预下载recognition识别道具fail，耗时 " + (System.currentTimeMillis() - this.f72602a.f72594a) + "ms", r100);
        a0.b r101 = this.f72602a.f72597d;
        if (r101 == null) goto L6;
        r101.b(r100);
        return;
    }
}
