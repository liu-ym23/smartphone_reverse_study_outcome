package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class GridValue extends f {
    public static final int DV_FIELD_NUMBER = 2;
    public static final int GK_FIELD_NUMBER = 1;
    public static final int IS_COMPRESSED_FIELD_NUMBER = 4;
    public static final int LEN_FIELD_NUMBER = 3;
    public static final int ORIG_FIELD_NUMBER = 5;
    private boolean hasGk;
    private boolean hasIsCompressed;
    private boolean hasLen;
    private boolean hasOrig;
    private GridKey gk_ = null;
    private List<DataValue> dv_ = Collections.emptyList();
    private int len_ = 0;
    private boolean isCompressed_ = false;
    private Loc orig_ = null;
    private int cachedSize = -1;

    public static GridValue parseFrom(b bVar) throws IOException {
        return new GridValue().mergeFrom(bVar);
    }

    public GridValue addDv(DataValue dataValue) {
        if (dataValue == null) {
            return this;
        }
        if (this.dv_.isEmpty()) {
            this.dv_ = new ArrayList();
        }
        this.dv_.add(dataValue);
        return this;
    }

    public final GridValue clear() {
        clearGk();
        clearDv();
        clearLen();
        clearIsCompressed();
        clearOrig();
        this.cachedSize = -1;
        return this;
    }

    public GridValue clearDv() {
        this.dv_ = Collections.emptyList();
        return this;
    }

    public GridValue clearGk() {
        this.hasGk = false;
        this.gk_ = null;
        return this;
    }

    public GridValue clearIsCompressed() {
        this.hasIsCompressed = false;
        this.isCompressed_ = false;
        return this;
    }

    public GridValue clearLen() {
        this.hasLen = false;
        this.len_ = 0;
        return this;
    }

    public GridValue clearOrig() {
        this.hasOrig = false;
        this.orig_ = null;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public DataValue getDv(int i4) {
        return this.dv_.get(i4);
    }

    public int getDvCount() {
        return this.dv_.size();
    }

    public List<DataValue> getDvList() {
        return this.dv_;
    }

    public GridKey getGk() {
        return this.gk_;
    }

    public boolean getIsCompressed() {
        return this.isCompressed_;
    }

    public int getLen() {
        return this.len_;
    }

    public Loc getOrig() {
        return this.orig_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iH = hasGk() ? d.h(1, getGk()) : 0;
        Iterator<DataValue> it = getDvList().iterator();
        while (it.hasNext()) {
            iH += d.h(2, it.next());
        }
        if (hasLen()) {
            iH += d.e(3, getLen());
        }
        if (hasIsCompressed()) {
            getIsCompressed();
            iH += d.a(4);
        }
        if (hasOrig()) {
            iH += d.h(5, getOrig());
        }
        this.cachedSize = iH;
        return iH;
    }

    public boolean hasGk() {
        return this.hasGk;
    }

    public boolean hasIsCompressed() {
        return this.hasIsCompressed;
    }

    public boolean hasLen() {
        return this.hasLen;
    }

    public boolean hasOrig() {
        return this.hasOrig;
    }

    public final boolean isInitialized() {
        return true;
    }

    public GridValue setDv(int i4, DataValue dataValue) {
        if (dataValue == null) {
            return this;
        }
        this.dv_.set(i4, dataValue);
        return this;
    }

    public GridValue setGk(GridKey gridKey) {
        if (gridKey == null) {
            return clearGk();
        }
        this.hasGk = true;
        this.gk_ = gridKey;
        return this;
    }

    public GridValue setIsCompressed(boolean z4) {
        this.hasIsCompressed = true;
        this.isCompressed_ = z4;
        return this;
    }

    public GridValue setLen(int i4) {
        this.hasLen = true;
        this.len_ = i4;
        return this;
    }

    public GridValue setOrig(Loc loc) {
        if (loc == null) {
            return clearOrig();
        }
        this.hasOrig = true;
        this.orig_ = loc;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasGk()) {
            dVar.u(1, getGk());
        }
        Iterator<DataValue> it = getDvList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
        if (hasLen()) {
            dVar.s(3, getLen());
        }
        if (hasIsCompressed()) {
            dVar.p(4, getIsCompressed());
        }
        if (hasOrig()) {
            dVar.u(5, getOrig());
        }
    }

    public static GridValue parseFrom(byte[] bArr) throws e {
        return (GridValue) new GridValue().mergeFrom(bArr);
    }

    @Override // L1.f
    public GridValue mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                GridKey gridKey = new GridKey();
                bVar.f(gridKey);
                setGk(gridKey);
            } else if (iO == 18) {
                DataValue dataValue = new DataValue();
                bVar.f(dataValue);
                addDv(dataValue);
            } else if (iO == 24) {
                setLen(bVar.k());
            } else if (iO == 32) {
                setIsCompressed(bVar.a());
            } else if (iO == 42) {
                Loc loc = new Loc();
                bVar.f(loc);
                setOrig(loc);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
