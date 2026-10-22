package com.bytedance.applet.impl;

import android.app.Activity;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ai.bridge.service.OnPermissionCallback;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class i0 implements r4.i {
    public i0() {
    }

    @Override // r4.i
    public final boolean isPermissionAllGranted(Context r100, String... r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "permission");
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        if ((-1) == ContextCompat.checkSelfPermission(r100, r101[r103])) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return false;
    L8:
        return true;
    }

    @Override // r4.i
    public final void a(Activity r100, e3.d r101, String r102, String[] r103, final OnPermissionCallback r104) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "bridgeContext");
        Intrinsics.checkNotNullParameter(r102, "bridgeName");
        Intrinsics.checkNotNullParameter(r103, "permission");
        Intrinsics.checkNotNullParameter(r104, "callback");
        com.larus.platform.service.i2.f365748b.m((FragmentActivity) r100, ArraysKt.toList(r103), new h0(r104));
    }
}
