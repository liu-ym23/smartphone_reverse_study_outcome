package com.bytedance.android.live.liveinteract.videotalk.avatarmix;

import com.ss.android.ugc.effectmanager.EffectConfiguration;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {
    public static final boolean a(d r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$equalTo");
        Intrinsics.checkNotNullParameter(r101, "struct");
        if (Intrinsics.areEqual(r100.f79075a, r101.f79075a) == true) goto L5;
        return false;
    L5:
        if (r100.getType() == r101.getType()) goto L7;
        return false;
    L7:
        if (Intrinsics.areEqual(r100.f79077c, r101.f79077c) == false) goto L23;
        ti6.f r102 = r100.f79078d;
        ti6.f r103 = r101.f79078d;
        Intrinsics.checkNotNullParameter(r102, "$this$equalTo");
        Intrinsics.checkNotNullParameter(r103, EffectConfiguration.KEY_REGION);
        if (Math.abs(r102.f546162d - r103.f546162d) < 1.0E-9d) goto L11;
    L17:
        boolean r104 = false;
    L18:
        if (r104 == false) goto L24;
        return true;
    L24:
        return false;
    L11:
        if (Math.abs(r102.f546163e - r103.f546163e) >= 1.0E-9d) goto L17;
        if (Math.abs(r102.f546164f - r103.f546164f) >= 1.0E-9d) goto L17;
        if (Math.abs(r102.f546165g - r103.f546165g) >= 1.0E-9d) goto L17;
        r104 = true;
        goto L18
    L23:
        return false;
    }
}
