package com.bytedance.android.bst.api.ext;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.Log;
import android.view.View;
import com.bytedance.android.btm.api.inner.ALogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes43.dex */
public final class ExtKt {
    public static final String c(Throwable r100) {
        String r101 = Log.getStackTraceString(r100);
        int r102 = RangesKt.coerceAtMost(r101.length(), 1000);
        if (r102 > 0) goto L7;
        return "";
    L7:
        return r101.substring(0, r102);
    }

    public static final Activity getActivity(View r100) {
        if (Intrinsics.areEqual(r100.getClass().getName(), "com.android.internal.policy.DecorView") == true) goto L5;
        Context r101 = r100.getContext();
    L8:
        if (r101 == null) goto L16;
        if ((r101 instanceof Activity) == true) goto L12;
        if ((r101 instanceof ContextWrapper) == false) goto L16;
        r101 = ((ContextWrapper) r101).getBaseContext();
        goto L8
    L12:
        return (Activity) r101;
    L16:
        return null;
    L5:
        return getActivity(r100.findViewById(R.id.content));
    }

    public static final void a(String r100, String r101) {
        b("SaasService", r100 + ' ' + r101);
    }

    public static final void b(String r100, final String r101) {
        ALogger r102 = ALogger.f41996d;
        Function0<String> r103 = new ExtKt$bstLog$1(r101);
        r102.getClass();
        r102.o("BTMSDK_BST_".concat(r100), false, r103, null);
    }
}
