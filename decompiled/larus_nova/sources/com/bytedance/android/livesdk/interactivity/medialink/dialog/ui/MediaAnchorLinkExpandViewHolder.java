package com.bytedance.android.livesdk.interactivity.medialink.dialog.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import v82.b;

/* JADX INFO: loaded from: classes9.dex */
public class MediaAnchorLinkExpandViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f138129c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f138130a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f138131b;

    public interface a {
    }

    public MediaAnchorLinkExpandViewHolder(View r100, final a r101, final boolean r102) {
        super(r100);
        this.f138130a = (TextView) r100.findViewById(R.id.tv_expand);
        this.f138131b = (ImageView) r100.findViewById(R.id.iv_expand);
        r100.setOnClickListener(new b(this, r102, r101));
    }
}
