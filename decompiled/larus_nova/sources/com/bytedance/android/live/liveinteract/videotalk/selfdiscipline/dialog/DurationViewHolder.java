package com.bytedance.android.live.liveinteract.videotalk.selfdiscipline.dialog;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/live/liveinteract/videotalk/selfdiscipline/dialog/DurationViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "liveinteract-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DurationViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f79669a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f79670b;

    public DurationViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f79669a = (TextView) r100.findViewById(R.id.time_text);
        this.f79670b = 600;
    }

    public final void T3(boolean r100) {
        TextView r101 = this.f79669a;
        if (r100 == false) goto L5;
        String r102 = "#161823";
    L6:
        r101.setTextColor(ColorProtector.parseColor(r102));
        return;
    L5:
        r102 = "#80161823";
        goto L6
    }
}
