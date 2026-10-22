package com.bytedance.android.live.pushstream;

import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import io.reactivex.functions.Function;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes47.dex */
public final class o<T, R> implements Function {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final o f89418a = null;

    static {
        f89418a = new o();
    }

    public o() {
    }

    @Override // io.reactivex.functions.Function
    public final Object apply(Object r100) {
        File r101 = (File) r100;
        Intrinsics.checkNotNullParameter(r101, "it");
        MessageDigest r102 = MessageDigest.getInstance("MD5");     // Catch: Throwable -> L17
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r101);
        byte[] r104 = new byte[8192];
    L28:
        int r105 = r103.read(r104);     // Catch: Throwable -> L10 IOException -> L12
        if (r105 <= 0) goto L8;
        r102.update(r104, 0, r105);     // Catch: Throwable -> L10 IOException -> L12
        goto L28
    L8:
        String r106 = String.format("%32s", new Object[]{new BigInteger(1, r102.digest()).toString(16)}).replace(' ', '0');     // Catch: Throwable -> L10 IOException -> L12
    L22:
        r103.close();     // Catch: IOException -> L20
    L18:
        ALogger.e("LiveStream", "name:" + r101.getName() + " md5:" + r106);
        JSONObject r107 = new JSONObject();
        BaseMonitor.add(r107, "so_name", r101.getName());
        BaseMonitor.add(r107, "so_md5", r106);
        return r107;
    L12:
        r106 = "";
    L10:
        th = move-exception;
        r103.close();     // Catch: IOException -> L21
    L16:
        throw th;
    L17:
        r106 = null;
        goto L18
    }
}
