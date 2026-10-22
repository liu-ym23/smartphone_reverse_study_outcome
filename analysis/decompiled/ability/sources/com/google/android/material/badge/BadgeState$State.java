package com.google.android.material.badge;

import L.g;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.XmlRes;
import java.util.Locale;

/* loaded from: classes3.dex */
public final class BadgeState$State implements Parcelable {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final Parcelable.Creator<BadgeState$State> CREATOR = new g(3);
    private static final int NOT_SET = -2;

    @Dimension(unit = 1)
    private Integer additionalHorizontalOffset;

    @Dimension(unit = 1)
    private Integer additionalVerticalOffset;
    private int alpha;
    private Boolean autoAdjustToWithinGrandparentBounds;

    @ColorInt
    private Integer backgroundColor;
    private Integer badgeFixedEdge;
    private Integer badgeGravity;

    @Px
    private Integer badgeHorizontalPadding;

    @XmlRes
    private int badgeResId;

    @StyleRes
    private Integer badgeShapeAppearanceOverlayResId;

    @StyleRes
    private Integer badgeShapeAppearanceResId;

    @StyleRes
    private Integer badgeTextAppearanceResId;

    @ColorInt
    private Integer badgeTextColor;

    @Px
    private Integer badgeVerticalPadding;

    @StyleRes
    private Integer badgeWithTextShapeAppearanceOverlayResId;

    @StyleRes
    private Integer badgeWithTextShapeAppearanceResId;

    @StringRes
    private int contentDescriptionExceedsMaxBadgeNumberRes;

    @Nullable
    private CharSequence contentDescriptionForText;

    @Nullable
    private CharSequence contentDescriptionNumberless;

    @PluralsRes
    private int contentDescriptionQuantityStrings;

    @Dimension(unit = 1)
    private Integer horizontalOffsetWithText;

    @Dimension(unit = 1)
    private Integer horizontalOffsetWithoutText;
    private Boolean isVisible;

    @Dimension(unit = 1)
    private Integer largeFontVerticalOffsetAdjustment;
    private int maxCharacterCount;
    private int maxNumber;
    private int number;
    private Locale numberLocale;

    @Nullable
    private String text;

    @Dimension(unit = 1)
    private Integer verticalOffsetWithText;

    @Dimension(unit = 1)
    private Integer verticalOffsetWithoutText;

    public BadgeState$State() {
        this.alpha = 255;
        this.number = -2;
        this.maxCharacterCount = -2;
        this.maxNumber = -2;
        this.isVisible = Boolean.TRUE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NonNull Parcel parcel, int i) {
        parcel.writeInt(this.badgeResId);
        parcel.writeSerializable(this.backgroundColor);
        parcel.writeSerializable(this.badgeTextColor);
        parcel.writeSerializable(this.badgeTextAppearanceResId);
        parcel.writeSerializable(this.badgeShapeAppearanceResId);
        parcel.writeSerializable(this.badgeShapeAppearanceOverlayResId);
        parcel.writeSerializable(this.badgeWithTextShapeAppearanceResId);
        parcel.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
        parcel.writeInt(this.alpha);
        parcel.writeString(this.text);
        parcel.writeInt(this.number);
        parcel.writeInt(this.maxCharacterCount);
        parcel.writeInt(this.maxNumber);
        CharSequence charSequence = this.contentDescriptionForText;
        parcel.writeString(charSequence != null ? charSequence.toString() : null);
        CharSequence charSequence2 = this.contentDescriptionNumberless;
        parcel.writeString(charSequence2 != null ? charSequence2.toString() : null);
        parcel.writeInt(this.contentDescriptionQuantityStrings);
        parcel.writeSerializable(this.badgeGravity);
        parcel.writeSerializable(this.badgeHorizontalPadding);
        parcel.writeSerializable(this.badgeVerticalPadding);
        parcel.writeSerializable(this.horizontalOffsetWithoutText);
        parcel.writeSerializable(this.verticalOffsetWithoutText);
        parcel.writeSerializable(this.horizontalOffsetWithText);
        parcel.writeSerializable(this.verticalOffsetWithText);
        parcel.writeSerializable(this.largeFontVerticalOffsetAdjustment);
        parcel.writeSerializable(this.additionalHorizontalOffset);
        parcel.writeSerializable(this.additionalVerticalOffset);
        parcel.writeSerializable(this.isVisible);
        parcel.writeSerializable(this.numberLocale);
        parcel.writeSerializable(this.autoAdjustToWithinGrandparentBounds);
        parcel.writeSerializable(this.badgeFixedEdge);
    }

    public BadgeState$State(@NonNull Parcel parcel) {
        this.alpha = 255;
        this.number = -2;
        this.maxCharacterCount = -2;
        this.maxNumber = -2;
        this.isVisible = Boolean.TRUE;
        this.badgeResId = parcel.readInt();
        this.backgroundColor = (Integer) parcel.readSerializable();
        this.badgeTextColor = (Integer) parcel.readSerializable();
        this.badgeTextAppearanceResId = (Integer) parcel.readSerializable();
        this.badgeShapeAppearanceResId = (Integer) parcel.readSerializable();
        this.badgeShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
        this.badgeWithTextShapeAppearanceResId = (Integer) parcel.readSerializable();
        this.badgeWithTextShapeAppearanceOverlayResId = (Integer) parcel.readSerializable();
        this.alpha = parcel.readInt();
        this.text = parcel.readString();
        this.number = parcel.readInt();
        this.maxCharacterCount = parcel.readInt();
        this.maxNumber = parcel.readInt();
        this.contentDescriptionForText = parcel.readString();
        this.contentDescriptionNumberless = parcel.readString();
        this.contentDescriptionQuantityStrings = parcel.readInt();
        this.badgeGravity = (Integer) parcel.readSerializable();
        this.badgeHorizontalPadding = (Integer) parcel.readSerializable();
        this.badgeVerticalPadding = (Integer) parcel.readSerializable();
        this.horizontalOffsetWithoutText = (Integer) parcel.readSerializable();
        this.verticalOffsetWithoutText = (Integer) parcel.readSerializable();
        this.horizontalOffsetWithText = (Integer) parcel.readSerializable();
        this.verticalOffsetWithText = (Integer) parcel.readSerializable();
        this.largeFontVerticalOffsetAdjustment = (Integer) parcel.readSerializable();
        this.additionalHorizontalOffset = (Integer) parcel.readSerializable();
        this.additionalVerticalOffset = (Integer) parcel.readSerializable();
        this.isVisible = (Boolean) parcel.readSerializable();
        this.numberLocale = (Locale) parcel.readSerializable();
        this.autoAdjustToWithinGrandparentBounds = (Boolean) parcel.readSerializable();
        this.badgeFixedEdge = (Integer) parcel.readSerializable();
    }
}
