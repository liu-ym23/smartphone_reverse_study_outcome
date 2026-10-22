package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class NrCellValue extends f {
    public static final int CI_FIELD_NUMBER = 1;
    public static final int CSIRSRP_FIELD_NUMBER = 8;
    public static final int CSIRSRQ_FIELD_NUMBER = 9;
    public static final int CSISINR_FIELD_NUMBER = 10;
    public static final int NRARFCN_FIELD_NUMBER = 4;
    public static final int PCI_FIELD_NUMBER = 2;
    public static final int SSRSRP_FIELD_NUMBER = 5;
    public static final int SSRSRQ_FIELD_NUMBER = 6;
    public static final int SSSINR_FIELD_NUMBER = 7;
    public static final int TAC_FIELD_NUMBER = 3;
    private boolean hasCi;
    private boolean hasCsirsrp;
    private boolean hasCsirsrq;
    private boolean hasCsisinr;
    private boolean hasNrarfcn;
    private boolean hasPci;
    private boolean hasSsrsrp;
    private boolean hasSsrsrq;
    private boolean hasSssinr;
    private boolean hasTac;
    private long ci_ = 0;
    private int pci_ = 0;
    private int tac_ = 0;
    private int nrarfcn_ = 0;
    private int ssrsrp_ = 0;
    private int ssrsrq_ = 0;
    private int sssinr_ = 0;
    private int csirsrp_ = 0;
    private int csirsrq_ = 0;
    private int csisinr_ = 0;
    private int cachedSize = -1;

    public static NrCellValue parseFrom(b bVar) throws IOException {
        return new NrCellValue().mergeFrom(bVar);
    }

    public final NrCellValue clear() {
        clearCi();
        clearPci();
        clearTac();
        clearNrarfcn();
        clearSsrsrp();
        clearSsrsrq();
        clearSssinr();
        clearCsirsrp();
        clearCsirsrq();
        clearCsisinr();
        this.cachedSize = -1;
        return this;
    }

    public NrCellValue clearCi() {
        this.hasCi = false;
        this.ci_ = 0L;
        return this;
    }

    public NrCellValue clearCsirsrp() {
        this.hasCsirsrp = false;
        this.csirsrp_ = 0;
        return this;
    }

    public NrCellValue clearCsirsrq() {
        this.hasCsirsrq = false;
        this.csirsrq_ = 0;
        return this;
    }

    public NrCellValue clearCsisinr() {
        this.hasCsisinr = false;
        this.csisinr_ = 0;
        return this;
    }

    public NrCellValue clearNrarfcn() {
        this.hasNrarfcn = false;
        this.nrarfcn_ = 0;
        return this;
    }

    public NrCellValue clearPci() {
        this.hasPci = false;
        this.pci_ = 0;
        return this;
    }

    public NrCellValue clearSsrsrp() {
        this.hasSsrsrp = false;
        this.ssrsrp_ = 0;
        return this;
    }

    public NrCellValue clearSsrsrq() {
        this.hasSsrsrq = false;
        this.ssrsrq_ = 0;
        return this;
    }

    public NrCellValue clearSssinr() {
        this.hasSssinr = false;
        this.sssinr_ = 0;
        return this;
    }

    public NrCellValue clearTac() {
        this.hasTac = false;
        this.tac_ = 0;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public long getCi() {
        return this.ci_;
    }

    public int getCsirsrp() {
        return this.csirsrp_;
    }

    public int getCsirsrq() {
        return this.csirsrq_;
    }

    public int getCsisinr() {
        return this.csisinr_;
    }

    public int getNrarfcn() {
        return this.nrarfcn_;
    }

    public int getPci() {
        return this.pci_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE;
        if (hasCi()) {
            long ci = getCi();
            iE = d.j(ci) + d.n(1);
        } else {
            iE = 0;
        }
        if (hasPci()) {
            iE += d.e(2, getPci());
        }
        if (hasTac()) {
            iE += d.e(3, getTac());
        }
        if (hasNrarfcn()) {
            iE += d.e(4, getNrarfcn());
        }
        if (hasSsrsrp()) {
            iE += d.e(5, getSsrsrp());
        }
        if (hasSsrsrq()) {
            iE += d.e(6, getSsrsrq());
        }
        if (hasSssinr()) {
            iE += d.e(7, getSssinr());
        }
        if (hasCsirsrp()) {
            iE += d.e(8, getCsirsrp());
        }
        if (hasCsirsrq()) {
            iE += d.e(9, getCsirsrq());
        }
        if (hasCsisinr()) {
            iE += d.e(10, getCsisinr());
        }
        this.cachedSize = iE;
        return iE;
    }

    public int getSsrsrp() {
        return this.ssrsrp_;
    }

    public int getSsrsrq() {
        return this.ssrsrq_;
    }

    public int getSssinr() {
        return this.sssinr_;
    }

    public int getTac() {
        return this.tac_;
    }

    public boolean hasCi() {
        return this.hasCi;
    }

    public boolean hasCsirsrp() {
        return this.hasCsirsrp;
    }

    public boolean hasCsirsrq() {
        return this.hasCsirsrq;
    }

    public boolean hasCsisinr() {
        return this.hasCsisinr;
    }

    public boolean hasNrarfcn() {
        return this.hasNrarfcn;
    }

    public boolean hasPci() {
        return this.hasPci;
    }

    public boolean hasSsrsrp() {
        return this.hasSsrsrp;
    }

    public boolean hasSsrsrq() {
        return this.hasSsrsrq;
    }

    public boolean hasSssinr() {
        return this.hasSssinr;
    }

    public boolean hasTac() {
        return this.hasTac;
    }

    public final boolean isInitialized() {
        return true;
    }

    public NrCellValue setCi(long j4) {
        this.hasCi = true;
        this.ci_ = j4;
        return this;
    }

    public NrCellValue setCsirsrp(int i4) {
        this.hasCsirsrp = true;
        this.csirsrp_ = i4;
        return this;
    }

    public NrCellValue setCsirsrq(int i4) {
        this.hasCsirsrq = true;
        this.csirsrq_ = i4;
        return this;
    }

    public NrCellValue setCsisinr(int i4) {
        this.hasCsisinr = true;
        this.csisinr_ = i4;
        return this;
    }

    public NrCellValue setNrarfcn(int i4) {
        this.hasNrarfcn = true;
        this.nrarfcn_ = i4;
        return this;
    }

    public NrCellValue setPci(int i4) {
        this.hasPci = true;
        this.pci_ = i4;
        return this;
    }

    public NrCellValue setSsrsrp(int i4) {
        this.hasSsrsrp = true;
        this.ssrsrp_ = i4;
        return this;
    }

    public NrCellValue setSsrsrq(int i4) {
        this.hasSsrsrq = true;
        this.ssrsrq_ = i4;
        return this;
    }

    public NrCellValue setSssinr(int i4) {
        this.hasSssinr = true;
        this.sssinr_ = i4;
        return this;
    }

    public NrCellValue setTac(int i4) {
        this.hasTac = true;
        this.tac_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasCi()) {
            long ci = getCi();
            dVar.B(1, 0);
            dVar.y(ci);
        }
        if (hasPci()) {
            dVar.s(2, getPci());
        }
        if (hasTac()) {
            dVar.s(3, getTac());
        }
        if (hasNrarfcn()) {
            dVar.s(4, getNrarfcn());
        }
        if (hasSsrsrp()) {
            dVar.s(5, getSsrsrp());
        }
        if (hasSsrsrq()) {
            dVar.s(6, getSsrsrq());
        }
        if (hasSssinr()) {
            dVar.s(7, getSssinr());
        }
        if (hasCsirsrp()) {
            dVar.s(8, getCsirsrp());
        }
        if (hasCsirsrq()) {
            dVar.s(9, getCsirsrq());
        }
        if (hasCsisinr()) {
            dVar.s(10, getCsisinr());
        }
    }

    public static NrCellValue parseFrom(byte[] bArr) throws e {
        return (NrCellValue) new NrCellValue().mergeFrom(bArr);
    }

    @Override // L1.f
    public NrCellValue mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 8:
                    setCi(bVar.l());
                    break;
                case 16:
                    setPci(bVar.k());
                    break;
                case 24:
                    setTac(bVar.k());
                    break;
                case 32:
                    setNrarfcn(bVar.k());
                    break;
                case 40:
                    setSsrsrp(bVar.k());
                    break;
                case 48:
                    setSsrsrq(bVar.k());
                    break;
                case 56:
                    setSssinr(bVar.k());
                    break;
                case 64:
                    setCsirsrp(bVar.k());
                    break;
                case 72:
                    setCsirsrq(bVar.k());
                    break;
                case 80:
                    setCsisinr(bVar.k());
                    break;
                default:
                    if (!parseUnknownField(bVar, iO)) {
                        return this;
                    }
                    break;
            }
        }
    }
}
