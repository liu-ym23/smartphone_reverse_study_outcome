package com.baidu.entity.pb;

import B0.g;
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
public final class CurrentCity extends f {
    public static final int CODE_FIELD_NUMBER = 1;
    public static final int GEO_FIELD_NUMBER = 2;
    public static final int LEVEL_FIELD_NUMBER = 3;
    public static final int NAME_FIELD_NUMBER = 4;
    public static final int SGEO_FIELD_NUMBER = 8;
    public static final int SUP_LUKUANG_FIELD_NUMBER = 6;
    public static final int SUP_SUBWAY_FIELD_NUMBER = 5;
    public static final int UID_FIELD_NUMBER = 7;
    private boolean hasCode;
    private boolean hasGeo;
    private boolean hasLevel;
    private boolean hasName;
    private boolean hasSupLukuang;
    private boolean hasSupSubway;
    private boolean hasUid;
    private int code_ = 0;
    private String geo_ = "";
    private int level_ = 0;
    private String name_ = "";
    private boolean supSubway_ = false;
    private boolean supLukuang_ = false;
    private String uid_ = "";
    private List<Integer> sgeo_ = Collections.emptyList();
    private int cachedSize = -1;

    public static CurrentCity parseFrom(b bVar) throws IOException {
        return new CurrentCity().mergeFrom(bVar);
    }

    public CurrentCity addSgeo(int i4) {
        if (this.sgeo_.isEmpty()) {
            this.sgeo_ = new ArrayList();
        }
        this.sgeo_.add(Integer.valueOf(i4));
        return this;
    }

    public final CurrentCity clear() {
        clearCode();
        clearGeo();
        clearLevel();
        clearName();
        clearSupSubway();
        clearSupLukuang();
        clearUid();
        clearSgeo();
        this.cachedSize = -1;
        return this;
    }

    public CurrentCity clearCode() {
        this.hasCode = false;
        this.code_ = 0;
        return this;
    }

    public CurrentCity clearGeo() {
        this.hasGeo = false;
        this.geo_ = "";
        return this;
    }

    public CurrentCity clearLevel() {
        this.hasLevel = false;
        this.level_ = 0;
        return this;
    }

    public CurrentCity clearName() {
        this.hasName = false;
        this.name_ = "";
        return this;
    }

    public CurrentCity clearSgeo() {
        this.sgeo_ = Collections.emptyList();
        return this;
    }

    public CurrentCity clearSupLukuang() {
        this.hasSupLukuang = false;
        this.supLukuang_ = false;
        return this;
    }

    public CurrentCity clearSupSubway() {
        this.hasSupSubway = false;
        this.supSubway_ = false;
        return this;
    }

    public CurrentCity clearUid() {
        this.hasUid = false;
        this.uid_ = "";
        return this;
    }

    @Override // L1.f
    public int getCachedSize() {
        if (this.cachedSize < 0) {
            getSerializedSize();
        }
        return this.cachedSize;
    }

    public int getCode() {
        return this.code_;
    }

    public String getGeo() {
        return this.geo_;
    }

    public int getLevel() {
        return this.level_;
    }

    public String getName() {
        return this.name_;
    }

    @Override // L1.f
    public int getSerializedSize() {
        int iG = 0;
        int iE = hasCode() ? d.e(1, getCode()) : 0;
        if (hasGeo()) {
            iE += d.l(2, getGeo());
        }
        if (hasLevel()) {
            iE += d.e(3, getLevel());
        }
        if (hasName()) {
            iE += d.l(4, getName());
        }
        if (hasSupSubway()) {
            getSupSubway();
            iE += d.a(5);
        }
        if (hasSupLukuang()) {
            getSupLukuang();
            iE += d.a(6);
        }
        if (hasUid()) {
            iE += d.l(7, getUid());
        }
        Iterator<Integer> it = getSgeoList().iterator();
        while (it.hasNext()) {
            iG = g.g(it.next(), iG);
        }
        int size = getSgeoList().size() + iE + iG;
        this.cachedSize = size;
        return size;
    }

    public int getSgeo(int i4) {
        return this.sgeo_.get(i4).intValue();
    }

    public int getSgeoCount() {
        return this.sgeo_.size();
    }

    public List<Integer> getSgeoList() {
        return this.sgeo_;
    }

    public boolean getSupLukuang() {
        return this.supLukuang_;
    }

    public boolean getSupSubway() {
        return this.supSubway_;
    }

    public String getUid() {
        return this.uid_;
    }

    public boolean hasCode() {
        return this.hasCode;
    }

    public boolean hasGeo() {
        return this.hasGeo;
    }

    public boolean hasLevel() {
        return this.hasLevel;
    }

    public boolean hasName() {
        return this.hasName;
    }

    public boolean hasSupLukuang() {
        return this.hasSupLukuang;
    }

    public boolean hasSupSubway() {
        return this.hasSupSubway;
    }

    public boolean hasUid() {
        return this.hasUid;
    }

    public final boolean isInitialized() {
        return true;
    }

    public CurrentCity setCode(int i4) {
        this.hasCode = true;
        this.code_ = i4;
        return this;
    }

    public CurrentCity setGeo(String str) {
        this.hasGeo = true;
        this.geo_ = str;
        return this;
    }

    public CurrentCity setLevel(int i4) {
        this.hasLevel = true;
        this.level_ = i4;
        return this;
    }

    public CurrentCity setName(String str) {
        this.hasName = true;
        this.name_ = str;
        return this;
    }

    public CurrentCity setSgeo(int i4, int i5) {
        this.sgeo_.set(i4, Integer.valueOf(i5));
        return this;
    }

    public CurrentCity setSupLukuang(boolean z4) {
        this.hasSupLukuang = true;
        this.supLukuang_ = z4;
        return this;
    }

    public CurrentCity setSupSubway(boolean z4) {
        this.hasSupSubway = true;
        this.supSubway_ = z4;
        return this;
    }

    public CurrentCity setUid(String str) {
        this.hasUid = true;
        this.uid_ = str;
        return this;
    }

    @Override // L1.f
    public void writeTo(d dVar) throws IOException {
        if (hasCode()) {
            dVar.s(1, getCode());
        }
        if (hasGeo()) {
            dVar.A(2, getGeo());
        }
        if (hasLevel()) {
            dVar.s(3, getLevel());
        }
        if (hasName()) {
            dVar.A(4, getName());
        }
        if (hasSupSubway()) {
            dVar.p(5, getSupSubway());
        }
        if (hasSupLukuang()) {
            dVar.p(6, getSupLukuang());
        }
        if (hasUid()) {
            dVar.A(7, getUid());
        }
        Iterator<Integer> it = getSgeoList().iterator();
        while (it.hasNext()) {
            dVar.z(8, it.next().intValue());
        }
    }

    public static CurrentCity parseFrom(byte[] bArr) throws e {
        return (CurrentCity) new CurrentCity().mergeFrom(bArr);
    }

    @Override // L1.f
    public CurrentCity mergeFrom(b bVar) throws IOException {
        while (true) {
            int iO = bVar.o();
            if (iO == 0) {
                return this;
            }
            if (iO == 8) {
                setCode(bVar.k());
            } else if (iO == 18) {
                setGeo(bVar.n());
            } else if (iO == 24) {
                setLevel(bVar.k());
            } else if (iO == 34) {
                setName(bVar.n());
            } else if (iO == 40) {
                setSupSubway(bVar.a());
            } else if (iO == 48) {
                setSupLukuang(bVar.a());
            } else if (iO == 58) {
                setUid(bVar.n());
            } else if (iO == 64) {
                addSgeo(bVar.m());
            } else if (!parseUnknownField(bVar, iO)) {
                return this;
            }
        }
    }
}
