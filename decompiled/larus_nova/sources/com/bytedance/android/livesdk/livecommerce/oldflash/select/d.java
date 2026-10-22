package com.bytedance.android.livesdk.livecommerce.oldflash.select;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class d extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f149727a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageView f149728b;

    public d(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super(r100);
        this.f149727a = (TextView) r100.findViewById(R.id.tv_auto_gen_title);
        this.f149728b = (ImageView) r100.findViewById(R.id.iv_selected);
    }
}
