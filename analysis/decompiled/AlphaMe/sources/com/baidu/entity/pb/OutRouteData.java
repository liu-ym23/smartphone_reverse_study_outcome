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
public final class OutRouteData extends f {
    public static final int DATA_FIELD_NUMBER = 1;
    private List<CloudDataCom> data_ = Collections.emptyList();
    private int cachedSize = -1;

    public static OutRouteData parseFrom(b bVar) throws IOException {
        return new OutRouteData().mergeFrom(bVar);
    }

    public OutRouteData addData(CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        if (this.data_.isEmpty()) {
            this.data_ = new ArrayList();
        }
        this.data_.add(cloudDataCom);
        return this;
    }

    public final OutRouteData clear() {
        clearData();
        this.cachedSize = -1;
        return this;
    }

    public OutRouteData clearData() {
        this.data_ = Collections.emptyList();
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

    @Override // L1.f
    public int getSerializedSize() {
        Iterator<CloudDataCom> it = getDataList().iterator();
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

    public OutRouteData setData(int i4, CloudDataCom cloudDataCom) {
        if (cloudDataCom == null) {
            return this;
        }
        this.data_.set(i4, cloudDataCom);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        Iterator<CloudDataCom> it = getDataList().iterator();
        while (it.hasNext()) {
            dVar.u(1, it.next());
        }
    }

    public static OutRouteData parseFrom(byte[] bArr) throws e {
        return (OutRouteData) new OutRouteData().mergeFrom(bArr);
    }

    @Override // L1.f
    public OutRouteData mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                CloudDataCom cloudDataCom = new CloudDataCom();
                bVar.f(cloudDataCom);
                addData(cloudDataCom);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
