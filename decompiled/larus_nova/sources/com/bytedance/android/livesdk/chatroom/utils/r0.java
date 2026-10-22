package com.bytedance.android.livesdk.chatroom.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.widget.HSImageView;

/* JADX INFO: loaded from: classes8.dex */
public final class r0 {
    public static final void a(HSImageView r110, py.k r111, boolean r210, int r211, Drawable r212, com.bytedance.android.live.core.utils.p0 r213, String r214) {
        if (r212 == null) goto L4;
        ImageUtil.loadImage(r110, r111, -1, -1, r210, r212, ImageView.ScaleType.CENTER_CROP, false, r213, r214);
        return;
    L4:
        ImageUtil.loadImage(r110, r111, -1, -1, r210, r211, ImageView.ScaleType.CENTER_CROP, false, r213, r214);
    }
}
