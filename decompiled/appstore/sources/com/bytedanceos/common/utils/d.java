package com.bytedanceos.common.utils;

import android.content.Intent;
import android.content.UriMatcher;
import android.net.Uri;

/* JADX INFO: loaded from: classes2.dex */
public abstract class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final UriMatcher f10204a = null;

    static {
        UriMatcher r10 = new UriMatcher(-1);
        r10.addURI("details", null, 1);
        f10204a = r10;
    }

    public static final boolean a(Intent r10) {
        if (r10 != null) goto L5;
        return false;
    L5:
        Uri r11 = r10.getData();
        if (r11 != null) goto L9;
        return false;
    L9:
        if (kotlin.jvm.internal.q.b(r11.getScheme(), "market") == true) goto L12;
        return false;
    L12:
        if (f10204a.match(r11) != 1) goto L19;
        String r12 = r11.getQueryParameter("id");
        if (r12 == null) goto L19;
        if (kotlin.text.o.r(r12) == true) goto L19;
        return true;
    L19:
        return false;
    }
}
