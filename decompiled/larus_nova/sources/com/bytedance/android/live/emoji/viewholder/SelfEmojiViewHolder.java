package com.bytedance.android.live.emoji.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.emoji.SelfEmoji;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes45.dex */
public class SelfEmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f68956c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f68957a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final View f68958b;

    public SelfEmojiViewHolder(View r100) {
        super(r100);
        this.f68958b = r100;
        this.f68957a = (HSImageView) r100.findViewById(R.id.self_emoji);
    }

    public final void T3(final SelfEmoji r100, final int r110, final int r111) {
        if (r111 != 0) goto L5;
        ImageLoader.bindDrawableResource(this.f68957a, R.drawable.ttlive_ic_self_emoji_item_add);
        this.f68957a.setOnClickListener(new b(this, r100, r110, r111));
        return;
    L5:
        if (r111 != 1) goto L17;
        if (r100 != null) goto L8;
        return;
    L8:
        if (r100.getAnimatedImage() == null) goto L10;
        ImageModel r101 = r100.getAnimatedImage();
    L11:
        ImageModel r102 = r101;
        if (r102 == null) goto L14;
        HSImageView r103 = this.f68957a;
        ImageUtil.loadImage(r103, r102, r103.getMeasuredWidth(), this.f68957a.getMeasuredHeight(), true, R.drawable.ttlive_bg_self_emoji_placeholder, null);
    L14:
        this.f68957a.setOnTouchListener(new c(this, r100, r110, r111));
        return;
    L10:
        r101 = r100.getStaticImage();
        goto L11
    }
}
