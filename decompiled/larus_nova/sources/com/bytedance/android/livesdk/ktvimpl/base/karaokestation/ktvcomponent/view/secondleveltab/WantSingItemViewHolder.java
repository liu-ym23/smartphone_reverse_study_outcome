package com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.view.secondleveltab;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.model.api.z0;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.dialog.selected.view.MultiUserAvatarView;
import com.larus.nova.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/karaokestation/ktvcomponent/view/secondleveltab/WantSingItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View$OnClickListener;", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class WantSingItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f142690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HSImageView f142691b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final TextView f142692c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final TextView f142693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final TextView f142694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final MultiUserAvatarView f142695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final TextView f142696g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public z0 f142697h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final View f142698i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final e f142699j;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        if (r100 == null) goto L4;
        Integer r101 = Integer.valueOf(r100.getId());
    L5:
        if (r101 != null) goto L8;
        return;
    L8:
        if (r101.intValue() != R.id.remove_want_sing) goto L13;
        e r102 = this.f142699j;
        if (r102 == null) goto L14;
        r102.a(this.f142697h);
        return;
    L14:
        return;
    L13:
        return;
    L4:
        r101 = null;
        goto L5
    }

    public WantSingItemViewHolder(View r100, e r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f142698i = r100;
        this.f142699j = r101;
        this.f142690a = (TextView) r100.findViewById(R.id.sequence_num);
        this.f142691b = (HSImageView) r100.findViewById(R.id.music_cover);
        this.f142692c = (TextView) r100.findViewById(R.id.music_name);
        this.f142693d = (TextView) r100.findViewById(R.id.music_duration);
        this.f142694e = (TextView) r100.findViewById(R.id.music_author);
        TextView r102 = (TextView) r100.findViewById(R.id.remove_want_sing);
        this.f142695f = (MultiUserAvatarView) r100.findViewById(R.id.multi_chorus_user_avatar);
        this.f142696g = (TextView) r100.findViewById(R.id.multi_user_count);
        if (r102 == null) goto L6;
        r102.setOnClickListener(this);
        return;
    }
}
