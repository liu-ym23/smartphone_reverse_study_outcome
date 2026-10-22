package com.bytedance.android.live.liveinteract.digitavatar;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f0 extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f72621a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f72622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public com.bytedance.android.live.liveinteract.videotalk.emoji.model.j f72623c;

    public f0(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f72621a = (HSImageView) this.itemView.findViewById(R.id.emoji_icon);
        this.f72622b = (TextView) this.itemView.findViewById(R.id.emoji_name);
    }
}
