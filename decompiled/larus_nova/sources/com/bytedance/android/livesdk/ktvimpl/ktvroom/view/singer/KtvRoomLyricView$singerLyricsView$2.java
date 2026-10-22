package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.singer;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.android.livesdk.ktvimpl.base.view.KtvAnchorLyricsDisplayView;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import ub0.b;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/livesdk/ktvimpl/base/view/KtvAnchorLyricsDisplayView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 5, 1})
public final class KtvRoomLyricView$singerLyricsView$2 extends Lambda implements Function0<KtvAnchorLyricsDisplayView> {
    final /* synthetic */ Context $context;
    final /* synthetic */ KtvRoomLyricView this$0;

    public KtvRoomLyricView$singerLyricsView$2(KtvRoomLyricView r100, Context r101) {
        this.this$0 = r100;
        this.$context = r101;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final KtvAnchorLyricsDisplayView invoke() {
        AttributeSet r100 = null;
        final KtvAnchorLyricsDisplayView r101 = new KtvAnchorLyricsDisplayView(this.$context, r100, 6, 0);
        if (this.this$0.getCustomSingerConfig() != null) goto L5;
        r101.c(new KtvRoomLyricView$singerLyricsView$2$$special$$inlined$apply$lambda$1(this));
    L8:
        return r101;
    L5:
        final b r102 = this.this$0.getCustomSingerConfig();
        if (r102 == null) goto L8;
        r101.c(new KtvRoomLyricView$singerLyricsView$2$$special$$inlined$apply$lambda$2(r102, r101, this));
        goto L8
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ KtvAnchorLyricsDisplayView invoke() {
        return invoke();
    }
}
