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
public final class CellValueList extends f {
    public static final int CELL_VALUE_FIELD_NUMBER = 1;
    private List<CellValue> cellValue_ = Collections.emptyList();
    private int cachedSize = -1;

    public static CellValueList parseFrom(b bVar) throws IOException {
        return new CellValueList().mergeFrom(bVar);
    }

    public CellValueList addCellValue(CellValue cellValue) {
        if (cellValue == null) {
            return this;
        }
        if (this.cellValue_.isEmpty()) {
            this.cellValue_ = new ArrayList();
        }
        this.cellValue_.add(cellValue);
        return this;
    }

    public final CellValueList clear() {
        clearCellValue();
        this.cachedSize = -1;
        return this;
    }

    public CellValueList clearCellValue() {
        this.cellValue_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CellValue getCellValue(int i4) {
        return this.cellValue_.get(i4);
    }

    public int getCellValueCount() {
        return this.cellValue_.size();
    }

    public List<CellValue> getCellValueList() {
        return this.cellValue_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        Iterator<CellValue> it = getCellValueList().iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH += d.h(1, it.next());
        }
        this.cachedSize = iH;
        return iH;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CellValueList setCellValue(int i4, CellValue cellValue) {
        if (cellValue == null) {
            return this;
        }
        this.cellValue_.set(i4, cellValue);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        Iterator<CellValue> it = getCellValueList().iterator();
        while (it.hasNext()) {
            dVar.u(1, it.next());
        }
    }

    public static CellValueList parseFrom(byte[] bArr) throws e {
        return (CellValueList) new CellValueList().mergeFrom(bArr);
    }

    @Override // L1.f
    public CellValueList mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                CellValue cellValue = new CellValue();
                bVar.f(cellValue);
                addCellValue(cellValue);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
