package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class GridTypeLen extends f {
    public static final int GL_FIELD_NUMBER = 2;
    public static final int GT_FIELD_NUMBER = 1;
    private boolean hasGl;
    private boolean hasGt;
    private int gt_ = 0;
    private int gl_ = 0;
    private int cachedSize = -1;

    public static GridTypeLen parseFrom(b bVar) throws IOException {
        return new GridTypeLen().mergeFrom(bVar);
    }

    public final GridTypeLen clear() {
        clearGt();
        clearGl();
        this.cachedSize = -1;
        return this;
    }

    public GridTypeLen clearGl() {
        this.hasGl = false;
        this.gl_ = 0;
        return this;
    }

    public GridTypeLen clearGt() {
        this.hasGt = false;
        this.gt_ = 0;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getGl() {
        return this.gl_;
    }

    public int getGt() {
        return this.gt_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasGt() ? d.e(1, getGt()) : 0;
        if (hasGl()) {
            iE += d.e(2, getGl());
        }
        this.cachedSize = iE;
        return iE;
    }

    public boolean hasGl() {
        return this.hasGl;
    }

    public boolean hasGt() {
        return this.hasGt;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GridTypeLen setGl(int i4) {
        this.hasGl = true;
        this.gl_ = i4;
        return this;
    }

    public GridTypeLen setGt(int i4) {
        this.hasGt = true;
        this.gt_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasGt()) {
            dVar.s(1, getGt());
        }
        if (hasGl()) {
            dVar.s(2, getGl());
        }
    }

    public static GridTypeLen parseFrom(byte[] bArr) throws e {
        return (GridTypeLen) new GridTypeLen().mergeFrom(bArr);
    }

    @Override // L1.f
    public GridTypeLen mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setGt(bVar.k());
            } else if (iO == 16) {
                setGl(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
