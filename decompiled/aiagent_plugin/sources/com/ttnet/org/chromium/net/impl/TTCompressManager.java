package com.ttnet.org.chromium.net.impl;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes4.dex */
public class TTCompressManager {

    public static final enum a extends Enum<a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f38039a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f38040b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final a f38041c = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final /* synthetic */ a[] f38042e = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f38043d;

        public static a valueOf(String r2) {
            return (a) ZeusTransformUtils.preCheckCast(Enum.valueOf(a.class, r2), a.class, "com.obric.aiagent.plugin");
        }

        public static a[] values() {
            return (a[]) ZeusTransformUtils.preCheckCast(f38042e.clone(), a[].class, "com.obric.aiagent.plugin");
        }

        static {
            a r0 = new a("GZIP", 0, 1);
            f38039a = r0;
            a r1 = new a("BROTLI", 1, 2);
            f38040b = r1;
            a r4 = new a("ZSTD", 2, 3);
            f38041c = r4;
            f38042e = new a[]{r0, r1, r4};
        }

        private a(String r1, int r2, int r3) {
            super(r1, r2);
            this.f38043d = r3;
        }

        public int a() {
            return this.f38043d;
        }
    }

    private static native byte[] nativeCompressData(byte[] r0, int r1, int r2, int r3);

    private static native byte[] nativeDecompressData(byte[] r0, int r1, int r2);

    public TTCompressManager() {
    }

    public static byte[] a(byte[] r0, int r1, int r2, a r3) {
        return nativeCompressData(r0, r1, r2, r3.a());
    }

    public static byte[] a(byte[] r0, int r1, a r2) {
        return nativeDecompressData(r0, r1, r2.a());
    }
}
