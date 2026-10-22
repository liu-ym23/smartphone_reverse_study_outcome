package bk0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class o extends b {
    public o() {
    }

    @Override // bk0.b, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof o0) == false) goto L6;
        return true;
    L6:
        return super.a(r100);
    }
}
