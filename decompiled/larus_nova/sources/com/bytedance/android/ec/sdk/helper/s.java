package com.bytedance.android.ec.sdk.helper;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f48133a = 0;

    static {
    }

    public static void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "msg");
        dm.a.b r102 = dm.a.f469202a;
        StringBuilder r103 = new StringBuilder();
        r103.append(ECommerceScene.COMMENT.getTag());
        r103.append('_');
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        r103.append(r100);
        dm.a.a(r103.toString()).i(r101);
    }
}
