package com.bytedance.android.live.liveinteract.interact.audience.fragment;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class m implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ InteractAudienceViewHolder f73825a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.bytedance.android.live.profit.fansclub.b f73826b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        this.f73825a.f73804j.setText(this.f73826b.f87276a);
    }

    public m(InteractAudienceViewHolder r100, com.bytedance.android.live.profit.fansclub.b r101) {
        this.f73825a = r100;
        this.f73826b = r101;
    }
}
