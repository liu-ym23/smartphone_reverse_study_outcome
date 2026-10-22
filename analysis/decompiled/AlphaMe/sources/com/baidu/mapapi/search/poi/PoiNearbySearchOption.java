package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes.dex */
public class PoiNearbySearchOption {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7421a;

    /* renamed from: b, reason: collision with root package name */
    private String f7422b;
    public String mKeyword = null;
    public LatLng mLocation = null;
    public int mRadius = -1;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public PoiSortType sortType = PoiSortType.comprehensive;
    public String mTag = "";
    public int mScope = 1;
    public boolean mRadiusLimit = false;
    public PoiFilter mPoiFilter = null;
    public boolean mIsExtendAdcode = true;
    public InputLanguageType mInputLanguageType = null;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7423c = true;

    public PoiNearbySearchOption customExtra(String str) {
        this.f7422b = str;
        return this;
    }

    public PoiNearbySearchOption extendAdcode(boolean z4) {
        this.mIsExtendAdcode = z4;
        return this;
    }

    public String getCustomExtra() {
        return this.f7422b;
    }

    public PoiNearbySearchOption inputLanguage(InputLanguageType inputLanguageType) {
        this.mInputLanguageType = inputLanguageType;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.mIsExtendAdcode;
    }

    public boolean isExtendChildPoi() {
        return this.f7423c;
    }

    public boolean isShowPhoto() {
        return this.f7421a;
    }

    public PoiNearbySearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiNearbySearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiNearbySearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }

    public PoiNearbySearchOption pageCapacity(int i4) {
        this.mPageCapacity = i4;
        return this;
    }

    public PoiNearbySearchOption pageNum(int i4) {
        this.mPageNum = i4;
        return this;
    }

    public PoiNearbySearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiNearbySearchOption radius(int i4) {
        this.mRadius = i4;
        return this;
    }

    public PoiNearbySearchOption radiusLimit(boolean z4) {
        this.mRadiusLimit = z4;
        return this;
    }

    public PoiNearbySearchOption scope(int i4) {
        this.mScope = i4;
        return this;
    }

    public PoiNearbySearchOption setExtendChildPoi(boolean z4) {
        this.f7423c = z4;
        return this;
    }

    public PoiNearbySearchOption setShowPhoto(boolean z4) {
        this.f7421a = z4;
        return this;
    }

    public PoiNearbySearchOption sortType(PoiSortType poiSortType) {
        if (poiSortType != null) {
            this.sortType = poiSortType;
        }
        return this;
    }

    public PoiNearbySearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
