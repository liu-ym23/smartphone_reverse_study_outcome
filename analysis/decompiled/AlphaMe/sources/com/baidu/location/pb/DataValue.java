package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class DataValue extends f {
    public static final int CL_FIELD_NUMBER = 4;
    public static final int COM_LOC_FIELD_NUMBER = 6;
    public static final int KEY_FIELD_NUMBER = 1;
    public static final int LOC_FIELD_NUMBER = 2;
    public static final int RES_FIELD_NUMBER = 5;
    public static final int R_FIELD_NUMBER = 3;
    private boolean hasCl;
    private boolean hasComLoc;
    private boolean hasKey;
    private boolean hasLoc;
    private boolean hasR;
    private boolean hasRes;
    private long key_ = 0;
    private Loc loc_ = null;
    private int r_ = 0;
    private int cl_ = 0;
    private long res_ = 0;
    private int comLoc_ = 0;
    private int cachedSize = -1;

    public static DataValue parseFrom(b bVar) throws IOException {
        return new DataValue().mergeFrom(bVar);
    }

    public final DataValue clear() {
        clearKey();
        clearLoc();
        clearR();
        clearCl();
        clearRes();
        clearComLoc();
        this.cachedSize = -1;
        return this;
    }

    public DataValue clearCl() {
        this.hasCl = false;
        this.cl_ = 0;
        return this;
    }

    public DataValue clearComLoc() {
        this.hasComLoc = false;
        this.comLoc_ = 0;
        return this;
    }

    public DataValue clearKey() {
        this.hasKey = false;
        this.key_ = 0L;
        return this;
    }

    public DataValue clearLoc() {
        this.hasLoc = false;
        this.loc_ = null;
        return this;
    }

    public DataValue clearR() {
        this.hasR = false;
        this.r_ = 0;
        return this;
    }

    public DataValue clearRes() {
        this.hasRes = false;
        this.res_ = 0L;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCl() {
        return this.cl_;
    }

    public int getComLoc() {
        return this.comLoc_;
    }

    public long getKey() {
        return this.key_;
    }

    public Loc getLoc() {
        return this.loc_;
    }

    public int getR() {
        return this.r_;
    }

    public long getRes() {
        return this.res_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iG = hasKey() ? d.g(1, getKey()) : 0;
        if (hasLoc()) {
            iG += d.h(2, getLoc());
        }
        if (hasR()) {
            iG += d.e(3, getR());
        }
        if (hasCl()) {
            iG += d.e(4, getCl());
        }
        if (hasRes()) {
            iG += d.g(5, getRes());
        }
        if (hasComLoc()) {
            iG += d.o(6, getComLoc());
        }
        this.cachedSize = iG;
        return iG;
    }

    public boolean hasCl() {
        return this.hasCl;
    }

    public boolean hasComLoc() {
        return this.hasComLoc;
    }

    public boolean hasKey() {
        return this.hasKey;
    }

    public boolean hasLoc() {
        return this.hasLoc;
    }

    public boolean hasR() {
        return this.hasR;
    }

    public boolean hasRes() {
        return this.hasRes;
    }

    public final boolean isInitialized() {
        return true;
    }

    public DataValue setCl(int i4) {
        this.hasCl = true;
        this.cl_ = i4;
        return this;
    }

    public DataValue setComLoc(int i4) {
        this.hasComLoc = true;
        this.comLoc_ = i4;
        return this;
    }

    public DataValue setKey(long j4) {
        this.hasKey = true;
        this.key_ = j4;
        return this;
    }

    public DataValue setLoc(Loc loc) {
        if (loc == null) {
            return clearLoc();
        }
        this.hasLoc = true;
        this.loc_ = loc;
        return this;
    }

    public DataValue setR(int i4) {
        this.hasR = true;
        this.r_ = i4;
        return this;
    }

    public DataValue setRes(long j4) {
        this.hasRes = true;
        this.res_ = j4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasKey()) {
            dVar.t(1, getKey());
        }
        if (hasLoc()) {
            dVar.u(2, getLoc());
        }
        if (hasR()) {
            dVar.s(3, getR());
        }
        if (hasCl()) {
            dVar.s(4, getCl());
        }
        if (hasRes()) {
            dVar.t(5, getRes());
        }
        if (hasComLoc()) {
            dVar.C(6, getComLoc());
        }
    }

    public static DataValue parseFrom(byte[] bArr) throws e {
        return (DataValue) new DataValue().mergeFrom(bArr);
    }

    @Override // L1.f
    public DataValue mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setKey(bVar.l());
            } else if (iO == 18) {
                Loc loc = new Loc();
                bVar.f(loc);
                setLoc(loc);
            } else if (iO == 24) {
                setR(bVar.k());
            } else if (iO == 32) {
                setCl(bVar.k());
            } else if (iO == 40) {
                setRes(bVar.l());
            } else if (iO == 48) {
                setComLoc(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
