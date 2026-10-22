package com.bytedance.android.live.effect.sticker.ui;

import com.bytedance.android.live.effect.api.LiveEffectContext;
import com.bytedance.android.live.uikit.recyclerview.LoadingStatusView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"loadTabStickers", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerPageAdapterKt$generateNormalPageView$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ d $holder;
    final /* synthetic */ CharSequence $pageTitle;
    final /* synthetic */ int $position;
    final /* synthetic */ LoadingStatusView $statusView;
    final /* synthetic */ LiveStickerComposerPageAdapterKt this$0;

    public LiveStickerComposerPageAdapterKt$generateNormalPageView$2(LiveStickerComposerPageAdapterKt r100, int r101, CharSequence r102, d r103, LoadingStatusView r104) {
        this.this$0 = r100;
        this.$position = r101;
        this.$pageTitle = r102;
        this.$holder = r103;
        this.$statusView = r104;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        List<String> r100 = LiveEffectContext.f66734h;
        LiveStickerComposerPageAdapterKt r101 = this.this$0;
        int r102 = LiveStickerComposerPageAdapterKt.f68450a;
        r101.getClass();
        LiveEffectContext.a.a(null);
        throw null;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
