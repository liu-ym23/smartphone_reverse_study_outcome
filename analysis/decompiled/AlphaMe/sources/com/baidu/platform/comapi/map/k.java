package com.baidu.platform.comapi.map;

import android.util.Log;
import com.stepos.alphame.awareness.AwarenessDataItem;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name */
    static boolean f9243a = false;

    public static void a(String str, String str2) {
        if (f9243a) {
            Log.d(B0.g.m("MapTrace-", str), "thread:" + Thread.currentThread().getName() + AwarenessDataItem.USERID_SPLITTER + Thread.currentThread().getId() + "," + str2);
        }
    }
}
