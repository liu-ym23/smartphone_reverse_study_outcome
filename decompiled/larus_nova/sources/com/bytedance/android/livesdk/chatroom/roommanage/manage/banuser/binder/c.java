package com.bytedance.android.livesdk.chatroom.roommanage.manage.banuser.binder;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomBanUserViewHolder f111465a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b f111466b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f111465a.f111459h.setText(this.f111466b.f87276a);
    }

    public c(LiveRoomBanUserViewHolder r100, com.bytedance.android.live.profit.fansclub.b r101) {
        this.f111465a = r100;
        this.f111466b = r101;
    }
}
