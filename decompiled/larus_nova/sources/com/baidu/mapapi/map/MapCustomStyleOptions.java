package com.baidu.mapapi.map;

/* JADX INFO: loaded from: classes39.dex */
public class MapCustomStyleOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f31018a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f31019b;

    public MapCustomStyleOptions() {
    }

    public String getCustomMapStyleId() {
        return this.f31019b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f31018a;
    }

    public MapCustomStyleOptions customStyleId(String r100) {
        this.f31019b = r100;
        return this;
    }

    public MapCustomStyleOptions localCustomStylePath(String r100) {
        this.f31018a = r100;
        return this;
    }
}
