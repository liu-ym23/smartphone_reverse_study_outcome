package com.bytedance.android.livesdk.livecommerce.utils;

import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes10.dex */
public final class j0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f153091a = 0;

    public j0() {
    }

    static {
    }

    public static Object a(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUtils$base64ToByteArray$2(r100, 0, null), r101);
    }

    public static Object b(PolarisFileWrapper r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new FileUtils$encodeFileToBase64$2(r100, null), r101);
    }
}
