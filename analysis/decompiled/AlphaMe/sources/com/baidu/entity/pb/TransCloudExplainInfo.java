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
public final class TransCloudExplainInfo extends f {
    public static final int DYNAMIC_INFO_FIELD_NUMBER = 1;
    private List<TransDynamicInfo> dynamicInfo_ = Collections.emptyList();
    private int cachedSize = -1;

    public static TransCloudExplainInfo parseFrom(b bVar) throws IOException {
        return new TransCloudExplainInfo().mergeFrom(bVar);
    }

    public TransCloudExplainInfo addDynamicInfo(TransDynamicInfo transDynamicInfo) {
        if (transDynamicInfo == null) {
            return this;
        }
        if (this.dynamicInfo_.isEmpty()) {
            this.dynamicInfo_ = new ArrayList();
        }
        this.dynamicInfo_.add(transDynamicInfo);
        return this;
    }

    public final TransCloudExplainInfo clear() {
        clearDynamicInfo();
        this.cachedSize = -1;
        return this;
    }

    public TransCloudExplainInfo clearDynamicInfo() {
        this.dynamicInfo_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public TransDynamicInfo getDynamicInfo(int i4) {
        return this.dynamicInfo_.get(i4);
    }

    public int getDynamicInfoCount() {
        return this.dynamicInfo_.size();
    }

    public List<TransDynamicInfo> getDynamicInfoList() {
        return this.dynamicInfo_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        Iterator<TransDynamicInfo> it = getDynamicInfoList().iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH += d.h(1, it.next());
        }
        this.cachedSize = iH;
        return iH;
    }

    public final boolean isInitialized() {
        Iterator<TransDynamicInfo> it = getDynamicInfoList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public TransCloudExplainInfo setDynamicInfo(int i4, TransDynamicInfo transDynamicInfo) {
        if (transDynamicInfo == null) {
            return this;
        }
        this.dynamicInfo_.set(i4, transDynamicInfo);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        Iterator<TransDynamicInfo> it = getDynamicInfoList().iterator();
        while (it.hasNext()) {
            dVar.u(1, it.next());
        }
    }

    public static TransCloudExplainInfo parseFrom(byte[] bArr) throws e {
        return (TransCloudExplainInfo) new TransCloudExplainInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransCloudExplainInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                TransDynamicInfo transDynamicInfo = new TransDynamicInfo();
                bVar.f(transDynamicInfo);
                addDynamicInfo(transDynamicInfo);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
