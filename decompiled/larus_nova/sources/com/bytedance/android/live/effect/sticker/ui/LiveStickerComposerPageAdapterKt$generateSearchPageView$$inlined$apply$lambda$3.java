package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "com/bytedance/android/live/effect/sticker/ui/LiveStickerComposerPageAdapterKt$generateSearchPageView$keywordView$1$1"}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerPageAdapterKt$generateSearchPageView$$inlined$apply$lambda$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ String $keyword$inlined;
    final /* synthetic */ LiveStickerComposerPageAdapterKt this$0;

    public LiveStickerComposerPageAdapterKt$generateSearchPageView$$inlined$apply$lambda$3(LiveStickerComposerPageAdapterKt r100, String r101) {
        this.this$0 = r100;
        this.$keyword$inlined = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        m90.c<Boolean> r100 = m90.b.f512558p;
        LiveStickerComposerPageAdapterKt r101 = this.this$0;
        int r102 = LiveStickerComposerPageAdapterKt.f68450a;
        r101.getClass();
        r100.e(null, Boolean.TRUE);
        this.this$0.getClass();
        xs2.b.a().post(new a(this.$keyword$inlined));
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
