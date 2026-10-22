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
public final class NaviRpCloudData extends f {
    public static final int ERROR_NO_FIELD_NUMBER = 1;
    public static final int ON_ROUTE_DATA_FIELD_NUMBER = 2;
    public static final int OUT_ROUTE_DATA_FIELD_NUMBER = 3;
    private boolean hasErrorNo;
    private boolean hasOutRouteData;
    private int errorNo_ = 0;
    private List<OnRouteData> onRouteData_ = Collections.emptyList();
    private OutRouteData outRouteData_ = null;
    private int cachedSize = -1;

    public static NaviRpCloudData parseFrom(b bVar) throws IOException {
        return new NaviRpCloudData().mergeFrom(bVar);
    }

    public NaviRpCloudData addOnRouteData(OnRouteData onRouteData) {
        if (onRouteData == null) {
            return this;
        }
        if (this.onRouteData_.isEmpty()) {
            this.onRouteData_ = new ArrayList();
        }
        this.onRouteData_.add(onRouteData);
        return this;
    }

    public final NaviRpCloudData clear() {
        clearErrorNo();
        clearOnRouteData();
        clearOutRouteData();
        this.cachedSize = -1;
        return this;
    }

    public NaviRpCloudData clearErrorNo() {
        this.hasErrorNo = false;
        this.errorNo_ = 0;
        return this;
    }

    public NaviRpCloudData clearOnRouteData() {
        this.onRouteData_ = Collections.emptyList();
        return this;
    }

    public NaviRpCloudData clearOutRouteData() {
        this.hasOutRouteData = false;
        this.outRouteData_ = null;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getErrorNo() {
        return this.errorNo_;
    }

    public OnRouteData getOnRouteData(int i4) {
        return this.onRouteData_.get(i4);
    }

    public int getOnRouteDataCount() {
        return this.onRouteData_.size();
    }

    public List<OnRouteData> getOnRouteDataList() {
        return this.onRouteData_;
    }

    public OutRouteData getOutRouteData() {
        return this.outRouteData_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasErrorNo() ? d.e(1, getErrorNo()) : 0;
        Iterator<OnRouteData> it = getOnRouteDataList().iterator();
        while (it.hasNext()) {
            iE += d.h(2, it.next());
        }
        if (hasOutRouteData()) {
            iE += d.h(3, getOutRouteData());
        }
        this.cachedSize = iE;
        return iE;
    }

    public boolean hasErrorNo() {
        return this.hasErrorNo;
    }

    public boolean hasOutRouteData() {
        return this.hasOutRouteData;
    }

    public final boolean isInitialized() {
        return this.hasErrorNo;
    }

    public NaviRpCloudData setErrorNo(int i4) {
        this.hasErrorNo = true;
        this.errorNo_ = i4;
        return this;
    }

    public NaviRpCloudData setOnRouteData(int i4, OnRouteData onRouteData) {
        if (onRouteData == null) {
            return this;
        }
        this.onRouteData_.set(i4, onRouteData);
        return this;
    }

    public NaviRpCloudData setOutRouteData(OutRouteData outRouteData) {
        if (outRouteData == null) {
            return clearOutRouteData();
        }
        this.hasOutRouteData = true;
        this.outRouteData_ = outRouteData;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasErrorNo()) {
            dVar.s(1, getErrorNo());
        }
        Iterator<OnRouteData> it = getOnRouteDataList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
        if (hasOutRouteData()) {
            dVar.u(3, getOutRouteData());
        }
    }

    public static NaviRpCloudData parseFrom(byte[] bArr) throws e {
        return (NaviRpCloudData) new NaviRpCloudData().mergeFrom(bArr);
    }

    @Override // L1.f
    public NaviRpCloudData mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setErrorNo(bVar.k());
            } else if (iO == 18) {
                OnRouteData onRouteData = new OnRouteData();
                bVar.f(onRouteData);
                addOnRouteData(onRouteData);
            } else if (iO == 26) {
                OutRouteData outRouteData = new OutRouteData();
                bVar.f(outRouteData);
                setOutRouteData(outRouteData);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
