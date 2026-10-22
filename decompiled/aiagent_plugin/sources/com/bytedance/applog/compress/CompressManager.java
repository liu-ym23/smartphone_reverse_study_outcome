package com.bytedance.applog.compress;

import android.content.Context;
import com.bytedance.applog.log.f;
import com.bytedance.applog.log.m;
import com.bytedance.compression.zstd.ZstdCompress;
import com.bytedance.compression.zstd.ZstdDictCompress;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class CompressManager {
    public static final int TYPE_EMPTY = -1;
    public static final int TYPE_GZIP = 0;
    public static final int TYPE_ZSTD = 1;
    public static final int TYPE_ZSTD_DICT = 2;
    private static byte[] mDictionary;
    private final Context mContext;
    private final f mLogger;

    @Deprecated
    public static void setReportStatsEnabled(boolean r0) {
    }

    public static void setZstdDict(byte[] r1) {
        if (r1 != null) goto L4;
        return;
    L4:
        if (r1.length <= 0) goto L8;
        mDictionary = Arrays.copyOf(r1, r1.length);
        return;
    }

    @Deprecated
    public CompressManager(Context r2, String r3, c r4, f r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
        c r7 = (c) ZeusTransformUtils.wrapperContextForParams(r4, c.class, "com.obric.aiagent.plugin");
        this(r6, (f) ZeusTransformUtils.wrapperContextForParams(r5, f.class, "com.obric.aiagent.plugin"));
    }

    public CompressManager(Context r3, f r4) {
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        f r6 = (f) ZeusTransformUtils.wrapperContextForParams(r4, f.class, "com.obric.aiagent.plugin");
        this.mContext = ZeusTransformUtils.wrapperContext(r5, "com.obric.aiagent.plugin");
        if (r6 != null) goto L6;
        r6 = m.a();
    L6:
        this.mLogger = r6;
    }

    private int getEncodeType(int r1) {
        if (r1 == 2) goto L5;
    L8:
        return r1;
    L5:
        if (mDictionary != null) goto L8;
        return 1;
    }

    public byte[] compress(byte[] r3, int r4, a r5) {
        int r0 = getEncodeType(r4);
        if (r0 != 0) goto L5;
        r3 = compressUsingGzip(r3, r5);
    L11:
        if (r3 == null) goto L15;
        if (r3.length == 0) goto L15;
        return r3;
    L15:
        return compressUsingGzip(r3, r5);
    L5:
        if (r0 != 1) goto L7;
    L9:
        r3 = compressUsingZstd(r3, r5, r4);
        goto L11
    L7:
        if (r0 == 2) goto L9;
        goto L9
    }

    public byte[] compressUsingGzip(byte[] r5, a r6) {
        if (r5 != null) goto L5;
        int r0 = 0;
    L6:
        r6.f5565a = r0;
        r6.f5567c = 0;
        long r1 = System.currentTimeMillis();
        byte[] r7 = b.a(r5);
        long r2 = System.currentTimeMillis();
        r6.f5569e = 0;
        r6.f5568d = r2 - r1;
        r6.f5566b = r7.length;
        return r7;
    L5:
        r0 = r5.length;
        goto L6
    }

    public byte[] compressUsingZstd(byte[] r7, a r8, int r9) {
        r8.f5565a = r7.length;
        r8.f5567c = r9;
        r8.f = 0;
        byte[] r1 = null;
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L11
        if (r9 == 2) goto L6;
    L8:
        byte[] r10 = ZstdCompress.compress(r7, 15);     // Catch: Throwable -> L11
    L9:
        r1 = r10;
        r8.f5568d = System.currentTimeMillis() - r2;     // Catch: Throwable -> L11
        r8.f5566b = r1.length;     // Catch: Throwable -> L11
        r8.f5569e = 0;     // Catch: Throwable -> L11
        return r1;
    L6:
        if (mDictionary == null) goto L8;
        r10 = ZstdCompress.compress(r7, new ZstdDictCompress(mDictionary, 15));     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        this.mLogger.a(14, "compress with zstd failed", th, new Object[0]);
        r8.f5569e = 1;
        return r1;
    }
}
