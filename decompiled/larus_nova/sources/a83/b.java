package a83;

import com.bytedance.android.shopping.anchorv3.detail.widget.playerblock.PlayAbilityCacheScene;
import com.bytedance.android.shopping.anchorv4.video.base.BasePdpVideoView;
import com.bytedance.android.shopping.anchorv4.video.base.bridge.HeadVideoPlayerBridge;
import com.bytedance.android.shopping.api.video.AVScene;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes12.dex */
public final class b implements c {
    public b() {
    }

    @Override // a83.c
    public final y73.a a(BasePdpVideoView r100, AVScene r101, PlayAbilityCacheScene r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "avScene");
        Intrinsics.checkNotNullParameter(r102, "abilityCacheScene");
        return new HeadVideoPlayerBridge(r100, r101, r102);
    }
}
