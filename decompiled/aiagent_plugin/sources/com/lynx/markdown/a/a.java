package com.lynx.markdown.a;

import java.io.DataInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

/* JADX INFO: compiled from: CBufferInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class a extends DataInputStream {
    public a(InputStream r1) {
        super(r1);
    }

    public String a() {
        int r0 = readInt();
        if (r0 != 0) goto L5;
        return "";
    L5:
        byte[] r2 = new byte[r0];
        if (read(r2, 0, r0) != (-1)) goto L8;
        return "";
    L8:
        return new String(r2, StandardCharsets.UTF_8);
    }
}
