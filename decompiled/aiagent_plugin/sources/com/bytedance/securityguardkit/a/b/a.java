package com.bytedance.securityguardkit.a.b;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.aiassistant.security.platformkey.PlatformKeyManager;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: compiled from: AssistantPlatformKeyManagerAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements com.bytedance.securityguardkit.a.a.a {
    private static final String TAG = "AssistantAdapter";

    public a() {
    }

    @Override // com.bytedance.securityguardkit.a.a.a
    public byte[] a(Context r7, int r8, byte[] r9, byte[] r10, Bundle r11) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        PlatformKeyManager r0 = PlatformKeyManager.getInstance();     // Catch: Exception -> L9
        if (r0 != null) goto L8;
        a(TAG, "PlatformKeyManager getInstance returned null");     // Catch: Exception -> L9
        return null;
    L8:
        return r0.decrypt(r1, r8, r9, r10, r11);
    L9:
        e = move-exception;
        a(TAG, "decrypt failed", e);
        return null;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1, Throwable r2) {
        return Log.e(r0, r1, r2);
    }
}
