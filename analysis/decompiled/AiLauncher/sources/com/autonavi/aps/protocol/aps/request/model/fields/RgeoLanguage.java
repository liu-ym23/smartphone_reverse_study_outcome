package com.autonavi.aps.protocol.aps.request.model.fields;

/* loaded from: classes.dex */
public enum RgeoLanguage {
    CHINESE("zh"),
    ENGLISH("en");


    /* renamed from: a, reason: collision with root package name */
    private String f18944a;

    RgeoLanguage(String str) {
        this.f18944a = str;
    }

    public static RgeoLanguage fromString(String str) {
        if (str == null) {
            return CHINESE;
        }
        String lowerCase = str.trim().toLowerCase();
        RgeoLanguage rgeoLanguage = ENGLISH;
        return rgeoLanguage.f18944a.equals(lowerCase) ? rgeoLanguage : CHINESE;
    }

    public String getStr() {
        return this.f18944a;
    }

    public void setStr(String str) {
        this.f18944a = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.f18944a;
    }
}
