package com.apm.lite.k;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes39.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static DateFormat f29992a;

    public static DateFormat a() {
        if (f29992a != null) goto L6;
        f29992a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
    L6:
        return f29992a;
    }
}
