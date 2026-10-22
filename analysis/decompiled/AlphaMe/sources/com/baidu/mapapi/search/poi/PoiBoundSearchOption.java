package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.model.LatLngBounds;
import com.baidu.mapapi.search.base.InputLanguageType;
import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes.dex */
public class PoiBoundSearchOption {

    /* renamed from: a, reason: collision with root package name */
    private boolean f7388a;

    /* renamed from: b, reason: collision with root package name */
    private String f7389b;
    public LatLngBounds mBound = null;
    public boolean mIsExtendAdcode = true;
    public String mKeyword = null;
    public int mPageNum = 0;
    public int mPageCapacity = 10;
    public String mTag = "";
    public int mScope = 1;
    public PoiFilter mPoiFilter = null;
    public InputLanguageType mInputLanguageType = null;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    /* renamed from: c, reason: collision with root package name */
    private boolean f7390c = true;

    public PoiBoundSearchOption bound(LatLngBounds latLngBounds) {
        this.mBound = latLngBounds;
        return this;
    }

    public PoiBoundSearchOption customExtra(String str) {
        this.f7389b = str;
        return this;
    }

    public PoiBoundSearchOption extendAdcode(boolean z4) {
        this.mIsExtendAdcode = z4;
        return this;
    }

    public String getCustomExtra() {
        return this.f7389b;
    }

    public PoiBoundSearchOption inputLanguage(InputLanguageType inputLanguageType) {
        this.mInputLanguageType = inputLanguageType;
        return this;
    }

    public boolean isExtendAdcode() {
        return this.mIsExtendAdcode;
    }

    public boolean isExtendChildPoi() {
        return this.f7390c;
    }

    public boolean isShowPhoto() {
        return this.f7388a;
    }

    public PoiBoundSearchOption keyword(String str) {
        this.mKeyword = str;
        return this;
    }

    public PoiBoundSearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiBoundSearchOption pageCapacity(int i4) {
        this.mPageCapacity = i4;
        return this;
    }

    public PoiBoundSearchOption pageNum(int i4) {
        this.mPageNum = i4;
        return this;
    }

    public PoiBoundSearchOption poiFilter(PoiFilter poiFilter) {
        this.mPoiFilter = poiFilter;
        return this;
    }

    public PoiBoundSearchOption scope(int i4) {
        this.mScope = i4;
        return this;
    }

    public PoiBoundSearchOption setExtendChildPoi(boolean z4) {
        this.f7390c = z4;
        return this;
    }

    public PoiBoundSearchOption setShowPhoto(boolean z4) {
        this.f7388a = z4;
        return this;
    }

    public PoiBoundSearchOption tag(String str) {
        this.mTag = str;
        return this;
    }
}
