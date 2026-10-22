package org.c.a.m;

import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;

/* JADX INFO: compiled from: UriEncoder.java */
/* JADX INFO: loaded from: classes5.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final CharsetDecoder f40520a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final org.c.a.e.a.a.a.a.a.a.a f40521b = null;

    static {
        f40520a = Charset.forName("UTF-8").newDecoder().onMalformedInput(CodingErrorAction.REPORT);
        f40521b = new org.c.a.e.a.a.a.a.a.a.b("-_.!~*'()@:$&,;=[]/", false);
    }

    public static String a(String r1) {
        return f40521b.a(r1);
    }

    public static String a(ByteBuffer r1) {
        return f40520a.decode(r1).toString();
    }
}
