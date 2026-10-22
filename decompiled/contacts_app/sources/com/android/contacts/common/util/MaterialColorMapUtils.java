package com.android.contacts.common.util;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Trace;
import com.android.contacts.common.R;

/* JADX INFO: loaded from: classes.dex */
public class MaterialColorMapUtils {
    private final TypedArray sPrimaryColors;
    private final TypedArray sSecondaryColors;

    /* JADX INFO: renamed from: com.android.contacts.common.util.MaterialColorMapUtils$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    public static class MaterialPalette implements Parcelable {
        public static final Parcelable.Creator<MaterialPalette> CREATOR = null;
        public final int mPrimaryColor;
        public final int mSecondaryColor;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        /* synthetic */ MaterialPalette(Parcel r1, AnonymousClass1 r2) {
            this(r1);
        }

        public MaterialPalette(int r1, int r2) {
            this.mPrimaryColor = r1;
            this.mSecondaryColor = r2;
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (r5 != null) goto L9;
            return false;
        L9:
            if (getClass() == r5.getClass()) goto L11;
            return false;
        L11:
            MaterialPalette r6 = (MaterialPalette) r5;
            if (this.mPrimaryColor == r6.mPrimaryColor) goto L15;
            return false;
        L15:
            if (this.mSecondaryColor == r6.mSecondaryColor) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return ((this.mPrimaryColor + 31) * 31) + this.mSecondaryColor;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.mPrimaryColor);
            r1.writeInt(this.mSecondaryColor);
        }

        private MaterialPalette(Parcel r2) {
            this.mPrimaryColor = r2.readInt();
            this.mSecondaryColor = r2.readInt();
        }

        static {
            CREATOR = new AnonymousClass1();
        }
    }

    public MaterialColorMapUtils(Resources r2) {
        this.sPrimaryColors = r2.obtainTypedArray(R.array.letter_tile_colors);
        this.sSecondaryColors = r2.obtainTypedArray(R.array.letter_tile_colors_dark);
    }

    public MaterialPalette calculatePrimaryAndSecondaryColor(int r7) {
        Trace.beginSection("calculatePrimaryAndSecondaryColor");
        float r8 = hue(r7);
        float r0 = Float.MAX_VALUE;
        int r2 = 0;
        int r3 = 0;
    L4:
        if (r2 >= this.sPrimaryColors.length()) goto L9;
        float r4 = Math.abs(hue(this.sPrimaryColors.getColor(r2, 0)) - r8);
        if (r4 >= r0) goto L8;
        r3 = r2;
        r0 = r4;
    L8:
        r2 = r2 + 1;
        goto L4
    L9:
        Trace.endSection();
        return new MaterialPalette(this.sPrimaryColors.getColor(r3, 0), this.sSecondaryColors.getColor(r3, 0));
    }

    public static MaterialPalette getDefaultPrimaryAndSecondaryColors(Resources r2) {
        return new MaterialPalette(r2.getColor(R.color.quickcontact_default_photo_tint_color), r2.getColor(R.color.quickcontact_default_photo_tint_color_dark));
    }

    public static float hue(int r7) {
        int r0 = (r7 >> 16) & 255;
        int r1 = (r7 >> 8) & 255;
        int r8 = r7 & 255;
        int r2 = Math.max(r8, Math.max(r0, r1));
        int r3 = Math.min(r8, Math.min(r0, r1));
        if (r2 == r3) goto L17;
        float r4 = r2 - r3;
        float r5 = (r2 - r0) / r4;
        float r6 = (r2 - r1) / r4;
        float r9 = (r2 - r8) / r4;
        if (r0 != r2) goto L8;
        float r10 = r9 - r6;
    L11:
        float r11 = r10 / 6.0f;
        if (r11 >= 0.0f) goto L15;
        return r11 + 1.0f;
    L15:
        return r11;
    L8:
        if (r1 != r2) goto L10;
        r10 = (r5 + 2.0f) - r9;
        goto L11
    L10:
        r10 = (r6 + 4.0f) - r5;
        goto L11
    L17:
        return 0.0f;
    }
}
