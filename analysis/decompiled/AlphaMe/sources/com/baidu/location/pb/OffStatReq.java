package com.baidu.location.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class OffStatReq extends f {
    public static final int AK_FIELD_NUMBER = 2;
    public static final int CLIENT_INFO_FIELD_NUMBER = 5;
    public static final int CU_FIELD_NUMBER = 1;
    public static final int SD_FIELD_NUMBER = 4;
    public static final int TS_FIELD_NUMBER = 3;
    private a ak_;
    private int cachedSize;
    private a clientInfo_;
    private a cu_;
    private boolean hasAk;
    private boolean hasClientInfo;
    private boolean hasCu;
    private boolean hasSd;
    private boolean hasTs;
    private StatData sd_;
    private long ts_;

    public OffStatReq() {
        a aVar = a.f1216c;
        this.cu_ = aVar;
        this.ak_ = aVar;
        this.ts_ = 0L;
        this.sd_ = null;
        this.clientInfo_ = aVar;
        this.cachedSize = -1;
    }

    public static OffStatReq parseFrom(b bVar) throws IOException {
        return new OffStatReq().mergeFrom(bVar);
    }

    public final OffStatReq clear() {
        clearCu();
        clearAk();
        clearTs();
        clearSd();
        clearClientInfo();
        this.cachedSize = -1;
        return this;
    }

    public OffStatReq clearAk() {
        this.hasAk = false;
        this.ak_ = a.f1216c;
        return this;
    }

    public OffStatReq clearClientInfo() {
        this.hasClientInfo = false;
        this.clientInfo_ = a.f1216c;
        return this;
    }

    public OffStatReq clearCu() {
        this.hasCu = false;
        this.cu_ = a.f1216c;
        return this;
    }

    public OffStatReq clearSd() {
        this.hasSd = false;
        this.sd_ = null;
        return this;
    }

    public OffStatReq clearTs() {
        this.hasTs = false;
        this.ts_ = 0L;
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

    public StatData getSd() {
        return this.sd_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasCu() ? d.b(1, getCu()) : 0;
        if (hasAk()) {
            iB += d.b(2, getAk());
        }
        if (hasTs()) {
            iB += d.g(3, getTs());
        }
        if (hasSd()) {
            iB += d.h(4, getSd());
        }
        if (hasClientInfo()) {
            iB += d.b(5, getClientInfo());
        }
        this.cachedSize = iB;
        return iB;
    }

    public long getTs() {
        return this.ts_;
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

    public boolean hasSd() {
        return this.hasSd;
    }

    public boolean hasTs() {
        return this.hasTs;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffStatReq setAk(a aVar) {
        this.hasAk = true;
        this.ak_ = aVar;
        return this;
    }

    public OffStatReq setClientInfo(a aVar) {
        this.hasClientInfo = true;
        this.clientInfo_ = aVar;
        return this;
    }

    public OffStatReq setCu(a aVar) {
        this.hasCu = true;
        this.cu_ = aVar;
        return this;
    }

    public OffStatReq setSd(StatData statData) {
        if (statData == null) {
            return clearSd();
        }
        this.hasSd = true;
        this.sd_ = statData;
        return this;
    }

    public OffStatReq setTs(long j4) {
        this.hasTs = true;
        this.ts_ = j4;
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
        if (hasTs()) {
            dVar.t(3, getTs());
        }
        if (hasSd()) {
            dVar.u(4, getSd());
        }
        if (hasClientInfo()) {
            dVar.q(5, getClientInfo());
        }
    }

    public static OffStatReq parseFrom(byte[] bArr) throws e {
        return (OffStatReq) new OffStatReq().mergeFrom(bArr);
    }

    @Override // L1.f
    public OffStatReq mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setCu(bVar.b());
            } else if (iO == 18) {
                setAk(bVar.b());
            } else if (iO == 24) {
                setTs(bVar.l());
            } else if (iO == 34) {
                StatData statData = new StatData();
                bVar.f(statData);
                setSd(statData);
            } else if (iO == 42) {
                setClientInfo(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
