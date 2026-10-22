package bk0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class g extends a {
    public g() {
    }

    @Override // bk0.a, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof x0) == false) goto L6;
    L10:
        return true;
    L6:
        if ((r100 instanceof c1) == true) goto L10;
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n) == true) goto L10;
        return false;
    }
}
