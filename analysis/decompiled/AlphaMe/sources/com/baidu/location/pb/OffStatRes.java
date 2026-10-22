package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class OffStatRes extends f {
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int ERRNUM_FIELD_NUMBER = 1;
    private boolean hasErrmsg;
    private boolean hasErrnum;
    private int errnum_ = 0;
    private a errmsg_ = a.f1216c;
    private int cachedSize = -1;

    public static OffStatRes parseFrom(b bVar) throws IOException {
        return new OffStatRes().mergeFrom(bVar);
    }

    public final OffStatRes clear() {
        clearErrnum();
        clearErrmsg();
        this.cachedSize = -1;
        return this;
    }

    public OffStatRes clearErrmsg() {
        this.hasErrmsg = false;
        this.errmsg_ = a.f1216c;
        return this;
    }

    public OffStatRes clearErrnum() {
        this.hasErrnum = false;
        this.errnum_ = 0;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getErrmsg() {
        return this.errmsg_;
    }

    public int getErrnum() {
        return this.errnum_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasErrnum() ? d.e(1, getErrnum()) : 0;
        if (hasErrmsg()) {
            iE += d.b(2, getErrmsg());
        }
        this.cachedSize = iE;
        return iE;
    }

    public boolean hasErrmsg() {
        return this.hasErrmsg;
    }

    public boolean hasErrnum() {
        return this.hasErrnum;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffStatRes setErrmsg(a aVar) {
        this.hasErrmsg = true;
        this.errmsg_ = aVar;
        return this;
    }

    public OffStatRes setErrnum(int i4) {
        this.hasErrnum = true;
        this.errnum_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasErrnum()) {
            dVar.s(1, getErrnum());
        }
        if (hasErrmsg()) {
            dVar.q(2, getErrmsg());
        }
    }

    public static OffStatRes parseFrom(byte[] bArr) throws e {
        return (OffStatRes) new OffStatRes().mergeFrom(bArr);
    }

    @Override // L1.f
    public OffStatRes mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setErrnum(bVar.k());
            } else if (iO == 18) {
                setErrmsg(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
