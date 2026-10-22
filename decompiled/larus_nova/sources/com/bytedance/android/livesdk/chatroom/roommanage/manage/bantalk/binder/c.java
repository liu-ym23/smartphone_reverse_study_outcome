package com.bytedance.android.livesdk.chatroom.roommanage.manage.bantalk.binder;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomBanTalkViewHolder f111419a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b f111420b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f111419a.f111413h.setText(this.f111420b.f87276a);
    }

    public c(LiveRoomBanTalkViewHolder r100, com.bytedance.android.live.profit.fansclub.b r101) {
        this.f111419a = r100;
        this.f111420b = r101;
    }
}
