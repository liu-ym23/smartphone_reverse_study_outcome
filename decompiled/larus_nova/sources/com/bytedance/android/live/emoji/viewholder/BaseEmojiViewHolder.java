package com.bytedance.android.live.emoji.viewholder;

import android.text.TextUtils;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.LiveResUtil;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livehostapi.business.model.emoji.BaseEmoji;
import com.bytedance.android.livesdk.r3;
import com.larus.nova.R;
import com.ss.android.lark.imagewidget.subsampling.decoder.custom.MSkiaImageRegionDecoder;

/* JADX INFO: loaded from: classes45.dex */
public class BaseEmojiViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final HSImageView f68954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t90.a f68955b;

    public BaseEmojiViewHolder(View r100) {
        super(r100);
        this.f68954a = (HSImageView) r100.findViewById(R.id.emoji_icon);
    }

    public final void T3(final BaseEmoji r100) {
        if (r100.getIconId() == 0) goto L6;
        this.f68954a.setImageResource(r100.getIconId());
    L11:
        this.itemView.setOnClickListener(new a(this, r100));
        if (r100.getType() != BaseEmoji.Type.DeleteEmoji) goto L14;
        r3.c(this.itemView, LiveResUtil.getString(R.string.ttlive_a11y_delete), true);
        return;
    L14:
        r3.a(this.itemView, r100.getDescription());
        return;
    L6:
        if (r100.getDrawable() == null) goto L9;
        this.f68954a.setImageDrawable(r100.getDrawable());
        goto L11
    L9:
        if (TextUtils.isEmpty(r100.getLocalFilePath()) == true) goto L11;
        ImageLoader.bindImage(this.f68954a, MSkiaImageRegionDecoder.FILE_PREFIX + r100.getLocalFilePath());
        goto L11
    }
}
