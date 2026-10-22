package com.bytedance.android.live.effect.sticker.chain;

import com.bytedance.android.live.effect.common.LiveCommonStickerUIViewModel;
import com.bytedance.android.livesdkapi.depend.model.Sticker;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"onDownloadFail", "", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/Sticker;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final class LiveCommonDownloadStickerInterceptor$intercept$2 extends Lambda implements Function1<Sticker, Unit> {
    final /* synthetic */ l $chain;
    final /* synthetic */ LiveCommonStickerUIViewModel $stickerUIViewModel;

    public LiveCommonDownloadStickerInterceptor$intercept$2(LiveCommonStickerUIViewModel r100, l r101) {
        this.$stickerUIViewModel = r100;
        this.$chain = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "sticker");
        r100.setDownloading(false);
        r100.setDownloaded(false);
        LiveCommonStickerUIViewModel r101 = this.$stickerUIViewModel;
        if (r101 == null) goto L7;
        com.bytedance.live.datacontext.k<Sticker> r102 = r101.getStickerDownloadCompleteEvent();
        if (r102 == null) goto L7;
        r102.post(r100);
    L7:
        this.$chain.a();
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Sticker r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
