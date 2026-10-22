package com.baidu.entity.pb;

import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class CloudDataBase extends f {
    public static final int DATA_ID_FIELD_NUMBER = 1;
    private boolean hasDataId;
    private long dataId_ = 0;
    private int cachedSize = -1;

    public static CloudDataBase parseFrom(b bVar) throws IOException {
        return new CloudDataBase().mergeFrom(bVar);
    }

    public final CloudDataBase clear() {
        clearDataId();
        this.cachedSize = -1;
        return this;
    }

    public CloudDataBase clearDataId() {
        this.hasDataId = false;
        this.dataId_ = 0L;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public long getDataId() {
        return this.dataId_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iJ;
        if (hasDataId()) {
            long dataId = getDataId();
            iJ = d.j(dataId) + d.n(1);
        } else {
            iJ = 0;
        }
        this.cachedSize = iJ;
        return iJ;
    }

    public boolean hasDataId() {
        return this.hasDataId;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CloudDataBase setDataId(long j4) {
        this.hasDataId = true;
        this.dataId_ = j4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasDataId()) {
            long dataId = getDataId();
            dVar.B(1, 0);
            dVar.y(dataId);
        }
    }

    public static CloudDataBase parseFrom(byte[] bArr) throws e {
        return (CloudDataBase) new CloudDataBase().mergeFrom(bArr);
    }

    @Override // L1.f
    public CloudDataBase mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setDataId(bVar.l());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
