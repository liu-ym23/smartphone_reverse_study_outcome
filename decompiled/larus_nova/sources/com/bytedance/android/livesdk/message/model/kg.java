package com.bytedance.android.livesdk.message.model;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class kg {
    public static final boolean a(MusicPanel r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$isDangerousCopyrightSong");
        List<Integer> r101 = r100.f153577a.getCopyRightList();
        if (r101 != null) goto L7;
        return false;
    L7:
        return r101.contains(5);
    }
}
