package com.bytedance.android.live.liveinteract.videotalk.themecompetition;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f {
    public static final void a(HSImageView r100, String r101, Function0<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$playWebpOnce");
        Intrinsics.checkNotNullParameter(r101, "url");
        if (TextUtils.isEmpty(r101) == false) goto L5;
        return;
    L5:
        Uri r103 = UriProtector.parse(r101);
        Intrinsics.checkNotNullParameter(r100, "$this$playWebpOnce");
        Intrinsics.checkNotNullParameter(r103, "uri");
        Intrinsics.checkNotNullParameter(r100, "$this$loadWebp");
        Intrinsics.checkNotNullParameter(r103, "uri");
        r100.setController(Fresco.newDraweeControllerBuilder().setUri(r103).setAutoPlayAnimations(true).setControllerListener(new e(r102)).build());
    }
}
