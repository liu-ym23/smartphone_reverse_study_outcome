package com.amap.api.col.jmsl;

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

/* loaded from: classes.dex */
public class O extends AbstractC1614v0 {

    /* renamed from: c, reason: collision with root package name */
    public String f16226c;

    /* renamed from: d, reason: collision with root package name */
    public N f16227d;

    /* renamed from: e, reason: collision with root package name */
    public Object[] f16228e;

    public O(Context context, AbstractC1614v0 abstractC1614v0, N n10, String str, Object... objArr) {
        super(abstractC1614v0);
        this.f16226c = str;
        this.f16227d = n10;
        this.f16228e = objArr;
    }

    @Override // com.amap.api.col.jmsl.AbstractC1614v0
    public byte[] c(byte[] bArr) throws BadPaddingException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException, CertificateException {
        String str;
        String strN = C1604s2.n(bArr);
        if (TextUtils.isEmpty(strN)) {
            return null;
        }
        try {
            str = String.format(C1604s2.m(this.f16226c), this.f16228e);
        } catch (Throwable th) {
            th.printStackTrace();
            C1541c2.b(th, "ofm", "gpj");
            str = "";
        }
        return C1604s2.t("{\"pinfo\":\"" + C1604s2.n(this.f16227d.b(C1604s2.t(str))) + "\",\"els\":[" + strN + "]}");
    }
}
