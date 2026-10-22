package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class CloudDataCom extends f {
    public static final int BASE_FIELD_NUMBER = 1;
    public static final int DETAIL_FIELD_NUMBER = 2;
    private boolean hasBase;
    private boolean hasDetail;
    private CloudDataBase base_ = null;
    private a detail_ = a.f1216c;
    private int cachedSize = -1;

    public static CloudDataCom parseFrom(b bVar) throws IOException {
        return new CloudDataCom().mergeFrom(bVar);
    }

    public final CloudDataCom clear() {
        clearBase();
        clearDetail();
        this.cachedSize = -1;
        return this;
    }

    public CloudDataCom clearBase() {
        this.hasBase = false;
        this.base_ = null;
        return this;
    }

    public CloudDataCom clearDetail() {
        this.hasDetail = false;
        this.detail_ = a.f1216c;
        return this;
    }

    public CloudDataBase getBase() {
        return this.base_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getDetail() {
        return this.detail_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iH = hasBase() ? d.h(1, getBase()) : 0;
        if (hasDetail()) {
            iH += d.b(2, getDetail());
        }
        this.cachedSize = iH;
        return iH;
    }

    public boolean hasBase() {
        return this.hasBase;
    }

    public boolean hasDetail() {
        return this.hasDetail;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CloudDataCom setBase(CloudDataBase cloudDataBase) {
        if (cloudDataBase == null) {
            return clearBase();
        }
        this.hasBase = true;
        this.base_ = cloudDataBase;
        return this;
    }

    public CloudDataCom setDetail(a aVar) {
        this.hasDetail = true;
        this.detail_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasBase()) {
            dVar.u(1, getBase());
        }
        if (hasDetail()) {
            dVar.q(2, getDetail());
        }
    }

    public static CloudDataCom parseFrom(byte[] bArr) throws e {
        return (CloudDataCom) new CloudDataCom().mergeFrom(bArr);
    }

    @Override // L1.f
    public CloudDataCom mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                CloudDataBase cloudDataBase = new CloudDataBase();
                bVar.f(cloudDataBase);
                setBase(cloudDataBase);
            } else if (iO == 18) {
                setDetail(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
