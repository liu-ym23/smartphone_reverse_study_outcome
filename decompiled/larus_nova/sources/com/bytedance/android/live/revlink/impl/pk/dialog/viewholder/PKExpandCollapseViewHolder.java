package com.bytedance.android.live.revlink.impl.pk.dialog.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes47.dex */
public class PKExpandCollapseViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f96159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f96160b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f96161c;

    public interface a {
        void Ew();
    }

    public PKExpandCollapseViewHolder(View r100, a r101) {
        super(r100);
        this.f96159a = (TextView) r100.findViewById(R.id.expand_collapse_text);
        this.f96160b = (ImageView) r100.findViewById(R.id.expand_collapse_icon);
        this.f96161c = r101;
        r100.setOnClickListener(new i(this));
    }
}
