package com.bytedance.applog.compress;

import android.content.Context;
import com.bytedance.applog.log.i;
import com.bytedance.applog.log.n;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import java.util.Arrays;
import pw3.a;
import pw3.b;
import pw3.c;

/* JADX INFO: loaded from: classes.dex */
public class CompressManager {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static byte[] mDictionary = null;
    private static int sZstdLevel = 15;
    private final Context mContext;
    private final i mLogger;

    public static void setReportStatsEnabled(boolean r100) {
    }

    private int getEncodeType(int r100) {
        if (r100 == 2) goto L5;
        return r100;
    L5:
        if (mDictionary != null) goto L9;
        return 1;
    L9:
        return r100;
    }

    public static void setZstdDict(byte[] r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.length <= 0) goto L8;
        mDictionary = Arrays.copyOf(r100, r100.length);
        return;
    }

    public static void setZstdLevel(int r100) {
        sZstdLevel = r100;
    }

    public CompressManager(Context r100, i r101) {
        this.mContext = r100;
        if (r101 != null) goto L6;
        r101 = n.w();
    L6:
        this.mLogger = r101;
    }

    public byte[] compressUsingGzip(byte[] r100, a r101) {
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        r101.f530828a = r102;
        r101.f530830c = 0;
        long r103 = System.currentTimeMillis();
        byte[] r104 = b.a(r100);
        long r105 = System.currentTimeMillis();
        r101.f530832e = 0;
        r101.f530831d = r105 - r103;
        r101.f530829b = r104.length;
        return r104;
    L5:
        r102 = r100.length;
        goto L6
    }

    public byte[] compress(byte[] r100, int r101, a r102) {
        int r103 = getEncodeType(r101);
        if (r103 != 0) goto L5;
        r100 = compressUsingGzip(r100, r102);
    L11:
        if (r100 == null) goto L15;
        if (r100.length == 0) goto L15;
        return r100;
    L15:
        return compressUsingGzip(r100, r102);
    L5:
        if (r103 != 1) goto L7;
    L9:
        r100 = compressUsingZstd(r100, r102, r101);
        goto L11
    L7:
        if (r103 == 2) goto L9;
        goto L9
    }

    public byte[] compressUsingZstd(byte[] r100, a r101, int r102) {
        r101.f530828a = r100.length;
        r101.f530830c = r102;
        byte[] r103 = null;
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r102 == 2) goto L6;
    L8:
        byte[] r105 = ZstdCompress.compress(r100, sZstdLevel);     // Catch: Throwable -> L11
    L9:
        r103 = r105;
        r101.f530831d = System.currentTimeMillis() - r104;     // Catch: Throwable -> L11
        r101.f530829b = r103.length;     // Catch: Throwable -> L11
        r101.f530832e = 0;     // Catch: Throwable -> L11
        return r103;
    L6:
        if (mDictionary == null) goto L8;
        r105 = ZstdCompress.compress(r100, new ZstdDictCompress(mDictionary, sZstdLevel));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLogger.o(14, "compress with zstd failed", th, new Object[0]);
        r101.f530832e = 1;
        return r103;
    }

    public CompressManager(Context r100, String r101, c r102, i r103) {
        this(r100, r103);
    }
}
