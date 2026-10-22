package com.bytedance.android.live.effect.sticker.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "index", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class LiveStickerComposerPageAdapterKt$generateNormalPageView$1 extends Lambda implements Function1<Integer, Unit> {
    final /* synthetic */ View $normalPageView;

    public LiveStickerComposerPageAdapterKt$generateNormalPageView$1(View r100) {
        this.$normalPageView = r100;
        super(1);
    }

    public final void invoke(int r100) {
        View r101 = this.$normalPageView;     // Catch: Exception -> L8
        if (r101 == null) goto L13;
        RecyclerView r102 = (RecyclerView) r101.findViewById(R.id.content_container);     // Catch: Exception -> L8
        if (r102 == null) goto L14;
        r102.scrollToPosition(r100);     // Catch: Exception -> L8
        return;
    L14:
        return;
    L13:
        return;
    L8:
        e = move-exception;
        int r103 = x8.a.f562881a;
        int r104 = LiveStickerComposerPageAdapterKt.f68450a;
        x8.a.b("ttlive_anchor_effect_LiveStickerComposerPageAdapterKt", e.toString(), false);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer r100) {
        invoke(r100.intValue());
        return Unit.INSTANCE;
    }
}
