package com.bytedance.android.live.ui;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bytedance.android.live.core.utils.ImageUtil;
import com.bytedance.android.live.core.utils.p0;
import com.bytedance.android.live.core.utils.q0;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.chatroom.utils.r0;
import com.bytedance.android.livesdk.config.InteractCustomDiskConfig;
import com.bytedance.android.livesdk.config.x7;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class k {
    public static final boolean a() {
        InteractCustomDiskConfig r100 = x7.f121580a.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.a() != true) goto L7;
        return true;
    }

    public static final void b(HSImageView r100, py.k r101, p0 r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$showAnimation");
        if (r101 != null) goto L5;
        return;
    L5:
        if (a() == false) goto L7;
        String r102 = "live_multi_player_scene_fresco_cache";
    L8:
        String r103 = r102;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageModel");
        Intrinsics.checkNotNullParameter(r103, "customCacheName");
        r0.a(r100, r101, r111, 0, null, r110, r103);
        return;
    L7:
        r102 = "";
        goto L8
    }

    public static final void c(HSImageView r100, py.k r101, int r110, p0 r111) {
        Intrinsics.checkNotNullParameter(r100, "$this$showImage");
        if (r101 != null) goto L5;
        return;
    L5:
        if (a() == false) goto L7;
        String r102 = "live_multi_player_scene_fresco_cache";
    L8:
        String r103 = r102;
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "imageModel");
        Intrinsics.checkNotNullParameter(r103, "customCacheName");
        r0.a(r100, r101, false, r110, null, r111, r103);
        return;
    L7:
        r102 = "";
        goto L8
    }

    public static final void d(HSImageView r110, py.k r111, Drawable r112, ImageView.ScaleType r113, int r114, q0 r115) {
        Intrinsics.checkNotNullParameter(r110, "$this$showImage");
        Intrinsics.checkNotNullParameter(r113, "scaleType");
        if (r111 != null) goto L5;
        return;
    L5:
        if (a() == false) goto L7;
        String r100 = "live_multi_player_scene_fresco_cache";
    L8:
        String r101 = r100;
        Intrinsics.checkNotNullParameter(r110, "view");
        Intrinsics.checkNotNullParameter(r111, "imageModel");
        Intrinsics.checkNotNullParameter(r101, "customCacheName");
        Intrinsics.checkNotNullParameter(r113, "scaleType");
        ImageUtil.loadImage(r110, r111, -1, -1, false, r112, r113, false, r115, r101, r114);
        return;
    L7:
        r100 = "";
        goto L8
    }
}
