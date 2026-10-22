package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import com.bytedance.librarian.LibrarianImpl;

/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f7650a;

    public static String a(Context r10) {
        if (f7650a != null) goto L6;
        String r11 = com.bytedance.framwork.core.sdklib.util.c.a(r10).replace(r10.getPackageName(), "p").replace(":", "_");
        f7650a = r11;
        f7650a = r11.replace(LibrarianImpl.Constants.DOT, "_");
    L6:
        return f7650a;
    }
}
