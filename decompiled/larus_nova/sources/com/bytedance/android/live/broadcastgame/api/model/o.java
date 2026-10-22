package com.bytedance.android.live.broadcastgame.api.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class o {
    public static final boolean a(u r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isOpenPlatformPlugin");
        if (r100.interactId != InteractID.OpenGame.getValue()) goto L5;
    L12:
        return true;
    L5:
        if (r100.interactId == InteractID.OpenMicroApp.getValue()) goto L12;
        if (r100.interactId == InteractID.SonicMiniGame.getValue()) goto L12;
        if (r100.interactId == InteractID.OpenMicroGame.getValue()) goto L12;
        return false;
    }
}
