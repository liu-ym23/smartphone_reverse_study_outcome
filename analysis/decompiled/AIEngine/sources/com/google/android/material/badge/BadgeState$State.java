package com.google.android.material.badge;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class BadgeState$State implements Parcelable {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final Parcelable.Creator<BadgeState$State> CREATOR = new a();
    private static final int NOT_SET = -2;
    private Integer additionalHorizontalOffset;
    private Integer additionalVerticalOffset;
    private int alpha;
    private Boolean autoAdjustToWithinGrandparentBounds;
    private Integer backgroundColor;
    private Integer badgeFixedEdge;
    private Integer badgeGravity;
    private Integer badgeHorizontalPadding;
    private int badgeResId;
    private Integer badgeShapeAppearanceOverlayResId;
    private Integer badgeShapeAppearanceResId;
    private Integer badgeTextAppearanceResId;
    private Integer badgeTextColor;
    private Integer badgeVerticalPadding;
    private Integer badgeWithTextShapeAppearanceOverlayResId;
    private Integer badgeWithTextShapeAppearanceResId;
    private int contentDescriptionExceedsMaxBadgeNumberRes;
    private CharSequence contentDescriptionForText;
    private CharSequence contentDescriptionNumberless;
    private int contentDescriptionQuantityStrings;
    private Integer horizontalOffsetWithText;
    private Integer horizontalOffsetWithoutText;
    private Boolean isVisible;
    private Integer largeFontVerticalOffsetAdjustment;
    private int maxCharacterCount;
    private int maxNumber;
    private int number;
    private Locale numberLocale;
    private String text;
    private Integer verticalOffsetWithText;
    private Integer verticalOffsetWithoutText;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public class a implements Parcelable.Creator<BadgeState$State> {
        @Override // android.os.Parcelable.Creator
        public final BadgeState$State createFromParcel(Parcel parcel) {
            return new BadgeState$State(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final BadgeState$State[] newArray(int i10) {
            return new BadgeState$State[i10];
        }
    }

    public BadgeState$State() {
        this.alpha = 255;
        this.number = NOT_SET;
        this.maxCharacterCount = NOT_SET;
        this.maxNumber = NOT_SET;
        this.isVisible = Boolean.TRUE;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
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

    public BadgeState$State(Parcel parcel) {
        this.alpha = 255;
        this.number = NOT_SET;
        this.maxCharacterCount = NOT_SET;
        this.maxNumber = NOT_SET;
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
