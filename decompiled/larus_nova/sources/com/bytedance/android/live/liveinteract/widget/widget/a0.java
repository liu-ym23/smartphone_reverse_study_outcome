package com.bytedance.android.live.liveinteract.widget.widget;

import android.graphics.drawable.NinePatchDrawable;
import com.bytedance.android.livesdk.chatroom.utils.a3;
import com.bytedance.common.utility.UIUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a0 implements a3.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SelectPairRankAdapter.SelectPairRankItemViewHolder f81038a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ py.h f81039b;

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void onFail() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.utils.a3.b
    public final void a(NinePatchDrawable r100) {
        Intrinsics.checkNotNullParameter(r100, "ninePatchDrawable");
        UIUtils.setText(this.f81038a.f81020f, this.f81039b.getClubName());
    }

    public a0(SelectPairRankAdapter.SelectPairRankItemViewHolder r100, py.h r101) {
        this.f81038a = r100;
        this.f81039b = r101;
    }
}
