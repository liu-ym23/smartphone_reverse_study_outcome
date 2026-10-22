package bk0;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.b1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.c1;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.n0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.o0;
import com.bytedance.android.live.liveinteract.voicechat.emoji.panel.x0;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f19284a;

    public interface a {
        boolean a();

        boolean b();

        boolean c();

        boolean isFollowed();

        boolean isMute();
    }

    public d(a r100) {
        Intrinsics.checkNotNullParameter(r100, ShortVideoSegments.KEY_PROP_PROVIDER);
        this.f19284a = r100;
    }

    @Override // bk0.e
    public final boolean a(com.bytedance.android.live.liveinteract.voicechat.emoji.panel.g r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        if ((r100 instanceof n0) == true) goto L36;
        if ((r100 instanceof x0) == true) goto L36;
        if ((r100 instanceof b1) == true) goto L34;
        if ((r100 instanceof c1) == true) goto L34;
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.q) == false) goto L17;
        return !this.f19284a.isFollowed();
    L17:
        if ((r100 instanceof a1) == false) goto L21;
        return this.f19284a.isFollowed();
    L21:
        if ((r100 instanceof o0) == false) goto L25;
        return this.f19284a.a();
    L25:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.a) == false) goto L29;
        return this.f19284a.c();
    L29:
        if ((r100 instanceof com.bytedance.android.live.liveinteract.voicechat.emoji.panel.r) == true) goto L31;
        return true;
    L31:
        return this.f19284a.b();
    L34:
        return this.f19284a.isMute();
    L36:
        return !this.f19284a.isMute();
    }
}
