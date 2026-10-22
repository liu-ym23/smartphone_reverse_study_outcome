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
public final class cloud_yellow_tips_t extends f {
    public static final int CLOUD_YELLOW_TIPS_FIELD_NUMBER = 1;
    private List<yellow_tips_t> cloudYellowTips_ = Collections.emptyList();
    private int cachedSize = -1;

    public static cloud_yellow_tips_t parseFrom(b bVar) throws IOException {
        return new cloud_yellow_tips_t().mergeFrom(bVar);
    }

    public cloud_yellow_tips_t addCloudYellowTips(yellow_tips_t yellow_tips_tVar) {
        if (yellow_tips_tVar == null) {
            return this;
        }
        if (this.cloudYellowTips_.isEmpty()) {
            this.cloudYellowTips_ = new ArrayList();
        }
        this.cloudYellowTips_.add(yellow_tips_tVar);
        return this;
    }

    public final cloud_yellow_tips_t clear() {
        clearCloudYellowTips();
        this.cachedSize = -1;
        return this;
    }

    public cloud_yellow_tips_t clearCloudYellowTips() {
        this.cloudYellowTips_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public yellow_tips_t getCloudYellowTips(int i4) {
        return this.cloudYellowTips_.get(i4);
    }

    public int getCloudYellowTipsCount() {
        return this.cloudYellowTips_.size();
    }

    public List<yellow_tips_t> getCloudYellowTipsList() {
        return this.cloudYellowTips_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        Iterator<yellow_tips_t> it = getCloudYellowTipsList().iterator();
        int iH = 0;
        while (it.hasNext()) {
            iH += d.h(1, it.next());
        }
        this.cachedSize = iH;
        return iH;
    }

    public final boolean isInitialized() {
        Iterator<yellow_tips_t> it = getCloudYellowTipsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public cloud_yellow_tips_t setCloudYellowTips(int i4, yellow_tips_t yellow_tips_tVar) {
        if (yellow_tips_tVar == null) {
            return this;
        }
        this.cloudYellowTips_.set(i4, yellow_tips_tVar);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        Iterator<yellow_tips_t> it = getCloudYellowTipsList().iterator();
        while (it.hasNext()) {
            dVar.u(1, it.next());
        }
    }

    public static cloud_yellow_tips_t parseFrom(byte[] bArr) throws e {
        return (cloud_yellow_tips_t) new cloud_yellow_tips_t().mergeFrom(bArr);
    }

    @Override // L1.f
    public cloud_yellow_tips_t mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                yellow_tips_t yellow_tips_tVar = new yellow_tips_t();
                bVar.f(yellow_tips_tVar);
                addCloudYellowTips(yellow_tips_tVar);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
