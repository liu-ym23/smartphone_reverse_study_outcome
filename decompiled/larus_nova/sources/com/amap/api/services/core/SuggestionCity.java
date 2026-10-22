package com.amap.api.services.core;

/* JADX INFO: loaded from: classes28.dex */
public class SuggestionCity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f28870a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f28871b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f28872c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f28873d;

    public SuggestionCity() {
    }

    public String getAdCode() {
        return this.f28872c;
    }

    public String getCityCode() {
        return this.f28871b;
    }

    public String getCityName() {
        return this.f28870a;
    }

    public int getSuggestionNum() {
        return this.f28873d;
    }

    public void setAdCode(String r100) {
        this.f28872c = r100;
    }

    public void setCityCode(String r100) {
        this.f28871b = r100;
    }

    public void setCityName(String r100) {
        this.f28870a = r100;
    }

    public void setSuggestionNum(int r100) {
        this.f28873d = r100;
    }

    public SuggestionCity(String r100, String r101, String r102, int r103) {
        this.f28870a = r100;
        this.f28871b = r101;
        this.f28872c = r102;
        this.f28873d = r103;
    }
}
