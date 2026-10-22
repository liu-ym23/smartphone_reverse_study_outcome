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
public final class TransRouteInfo extends f {
    public static final int LABELS_FIELD_NUMBER = 1;
    private List<TransRouteLabel> labels_ = Collections.emptyList();
    private int cachedSize = -1;

    public static TransRouteInfo parseFrom(b bVar) throws IOException {
        return new TransRouteInfo().mergeFrom(bVar);
    }

    public TransRouteInfo addLabels(TransRouteLabel transRouteLabel) {
        if (transRouteLabel == null) {
            return this;
        }
        if (this.labels_.isEmpty()) {
            this.labels_ = new ArrayList();
        }
        this.labels_.add(transRouteLabel);
        return this;
    }

    public final TransRouteInfo clear() {
        clearLabels();
        this.cachedSize = -1;
        return this;
    }

    public TransRouteInfo clearLabels() {
        this.labels_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public TransRouteLabel getLabels(int i4) {
        return this.labels_.get(i4);
    }

    public int getLabelsCount() {
        return this.labels_.size();
    }

    public List<TransRouteLabel> getLabelsList() {
        return this.labels_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        Iterator<TransRouteLabel> it = getLabelsList().iterator();
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

    public TransRouteInfo setLabels(int i4, TransRouteLabel transRouteLabel) {
        if (transRouteLabel == null) {
            return this;
        }
        this.labels_.set(i4, transRouteLabel);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        Iterator<TransRouteLabel> it = getLabelsList().iterator();
        while (it.hasNext()) {
            dVar.u(1, it.next());
        }
    }

    public static TransRouteInfo parseFrom(byte[] bArr) throws e {
        return (TransRouteInfo) new TransRouteInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransRouteInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                TransRouteLabel transRouteLabel = new TransRouteLabel();
                bVar.f(transRouteLabel);
                addLabels(transRouteLabel);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
