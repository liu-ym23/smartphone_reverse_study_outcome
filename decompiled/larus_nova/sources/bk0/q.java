package bk0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.i0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.j0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class q extends c {
    public q() {
    }

    @Override // bk0.c, bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof n0) == false) goto L6;
    L31:
        return true;
    L6:
        if ((r100 instanceof b1) == true) goto L31;
        if ((r100 instanceof x0) == true) goto L31;
        if ((r100 instanceof c1) == true) goto L31;
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a) == true) goto L31;
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n) == true) goto L31;
        if ((r100 instanceof i0) == true) goto L31;
        if ((r100 instanceof j0) == true) goto L31;
        if ((r100 instanceof o0) == true) goto L31;
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.d) == true) goto L31;
        return super.a(r100);
    }
}
