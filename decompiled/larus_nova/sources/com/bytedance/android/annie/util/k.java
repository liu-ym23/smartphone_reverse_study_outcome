package com.bytedance.android.annie.util;

import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import androidx.core.content.ContextCompat;
import com.bytedance.security.android.aopcheck.ContentResolverWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f40065a = 0;

    static {
    }

    public static Pair b(Context r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "path");
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L20
        PolarisFileWrapper r104 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L20
        if (r102 == false) goto L6;
        Uri r105 = d.c(r100, r104.getName());     // Catch: Throwable -> L20
    L7:
        if (r105 != null) goto L9;
        return null;
    L9:
        OutputStream r106 = ContentResolverWrapper.openOutputStream(r100.getContentResolver(), r105);     // Catch: Throwable -> L20
        d.b(new PolarisFileInputStreamWrapper(r101), r106);     // Catch: Throwable -> L20
        d.g(r101);     // Catch: Throwable -> L20
        boolean r107 = false;
        AssetFileDescriptor r108 = ContentResolverWrapper.openAssetFileDescriptor(r100.getContentResolver(), r105, "r");     // Catch: FileNotFoundException -> L34 Throwable -> L20
        if (r108 == null) goto L16;
        r108.close();     // Catch: IOException -> L33 Throwable -> L20
    L15:
        r107 = true;
    L16:
        if (r107 == false) goto L18;
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r105));     // Catch: Throwable -> L20
    L18:
        Object r109 = Result.m9449constructorimpl(new Pair(r105, null));     // Catch: Throwable -> L20
    L23:
        if (Result.m9456isSuccessimpl(r109) == false) goto L27;
        return (Pair) r109;
    L27:
        if (Result.m9452exceptionOrNullimpl(r109) != null) goto L37;
    L32:
        return null;
    L37:
        Result.m9449constructorimpl(Boolean.valueOf(d.g(r101)));     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L32
    L6:
        r105 = d.d(r100, r104.getName());     // Catch: Throwable -> L20
    L20:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    public static Pair a(Context r100, String r101, boolean r102, com.bytedance.android.annie.container.fragment.q r103, com.bytedance.android.annie.bridge.method.permission.b r104) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "path");
        if (ContextCompat.checkSelfPermission(r100, "android.permission.WRITE_EXTERNAL_STORAGE") == 0) goto L54;
        if (r104 == null) goto L48;
        if (r103 == null) goto L14;
        r103.registerOnRequestPermissionsCallBack(r104);
        r103.requestPermissionsProxy(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 800);
    L14:
        return new Pair(null, -1);
    L48:
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L7
        Object r106 = Result.m9449constructorimpl(Boolean.valueOf(d.g(r101)));     // Catch: Throwable -> L7
    L9:
        Result.m9452exceptionOrNullimpl(r106);
        return null;
    L7:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    L54:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L33
        PolarisFileWrapper r109 = new PolarisFileWrapper(r101);     // Catch: Throwable -> L33
        if (r102 == false) goto L18;
        Uri r110 = d.c(r100, r109.getName());     // Catch: Throwable -> L33
    L19:
        if (r110 != null) goto L21;
        r110 = null;
    L21:
        ContentResolver r111 = r100.getContentResolver();     // Catch: Throwable -> L33
        Intrinsics.checkNotNull(r110);     // Catch: Throwable -> L33
        d.b(new PolarisFileInputStreamWrapper(r101), ContentResolverWrapper.openOutputStream(r111, r110));     // Catch: Throwable -> L33
        d.g(r101);     // Catch: Throwable -> L33
        boolean r112 = false;
        if (r110 != null) goto L50;
    L29:
        if (r112 == false) goto L31;
        r100.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", r110));     // Catch: Throwable -> L33
    L31:
        Object r113 = Result.m9449constructorimpl(new Pair(r110, null));     // Catch: Throwable -> L33
    L36:
        if (Result.m9456isSuccessimpl(r113) == false) goto L40;
        return (Pair) r113;
    L40:
        if (Result.m9452exceptionOrNullimpl(r113) != null) goto L56;
    L45:
        return null;
    L56:
        Result.m9449constructorimpl(Boolean.valueOf(d.g(r101)));     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L45
    L50:
        AssetFileDescriptor r115 = ContentResolverWrapper.openAssetFileDescriptor(r100.getContentResolver(), r110, "r");     // Catch: FileNotFoundException -> L47 Throwable -> L33
        if (r115 == null) goto L29;
        r115.close();     // Catch: IOException -> L46 Throwable -> L33
    L28:
        r112 = true;
        goto L29
    L18:
        r110 = d.d(r100, r109.getName());     // Catch: Throwable -> L33
    L33:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r113 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    }
}
