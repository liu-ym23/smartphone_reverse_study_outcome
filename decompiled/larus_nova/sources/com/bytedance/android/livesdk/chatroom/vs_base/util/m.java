package com.bytedance.android.livesdk.chatroom.vs_base.util;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.utils.screen.FoldScreenUtils;

/* JADX INFO: loaded from: classes8.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f118199a = 0;

    static {
    }

    public static boolean a(Context r100) {
        if (r100 == null) goto L7;
        Resources r101 = r100.getResources();
        if (r101 == null) goto L7;
        Configuration r102 = r101.getConfiguration();
        if (r102 == null) goto L7;
    L14:
        if (r102 != null) goto L17;
        return false;
    L17:
        if (FoldScreenUtils.c(r102) != 0) goto L20;
        return true;
    L20:
        return false;
    L7:
        Context r103 = s1.getContext();
        if (r103 == null) goto L12;
        Resources r104 = r103.getResources();
        if (r104 == null) goto L12;
        r102 = r104.getConfiguration();
    L12:
        r102 = null;
        goto L14
    }

    public static boolean b(Configuration r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (FoldScreenUtils.c(r100) != 0) goto L9;
        return true;
    L9:
        return false;
    }
}
