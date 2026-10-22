package com.bytedance.android.livesdk.chatroom.replay.player;

import android.content.ComponentCallbacks2;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.chatroom.vs_base.player.ReplayPlayerScene;
import com.bytedance.android.livesdk.utils.e5;
import com.bytedance.android.livesdk.x8;
import com.ss.android.videoshop.context.VideoContext;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class g extends b {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f109576k;

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.b
    public final c a() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final ReplayPlayerScene getScene() {
        return null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final boolean n() {
        return false;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.b, com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final void p() {
        if (this.f109562h == false) goto L5;
        VideoContext.n0(this.f109555a.getContext()).H0(e5.a());
        VideoContext.n0(this.f109555a.getContext()).f455965s = true;
        VideoContext.n0(this.f109555a.getContext()).f455947a.f555386y = null;
    L5:
        super.p();
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.b, com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final void i() {
        super.i();
        this.f109576k = true;
        throw null;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.b, com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final void o() {
        super.o();
        if (this.f109576k == true) goto L8;
        int r100 = x8.f162541a;
        ComponentCallbacks2 r101 = x8.c(this.f109555a.getContext());
        if ((r101 instanceof LifecycleOwner) == false) goto L9;
        VideoContext.n0(this.f109555a.getContext()).C0(((LifecycleOwner) r101).getLifecycle(), new oic.b());
        return;
    L9:
        return;
    }

    @Override // com.bytedance.android.livesdk.chatroom.replay.player.b, com.bytedance.android.livesdk.chatroom.vs_base.player.c
    public final void k(com.bytedance.android.livesdk.chatroom.vs_base.player.d r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        super.k(r100);
        if (this.f109576k == false) goto L5;
        return;
    L5:
        int r101 = i.f109585a;
        StringBuilder r102 = new StringBuilder("video pre play, dispatch event when register, episode_id = ");
        r102.append(this.f109564j.id());
        r102.append(" ,listener = ");
        r102.append(r100);
        r102.append(" ,scene = ");
        throw null;
    }
}
