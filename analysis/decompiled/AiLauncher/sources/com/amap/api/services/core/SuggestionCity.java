package com.amap.api.services.core;

/* loaded from: classes.dex */
public class SuggestionCity {

    /* renamed from: a, reason: collision with root package name */
    private String f17393a;

    /* renamed from: b, reason: collision with root package name */
    private String f17394b;

    /* renamed from: c, reason: collision with root package name */
    private String f17395c;

    /* renamed from: d, reason: collision with root package name */
    private int f17396d;

    public SuggestionCity() {
    }

    public String getAdCode() {
        return this.f17395c;
    }

    public String getCityCode() {
        return this.f17394b;
    }

    public String getCityName() {
        return this.f17393a;
    }

    public int getSuggestionNum() {
        return this.f17396d;
    }

    public void setAdCode(String str) {
        this.f17395c = str;
    }

    public void setCityCode(String str) {
        this.f17394b = str;
    }

    public void setCityName(String str) {
        this.f17393a = str;
    }

    public void setSuggestionNum(int i10) {
        this.f17396d = i10;
    }

    public SuggestionCity(String str, String str2, String str3, int i10) {
        this.f17393a = str;
        this.f17394b = str2;
        this.f17395c = str3;
        this.f17396d = i10;
    }
}
