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
public final class OffAuthRes extends f {
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int ERRNUM_FIELD_NUMBER = 1;
    public static final int GKS_FIELD_NUMBER = 5;
    public static final int SN_FIELD_NUMBER = 4;
    public static final int VKEY_FIELD_NUMBER = 3;
    private int cachedSize;
    private a errmsg_;
    private int errnum_ = 0;
    private List<GridKey> gks_;
    private boolean hasErrmsg;
    private boolean hasErrnum;
    private boolean hasSn;
    private boolean hasVkey;
    private a sn_;
    private a vkey_;

    public OffAuthRes() {
        a aVar = a.f1216c;
        this.errmsg_ = aVar;
        this.vkey_ = aVar;
        this.sn_ = aVar;
        this.gks_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static OffAuthRes parseFrom(b bVar) throws IOException {
        return new OffAuthRes().mergeFrom(bVar);
    }

    public OffAuthRes addGks(GridKey gridKey) {
        if (gridKey == null) {
            return this;
        }
        if (this.gks_.isEmpty()) {
            this.gks_ = new ArrayList();
        }
        this.gks_.add(gridKey);
        return this;
    }

    public final OffAuthRes clear() {
        clearErrnum();
        clearErrmsg();
        clearVkey();
        clearSn();
        clearGks();
        this.cachedSize = -1;
        return this;
    }

    public OffAuthRes clearErrmsg() {
        this.hasErrmsg = false;
        this.errmsg_ = a.f1216c;
        return this;
    }

    public OffAuthRes clearErrnum() {
        this.hasErrnum = false;
        this.errnum_ = 0;
        return this;
    }

    public OffAuthRes clearGks() {
        this.gks_ = Collections.emptyList();
        return this;
    }

    public OffAuthRes clearSn() {
        this.hasSn = false;
        this.sn_ = a.f1216c;
        return this;
    }

    public OffAuthRes clearVkey() {
        this.hasVkey = false;
        this.vkey_ = a.f1216c;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getErrmsg() {
        return this.errmsg_;
    }

    public int getErrnum() {
        return this.errnum_;
    }

    public GridKey getGks(int i4) {
        return this.gks_.get(i4);
    }

    public int getGksCount() {
        return this.gks_.size();
    }

    public List<GridKey> getGksList() {
        return this.gks_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasErrnum() ? d.e(1, getErrnum()) : 0;
        if (hasErrmsg()) {
            iE += d.b(2, getErrmsg());
        }
        if (hasVkey()) {
            iE += d.b(3, getVkey());
        }
        if (hasSn()) {
            iE += d.b(4, getSn());
        }
        Iterator<GridKey> it = getGksList().iterator();
        while (it.hasNext()) {
            iE += d.h(5, it.next());
        }
        this.cachedSize = iE;
        return iE;
    }

    public a getSn() {
        return this.sn_;
    }

    public a getVkey() {
        return this.vkey_;
    }

    public boolean hasErrmsg() {
        return this.hasErrmsg;
    }

    public boolean hasErrnum() {
        return this.hasErrnum;
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

    public OffAuthRes setErrmsg(a aVar) {
        this.hasErrmsg = true;
        this.errmsg_ = aVar;
        return this;
    }

    public OffAuthRes setErrnum(int i4) {
        this.hasErrnum = true;
        this.errnum_ = i4;
        return this;
    }

    public OffAuthRes setGks(int i4, GridKey gridKey) {
        if (gridKey == null) {
            return this;
        }
        this.gks_.set(i4, gridKey);
        return this;
    }

    public OffAuthRes setSn(a aVar) {
        this.hasSn = true;
        this.sn_ = aVar;
        return this;
    }

    public OffAuthRes setVkey(a aVar) {
        this.hasVkey = true;
        this.vkey_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasErrnum()) {
            dVar.s(1, getErrnum());
        }
        if (hasErrmsg()) {
            dVar.q(2, getErrmsg());
        }
        if (hasVkey()) {
            dVar.q(3, getVkey());
        }
        if (hasSn()) {
            dVar.q(4, getSn());
        }
        Iterator<GridKey> it = getGksList().iterator();
        while (it.hasNext()) {
            dVar.u(5, it.next());
        }
    }

    public static OffAuthRes parseFrom(byte[] bArr) throws e {
        return (OffAuthRes) new OffAuthRes().mergeFrom(bArr);
    }

    @Override // L1.f
    public OffAuthRes mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setErrnum(bVar.k());
            } else if (iO == 18) {
                setErrmsg(bVar.b());
            } else if (iO == 26) {
                setVkey(bVar.b());
            } else if (iO == 34) {
                setSn(bVar.b());
            } else if (iO == 42) {
                GridKey gridKey = new GridKey();
                bVar.f(gridKey);
                addGks(gridKey);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
