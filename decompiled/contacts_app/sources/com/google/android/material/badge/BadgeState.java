package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class BadgeState {
    private static final String BADGE_RESOURCE_TAG = "badge";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;
    final float badgeHeight;
    final float badgeRadius;
    final float badgeWidePadding;
    final float badgeWidth;
    final float badgeWithTextHeight;
    final float badgeWithTextRadius;
    final float badgeWithTextWidth;
    private final State currentState;
    final int horizontalInset;
    final int horizontalInsetWithText;
    int offsetAlignmentMode;
    private final State overridingState;

    public static final class State implements Parcelable {
        private static final int BADGE_NUMBER_NONE = -1;
        public static final Parcelable.Creator<State> CREATOR = null;
        private static final int NOT_SET = -2;
        private Integer additionalHorizontalOffset;
        private Integer additionalVerticalOffset;
        private int alpha;
        private Integer backgroundColor;
        private Integer badgeGravity;
        private int badgeResId;
        private Integer badgeShapeAppearanceOverlayResId;
        private Integer badgeShapeAppearanceResId;
        private Integer badgeTextAppearanceResId;
        private Integer badgeTextColor;
        private Integer badgeWithTextShapeAppearanceOverlayResId;
        private Integer badgeWithTextShapeAppearanceResId;
        private int contentDescriptionExceedsMaxBadgeNumberRes;
        private CharSequence contentDescriptionNumberless;
        private int contentDescriptionQuantityStrings;
        private Integer horizontalOffsetWithText;
        private Integer horizontalOffsetWithoutText;
        private Boolean isVisible;
        private int maxCharacterCount;
        private int number;
        private Locale numberLocale;
        private Integer verticalOffsetWithText;
        private Integer verticalOffsetWithoutText;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        static /* synthetic */ int access$000(State r0) {
            return r0.badgeResId;
        }

        static /* synthetic */ int access$002(State r0, int r1) {
            r0.badgeResId = r1;
            return r1;
        }

        static /* synthetic */ int access$100(State r0) {
            return r0.alpha;
        }

        static /* synthetic */ Integer access$1000(State r0) {
            return r0.badgeWithTextShapeAppearanceResId;
        }

        static /* synthetic */ Integer access$1002(State r0, Integer r1) {
            r0.badgeWithTextShapeAppearanceResId = r1;
            return r1;
        }

        static /* synthetic */ int access$102(State r0, int r1) {
            r0.alpha = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1100(State r0) {
            return r0.badgeWithTextShapeAppearanceOverlayResId;
        }

        static /* synthetic */ Integer access$1102(State r0, Integer r1) {
            r0.badgeWithTextShapeAppearanceOverlayResId = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1200(State r0) {
            return r0.backgroundColor;
        }

        static /* synthetic */ Integer access$1202(State r0, Integer r1) {
            r0.backgroundColor = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1300(State r0) {
            return r0.badgeTextAppearanceResId;
        }

        static /* synthetic */ Integer access$1302(State r0, Integer r1) {
            r0.badgeTextAppearanceResId = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1400(State r0) {
            return r0.badgeTextColor;
        }

        static /* synthetic */ Integer access$1402(State r0, Integer r1) {
            r0.badgeTextColor = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1500(State r0) {
            return r0.badgeGravity;
        }

        static /* synthetic */ Integer access$1502(State r0, Integer r1) {
            r0.badgeGravity = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1600(State r0) {
            return r0.horizontalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1602(State r0, Integer r1) {
            r0.horizontalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1700(State r0) {
            return r0.verticalOffsetWithoutText;
        }

        static /* synthetic */ Integer access$1702(State r0, Integer r1) {
            r0.verticalOffsetWithoutText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1800(State r0) {
            return r0.horizontalOffsetWithText;
        }

        static /* synthetic */ Integer access$1802(State r0, Integer r1) {
            r0.horizontalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ Integer access$1900(State r0) {
            return r0.verticalOffsetWithText;
        }

        static /* synthetic */ Integer access$1902(State r0, Integer r1) {
            r0.verticalOffsetWithText = r1;
            return r1;
        }

        static /* synthetic */ CharSequence access$200(State r0) {
            return r0.contentDescriptionNumberless;
        }

        static /* synthetic */ Integer access$2000(State r0) {
            return r0.additionalHorizontalOffset;
        }

        static /* synthetic */ Integer access$2002(State r0, Integer r1) {
            r0.additionalHorizontalOffset = r1;
            return r1;
        }

        static /* synthetic */ CharSequence access$202(State r0, CharSequence r1) {
            r0.contentDescriptionNumberless = r1;
            return r1;
        }

        static /* synthetic */ Integer access$2100(State r0) {
            return r0.additionalVerticalOffset;
        }

        static /* synthetic */ Integer access$2102(State r0, Integer r1) {
            r0.additionalVerticalOffset = r1;
            return r1;
        }

        static /* synthetic */ Locale access$2200(State r0) {
            return r0.numberLocale;
        }

        static /* synthetic */ Locale access$2202(State r0, Locale r1) {
            r0.numberLocale = r1;
            return r1;
        }

        static /* synthetic */ int access$300(State r0) {
            return r0.contentDescriptionQuantityStrings;
        }

        static /* synthetic */ int access$302(State r0, int r1) {
            r0.contentDescriptionQuantityStrings = r1;
            return r1;
        }

        static /* synthetic */ int access$400(State r0) {
            return r0.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        static /* synthetic */ int access$402(State r0, int r1) {
            r0.contentDescriptionExceedsMaxBadgeNumberRes = r1;
            return r1;
        }

        static /* synthetic */ Boolean access$500(State r0) {
            return r0.isVisible;
        }

        static /* synthetic */ Boolean access$502(State r0, Boolean r1) {
            r0.isVisible = r1;
            return r1;
        }

        static /* synthetic */ int access$600(State r0) {
            return r0.maxCharacterCount;
        }

        static /* synthetic */ int access$602(State r0, int r1) {
            r0.maxCharacterCount = r1;
            return r1;
        }

        static /* synthetic */ int access$700(State r0) {
            return r0.number;
        }

        static /* synthetic */ int access$702(State r0, int r1) {
            r0.number = r1;
            return r1;
        }

        static /* synthetic */ Integer access$800(State r0) {
            return r0.badgeShapeAppearanceResId;
        }

        static /* synthetic */ Integer access$802(State r0, Integer r1) {
            r0.badgeShapeAppearanceResId = r1;
            return r1;
        }

        static /* synthetic */ Integer access$900(State r0) {
            return r0.badgeShapeAppearanceOverlayResId;
        }

        static /* synthetic */ Integer access$902(State r0, Integer r1) {
            r0.badgeShapeAppearanceOverlayResId = r1;
            return r1;
        }

        public State() {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = true;
        }

        State(Parcel r2) {
            this.alpha = 255;
            this.number = -2;
            this.maxCharacterCount = -2;
            this.isVisible = true;
            this.badgeResId = r2.readInt();
            this.backgroundColor = (Integer) r2.readSerializable();
            this.badgeTextColor = (Integer) r2.readSerializable();
            this.badgeTextAppearanceResId = (Integer) r2.readSerializable();
            this.badgeShapeAppearanceResId = (Integer) r2.readSerializable();
            this.badgeShapeAppearanceOverlayResId = (Integer) r2.readSerializable();
            this.badgeWithTextShapeAppearanceResId = (Integer) r2.readSerializable();
            this.badgeWithTextShapeAppearanceOverlayResId = (Integer) r2.readSerializable();
            this.alpha = r2.readInt();
            this.number = r2.readInt();
            this.maxCharacterCount = r2.readInt();
            this.contentDescriptionNumberless = r2.readString();
            this.contentDescriptionQuantityStrings = r2.readInt();
            this.badgeGravity = (Integer) r2.readSerializable();
            this.horizontalOffsetWithoutText = (Integer) r2.readSerializable();
            this.verticalOffsetWithoutText = (Integer) r2.readSerializable();
            this.horizontalOffsetWithText = (Integer) r2.readSerializable();
            this.verticalOffsetWithText = (Integer) r2.readSerializable();
            this.additionalHorizontalOffset = (Integer) r2.readSerializable();
            this.additionalVerticalOffset = (Integer) r2.readSerializable();
            this.isVisible = (Boolean) r2.readSerializable();
            this.numberLocale = (Locale) r2.readSerializable();
        }

        static {
            CREATOR = new AnonymousClass1();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel r1, int r2) {
            r1.writeInt(this.badgeResId);
            r1.writeSerializable(this.backgroundColor);
            r1.writeSerializable(this.badgeTextColor);
            r1.writeSerializable(this.badgeTextAppearanceResId);
            r1.writeSerializable(this.badgeShapeAppearanceResId);
            r1.writeSerializable(this.badgeShapeAppearanceOverlayResId);
            r1.writeSerializable(this.badgeWithTextShapeAppearanceResId);
            r1.writeSerializable(this.badgeWithTextShapeAppearanceOverlayResId);
            r1.writeInt(this.alpha);
            r1.writeInt(this.number);
            r1.writeInt(this.maxCharacterCount);
            CharSequence r3 = this.contentDescriptionNumberless;
            if (r3 != null) goto L5;
            String r4 = null;
        L6:
            r1.writeString(r4);
            r1.writeInt(this.contentDescriptionQuantityStrings);
            r1.writeSerializable(this.badgeGravity);
            r1.writeSerializable(this.horizontalOffsetWithoutText);
            r1.writeSerializable(this.verticalOffsetWithoutText);
            r1.writeSerializable(this.horizontalOffsetWithText);
            r1.writeSerializable(this.verticalOffsetWithText);
            r1.writeSerializable(this.additionalHorizontalOffset);
            r1.writeSerializable(this.additionalVerticalOffset);
            r1.writeSerializable(this.isVisible);
            r1.writeSerializable(this.numberLocale);
            return;
        L5:
            r4 = r3.toString();
            goto L6
        }
    }

    BadgeState(Context r5, int r6, int r7, int r8, State r9) {
        State r0 = new State();
        this.currentState = r0;
        if (r9 != null) goto L5;
        r9 = new State();
    L5:
        if (r6 == 0) goto L7;
        State.access$002(r9, r6);
    L7:
        TypedArray r10 = generateTypedArray(r5, State.access$000(r9), r7, r8);
        Resources r11 = r5.getResources();
        this.badgeRadius = r10.getDimensionPixelSize(R.styleable.Badge_badgeRadius, -1);
        this.badgeWidePadding = r10.getDimensionPixelSize(R.styleable.Badge_badgeWidePadding, r11.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding));
        this.horizontalInset = r5.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_horizontal_edge_offset);
        this.horizontalInsetWithText = r5.getResources().getDimensionPixelSize(R.dimen.mtrl_badge_text_horizontal_edge_offset);
        this.badgeWithTextRadius = r10.getDimensionPixelSize(R.styleable.Badge_badgeWithTextRadius, -1);
        this.badgeWidth = r10.getDimension(R.styleable.Badge_badgeWidth, r11.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextWidth = r10.getDimension(R.styleable.Badge_badgeWithTextWidth, r11.getDimension(R.dimen.m3_badge_with_text_size));
        this.badgeHeight = r10.getDimension(R.styleable.Badge_badgeHeight, r11.getDimension(R.dimen.m3_badge_size));
        this.badgeWithTextHeight = r10.getDimension(R.styleable.Badge_badgeWithTextHeight, r11.getDimension(R.dimen.m3_badge_with_text_size));
        boolean r12 = true;
        this.offsetAlignmentMode = r10.getInt(R.styleable.Badge_offsetAlignmentMode, 1);
        if (State.access$100(r9) != (-2)) goto L10;
        int r13 = 255;
    L11:
        State.access$102(r0, r13);
        if (State.access$200(r9) != null) goto L14;
        CharSequence r14 = r5.getString(R.string.mtrl_badge_numberless_content_description);
    L15:
        State.access$202(r0, r14);
        if (State.access$300(r9) != 0) goto L18;
        int r15 = R.plurals.mtrl_badge_content_description;
    L19:
        State.access$302(r0, r15);
        if (State.access$400(r9) != 0) goto L22;
        int r16 = R.string.mtrl_exceed_max_badge_number_content_description;
    L23:
        State.access$402(r0, r16);
        int r3 = 0;
        if (State.access$500(r9) != null) goto L26;
    L29:
        State.access$502(r0, Boolean.valueOf(r12));
        if (State.access$600(r9) != (-2)) goto L32;
        int r17 = r10.getInt(R.styleable.Badge_maxCharacterCount, 4);
    L33:
        State.access$602(r0, r17);
        if (State.access$700(r9) == (-2)) goto L37;
        State.access$702(r0, State.access$700(r9));
    L41:
        if (State.access$800(r9) != null) goto L43;
        int r18 = r10.getResourceId(R.styleable.Badge_badgeShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
    L44:
        State.access$802(r0, Integer.valueOf(r18));
        if (State.access$900(r9) != null) goto L47;
        int r19 = r10.getResourceId(R.styleable.Badge_badgeShapeAppearanceOverlay, 0);
    L48:
        State.access$902(r0, Integer.valueOf(r19));
        if (State.access$1000(r9) != null) goto L51;
        int r20 = r10.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearance, R.style.ShapeAppearance_M3_Sys_Shape_Corner_Full);
    L52:
        State.access$1002(r0, Integer.valueOf(r20));
        if (State.access$1100(r9) != null) goto L55;
        int r21 = r10.getResourceId(R.styleable.Badge_badgeWithTextShapeAppearanceOverlay, 0);
    L56:
        State.access$1102(r0, Integer.valueOf(r21));
        if (State.access$1200(r9) != null) goto L59;
        int r22 = readColorFromAttributes(r5, r10, R.styleable.Badge_backgroundColor);
    L60:
        State.access$1202(r0, Integer.valueOf(r22));
        if (State.access$1300(r9) != null) goto L63;
        int r23 = r10.getResourceId(R.styleable.Badge_badgeTextAppearance, R.style.TextAppearance_MaterialComponents_Badge);
    L64:
        State.access$1302(r0, Integer.valueOf(r23));
        if (State.access$1400(r9) == null) goto L68;
        State.access$1402(r0, State.access$1400(r9));
    L72:
        if (State.access$1500(r9) != null) goto L74;
        int r24 = r10.getInt(R.styleable.Badge_badgeGravity, 8388661);
    L75:
        State.access$1502(r0, Integer.valueOf(r24));
        if (State.access$1600(r9) != null) goto L78;
        int r25 = r10.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0);
    L79:
        State.access$1602(r0, Integer.valueOf(r25));
        if (State.access$1700(r9) != null) goto L82;
        int r26 = r10.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0);
    L83:
        State.access$1702(r0, Integer.valueOf(r26));
        if (State.access$1800(r9) != null) goto L86;
        int r27 = r10.getDimensionPixelOffset(R.styleable.Badge_horizontalOffsetWithText, State.access$1600(r0).intValue());
    L87:
        State.access$1802(r0, Integer.valueOf(r27));
        if (State.access$1900(r9) != null) goto L90;
        int r28 = r10.getDimensionPixelOffset(R.styleable.Badge_verticalOffsetWithText, State.access$1700(r0).intValue());
    L91:
        State.access$1902(r0, Integer.valueOf(r28));
        if (State.access$2000(r9) != null) goto L94;
        int r29 = 0;
    L95:
        State.access$2002(r0, Integer.valueOf(r29));
        if (State.access$2100(r9) == null) goto L99;
        r3 = State.access$2100(r9).intValue();
    L99:
        State.access$2102(r0, Integer.valueOf(r3));
        r10.recycle();
        if (State.access$2200(r9) != null) goto L102;
        State.access$2202(r0, Locale.getDefault(Locale.Category.FORMAT));
    L103:
        this.overridingState = r9;
        return;
    L102:
        State.access$2202(r0, State.access$2200(r9));
        goto L103
    L94:
        r29 = State.access$2000(r9).intValue();
        goto L95
    L90:
        r28 = State.access$1900(r9).intValue();
        goto L91
    L86:
        r27 = State.access$1800(r9).intValue();
        goto L87
    L82:
        r26 = State.access$1700(r9).intValue();
        goto L83
    L78:
        r25 = State.access$1600(r9).intValue();
        goto L79
    L74:
        r24 = State.access$1500(r9).intValue();
        goto L75
    L68:
        if (r10.hasValue(R.styleable.Badge_badgeTextColor) == false) goto L70;
        State.access$1402(r0, Integer.valueOf(readColorFromAttributes(r5, r10, R.styleable.Badge_badgeTextColor)));
        goto L72
    L70:
        State.access$1402(r0, Integer.valueOf(new TextAppearance(r5, State.access$1300(r0).intValue()).getTextColor().getDefaultColor()));
        goto L72
    L63:
        r23 = State.access$1300(r9).intValue();
        goto L64
    L59:
        r22 = State.access$1200(r9).intValue();
        goto L60
    L55:
        r21 = State.access$1100(r9).intValue();
        goto L56
    L51:
        r20 = State.access$1000(r9).intValue();
        goto L52
    L47:
        r19 = State.access$900(r9).intValue();
        goto L48
    L43:
        r18 = State.access$800(r9).intValue();
        goto L44
    L37:
        if (r10.hasValue(R.styleable.Badge_number) == false) goto L39;
        State.access$702(r0, r10.getInt(R.styleable.Badge_number, 0));
        goto L41
    L39:
        State.access$702(r0, -1);
        goto L41
    L32:
        r17 = State.access$600(r9);
        goto L33
    L26:
        if (State.access$500(r9).booleanValue() == true) goto L29;
        r12 = false;
        goto L29
    L22:
        r16 = State.access$400(r9);
        goto L23
    L18:
        r15 = State.access$300(r9);
        goto L19
    L14:
        r14 = State.access$200(r9);
        goto L15
    L10:
        r13 = State.access$100(r9);
        goto L11
    }

    private TypedArray generateTypedArray(Context r7, int r8, int r9, int r10) {
        if (r8 == 0) goto L5;
        AttributeSet r11 = DrawableUtils.parseDrawableXml(r7, r8, BADGE_RESOURCE_TAG);
        int r0 = r11.getStyleAttribute();
    L6:
        AttributeSet r1 = r11;
        if (r0 != 0) goto L9;
        int r4 = r10;
    L11:
        return ThemeEnforcement.obtainStyledAttributes(r7, r1, R.styleable.Badge, r9, r4, new int[0]);
    L9:
        r4 = r0;
        goto L11
    L5:
        r11 = null;
        r0 = 0;
        goto L6
    }

    State getOverridingState() {
        return this.overridingState;
    }

    boolean isVisible() {
        return State.access$500(this.currentState).booleanValue();
    }

    void setVisible(boolean r3) {
        State.access$502(this.overridingState, Boolean.valueOf(r3));
        State.access$502(this.currentState, Boolean.valueOf(r3));
    }

    boolean hasNumber() {
        if (State.access$700(this.currentState) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    int getNumber() {
        return State.access$700(this.currentState);
    }

    void setNumber(int r2) {
        State.access$702(this.overridingState, r2);
        State.access$702(this.currentState, r2);
    }

    void clearNumber() {
        setNumber(-1);
    }

    int getAlpha() {
        return State.access$100(this.currentState);
    }

    void setAlpha(int r2) {
        State.access$102(this.overridingState, r2);
        State.access$102(this.currentState, r2);
    }

    int getMaxCharacterCount() {
        return State.access$600(this.currentState);
    }

    void setMaxCharacterCount(int r2) {
        State.access$602(this.overridingState, r2);
        State.access$602(this.currentState, r2);
    }

    int getBackgroundColor() {
        return State.access$1200(this.currentState).intValue();
    }

    void setBackgroundColor(int r3) {
        State.access$1202(this.overridingState, Integer.valueOf(r3));
        State.access$1202(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeTextColor() {
        return State.access$1400(this.currentState).intValue();
    }

    void setBadgeTextColor(int r3) {
        State.access$1402(this.overridingState, Integer.valueOf(r3));
        State.access$1402(this.currentState, Integer.valueOf(r3));
    }

    int getTextAppearanceResId() {
        return State.access$1300(this.currentState).intValue();
    }

    void setTextAppearanceResId(int r3) {
        State.access$1302(this.overridingState, Integer.valueOf(r3));
        State.access$1302(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeShapeAppearanceResId() {
        return State.access$800(this.currentState).intValue();
    }

    void setBadgeShapeAppearanceResId(int r3) {
        State.access$802(this.overridingState, Integer.valueOf(r3));
        State.access$802(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeShapeAppearanceOverlayResId() {
        return State.access$900(this.currentState).intValue();
    }

    void setBadgeShapeAppearanceOverlayResId(int r3) {
        State.access$902(this.overridingState, Integer.valueOf(r3));
        State.access$902(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeWithTextShapeAppearanceResId() {
        return State.access$1000(this.currentState).intValue();
    }

    void setBadgeWithTextShapeAppearanceResId(int r3) {
        State.access$1002(this.overridingState, Integer.valueOf(r3));
        State.access$1002(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeWithTextShapeAppearanceOverlayResId() {
        return State.access$1100(this.currentState).intValue();
    }

    void setBadgeWithTextShapeAppearanceOverlayResId(int r3) {
        State.access$1102(this.overridingState, Integer.valueOf(r3));
        State.access$1102(this.currentState, Integer.valueOf(r3));
    }

    int getBadgeGravity() {
        return State.access$1500(this.currentState).intValue();
    }

    void setBadgeGravity(int r3) {
        State.access$1502(this.overridingState, Integer.valueOf(r3));
        State.access$1502(this.currentState, Integer.valueOf(r3));
    }

    int getHorizontalOffsetWithoutText() {
        return State.access$1600(this.currentState).intValue();
    }

    void setHorizontalOffsetWithoutText(int r3) {
        State.access$1602(this.overridingState, Integer.valueOf(r3));
        State.access$1602(this.currentState, Integer.valueOf(r3));
    }

    int getVerticalOffsetWithoutText() {
        return State.access$1700(this.currentState).intValue();
    }

    void setVerticalOffsetWithoutText(int r3) {
        State.access$1702(this.overridingState, Integer.valueOf(r3));
        State.access$1702(this.currentState, Integer.valueOf(r3));
    }

    int getHorizontalOffsetWithText() {
        return State.access$1800(this.currentState).intValue();
    }

    void setHorizontalOffsetWithText(int r3) {
        State.access$1802(this.overridingState, Integer.valueOf(r3));
        State.access$1802(this.currentState, Integer.valueOf(r3));
    }

    int getVerticalOffsetWithText() {
        return State.access$1900(this.currentState).intValue();
    }

    void setVerticalOffsetWithText(int r3) {
        State.access$1902(this.overridingState, Integer.valueOf(r3));
        State.access$1902(this.currentState, Integer.valueOf(r3));
    }

    int getAdditionalHorizontalOffset() {
        return State.access$2000(this.currentState).intValue();
    }

    void setAdditionalHorizontalOffset(int r3) {
        State.access$2002(this.overridingState, Integer.valueOf(r3));
        State.access$2002(this.currentState, Integer.valueOf(r3));
    }

    int getAdditionalVerticalOffset() {
        return State.access$2100(this.currentState).intValue();
    }

    void setAdditionalVerticalOffset(int r3) {
        State.access$2102(this.overridingState, Integer.valueOf(r3));
        State.access$2102(this.currentState, Integer.valueOf(r3));
    }

    CharSequence getContentDescriptionNumberless() {
        return State.access$200(this.currentState);
    }

    void setContentDescriptionNumberless(CharSequence r2) {
        State.access$202(this.overridingState, r2);
        State.access$202(this.currentState, r2);
    }

    int getContentDescriptionQuantityStrings() {
        return State.access$300(this.currentState);
    }

    void setContentDescriptionQuantityStringsResource(int r2) {
        State.access$302(this.overridingState, r2);
        State.access$302(this.currentState, r2);
    }

    int getContentDescriptionExceedsMaxBadgeNumberStringResource() {
        return State.access$400(this.currentState);
    }

    void setContentDescriptionExceedsMaxBadgeNumberStringResource(int r2) {
        State.access$402(this.overridingState, r2);
        State.access$402(this.currentState, r2);
    }

    Locale getNumberLocale() {
        return State.access$2200(this.currentState);
    }

    void setNumberLocale(Locale r2) {
        State.access$2202(this.overridingState, r2);
        State.access$2202(this.currentState, r2);
    }

    private static int readColorFromAttributes(Context r0, TypedArray r1, int r2) {
        return MaterialResources.getColorStateList(r0, r1, r2).getDefaultColor();
    }
}
