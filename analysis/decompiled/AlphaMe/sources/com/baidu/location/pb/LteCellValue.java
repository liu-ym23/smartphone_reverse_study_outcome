package com.baidu.location.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class LteCellValue extends f {
    public static final int BANDWIDTH_FIELD_NUMBER = 5;
    public static final int CI_FIELD_NUMBER = 1;
    public static final int CQI_FIELD_NUMBER = 10;
    public static final int EARFCN_FIELD_NUMBER = 4;
    public static final int PCI_FIELD_NUMBER = 2;
    public static final int RSRP_FIELD_NUMBER = 7;
    public static final int RSRQ_FIELD_NUMBER = 8;
    public static final int RSSI_FIELD_NUMBER = 6;
    public static final int RSSNR_FIELD_NUMBER = 9;
    public static final int TAC_FIELD_NUMBER = 3;
    public static final int TIMINGADVANCE_FIELD_NUMBER = 11;
    private boolean hasBandwidth;
    private boolean hasCi;
    private boolean hasCqi;
    private boolean hasEarfcn;
    private boolean hasPci;
    private boolean hasRsrp;
    private boolean hasRsrq;
    private boolean hasRssi;
    private boolean hasRssnr;
    private boolean hasTac;
    private boolean hasTimingadvance;
    private int ci_ = 0;
    private int pci_ = 0;
    private int tac_ = 0;
    private int earfcn_ = 0;
    private int bandwidth_ = 0;
    private int rssi_ = 0;
    private int rsrp_ = 0;
    private int rsrq_ = 0;
    private int rssnr_ = 0;
    private int cqi_ = 0;
    private int timingadvance_ = 0;
    private int cachedSize = -1;

    public static LteCellValue parseFrom(b bVar) throws IOException {
        return new LteCellValue().mergeFrom(bVar);
    }

    public final LteCellValue clear() {
        clearCi();
        clearPci();
        clearTac();
        clearEarfcn();
        clearBandwidth();
        clearRssi();
        clearRsrp();
        clearRsrq();
        clearRssnr();
        clearCqi();
        clearTimingadvance();
        this.cachedSize = -1;
        return this;
    }

    public LteCellValue clearBandwidth() {
        this.hasBandwidth = false;
        this.bandwidth_ = 0;
        return this;
    }

    public LteCellValue clearCi() {
        this.hasCi = false;
        this.ci_ = 0;
        return this;
    }

    public LteCellValue clearCqi() {
        this.hasCqi = false;
        this.cqi_ = 0;
        return this;
    }

    public LteCellValue clearEarfcn() {
        this.hasEarfcn = false;
        this.earfcn_ = 0;
        return this;
    }

    public LteCellValue clearPci() {
        this.hasPci = false;
        this.pci_ = 0;
        return this;
    }

    public LteCellValue clearRsrp() {
        this.hasRsrp = false;
        this.rsrp_ = 0;
        return this;
    }

    public LteCellValue clearRsrq() {
        this.hasRsrq = false;
        this.rsrq_ = 0;
        return this;
    }

    public LteCellValue clearRssi() {
        this.hasRssi = false;
        this.rssi_ = 0;
        return this;
    }

    public LteCellValue clearRssnr() {
        this.hasRssnr = false;
        this.rssnr_ = 0;
        return this;
    }

    public LteCellValue clearTac() {
        this.hasTac = false;
        this.tac_ = 0;
        return this;
    }

    public LteCellValue clearTimingadvance() {
        this.hasTimingadvance = false;
        this.timingadvance_ = 0;
        return this;
    }

    public int getBandwidth() {
        return this.bandwidth_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCi() {
        return this.ci_;
    }

    public int getCqi() {
        return this.cqi_;
    }

    public int getEarfcn() {
        return this.earfcn_;
    }

    public int getPci() {
        return this.pci_;
    }

    public int getRsrp() {
        return this.rsrp_;
    }

    public int getRsrq() {
        return this.rsrq_;
    }

    public int getRssi() {
        return this.rssi_;
    }

    public int getRssnr() {
        return this.rssnr_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasCi() ? d.e(1, getCi()) : 0;
        if (hasPci()) {
            iE += d.e(2, getPci());
        }
        if (hasTac()) {
            iE += d.e(3, getTac());
        }
        if (hasEarfcn()) {
            iE += d.e(4, getEarfcn());
        }
        if (hasBandwidth()) {
            iE += d.e(5, getBandwidth());
        }
        if (hasRssi()) {
            iE += d.e(6, getRssi());
        }
        if (hasRsrp()) {
            iE += d.e(7, getRsrp());
        }
        if (hasRsrq()) {
            iE += d.e(8, getRsrq());
        }
        if (hasRssnr()) {
            iE += d.e(9, getRssnr());
        }
        if (hasCqi()) {
            iE += d.e(10, getCqi());
        }
        if (hasTimingadvance()) {
            iE += d.e(11, getTimingadvance());
        }
        this.cachedSize = iE;
        return iE;
    }

    public int getTac() {
        return this.tac_;
    }

    public int getTimingadvance() {
        return this.timingadvance_;
    }

    public boolean hasBandwidth() {
        return this.hasBandwidth;
    }

    public boolean hasCi() {
        return this.hasCi;
    }

    public boolean hasCqi() {
        return this.hasCqi;
    }

    public boolean hasEarfcn() {
        return this.hasEarfcn;
    }

    public boolean hasPci() {
        return this.hasPci;
    }

    public boolean hasRsrp() {
        return this.hasRsrp;
    }

    public boolean hasRsrq() {
        return this.hasRsrq;
    }

    public boolean hasRssi() {
        return this.hasRssi;
    }

    public boolean hasRssnr() {
        return this.hasRssnr;
    }

    public boolean hasTac() {
        return this.hasTac;
    }

    public boolean hasTimingadvance() {
        return this.hasTimingadvance;
    }

    public final boolean isInitialized() {
        return true;
    }

    public LteCellValue setBandwidth(int i4) {
        this.hasBandwidth = true;
        this.bandwidth_ = i4;
        return this;
    }

    public LteCellValue setCi(int i4) {
        this.hasCi = true;
        this.ci_ = i4;
        return this;
    }

    public LteCellValue setCqi(int i4) {
        this.hasCqi = true;
        this.cqi_ = i4;
        return this;
    }

    public LteCellValue setEarfcn(int i4) {
        this.hasEarfcn = true;
        this.earfcn_ = i4;
        return this;
    }

    public LteCellValue setPci(int i4) {
        this.hasPci = true;
        this.pci_ = i4;
        return this;
    }

    public LteCellValue setRsrp(int i4) {
        this.hasRsrp = true;
        this.rsrp_ = i4;
        return this;
    }

    public LteCellValue setRsrq(int i4) {
        this.hasRsrq = true;
        this.rsrq_ = i4;
        return this;
    }

    public LteCellValue setRssi(int i4) {
        this.hasRssi = true;
        this.rssi_ = i4;
        return this;
    }

    public LteCellValue setRssnr(int i4) {
        this.hasRssnr = true;
        this.rssnr_ = i4;
        return this;
    }

    public LteCellValue setTac(int i4) {
        this.hasTac = true;
        this.tac_ = i4;
        return this;
    }

    public LteCellValue setTimingadvance(int i4) {
        this.hasTimingadvance = true;
        this.timingadvance_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasCi()) {
            dVar.s(1, getCi());
        }
        if (hasPci()) {
            dVar.s(2, getPci());
        }
        if (hasTac()) {
            dVar.s(3, getTac());
        }
        if (hasEarfcn()) {
            dVar.s(4, getEarfcn());
        }
        if (hasBandwidth()) {
            dVar.s(5, getBandwidth());
        }
        if (hasRssi()) {
            dVar.s(6, getRssi());
        }
        if (hasRsrp()) {
            dVar.s(7, getRsrp());
        }
        if (hasRsrq()) {
            dVar.s(8, getRsrq());
        }
        if (hasRssnr()) {
            dVar.s(9, getRssnr());
        }
        if (hasCqi()) {
            dVar.s(10, getCqi());
        }
        if (hasTimingadvance()) {
            dVar.s(11, getTimingadvance());
        }
    }

    public static LteCellValue parseFrom(byte[] bArr) throws e {
        return (LteCellValue) new LteCellValue().mergeFrom(bArr);
    }

    @Override // L1.f
    public LteCellValue mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            switch (iO) {
                case 0:
                    return this;
                case 8:
                    setCi(bVar.k());
                    break;
                case 16:
                    setPci(bVar.k());
                    break;
                case 24:
                    setTac(bVar.k());
                    break;
                case 32:
                    setEarfcn(bVar.k());
                    break;
                case 40:
                    setBandwidth(bVar.k());
                    break;
                case 48:
                    setRssi(bVar.k());
                    break;
                case 56:
                    setRsrp(bVar.k());
                    break;
                case 64:
                    setRsrq(bVar.k());
                    break;
                case 72:
                    setRssnr(bVar.k());
                    break;
                case 80:
                    setCqi(bVar.k());
                    break;
                case 88:
                    setTimingadvance(bVar.k());
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
