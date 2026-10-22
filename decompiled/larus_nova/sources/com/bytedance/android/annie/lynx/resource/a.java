package com.bytedance.android.annie.lynx.resource;

import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes43.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Boolean f39507a = null;

    static {
        f39507a = AnnieConfigSettingKeys.FIX_LYNX_FILE_STREAM_CLOSE.a();
    }

    public static byte[] a(InputStream r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (f39507a.booleanValue() == false) goto L23;
        ByteArrayOutputStream r101 = new ByteArrayOutputStream(Math.max(8192, r100.available()));     // Catch: Throwable -> L17
        ByteStreamsKt.copyTo$default(r100, r101, 0, 2, null);     // Catch: Throwable -> L12
        byte[] r102 = r101.toByteArray();     // Catch: Throwable -> L12
        CloseableKt.closeFinally(r101, null);     // Catch: Throwable -> L17
        CloseableKt.closeFinally(r100, null);
        return r102;
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L14
    L14:
        th = move-exception;
        CloseableKt.closeFinally(r101, th);     // Catch: Throwable -> L17
        throw th;     // Catch: Throwable -> L17
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L19:
        th = move-exception;
        CloseableKt.closeFinally(r100, th);
        throw th;
    L23:
        return ByteStreamsKt.readBytes(r100);
    }
}
