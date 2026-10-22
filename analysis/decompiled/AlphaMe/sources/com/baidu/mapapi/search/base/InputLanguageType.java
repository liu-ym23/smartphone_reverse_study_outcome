package com.baidu.mapapi.search.base;

/* loaded from: classes.dex */
public enum InputLanguageType {
    AUTO("auto"),
    ENGLISH("en"),
    CANTONESE("yue"),
    CLASSICAL_CHINESE("wyw"),
    JAPANESE("jp"),
    KOREAN("kor"),
    FRENCH("fra"),
    SPANISH("spa"),
    THAI("th"),
    ARABIC("ara"),
    RUSSIAN("ru"),
    PORTUGUESE("pt"),
    GERMAN("de"),
    ITALIAN("it"),
    Greek("el"),
    DUTCH("nl"),
    Polish("pl"),
    BULGARIAN("bul"),
    ESTONIAN("est"),
    DANISH("dan"),
    FINNISH("fin"),
    CZECH("cs"),
    ROMANIAN("rom"),
    SLOVENIAN("slo"),
    SWEDISH("swe"),
    HUNGARIAN("hu"),
    TRADITIONAL_CHINESE("cht"),
    VIETNAMESE("vie");

    private final String value;

    InputLanguageType(String str) {
        this.value = str;
    }

    public String getValue() {
        return this.value;
    }
}
