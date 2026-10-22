package com.amap.api.col.s;

import android.text.TextUtils;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.UByte;

/* JADX INFO: loaded from: classes28.dex */
public final class cc {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f26371a = "9aj&#k81";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f26372b = "IaHR0cDovL2xvZ3MuYW1hcC5jb20vd3MvbG9nL3VwbG9hZD9wcm9kdWN0PSVzJnR5cGU9JXMmcGxhdGZvcm09JXMmY2hhbm5lbD0lcyZzaWduPSVz";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static byte[] f26373c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f26374d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static boolean f26375e = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Integer f26376f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Integer f26377g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Integer f26378h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Integer f26379i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Integer f26380j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static String f26381k = "ADgAIwBbAA8AagAIAHIAEwCFAD8AxABDAQcAIQEoADgBYAA8AZwAnwI7APADKwAHAzIADAM+AA9LWVc1a2NtOXBaQzV2Y3k1VFpYSjJhV05sVFdGdVlXZGxjZ1FaMlYwVTJWeWRtbGpaUUljR2h2Ym1VVWFYQm9iMjVsYzNWaWFXNW1id01ZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsVVpXeGxjR2h2Ym5ra1UzUjFZZ1FZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOGtVM1IxWWdHVkZKQlRsTkJRMVJKVDA1ZloyVjBSR1YyYVdObFNXUT1FWTI5dExtRnVaSEp2YVdRdWFXNTBaWEp1WVd3dWRHVnNaWEJvYjI1NUxrbFVaV3hsY0dodmJua0lZMjl0TG1GdVpISnZhV1F1YVc1MFpYSnVZV3d1ZEdWc1pYQm9iMjU1TGtsUWFHOXVaVk4xWWtsdVptOEVJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSndhMmNpT2lJbGN5SXNJbTF2WkdWc0lqb2lKWE1pTENKaGNIQnVZVzFsSWpvaUpYTWlMQ0poY0hCMlpYSnphVzl1SWpvaUpYTWlMQ0p6ZVhOMlpYSnphVzl1SWpvaUpYTWlMQUdJbXRsZVNJNklpVnpJaXdpY0d4aGRHWnZjbTBpT2lKaGJtUnliMmxrSWl3aVpHbDFJam9pSlhNaUxDSnRZV01pT2lJbGN5SXNJblJwWkNJNklpVnpJaXdpZFcxcFpIUWlPaUlsY3lJc0ltMWhiblZtWVdOMGRYSmxJam9pSlhNaUxDSmtaWFpwWTJVaU9pSWxjeUlzSW5OcGJTSTZJaVZ6SWl3aWNHdG5Jam9pSlhNaUxDSnRiMlJsYkNJNklpVnpJaXdpWVhCd2RtVnljMmx2YmlJNklpVnpJaXdpWVhCd2JtRnRaU0k2SWlWeklnPUlZV2xrUFFNZkhObGNtbGhiRDBRWVc1a2NtOXBaRjlwWkE=";

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static volatile ConcurrentHashMap<String, String> f26382l;

    static {
        f26382l = new ConcurrentHashMap(8);
        f26376f = 1;
        f26377g = 2;
        f26378h = 3;
        f26379i = 4;
        f26380j = 5;
    }

    public static byte[] a(int r100) {
        if (f26373c != null) goto L5;
        f26373c = bn.b(f26381k);
    L5:
        byte[] r101 = new byte[4];
        System.arraycopy(f26373c, r100 * 4, r101, 0, 4);
        int r102 = ((r101[0] & UByte.MAX_VALUE) * 256) + (r101[1] & UByte.MAX_VALUE);
        int r103 = ((r101[2] & 255) * 256) + (r101[3] & 255);
        byte[] r104 = new byte[r103];
        System.arraycopy(f26373c, r102, r104, 0, r103);
        return r104;
    }

    public static String a(String r100) {
        String r101 = "";
        ConcurrentHashMap<String, String> r102 = f26382l;     // Catch: Throwable -> L16
        monitor-enter(r102);     // Catch: Throwable -> L16
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L16
    L6:
        if (f26382l != null) goto L8;
    L10:
        monitor-exit(r102);     // Catch: Throwable -> L12
        goto L15
    L8:
        if (f26382l.containsKey(r100) == false) goto L10;
        r101 = f26382l.get(r100);     // Catch: Throwable -> L12
    L15:
        return r101;
    }

    public static void a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L26;
        ConcurrentHashMap<String, String> r102 = f26382l;     // Catch: Throwable -> L21
        monitor-enter(r102);     // Catch: Throwable -> L21
    L17:
        th = move-exception;
        throw th;     // Catch: Throwable -> L21
        goto L27
    L10:
        if (f26382l != null) goto L13;
        f26382l = new ConcurrentHashMap(8);     // Catch: Throwable -> L17
    L13:
        if (f26382l.containsKey(r100) == true) goto L15;
        f26382l.put(r100, r101);     // Catch: Throwable -> L17
    L15:
        monitor-exit(r102);     // Catch: Throwable -> L17
        return;
        goto L27
    L26:
        return;
    }
}
