package com.bytedance.android.livesdk.vscore_impl.component.tabs;

import android.content.res.Configuration;
import android.view.View;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f160000a = 0;

    static {
    }

    public static void a(View r100, Configuration r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "config");
        if (FoldScreenUtils.c(r101) != 0) goto L5;
        r100.setVisibility(4);
        return;
    L5:
        r100.setVisibility(0);
    }
}
