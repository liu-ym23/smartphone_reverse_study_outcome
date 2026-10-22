package com.obric.autoaction.vdplayer.components;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.obric.aiagent.plugin.R;
import com.obric.autogui.common.api.AOPackagesTools;
import com.obric.autogui.common.api.platform.AOPlatform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: AppIconLoader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static final Drawable a(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        o.e(r4, "context");
        o.e(r3, "packageName");
        Drawable r0 = b(r4, r3);
        if (r0 != null) goto L8;
        Drawable r1 = c(r4, r3);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return androidx.core.content.a.a(r4, ZeusTransformUtils.mapRes(R.drawable.ic_vd_hand_right_gradient, "drawable", "ic_vd_hand_right_gradient"));
    L8:
        return r0;
    }

    private static final Drawable b(Context r2, String r3) {
        Context r4 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        if (AOPlatform.INSTANCE.isInitialized() == true) goto L6;
        return null;
    L6:
        return AOPackagesTools.INSTANCE.getAppIconDrawable(r4, r3);
    L11:
        return null;
    }

    private static final Drawable c(Context r2, String r3) {
        return ((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin")).getPackageManager().getApplicationIcon(r3);
    L5:
        return null;
    }
}
