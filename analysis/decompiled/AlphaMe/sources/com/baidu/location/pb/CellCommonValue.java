package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class CellCommonValue extends f {
    public static final int CELLCONNECTIONSTATUS_FIELD_NUMBER = 6;
    public static final int CELL_TYPE_FIELD_NUMBER = 1;
    public static final int MCC_FIELD_NUMBER = 2;
    public static final int MNC_FIELD_NUMBER = 3;
    public static final int REGISTERED_FIELD_NUMBER = 4;
    public static final int TIMESTAMP_FIELD_NUMBER = 5;
    private int cachedSize;
    private int cellType_ = 0;
    private int cellconnectionstatus_;
    private boolean hasCellType;
    private boolean hasCellconnectionstatus;
    private boolean hasMcc;
    private boolean hasMnc;
    private boolean hasRegistered;
    private boolean hasTimestamp;
    private a mcc_;
    private a mnc_;
    private int registered_;
    private long timestamp_;

    public CellCommonValue() {
        a aVar = a.f1216c;
        this.mcc_ = aVar;
        this.mnc_ = aVar;
        this.registered_ = 0;
        this.timestamp_ = 0L;
        this.cellconnectionstatus_ = 0;
        this.cachedSize = -1;
    }

    public static CellCommonValue parseFrom(b bVar) throws IOException {
        return new CellCommonValue().mergeFrom(bVar);
    }

    public final CellCommonValue clear() {
        clearCellType();
        clearMcc();
        clearMnc();
        clearRegistered();
        clearTimestamp();
        clearCellconnectionstatus();
        this.cachedSize = -1;
        return this;
    }

    public CellCommonValue clearCellType() {
        this.hasCellType = false;
        this.cellType_ = 0;
        return this;
    }

    public CellCommonValue clearCellconnectionstatus() {
        this.hasCellconnectionstatus = false;
        this.cellconnectionstatus_ = 0;
        return this;
    }

    public CellCommonValue clearMcc() {
        this.hasMcc = false;
        this.mcc_ = a.f1216c;
        return this;
    }

    public CellCommonValue clearMnc() {
        this.hasMnc = false;
        this.mnc_ = a.f1216c;
        return this;
    }

    public CellCommonValue clearRegistered() {
        this.hasRegistered = false;
        this.registered_ = 0;
        return this;
    }

    public CellCommonValue clearTimestamp() {
        this.hasTimestamp = false;
        this.timestamp_ = 0L;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCellType() {
        return this.cellType_;
    }

    public int getCellconnectionstatus() {
        return this.cellconnectionstatus_;
    }

    public a getMcc() {
        return this.mcc_;
    }

    public a getMnc() {
        return this.mnc_;
    }

    public int getRegistered() {
        return this.registered_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasCellType() ? d.e(1, getCellType()) : 0;
        if (hasMcc()) {
            iE += d.b(2, getMcc());
        }
        if (hasMnc()) {
            iE += d.b(3, getMnc());
        }
        if (hasRegistered()) {
            iE += d.e(4, getRegistered());
        }
        if (hasTimestamp()) {
            iE += d.j(getTimestamp()) + d.n(5);
        }
        if (hasCellconnectionstatus()) {
            iE += d.e(6, getCellconnectionstatus());
        }
        this.cachedSize = iE;
        return iE;
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public boolean hasCellType() {
        return this.hasCellType;
    }

    public boolean hasCellconnectionstatus() {
        return this.hasCellconnectionstatus;
    }

    public boolean hasMcc() {
        return this.hasMcc;
    }

    public boolean hasMnc() {
        return this.hasMnc;
    }

    public boolean hasRegistered() {
        return this.hasRegistered;
    }

    public boolean hasTimestamp() {
        return this.hasTimestamp;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CellCommonValue setCellType(int i4) {
        this.hasCellType = true;
        this.cellType_ = i4;
        return this;
    }

    public CellCommonValue setCellconnectionstatus(int i4) {
        this.hasCellconnectionstatus = true;
        this.cellconnectionstatus_ = i4;
        return this;
    }

    public CellCommonValue setMcc(a aVar) {
        this.hasMcc = true;
        this.mcc_ = aVar;
        return this;
    }

    public CellCommonValue setMnc(a aVar) {
        this.hasMnc = true;
        this.mnc_ = aVar;
        return this;
    }

    public CellCommonValue setRegistered(int i4) {
        this.hasRegistered = true;
        this.registered_ = i4;
        return this;
    }

    public CellCommonValue setTimestamp(long j4) {
        this.hasTimestamp = true;
        this.timestamp_ = j4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasCellType()) {
            dVar.s(1, getCellType());
        }
        if (hasMcc()) {
            dVar.q(2, getMcc());
        }
        if (hasMnc()) {
            dVar.q(3, getMnc());
        }
        if (hasRegistered()) {
            dVar.s(4, getRegistered());
        }
        if (hasTimestamp()) {
            long timestamp = getTimestamp();
            dVar.B(5, 0);
            dVar.y(timestamp);
        }
        if (hasCellconnectionstatus()) {
            dVar.s(6, getCellconnectionstatus());
        }
    }

    public static CellCommonValue parseFrom(byte[] bArr) throws e {
        return (CellCommonValue) new CellCommonValue().mergeFrom(bArr);
    }

    @Override // L1.f
    public CellCommonValue mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setCellType(bVar.k());
            } else if (iO == 18) {
                setMcc(bVar.b());
            } else if (iO == 26) {
                setMnc(bVar.b());
            } else if (iO == 32) {
                setRegistered(bVar.k());
            } else if (iO == 40) {
                setTimestamp(bVar.l());
            } else if (iO == 48) {
                setCellconnectionstatus(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
