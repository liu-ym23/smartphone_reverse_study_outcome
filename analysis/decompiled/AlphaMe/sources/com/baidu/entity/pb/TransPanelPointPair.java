package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransPanelPointPair extends f {
    public static final int AUXI_END_INDEX_FIELD_NUMBER = 4;
    public static final int AUXI_START_INDEX_FIELD_NUMBER = 3;
    public static final int CONTENT_FIELD_NUMBER = 8;
    public static final int MAIN_END_INDEX_FIELD_NUMBER = 2;
    public static final int MAIN_START_INDEX_FIELD_NUMBER = 1;
    public static final int MAIN_TRIGGER_DIST_FIELD_NUMBER = 6;
    public static final int POINT_TYPE_FIELD_NUMBER = 7;
    public static final int ROAD_INDEX_FIELD_NUMBER = 5;
    public static final int SUB_CONTENT_FIELD_NUMBER = 9;
    private int cachedSize;
    private a content_;
    private boolean hasAuxiEndIndex;
    private boolean hasAuxiStartIndex;
    private boolean hasContent;
    private boolean hasMainEndIndex;
    private boolean hasMainStartIndex;
    private boolean hasMainTriggerDist;
    private boolean hasPointType;
    private boolean hasRoadIndex;
    private boolean hasSubContent;
    private a subContent_;
    private int mainStartIndex_ = 0;
    private int mainEndIndex_ = 0;
    private int auxiStartIndex_ = 0;
    private int auxiEndIndex_ = 0;
    private int roadIndex_ = 0;
    private int mainTriggerDist_ = 0;
    private int pointType_ = 0;

    public TransPanelPointPair() {
        a aVar = a.f1216c;
        this.content_ = aVar;
        this.subContent_ = aVar;
        this.cachedSize = -1;
    }

    public static TransPanelPointPair parseFrom(b bVar) throws IOException {
        return new TransPanelPointPair().mergeFrom(bVar);
    }

    public final TransPanelPointPair clear() {
        clearMainStartIndex();
        clearMainEndIndex();
        clearAuxiStartIndex();
        clearAuxiEndIndex();
        clearRoadIndex();
        clearMainTriggerDist();
        clearPointType();
        clearContent();
        clearSubContent();
        this.cachedSize = -1;
        return this;
    }

    public TransPanelPointPair clearAuxiEndIndex() {
        this.hasAuxiEndIndex = false;
        this.auxiEndIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearAuxiStartIndex() {
        this.hasAuxiStartIndex = false;
        this.auxiStartIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearContent() {
        this.hasContent = false;
        this.content_ = a.f1216c;
        return this;
    }

    public TransPanelPointPair clearMainEndIndex() {
        this.hasMainEndIndex = false;
        this.mainEndIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearMainStartIndex() {
        this.hasMainStartIndex = false;
        this.mainStartIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearMainTriggerDist() {
        this.hasMainTriggerDist = false;
        this.mainTriggerDist_ = 0;
        return this;
    }

    public TransPanelPointPair clearPointType() {
        this.hasPointType = false;
        this.pointType_ = 0;
        return this;
    }

    public TransPanelPointPair clearRoadIndex() {
        this.hasRoadIndex = false;
        this.roadIndex_ = 0;
        return this;
    }

    public TransPanelPointPair clearSubContent() {
        this.hasSubContent = false;
        this.subContent_ = a.f1216c;
        return this;
    }

    public int getAuxiEndIndex() {
        return this.auxiEndIndex_;
    }

    public int getAuxiStartIndex() {
        return this.auxiStartIndex_;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getContent() {
        return this.content_;
    }

    public int getMainEndIndex() {
        return this.mainEndIndex_;
    }

    public int getMainStartIndex() {
        return this.mainStartIndex_;
    }

    public int getMainTriggerDist() {
        return this.mainTriggerDist_;
    }

    public int getPointType() {
        return this.pointType_;
    }

    public int getRoadIndex() {
        return this.roadIndex_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasMainStartIndex() ? d.e(1, getMainStartIndex()) : 0;
        if (hasMainEndIndex()) {
            iE += d.e(2, getMainEndIndex());
        }
        if (hasAuxiStartIndex()) {
            iE += d.e(3, getAuxiStartIndex());
        }
        if (hasAuxiEndIndex()) {
            iE += d.e(4, getAuxiEndIndex());
        }
        if (hasRoadIndex()) {
            iE += d.e(5, getRoadIndex());
        }
        if (hasMainTriggerDist()) {
            iE += d.e(6, getMainTriggerDist());
        }
        if (hasPointType()) {
            iE += d.e(7, getPointType());
        }
        if (hasContent()) {
            iE += d.b(8, getContent());
        }
        if (hasSubContent()) {
            iE += d.b(9, getSubContent());
        }
        this.cachedSize = iE;
        return iE;
    }

    public a getSubContent() {
        return this.subContent_;
    }

    public boolean hasAuxiEndIndex() {
        return this.hasAuxiEndIndex;
    }

    public boolean hasAuxiStartIndex() {
        return this.hasAuxiStartIndex;
    }

    public boolean hasContent() {
        return this.hasContent;
    }

    public boolean hasMainEndIndex() {
        return this.hasMainEndIndex;
    }

    public boolean hasMainStartIndex() {
        return this.hasMainStartIndex;
    }

    public boolean hasMainTriggerDist() {
        return this.hasMainTriggerDist;
    }

    public boolean hasPointType() {
        return this.hasPointType;
    }

    public boolean hasRoadIndex() {
        return this.hasRoadIndex;
    }

    public boolean hasSubContent() {
        return this.hasSubContent;
    }

    public final boolean isInitialized() {
        return true;
    }

    public TransPanelPointPair setAuxiEndIndex(int i4) {
        this.hasAuxiEndIndex = true;
        this.auxiEndIndex_ = i4;
        return this;
    }

    public TransPanelPointPair setAuxiStartIndex(int i4) {
        this.hasAuxiStartIndex = true;
        this.auxiStartIndex_ = i4;
        return this;
    }

    public TransPanelPointPair setContent(a aVar) {
        this.hasContent = true;
        this.content_ = aVar;
        return this;
    }

    public TransPanelPointPair setMainEndIndex(int i4) {
        this.hasMainEndIndex = true;
        this.mainEndIndex_ = i4;
        return this;
    }

    public TransPanelPointPair setMainStartIndex(int i4) {
        this.hasMainStartIndex = true;
        this.mainStartIndex_ = i4;
        return this;
    }

    public TransPanelPointPair setMainTriggerDist(int i4) {
        this.hasMainTriggerDist = true;
        this.mainTriggerDist_ = i4;
        return this;
    }

    public TransPanelPointPair setPointType(int i4) {
        this.hasPointType = true;
        this.pointType_ = i4;
        return this;
    }

    public TransPanelPointPair setRoadIndex(int i4) {
        this.hasRoadIndex = true;
        this.roadIndex_ = i4;
        return this;
    }

    public TransPanelPointPair setSubContent(a aVar) {
        this.hasSubContent = true;
        this.subContent_ = aVar;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasMainStartIndex()) {
            dVar.s(1, getMainStartIndex());
        }
        if (hasMainEndIndex()) {
            dVar.s(2, getMainEndIndex());
        }
        if (hasAuxiStartIndex()) {
            dVar.s(3, getAuxiStartIndex());
        }
        if (hasAuxiEndIndex()) {
            dVar.s(4, getAuxiEndIndex());
        }
        if (hasRoadIndex()) {
            dVar.s(5, getRoadIndex());
        }
        if (hasMainTriggerDist()) {
            dVar.s(6, getMainTriggerDist());
        }
        if (hasPointType()) {
            dVar.s(7, getPointType());
        }
        if (hasContent()) {
            dVar.q(8, getContent());
        }
        if (hasSubContent()) {
            dVar.q(9, getSubContent());
        }
    }

    public static TransPanelPointPair parseFrom(byte[] bArr) throws e {
        return (TransPanelPointPair) new TransPanelPointPair().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransPanelPointPair mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setMainStartIndex(bVar.k());
            } else if (iO == 16) {
                setMainEndIndex(bVar.k());
            } else if (iO == 24) {
                setAuxiStartIndex(bVar.k());
            } else if (iO == 32) {
                setAuxiEndIndex(bVar.k());
            } else if (iO == 40) {
                setRoadIndex(bVar.k());
            } else if (iO == 48) {
                setMainTriggerDist(bVar.k());
            } else if (iO == 56) {
                setPointType(bVar.k());
            } else if (iO == 66) {
                setContent(bVar.b());
            } else if (iO == 74) {
                setSubContent(bVar.b());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
