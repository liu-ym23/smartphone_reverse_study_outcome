package com.bytedance.android.live.platformplayer.utils;

import com.ss.android.ugc.aweme.debug.LocalTestManager;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f85834a = 0;

    static {
    }

    @JvmStatic
    public static final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "info");
        LocalTestManager.a(new Class[]{wy.a.class});
        com.bytedance.android.live.core.log.g.i("LiveBackgroundOpt", r100);
    }
}
