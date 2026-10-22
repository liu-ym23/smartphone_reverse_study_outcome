package com.stepos.activeview.json;

import android.content.Context;
import com.stepos.activeview.utils.DisplayUnitUtil;

/* loaded from: classes.dex */
public class TextAttrs {
    private Integer background;
    private String ellipsize;
    private String fontFamily;
    private String fontStyle;
    private String gravity;
    private String letterSpacing;
    private String lineSpacingExtra;
    private Float mLetterSpacingValue;
    private Float mLineSpacingExtraValue;
    private Float mTextSizeValue;
    private Integer maxLength;
    private Integer maxLines;
    private Integer opacity;
    private Boolean singleLine;
    private String text;
    private Integer textColor;
    private String textSize;
    private String textStyle;
    private Boolean underline;

    public Integer getBackground() {
        return this.background;
    }

    public String getEllipsize() {
        return this.ellipsize;
    }

    public String getFontFamily() {
        return this.fontFamily;
    }

    public String getFontStyle() {
        return this.fontStyle;
    }

    public String getGravity() {
        return this.gravity;
    }

    public String getLetterSpacing() {
        return this.letterSpacing;
    }

    public Float getLetterSpacingValue(Context context) {
        String str = this.letterSpacing;
        if (str != null && !str.isEmpty()) {
            this.mLetterSpacingValue = Float.valueOf(DisplayUnitUtil.getPixelValue(context, this.letterSpacing));
        }
        return this.mLetterSpacingValue;
    }

    public String getLineSpacingExtra() {
        return this.lineSpacingExtra;
    }

    public Float getLineSpacingExtraValue(Context context) {
        String str = this.lineSpacingExtra;
        if (str != null && !str.isEmpty()) {
            this.mLineSpacingExtraValue = Float.valueOf(DisplayUnitUtil.getPixelValue(context, this.lineSpacingExtra));
        }
        return this.mLineSpacingExtraValue;
    }

    public Integer getMaxLength() {
        return this.maxLength;
    }

    public Integer getMaxLines() {
        return this.maxLines;
    }

    public Integer getOpacity() {
        return this.opacity;
    }

    public Boolean getSingleLine() {
        return this.singleLine;
    }

    public String getText() {
        return this.text;
    }

    public Integer getTextColor() {
        return this.textColor;
    }

    public String getTextSize() {
        return this.textSize;
    }

    public Float getTextSizeValue(Context context) {
        String str = this.textSize;
        if (str != null && !str.isEmpty()) {
            this.mTextSizeValue = Float.valueOf(DisplayUnitUtil.getPixelValue(context, this.textSize));
        }
        return this.mTextSizeValue;
    }

    public String getTextStyle() {
        return this.textStyle;
    }

    public Boolean getUnderline() {
        return this.underline;
    }

    public void setBackground(Integer num) {
        this.background = num;
    }

    public void setEllipsize(String str) {
        this.ellipsize = str;
    }

    public void setFontFamily(String str) {
        this.fontFamily = str;
    }

    public void setFontStyle(String str) {
        this.fontStyle = str;
    }

    public void setGravity(String str) {
        this.gravity = str;
    }

    public void setLetterSpacing(String str) {
        this.letterSpacing = str;
    }

    public void setLineSpacingExtra(String str) {
        this.lineSpacingExtra = str;
    }

    public void setMaxLength(Integer num) {
        this.maxLength = num;
    }

    public void setMaxLines(Integer num) {
        this.maxLines = num;
    }

    public void setOpacity(Integer num) {
        this.opacity = num;
    }

    public void setSingleLine(Boolean bool) {
        this.singleLine = bool;
    }

    public void setText(String str) {
        this.text = str;
    }

    public void setTextColor(Integer num) {
        this.textColor = num;
    }

    public void setTextSize(String str) {
        this.textSize = str;
    }

    public void setTextStyle(String str) {
        this.textStyle = str;
    }

    public void setUnderline(Boolean bool) {
        this.underline = bool;
    }
}
