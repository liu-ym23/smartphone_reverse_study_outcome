package com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.graphics.drawable.DrawableCompat;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class s extends r {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View f110063g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ViewGroup f110064h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f110065i;

    @Override // com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.r, com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.c0.b
    public final void p4(View r100, DataCenter r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "dataCenter");
        super.p4(r100, r101);
        this.f110063g = r100;
        this.f110064h = (ViewGroup) r100.findViewById(R.id.icon);
        Drawable r102 = r100.getContext().getResources().getDrawable(R.drawable.ttlive_vs_share_unfolded_landscape);
        if (this.f110065i == false) goto L5;
        DrawableCompat.setTint(r102, r100.getResources().getColor(R.color.ttlive_replay_toolbar_color));
    L5:
        ViewGroup r103 = this.f110064h;
        if (r103 == null) goto L9;
        r103.setBackground(r102);
        return;
    }

    public s(Context r100, boolean r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mContext");
        super(r100, r102);
        this.f110065i = r101;
    }
}
