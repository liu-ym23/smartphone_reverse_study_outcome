package com.bytedance.android.livesdk.viewholder;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/viewholder/GuideChatConfViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GuideChatConfViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f159265a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f159266b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jf2.b f159267c;

    public GuideChatConfViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        super(r100);
        this.f159265a = (TextView) r100.findViewById(R.id.text_view);
        this.f159266b = r100.findViewById(R.id.guide_chat_container);
    }
}
