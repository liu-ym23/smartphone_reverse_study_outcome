package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.adapter.v3;

import a20.e;
import android.view.View;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.config.qa;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/adapter/v3/OpenFeatureRecentUseItemViewHolderV3;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureRecentUseItemViewHolderV3 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f61390a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f61391b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f61392c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f61393d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f61394e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final View f61395f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final e f61396g;

    public OpenFeatureRecentUseItemViewHolderV3(View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f61396g = r101;
        this.f61390a = (HSImageView) r100.findViewById(R.id.icon);
        TextView r102 = (TextView) r100.findViewById(R.id.name);
        this.f61391b = r102;
        this.f61392c = r100.findViewById(R.id.action_area);
        this.f61393d = (TextView) r100.findViewById(R.id.category_tag);
        this.f61394e = r100.findViewById(R.id.doing_area);
        this.f61395f = r100.findViewById(R.id.bind_self_mount_area);
        if (Intrinsics.areEqual(qa.f121038a.getValue(), Boolean.TRUE) == false) goto L6;
        ViewCompat.setAccessibilityDelegate(r102, new AnonymousClass1());
        return;
    }
}
