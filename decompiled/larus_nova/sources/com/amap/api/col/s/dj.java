package com.amap.api.col.s;

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
public final class dj extends dn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f26572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f26573b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private cm f26574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Object[] f26575f;

    private String b() {
        return String.format(bs.c(this.f26573b), this.f26575f);
    L4:
        th = move-exception;
        th.printStackTrace();
        cg.c(th, "ofm", "gpj");
        return "";
    }

    @Override // com.amap.api.col.s.dn
    public final byte[] a(byte[] r100) throws CertificateException, NoSuchAlgorithmException, IOException, BadPaddingException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String r101 = bs.a(r100);
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return null;
    L7:
        return bs.a("{\"pinfo\":\"" + bs.a(this.f26574e.b(bs.a(b()))) + "\",\"els\":[" + r101 + "]}");
    }

    public dj(Context r100, dn r101, cm r102, String r103, Object... r104) {
        super(r101);
        this.f26572a = r100;
        this.f26573b = r103;
        this.f26574e = r102;
        this.f26575f = r104;
    }
}
