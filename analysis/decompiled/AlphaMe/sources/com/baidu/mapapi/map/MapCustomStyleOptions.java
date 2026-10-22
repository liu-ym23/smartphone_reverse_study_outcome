package com.baidu.mapapi.map;

/* loaded from: classes.dex */
public class MapCustomStyleOptions {

    /* renamed from: a, reason: collision with root package name */
    private String f6503a;

    /* renamed from: b, reason: collision with root package name */
    private String f6504b;

    public MapCustomStyleOptions customStyleId(String str) {
        this.f6504b = str;
        return this;
    }

    public String getCustomMapStyleId() {
        return this.f6504b;
    }

    public String getLocalCustomStyleFilePath() {
        return this.f6503a;
    }

    public MapCustomStyleOptions localCustomStylePath(String str) {
        this.f6503a = str;
        return this;
    }
}
