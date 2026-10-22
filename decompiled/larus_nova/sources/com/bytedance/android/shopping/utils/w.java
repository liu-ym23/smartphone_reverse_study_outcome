package com.bytedance.android.shopping.utils;

import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes14.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f187158a = 0;

    static {
    }

    public static void a(JSONObject r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "meta");
        if (r101 == null) goto L16;
    L11:
        e = move-exception;
        ECExceptionMonitor.f(e, "MetaUtil");
        return;
    L5:
        if ((!TextUtils.isEmpty(r101)) == false) goto L7;
        String r102 = r101;
    L8:
        if (r102 == null) goto L17;
        r100.put(com.bytedance.android.ec.core.event.a.KEY_ENTRANCE_INFO, r101);     // Catch: Exception -> L11
        return;
    L17:
        return;
    L7:
        r102 = null;
        goto L8
    }
}
