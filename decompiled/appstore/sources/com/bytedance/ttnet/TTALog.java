package com.bytedance.ttnet;

import android.util.Log;
import com.bytedance.frameworks.baselib.network.http.cronet.impl.SsCronetHttpClient;
import k6.b;
import re.a;

/* JADX INFO: loaded from: classes.dex */
public class TTALog {
    private static final String TAG = "TTNET_ALog";
    private static volatile long sALogFuncAddr;

    public TTALog() {
    }

    public static /* synthetic */ void a(long r10) {
        lambda$ensureALogInitialized$0(r10);
    }

    private static void ensureALogInitialized() {
        sALogFuncAddr = a.n();
        Log.i(TAG, "ALog function address is " + sALogFuncAddr);
        if (sALogFuncAddr != 0) goto L6;
        a.f(new b());
        return;
    }

    public static long getALogFuncAddr() {
        return sALogFuncAddr;
    }

    private static SsCronetHttpClient getCronetHttpClient() throws Exception {
        if (HttpClient.c() == true) goto L5;
        return null;
    L5:
        return SsCronetHttpClient.y(TTNetInit.getTTNetDepend().getContext());
    }

    public static void init() {
        ensureALogInitialized();
    }

    private static /* synthetic */ void lambda$ensureALogInitialized$0(long r10) {
        if (sALogFuncAddr == 0) goto L7;
        Log.i(TAG, "ALog function address has initialized.");
        return;
    L7:
        if (r10 != 0) goto L10;
        Log.w(TAG, "Cannot get ALog function address in init callback.");
        return;
    L10:
        sALogFuncAddr = r10;
        Log.i(TAG, "ALog function address is " + sALogFuncAddr + " from callback.");
        SsCronetHttpClient r11 = getCronetHttpClient();     // Catch: Exception -> L15
        if (r11 == null) goto L20;
        r11.S(sALogFuncAddr);     // Catch: Exception -> L15
        return;
    L20:
        return;
    L15:
        e = move-exception;
        e.printStackTrace();
    }
}
