package com.baidu.location.pb;

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
public final class LinkAttrArray extends f {
    public static final int GEO_ENCODE_FLAG_FIELD_NUMBER = 1;
    public static final int LINK_ATTRS_FIELD_NUMBER = 2;
    private boolean hasGeoEncodeFlag;
    private int geoEncodeFlag_ = 0;
    private List<LinkAttrt> linkAttrs_ = Collections.emptyList();
    private int cachedSize = -1;

    public static LinkAttrArray parseFrom(b bVar) throws IOException {
        return new LinkAttrArray().mergeFrom(bVar);
    }

    public LinkAttrArray addLinkAttrs(LinkAttrt linkAttrt) {
        if (linkAttrt == null) {
            return this;
        }
        if (this.linkAttrs_.isEmpty()) {
            this.linkAttrs_ = new ArrayList();
        }
        this.linkAttrs_.add(linkAttrt);
        return this;
    }

    public final LinkAttrArray clear() {
        clearGeoEncodeFlag();
        clearLinkAttrs();
        this.cachedSize = -1;
        return this;
    }

    public LinkAttrArray clearGeoEncodeFlag() {
        this.hasGeoEncodeFlag = false;
        this.geoEncodeFlag_ = 0;
        return this;
    }

    public LinkAttrArray clearLinkAttrs() {
        this.linkAttrs_ = Collections.emptyList();
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getGeoEncodeFlag() {
        return this.geoEncodeFlag_;
    }

    public LinkAttrt getLinkAttrs(int i4) {
        return this.linkAttrs_.get(i4);
    }

    public int getLinkAttrsCount() {
        return this.linkAttrs_.size();
    }

    public List<LinkAttrt> getLinkAttrsList() {
        return this.linkAttrs_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iO = hasGeoEncodeFlag() ? d.o(1, getGeoEncodeFlag()) : 0;
        Iterator<LinkAttrt> it = getLinkAttrsList().iterator();
        while (it.hasNext()) {
            iO += d.h(2, it.next());
        }
        this.cachedSize = iO;
        return iO;
    }

    public boolean hasGeoEncodeFlag() {
        return this.hasGeoEncodeFlag;
    }

    public final boolean isInitialized() {
        Iterator<LinkAttrt> it = getLinkAttrsList().iterator();
        while (it.hasNext()) {
            if (!it.next().isInitialized()) {
                return false;
            }
        }
        return true;
    }

    public LinkAttrArray setGeoEncodeFlag(int i4) {
        this.hasGeoEncodeFlag = true;
        this.geoEncodeFlag_ = i4;
        return this;
    }

    public LinkAttrArray setLinkAttrs(int i4, LinkAttrt linkAttrt) {
        if (linkAttrt == null) {
            return this;
        }
        this.linkAttrs_.set(i4, linkAttrt);
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasGeoEncodeFlag()) {
            dVar.C(1, getGeoEncodeFlag());
        }
        Iterator<LinkAttrt> it = getLinkAttrsList().iterator();
        while (it.hasNext()) {
            dVar.u(2, it.next());
        }
    }

    public static LinkAttrArray parseFrom(byte[] bArr) throws e {
        return (LinkAttrArray) new LinkAttrArray().mergeFrom(bArr);
    }

    @Override // L1.f
    public LinkAttrArray mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setGeoEncodeFlag(bVar.k());
            } else if (iO == 18) {
                LinkAttrt linkAttrt = new LinkAttrt();
                bVar.f(linkAttrt);
                addLinkAttrs(linkAttrt);
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
