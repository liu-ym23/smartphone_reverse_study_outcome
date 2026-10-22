package com.bytedance.android.accessibilityLib_Core.processor;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes43.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, String> f38304a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, WeakReference<View>> f38305b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f38306c;

    public b() {
        this.f38304a = new ConcurrentHashMap();
        this.f38305b = new ConcurrentHashMap();
        this.f38306c = 10000;
    }

    public static String a(View r100) {
        CharSequence r101 = r100.getContentDescription();
        if (r101 == null) goto L5;
        String r102 = r101.toString();
    L6:
        if (r102 != null) goto L8;
    L11:
        boolean r103 = true;
    L12:
        if (r103 == true) goto L14;
        return r102;
    L14:
        if ((r100 instanceof TextView) == false) goto L27;
        String r104 = ((TextView) r100).getText().toString();     // Catch: Exception -> L17
    L23:
        return r104;
    L17:
        e = move-exception;
        if (("Try exception occur " + e.getMessage()) == null) goto L21;
        Context r105 = com.bytedance.android.accessibilityLib_Core.helper.a.f38277a;
    L21:
        r104 = "";
        goto L23
    L27:
        return r102;
    L8:
        if (r102.length() == 0) goto L11;
        r103 = false;
        goto L12
    L5:
        r102 = null;
        goto L6
    }
}
