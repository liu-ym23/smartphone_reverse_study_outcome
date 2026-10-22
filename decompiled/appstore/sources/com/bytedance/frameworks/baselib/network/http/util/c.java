package com.bytedance.frameworks.baselib.network.http.util;

import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f7529a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f7530b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Pattern f7531c = null;

    static {
        f7529a = Pattern.compile("^(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)(\\.(25[0-5]|2[0-4]\\d|[0-1]?\\d?\\d)){3}$");
        f7530b = Pattern.compile("^(?:[0-9a-fA-F]{1,4}:){7}[0-9a-fA-F]{1,4}$");
        f7531c = Pattern.compile("^((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)::((?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?)$");
    }

    public static boolean a(String r10) {
        return f7529a.matcher(r10).matches();
    }

    public static boolean b(String r10) {
        return f7531c.matcher(r10).matches();
    }

    public static boolean c(String r10) {
        return f7530b.matcher(r10).matches();
    }
}
