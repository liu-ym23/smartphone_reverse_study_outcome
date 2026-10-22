package com.bytedance.frameworks.baselib.network.http.i;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: InetAddressUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f8377a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f8378b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f8379c = null;

    static {
        f8377a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f8378b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f8379c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r1) {
        return f8377a.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean b(String r1) {
        return f8378b.matcher(r1).matches();
    L4:
        return false;
    }

    public static boolean c(String r1) {
        return f8379c.matcher(r1).matches();
    L4:
        return false;
    }
}
