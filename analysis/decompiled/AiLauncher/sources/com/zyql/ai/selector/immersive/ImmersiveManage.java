package com.zyql.ai.selector.immersive;

import android.view.Window;
import androidx.appcompat.app.d;

/* loaded from: classes4.dex */
public class ImmersiveManage {
    public static void immersiveAboveAPI23(d dVar, int i10, int i11, boolean z10) {
        immersiveAboveAPI23(dVar, false, false, i10, i11, z10);
    }

    public static void immersiveAboveAPI23(d dVar, boolean z10, boolean z11, int i10, int i11, boolean z12) {
        try {
            Window window = dVar.getWindow();
            boolean z13 = true;
            if (z10 && z11) {
                window.clearFlags(201326592);
                LightStatusBarUtils.setLightStatusBar(dVar, true, true, i10 == 0, z12);
                window.addFlags(Integer.MIN_VALUE);
            } else if (!z10 && !z11) {
                window.requestFeature(1);
                window.clearFlags(201326592);
                if (i10 != 0) {
                    z13 = false;
                }
                LightStatusBarUtils.setLightStatusBar(dVar, false, false, z13, z12);
                window.addFlags(Integer.MIN_VALUE);
            } else {
                if (z10) {
                    return;
                }
                window.requestFeature(1);
                window.clearFlags(201326592);
                LightStatusBarUtils.setLightStatusBar(dVar, false, true, i10 == 0, z12);
                window.addFlags(Integer.MIN_VALUE);
            }
            window.setStatusBarColor(i10);
            window.setNavigationBarColor(i11);
        } catch (Exception unused) {
        }
    }
}
