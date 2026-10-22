package com.bytedance.android.livesdk.viewholder;

import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes11.dex */
public class ActivityEmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f159256a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final FrameLayout f159257b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public jf2.b f159258c;

    public ActivityEmojiViewHolder(View r100) {
        super(r100);
        this.f159256a = (HSImageView) r100.findViewById(R.id.emoji_icon);
        this.f159257b = (FrameLayout) r100.findViewById(R.id.activity_group_container);
    }

    public final void T3(HSImageView r100, py.k r101) {
        int r102 = Math.min(((s1.y() - s1.f(32.0f)) - (s1.f(6.0f) * 3)) / 4, s1.f(81.0f));
        float r103 = r102 / s1.f(81.0f);
        int r104 = (int) (s1.f(30.0f) * r103);
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(-2, -2);
        r105.gravity = 16;
        r105.width = r102;
        r105.height = r104;
        this.f159257b.setLayoutParams(r105);
        int r106 = r101.getWidth();
        int r107 = r101.getHeight();
        if (r106 == 0) goto L8;
        if (r107 == 0) goto L9;
        int r108 = com.bytedance.android.livesdk.interactivity.api.expression.h.f133214a;
        float r109 = 27 * r103;
        float r110 = (r109 / r101.getHeight()) * r101.getWidth();
        float r111 = s1.f(r109);
        float r112 = Math.min(r102, s1.f(r110));
        FrameLayout.LayoutParams r113 = (FrameLayout.LayoutParams) r100.getLayoutParams();
        r113.width = (int) r112;
        r113.height = (int) r111;
        r100.setLayoutParams(r113);
        return;
    L9:
        return;
    }
}
