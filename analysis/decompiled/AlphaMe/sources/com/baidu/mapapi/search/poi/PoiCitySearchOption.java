package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLng;
import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes.dex */
public class PoiCitySearchOption {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7391a;

    /* renamed from: b, reason: collision with root package name */
    private LatLng f7392b;

    /* renamed from: c, reason: collision with root package name */
    private int f7393c;

    /* renamed from: d, reason: collision with root package name */
    private LatLngBounds f7394d;

    /* renamed from: e, reason: collision with root package name */
    private LatLngBounds f7395e;

    /* renamed from: f, reason: collision with root package name */
    private String f7396f;
    public String mCity = null;
    public String mKeyword = null;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public boolean mIsReturnAddr = true;
    public String mTag = "";
    public int mScope = 1;
    public boolean mIsCityLimit = true;
    public PoiFilter mPoiFilter = null;
    public boolean mIsExtendAdcode = true;
    public InputLanguageType mInputLanguageType = null;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    /* renamed from: g, reason: collision with root package name */
    private boolean f7397g = true;

    public PoiCitySearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public PoiCitySearchOption cityLimit(boolean z4) {
        this.mIsCityLimit = z4;
        return this;
    }

    public PoiCitySearchOption customExtra(String str) {
        this.f7396f = str;
        return this;
    }

    public PoiCitySearchOption extendAdcode(boolean z4) {
        this.mIsExtendAdcode = z4;
        return this;
    }

    public LatLng getCenter() {
        return this.f7392b;
    }

    public String getCustomExtra() {
        return this.f7396f;
    }

    public int getFilterDistance() {
        return this.f7393c;
    }

    public LatLngBounds getSearchBound() {
        return this.f7395e;
    }

    public LatLngBounds getViewBound() {
        return this.f7394d;
    }

    public PoiCitySearchOption inputLanguage(InputLanguageType inputLanguageType) {
        this.mInputLanguageType = inputLanguageType;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.mIsExtendAdcode;
    }

    public boolean isExtendChildPoi() {
        return this.f7397g;
    }

    public PoiCitySearchOption isReturnAddr(boolean z4) {
        this.mIsReturnAddr = z4;
        return this;
    }

    public boolean isShowPhoto() {
        return this.f7391a;
    }

    public PoiCitySearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiCitySearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiCitySearchOption pageCapacity(int i4) {
        this.mPageCapacity = i4;
        return this;
    }

    public PoiCitySearchOption pageNum(int i4) {
        this.mPageNum = i4;
        return this;
    }

    public PoiCitySearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiCitySearchOption scope(int i4) {
        this.mScope = i4;
        return this;
    }

    public PoiCitySearchOption setCenter(LatLng latLng) {
        this.f7392b = latLng;
        return this;
    }

    public PoiCitySearchOption setExtendChildPoi(boolean z4) {
        this.f7397g = z4;
        return this;
    }

    public PoiCitySearchOption setFilterDistance(int i4) {
        this.f7393c = i4;
        return this;
    }

    public PoiCitySearchOption setSearchBound(LatLngBounds latLngBounds) {
        this.f7395e = latLngBounds;
        return this;
    }

    public PoiCitySearchOption setShowPhoto(boolean z4) {
        this.f7391a = z4;
        return this;
    }

    public PoiCitySearchOption setViewBound(LatLngBounds latLngBounds) {
        this.f7394d = latLngBounds;
        return this;
    }

    public PoiCitySearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
