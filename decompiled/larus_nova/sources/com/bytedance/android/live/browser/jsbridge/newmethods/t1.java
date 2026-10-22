package com.bytedance.android.live.browser.jsbridge.newmethods;

import com.bytedance.android.live.browser.jsbridge.base.CheckAnchorEffectInUsedResultModel;
import com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusCallback;
import kotlin.Unit;

/* JADX INFO: loaded from: classes45.dex */
public final class t1 implements CheckAnchorStickerStatusCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f63660a;

    public t1(u1 r100) {
        this.f63660a = r100;
    }

    @Override // com.bytedance.android.livesdkapi.eventbus.CheckAnchorStickerStatusCallback
    public final void onResult(boolean r100) {
        u1 r101 = this.f63660a;
        CheckAnchorEffectInUsedResultModel r102 = new CheckAnchorEffectInUsedResultModel();
        r102.a(CheckAnchorEffectInUsedResultModel.Code.Success);
        CheckAnchorEffectInUsedResultModel.a r103 = new CheckAnchorEffectInUsedResultModel.a();
        r103.a(Boolean.valueOf(r100));
        Unit r104 = Unit.INSTANCE;
        r102.b(r103);
        r101.finishWithResult(r102);
    }
}
