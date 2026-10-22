package com.bytedance.android.livesdk.drawer.history;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/drawer/history/PlaceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PlaceViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f122483a;

    public PlaceViewHolder(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        if (r101 == false) goto L9;
        ViewGroup.LayoutParams r102 = ((TextView) r100.findViewById(R.id.place_text)).getLayoutParams();
        if (r102 == null) goto L8;
        int r103 = s1.f(0.0f);
        ((ViewGroup.MarginLayoutParams) ((ConstraintLayout.LayoutParams) r102)).leftMargin = r103;
        goto L9
    L8:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L9:
        this.f122483a = (TextView) r100.findViewById(R.id.place_text);
    }
}
