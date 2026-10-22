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
public final class StatData extends f {
    public static final int ACCS_FIELD_NUMBER = 5;
    public static final int COSTS_FIELD_NUMBER = 6;
    public static final int LOAD_FAIL_CNT_FIELD_NUMBER = 2;
    public static final int LOAD_SUCC_CNT_FIELD_NUMBER = 1;
    public static final int LOC_FAIL_CNT_FIELD_NUMBER = 4;
    public static final int LOC_SUCC_CNT_FIELD_NUMBER = 3;
    private boolean hasLoadFailCnt;
    private boolean hasLoadSuccCnt;
    private boolean hasLocFailCnt;
    private boolean hasLocSuccCnt;
    private int loadSuccCnt_ = 0;
    private int loadFailCnt_ = 0;
    private int locSuccCnt_ = 0;
    private int locFailCnt_ = 0;
    private List<Integer> accs_ = Collections.emptyList();
    private List<Integer> costs_ = Collections.emptyList();
    private int cachedSize = -1;

    public static StatData parseFrom(b bVar) throws IOException {
        return new StatData().mergeFrom(bVar);
    }

    public StatData addAccs(int i4) {
        if (this.accs_.isEmpty()) {
            this.accs_ = new ArrayList();
        }
        this.accs_.add(Integer.valueOf(i4));
        return this;
    }

    public StatData addCosts(int i4) {
        if (this.costs_.isEmpty()) {
            this.costs_ = new ArrayList();
        }
        this.costs_.add(Integer.valueOf(i4));
        return this;
    }

    public final StatData clear() {
        clearLoadSuccCnt();
        clearLoadFailCnt();
        clearLocSuccCnt();
        clearLocFailCnt();
        clearAccs();
        clearCosts();
        this.cachedSize = -1;
        return this;
    }

    public StatData clearAccs() {
        this.accs_ = Collections.emptyList();
        return this;
    }

    public StatData clearCosts() {
        this.costs_ = Collections.emptyList();
        return this;
    }

    public StatData clearLoadFailCnt() {
        this.hasLoadFailCnt = false;
        this.loadFailCnt_ = 0;
        return this;
    }

    public StatData clearLoadSuccCnt() {
        this.hasLoadSuccCnt = false;
        this.loadSuccCnt_ = 0;
        return this;
    }

    public StatData clearLocFailCnt() {
        this.hasLocFailCnt = false;
        this.locFailCnt_ = 0;
        return this;
    }

    public StatData clearLocSuccCnt() {
        this.hasLocSuccCnt = false;
        this.locSuccCnt_ = 0;
        return this;
    }

    public int getAccs(int i4) {
        return this.accs_.get(i4).intValue();
    }

    public int getAccsCount() {
        return this.accs_.size();
    }

    public List<Integer> getAccsList() {
        return this.accs_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCosts(int i4) {
        return this.costs_.get(i4).intValue();
    }

    public int getCostsCount() {
        return this.costs_.size();
    }

    public List<Integer> getCostsList() {
        return this.costs_;
    }

    public int getLoadFailCnt() {
        return this.loadFailCnt_;
    }

    public int getLoadSuccCnt() {
        return this.loadSuccCnt_;
    }

    public int getLocFailCnt() {
        return this.locFailCnt_;
    }

    public int getLocSuccCnt() {
        return this.locSuccCnt_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iF = 0;
        int iE = hasLoadSuccCnt() ? d.e(1, getLoadSuccCnt()) : 0;
        if (hasLoadFailCnt()) {
            iE += d.e(2, getLoadFailCnt());
        }
        if (hasLocSuccCnt()) {
            iE += d.e(3, getLocSuccCnt());
        }
        if (hasLocFailCnt()) {
            iE += d.e(4, getLocFailCnt());
        }
        Iterator<Integer> it = getAccsList().iterator();
        int iF2 = 0;
        while (it.hasNext()) {
            iF2 += d.f(it.next().intValue());
        }
        int size = getAccsList().size() + iE + iF2;
        Iterator<Integer> it2 = getCostsList().iterator();
        while (it2.hasNext()) {
            iF += d.f(it2.next().intValue());
        }
        int size2 = getCostsList().size() + size + iF;
        this.cachedSize = size2;
        return size2;
    }

    public boolean hasLoadFailCnt() {
        return this.hasLoadFailCnt;
    }

    public boolean hasLoadSuccCnt() {
        return this.hasLoadSuccCnt;
    }

    public boolean hasLocFailCnt() {
        return this.hasLocFailCnt;
    }

    public boolean hasLocSuccCnt() {
        return this.hasLocSuccCnt;
    }

    public final boolean isInitialized() {
        return true;
    }

    public StatData setAccs(int i4, int i5) {
        this.accs_.set(i4, Integer.valueOf(i5));
        return this;
    }

    public StatData setCosts(int i4, int i5) {
        this.costs_.set(i4, Integer.valueOf(i5));
        return this;
    }

    public StatData setLoadFailCnt(int i4) {
        this.hasLoadFailCnt = true;
        this.loadFailCnt_ = i4;
        return this;
    }

    public StatData setLoadSuccCnt(int i4) {
        this.hasLoadSuccCnt = true;
        this.loadSuccCnt_ = i4;
        return this;
    }

    public StatData setLocFailCnt(int i4) {
        this.hasLocFailCnt = true;
        this.locFailCnt_ = i4;
        return this;
    }

    public StatData setLocSuccCnt(int i4) {
        this.hasLocSuccCnt = true;
        this.locSuccCnt_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasLoadSuccCnt()) {
            dVar.s(1, getLoadSuccCnt());
        }
        if (hasLoadFailCnt()) {
            dVar.s(2, getLoadFailCnt());
        }
        if (hasLocSuccCnt()) {
            dVar.s(3, getLocSuccCnt());
        }
        if (hasLocFailCnt()) {
            dVar.s(4, getLocFailCnt());
        }
        Iterator<Integer> it = getAccsList().iterator();
        while (it.hasNext()) {
            dVar.s(5, it.next().intValue());
        }
        Iterator<Integer> it2 = getCostsList().iterator();
        while (it2.hasNext()) {
            dVar.s(6, it2.next().intValue());
        }
    }

    public static StatData parseFrom(byte[] bArr) throws e {
        return (StatData) new StatData().mergeFrom(bArr);
    }

    @Override // L1.f
    public StatData mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setLoadSuccCnt(bVar.k());
            } else if (iO == 16) {
                setLoadFailCnt(bVar.k());
            } else if (iO == 24) {
                setLocSuccCnt(bVar.k());
            } else if (iO == 32) {
                setLocFailCnt(bVar.k());
            } else if (iO == 40) {
                addAccs(bVar.k());
            } else if (iO == 48) {
                addCosts(bVar.k());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
