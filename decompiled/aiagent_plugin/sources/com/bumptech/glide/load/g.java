package com.bumptech.glide.load;

import java.nio.charset.Charset;
import java.security.MessageDigest;

/* JADX INFO: compiled from: Key.java */
/* JADX INFO: loaded from: classes.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Charset f3763a = null;

    void a(MessageDigest r1);

    boolean equals(Object r1);

    int hashCode();

    static {
        f3763a = Charset.forName("UTF-8");
    }
}
