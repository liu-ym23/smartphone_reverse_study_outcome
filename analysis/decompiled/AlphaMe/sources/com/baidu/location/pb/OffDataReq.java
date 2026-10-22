package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class OffDataReq extends f {
    public static final int AK_FIELD_NUMBER = 2;
    public static final int CLIENT_INFO_FIELD_NUMBER = 6;
    public static final int CU_FIELD_NUMBER = 1;
    public static final int GK_FIELD_NUMBER = 5;
    public static final int SN_FIELD_NUMBER = 3;
    public static final int VKEY_FIELD_NUMBER = 4;
    private a ak_;
    private int cachedSize;
    private a clientInfo_;
    private a cu_;
    private GridKey gk_;
    private boolean hasAk;
    private boolean hasClientInfo;
    private boolean hasCu;
    private boolean hasGk;
    private boolean hasSn;
    private boolean hasVkey;
    private a sn_;
    private a vkey_;

    public OffDataReq() {
        a aVar = a.f1216c;
        this.cu_ = aVar;
        this.ak_ = aVar;
        this.sn_ = aVar;
        this.vkey_ = aVar;
        this.gk_ = null;
        this.clientInfo_ = aVar;
        this.cachedSize = -1;
    }

    public static OffDataReq parseFrom(b bVar) throws IOException {
        return new OffDataReq().mergeFrom(bVar);
    }

    public final OffDataReq clear() {
        clearCu();
        clearAk();
        clearSn();
        clearVkey();
        clearGk();
        clearClientInfo();
        this.cachedSize = -1;
        return this;
    }

    public OffDataReq clearAk() {
        this.hasAk = false;
        this.ak_ = a.f1216c;
        return this;
    }

    public OffDataReq clearClientInfo() {
        this.hasClientInfo = false;
        this.clientInfo_ = a.f1216c;
        return this;
    }

    public OffDataReq clearCu() {
        this.hasCu = false;
        this.cu_ = a.f1216c;
        return this;
    }

    public OffDataReq clearGk() {
        this.hasGk = false;
        this.gk_ = null;
        return this;
    }

    public OffDataReq clearSn() {
        this.hasSn = false;
        this.sn_ = a.f1216c;
        return this;
    }

    public OffDataReq clearVkey() {
        this.hasVkey = false;
        this.vkey_ = a.f1216c;
        return this;
    }

    public a getAk() {
        return this.ak_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getClientInfo() {
        return this.clientInfo_;
    }

    public a getCu() {
        return this.cu_;
    }

    public GridKey getGk() {
        return this.gk_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasCu() ? d.b(1, getCu()) : 0;
        if (hasAk()) {
            iB += d.b(2, getAk());
        }
        if (hasSn()) {
            iB += d.b(3, getSn());
        }
        if (hasVkey()) {
            iB += d.b(4, getVkey());
        }
        if (hasGk()) {
            iB += d.h(5, getGk());
        }
        if (hasClientInfo()) {
            iB += d.b(6, getClientInfo());
        }
        this.cachedSize = iB;
        return iB;
    }

    public a getSn() {
        return this.sn_;
    }

    public a getVkey() {
        return this.vkey_;
    }

    public boolean hasAk() {
        return this.hasAk;
    }

    public boolean hasClientInfo() {
        return this.hasClientInfo;
    }

    public boolean hasCu() {
        return this.hasCu;
    }

    public boolean hasGk() {
        return this.hasGk;
    }

    public boolean hasSn() {
        return this.hasSn;
    }

    public boolean hasVkey() {
        return this.hasVkey;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffDataReq setAk(a aVar) {
        this.hasAk = true;
        this.ak_ = aVar;
        return this;
    }

    public OffDataReq setClientInfo(a aVar) {
        this.hasClientInfo = true;
        this.clientInfo_ = aVar;
        return this;
    }

    public OffDataReq setCu(a aVar) {
        this.hasCu = true;
        this.cu_ = aVar;
        return this;
    }

    public OffDataReq setGk(GridKey gridKey) {
        if (gridKey == null) {
            return clearGk();
        }
        this.hasGk = true;
        this.gk_ = gridKey;
        return this;
    }

    public OffDataReq setSn(a aVar) {
        this.hasSn = true;
        this.sn_ = aVar;
        return this;
    }

    public OffDataReq setVkey(a aVar) {
        this.hasVkey = true;
        this.vkey_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasCu()) {
            dVar.q(1, getCu());
        }
        if (hasAk()) {
            dVar.q(2, getAk());
        }
        if (hasSn()) {
            dVar.q(3, getSn());
        }
        if (hasVkey()) {
            dVar.q(4, getVkey());
        }
        if (hasGk()) {
            dVar.u(5, getGk());
        }
        if (hasClientInfo()) {
            dVar.q(6, getClientInfo());
        }
    }

    public static OffDataReq parseFrom(byte[] bArr) throws e {
        return (OffDataReq) new OffDataReq().mergeFrom(bArr);
    }

    @Override // L1.f
    public OffDataReq mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setCu(bVar.b());
            } else if (iO == 18) {
                setAk(bVar.b());
            } else if (iO == 26) {
                setSn(bVar.b());
            } else if (iO == 34) {
                setVkey(bVar.b());
            } else if (iO == 42) {
                GridKey gridKey = new GridKey();
                bVar.f(gridKey);
                setGk(gridKey);
            } else if (iO == 50) {
                setClientInfo(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
