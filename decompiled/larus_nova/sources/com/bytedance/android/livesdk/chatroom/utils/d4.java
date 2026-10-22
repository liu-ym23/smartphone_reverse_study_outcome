package com.bytedance.android.livesdk.chatroom.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.lighten.core.CircleOptions;
import com.bytedance.lighten.core.ScaleType;
import com.bytedance.lighten.loader.SmartImageView;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes8.dex */
public final class d4 {
    public static boolean a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if ((r100 instanceof Activity) == false) goto L8;
        Activity r101 = (Activity) r100;
        if (r101.isDestroyed() == false) goto L18;
        return false;
    L18:
        return !r101.isFinishing();
    L8:
        if ((r100 instanceof Application) == false) goto L10;
    L13:
        return true;
    L10:
        if ((r100 instanceof ContextWrapper) == false) goto L13;
        return a(((ContextWrapper) r100).getBaseContext());
    }

    public static void b(SmartImageView r100, ImageModel r101) {
        if (a(r100.getContext()) == true) goto L6;
        return;
    L6:
        if (r101 != null) goto L8;
        ef6.a r102 = null;
    L9:
        df6.u r103 = df6.q.c(r102);
        r103.f468277c = r100.getContext();
        r103.f468288n = ScaleType.CENTER_CROP;
        CircleOptions.a r104 = new CircleOptions.a();
        r104.f254607a = true;
        r103.f468289o = new CircleOptions(r104);
        r103.b("SmartImageLoadUtils");
        r103.f468283i = R.drawable.ttlive_ic_default_head_small;
        r103.f468295u = r100;
        r103.d(null);
        return;
    L8:
        r102 = new ef6.a(r101.getUrls());
        goto L9
    }
}
