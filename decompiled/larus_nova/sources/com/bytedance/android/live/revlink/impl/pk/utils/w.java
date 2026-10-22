package com.bytedance.android.live.revlink.impl.pk.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: classes47.dex */
public final class w {
    public static void a(SimpleDraweeView r100, String r101) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        Uri r102 = UriProtector.parse(r101);
        r100.setController(Fresco.newDraweeControllerBuilder().setUri(r102).setAutoPlayAnimations(true).build());
        return;
    }
}
