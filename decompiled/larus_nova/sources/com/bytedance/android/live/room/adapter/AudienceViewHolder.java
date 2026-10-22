package com.bytedance.android.live.room.adapter;

import android.graphics.Paint;
import android.view.View;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.FitTextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class AudienceViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public RecyclerView f98887a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f98888b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HSImageView f98889c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final HSImageView f98890d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageView f98891e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FitTextView f98892f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Paint f98893g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f98894h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f98895i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f98896j;

    public AudienceViewHolder(View r100) {
        super(r100);
        this.f98894h = s1.f(34.0f);
        this.f98895i = s1.f(2.0f);
        this.f98896j = s1.f(8.0f);
        this.f98888b = r100;
        this.f98889c = (HSImageView) r100.findViewById(R.id.avatar);
        this.f98890d = (HSImageView) r100.findViewById(R.id.avatar_border);
        this.f98891e = (ImageView) r100.findViewById(R.id.honer_icon);
        ImageView r101 = (ImageView) r100.findViewById(R.id.crown);
        this.f98892f = (FitTextView) r100.findViewById(R.id.contribution);
    }
}
