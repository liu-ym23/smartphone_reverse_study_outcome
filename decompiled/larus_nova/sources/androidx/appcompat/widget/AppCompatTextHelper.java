package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.inputmethod.EditorInfoCompat;
import androidx.core.widget.AutoSizeableTextView;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatTextHelper {
    private static final int MONOSPACE = 3;
    private static final int SANS = 1;
    private static final int SERIF = 2;
    private static final int TEXT_FONT_WEIGHT_UNSPECIFIED = -1;
    private boolean mAsyncFontPending;
    private final AppCompatTextViewAutoSizeHelper mAutoSizeTextHelper;
    private TintInfo mDrawableBottomTint;
    private TintInfo mDrawableEndTint;
    private TintInfo mDrawableLeftTint;
    private TintInfo mDrawableRightTint;
    private TintInfo mDrawableStartTint;
    private TintInfo mDrawableTint;
    private TintInfo mDrawableTopTint;
    private Typeface mFontTypeface;
    private int mFontWeight;
    private int mStyle;
    private final TextView mView;

    private void setCompoundTints() {
        TintInfo r100 = this.mDrawableTint;
        this.mDrawableLeftTint = r100;
        this.mDrawableTopTint = r100;
        this.mDrawableRightTint = r100;
        this.mDrawableBottomTint = r100;
        this.mDrawableStartTint = r100;
        this.mDrawableEndTint = r100;
    }

    public void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null) goto L5;
    L10:
        Drawable[] r100 = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(r100[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(r100[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(r100[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(r100[3], this.mDrawableBottomTint);
    L12:
        if (this.mDrawableStartTint == null) goto L14;
    L15:
        Drawable[] r101 = this.mView.getCompoundDrawablesRelative();
        applyCompoundDrawableTint(r101[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(r101[2], this.mDrawableEndTint);
        return;
    L14:
        if (this.mDrawableEndTint != null) goto L15;
        return;
    L5:
        if (this.mDrawableTopTint != null) goto L10;
        if (this.mDrawableRightTint != null) goto L10;
        if (this.mDrawableBottomTint == null) goto L12;
        goto L10
    }

    public void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    public int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    public int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    public int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    public ColorStateList getCompoundDrawableTintList() {
        TintInfo r100 = this.mDrawableTint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mTintList;
    }

    public PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo r100 = this.mDrawableTint;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.mTintMode;
    }

    public boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    public void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    public AppCompatTextHelper(TextView r100) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = r100;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(r100);
    }

    public void setAllCaps(boolean r100) {
        this.mView.setAllCaps(r100);
    }

    public void setAutoSizeTextTypeWithDefaults(int r100) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(r100);
    }

    public void setCompoundDrawableTintList(ColorStateList r100) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r101 = this.mDrawableTint;
        r101.mTintList = r100;
        if (r100 == null) goto L8;
        boolean r102 = true;
    L9:
        r101.mHasTintList = r102;
        setCompoundTints();
        return;
    L8:
        r102 = false;
        goto L9
    }

    public void setCompoundDrawableTintMode(PorterDuff.Mode r100) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        TintInfo r101 = this.mDrawableTint;
        r101.mTintMode = r100;
        if (r100 == null) goto L8;
        boolean r102 = true;
    L9:
        r101.mHasTintMode = r102;
        setCompoundTints();
        return;
    L8:
        r102 = false;
        goto L9
    }

    private void applyCompoundDrawableTint(Drawable r100, TintInfo r101) {
        if (r100 == null) goto L6;
        if (r101 == null) goto L7;
        AppCompatDrawableManager.tintDrawable(r100, r101, this.mView.getDrawableState());
        return;
    L7:
        return;
    }

    private void setTextSizeInternal(int r100, float r101) {
        this.mAutoSizeTextHelper.setTextSizeInternal(r100, r101);
    }

    private void updateTypefaceAndStyle(Context r110, TintTypedArray r111) {
        this.mStyle = r111.getInt(2, this.mStyle);
        int r100 = Build.VERSION.SDK_INT;
        boolean r101 = false;
        if (r100 < 28) goto L7;
        int r102 = r111.getInt(11, -1);
        this.mFontWeight = r102;
        if (r102 == (-1)) goto L7;
        this.mStyle = (this.mStyle & 2) | 0;
    L7:
        int r103 = 10;
        if (r111.hasValue(10) == false) goto L10;
    L24:
        this.mFontTypeface = null;
        if (r111.hasValue(12) == false) goto L27;
        r103 = 12;
    L27:
        final int r104 = this.mFontWeight;
        final int r105 = this.mStyle;
        if (r110.isRestricted() == true) goto L49;
        final WeakReference r112 = new WeakReference(this.mView);
        ResourcesCompat.FontCallback r106 = new AnonymousClass1(this, r104, r105, r112);
        Typeface r113 = r111.getFont(r103, this.mStyle, r106);     // Catch: Throwable -> L47
        if (r113 == null) goto L42;
        if (r100 >= 28) goto L34;
    L40:
        this.mFontTypeface = r113;     // Catch: Throwable -> L47
        goto L42
    L34:
        if (this.mFontWeight == (-1)) goto L40;
        Typeface r114 = Typeface.create(r113, 0);     // Catch: Throwable -> L47
        int r107 = this.mFontWeight;     // Catch: Throwable -> L47
        if ((this.mStyle & 2) == 0) goto L38;
        boolean r108 = true;
    L39:
        this.mFontTypeface = Typeface.create(r114, r107, r108);     // Catch: Throwable -> L47
        goto L42
    L38:
        r108 = false;
    L42:
        if (this.mFontTypeface != null) goto L44;
        boolean r115 = true;
    L45:
        this.mAsyncFontPending = r115;     // Catch: Throwable -> L47
        goto L49
    L44:
        r115 = false;
    L49:
        if (this.mFontTypeface != null) goto L68;
        String r116 = r111.getString(r103);
        if (r116 != null) goto L53;
        return;
    L53:
        if (Build.VERSION.SDK_INT >= 28) goto L55;
    L60:
        this.mFontTypeface = Typeface.create(r116, this.mStyle);
        return;
    L55:
        if (this.mFontWeight == (-1)) goto L60;
        Typeface r117 = Typeface.create(r116, 0);
        int r118 = this.mFontWeight;
        if ((this.mStyle & 2) == 0) goto L59;
        r101 = true;
    L59:
        this.mFontTypeface = Typeface.create(r117, r118, r101);
        return;
    L68:
        return;
    L10:
        if (r111.hasValue(12) == true) goto L24;
        if (r111.hasValue(1) == false) goto L64;
        this.mAsyncFontPending = false;
        int r119 = r111.getInt(1, 1);
        if (r119 == 1) goto L22;
        if (r119 != 2) goto L18;
        this.mFontTypeface = Typeface.SERIF;
        return;
    L18:
        if (r119 != 3) goto L67;
        this.mFontTypeface = Typeface.MONOSPACE;
        return;
    L67:
        return;
    L22:
        this.mFontTypeface = Typeface.SANS_SERIF;
        return;
    }

    public void loadFromAttributes(AttributeSet r210, int r211) {
        Context r110 = this.mView.getContext();
        AppCompatDrawableManager r111 = AppCompatDrawableManager.get();
        TintTypedArray r112 = TintTypedArray.obtainStyledAttributes(r110, r210, new int[]{R.attr.textAppearance, R.attr.drawableTop, R.attr.drawableBottom, R.attr.drawableLeft, R.attr.drawableRight, R.attr.drawableStart, R.attr.drawableEnd}, r211, 0);
        TextView r100 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r100, r100.getContext(), new int[]{R.attr.textAppearance, R.attr.drawableTop, R.attr.drawableBottom, R.attr.drawableLeft, R.attr.drawableRight, R.attr.drawableStart, R.attr.drawableEnd}, r210, r112.getWrappedTypeArray(), r211, 0);
        int r101 = r112.getResourceId(0, -1);
        if (r112.hasValue(3) == false) goto L6;
        this.mDrawableLeftTint = createTintInfo(r110, r111, r112.getResourceId(3, 0));
    L6:
        if (r112.hasValue(1) == false) goto L9;
        this.mDrawableTopTint = createTintInfo(r110, r111, r112.getResourceId(1, 0));
    L9:
        if (r112.hasValue(4) == false) goto L12;
        this.mDrawableRightTint = createTintInfo(r110, r111, r112.getResourceId(4, 0));
    L12:
        if (r112.hasValue(2) == false) goto L14;
        this.mDrawableBottomTint = createTintInfo(r110, r111, r112.getResourceId(2, 0));
    L14:
        int r102 = Build.VERSION.SDK_INT;
        if (r112.hasValue(5) == false) goto L18;
        this.mDrawableStartTint = createTintInfo(r110, r111, r112.getResourceId(5, 0));
    L18:
        if (r112.hasValue(6) == false) goto L20;
        this.mDrawableEndTint = createTintInfo(r110, r111, r112.getResourceId(6, 0));
    L20:
        r112.recycle();
        boolean r103 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        if (r101 == (-1)) goto L54;
        TintTypedArray r104 = TintTypedArray.obtainStyledAttributes(r110, r101, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        if (r103 == false) goto L25;
    L27:
        boolean r105 = false;
        boolean r212 = false;
    L28:
        updateTypefaceAndStyle(r110, r104);
        if (r102 < 23) goto L31;
        int r113 = 15;
        ColorStateList r213 = null;
        ColorStateList r214 = null;
    L43:
        ColorStateList r215 = null;
    L45:
        if (r104.hasValue(r113) == false) goto L47;
        String r216 = r104.getString(r113);
        int r114 = 26;
    L48:
        if (r102 >= r114) goto L50;
    L52:
        String r217 = null;
    L53:
        r104.recycle();
    L55:
        TintTypedArray r106 = TintTypedArray.obtainStyledAttributes(r110, r210, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale}, r211, 0);
        if (r103 == false) goto L58;
    L60:
        boolean r115 = r212;
    L61:
        if (r102 < 23) goto L63;
    L71:
        ColorStateList r107 = r213;
        ColorStateList r108 = r214;
        ColorStateList r109 = r215;
        if (r106.hasValue(15) == false) goto L74;
        r216 = r106.getString(15);
    L74:
        String r116 = r216;
        if (r102 >= 26) goto L77;
    L79:
        String r117 = r217;
        if (r102 < 28) goto L87;
        if (r106.hasValue(0) == false) goto L87;
        if (r106.getDimensionPixelSize(0, -1) != 0) goto L87;
        this.mView.setTextSize(0, 0.0f);
    L87:
        updateTypefaceAndStyle(r110, r106);
        r106.recycle();
        if (r107 == null) goto L90;
        this.mView.setTextColor(r107);
    L90:
        if (r108 == null) goto L92;
        this.mView.setHintTextColor(r108);
    L92:
        if (r109 == null) goto L94;
        this.mView.setLinkTextColor(r109);
    L94:
        if (r103 == true) goto L97;
        if (r115 == false) goto L97;
        setAllCaps(r105);
    L97:
        Typeface r118 = this.mFontTypeface;
        if (r118 != null) goto L100;
    L103:
        if (r117 == null) goto L105;
        this.mView.setFontVariationSettings(r117);
    L105:
        if (r116 != null) goto L107;
    L110:
        this.mAutoSizeTextHelper.loadFromAttributes(r210, r211);
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L113;
    L120:
        TintTypedArray r119 = TintTypedArray.obtainStyledAttributes(r110, r210, new int[]{R.attr.textAppearance, com.larus.nova.R.attr.autoSizeMaxTextSize, com.larus.nova.R.attr.autoSizeMinTextSize, com.larus.nova.R.attr.autoSizePresetSizes, com.larus.nova.R.attr.autoSizeStepGranularity, com.larus.nova.R.attr.autoSizeTextType, com.larus.nova.R.attr.drawableBottomCompat, com.larus.nova.R.attr.drawableEndCompat, com.larus.nova.R.attr.drawableLeftCompat, com.larus.nova.R.attr.drawableRightCompat, com.larus.nova.R.attr.drawableStartCompat, com.larus.nova.R.attr.drawableTint, com.larus.nova.R.attr.drawableTintMode, com.larus.nova.R.attr.drawableTopCompat, com.larus.nova.R.attr.firstBaselineToTopHeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.lastBaselineToBottomHeight, com.larus.nova.R.attr.lineHeight, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        int r120 = r119.getResourceId(8, -1);
        if (r120 == (-1)) goto L123;
        Drawable r121 = r111.getDrawable(r110, r120);
        int r122 = 13;
    L124:
        int r123 = r119.getResourceId(r122, -1);
        if (r123 == (-1)) goto L127;
        Drawable r124 = r111.getDrawable(r110, r123);
    L128:
        int r125 = r119.getResourceId(9, -1);
        if (r125 == (-1)) goto L131;
        Drawable r126 = r111.getDrawable(r110, r125);
        int r127 = 6;
    L132:
        int r128 = r119.getResourceId(r127, -1);
        if (r128 == (-1)) goto L135;
        Drawable r129 = r111.getDrawable(r110, r128);
    L136:
        int r130 = r119.getResourceId(10, -1);
        if (r130 == (-1)) goto L139;
        Drawable r131 = r111.getDrawable(r110, r130);
        int r132 = 7;
    L140:
        int r133 = r119.getResourceId(r132, -1);
        if (r133 == (-1)) goto L143;
        Drawable r134 = r111.getDrawable(r110, r133);
    L144:
        setCompoundDrawables(r121, r124, r126, r129, r131, r134);
        if (r119.hasValue(11) == false) goto L148;
        TextViewCompat.setCompoundDrawableTintList(this.mView, r119.getColorStateList(11));
    L148:
        if (r119.hasValue(12) == false) goto L150;
        int r135 = -1;
        TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(r119.getInt(12, -1), null));
    L151:
        int r136 = r119.getDimensionPixelSize(14, r135);
        int r137 = r119.getDimensionPixelSize(17, r135);
        int r138 = r119.getDimensionPixelSize(18, r135);
        r119.recycle();
        if (r136 == r135) goto L154;
        TextViewCompat.setFirstBaselineToTopHeight(this.mView, r136);
    L154:
        if (r137 == r135) goto L156;
        TextViewCompat.setLastBaselineToBottomHeight(this.mView, r137);
    L156:
        if (r138 == r135) goto L159;
        TextViewCompat.setLineHeight(this.mView, r138);
        return;
    L159:
        return;
    L150:
        r135 = -1;
        goto L151
    L143:
        r134 = null;
        goto L144
    L139:
        r132 = 7;
        r131 = null;
        goto L140
    L135:
        r129 = null;
        goto L136
    L131:
        r127 = 6;
        r126 = null;
        goto L132
    L127:
        r124 = null;
        goto L128
    L123:
        r122 = 13;
        r121 = null;
        goto L124
    L113:
        if (this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) goto L120;
        int[] r139 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (r139.length <= 0) goto L120;
        if (this.mView.getAutoSizeStepGranularity() == (-1.0f)) goto L119;
        this.mView.setAutoSizeTextTypeUniformWithConfiguration(this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        goto L120
    L119:
        this.mView.setAutoSizeTextTypeUniformWithPresetSizes(r139, 0);
        goto L120
    L107:
        if (r102 < 24) goto L109;
        this.mView.setTextLocales(LocaleList.forLanguageTags(r116));
        goto L110
    L109:
        this.mView.setTextLocale(Locale.forLanguageTag(r116.substring(0, r116.indexOf(44))));
        goto L110
    L100:
        if (this.mFontWeight != (-1)) goto L102;
        this.mView.setTypeface(r118, this.mStyle);
        goto L103
    L102:
        this.mView.setTypeface(r118);
        goto L103
    L77:
        if (r106.hasValue(13) == false) goto L79;
        r217 = r106.getString(13);
        goto L79
    L63:
        if (r106.hasValue(3) == false) goto L66;
        r213 = r106.getColorStateList(3);
    L66:
        if (r106.hasValue(4) == false) goto L69;
        r214 = r106.getColorStateList(4);
    L69:
        if (r106.hasValue(5) == false) goto L71;
        r215 = r106.getColorStateList(5);
        goto L71
    L58:
        if (r106.hasValue(14) == false) goto L60;
        r105 = r106.getBoolean(14, false);
        r115 = true;
        goto L61
    L50:
        if (r104.hasValue(13) == false) goto L52;
        r217 = r104.getString(13);
        goto L53
    L47:
        r114 = 26;
        r216 = null;
        goto L48
    L31:
        if (r104.hasValue(3) == false) goto L33;
        r213 = r104.getColorStateList(3);
    L35:
        if (r104.hasValue(4) == false) goto L37;
        r214 = r104.getColorStateList(4);
        int r140 = 5;
    L39:
        if (r104.hasValue(r140) == false) goto L41;
        r215 = r104.getColorStateList(r140);
        r113 = 15;
        goto L45
    L41:
        r113 = 15;
        goto L43
    L37:
        r140 = 5;
        r214 = null;
        goto L39
    L33:
        r213 = null;
        goto L35
    L25:
        if (r104.hasValue(14) == false) goto L27;
        r105 = r104.getBoolean(14, false);
        r212 = true;
        goto L28
    L54:
        r105 = false;
        r212 = false;
        r213 = null;
        r214 = null;
        r215 = null;
        r216 = null;
        r217 = null;
        goto L55
    }

    public void onAsyncTypefaceReceived(WeakReference<TextView> r100, final Typeface r101) {
        if (this.mAsyncFontPending == false) goto L11;
        this.mFontTypeface = r101;
        final TextView r102 = r100.get();
        if (r102 != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(r102) == false) goto L9;
        final int r103 = this.mStyle;
        r102.post(new AnonymousClass2(this, r102, r101, r103));
        return;
    L9:
        r102.setTypeface(r101, this.mStyle);
        return;
    }

    public void onSetTextAppearance(Context r100, int r101) {
        TintTypedArray r102 = TintTypedArray.obtainStyledAttributes(r100, r101, new int[]{R.attr.textSize, R.attr.typeface, R.attr.textStyle, R.attr.textColor, R.attr.textColorHint, R.attr.textColorLink, R.attr.shadowColor, R.attr.shadowDx, R.attr.shadowDy, R.attr.shadowRadius, R.attr.fontFamily, R.attr.textFontWeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale});
        if (r102.hasValue(14) == false) goto L5;
        setAllCaps(r102.getBoolean(14, false));
    L5:
        int r103 = Build.VERSION.SDK_INT;
        if (r103 >= 23) goto L23;
        if (r102.hasValue(3) == false) goto L13;
        ColorStateList r104 = r102.getColorStateList(3);
        if (r104 == null) goto L13;
        this.mView.setTextColor(r104);
    L13:
        if (r102.hasValue(5) == false) goto L18;
        ColorStateList r105 = r102.getColorStateList(5);
        if (r105 == null) goto L18;
        this.mView.setLinkTextColor(r105);
    L18:
        if (r102.hasValue(4) == false) goto L23;
        ColorStateList r106 = r102.getColorStateList(4);
        if (r106 == null) goto L23;
        this.mView.setHintTextColor(r106);
    L23:
        if (r102.hasValue(0) == true) goto L25;
    L27:
        updateTypefaceAndStyle(r100, r102);
        if (r103 >= 26) goto L30;
    L34:
        r102.recycle();
        Typeface r107 = this.mFontTypeface;
        if (r107 == null) goto L38;
        this.mView.setTypeface(r107, this.mStyle);
        return;
    L38:
        return;
    L30:
        if (r102.hasValue(13) == false) goto L34;
        String r108 = r102.getString(13);
        if (r108 == null) goto L34;
        this.mView.setFontVariationSettings(r108);
        goto L34
    L25:
        if (r102.getDimensionPixelSize(0, -1) != 0) goto L27;
        this.mView.setTextSize(0, 0.0f);
        goto L27
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r100, int r101) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(r100, r101);
    }

    public void setTextSize(int r100, float r101) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == false) goto L5;
        return;
    L5:
        if (isAutoSizeEnabled() == true) goto L9;
        setTextSizeInternal(r100, r101);
        return;
    }

    private static TintInfo createTintInfo(Context r100, AppCompatDrawableManager r101, int r102) {
        ColorStateList r103 = r101.getTintList(r100, r102);
        if (r103 == null) goto L6;
        TintInfo r104 = new TintInfo();
        r104.mHasTintList = true;
        r104.mTintList = r103;
        return r104;
    L6:
        return null;
    }

    public void populateSurroundingTextIfNeeded(TextView r100, InputConnection r101, EditorInfo r102) {
        if (Build.VERSION.SDK_INT >= 30) goto L7;
        if (r101 == null) goto L8;
        EditorInfoCompat.setInitialSurroundingText(r102, r100.getText());
        return;
    L8:
        return;
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int r100, int r101, int r102, int r103) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(r100, r101, r102, r103);
    }

    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (AutoSizeableTextView.PLATFORM_SUPPORTS_AUTOSIZE == true) goto L6;
        autoSizeText();
        return;
    }

    private void setCompoundDrawables(Drawable r100, Drawable r101, Drawable r102, Drawable r103, Drawable r110, Drawable r111) {
        if (r110 != null) goto L39;
        if (r111 != null) goto L39;
        if (r100 != null) goto L10;
        if (r101 != null) goto L10;
        if (r102 != null) goto L10;
        if (r103 != null) goto L10;
        return;
    L10:
        Drawable[] r112 = this.mView.getCompoundDrawablesRelative();
        Drawable r113 = r112[0];
        if (r113 == null) goto L13;
    L29:
        TextView r104 = this.mView;
        if (r101 != null) goto L33;
        r101 = r112[1];
    L33:
        Drawable r105 = r112[2];
        if (r103 != null) goto L37;
        r103 = r112[3];
    L37:
        r104.setCompoundDrawablesRelativeWithIntrinsicBounds(r113, r101, r105, r103);
        return;
    L13:
        if (r112[2] != null) goto L29;
        Drawable[] r114 = this.mView.getCompoundDrawables();
        TextView r115 = this.mView;
        if (r100 != null) goto L19;
        r100 = r114[0];
    L19:
        if (r101 != null) goto L22;
        r101 = r114[1];
    L22:
        if (r102 != null) goto L25;
        r102 = r114[2];
    L25:
        if (r103 != null) goto L28;
        r103 = r114[3];
    L28:
        r115.setCompoundDrawablesWithIntrinsicBounds(r100, r101, r102, r103);
        return;
    L39:
        Drawable[] r106 = this.mView.getCompoundDrawablesRelative();
        TextView r107 = this.mView;
        if (r110 != null) goto L43;
        r110 = r106[0];
    L43:
        if (r101 != null) goto L46;
        r101 = r106[1];
    L46:
        if (r111 != null) goto L49;
        r111 = r106[2];
    L49:
        if (r103 != null) goto L52;
        r103 = r106[3];
    L52:
        r107.setCompoundDrawablesRelativeWithIntrinsicBounds(r110, r101, r111, r103);
    }
}
