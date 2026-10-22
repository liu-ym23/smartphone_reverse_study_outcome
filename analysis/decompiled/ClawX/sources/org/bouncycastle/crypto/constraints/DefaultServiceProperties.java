package org.bouncycastle.crypto.constraints;

import org.bouncycastle.crypto.CryptoServiceProperties;
import org.bouncycastle.crypto.CryptoServicePurpose;

/* loaded from: classes.dex */
public class DefaultServiceProperties implements CryptoServiceProperties {
    private final String algorithm;
    private final int bitsOfSecurity;
    private final Object params;
    private final CryptoServicePurpose purpose;

    public DefaultServiceProperties(String str, int i8) {
        this(str, i8, null, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public int bitsOfSecurity() {
        return this.bitsOfSecurity;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public Object getParams() {
        return this.params;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public CryptoServicePurpose getPurpose() {
        return this.purpose;
    }

    @Override // org.bouncycastle.crypto.CryptoServiceProperties
    public String getServiceName() {
        return this.algorithm;
    }

    public DefaultServiceProperties(String str, int i8, Object obj) {
        this(str, i8, obj, CryptoServicePurpose.ANY);
    }

    public DefaultServiceProperties(String str, int i8, Object obj, CryptoServicePurpose cryptoServicePurpose) {
        this.algorithm = str;
        this.bitsOfSecurity = i8;
        this.params = obj;
        if (obj instanceof CryptoServicePurpose) {
            throw new IllegalArgumentException("params should not be CryptoServicePurpose");
        }
        this.purpose = cryptoServicePurpose;
    }
}
