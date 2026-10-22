package com.google.android.material.badge;

import W2.c;
import W2.d;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R$dimen;
import com.google.android.material.R$plurals;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.r;
import java.io.IOException;
import java.util.Locale;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes2.dex */
public final class BadgeState {

    /* renamed from: a, reason: collision with root package name */
    public final State f20289a;

    /* renamed from: b, reason: collision with root package name */
    public final State f20290b;

    /* renamed from: c, reason: collision with root package name */
    public final float f20291c;

    /* renamed from: d, reason: collision with root package name */
    public final float f20292d;

    /* renamed from: e, reason: collision with root package name */
    public final float f20293e;

    /* renamed from: f, reason: collision with root package name */
    public final float f20294f;

    /* renamed from: g, reason: collision with root package name */
    public final float f20295g;

    /* renamed from: h, reason: collision with root package name */
    public final float f20296h;

    /* renamed from: i, reason: collision with root package name */
    public final int f20297i;

    /* renamed from: j, reason: collision with root package name */
    public final int f20298j;

    /* renamed from: k, reason: collision with root package name */
    public int f20299k;

    /* renamed from: l, reason: collision with root package name */
    public int f20300l;

    public BadgeState(Context context, int i10, int i11, int i12, State state) throws XmlPullParserException, Resources.NotFoundException, IOException {
        State state2 = new State();
        this.f20290b = state2;
        state = state == null ? new State() : state;
        if (i10 != 0) {
            state.badgeResId = i10;
        }
        TypedArray typedArrayA = a(context, state.badgeResId, i11, i12);
        Resources resources = context.getResources();
        this.f20291c = typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeRadius, -1);
        this.f20297i = context.getResources().getDimensionPixelSize(R$dimen.mtrl_badge_horizontal_edge_offset);
        this.f20298j = context.getResources().getDimensionPixelSize(R$dimen.mtrl_badge_text_horizontal_edge_offset);
        this.f20292d = typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeWithTextRadius, -1);
        int i13 = R$styleable.Badge_badgeWidth;
        int i14 = R$dimen.m3_badge_size;
        this.f20293e = typedArrayA.getDimension(i13, resources.getDimension(i14));
        int i15 = R$styleable.Badge_badgeWithTextWidth;
        int i16 = R$dimen.m3_badge_with_text_size;
        this.f20295g = typedArrayA.getDimension(i15, resources.getDimension(i16));
        this.f20294f = typedArrayA.getDimension(R$styleable.Badge_badgeHeight, resources.getDimension(i14));
        this.f20296h = typedArrayA.getDimension(R$styleable.Badge_badgeWithTextHeight, resources.getDimension(i16));
        boolean z10 = true;
        this.f20299k = typedArrayA.getInt(R$styleable.Badge_offsetAlignmentMode, 1);
        this.f20300l = typedArrayA.getInt(R$styleable.Badge_badgeFixedEdge, 0);
        state2.alpha = state.alpha == -2 ? 255 : state.alpha;
        if (state.number != -2) {
            state2.number = state.number;
        } else {
            int i17 = R$styleable.Badge_number;
            if (typedArrayA.hasValue(i17)) {
                state2.number = typedArrayA.getInt(i17, 0);
            } else {
                state2.number = -1;
            }
        }
        if (state.text != null) {
            state2.text = state.text;
        } else {
            int i18 = R$styleable.Badge_badgeText;
            if (typedArrayA.hasValue(i18)) {
                state2.text = typedArrayA.getString(i18);
            }
        }
        state2.contentDescriptionForText = state.contentDescriptionForText;
        state2.contentDescriptionNumberless = state.contentDescriptionNumberless == null ? context.getString(R$string.mtrl_badge_numberless_content_description) : state.contentDescriptionNumberless;
        state2.contentDescriptionQuantityStrings = state.contentDescriptionQuantityStrings == 0 ? R$plurals.mtrl_badge_content_description : state.contentDescriptionQuantityStrings;
        state2.contentDescriptionExceedsMaxBadgeNumberRes = state.contentDescriptionExceedsMaxBadgeNumberRes == 0 ? R$string.mtrl_exceed_max_badge_number_content_description : state.contentDescriptionExceedsMaxBadgeNumberRes;
        if (state.isVisible != null && !state.isVisible.booleanValue()) {
            z10 = false;
        }
        state2.isVisible = Boolean.valueOf(z10);
        state2.maxCharacterCount = state.maxCharacterCount == -2 ? typedArrayA.getInt(R$styleable.Badge_maxCharacterCount, -2) : state.maxCharacterCount;
        state2.maxNumber = state.maxNumber == -2 ? typedArrayA.getInt(R$styleable.Badge_maxNumber, -2) : state.maxNumber;
        state2.badgeShapeAppearanceResId = Integer.valueOf(state.badgeShapeAppearanceResId == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeShapeAppearance, R$style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.badgeShapeAppearanceResId.intValue());
        state2.badgeShapeAppearanceOverlayResId = Integer.valueOf(state.badgeShapeAppearanceOverlayResId == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeShapeAppearanceOverlay, 0) : state.badgeShapeAppearanceOverlayResId.intValue());
        state2.badgeWithTextShapeAppearanceResId = Integer.valueOf(state.badgeWithTextShapeAppearanceResId == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeWithTextShapeAppearance, R$style.ShapeAppearance_M3_Sys_Shape_Corner_Full) : state.badgeWithTextShapeAppearanceResId.intValue());
        state2.badgeWithTextShapeAppearanceOverlayResId = Integer.valueOf(state.badgeWithTextShapeAppearanceOverlayResId == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0) : state.badgeWithTextShapeAppearanceOverlayResId.intValue());
        state2.backgroundColor = Integer.valueOf(state.backgroundColor == null ? G(context, typedArrayA, R$styleable.Badge_backgroundColor) : state.backgroundColor.intValue());
        state2.badgeTextAppearanceResId = Integer.valueOf(state.badgeTextAppearanceResId == null ? typedArrayA.getResourceId(R$styleable.Badge_badgeTextAppearance, R$style.TextAppearance_MaterialComponents_Badge) : state.badgeTextAppearanceResId.intValue());
        if (state.badgeTextColor != null) {
            state2.badgeTextColor = state.badgeTextColor;
        } else {
            int i19 = R$styleable.Badge_badgeTextColor;
            if (typedArrayA.hasValue(i19)) {
                state2.badgeTextColor = Integer.valueOf(G(context, typedArrayA, i19));
            } else {
                state2.badgeTextColor = Integer.valueOf(new d(context, state2.badgeTextAppearanceResId.intValue()).j().getDefaultColor());
            }
        }
        state2.badgeGravity = Integer.valueOf(state.badgeGravity == null ? typedArrayA.getInt(R$styleable.Badge_badgeGravity, 8388661) : state.badgeGravity.intValue());
        state2.badgeHorizontalPadding = Integer.valueOf(state.badgeHorizontalPadding == null ? typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeWidePadding, resources.getDimensionPixelSize(R$dimen.mtrl_badge_long_text_horizontal_padding)) : state.badgeHorizontalPadding.intValue());
        state2.badgeVerticalPadding = Integer.valueOf(state.badgeVerticalPadding == null ? typedArrayA.getDimensionPixelSize(R$styleable.Badge_badgeVerticalPadding, resources.getDimensionPixelSize(R$dimen.m3_badge_with_text_vertical_padding)) : state.badgeVerticalPadding.intValue());
        state2.horizontalOffsetWithoutText = Integer.valueOf(state.horizontalOffsetWithoutText == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0) : state.horizontalOffsetWithoutText.intValue());
        state2.verticalOffsetWithoutText = Integer.valueOf(state.verticalOffsetWithoutText == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0) : state.verticalOffsetWithoutText.intValue());
        state2.horizontalOffsetWithText = Integer.valueOf(state.horizontalOffsetWithText == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_horizontalOffsetWithText, state2.horizontalOffsetWithoutText.intValue()) : state.horizontalOffsetWithText.intValue());
        state2.verticalOffsetWithText = Integer.valueOf(state.verticalOffsetWithText == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_verticalOffsetWithText, state2.verticalOffsetWithoutText.intValue()) : state.verticalOffsetWithText.intValue());
        state2.largeFontVerticalOffsetAdjustment = Integer.valueOf(state.largeFontVerticalOffsetAdjustment == null ? typedArrayA.getDimensionPixelOffset(R$styleable.Badge_largeFontVerticalOffsetAdjustment, 0) : state.largeFontVerticalOffsetAdjustment.intValue());
        state2.additionalHorizontalOffset = Integer.valueOf(state.additionalHorizontalOffset == null ? 0 : state.additionalHorizontalOffset.intValue());
        state2.additionalVerticalOffset = Integer.valueOf(state.additionalVerticalOffset == null ? 0 : state.additionalVerticalOffset.intValue());
        state2.autoAdjustToWithinGrandparentBounds = Boolean.valueOf(state.autoAdjustToWithinGrandparentBounds == null ? typedArrayA.getBoolean(R$styleable.Badge_autoAdjustToWithinGrandparentBounds, false) : state.autoAdjustToWithinGrandparentBounds.booleanValue());
        typedArrayA.recycle();
        if (state.numberLocale == null) {
            state2.numberLocale = Locale.getDefault(Locale.Category.FORMAT);
        } else {
            state2.numberLocale = state.numberLocale;
        }
        this.f20289a = state;
    }

    public static int G(Context context, TypedArray typedArray, int i10) {
        return c.a(context, typedArray, i10).getDefaultColor();
    }

    public int A() {
        return this.f20290b.verticalOffsetWithText.intValue();
    }

    public int B() {
        return this.f20290b.verticalOffsetWithoutText.intValue();
    }

    public boolean C() {
        return this.f20290b.number != -1;
    }

    public boolean D() {
        return this.f20290b.text != null;
    }

    @Deprecated
    public boolean E() {
        return this.f20290b.autoAdjustToWithinGrandparentBounds.booleanValue();
    }

    public boolean F() {
        return this.f20290b.isVisible.booleanValue();
    }

    public void H(int i10) {
        this.f20289a.alpha = i10;
        this.f20290b.alpha = i10;
    }

    public final TypedArray a(Context context, int i10, int i11, int i12) throws XmlPullParserException, Resources.NotFoundException, IOException {
        AttributeSet attributeSetI;
        int styleAttribute;
        if (i10 != 0) {
            attributeSetI = O2.a.i(context, i10, "badge");
            styleAttribute = attributeSetI.getStyleAttribute();
        } else {
            attributeSetI = null;
            styleAttribute = 0;
        }
        return r.i(context, attributeSetI, R$styleable.Badge, i11, styleAttribute == 0 ? i12 : styleAttribute, new int[0]);
    }

    public int b() {
        return this.f20290b.additionalHorizontalOffset.intValue();
    }

    public int c() {
        return this.f20290b.additionalVerticalOffset.intValue();
    }

    public int d() {
        return this.f20290b.alpha;
    }

    public int e() {
        return this.f20290b.backgroundColor.intValue();
    }

    public int f() {
        return this.f20290b.badgeGravity.intValue();
    }

    public int g() {
        return this.f20290b.badgeHorizontalPadding.intValue();
    }

    public int h() {
        return this.f20290b.badgeShapeAppearanceOverlayResId.intValue();
    }

    public int i() {
        return this.f20290b.badgeShapeAppearanceResId.intValue();
    }

    public int j() {
        return this.f20290b.badgeTextColor.intValue();
    }

    public int k() {
        return this.f20290b.badgeVerticalPadding.intValue();
    }

    public int l() {
        return this.f20290b.badgeWithTextShapeAppearanceOverlayResId.intValue();
    }

    public int m() {
        return this.f20290b.badgeWithTextShapeAppearanceResId.intValue();
    }

    public int n() {
        return this.f20290b.contentDescriptionExceedsMaxBadgeNumberRes;
    }

    public CharSequence o() {
        return this.f20290b.contentDescriptionForText;
    }

    public CharSequence p() {
        return this.f20290b.contentDescriptionNumberless;
    }

    public int q() {
        return this.f20290b.contentDescriptionQuantityStrings;
    }

    public int r() {
        return this.f20290b.horizontalOffsetWithText.intValue();
    }

    public int s() {
        return this.f20290b.horizontalOffsetWithoutText.intValue();
    }

    public int t() {
        return this.f20290b.largeFontVerticalOffsetAdjustment.intValue();
    }

    public int u() {
        return this.f20290b.maxCharacterCount;
    }

    public int v() {
        return this.f20290b.maxNumber;
    }

    public int w() {
        return this.f20290b.number;
    }

    public Locale x() {
        return this.f20290b.numberLocale;
    }

    public String y() {
        return this.f20290b.text;
    }

    public int z() {
        return this.f20290b.badgeTextAppearanceResId.intValue();
    }

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = new a();
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

        public class a implements Parcelable.Creator<State> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public State createFromParcel(Parcel parcel) {
                return new State(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public State[] newArray(int i10) {
                return new State[i10];
            }
        }

        public State() {
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

        public State(Parcel parcel) {
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
}
