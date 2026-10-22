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
public final class group_yellow_tips_t extends f {
    public static final int EVENT_IDS_FIELD_NUMBER = 5;
    public static final int ROUTE_TAG_OFF_FIELD_NUMBER = 4;
    public static final int TAG_FIELD_NUMBER = 1;
    public static final int TAG_INFO_FIELD_NUMBER = 2;
    public static final int YELLOW_TIPS_FIELD_NUMBER = 3;
    private int cachedSize;
    private List<Long> eventIds_;
    private boolean hasRouteTagOff;
    private boolean hasTag;
    private boolean hasTagInfo;
    private boolean routeTagOff_;
    private a tagInfo_;
    private a tag_;
    private List<yellow_tips_list_t> yellowTips_;

    public group_yellow_tips_t() {
        a aVar = a.f1216c;
        this.tag_ = aVar;
        this.tagInfo_ = aVar;
        this.yellowTips_ = Collections.emptyList();
        this.routeTagOff_ = false;
        this.eventIds_ = Collections.emptyList();
        this.cachedSize = -1;
    }

    public static group_yellow_tips_t parseFrom(b bVar) throws IOException {
        return new group_yellow_tips_t().mergeFrom(bVar);
    }

    public group_yellow_tips_t addEventIds(long j4) {
        if (this.eventIds_.isEmpty()) {
            this.eventIds_ = new ArrayList();
        }
        this.eventIds_.add(Long.valueOf(j4));
        return this;
    }

    public group_yellow_tips_t addYellowTips(yellow_tips_list_t yellow_tips_list_tVar) {
        if (yellow_tips_list_tVar == null) {
            return this;
        }
        if (this.yellowTips_.isEmpty()) {
            this.yellowTips_ = new ArrayList();
        }
        this.yellowTips_.add(yellow_tips_list_tVar);
        return this;
    }

    public final group_yellow_tips_t clear() {
        clearTag();
        clearTagInfo();
        clearYellowTips();
        clearRouteTagOff();
        clearEventIds();
        this.cachedSize = -1;
        return this;
    }

    public group_yellow_tips_t clearEventIds() {
        this.eventIds_ = Collections.emptyList();
        return this;
    }

    public group_yellow_tips_t clearRouteTagOff() {
        this.hasRouteTagOff = false;
        this.routeTagOff_ = false;
        return this;
    }

    public group_yellow_tips_t clearTag() {
        this.hasTag = false;
        this.tag_ = a.f1216c;
        return this;
    }

    public group_yellow_tips_t clearTagInfo() {
        this.hasTagInfo = false;
        this.tagInfo_ = a.f1216c;
        return this;
    }

    public group_yellow_tips_t clearYellowTips() {
        this.yellowTips_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public long getEventIds(int i4) {
        return this.eventIds_.get(i4).longValue();
    }

    public int getEventIdsCount() {
        return this.eventIds_.size();
    }

    public List<Long> getEventIdsList() {
        return this.eventIds_;
    }

    public boolean getRouteTagOff() {
        return this.routeTagOff_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iJ = 0;
        int iB = hasTag() ? d.b(1, getTag()) : 0;
        if (hasTagInfo()) {
            iB += d.b(2, getTagInfo());
        }
        Iterator<yellow_tips_list_t> it = getYellowTipsList().iterator();
        while (it.hasNext()) {
            iB += d.h(3, it.next());
        }
        if (hasRouteTagOff()) {
            getRouteTagOff();
            iB += d.a(4);
        }
        Iterator<Long> it2 = getEventIdsList().iterator();
        while (it2.hasNext()) {
            iJ += d.j(it2.next().longValue());
        }
        int size = getEventIdsList().size() + iB + iJ;
        this.cachedSize = size;
        return size;
    }

    public a getTag() {
        return this.tag_;
    }

    public a getTagInfo() {
        return this.tagInfo_;
    }

    public yellow_tips_list_t getYellowTips(int i4) {
        return this.yellowTips_.get(i4);
    }

    public int getYellowTipsCount() {
        return this.yellowTips_.size();
    }

    public List<yellow_tips_list_t> getYellowTipsList() {
        return this.yellowTips_;
    }

    public boolean hasRouteTagOff() {
        return this.hasRouteTagOff;
    }

    public boolean hasTag() {
        return this.hasTag;
    }

    public boolean hasTagInfo() {
        return this.hasTagInfo;
    }

    public final boolean isInitialized() {
        Iterator<yellow_tips_list_t> it = getYellowTipsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public group_yellow_tips_t setEventIds(int i4, long j4) {
        this.eventIds_.set(i4, Long.valueOf(j4));
        return this;
    }

    public group_yellow_tips_t setRouteTagOff(boolean z4) {
        this.hasRouteTagOff = true;
        this.routeTagOff_ = z4;
        return this;
    }

    public group_yellow_tips_t setTag(a aVar) {
        this.hasTag = true;
        this.tag_ = aVar;
        return this;
    }

    public group_yellow_tips_t setTagInfo(a aVar) {
        this.hasTagInfo = true;
        this.tagInfo_ = aVar;
        return this;
    }

    public group_yellow_tips_t setYellowTips(int i4, yellow_tips_list_t yellow_tips_list_tVar) {
        if (yellow_tips_list_tVar == null) {
            return this;
        }
        this.yellowTips_.set(i4, yellow_tips_list_tVar);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasTag()) {
            dVar.q(1, getTag());
        }
        if (hasTagInfo()) {
            dVar.q(2, getTagInfo());
        }
        Iterator<yellow_tips_list_t> it = getYellowTipsList().iterator();
        while (it.hasNext()) {
            dVar.u(3, it.next());
        }
        if (hasRouteTagOff()) {
            dVar.p(4, getRouteTagOff());
        }
        Iterator<Long> it2 = getEventIdsList().iterator();
        while (it2.hasNext()) {
            dVar.t(5, it2.next().longValue());
        }
    }

    public static group_yellow_tips_t parseFrom(byte[] bArr) throws e {
        return (group_yellow_tips_t) new group_yellow_tips_t().mergeFrom(bArr);
    }

    @Override // L1.f
    public group_yellow_tips_t mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 10) {
                setTag(bVar.b());
            } else if (iO == 18) {
                setTagInfo(bVar.b());
            } else if (iO == 26) {
                yellow_tips_list_t yellow_tips_list_tVar = new yellow_tips_list_t();
                bVar.f(yellow_tips_list_tVar);
                addYellowTips(yellow_tips_list_tVar);
            } else if (iO == 32) {
                setRouteTagOff(bVar.a());
            } else if (iO == 40) {
                addEventIds(bVar.l());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
