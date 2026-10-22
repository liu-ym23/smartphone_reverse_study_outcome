package com.airbnb.lottie.model;

import android.graphics.Typeface;

/* JADX INFO: loaded from: classes.dex */
public class Font {
    private final float ascent;
    private final String family;
    private final String name;
    private final String style;
    private Typeface typeface;

    public Font(String r1, String r2, String r3, float r4) {
        this.family = r1;
        this.name = r2;
        this.style = r3;
        this.ascent = r4;
    }

    public String getFamily() {
        return this.family;
    }

    public String getName() {
        return this.name;
    }

    public String getStyle() {
        return this.style;
    }

    float getAscent() {
        return this.ascent;
    }

    public Typeface getTypeface() {
        return this.typeface;
    }

    public void setTypeface(Typeface r1) {
        this.typeface = r1;
    }
}
