package com.bytedance.android.live.emoji.online;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.emoji.online.model.OnlineSmallEmojiResInfo;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.bytedance.security.android.aopcheck.PolarisFileReaderWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.File;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public final class f<V> implements Callable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f68933a;

    public f(String r100) {
        this.f68933a = r100;
    }

    @Override // java.util.concurrent.Callable
    public final OnlineSmallEmojiResInfo call() {
        String r100 = c.f68926a;
        String r101 = this.f68933a;
        Intrinsics.checkNotNullParameter(r101, "md5");
        PolarisFileWrapper r102 = new PolarisFileWrapper(c.b(r101));
        BufferedReader r103 = null;
        if (r102.exists() == true) goto L5;
    L68:
        ALogger.d("OnlineEmojiFileHelper", " loadCache, cacheDir not exist");
        return null;
    L5:
        if (r102.isDirectory() == false) goto L68;
        File[] r104 = r102.listFiles();
        boolean r105 = true;
        if (r104 != null) goto L10;
    L16:
        if (r105 == false) goto L18;
        ALogger.d("OnlineEmojiFileHelper", " loadCache, cacheDirFileList is empty");
        return null;
    L18:
        File r106 = r104[0];
        PolarisFileWrapper r107 = new PolarisFileWrapper(r106, "info.json");
        if (r107.exists() == true) goto L21;
    L67:
        ALogger.d("OnlineEmojiFileHelper", " loadCache, infoFile not exist");
        return null;
    L21:
        if (r107.isFile() == false) goto L67;
        int r108 = com.bytedance.android.live.emoji.utils.c.f68952a;
        Intrinsics.checkNotNullParameter(r107, "file");
        BufferedReader r109 = new BufferedReader(new PolarisFileReaderWrapper(r107));     // Catch: Throwable -> L37 Exception -> L39
    L82:
        String r110 = r109.readLine();     // Catch: Throwable -> L33 Exception -> L35
        StringBuilder r111 = new StringBuilder();     // Catch: Throwable -> L33 Exception -> L35
    L26:
        if (r110 == null) goto L28;
        r111.append(r110);     // Catch: Throwable -> L33 Exception -> L35
        r110 = r109.readLine();     // Catch: Throwable -> L33 Exception -> L35
        goto L26
    L28:
        String r112 = r111.toString();     // Catch: Throwable -> L33 Exception -> L35
        r109.close();     // Catch: Exception -> L31
    L49:
        if (TextUtils.isEmpty(r112) == false) goto L76;
        ALogger.d("OnlineEmojiFileHelper", " loadCache, infoJsonStr is empty");
        return null;
    L76:
        Gson r113 = com.bytedance.android.live.emoji.utils.d.f68953a;     // Catch: Throwable -> L53
        Intrinsics.checkNotNullParameter(OnlineSmallEmojiResInfo.class, "clazz");     // Catch: Throwable -> L53
        OnlineSmallEmojiResInfo r114 = (OnlineSmallEmojiResInfo) GsonProtectorUtils.fromJson(com.bytedance.android.live.emoji.utils.d.f68953a, r112, OnlineSmallEmojiResInfo.class);     // Catch: Throwable -> L53
    L55:
        if (r114 != null) goto L57;
        ALogger.d("OnlineEmojiFileHelper", " loadCache resultResInfo is null");
        return null;
    L57:
        r114.setMd5(r101);
        r114.setResDirPath(r106.getAbsolutePath());
        r114.setPicFileDirPath(new PolarisFileWrapper(r106, "static/").getAbsolutePath());
        return r114;
    L53:
        th = move-exception;
        ALogger.e("OnlineEmojiFileHelper", th);
        r114 = null;
    L31:
        e = move-exception;
        ALogger.e("FileRWerHelper", e);
        goto L49
    L35:
        e = e;
    L72:
        ALogger.e("FileRWerHelper", e);     // Catch: Throwable -> L58
        if (r109 != null) goto L74;
    L47:
        r112 = "";
        goto L49
    L74:
        r109.close();     // Catch: Exception -> L45
    L45:
        e = move-exception;
        ALogger.e("FileRWerHelper", e);
    L58:
        th = th;
        r103 = r109;
    L60:
        r109 = r103;
    L61:
        if (r109 != null) goto L70;
    L66:
        throw th;
    L70:
        r109.close();     // Catch: Exception -> L64
    L64:
        e = move-exception;
        ALogger.e("FileRWerHelper", e);
    L33:
        th = th;
    L39:
        e = e;
        r109 = null;
    L37:
        th = th;
        goto L60
    L10:
        if (r104.length != 0) goto L12;
        boolean r115 = true;
    L13:
        if (r115 == true) goto L16;
        r105 = false;
        goto L16
    L12:
        r115 = false;
        goto L13
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        return call();
    }
}
