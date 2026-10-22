package com.fasterxml.jackson.a.h;

import java.util.regex.Pattern;

/* JADX INFO: compiled from: VersionUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public class q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Pattern f12129a = null;

    static {
        f12129a = Pattern.compile("[-_./;:]");
    }

    public static final void a() {
        throw new RuntimeException("Internal error: this code path should never get executed");
    }
}
