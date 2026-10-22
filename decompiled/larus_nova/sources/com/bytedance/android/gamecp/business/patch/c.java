package com.bytedance.android.gamecp.business.patch;

import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.IOException;
import java.util.zip.Adler32;
import kotlin.Unit;
import kotlin.io.CloseableKt;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f56220a = 0;

    static {
    }

    public static a.C0904a a(String r210, long r211, long[] r212, long r213) throws IOException {
        PolarisFileWrapper r100 = new PolarisFileWrapper(r210);
        Adler32 r101 = new Adler32();
        PolarisFileInputStreamWrapper r102 = new PolarisFileInputStreamWrapper(r100);
        if (r211 != (-1)) goto L9;
        byte[] r103 = new byte[65536];     // Catch: Throwable -> L35
        long r104 = r100.length();     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 当前处理部分：整个文件");     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 开始偏移值: 0");     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 结束偏移值: " + r104);     // Catch: Throwable -> L35
    L5:
        int r105 = r102.read(r103);     // Catch: Throwable -> L35
        if (r105 == (-1)) goto L8;
        r101.update(r103, 0, r105);     // Catch: Throwable -> L35
        goto L5
    L8:
        boolean r106 = true;
    L32:
        Unit r107 = Unit.INSTANCE;     // Catch: Throwable -> L35
        CloseableKt.closeFinally(r102, null);
        a.C0904a r108 = new a.C0904a();
        r108.f56215a = r101.getValue();
        r108.f56216b = r100.length();
        r108.f56217c = r106;
        r108.f56218d = false;
        return r108;
    L9:
        byte[] r109 = new byte[65536];     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 当前处理部分：第一部分");     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 开始偏移值: 0");     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 结束偏移值: " + (r211 - 1));     // Catch: Throwable -> L35
        long r110 = r211;
    L10:
        long r111 = 0;
        if (r110 <= 0) goto L17;
        int r112 = r102.read(r109, 0, (int) Math.min(r110, 65536));     // Catch: Throwable -> L35
        if (r112 == (-1)) goto L10;
        r101.update(r109, 0, r112);     // Catch: Throwable -> L35
        r110 = r110 - ((long) r112);
        goto L10
    L17:
        if (r212 == null) goto L26;
        long r113 = r212[0];     // Catch: Throwable -> L35
        byte[] r114 = r109;
        long r115 = (r212[1] + r113) - 1;     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 当前处理部分：第二部分");     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 开始偏移值: " + r113);     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 结束偏移值: " + r115);     // Catch: Throwable -> L35
        r102.getChannel().position(r212[0]);     // Catch: Throwable -> L35
        long r116 = r212[1];     // Catch: Throwable -> L35
    L20:
        if (r116 <= r111) goto L25;
        byte[] r117 = r114;
        int r118 = r102.read(r117, 0, (int) Math.min(r116, 65536));     // Catch: Throwable -> L35
        if (r118 == (-1)) goto L24;
        r101.update(r117, 0, r118);     // Catch: Throwable -> L35
        r116 = r116 - ((long) r118);     // Catch: Throwable -> L35
    L24:
        r114 = r117;
        r111 = 0;
        goto L20
    L25:
        byte[] r119 = r114;
    L27:
        long r120 = r100.length() - 1;     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 当前处理部分：第三部分");     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 开始偏移值: " + r213);     // Catch: Throwable -> L35
        yr.c.e("game_apk_md5_ApkMd5OldCalculator", "calculateAdler32() 结束偏移值: " + r120);     // Catch: Throwable -> L35
        r102.getChannel().position(r213);     // Catch: Throwable -> L35
    L28:
        int r121 = r102.read(r119);     // Catch: Throwable -> L35
        if (r121 == (-1)) goto L31;
        r101.update(r119, 0, r121);     // Catch: Throwable -> L35
        goto L28
    L31:
        r106 = false;
        goto L32
    L26:
        r119 = r109;
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        CloseableKt.closeFinally(r102, th);
        throw th;
    }
}
