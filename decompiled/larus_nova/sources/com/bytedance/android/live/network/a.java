package com.bytedance.android.live.network;

import java.net.URLEncoder;

/* JADX INFO: loaded from: classes46.dex */
public final /* synthetic */ class a {
    public static String a(String r100) {
        return URLEncoder.encode(r100, "UTF-8");
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
