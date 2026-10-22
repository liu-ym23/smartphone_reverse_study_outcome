package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class GridKey extends f {
    public static final int GT_FIELD_NUMBER = 3;
    public static final int GX_FIELD_NUMBER = 1;
    public static final int GY_FIELD_NUMBER = 2;
    public static final int LEN_FIELD_NUMBER = 4;
    private boolean hasGt;
    private boolean hasGx;
    private boolean hasGy;
    private boolean hasLen;
    private int gx_ = 0;
    private int gy_ = 0;
    private int gt_ = 0;
    private int len_ = 0;
    private int cachedSize = -1;

    public static GridKey parseFrom(b bVar) throws IOException {
        return new GridKey().mergeFrom(bVar);
    }

    public final GridKey clear() {
        clearGx();
        clearGy();
        clearGt();
        clearLen();
        this.cachedSize = -1;
        return this;
    }

    public GridKey clearGt() {
        this.hasGt = false;
        this.gt_ = 0;
        return this;
    }

    public GridKey clearGx() {
        this.hasGx = false;
        this.gx_ = 0;
        return this;
    }

    public GridKey clearGy() {
        this.hasGy = false;
        this.gy_ = 0;
        return this;
    }

    public GridKey clearLen() {
        this.hasLen = false;
        this.len_ = 0;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getGt() {
        return this.gt_;
    }

    public int getGx() {
        return this.gx_;
    }

    public int getGy() {
        return this.gy_;
    }

    public int getLen() {
        return this.len_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasGx() ? d.e(1, getGx()) : 0;
        if (hasGy()) {
            iE += d.e(2, getGy());
        }
        if (hasGt()) {
            iE += d.e(3, getGt());
        }
        if (hasLen()) {
            iE += d.e(4, getLen());
        }
        this.cachedSize = iE;
        return iE;
    }

    public boolean hasGt() {
        return this.hasGt;
    }

    public boolean hasGx() {
        return this.hasGx;
    }

    public boolean hasGy() {
        return this.hasGy;
    }

    public boolean hasLen() {
        return this.hasLen;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GridKey setGt(int i4) {
        this.hasGt = true;
        this.gt_ = i4;
        return this;
    }

    public GridKey setGx(int i4) {
        this.hasGx = true;
        this.gx_ = i4;
        return this;
    }

    public GridKey setGy(int i4) {
        this.hasGy = true;
        this.gy_ = i4;
        return this;
    }

    public GridKey setLen(int i4) {
        this.hasLen = true;
        this.len_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasGx()) {
            dVar.s(1, getGx());
        }
        if (hasGy()) {
            dVar.s(2, getGy());
        }
        if (hasGt()) {
            dVar.s(3, getGt());
        }
        if (hasLen()) {
            dVar.s(4, getLen());
        }
    }

    public static GridKey parseFrom(byte[] bArr) throws e {
        return (GridKey) new GridKey().mergeFrom(bArr);
    }

    @Override // L1.f
    public GridKey mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setGx(bVar.k());
            } else if (iO == 16) {
                setGy(bVar.k());
            } else if (iO == 24) {
                setGt(bVar.k());
            } else if (iO == 32) {
                setLen(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
