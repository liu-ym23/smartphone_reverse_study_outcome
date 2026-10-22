package com.baidu.location.pb;

import L1.a;
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
public final class OffAuthReq extends f {
    public static final int AK_FIELD_NUMBER = 2;
    public static final int CLIENT_INFO_FIELD_NUMBER = 7;
    public static final int CU_FIELD_NUMBER = 1;
    public static final int GTL_FIELD_NUMBER = 8;
    public static final int GT_FIELD_NUMBER = 6;
    public static final int LOC_FIELD_NUMBER = 3;
    public static final int SRC_FIELD_NUMBER = 5;
    public static final int TS_FIELD_NUMBER = 4;
    private a ak_;
    private int cachedSize;
    private a clientInfo_;
    private a cu_;
    private List<Integer> gt_;
    private List<GridTypeLen> gtl_;
    private boolean hasAk;
    private boolean hasClientInfo;
    private boolean hasCu;
    private boolean hasLoc;
    private boolean hasSrc;
    private boolean hasTs;
    private Loc loc_;
    private a src_;
    private long ts_;

    public OffAuthReq() {
        a aVar = a.f1216c;
        this.cu_ = aVar;
        this.ak_ = aVar;
        this.loc_ = null;
        this.ts_ = 0L;
        this.src_ = aVar;
        this.gt_ = Collections.emptyList();
        this.clientInfo_ = aVar;
        this.gtl_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static OffAuthReq parseFrom(b bVar) throws IOException {
        return new OffAuthReq().mergeFrom(bVar);
    }

    public OffAuthReq addGt(int i4) {
        if (this.gt_.isEmpty()) {
            this.gt_ = new ArrayList();
        }
        this.gt_.add(Integer.valueOf(i4));
        return this;
    }

    public OffAuthReq addGtl(GridTypeLen gridTypeLen) {
        if (gridTypeLen == null) {
            return this;
        }
        if (this.gtl_.isEmpty()) {
            this.gtl_ = new ArrayList();
        }
        this.gtl_.add(gridTypeLen);
        return this;
    }

    public final OffAuthReq clear() {
        clearCu();
        clearAk();
        clearLoc();
        clearTs();
        clearSrc();
        clearGt();
        clearClientInfo();
        clearGtl();
        this.cachedSize = -1;
        return this;
    }

    public OffAuthReq clearAk() {
        this.hasAk = false;
        this.ak_ = a.f1216c;
        return this;
    }

    public OffAuthReq clearClientInfo() {
        this.hasClientInfo = false;
        this.clientInfo_ = a.f1216c;
        return this;
    }

    public OffAuthReq clearCu() {
        this.hasCu = false;
        this.cu_ = a.f1216c;
        return this;
    }

    public OffAuthReq clearGt() {
        this.gt_ = Collections.emptyList();
        return this;
    }

    public OffAuthReq clearGtl() {
        this.gtl_ = Collections.emptyList();
        return this;
    }

    public OffAuthReq clearLoc() {
        this.hasLoc = false;
        this.loc_ = null;
        return this;
    }

    public OffAuthReq clearSrc() {
        this.hasSrc = false;
        this.src_ = a.f1216c;
        return this;
    }

    public OffAuthReq clearTs() {
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

    public int getGt(int i4) {
        return this.gt_.get(i4).intValue();
    }

    public int getGtCount() {
        return this.gt_.size();
    }

    public List<Integer> getGtList() {
        return this.gt_;
    }

    public GridTypeLen getGtl(int i4) {
        return this.gtl_.get(i4);
    }

    public int getGtlCount() {
        return this.gtl_.size();
    }

    public List<GridTypeLen> getGtlList() {
        return this.gtl_;
    }

    public Loc getLoc() {
        return this.loc_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iF = 0;
        int iB = hasCu() ? d.b(1, getCu()) : 0;
        if (hasAk()) {
            iB += d.b(2, getAk());
        }
        if (hasLoc()) {
            iB += d.h(3, getLoc());
        }
        if (hasTs()) {
            iB += d.g(4, getTs());
        }
        if (hasSrc()) {
            iB += d.b(5, getSrc());
        }
        Iterator<Integer> it = getGtList().iterator();
        while (it.hasNext()) {
            iF += d.f(it.next().intValue());
        }
        int size = getGtList().size() + iB + iF;
        if (hasClientInfo()) {
            size += d.b(7, getClientInfo());
        }
        Iterator<GridTypeLen> it2 = getGtlList().iterator();
        while (it2.hasNext()) {
            size += d.h(8, it2.next());
        }
        this.cachedSize = size;
        return size;
    }

    public a getSrc() {
        return this.src_;
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

    public boolean hasLoc() {
        return this.hasLoc;
    }

    public boolean hasSrc() {
        return this.hasSrc;
    }

    public boolean hasTs() {
        return this.hasTs;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OffAuthReq setAk(a aVar) {
        this.hasAk = true;
        this.ak_ = aVar;
        return this;
    }

    public OffAuthReq setClientInfo(a aVar) {
        this.hasClientInfo = true;
        this.clientInfo_ = aVar;
        return this;
    }

    public OffAuthReq setCu(a aVar) {
        this.hasCu = true;
        this.cu_ = aVar;
        return this;
    }

    public OffAuthReq setGt(int i4, int i5) {
        this.gt_.set(i4, Integer.valueOf(i5));
        return this;
    }

    public OffAuthReq setGtl(int i4, GridTypeLen gridTypeLen) {
        if (gridTypeLen == null) {
            return this;
        }
        this.gtl_.set(i4, gridTypeLen);
        return this;
    }

    public OffAuthReq setLoc(Loc loc) {
        if (loc == null) {
            return clearLoc();
        }
        this.hasLoc = true;
        this.loc_ = loc;
        return this;
    }

    public OffAuthReq setSrc(a aVar) {
        this.hasSrc = true;
        this.src_ = aVar;
        return this;
    }

    public OffAuthReq setTs(long j4) {
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
        if (hasLoc()) {
            dVar.u(3, getLoc());
        }
        if (hasTs()) {
            dVar.t(4, getTs());
        }
        if (hasSrc()) {
            dVar.q(5, getSrc());
        }
        Iterator<Integer> it = getGtList().iterator();
        while (it.hasNext()) {
            dVar.s(6, it.next().intValue());
        }
        if (hasClientInfo()) {
            dVar.q(7, getClientInfo());
        }
        Iterator<GridTypeLen> it2 = getGtlList().iterator();
        while (it2.hasNext()) {
            dVar.u(8, it2.next());
        }
    }

    public static OffAuthReq parseFrom(byte[] bArr) throws e {
        return (OffAuthReq) new OffAuthReq().mergeFrom(bArr);
    }

    @Override // L1.f
    public OffAuthReq mergeFrom(b bVar) throws IOException {
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
                Loc loc = new Loc();
                bVar.f(loc);
                setLoc(loc);
            } else if (iO == 32) {
                setTs(bVar.l());
            } else if (iO == 42) {
                setSrc(bVar.b());
            } else if (iO == 48) {
                addGt(bVar.k());
            } else if (iO == 58) {
                setClientInfo(bVar.b());
            } else if (iO == 66) {
                GridTypeLen gridTypeLen = new GridTypeLen();
                bVar.f(gridTypeLen);
                addGtl(gridTypeLen);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
