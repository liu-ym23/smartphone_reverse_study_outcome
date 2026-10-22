package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class OffDataRes extends f {
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int ERRNUM_FIELD_NUMBER = 1;
    public static final int GV_FIELD_NUMBER = 3;
    private int cachedSize;
    private a errmsg_;
    private int errnum_ = 0;
    private a gv_;
    private boolean hasErrmsg;
    private boolean hasErrnum;
    private boolean hasGv;

    public OffDataRes() {
        a aVar = a.f1216c;
        this.errmsg_ = aVar;
        this.gv_ = aVar;
        this.cachedSize = -1;
    }

    public static OffDataRes parseFrom(b bVar) throws IOException {
        return new OffDataRes().mergeFrom(bVar);
    }

    public final OffDataRes clear() {
        clearErrnum();
        clearErrmsg();
        clearGv();
        this.cachedSize = -1;
        return this;
    }

    public OffDataRes clearErrmsg() {
        this.hasErrmsg = false;
        this.errmsg_ = a.f1216c;
        return this;
    }

    public OffDataRes clearErrnum() {
        this.hasErrnum = false;
        this.errnum_ = 0;
        return this;
    }

    public OffDataRes clearGv() {
        this.hasGv = false;
        this.gv_ = a.f1216c;
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

    public a getGv() {
        return this.gv_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasErrnum() ? d.e(1, getErrnum()) : 0;
        if (hasErrmsg()) {
            iE += d.b(2, getErrmsg());
        }
        if (hasGv()) {
            iE += d.b(3, getGv());
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

    public boolean hasGv() {
        return this.hasGv;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffDataRes setErrmsg(a aVar) {
        this.hasErrmsg = true;
        this.errmsg_ = aVar;
        return this;
    }

    public OffDataRes setErrnum(int i4) {
        this.hasErrnum = true;
        this.errnum_ = i4;
        return this;
    }

    public OffDataRes setGv(a aVar) {
        this.hasGv = true;
        this.gv_ = aVar;
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
        if (hasGv()) {
            dVar.q(3, getGv());
        }
    }

    public static OffDataRes parseFrom(byte[] bArr) throws e {
        return (OffDataRes) new OffDataRes().mergeFrom(bArr);
    }

    @Override // L1.f
    public OffDataRes mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setErrnum(bVar.k());
            } else if (iO == 18) {
                setErrmsg(bVar.b());
            } else if (iO == 26) {
                setGv(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
