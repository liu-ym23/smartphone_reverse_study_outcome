package bk0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m extends b {
    public m() {
    }

    @Override // bk0.b, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof n0) == false) goto L6;
    L16:
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L16;
        if ((r100 instanceof r0) == true) goto L16;
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q) == true) goto L16;
        if ((r100 instanceof a1) == true) goto L16;
        return false;
    }
}
