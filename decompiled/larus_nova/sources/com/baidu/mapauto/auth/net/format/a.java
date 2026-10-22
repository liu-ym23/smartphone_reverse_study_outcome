package com.baidu.mapauto.auth.net.format;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.UUID;

/* JADX INFO: loaded from: classes39.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f31806a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f31807b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final String f31808c = null;

    static {
        String r100 = UUID.randomUUID().toString();
        f31806a = r100;
        f31807b = "\r\n--" + r100 + "\r\n";
        f31808c = "\r\n--" + r100 + "--\r\n";
    }

    public a() {
    }

    public final String a(HashMap r100) {
        StringBuilder r101 = new StringBuilder();
        Iterator r102 = r100.keySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L12;
        String r103 = (String) r102.next();
        Object r104 = r100.get(r103);
        if ((r104 instanceof File) == true) goto L11;
        if (r104 == null) goto L4;
        String r105 = r104.toString();
        r101.append(f31807b);
        r101.append("Content-Disposition: form-data; name=\"");
        r101.append(r103);
        r101.append("\"\r\n\r\n");
        r101.append(r105);
        goto L4
    L11:
        throw new UnsupportedOperationException();
    L12:
        r101.append(f31808c);
        return r101.toString();
    }
}
