package com.bytedance.android.live.broadcastgame.openplatform.feature_panel.viewholder.delegate.v3;

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
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/broadcastgame/openplatform/feature_panel/viewholder/delegate/v3/OpenFeatureFunctionItemViewHolderV3;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livebroadcastgame-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class OpenFeatureFunctionItemViewHolderV3 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f61664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f61665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f61666c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final View f61667d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final e f61668e;

    public OpenFeatureFunctionItemViewHolderV3(View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f61668e = r101;
        this.f61664a = (HSImageView) r100.findViewById(R.id.icon);
        TextView r102 = (TextView) r100.findViewById(R.id.name);
        this.f61665b = r102;
        this.f61666c = r100.findViewById(R.id.red_dot);
        this.f61667d = r100.findViewById(R.id.action_area);
        if (Intrinsics.areEqual(qa.f121038a.getValue(), Boolean.TRUE) == false) goto L6;
        ViewCompat.setAccessibilityDelegate(r102, new AnonymousClass1());
        return;
    }
}
