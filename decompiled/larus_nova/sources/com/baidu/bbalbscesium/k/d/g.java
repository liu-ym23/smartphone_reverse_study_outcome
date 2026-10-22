package com.baidu.bbalbscesium.k.d;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes39.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f30395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f30396b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f30397c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f30398d;

    private g(String r100, String r101, String r102, String r103) {
        this.f30395a = r100 + r101;
        this.f30396b = r101.toUpperCase(Locale.ENGLISH);
        this.f30397c = r102;
        this.f30398d = r103;
    }

    public static g a(String r100) throws NoSuchAlgorithmException {
        String[] r101 = b(r100);
        String r102 = r101[0];
        String r103 = r101[1];
        String r104 = r101[2];
        if (r103 != null) goto L5;
    L7:
        if (r104 == null) goto L12;
        if (r104.length() != 0) goto L12;
        r104 = null;
    L12:
        return new g(r102, "", r103, r104);
    L5:
        if (r103.length() != 0) goto L7;
        r103 = null;
        goto L7
    }

    private static String[] b(String r100) throws NoSuchAlgorithmException {
        if (r100 == null) goto L26;
        String[] r101 = new String[3];
        StringTokenizer r102 = new StringTokenizer(r100, HTTP.URL_DEFAULT);
        int r103 = 0;
    L27:
        if (r102.hasMoreTokens() == false) goto L9;
        if (r103 >= 3) goto L9;
        r101[r103] = r102.nextToken().trim();     // Catch: NoSuchElementException -> L23
        r103 = r103 + 1;     // Catch: NoSuchElementException -> L23
    L9:
        if (r103 == 0) goto L22;
        if (r103 == 2) goto L22;
        if (r102.hasMoreTokens() == true) goto L22;
        String r104 = r101[0];
        if (r104 == null) goto L20;
        if (r104.length() == 0) goto L20;
        return r101;
    L20:
        throw new NoSuchAlgorithmException("Invalid transformation:algorithm not specified-".concat(r100));
    L22:
        throw new NoSuchAlgorithmException("Invalid transformation format:" + r100);     // Catch: NoSuchElementException -> L23
    L24:
        throw new NoSuchAlgorithmException("Invalid transformation format:".concat(r100));
    L26:
        throw new NoSuchAlgorithmException("No transformation given");
    }

    public void a(c r100) throws NoSuchAlgorithmException, NoSuchPaddingException {
        String r101 = this.f30397c;
        if (r101 == null) goto L5;
        r100.a(r101);
    L5:
        String r102 = this.f30398d;
        if (r102 == null) goto L9;
        r100.b(r102);
        return;
    }
}
