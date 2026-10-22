package com.baidu.entity.pb;

import L1.a;
import L1.b;
import L1.d;
import L1.e;
import L1.f;
import java.io.IOException;

/* loaded from: classes.dex */
public final class TransVoiceInfo extends f {
    public static final int CONTENT_BEG_FIELD_NUMBER = 5;
    public static final int CONTENT_END_FIELD_NUMBER = 6;
    public static final int DISTANCE_FIELD_NUMBER = 7;
    public static final int END_POINT_FIELD_NUMBER = 8;
    public static final int LINK_IDX_FIELD_NUMBER = 2;
    public static final int MIN_BROADCAST_DIST_FIELD_NUMBER = 4;
    public static final int OFFSET_FIELD_NUMBER = 1;
    public static final int POINT_FIELD_NUMBER = 3;
    private int cachedSize;
    private a contentBeg_;
    private a contentEnd_;
    private int distance_;
    private TransPanelPoint endPoint_;
    private boolean hasContentBeg;
    private boolean hasContentEnd;
    private boolean hasDistance;
    private boolean hasEndPoint;
    private boolean hasLinkIdx;
    private boolean hasMinBroadcastDist;
    private boolean hasOffset;
    private boolean hasPoint;
    private int offset_ = 0;
    private int linkIdx_ = 0;
    private TransPanelPoint point_ = null;
    private int minBroadcastDist_ = 0;

    public TransVoiceInfo() {
        a aVar = a.f1216c;
        this.contentBeg_ = aVar;
        this.contentEnd_ = aVar;
        this.distance_ = 0;
        this.endPoint_ = null;
        this.cachedSize = -1;
    }

    public static TransVoiceInfo parseFrom(b bVar) throws IOException {
        return new TransVoiceInfo().mergeFrom(bVar);
    }

    public final TransVoiceInfo clear() {
        clearOffset();
        clearLinkIdx();
        clearPoint();
        clearMinBroadcastDist();
        clearContentBeg();
        clearContentEnd();
        clearDistance();
        clearEndPoint();
        this.cachedSize = -1;
        return this;
    }

    public TransVoiceInfo clearContentBeg() {
        this.hasContentBeg = false;
        this.contentBeg_ = a.f1216c;
        return this;
    }

    public TransVoiceInfo clearContentEnd() {
        this.hasContentEnd = false;
        this.contentEnd_ = a.f1216c;
        return this;
    }

    public TransVoiceInfo clearDistance() {
        this.hasDistance = false;
        this.distance_ = 0;
        return this;
    }

    public TransVoiceInfo clearEndPoint() {
        this.hasEndPoint = false;
        this.endPoint_ = null;
        return this;
    }

    public TransVoiceInfo clearLinkIdx() {
        this.hasLinkIdx = false;
        this.linkIdx_ = 0;
        return this;
    }

    public TransVoiceInfo clearMinBroadcastDist() {
        this.hasMinBroadcastDist = false;
        this.minBroadcastDist_ = 0;
        return this;
    }

    public TransVoiceInfo clearOffset() {
        this.hasOffset = false;
        this.offset_ = 0;
        return this;
    }

    public TransVoiceInfo clearPoint() {
        this.hasPoint = false;
        this.point_ = null;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public a getContentBeg() {
        return this.contentBeg_;
    }

    public a getContentEnd() {
        return this.contentEnd_;
    }

    public int getDistance() {
        return this.distance_;
    }

    public TransPanelPoint getEndPoint() {
        return this.endPoint_;
    }

    public int getLinkIdx() {
        return this.linkIdx_;
    }

    public int getMinBroadcastDist() {
        return this.minBroadcastDist_;
    }

    public int getOffset() {
        return this.offset_;
    }

    public TransPanelPoint getPoint() {
        return this.point_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasOffset() ? d.e(1, getOffset()) : 0;
        if (hasLinkIdx()) {
            iE += d.e(2, getLinkIdx());
        }
        if (hasPoint()) {
            iE += d.h(3, getPoint());
        }
        if (hasMinBroadcastDist()) {
            iE += d.e(4, getMinBroadcastDist());
        }
        if (hasContentBeg()) {
            iE += d.b(5, getContentBeg());
        }
        if (hasContentEnd()) {
            iE += d.b(6, getContentEnd());
        }
        if (hasDistance()) {
            iE += d.e(7, getDistance());
        }
        if (hasEndPoint()) {
            iE += d.h(8, getEndPoint());
        }
        this.cachedSize = iE;
        return iE;
    }

    public boolean hasContentBeg() {
        return this.hasContentBeg;
    }

    public boolean hasContentEnd() {
        return this.hasContentEnd;
    }

    public boolean hasDistance() {
        return this.hasDistance;
    }

    public boolean hasEndPoint() {
        return this.hasEndPoint;
    }

    public boolean hasLinkIdx() {
        return this.hasLinkIdx;
    }

    public boolean hasMinBroadcastDist() {
        return this.hasMinBroadcastDist;
    }

    public boolean hasOffset() {
        return this.hasOffset;
    }

    public boolean hasPoint() {
        return this.hasPoint;
    }

    public final boolean isInitialized() {
        if (!hasPoint() || getPoint().isInitialized()) {
            return !hasEndPoint() || getEndPoint().isInitialized();
        }
        return false;
    }

    public TransVoiceInfo setContentBeg(a aVar) {
        this.hasContentBeg = true;
        this.contentBeg_ = aVar;
        return this;
    }

    public TransVoiceInfo setContentEnd(a aVar) {
        this.hasContentEnd = true;
        this.contentEnd_ = aVar;
        return this;
    }

    public TransVoiceInfo setDistance(int i4) {
        this.hasDistance = true;
        this.distance_ = i4;
        return this;
    }

    public TransVoiceInfo setEndPoint(TransPanelPoint transPanelPoint) {
        if (transPanelPoint == null) {
            return clearEndPoint();
        }
        this.hasEndPoint = true;
        this.endPoint_ = transPanelPoint;
        return this;
    }

    public TransVoiceInfo setLinkIdx(int i4) {
        this.hasLinkIdx = true;
        this.linkIdx_ = i4;
        return this;
    }

    public TransVoiceInfo setMinBroadcastDist(int i4) {
        this.hasMinBroadcastDist = true;
        this.minBroadcastDist_ = i4;
        return this;
    }

    public TransVoiceInfo setOffset(int i4) {
        this.hasOffset = true;
        this.offset_ = i4;
        return this;
    }

    public TransVoiceInfo setPoint(TransPanelPoint transPanelPoint) {
        if (transPanelPoint == null) {
            return clearPoint();
        }
        this.hasPoint = true;
        this.point_ = transPanelPoint;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasOffset()) {
            dVar.s(1, getOffset());
        }
        if (hasLinkIdx()) {
            dVar.s(2, getLinkIdx());
        }
        if (hasPoint()) {
            dVar.u(3, getPoint());
        }
        if (hasMinBroadcastDist()) {
            dVar.s(4, getMinBroadcastDist());
        }
        if (hasContentBeg()) {
            dVar.q(5, getContentBeg());
        }
        if (hasContentEnd()) {
            dVar.q(6, getContentEnd());
        }
        if (hasDistance()) {
            dVar.s(7, getDistance());
        }
        if (hasEndPoint()) {
            dVar.u(8, getEndPoint());
        }
    }

    public static TransVoiceInfo parseFrom(byte[] bArr) throws e {
        return (TransVoiceInfo) new TransVoiceInfo().mergeFrom(bArr);
    }

    @Override // L1.f
    public TransVoiceInfo mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setOffset(bVar.k());
            } else if (iO == 16) {
                setLinkIdx(bVar.k());
            } else if (iO == 26) {
                TransPanelPoint transPanelPoint = new TransPanelPoint();
                bVar.f(transPanelPoint);
                setPoint(transPanelPoint);
            } else if (iO == 32) {
                setMinBroadcastDist(bVar.k());
            } else if (iO == 42) {
                setContentBeg(bVar.b());
            } else if (iO == 50) {
                setContentEnd(bVar.b());
            } else if (iO == 56) {
                setDistance(bVar.k());
            } else if (iO == 66) {
                TransPanelPoint transPanelPoint2 = new TransPanelPoint();
                bVar.f(transPanelPoint2);
                setEndPoint(transPanelPoint2);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
