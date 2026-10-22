package com.bytedance.android.livesdk.link.model.bridge;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
public final class i1 {
    public static final long a(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$linkerIdExt");
        return r100.getLinkerId();
    }

    public static final long b(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$sceneExt");
        return r100.getScene();
    }

    public static final long c(h1 r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$typeExt");
        return r100.getType2();
    }
}
