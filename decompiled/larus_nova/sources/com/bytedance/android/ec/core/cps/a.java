package com.bytedance.android.ec.core.cps;

import java.util.zip.CRC32;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f43936a = null;

    public a() {
    }

    static {
        f43936a = new a();
    }

    @Override // com.bytedance.android.ec.core.cps.k
    public final String encode(String r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        CRC32 r101 = new CRC32();     // Catch: Throwable -> L10
        r101.update(r100.getBytes(Charsets.UTF_8));     // Catch: Throwable -> L10
        String r102 = Long.toHexString(r101.getValue());     // Catch: Throwable -> L10
        if (r102.length() >= 8) goto L15;
        StringBuilder r103 = new StringBuilder();     // Catch: Throwable -> L10
        int r104 = r102.length();     // Catch: Throwable -> L10
    L6:
        if (r104 >= 8) goto L8;
        r103.append("0");     // Catch: Throwable -> L10
        r104 = r104 + 1;     // Catch: Throwable -> L10
        goto L6
    L8:
        return r103 + r102;
    L15:
        return r102;
    L10:
        return null;
    }
}
