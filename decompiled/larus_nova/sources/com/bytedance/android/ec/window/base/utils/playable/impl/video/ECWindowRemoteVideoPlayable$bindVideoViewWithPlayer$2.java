package com.bytedance.android.ec.window.base.utils.playable.impl.video;

import com.bytedance.android.shopping.api.video.AVScene;
import com.bytedance.android.shopping.widget.ecvideoplayer.ECVideoPlayer;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowRemoteVideoPlayable$bindVideoViewWithPlayer$2 extends FunctionReferenceImpl implements Function0<ECVideoPlayer> {
    public ECWindowRemoteVideoPlayable$bindVideoViewWithPlayer$2(d r100) {
        super(0, r100, d.class, "generatePlayer", "generatePlayer()Lcom/bytedance/android/shopping/widget/ecvideoplayer/ECVideoPlayer;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ECVideoPlayer invoke() {
        d r100 = (d) this.receiver;
        int r101 = d.f49752j;
        r100.getClass();
        ECVideoPlayer r102 = new ECVideoPlayer(r100.f49757g.getContext(), AVScene.WINDOW_INNER_FLOW);
        r102.n(r100.f49759i);
        return r102;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ ECVideoPlayer invoke() {
        return invoke();
    }
}
