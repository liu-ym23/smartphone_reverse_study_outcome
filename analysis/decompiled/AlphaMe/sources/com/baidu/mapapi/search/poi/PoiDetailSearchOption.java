package com.baidu.mapapi.search.poi;

import com.baidu.mapapi.search.base.LanguageType;

/* loaded from: classes.dex */
public class PoiDetailSearchOption {

    /* renamed from: e, reason: collision with root package name */
    private boolean f7402e;

    /* renamed from: a, reason: collision with root package name */
    private String f7398a = "";

    /* renamed from: b, reason: collision with root package name */
    private boolean f7399b = true;

    /* renamed from: c, reason: collision with root package name */
    private String f7400c = "";

    /* renamed from: d, reason: collision with root package name */
    private boolean f7401d = false;
    public LanguageType mLanguageType = LanguageType.LanguageTypeChinese;

    public PoiDetailSearchOption extendAdcode(boolean z4) {
        this.f7399b = z4;
        return this;
    }

    public String getUid() {
        return this.f7398a;
    }

    public String getUids() {
        return this.f7400c;
    }

    public boolean isExtendAdcode() {
        return this.f7399b;
    }

    public boolean isSearchByUids() {
        return this.f7401d;
    }

    public boolean isShowPhoto() {
        return this.f7402e;
    }

    public PoiDetailSearchOption language(LanguageType languageType) {
        this.mLanguageType = languageType;
        return this;
    }

    public PoiDetailSearchOption poiUid(String str) {
        this.f7401d = false;
        this.f7398a = str;
        return this;
    }

    public PoiDetailSearchOption poiUids(String str) {
        this.f7401d = true;
        this.f7400c = str;
        return this;
    }

    public PoiDetailSearchOption setShowPhoto(boolean z4) {
        this.f7402e = z4;
        return this;
    }
}
