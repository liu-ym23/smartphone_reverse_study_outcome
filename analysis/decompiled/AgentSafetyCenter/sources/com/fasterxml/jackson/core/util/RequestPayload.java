package com.fasterxml.jackson.core.util;

import ad.o;
import java.io.IOException;
import java.io.Serializable;
import od.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class RequestPayload implements Serializable {
    private static final long serialVersionUID = 1;
    protected String _charset;
    protected byte[] _payloadAsBytes;
    protected CharSequence _payloadAsText;

    public RequestPayload(byte[] bArr, String str) {
        if (bArr == null) {
            f.b();
            throw null;
        }
        this._payloadAsBytes = bArr;
        this._charset = (str == null || str.isEmpty()) ? "UTF-8" : str;
    }

    public Object getRawPayload() {
        byte[] bArr = this._payloadAsBytes;
        return bArr != null ? bArr : this._payloadAsText;
    }

    public String toString() {
        byte[] bArr = this._payloadAsBytes;
        if (bArr == null) {
            return this._payloadAsText.toString();
        }
        try {
            return new String(bArr, this._charset);
        } catch (IOException e10) {
            o.h(e10);
            return null;
        }
    }

    public RequestPayload(CharSequence charSequence) {
        if (charSequence != null) {
            this._payloadAsText = charSequence;
        } else {
            f.b();
            throw null;
        }
    }
}
