package com.amap.api.mapcore.util;

import android.content.Context;
import android.text.TextUtils;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* JADX INFO: loaded from: classes28.dex */
public class l8 extends p8 {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f27527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private j7 f27528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Object[] f27529e;

    @Override // com.amap.api.mapcore.util.p8
    public byte[] b(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String r101 = x5.c(r100);
        if (TextUtils.isEmpty(r101) == false) goto L12;
        return null;
    L12:
        String r102 = String.format(x5.b(this.f27527c), this.f27529e);     // Catch: Throwable -> L8
    L11:
        return x5.e("{\"pinfo\":\"" + x5.c(this.f27528d.b(x5.e(r102))) + "\",\"els\":[" + r101 + "]}");
    L8:
        th = move-exception;
        th.printStackTrace();
        t6.a(th, "ofm", "gpj");
        r102 = "";
        goto L11
    }

    public l8(Context r100, p8 r101, j7 r102, String r103, Object... r104) {
        super(r101);
        this.f27527c = r103;
        this.f27528d = r102;
        this.f27529e = r104;
    }
}
