package com.amap.api.col.jmsl;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class K0 {

    /* renamed from: a, reason: collision with root package name */
    public static byte[] f16145a = null;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f16146b = false;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f16147c = false;

    /* renamed from: d, reason: collision with root package name */
    public static volatile ConcurrentHashMap<String, String> f16148d = new ConcurrentHashMap<>(8);

    /* renamed from: e, reason: collision with root package name */
    public static final Integer f16149e = 1;

    /* renamed from: f, reason: collision with root package name */
    public static final Integer f16150f = 2;

    /* renamed from: g, reason: collision with root package name */
    public static final Integer f16151g = 3;

    /* renamed from: h, reason: collision with root package name */
    public static final Integer f16152h = 4;

    /* renamed from: i, reason: collision with root package name */
    public static final Integer f16153i = 5;

    public static String a(String str) {
        String str2 = "";
        try {
            synchronized (f16148d) {
                try {
                    if (f16148d != null && f16148d.containsKey(str)) {
                        str2 = f16148d.get(str);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return str2;
        } catch (Throwable unused) {
            return str2;
        }
    }

    public static void b(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                synchronized (f16148d) {
                    try {
                        if (f16148d == null) {
                            f16148d = new ConcurrentHashMap<>(8);
                        }
                        if (!f16148d.containsKey(str)) {
                            f16148d.put(str, str2);
                        }
                    } finally {
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public static byte[] c() {
        if (f16145a == null) {
            f16145a = C1568j1.b("ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09");
        }
        byte[] bArr = new byte[4];
        System.arraycopy(f16145a, 40, bArr, 0, 4);
        int i10 = ((bArr[0] & 255) * 256) + (bArr[1] & 255);
        int i11 = ((bArr[2] & 255) * 256) + (bArr[3] & 255);
        byte[] bArr2 = new byte[i11];
        System.arraycopy(f16145a, i10, bArr2, 0, i11);
        return bArr2;
    }
}
