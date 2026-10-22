package com.bytedance.android.live.revlink.impl.multianchor.dialog.fragment;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f93501a = 0;

    static {
    }

    public static String a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nickName");
        if (r100.length() > 4) goto L5;
        return r100;
    L5:
        return r100.substring(0, 3) + "...";
    }
}
