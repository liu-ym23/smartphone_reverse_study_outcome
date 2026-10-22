package com.bytedance.android.shopping.widget.ecvideoplayer;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class ECVideoPlayer$dispatchVideoStatus$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ b $ecVideoListener;
    final /* synthetic */ ECVideoPlayer this$0;

    public ECVideoPlayer$dispatchVideoStatus$1(ECVideoPlayer r100, b r101) {
        this.this$0 = r100;
        this.$ecVideoListener = r101;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        int r100 = this.this$0.f187343g.f187406d;
        if (r100 == (-1)) goto L22;
        if (r100 != 0) goto L6;
        this.$ecVideoListener.onIdle();
        return;
    L6:
        if (r100 != 3) goto L8;
        this.$ecVideoListener.onPlaying();
        return;
    L8:
        if (r100 != 4) goto L10;
        this.$ecVideoListener.onPaused();
        return;
    L10:
        if (r100 != 6) goto L12;
        this.$ecVideoListener.onRelease();
        return;
    L12:
        if (r100 != 7) goto L14;
        this.$ecVideoListener.E();
        return;
    L14:
        if (r100 != 8) goto L30;
        this.$ecVideoListener.w();
        return;
    L30:
        return;
    L22:
        this.$ecVideoListener.onError(this.this$0.f187348l);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.INSTANCE;
    }
}
