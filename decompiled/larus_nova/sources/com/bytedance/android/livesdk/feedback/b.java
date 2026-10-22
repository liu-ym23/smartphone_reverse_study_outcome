package com.bytedance.android.livesdk.feedback;

import android.net.Uri;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes8.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f124640a = 0;

    static {
    }

    @JvmStatic
    public static final Uri a(String r100, String r101) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Uri.Builder r102 = x6.a.d(r100).buildUpon();
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        return r102.appendQueryParameter("fallback_url", r101).build();
    }
}
