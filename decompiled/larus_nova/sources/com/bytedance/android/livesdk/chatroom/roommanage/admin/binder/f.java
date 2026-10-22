package com.bytedance.android.livesdk.chatroom.roommanage.admin.binder;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class f implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveRoomAdminViewHolder f111264a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b f111265b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f111264a.f111251i.setText(this.f111265b.f87276a);
    }

    public f(LiveRoomAdminViewHolder r100, com.bytedance.android.live.profit.fansclub.b r101) {
        this.f111264a = r100;
        this.f111265b = r101;
    }
}
