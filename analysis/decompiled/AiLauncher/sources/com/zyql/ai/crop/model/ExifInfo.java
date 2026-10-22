package com.zyql.ai.crop.model;

/* loaded from: classes4.dex */
public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int i10, int i11, int i12) {
        this.mExifOrientation = i10;
        this.mExifDegrees = i11;
        this.mExifTranslation = i12;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ExifInfo exifInfo = (ExifInfo) obj;
            if (this.mExifOrientation == exifInfo.mExifOrientation && this.mExifDegrees == exifInfo.mExifDegrees && this.mExifTranslation == exifInfo.mExifTranslation) {
                return true;
            }
        }
        return false;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return (((this.mExifOrientation * 31) + this.mExifDegrees) * 31) + this.mExifTranslation;
    }

    public void setExifDegrees(int i10) {
        this.mExifDegrees = i10;
    }

    public void setExifOrientation(int i10) {
        this.mExifOrientation = i10;
    }

    public void setExifTranslation(int i10) {
        this.mExifTranslation = i10;
    }
}
