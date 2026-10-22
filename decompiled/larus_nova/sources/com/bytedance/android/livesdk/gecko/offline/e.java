package com.bytedance.android.livesdk.gecko.offline;

import java.io.File;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class e extends a<Pair<? extends String, ? extends String>> {
    public e(List<? extends d> r100) {
        Intrinsics.checkNotNullParameter(r100, "iOfflineController");
        super(r100);
    }

    public final Object b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        File r101 = a(r100);
        if (r101 != null) goto L5;
    L7:
        return null;
    L5:
        if (r101.exists() == false) goto L7;
        return new Pair(r101.getParent(), r101.getName());
    }
}
