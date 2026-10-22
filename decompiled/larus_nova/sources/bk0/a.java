package bk0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public class a implements e {
    public a() {
    }

    @Override // bk0.e
    public boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof n0) == false) goto L6;
        return true;
    L6:
        if ((r100 instanceof b1) == false) goto L9;
        return true;
    L9:
        if ((r100 instanceof x0) == false) goto L12;
        return true;
    L12:
        if ((r100 instanceof c1) == false) goto L15;
        return true;
    L15:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a) == false) goto L18;
        return true;
    L18:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n) == false) goto L21;
        return true;
    L21:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r) == false) goto L24;
        return true;
    L24:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d) == true) goto L35;
        return false;
    L35:
        return true;
    }
}
