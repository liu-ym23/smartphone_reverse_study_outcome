package com.bytedance.android.gamecp.business.patch;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.zip.Adler32;
import kotlin.Unit;
import kotlin.io.CloseableKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes44.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56219a = 0;

    static {
    }

    public static a.C0904a a(String r110, long r111) throws IOException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r110);
        Adler32 r101 = new Adler32();
        if (r111 != (-1)) goto L5;
        long r102 = r100.length();
        yr.c.g("game_apk_md5_ApkMd5NewCalculator", "finalLength 为-1表示没有找到签名区的位置，需要计算整个文件的校验和");
        boolean r103 = true;
    L6:
        PolarisFileInputStreamWrapper r104 = new PolarisFileInputStreamWrapper(r100);
        byte[] r112 = new byte[65536];     // Catch: Throwable -> L18
        yr.c.e("game_apk_md5_ApkMd5NewCalculator", "开始偏移值: 0");     // Catch: Throwable -> L18
        yr.c.e("game_apk_md5_ApkMd5NewCalculator", "结束偏移值: " + r102);     // Catch: Throwable -> L18
        long r113 = 0;
    L9:
        if (r113 >= r102) goto L14;
        boolean r105 = r103;
        int r106 = r104.read(r112, 0, (int) RangesKt.coerceAtMost(65536, r102 - r113));     // Catch: Throwable -> L18
        if (r106 == (-1)) goto L15;
        r101.update(r112, 0, r106);     // Catch: Throwable -> L18
        r113 = r113 + ((long) r106);     // Catch: Throwable -> L18
        r103 = r105;
    L15:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L18
        CloseableKt.closeFinally(r104, null);
        a.C0904a r108 = new a.C0904a();
        r108.f56215a = r101.getValue();
        r108.f56216b = r100.length();
        r108.f56217c = r105;
        r108.f56218d = true;
        return r108;
    L14:
        r105 = r103;
    L18:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        CloseableKt.closeFinally(r104, th);
        throw th;
    L5:
        r102 = r111;
        r103 = false;
        goto L6
    }
}
