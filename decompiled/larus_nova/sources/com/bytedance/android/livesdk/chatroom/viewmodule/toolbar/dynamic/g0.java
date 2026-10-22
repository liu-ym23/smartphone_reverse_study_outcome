package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.dynamic;

import android.util.SparseArray;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SparseArray<b0> f116111a = null;

    static {
        f116111a = new SparseArray();
    }

    public static boolean a(s r100) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        b0 r101 = f116111a.get(r100.f116191a);
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.a(r100);
    }
}
