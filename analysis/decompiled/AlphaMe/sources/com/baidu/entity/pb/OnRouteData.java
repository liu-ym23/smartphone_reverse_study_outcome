package com.baidu.entity.pb;

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
public final class OnRouteData extends f {
    public static final int DATA_FIELD_NUMBER = 2;
    public static final int MD5_FIELD_NUMBER = 1;
    private boolean hasMd5;
    private String md5_ = "";
    private List<CloudDataCom> data_ = Collections.emptyList();
    private int cachedSize = -1;

    public static OnRouteData parseFrom(b bVar) throws IOException {
        return new OnRouteData().mergeFrom(bVar);
    }

    public OnRouteData addData(CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        if (this.data_.isEmpty()) {
            this.data_ = new ArrayList();
        }
        this.data_.add(cloudDataCom);
        return this;
    }

    public final OnRouteData clear() {
        clearMd5();
        clearData();
        this.cachedSize = -1;
        return this;
    }

    public OnRouteData clearData() {
        this.data_ = Collections.emptyList();
        return this;
    }

    public OnRouteData clearMd5() {
        this.hasMd5 = false;
        this.md5_ = "";
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public CloudDataCom getData(int i4) {
        return this.data_.get(i4);
    }

    public int getDataCount() {
        return this.data_.size();
    }

    public List<CloudDataCom> getDataList() {
        return this.data_;
    }

    public String getMd5() {
        return this.md5_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iL = hasMd5() ? d.l(1, getMd5()) : 0;
        Iterator<CloudDataCom> it = getDataList().iterator();
        while (it.hasNext()) {
            iL += d.h(2, it.next());
        }
        this.cachedSize = iL;
        return iL;
    }

    public boolean hasMd5() {
        return this.hasMd5;
    }

    public final boolean isInitialized() {
        return true;
    }

    public OnRouteData setData(int i4, CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        this.data_.set(i4, cloudDataCom);
        return this;
    }

    public OnRouteData setMd5(String str) {
        this.hasMd5 = true;
        this.md5_ = str;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasMd5()) {
            dVar.A(1, getMd5());
        }
        Iterator<CloudDataCom> it = getDataList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
    }

    public static OnRouteData parseFrom(byte[] bArr) throws e {
        return (OnRouteData) new OnRouteData().mergeFrom(bArr);
    }

    @Override // L1.f
    public OnRouteData mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setMd5(bVar.n());
            } else if (iO == 18) {
                CloudDataCom cloudDataCom = new CloudDataCom();
                bVar.f(cloudDataCom);
                addData(cloudDataCom);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
