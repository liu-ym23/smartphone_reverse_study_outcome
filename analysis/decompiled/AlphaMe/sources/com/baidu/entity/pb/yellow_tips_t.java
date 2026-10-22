package com.baidu.entity.pb;

import L1.a;
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
public final class yellow_tips_t extends f {
    public static final int GROUP_TIPS_FIELD_NUMBER = 4;
    public static final int NAME_FIELD_NUMBER = 2;
    public static final int ROUTE_PREVIEW_OFF_FIELD_NUMBER = 3;
    public static final int TIPS_TYPE_FIELD_NUMBER = 1;
    private boolean hasName;
    private boolean hasRoutePreviewOff;
    private boolean hasTipsType;
    private int tipsType_ = 0;
    private a name_ = a.f1216c;
    private boolean routePreviewOff_ = false;
    private List<group_yellow_tips_t> groupTips_ = Collections.emptyList();
    private int cachedSize = -1;

    public static yellow_tips_t parseFrom(b bVar) throws IOException {
        return new yellow_tips_t().mergeFrom(bVar);
    }

    public yellow_tips_t addGroupTips(group_yellow_tips_t group_yellow_tips_tVar) {
        if (group_yellow_tips_tVar == null) {
            return this;
        }
        if (this.groupTips_.isEmpty()) {
            this.groupTips_ = new ArrayList();
        }
        this.groupTips_.add(group_yellow_tips_tVar);
        return this;
    }

    public final yellow_tips_t clear() {
        clearTipsType();
        clearName();
        clearRoutePreviewOff();
        clearGroupTips();
        this.cachedSize = -1;
        return this;
    }

    public yellow_tips_t clearGroupTips() {
        this.groupTips_ = Collections.emptyList();
        return this;
    }

    public yellow_tips_t clearName() {
        this.hasName = false;
        this.name_ = a.f1216c;
        return this;
    }

    public yellow_tips_t clearRoutePreviewOff() {
        this.hasRoutePreviewOff = false;
        this.routePreviewOff_ = false;
        return this;
    }

    public yellow_tips_t clearTipsType() {
        this.hasTipsType = false;
        this.tipsType_ = 0;
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public group_yellow_tips_t getGroupTips(int i4) {
        return this.groupTips_.get(i4);
    }

    public int getGroupTipsCount() {
        return this.groupTips_.size();
    }

    public List<group_yellow_tips_t> getGroupTipsList() {
        return this.groupTips_;
    }

    public a getName() {
        return this.name_;
    }

    public boolean getRoutePreviewOff() {
        return this.routePreviewOff_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iE = hasTipsType() ? d.e(1, getTipsType()) : 0;
        if (hasName()) {
            iE += d.b(2, getName());
        }
        if (hasRoutePreviewOff()) {
            getRoutePreviewOff();
            iE += d.a(3);
        }
        Iterator<group_yellow_tips_t> it = getGroupTipsList().iterator();
        while (it.hasNext()) {
            iE += d.h(4, it.next());
        }
        this.cachedSize = iE;
        return iE;
    }

    public int getTipsType() {
        return this.tipsType_;
    }

    public boolean hasName() {
        return this.hasName;
    }

    public boolean hasRoutePreviewOff() {
        return this.hasRoutePreviewOff;
    }

    public boolean hasTipsType() {
        return this.hasTipsType;
    }

    public final boolean isInitialized() {
        Iterator<group_yellow_tips_t> it = getGroupTipsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public yellow_tips_t setGroupTips(int i4, group_yellow_tips_t group_yellow_tips_tVar) {
        if (group_yellow_tips_tVar == null) {
            return this;
        }
        this.groupTips_.set(i4, group_yellow_tips_tVar);
        return this;
    }

    public yellow_tips_t setName(a aVar) {
        this.hasName = true;
        this.name_ = aVar;
        return this;
    }

    public yellow_tips_t setRoutePreviewOff(boolean z4) {
        this.hasRoutePreviewOff = true;
        this.routePreviewOff_ = z4;
        return this;
    }

    public yellow_tips_t setTipsType(int i4) {
        this.hasTipsType = true;
        this.tipsType_ = i4;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasTipsType()) {
            dVar.s(1, getTipsType());
        }
        if (hasName()) {
            dVar.q(2, getName());
        }
        if (hasRoutePreviewOff()) {
            dVar.p(3, getRoutePreviewOff());
        }
        Iterator<group_yellow_tips_t> it = getGroupTipsList().iterator();
        while (it.hasNext()) {
            dVar.u(4, it.next());
        }
    }

    public static yellow_tips_t parseFrom(byte[] bArr) throws e {
        return (yellow_tips_t) new yellow_tips_t().mergeFrom(bArr);
    }

    @Override // L1.f
    public yellow_tips_t mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setTipsType(bVar.k());
            } else if (iO == 18) {
                setName(bVar.b());
            } else if (iO == 24) {
                setRoutePreviewOff(bVar.a());
            } else if (iO == 34) {
                group_yellow_tips_t group_yellow_tips_tVar = new group_yellow_tips_t();
                bVar.f(group_yellow_tips_tVar);
                addGroupTips(group_yellow_tips_tVar);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
