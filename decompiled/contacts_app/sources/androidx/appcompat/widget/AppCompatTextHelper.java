package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.LocaleList;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import java.lang.ref.WeakReference;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
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

    static class Api17Impl {
        private Api17Impl() {
        }

        static void setTextLocale(TextView r0, Locale r1) {
            r0.setTextLocale(r1);
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static Drawable[] getCompoundDrawablesRelative(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }
    }

    static class Api21Impl {
        private Api21Impl() {
        }

        static Locale forLanguageTag(String r0) {
            return Locale.forLanguageTag(r0);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static void setTextLocales(TextView r0, LocaleList r1) {
            r0.setTextLocales(r1);
        }

        static LocaleList forLanguageTags(String r0) {
            return LocaleList.forLanguageTags(r0);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static boolean setFontVariationSettings(TextView r0, String r1) {
            return r0.setFontVariationSettings(r1);
        }

        static int getAutoSizeStepGranularity(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static Typeface create(Typeface r0, int r1, boolean r2) {
            return Typeface.create(r0, r1, r2);
        }
    }

    void populateSurroundingTextIfNeeded(TextView r1, InputConnection r2, EditorInfo r3) {
    }

    AppCompatTextHelper(TextView r2) {
        this.mStyle = 0;
        this.mFontWeight = -1;
        this.mView = r2;
        this.mAutoSizeTextHelper = new AppCompatTextViewAutoSizeHelper(r2);
    }

    void loadFromAttributes(AttributeSet r17, int r18) {
        Context r10 = this.mView.getContext();
        AppCompatDrawableManager r11 = AppCompatDrawableManager.get();
        TintTypedArray r13 = TintTypedArray.obtainStyledAttributes(r10, r17, R.styleable.AppCompatTextHelper, r18, 0);
        TextView r0 = this.mView;
        ViewCompat.saveAttributeDataForStyleable(r0, r0.getContext(), R.styleable.AppCompatTextHelper, r17, r13.getWrappedTypeArray(), r18, 0);
        int r1 = r13.getResourceId(R.styleable.AppCompatTextHelper_android_textAppearance, -1);
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableLeft) == false) goto L6;
        this.mDrawableLeftTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableLeft, 0));
    L6:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableTop) == false) goto L9;
        this.mDrawableTopTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableTop, 0));
    L9:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableRight) == false) goto L12;
        this.mDrawableRightTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableRight, 0));
    L12:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableBottom) == false) goto L15;
        this.mDrawableBottomTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableBottom, 0));
    L15:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableStart) == false) goto L18;
        this.mDrawableStartTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableStart, 0));
    L18:
        if (r13.hasValue(R.styleable.AppCompatTextHelper_android_drawableEnd) == false) goto L20;
        this.mDrawableEndTint = createTintInfo(r10, r11, r13.getResourceId(R.styleable.AppCompatTextHelper_android_drawableEnd, 0));
    L20:
        r13.recycle();
        boolean r2 = this.mView.getTransformationMethod() instanceof PasswordTransformationMethod;
        boolean r3 = true;
        if (r1 == (-1)) goto L37;
        TintTypedArray r4 = TintTypedArray.obtainStyledAttributes(r10, r1, R.styleable.TextAppearance);
        if (r2 == false) goto L25;
    L27:
        boolean r5 = false;
        boolean r6 = false;
    L28:
        updateTypefaceAndStyle(r10, r4);
        if (r4.hasValue(R.styleable.TextAppearance_textLocale) == false) goto L31;
        String r7 = r4.getString(R.styleable.TextAppearance_textLocale);
    L33:
        if (r4.hasValue(R.styleable.TextAppearance_fontVariationSettings) == false) goto L35;
        String r8 = r4.getString(R.styleable.TextAppearance_fontVariationSettings);
    L36:
        r4.recycle();
    L38:
        TintTypedArray r9 = TintTypedArray.obtainStyledAttributes(r10, r17, R.styleable.TextAppearance, r18, 0);
        if (r2 == false) goto L41;
    L43:
        r3 = r6;
    L45:
        if (r9.hasValue(R.styleable.TextAppearance_textLocale) == false) goto L48;
        r7 = r9.getString(R.styleable.TextAppearance_textLocale);
    L48:
        if (r9.hasValue(R.styleable.TextAppearance_fontVariationSettings) == false) goto L51;
        r8 = r9.getString(R.styleable.TextAppearance_fontVariationSettings);
    L51:
        if (r9.hasValue(R.styleable.TextAppearance_android_textSize) == true) goto L53;
    L55:
        updateTypefaceAndStyle(r10, r9);
        r9.recycle();
        if (r2 == true) goto L59;
        if (r3 == false) goto L59;
        setAllCaps(r5);
    L59:
        Typeface r12 = this.mFontTypeface;
        if (r12 != null) goto L62;
    L65:
        if (r8 == null) goto L67;
        Api26Impl.setFontVariationSettings(this.mView, r8);
    L67:
        if (r7 == null) goto L69;
        Api24Impl.setTextLocales(this.mView, Api24Impl.forLanguageTags(r7));
    L69:
        this.mAutoSizeTextHelper.loadFromAttributes(r17, r18);
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L72;
    L79:
        TintTypedArray r14 = TintTypedArray.obtainStyledAttributes(r10, r17, R.styleable.AppCompatTextView);
        int r15 = r14.getResourceId(R.styleable.AppCompatTextView_drawableLeftCompat, -1);
        if (r15 == (-1)) goto L82;
        Drawable r16 = r11.getDrawable(r10, r15);
    L83:
        int r19 = r14.getResourceId(R.styleable.AppCompatTextView_drawableTopCompat, -1);
        if (r19 == (-1)) goto L86;
        Drawable r20 = r11.getDrawable(r10, r19);
    L87:
        int r21 = r14.getResourceId(R.styleable.AppCompatTextView_drawableRightCompat, -1);
        if (r21 == (-1)) goto L90;
        Drawable r22 = r11.getDrawable(r10, r21);
    L91:
        int r23 = r14.getResourceId(R.styleable.AppCompatTextView_drawableBottomCompat, -1);
        if (r23 == (-1)) goto L94;
        Drawable r24 = r11.getDrawable(r10, r23);
    L95:
        int r25 = r14.getResourceId(R.styleable.AppCompatTextView_drawableStartCompat, -1);
        if (r25 == (-1)) goto L98;
        Drawable r26 = r11.getDrawable(r10, r25);
    L99:
        int r27 = r14.getResourceId(R.styleable.AppCompatTextView_drawableEndCompat, -1);
        if (r27 == (-1)) goto L102;
        Drawable r28 = r11.getDrawable(r10, r27);
    L103:
        setCompoundDrawables(r16, r20, r22, r24, r26, r28);
        if (r14.hasValue(R.styleable.AppCompatTextView_drawableTint) == false) goto L107;
        TextViewCompat.setCompoundDrawableTintList(this.mView, r14.getColorStateList(R.styleable.AppCompatTextView_drawableTint));
    L107:
        if (r14.hasValue(R.styleable.AppCompatTextView_drawableTintMode) == false) goto L109;
        TextViewCompat.setCompoundDrawableTintMode(this.mView, DrawableUtils.parseTintMode(r14.getInt(R.styleable.AppCompatTextView_drawableTintMode, -1), null));
    L109:
        int r29 = r14.getDimensionPixelSize(R.styleable.AppCompatTextView_firstBaselineToTopHeight, -1);
        int r30 = r14.getDimensionPixelSize(R.styleable.AppCompatTextView_lastBaselineToBottomHeight, -1);
        int r31 = r14.getDimensionPixelSize(R.styleable.AppCompatTextView_lineHeight, -1);
        r14.recycle();
        if (r29 == (-1)) goto L112;
        TextViewCompat.setFirstBaselineToTopHeight(this.mView, r29);
    L112:
        if (r30 == (-1)) goto L114;
        TextViewCompat.setLastBaselineToBottomHeight(this.mView, r30);
    L114:
        if (r31 == (-1)) goto L117;
        TextViewCompat.setLineHeight(this.mView, r31);
        return;
    L117:
        return;
    L102:
        r28 = null;
        goto L103
    L98:
        r26 = null;
        goto L99
    L94:
        r24 = null;
        goto L95
    L90:
        r22 = null;
        goto L91
    L86:
        r20 = null;
        goto L87
    L82:
        r16 = null;
        goto L83
    L72:
        if (this.mAutoSizeTextHelper.getAutoSizeTextType() == 0) goto L79;
        int[] r32 = this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
        if (r32.length <= 0) goto L79;
        if (Api26Impl.getAutoSizeStepGranularity(this.mView) == (-1.0f)) goto L78;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(this.mView, this.mAutoSizeTextHelper.getAutoSizeMinTextSize(), this.mAutoSizeTextHelper.getAutoSizeMaxTextSize(), this.mAutoSizeTextHelper.getAutoSizeStepGranularity(), 0);
        goto L79
    L78:
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(this.mView, r32, 0);
        goto L79
    L62:
        if (this.mFontWeight != (-1)) goto L64;
        this.mView.setTypeface(r12, this.mStyle);
        goto L65
    L64:
        this.mView.setTypeface(r12);
        goto L65
    L53:
        if (r9.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) != 0) goto L55;
        this.mView.setTextSize(0, 0.0f);
        goto L55
    L41:
        if (r9.hasValue(R.styleable.TextAppearance_textAllCaps) == false) goto L43;
        r5 = r9.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        goto L45
    L35:
        r8 = null;
        goto L36
    L31:
        r7 = null;
        goto L33
    L25:
        if (r4.hasValue(R.styleable.TextAppearance_textAllCaps) == false) goto L27;
        r5 = r4.getBoolean(R.styleable.TextAppearance_textAllCaps, false);
        r6 = true;
        goto L28
    L37:
        r5 = false;
        r6 = false;
        r7 = null;
        r8 = null;
        goto L38
    }

    private void updateTypefaceAndStyle(Context r9, TintTypedArray r10) {
        this.mStyle = r10.getInt(R.styleable.TextAppearance_android_textStyle, this.mStyle);
        int r0 = r10.getInt(R.styleable.TextAppearance_android_textFontWeight, -1);
        this.mFontWeight = r0;
        boolean r3 = false;
        if (r0 == (-1)) goto L6;
        this.mStyle = (this.mStyle & 2) | 0;
    L6:
        if (r10.hasValue(R.styleable.TextAppearance_android_fontFamily) == false) goto L8;
    L22:
        this.mFontTypeface = null;
        if (r10.hasValue(R.styleable.TextAppearance_fontFamily) == false) goto L25;
        int r1 = R.styleable.TextAppearance_fontFamily;
    L26:
        final int r5 = this.mFontWeight;
        final int r6 = this.mStyle;
        if (r9.isRestricted() == true) goto L45;
        final WeakReference r11 = new WeakReference(this.mView);
        Typeface r12 = r10.getFont(r1, this.mStyle, new AnonymousClass1(this, r5, r6, r11));     // Catch: Throwable -> L56
        if (r12 == null) goto L40;
        if (this.mFontWeight == (-1)) goto L38;
        Typeface r13 = Typeface.create(r12, 0);     // Catch: Throwable -> L56
        int r7 = this.mFontWeight;     // Catch: Throwable -> L56
        if ((this.mStyle & 2) == 0) goto L36;
        boolean r8 = true;
    L37:
        this.mFontTypeface = Api28Impl.create(r13, r7, r8);     // Catch: Throwable -> L56
        goto L40
    L36:
        r8 = false;
        goto L37
    L38:
        this.mFontTypeface = r12;     // Catch: Throwable -> L56
    L40:
        if (this.mFontTypeface != null) goto L42;
        boolean r14 = true;
    L43:
        this.mAsyncFontPending = r14;     // Catch: Throwable -> L56
        goto L45
    L42:
        r14 = false;
    L45:
        if (this.mFontTypeface != null) goto L63;
        String r15 = r10.getString(r1);
        if (r15 != null) goto L49;
        return;
    L49:
        if (this.mFontWeight == (-1)) goto L54;
        Typeface r16 = Typeface.create(r15, 0);
        int r17 = this.mFontWeight;
        if ((this.mStyle & 2) == 0) goto L53;
        r3 = true;
    L53:
        this.mFontTypeface = Api28Impl.create(r16, r17, r3);
        return;
    L54:
        this.mFontTypeface = Typeface.create(r15, this.mStyle);
        return;
    L63:
        return;
    L25:
        r1 = R.styleable.TextAppearance_android_fontFamily;
        goto L26
    L8:
        if (r10.hasValue(R.styleable.TextAppearance_fontFamily) == true) goto L22;
        if (r10.hasValue(R.styleable.TextAppearance_android_typeface) == false) goto L59;
        this.mAsyncFontPending = false;
        int r18 = r10.getInt(R.styleable.TextAppearance_android_typeface, 1);
        if (r18 == 1) goto L20;
        if (r18 != 2) goto L16;
        this.mFontTypeface = Typeface.SERIF;
        return;
    L16:
        if (r18 != 3) goto L62;
        this.mFontTypeface = Typeface.MONOSPACE;
        return;
    L62:
        return;
    L20:
        this.mFontTypeface = Typeface.SANS_SERIF;
        return;
    }

    void onAsyncTypefaceReceived(WeakReference<TextView> r3, final Typeface r4) {
        if (this.mAsyncFontPending == false) goto L11;
        this.mFontTypeface = r4;
        final TextView r5 = r3.get();
        if (r5 != null) goto L7;
        return;
    L7:
        if (ViewCompat.isAttachedToWindow(r5) == false) goto L9;
        final int r0 = this.mStyle;
        r5.post(new AnonymousClass2(this, r5, r4, r0));
        return;
    L9:
        r5.setTypeface(r4, this.mStyle);
        return;
    }

    void onSetTextAppearance(Context r4, int r5) {
        TintTypedArray r6 = TintTypedArray.obtainStyledAttributes(r4, r5, R.styleable.TextAppearance);
        if (r6.hasValue(R.styleable.TextAppearance_textAllCaps) == false) goto L6;
        setAllCaps(r6.getBoolean(R.styleable.TextAppearance_textAllCaps, false));
    L6:
        if (r6.hasValue(R.styleable.TextAppearance_android_textSize) == true) goto L8;
    L10:
        updateTypefaceAndStyle(r4, r6);
        if (r6.hasValue(R.styleable.TextAppearance_fontVariationSettings) == false) goto L15;
        String r7 = r6.getString(R.styleable.TextAppearance_fontVariationSettings);
        if (r7 == null) goto L15;
        Api26Impl.setFontVariationSettings(this.mView, r7);
    L15:
        r6.recycle();
        Typeface r8 = this.mFontTypeface;
        if (r8 == null) goto L19;
        this.mView.setTypeface(r8, this.mStyle);
        return;
    L19:
        return;
    L8:
        if (r6.getDimensionPixelSize(R.styleable.TextAppearance_android_textSize, -1) != 0) goto L10;
        this.mView.setTextSize(0, 0.0f);
        goto L10
    }

    void setAllCaps(boolean r1) {
        this.mView.setAllCaps(r1);
    }

    void onSetCompoundDrawables() {
        applyCompoundDrawablesTints();
    }

    void applyCompoundDrawablesTints() {
        if (this.mDrawableLeftTint == null) goto L5;
    L10:
        Drawable[] r0 = this.mView.getCompoundDrawables();
        applyCompoundDrawableTint(r0[0], this.mDrawableLeftTint);
        applyCompoundDrawableTint(r0[1], this.mDrawableTopTint);
        applyCompoundDrawableTint(r0[2], this.mDrawableRightTint);
        applyCompoundDrawableTint(r0[3], this.mDrawableBottomTint);
    L12:
        if (this.mDrawableStartTint == null) goto L14;
    L15:
        Drawable[] r1 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        applyCompoundDrawableTint(r1[0], this.mDrawableStartTint);
        applyCompoundDrawableTint(r1[2], this.mDrawableEndTint);
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

    private void applyCompoundDrawableTint(Drawable r1, TintInfo r2) {
        if (r1 == null) goto L6;
        if (r2 == null) goto L7;
        AppCompatDrawableManager.tintDrawable(r1, r2, this.mView.getDrawableState());
        return;
    L7:
        return;
    }

    private static TintInfo createTintInfo(Context r0, AppCompatDrawableManager r1, int r2) {
        ColorStateList r3 = r1.getTintList(r0, r2);
        if (r3 == null) goto L6;
        TintInfo r4 = new TintInfo();
        r4.mHasTintList = true;
        r4.mTintList = r3;
        return r4;
    L6:
        return null;
    }

    void onLayout(boolean r1, int r2, int r3, int r4, int r5) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == true) goto L6;
        autoSizeText();
        return;
    }

    void setTextSize(int r2, float r3) {
        if (ViewUtils.SDK_LEVEL_SUPPORTS_AUTOSIZE == false) goto L5;
        return;
    L5:
        if (isAutoSizeEnabled() == true) goto L9;
        setTextSizeInternal(r2, r3);
        return;
    }

    void autoSizeText() {
        this.mAutoSizeTextHelper.autoSizeText();
    }

    boolean isAutoSizeEnabled() {
        return this.mAutoSizeTextHelper.isAutoSizeEnabled();
    }

    private void setTextSizeInternal(int r1, float r2) {
        this.mAutoSizeTextHelper.setTextSizeInternal(r1, r2);
    }

    void setAutoSizeTextTypeWithDefaults(int r1) {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeWithDefaults(r1);
    }

    void setAutoSizeTextTypeUniformWithConfiguration(int r1, int r2, int r3, int r4) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
    }

    void setAutoSizeTextTypeUniformWithPresetSizes(int[] r1, int r2) throws IllegalArgumentException {
        this.mAutoSizeTextHelper.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
    }

    int getAutoSizeTextType() {
        return this.mAutoSizeTextHelper.getAutoSizeTextType();
    }

    int getAutoSizeStepGranularity() {
        return this.mAutoSizeTextHelper.getAutoSizeStepGranularity();
    }

    int getAutoSizeMinTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMinTextSize();
    }

    int getAutoSizeMaxTextSize() {
        return this.mAutoSizeTextHelper.getAutoSizeMaxTextSize();
    }

    int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextHelper.getAutoSizeTextAvailableSizes();
    }

    ColorStateList getCompoundDrawableTintList() {
        TintInfo r0 = this.mDrawableTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintList;
    }

    void setCompoundDrawableTintList(ColorStateList r2) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        this.mDrawableTint.mTintList = r2;
        TintInfo r0 = this.mDrawableTint;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.mHasTintList = r3;
        setCompoundTints();
        return;
    L8:
        r3 = false;
        goto L9
    }

    PorterDuff.Mode getCompoundDrawableTintMode() {
        TintInfo r0 = this.mDrawableTint;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.mTintMode;
    }

    void setCompoundDrawableTintMode(PorterDuff.Mode r2) {
        if (this.mDrawableTint != null) goto L5;
        this.mDrawableTint = new TintInfo();
    L5:
        this.mDrawableTint.mTintMode = r2;
        TintInfo r0 = this.mDrawableTint;
        if (r2 == null) goto L8;
        boolean r3 = true;
    L9:
        r0.mHasTintMode = r3;
        setCompoundTints();
        return;
    L8:
        r3 = false;
        goto L9
    }

    private void setCompoundTints() {
        TintInfo r0 = this.mDrawableTint;
        this.mDrawableLeftTint = r0;
        this.mDrawableTopTint = r0;
        this.mDrawableRightTint = r0;
        this.mDrawableBottomTint = r0;
        this.mDrawableStartTint = r0;
        this.mDrawableEndTint = r0;
    }

    private void setCompoundDrawables(Drawable r6, Drawable r7, Drawable r8, Drawable r9, Drawable r10, Drawable r11) {
        if (r10 != null) goto L39;
        if (r11 != null) goto L39;
        if (r6 != null) goto L10;
        if (r7 != null) goto L10;
        if (r8 != null) goto L10;
        if (r9 != null) goto L10;
        return;
    L10:
        Drawable[] r12 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        Drawable r13 = r12[0];
        if (r13 == null) goto L13;
    L29:
        TextView r5 = this.mView;
        if (r7 != null) goto L33;
        r7 = r12[1];
    L33:
        Drawable r14 = r12[2];
        if (r9 != null) goto L37;
        r9 = r12[3];
    L37:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r5, r13, r7, r14, r9);
        return;
    L13:
        if (r12[2] != null) goto L29;
        Drawable[] r15 = this.mView.getCompoundDrawables();
        TextView r16 = this.mView;
        if (r6 != null) goto L19;
        r6 = r15[0];
    L19:
        if (r7 != null) goto L22;
        r7 = r15[1];
    L22:
        if (r8 != null) goto L25;
        r8 = r15[2];
    L25:
        if (r9 != null) goto L28;
        r9 = r15[3];
    L28:
        r16.setCompoundDrawablesWithIntrinsicBounds(r6, r7, r8, r9);
        return;
    L39:
        Drawable[] r17 = Api17Impl.getCompoundDrawablesRelative(this.mView);
        TextView r18 = this.mView;
        if (r10 != null) goto L43;
        r10 = r17[0];
    L43:
        if (r7 != null) goto L46;
        r7 = r17[1];
    L46:
        if (r11 != null) goto L49;
        r11 = r17[2];
    L49:
        if (r9 != null) goto L52;
        r9 = r17[3];
    L52:
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r18, r10, r7, r11, r9);
    }
}
