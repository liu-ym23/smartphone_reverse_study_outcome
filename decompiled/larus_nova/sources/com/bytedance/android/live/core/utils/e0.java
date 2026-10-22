package com.bytedance.android.live.core.utils;

import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: classes45.dex */
public final class e0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f66128a = null;

    public class a implements FileFilter {
        public a() {
        }

        @Override // java.io.FileFilter
        public final boolean accept(File r100) {
            String r101 = r100.getName();
            if (r101.startsWith("cpu") == false) goto L13;
            int r102 = 3;
        L6:
            if (r102 >= r101.length()) goto L11;
            if (Character.isDigit(r101.charAt(r102)) == false) goto L9;
            r102 = r102 + 1;
            goto L6
        L9:
            return false;
        L11:
            return true;
        L13:
            return false;
        }
    }

    public static int c() {
        int r100 = b("/sys/devices/system/cpu/possible");     // Catch: Throwable -> L11
        if (r100 != (-1)) goto L6;
        r100 = b("/sys/devices/system/cpu/present");     // Catch: Throwable -> L11
    L6:
        if (r100 != (-1)) goto L10;
        return new PolarisFileWrapper("/sys/devices/system/cpu/").listFiles(f66128a).length;
    L10:
        return r100;
    L15:
        return -1;
    }

    static {
        f66128a = new a();
    }

    public static int b(String r100) {
        int r101 = -1;
        PolarisFileInputStreamWrapper r102 = null;
        PolarisFileInputStreamWrapper r103 = new PolarisFileInputStreamWrapper(r100);     // Catch: Throwable -> L19 IOException -> L26
        goto L27
    L41:
        String r104 = new BufferedReader(new InputStreamReader(r103)).readLine();     // Catch: Throwable -> L16 IOException -> L18
        if (r104 != null) goto L7;
    L35:
        r103.close();     // Catch: IOException -> L13
    L15:
        return r101;
    L13:
        e = move-exception;
        e.printStackTrace();
        goto L15
    L7:
        if (r104.matches("0-[\\d]+$") == false) goto L35;
        r101 = CastIntegerProtector.valueOf(r104.substring(2)).intValue() + 1;
        goto L35
    L18:
        r102 = r103;
    L16:
        th = th;
        r102 = r103;
    L20:
        if (r102 != null) goto L33;
    L25:
        throw th;
    L33:
        r102.close();     // Catch: IOException -> L23
    L23:
        e = move-exception;
        e.printStackTrace();
    L19:
        th = th;
    L27:
        if (r102 != null) goto L37;
    L32:
        return -1;
    L37:
        r102.close();     // Catch: IOException -> L30
    L30:
        e = move-exception;
        e.printStackTrace();
        goto L32
    }

    public static int a(byte[] r100, int r101) {
    L3:
        if (r101 >= r100.length) goto L17;
        byte r102 = r100[r101];
        if (r102 == 10) goto L24;
        if (Character.isDigit(r102) == true) goto L8;
        r101 = r101 + 1;
        goto L3
    L8:
        int r103 = r101 + 1;
    L10:
        if (r103 >= r100.length) goto L15;
        if (Character.isDigit(r100[r103]) == false) goto L15;
        r103 = r103 + 1;
    L15:
        return CastIntegerProtector.parseInt(new String(r100, 0, r101, r103 - r101));
    L24:
        return -1;
    L17:
        return -1;
    }
}
