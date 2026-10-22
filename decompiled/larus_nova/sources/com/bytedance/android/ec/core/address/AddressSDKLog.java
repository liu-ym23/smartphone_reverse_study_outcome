package com.bytedance.android.ec.core.address;

import com.bytedance.android.ec.core.utils.b2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class AddressSDKLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f43665a = 0;

    static {
    }

    public static void a(final String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        if (r101 == true) goto L7;
        final long r102 = System.currentTimeMillis();
        b2.a(new AddressSDKLog$i$1(r100, r102));
        return;
    }
}
