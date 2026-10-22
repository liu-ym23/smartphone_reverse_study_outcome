package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class m6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static byte[] f27613a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static boolean f27614b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f27615c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f27616d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Integer f27617e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f27618f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer f27619g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer f27620h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer f27621i = null;

    static {
        f27616d = new ConcurrentHashMap(8);
        f27617e = 1;
        f27618f = 2;
        f27619g = 3;
        f27620h = 4;
        f27621i = 5;
    }

    public static byte[] a() {
        if (f27613a != null) goto L5;
        f27613a = q5.a("ADgAJQBdABEAbgAJAHcAFQCMAEEAzQBFARIAIQEzADkBbAA9AakAoQJKATEDewAJA4QADQORABFLWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZz09UVoyVjBVMlZ5ZG1salpRPT1JY0dodmJtVT1VYVhCb2IyNWxjM1ZpYVc1bWJ3PT1NWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua2tVM1IxWWc9PVFZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWc9PUdWRkpCVGxOQlExUkpUMDVmWjJWMFJHVjJhV05sU1dRPUVZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5rPUlZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOD1FSW10bGVTSTZJaVZ6SWl3aWNHeGhkR1p2Y20waU9pSmhibVJ5YjJsa0lpd2laR2wxSWpvaUpYTWlMQ0p3YTJjaU9pSWxjeUlzSW0xdlpHVnNJam9pSlhNaUxDSmhjSEJ1WVcxbElqb2lKWE1pTENKaGNIQjJaWEp6YVc5dUlqb2lKWE1pTENKemVYTjJaWEp6YVc5dUlqb2lKWE1pTEE9PVNJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklpd2liMkZwWkNJNklpVnpJaXdpWVdScGRTSTZJaVZ6SWl3aWIzTmZkbVZ5SWpvaUpYTWlMQ0poWVdsa0lqb2lKWE1pSVlXbGtQUT09TWZITmxjbWxoYkQwPVFZVzVrY205cFpGOXBaQT09");
    L5:
        byte[] r100 = new byte[4];
        System.arraycopy(f27613a, 40, r100, 0, 4);
        int r101 = ((r100[0] & UByte.MAX_VALUE) * 256) + (r100[1] & UByte.MAX_VALUE);
        int r102 = ((r100[2] & 255) * 256) + (r100[3] & 255);
        byte[] r103 = new byte[r102];
        System.arraycopy(f27613a, r101, r103, 0, r102);
        return r103;
    }

    public static String a(String r100) {
        String r101 = "";
        ConcurrentHashMap<String, String> r102 = f27616d;     // Catch: Throwable -> L16
        monitor-enter(r102);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (f27616d != null) goto L8;
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        goto L15
    L8:
        if (f27616d.containsKey(r100) == false) goto L10;
        r101 = f27616d.get(r100);     // Catch: Throwable -> L12
    L15:
        return r101;
    }

    public static void a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        ConcurrentHashMap<String, String> r102 = f27616d;     // Catch: Throwable -> L21
        monitor-enter(r102);     // Catch: Throwable -> L21
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
        goto L27
    L10:
        if (f27616d != null) goto L13;
        f27616d = new ConcurrentHashMap(8);     // Catch: Throwable -> L17
    L13:
        if (f27616d.containsKey(r100) == true) goto L15;
        f27616d.put(r100, r101);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
        goto L27
    L26:
        return;
    }
}
