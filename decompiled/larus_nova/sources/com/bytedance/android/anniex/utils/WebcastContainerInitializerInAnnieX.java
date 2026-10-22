package com.bytedance.android.anniex.utils;

import android.view.View;
import com.bytedance.sdk.xbridge.cn.platform.lynx.LynxBDXBridge;
import defpackage.x0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class WebcastContainerInitializerInAnnieX {
    public static void a(ra.a r100, final View r101, LynxBDXBridge r102, m16.b r110) {
        Intrinsics.checkNotNullParameter(r100, "annieXLynxModel");
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r110, "providerFactory");
        x0.a(r101, r102, r110, r100.f536749g, r100.f536744b, new WebcastContainerInitializerInAnnieX$initializeWithAnnieXLynxModelInLynx$1(r101));
    }
}
