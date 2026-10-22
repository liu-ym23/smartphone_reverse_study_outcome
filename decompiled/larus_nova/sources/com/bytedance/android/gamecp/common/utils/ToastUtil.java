package com.bytedance.android.gamecp.common.utils;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class ToastUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f57193a = 0;

    static {
    }

    @JvmStatic
    public static final void a(int r100) {
        Context r101 = y0.getContext();
        if (r101 == null) goto L7;
        b(r101.getString(r100), 0);
        return;
    }

    @JvmStatic
    public static final void b(final String r100, final int r101) {
        if ((!Intrinsics.areEqual(Looper.getMainLooper(), Looper.myLooper())) == false) goto L6;
        UtilityKotlinExtentionsKt.g(0, false, false, new ToastUtil$centerToast$1(r100, r101), 7);
        return;
    L6:
        Context r102 = y0.getContext();
        if (r102 != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(r100) == true) goto L14;
        com.bytedance.android.gamecp.host_api.a.b().getHostAppService().centerToast(r102, r100, r101);
        return;
    }
}
