package com.bef.effectsdk.text.data;

/* JADX INFO: loaded from: classes3.dex */
public class TextLayoutParam {
    public int backColor;
    public int bitmapType;
    public String familyName;
    public String fontPath;
    public float fontSize;
    public int fontStyle;
    public float letterSpacing;
    public int lineBreakMode;
    public float lineSpacingAdd;
    public float lineSpacingMult;
    public int lineWidth;
    public int maxLine;
    public int paintStyle;
    public int shadowColor;
    public float shadowDx;
    public float shadowDy;
    public float shadowRadius;
    public float strokeWidth;
    public int textAlign;
    public int textColor;

    public TextLayoutParam() {
        this.familyName = null;
        this.fontPath = null;
        this.fontStyle = 0;
        this.fontSize = 16.0f;
        this.textColor = 0;
        this.backColor = 0;
        this.paintStyle = 0;
        this.strokeWidth = 0.0f;
        this.shadowRadius = 0.0f;
        this.shadowDx = 0.0f;
        this.shadowDy = 0.0f;
        this.shadowColor = 0;
        this.lineWidth = 0;
        this.letterSpacing = 0.0f;
        this.lineSpacingMult = 1.0f;
        this.lineSpacingAdd = 0.0f;
        this.textAlign = 0;
        this.maxLine = 0;
        this.lineBreakMode = 0;
    }
}
