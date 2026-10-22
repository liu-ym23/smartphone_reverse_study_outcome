package com.bytedance.android.livesdk.interactivity.publicscreen.utils;

import com.bytedance.android.livesdkapi.message.IPublicAreaCommon;
import com.bytedance.android.livesdkapi.message.IPublicAreaCommonKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f140315a = 0;

    static {
    }

    @JvmStatic
    public static final boolean a(com.bytedance.android.livesdk.interactivity.api.entity.f<?> r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.i r101 = r100.s();
        if (r101 == null) goto L9;
        IPublicAreaCommon r102 = r101.c();
        if (r102 == null) goto L9;
        if (IPublicAreaCommonKt.isFloatMessage(r102) != true) goto L9;
        return true;
    L9:
        return false;
    }
}
