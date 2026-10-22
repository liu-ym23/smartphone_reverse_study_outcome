package com.bytedance.android.ec.sdk.plugin;

import android.content.Context;
import android.content.res.TypedArray;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements af.a {
    public b() {
    }

    @Override // af.a
    public final boolean a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        r100.getString(R.string.ec_sdk_plugin_check_res);     // Catch: Throwable -> L5
        TypedArray r101 = r100.obtainStyledAttributes(new int[]{R.attr.colorPrimary});     // Catch: Throwable -> L5
        boolean r102 = r101.hasValue(0);     // Catch: Throwable -> L5
        r101.recycle();     // Catch: Throwable -> L5
        return r102;
    L5:
        return false;
    }
}
