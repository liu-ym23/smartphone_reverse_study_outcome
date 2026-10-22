package com.bytedance.android.ec.core.cps;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import org.bouncycastle.crypto.digests.SHA3Digest;

/* JADX INFO: loaded from: classes43.dex */
public final class j {
    public static final String d(byte[] r100) {
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L6;
        byte r104 = r100[r103];
        StringCompanionObject r105 = StringCompanionObject.INSTANCE;
        r101.append(String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(r104)}, 1)));
        r103 = r103 + 1;
        goto L3
    L6:
        return r101.toString();
    }

    public static final String a(String r100, String r101) {
        MessageDigest r102 = MessageDigest.getInstance(r101);
        Charset r103 = Charsets.UTF_8;
        if (r100 == null) goto L7;
        return d(r102.digest(r100.getBytes(r103)));
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String b(String r100, int r101) {
        SHA3Digest r102 = new SHA3Digest(r101);
        Charset r103 = Charsets.UTF_8;
        if (r100 == null) goto L7;
        byte[] r104 = r100.getBytes(r103);
        r102.update(r104, 0, r104.length);
        byte[] r105 = new byte[r102.getDigestSize()];
        r102.doFinal(r105, 0);
        return d(r105);
    L7:
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }

    public static final String c(k r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$encode");
        Intrinsics.checkNotNullParameter(r101, "data");
        String r102 = r100.encode(r101);
        if (r102 != null) goto L5;
    L11:
        if (r102 != null) goto L16;
        return null;
    L16:
        return r102.substring(0, 32);
    L5:
        if (r102.length() >= 32) goto L11;
        StringBuilder r103 = new StringBuilder(r102);
    L8:
        if (r103.length() >= 32) goto L10;
        String r104 = String.valueOf(System.currentTimeMillis());
        r103.append(i.f43940b.encode(r104));
        goto L8
    L10:
        r102 = r103.toString();
        goto L11
    }
}
