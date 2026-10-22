package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransPreferInfo extends f {
    public static final int GOOD_AUXILARY_LABEL_FIELD_NUMBER = 1;
    public static final int NORMAL_AUXILARY_LABEL_FIELD_NUMBER = 2;
    private int cachedSize;
    private a goodAuxilaryLabel_;
    private boolean hasGoodAuxilaryLabel;
    private boolean hasNormalAuxilaryLabel;
    private a normalAuxilaryLabel_;

    public TransPreferInfo() {
        a aVar = a.f1216c;
        this.goodAuxilaryLabel_ = aVar;
        this.normalAuxilaryLabel_ = aVar;
        this.cachedSize = -1;
    }

    public static TransPreferInfo parseFrom(b bVar) throws IOException {
        return new TransPreferInfo().mergeFrom(bVar);
    }

    public final TransPreferInfo clear() {
        clearGoodAuxilaryLabel();
        clearNormalAuxilaryLabel();
        this.cachedSize = -1;
        return this;
    }

    public TransPreferInfo clearGoodAuxilaryLabel() {
        this.hasGoodAuxilaryLabel = false;
        this.goodAuxilaryLabel_ = a.f1216c;
        return this;
    }

    public TransPreferInfo clearNormalAuxilaryLabel() {
        this.hasNormalAuxilaryLabel = false;
        this.normalAuxilaryLabel_ = a.f1216c;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getGoodAuxilaryLabel() {
        return this.goodAuxilaryLabel_;
    }

    public a getNormalAuxilaryLabel() {
        return this.normalAuxilaryLabel_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iB = hasGoodAuxilaryLabel() ? d.b(1, getGoodAuxilaryLabel()) : 0;
        if (hasNormalAuxilaryLabel()) {
            iB += d.b(2, getNormalAuxilaryLabel());
        }
        this.cachedSize = iB;
        return iB;
    }

    public boolean hasGoodAuxilaryLabel() {
        return this.hasGoodAuxilaryLabel;
    }

    public boolean hasNormalAuxilaryLabel() {
        return this.hasNormalAuxilaryLabel;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TransPreferInfo setGoodAuxilaryLabel(a aVar) {
        this.hasGoodAuxilaryLabel = true;
        this.goodAuxilaryLabel_ = aVar;
        return this;
    }

    public TransPreferInfo setNormalAuxilaryLabel(a aVar) {
        this.hasNormalAuxilaryLabel = true;
        this.normalAuxilaryLabel_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasGoodAuxilaryLabel()) {
            dVar.q(1, getGoodAuxilaryLabel());
        }
        if (hasNormalAuxilaryLabel()) {
            dVar.q(2, getNormalAuxilaryLabel());
        }
    }

    public static TransPreferInfo parseFrom(byte[] bArr) throws e {
        return (TransPreferInfo) new TransPreferInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransPreferInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setGoodAuxilaryLabel(bVar.b());
            } else if (iO == 18) {
                setNormalAuxilaryLabel(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
