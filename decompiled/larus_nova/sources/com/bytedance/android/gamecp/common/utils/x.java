package com.bytedance.android.gamecp.common.utils;

import android.app.Activity;
import android.content.Context;
import android.media.MediaScannerConnection;
import android.os.Environment;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileOutputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.File;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes44.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f57327a = null;

    public x() {
    }

    static {
        f57327a = TokenCert.Companion.with("bpea-gmcp_save_album");
    }

    public static final void a(Context r110, File r111, String r112, String r113, Function1 r114) {
        if (ru.c.c(r110, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}) == true) goto L11;
        h r100 = new h();
        if ((r110 instanceof Activity) == true) goto L7;
        r114.invoke(null);
    L7:
        if (r110 == null) goto L10;
        TokenCert r101 = ru.j.f539228a;
        ru.j.b r102 = new ru.j.b((Activity) r110);
        r102.f539231c = r100;
        r102.a(new v(r110, r111, r112, r113, r114), f57327a, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        goto L11
    L10:
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    L11:
        File r115 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES + HTTP.URL_DEFAULT + r112);
        if (r115.exists() == true) goto L14;
        r115.mkdirs();
    L14:
        PolarisFileWrapper r103 = new PolarisFileWrapper(r115, r113);
        PolarisFileInputStreamWrapper r116 = new PolarisFileInputStreamWrapper(r111);
        PolarisFileOutputStreamWrapper r117 = new PolarisFileOutputStreamWrapper(r103);     // Catch: Throwable -> L26
        ByteStreamsKt.copyTo$default(r116, r117, 0, 2, null);     // Catch: Throwable -> L21
        CloseableKt.closeFinally(r117, null);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r116, null);
        MediaScannerConnection.scanFile(r110, new String[]{r103.getAbsolutePath()}, new String[]{"image/png"}, new w(r114));
        return;
    L21:
        th = move-exception;
        throw th;     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        CloseableKt.closeFinally(r117, th);     // Catch: Throwable -> L26
        throw th;     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r116, th);
        throw th;
    }
}
