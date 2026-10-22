package com.bytedance.android.live.ktv.common.karaokestation.model;

import android.text.TextUtils;
import com.bytedance.android.live.ktv.common.model.api.o0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class z {
    public static final y update(y r100, o0 r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$update");
        Intrinsics.checkNotNullParameter(r101, "playlistLabel");
        String r102 = r101.c();
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r100.f69578c = r102;
        if (r101.f() == true) goto L5;
    L7:
        String r103 = r101.a();
        Intrinsics.checkNotNullParameter(r103, "<set-?>");
        r100.f69579d = r103;
        r100.f69580e = r101.b();
        r100.f69581f.getClass();
        r100.f69582g = r101.e();
        return r100;
    L5:
        if (TextUtils.isEmpty(r101.c()) == false) goto L7;
        String r104 = r101.a();
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        r100.f69578c = r104;
        goto L7
    }
}
