package com.bytedance.android.shopping.anchorv3.detail.widget.playerblock;

import android.content.Context;
import com.bytedance.android.shopping.api.video.ECVideoPlayerView;
import com.bytedance.android.shopping.api.video.ScaleType;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.ttvideoengine.model.VideoRef;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/api/video/ECVideoPlayerView;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final class PlayAbilityV2$playerView$2 extends Lambda implements Function0<ECVideoPlayerView> {
    final /* synthetic */ i this$0;

    public PlayAbilityV2$playerView$2(i r100) {
        this.this$0 = r100;
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ECVideoPlayerView invoke() {
        Context r100 = this.this$0.f164981a.getContext();
        i r101 = this.this$0;
        r101.getClass();
        ECVideoPlayerView r102 = new ECVideoPlayerView(r100, null, 0, new com.bytedance.android.shopping.api.video.l(null, r101.f164982b.f170648h, false, false, null, false, false, VideoRef.VALUE_VIDEO_REF_CONST_DEPTH), 6);
        i r103 = this.this$0;
        com.bytedance.android.shopping.api.video.d r104 = r103.f164982b;
        if (r104.f170648h == true) goto L7;
        r103.getClass();
        if (i.g0(r102, null, r104) == false) goto L7;
        r102.w(ScaleType.FIT_CENTER);
        this.this$0.getClass();
        r102.r(null);
    L7:
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ECVideoPlayerView invoke() {
        return invoke();
    }
}
