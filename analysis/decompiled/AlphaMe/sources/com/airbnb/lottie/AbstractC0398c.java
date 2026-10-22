package com.airbnb.lottie;

import android.util.Log;
import java.util.HashSet;

/* renamed from: com.airbnb.lottie.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC0398c {

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f4541a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static int f4542b = 0;

    public static void a() {
        int i4 = f4542b;
        if (i4 > 0) {
            f4542b = i4 - 1;
        }
    }

    public static void b(String str) {
        HashSet hashSet = f4541a;
        if (hashSet.contains(str)) {
            return;
        }
        Log.w("LOTTIE", str);
        hashSet.add(str);
    }
}
