package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.AttrRes;
import androidx.annotation.ColorInt;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.PluralsRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.annotation.StyleableRes;
import androidx.annotation.XmlRes;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.ttnet.org.chromium.net.PrivateKeyType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;

/* JADX INFO: loaded from: classes3.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    private static final int BADGE_NUMBER_NONE = -1;
    public static final int BOTTOM_END = 8388693;
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    private static final int DEFAULT_MAX_BADGE_CHARACTER_COUNT = 4;

    @StyleRes
    private static final int DEFAULT_STYLE = 0;

    @AttrRes
    private static final int DEFAULT_THEME_ATTR = 0;
    private static final int MAX_CIRCULAR_BADGE_NUMBER_COUNT = 9;
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;

    @Nullable
    private WeakReference<View> anchorViewRef;

    @NonNull
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final float badgeRadius;
    private final float badgeWidePadding;
    private final float badgeWithTextRadius;

    @NonNull
    private final WeakReference<Context> contextRef;
    private float cornerRadius;

    @Nullable
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;

    @NonNull
    private final SavedState savedState;

    @NonNull
    private final MaterialShapeDrawable shapeDrawable;

    @NonNull
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BadgeGravity {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public static final class SavedState implements Parcelable {
        public static final Parcelable.Creator<SavedState> CREATOR = null;

        @Dimension(unit = 1)
        private int additionalHorizontalOffset;

        @Dimension(unit = 1)
        private int additionalVerticalOffset;
        private int alpha;

        @ColorInt
        private int backgroundColor;
        private int badgeGravity;

        @ColorInt
        private int badgeTextColor;

        @StringRes
        private int contentDescriptionExceedsMaxBadgeNumberRes;

        @Nullable
        private CharSequence contentDescriptionNumberless;

        @PluralsRes
        private int contentDescriptionQuantityStrings;

        @Dimension(unit = 1)
        private int horizontalOffset;
        private boolean isVisible;
        private int maxCharacterCount;
        private int number;

        @Dimension(unit = 1)
        private int verticalOffset;

        static {
            CREATOR = new AnonymousClass1();
        }

        public SavedState(@NonNull Context r10) {
            this.alpha = PrivateKeyType.INVALID;
            this.number = -1;
            this.badgeTextColor = new TextAppearance(r10, R.style.TextAppearance_MaterialComponents_Badge).textColor.getDefaultColor();
            this.contentDescriptionNumberless = r10.getString(R.string.mtrl_badge_numberless_content_description);
            this.contentDescriptionQuantityStrings = R.plurals.mtrl_badge_content_description;
            this.contentDescriptionExceedsMaxBadgeNumberRes = R.string.mtrl_exceed_max_badge_number_content_description;
            this.isVisible = true;
        }

        public static /* synthetic */ boolean access$000(SavedState r10) {
            return r10.isVisible;
        }

        public static /* synthetic */ boolean access$002(SavedState r10, boolean r11) {
            r10.isVisible = r11;
            return r11;
        }

        public static /* synthetic */ int access$100(SavedState r10) {
            return r10.maxCharacterCount;
        }

        public static /* synthetic */ int access$1000(SavedState r10) {
            return r10.alpha;
        }

        public static /* synthetic */ int access$1002(SavedState r10, int r11) {
            r10.alpha = r11;
            return r11;
        }

        public static /* synthetic */ int access$102(SavedState r10, int r11) {
            r10.maxCharacterCount = r11;
            return r11;
        }

        public static /* synthetic */ CharSequence access$1100(SavedState r10) {
            return r10.contentDescriptionNumberless;
        }

        public static /* synthetic */ CharSequence access$1102(SavedState r10, CharSequence r11) {
            r10.contentDescriptionNumberless = r11;
            return r11;
        }

        public static /* synthetic */ int access$1200(SavedState r10) {
            return r10.contentDescriptionQuantityStrings;
        }

        public static /* synthetic */ int access$1202(SavedState r10, int r11) {
            r10.contentDescriptionQuantityStrings = r11;
            return r11;
        }

        public static /* synthetic */ int access$1300(SavedState r10) {
            return r10.contentDescriptionExceedsMaxBadgeNumberRes;
        }

        public static /* synthetic */ int access$1302(SavedState r10, int r11) {
            r10.contentDescriptionExceedsMaxBadgeNumberRes = r11;
            return r11;
        }

        public static /* synthetic */ int access$200(SavedState r10) {
            return r10.number;
        }

        public static /* synthetic */ int access$202(SavedState r10, int r11) {
            r10.number = r11;
            return r11;
        }

        public static /* synthetic */ int access$300(SavedState r10) {
            return r10.backgroundColor;
        }

        public static /* synthetic */ int access$302(SavedState r10, int r11) {
            r10.backgroundColor = r11;
            return r11;
        }

        public static /* synthetic */ int access$400(SavedState r10) {
            return r10.badgeTextColor;
        }

        public static /* synthetic */ int access$402(SavedState r10, int r11) {
            r10.badgeTextColor = r11;
            return r11;
        }

        public static /* synthetic */ int access$500(SavedState r10) {
            return r10.badgeGravity;
        }

        public static /* synthetic */ int access$502(SavedState r10, int r11) {
            r10.badgeGravity = r11;
            return r11;
        }

        public static /* synthetic */ int access$600(SavedState r10) {
            return r10.horizontalOffset;
        }

        public static /* synthetic */ int access$602(SavedState r10, int r11) {
            r10.horizontalOffset = r11;
            return r11;
        }

        public static /* synthetic */ int access$700(SavedState r10) {
            return r10.verticalOffset;
        }

        public static /* synthetic */ int access$702(SavedState r10, int r11) {
            r10.verticalOffset = r11;
            return r11;
        }

        public static /* synthetic */ int access$800(SavedState r10) {
            return r10.additionalHorizontalOffset;
        }

        public static /* synthetic */ int access$802(SavedState r10, int r11) {
            r10.additionalHorizontalOffset = r11;
            return r11;
        }

        public static /* synthetic */ int access$900(SavedState r10) {
            return r10.additionalVerticalOffset;
        }

        public static /* synthetic */ int access$902(SavedState r10, int r11) {
            r10.additionalVerticalOffset = r11;
            return r11;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(@NonNull Parcel r10, int r11) {
            r10.writeInt(this.backgroundColor);
            r10.writeInt(this.badgeTextColor);
            r10.writeInt(this.alpha);
            r10.writeInt(this.number);
            r10.writeInt(this.maxCharacterCount);
            r10.writeString(this.contentDescriptionNumberless.toString());
            r10.writeInt(this.contentDescriptionQuantityStrings);
            r10.writeInt(this.badgeGravity);
            r10.writeInt(this.horizontalOffset);
            r10.writeInt(this.verticalOffset);
            r10.writeInt(this.additionalHorizontalOffset);
            r10.writeInt(this.additionalVerticalOffset);
            r10.writeInt(this.isVisible ? 1 : 0);
        }

        public SavedState(@NonNull Parcel r10) {
            this.alpha = PrivateKeyType.INVALID;
            this.number = -1;
            this.backgroundColor = r10.readInt();
            this.badgeTextColor = r10.readInt();
            this.alpha = r10.readInt();
            this.number = r10.readInt();
            this.maxCharacterCount = r10.readInt();
            this.contentDescriptionNumberless = r10.readString();
            this.contentDescriptionQuantityStrings = r10.readInt();
            this.badgeGravity = r10.readInt();
            this.horizontalOffset = r10.readInt();
            this.verticalOffset = r10.readInt();
            this.additionalHorizontalOffset = r10.readInt();
            this.additionalVerticalOffset = r10.readInt();
            if (r10.readInt() == 0) goto L5;
            boolean r11 = true;
        L6:
            this.isVisible = r11;
            return;
        L5:
            r11 = false;
            goto L6
        }
    }

    static {
        DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
        DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    }

    private BadgeDrawable(@NonNull Context r10) {
        this.contextRef = new WeakReference(r10);
        ThemeEnforcement.checkMaterialTheme(r10);
        Resources r11 = r10.getResources();
        this.badgeBounds = new Rect();
        this.shapeDrawable = new MaterialShapeDrawable();
        this.badgeRadius = r11.getDimensionPixelSize(R.dimen.mtrl_badge_radius);
        this.badgeWidePadding = r11.getDimensionPixelSize(R.dimen.mtrl_badge_long_text_horizontal_padding);
        this.badgeWithTextRadius = r11.getDimensionPixelSize(R.dimen.mtrl_badge_with_text_radius);
        TextDrawableHelper r12 = new TextDrawableHelper(this);
        this.textDrawableHelper = r12;
        r12.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.savedState = new SavedState(r10);
        setTextAppearanceResource(R.style.TextAppearance_MaterialComponents_Badge);
    }

    private void calculateCenterAndBounds(@NonNull Context r10, @NonNull Rect r11, @NonNull View r12) {
        int r13 = SavedState.access$700(this.savedState) + SavedState.access$900(this.savedState);
        int r14 = SavedState.access$500(this.savedState);
        if (r14 != 8388691) goto L5;
    L7:
        this.badgeCenterY = r11.bottom - r13;
    L9:
        if (getNumber() <= 9) goto L11;
        float r15 = this.badgeWithTextRadius;
        this.cornerRadius = r15;
        this.halfBadgeHeight = r15;
        this.halfBadgeWidth = (this.textDrawableHelper.getTextWidth(getBadgeText()) / 2.0f) + this.badgeWidePadding;
    L16:
        Resources r16 = r10.getResources();
        if (hasNumber() == false) goto L19;
        int r17 = R.dimen.mtrl_badge_text_horizontal_edge_offset;
    L20:
        int r18 = r16.getDimensionPixelSize(r17);
        int r19 = SavedState.access$600(this.savedState) + SavedState.access$800(this.savedState);
        int r20 = SavedState.access$500(this.savedState);
        if (r20 == 8388659) goto L29;
        if (r20 == 8388691) goto L29;
        if (ViewCompat.A(r12) != 0) goto L26;
        float r21 = ((r11.right + this.halfBadgeWidth) - r18) - r19;
    L27:
        this.badgeCenterX = r21;
        return;
    L26:
        r21 = ((r11.left - this.halfBadgeWidth) + r18) + r19;
    L29:
        if (ViewCompat.A(r12) != 0) goto L31;
        float r22 = ((r11.left - this.halfBadgeWidth) + r18) + r19;
    L32:
        this.badgeCenterX = r22;
        return;
    L31:
        r22 = ((r11.right + this.halfBadgeWidth) - r18) - r19;
        goto L32
    L19:
        r17 = R.dimen.mtrl_badge_horizontal_edge_offset;
        goto L20
    L11:
        if (hasNumber() == true) goto L13;
        float r23 = this.badgeRadius;
    L14:
        this.cornerRadius = r23;
        this.halfBadgeHeight = r23;
        this.halfBadgeWidth = r23;
        goto L16
    L13:
        r23 = this.badgeWithTextRadius;
        goto L14
    L5:
        if (r14 == 8388693) goto L7;
        this.badgeCenterY = r11.top + r13;
        goto L9
    }

    @NonNull
    public static BadgeDrawable create(@NonNull Context r10) {
        return createFromAttributes(r10, null, DEFAULT_THEME_ATTR, DEFAULT_STYLE);
    }

    @NonNull
    private static BadgeDrawable createFromAttributes(@NonNull Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        BadgeDrawable r14 = new BadgeDrawable(r10);
        r14.loadDefaultStateFromAttributes(r10, r11, r12, r13);
        return r14;
    }

    @NonNull
    public static BadgeDrawable createFromResource(@NonNull Context r10, @XmlRes int r11) {
        AttributeSet r12 = DrawableUtils.parseDrawableXml(r10, r11, "badge");
        int r13 = r12.getStyleAttribute();
        if (r13 != 0) goto L6;
        r13 = DEFAULT_STYLE;
    L6:
        return createFromAttributes(r10, r12, DEFAULT_THEME_ATTR, r13);
    }

    @NonNull
    public static BadgeDrawable createFromSavedState(@NonNull Context r10, @NonNull SavedState r11) {
        BadgeDrawable r12 = new BadgeDrawable(r10);
        r12.restoreFromSavedState(r11);
        return r12;
    }

    private void drawText(Canvas r10) {
        Rect r11 = new Rect();
        String r12 = getBadgeText();
        this.textDrawableHelper.getTextPaint().getTextBounds(r12, 0, r12.length(), r11);
        r10.drawText(r12, this.badgeCenterX, this.badgeCenterY + (r11.height() / 2), this.textDrawableHelper.getTextPaint());
    }

    @NonNull
    private String getBadgeText() {
        if (getNumber() <= this.maxBadgeNumber) goto L5;
        Context r10 = this.contextRef.get();
        if (r10 != null) goto L11;
        return "";
    L11:
        return r10.getString(R.string.mtrl_exceed_max_badge_number_suffix, new Object[]{Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX});
    L5:
        return NumberFormat.getInstance().format(getNumber());
    }

    private void loadDefaultStateFromAttributes(Context r10, AttributeSet r11, @AttrRes int r12, @StyleRes int r13) {
        TypedArray r14 = ThemeEnforcement.obtainStyledAttributes(r10, r11, R.styleable.Badge, r12, r13, new int[0]);
        setMaxCharacterCount(r14.getInt(R.styleable.Badge_maxCharacterCount, 4));
        int r15 = R.styleable.Badge_number;
        if (r14.hasValue(r15) == false) goto L5;
        setNumber(r14.getInt(r15, 0));
    L5:
        setBackgroundColor(readColorFromAttributes(r10, r14, R.styleable.Badge_backgroundColor));
        int r16 = R.styleable.Badge_badgeTextColor;
        if (r14.hasValue(r16) == false) goto L8;
        setBadgeTextColor(readColorFromAttributes(r10, r14, r16));
    L8:
        setBadgeGravity(r14.getInt(R.styleable.Badge_badgeGravity, TOP_END));
        setHorizontalOffset(r14.getDimensionPixelOffset(R.styleable.Badge_horizontalOffset, 0));
        setVerticalOffset(r14.getDimensionPixelOffset(R.styleable.Badge_verticalOffset, 0));
        r14.recycle();
    }

    private static int readColorFromAttributes(Context r10, @NonNull TypedArray r11, @StyleableRes int r12) {
        return MaterialResources.getColorStateList(r10, r11, r12).getDefaultColor();
    }

    private void restoreFromSavedState(@NonNull SavedState r10) {
        setMaxCharacterCount(SavedState.access$100(r10));
        if (SavedState.access$200(r10) == (-1)) goto L5;
        setNumber(SavedState.access$200(r10));
    L5:
        setBackgroundColor(SavedState.access$300(r10));
        setBadgeTextColor(SavedState.access$400(r10));
        setBadgeGravity(SavedState.access$500(r10));
        setHorizontalOffset(SavedState.access$600(r10));
        setVerticalOffset(SavedState.access$700(r10));
        setAdditionalHorizontalOffset(SavedState.access$800(r10));
        setAdditionalVerticalOffset(SavedState.access$900(r10));
        setVisible(SavedState.access$000(r10));
    }

    private void setTextAppearance(@Nullable TextAppearance r10) {
        if (this.textDrawableHelper.getTextAppearance() != r10) goto L5;
        return;
    L5:
        Context r11 = this.contextRef.get();
        if (r11 != null) goto L8;
        return;
    L8:
        this.textDrawableHelper.setTextAppearance(r10, r11);
        updateCenterAndBounds();
    }

    private void setTextAppearanceResource(@StyleRes int r10) {
        Context r11 = this.contextRef.get();
        if (r11 != null) goto L5;
        return;
    L5:
        setTextAppearance(new TextAppearance(r11, r10));
    }

    private void tryWrapAnchorInCompatParent(final View r10) {
        ViewGroup r11 = (ViewGroup) r10.getParent();
        if (r11 != null) goto L5;
    L6:
        WeakReference<FrameLayout> r12 = this.customBadgeParentRef;
        if (r12 != null) goto L9;
    L11:
        updateAnchorParentToNotClip(r10);
        final FrameLayout r13 = new FrameLayout(r10.getContext());
        r13.setId(R.id.mtrl_anchor_parent);
        r13.setClipChildren(false);
        r13.setClipToPadding(false);
        r13.setLayoutParams(r10.getLayoutParams());
        r13.setMinimumWidth(r10.getWidth());
        r13.setMinimumHeight(r10.getHeight());
        int r14 = r11.indexOfChild(r10);
        r11.removeViewAt(r14);
        r10.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r13.addView(r10);
        r11.addView(r13, r14);
        this.customBadgeParentRef = new WeakReference(r13);
        r13.post(new AnonymousClass1(this, r10, r13));
        return;
    L9:
        if (r12.get() != r11) goto L11;
        return;
    L5:
        if (r11.getId() != R.id.mtrl_anchor_parent) goto L6;
    }

    private static void updateAnchorParentToNotClip(View r10) {
        ViewGroup r11 = (ViewGroup) r10.getParent();
        r11.setClipChildren(false);
        r11.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        Context r10 = this.contextRef.get();
        WeakReference<View> r11 = this.anchorViewRef;
        FrameLayout r12 = null;
        if (r11 == null) goto L5;
        View r13 = r11.get();
    L6:
        if (r10 == null) goto L22;
        if (r13 == null) goto L24;
        Rect r14 = new Rect();
        r14.set(this.badgeBounds);
        Rect r15 = new Rect();
        r13.getDrawingRect(r15);
        WeakReference<FrameLayout> r16 = this.customBadgeParentRef;
        if (r16 == null) goto L12;
        r12 = r16.get();
    L12:
        if (r12 == null) goto L14;
    L15:
        if (r12 != null) goto L17;
        r12 = (ViewGroup) r13.getParent();
    L17:
        r12.offsetDescendantRectToMyCoords(r13, r15);
    L18:
        calculateCenterAndBounds(r10, r15, r13);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        this.shapeDrawable.setCornerSize(this.cornerRadius);
        if (r14.equals(this.badgeBounds) == true) goto L23;
        this.shapeDrawable.setBounds(this.badgeBounds);
        return;
    L23:
        return;
    L14:
        if (BadgeUtils.USE_COMPAT_PARENT == false) goto L18;
    L24:
        return;
    L22:
        return;
    L5:
        r13 = null;
        goto L6
    }

    private void updateMaxBadgeNumber() {
        this.maxBadgeNumber = ((int) Math.pow(10.0d, ((double) getMaxCharacterCount()) - 1.0d)) - 1;
    }

    public void clearNumber() {
        SavedState.access$202(this.savedState, -1);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas r10) {
        if (getBounds().isEmpty() == false) goto L5;
        return;
    L5:
        if (getAlpha() != 0) goto L7;
        return;
    L7:
        if (isVisible() == false) goto L16;
        this.shapeDrawable.draw(r10);
        if (hasNumber() == false) goto L15;
        drawText(r10);
        return;
    L15:
        return;
    }

    public int getAdditionalHorizontalOffset() {
        return SavedState.access$800(this.savedState);
    }

    public int getAdditionalVerticalOffset() {
        return SavedState.access$900(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return SavedState.access$1000(this.savedState);
    }

    @ColorInt
    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return SavedState.access$500(this.savedState);
    }

    @ColorInt
    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    @Nullable
    public CharSequence getContentDescription() {
        if (isVisible() == true) goto L6;
        return null;
    L6:
        if (hasNumber() == false) goto L20;
        if (SavedState.access$1200(this.savedState) <= 0) goto L18;
        Context r10 = this.contextRef.get();
        if (r10 != null) goto L13;
        return null;
    L13:
        if (getNumber() > this.maxBadgeNumber) goto L17;
        return r10.getResources().getQuantityString(SavedState.access$1200(this.savedState), getNumber(), new Object[]{Integer.valueOf(getNumber())});
    L17:
        return r10.getString(SavedState.access$1300(this.savedState), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
    L18:
        return null;
    L20:
        return SavedState.access$1100(this.savedState);
    }

    @Nullable
    public FrameLayout getCustomBadgeParent() {
        WeakReference<FrameLayout> r10 = this.customBadgeParentRef;
        if (r10 != null) goto L7;
        return null;
    L7:
        return r10.get();
    }

    public int getHorizontalOffset() {
        return SavedState.access$600(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getMaxCharacterCount() {
        return SavedState.access$100(this.savedState);
    }

    public int getNumber() {
        if (hasNumber() == true) goto L7;
        return 0;
    L7:
        return SavedState.access$200(this.savedState);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @NonNull
    public SavedState getSavedState() {
        return this.savedState;
    }

    public int getVerticalOffset() {
        return SavedState.access$700(this.savedState);
    }

    public boolean hasNumber() {
        if (SavedState.access$200(this.savedState) == (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] r10) {
        return super.onStateChange(r10);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void onTextSizeChange() {
        invalidateSelf();
    }

    public void setAdditionalHorizontalOffset(int r10) {
        SavedState.access$802(this.savedState, r10);
        updateCenterAndBounds();
    }

    public void setAdditionalVerticalOffset(int r10) {
        SavedState.access$902(this.savedState, r10);
        updateCenterAndBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int r10) {
        SavedState.access$1002(this.savedState, r10);
        this.textDrawableHelper.getTextPaint().setAlpha(r10);
        invalidateSelf();
    }

    public void setBackgroundColor(@ColorInt int r10) {
        SavedState.access$302(this.savedState, r10);
        ColorStateList r11 = ColorStateList.valueOf(r10);
        if (this.shapeDrawable.getFillColor() == r11) goto L6;
        this.shapeDrawable.setFillColor(r11);
        invalidateSelf();
        return;
    }

    public void setBadgeGravity(int r10) {
        if (SavedState.access$500(this.savedState) == r10) goto L14;
        SavedState.access$502(this.savedState, r10);
        WeakReference<View> r11 = this.anchorViewRef;
        if (r11 != null) goto L7;
        return;
    L7:
        if (r11.get() == null) goto L16;
        View r12 = this.anchorViewRef.get();
        WeakReference<FrameLayout> r13 = this.customBadgeParentRef;
        if (r13 == null) goto L11;
        FrameLayout r14 = r13.get();
    L12:
        updateBadgeCoordinates(r12, r14);
        return;
    L11:
        r14 = null;
        goto L12
    L16:
        return;
    }

    public void setBadgeTextColor(@ColorInt int r10) {
        SavedState.access$402(this.savedState, r10);
        if (this.textDrawableHelper.getTextPaint().getColor() == r10) goto L6;
        this.textDrawableHelper.getTextPaint().setColor(r10);
        invalidateSelf();
        return;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter r10) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(@StringRes int r10) {
        SavedState.access$1302(this.savedState, r10);
    }

    public void setContentDescriptionNumberless(CharSequence r10) {
        SavedState.access$1102(this.savedState, r10);
    }

    public void setContentDescriptionQuantityStringsResource(@PluralsRes int r10) {
        SavedState.access$1202(this.savedState, r10);
    }

    public void setHorizontalOffset(int r10) {
        SavedState.access$602(this.savedState, r10);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int r10) {
        if (SavedState.access$100(this.savedState) == r10) goto L6;
        SavedState.access$102(this.savedState, r10);
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
        return;
    }

    public void setNumber(int r10) {
        int r11 = Math.max(0, r10);
        if (SavedState.access$200(this.savedState) == r11) goto L6;
        SavedState.access$202(this.savedState, r11);
        this.textDrawableHelper.setTextWidthDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
        return;
    }

    public void setVerticalOffset(int r10) {
        SavedState.access$702(this.savedState, r10);
        updateCenterAndBounds();
    }

    public void setVisible(boolean r10) {
        setVisible(r10, false);
        SavedState.access$002(this.savedState, r10);
        if (BadgeUtils.USE_COMPAT_PARENT == true) goto L5;
        return;
    L5:
        if (getCustomBadgeParent() == null) goto L10;
        if (r10 == true) goto L11;
        ((ViewGroup) getCustomBadgeParent().getParent()).invalidate();
        return;
    L11:
        return;
    }

    @Deprecated
    public void updateBadgeCoordinates(@NonNull View r10, @Nullable ViewGroup r11) {
        if ((r11 instanceof FrameLayout) == false) goto L7;
        updateBadgeCoordinates(r10, (FrameLayout) r11);
        return;
    L7:
        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    public void updateBadgeCoordinates(@NonNull View r10) {
        updateBadgeCoordinates(r10, null);
    }

    public void updateBadgeCoordinates(@NonNull View r10, @Nullable FrameLayout r11) {
        this.anchorViewRef = new WeakReference(r10);
        boolean r12 = BadgeUtils.USE_COMPAT_PARENT;
        if (r12 == false) goto L6;
        if (r11 != null) goto L6;
        tryWrapAnchorInCompatParent(r10);
    L7:
        if (r12 == true) goto L9;
        updateAnchorParentToNotClip(r10);
    L9:
        updateCenterAndBounds();
        invalidateSelf();
        return;
    L6:
        this.customBadgeParentRef = new WeakReference(r11);
        goto L7
    }
}
