package com.bytedance.android.livesdk.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;

/* JADX INFO: loaded from: classes11.dex */
public class BaseEmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f159259a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public jf2.b f159260b;

    public BaseEmojiViewHolder(View r100) {
        super(r100);
        this.f159259a = (HSImageView) r100.findViewById(R.id.emoji_icon);
    }

    public final void T3(final BaseEmoji r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.getIconId() == 0) goto L8;
        this.f159259a.setImageResource(r100.getIconId());
    L13:
        this.itemView.setOnClickListener(new d(this, r100));
        if (r100.getType() != BaseEmoji.Type.DeleteEmoji) goto L16;
        r3.c(this.itemView, s1.B(R.string.ttlive_a11y_delete), true);
        return;
    L16:
        r3.a(this.itemView, r100.getDescription());
        return;
    L8:
        if (r100.getDrawable() == null) goto L11;
        this.f159259a.setImageDrawable(r100.getDrawable());
        goto L13
    L11:
        if (TextUtils.isEmpty(r100.getLocalFilePath()) == true) goto L13;
        ImageLoader.bindImage(this.f159259a, MSkiaImageRegionDecoder.FILE_PREFIX + r100.getLocalFilePath());
        goto L13
    }
}
