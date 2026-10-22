package com.bytedance.android.livesdk.utils;

import android.os.Bundle;

/* JADX INFO: loaded from: classes11.dex */
public final class d6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f158931a = 0;

    static {
    }

    public static String a(Bundle r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getString("search_params");
    }
}
