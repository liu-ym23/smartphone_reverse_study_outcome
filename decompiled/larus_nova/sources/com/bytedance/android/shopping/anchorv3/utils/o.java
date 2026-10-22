package com.bytedance.android.shopping.anchorv3.utils;

import com.google.gson.Gson;

/* JADX INFO: loaded from: classes12.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Gson f165316a;

    public static Gson a() {
        if (f165316a != null) goto L6;
        f165316a = new Gson();
    L6:
        return f165316a;
    }
}
