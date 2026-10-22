package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes3.dex */
class AppCompatTextViewAutoSizeHelper {
    private static final int DEFAULT_AUTO_SIZE_GRANULARITY_IN_PX = 1;
    private static final int DEFAULT_AUTO_SIZE_MAX_TEXT_SIZE_IN_SP = 112;
    private static final int DEFAULT_AUTO_SIZE_MIN_TEXT_SIZE_IN_SP = 12;
    private static final String TAG = "ACTVAutoSizeHelper";
    private static final RectF TEMP_RECTF = null;
    static final float UNSET_AUTO_SIZE_UNIFORM_CONFIGURATION_VALUE = -1.0f;
    private static final int VERY_WIDE = 1048576;
    private static ConcurrentHashMap<String, Field> sTextViewFieldByNameCache;
    private static ConcurrentHashMap<String, Method> sTextViewMethodByNameCache;
    private float mAutoSizeMaxTextSizeInPx;
    private float mAutoSizeMinTextSizeInPx;
    private float mAutoSizeStepGranularityInPx;
    private int[] mAutoSizeTextSizesInPx;
    private int mAutoSizeTextType;
    private final Context mContext;
    private boolean mHasPresetAutoSizeValues;
    private final Impl mImpl;
    private boolean mNeedsAutoSizeText;
    private TextPaint mTempTextPaint;
    private final TextView mTextView;

    public static class Impl {
        public Impl() {
        }

        public void computeAndSetTextDirection(StaticLayout.Builder r100, TextView r101) {
        }

        public boolean isHorizontallyScrollable(TextView r100) {
            return ((Boolean) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r100, "getHorizontallyScrolling", Boolean.FALSE)).booleanValue();
        }
    }

    public static class Impl23 extends Impl {
        public Impl23() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder r100, TextView r101) {
            r100.setTextDirection((TextDirectionHeuristic) AppCompatTextViewAutoSizeHelper.invokeAndReturnWithDefault(r101, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        }
    }

    public static class Impl29 extends Impl23 {
        public Impl29() {
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public boolean isHorizontallyScrollable(TextView r100) {
            return r100.isHorizontallyScrollable();
        }

        @Override // androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl23, androidx.appcompat.widget.AppCompatTextViewAutoSizeHelper.Impl
        public void computeAndSetTextDirection(StaticLayout.Builder r100, TextView r101) {
            r100.setTextDirection(r101.getTextDirectionHeuristic());
        }
    }

    private void clearAutoSizeConfiguration() {
        this.mAutoSizeTextType = 0;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mNeedsAutoSizeText = false;
    }

    static {
        TEMP_RECTF = new RectF();
        sTextViewMethodByNameCache = new ConcurrentHashMap();
        sTextViewFieldByNameCache = new ConcurrentHashMap();
    }

    private boolean setupAutoSizeUniformPresetSizesConfiguration() {
        int[] r100 = this.mAutoSizeTextSizesInPx;
        int r101 = r100.length;
        if (r101 <= 0) goto L5;
        boolean r102 = true;
    L6:
        this.mHasPresetAutoSizeValues = r102;
        if (r102 == false) goto L9;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r100[0];
        this.mAutoSizeMaxTextSizeInPx = r100[r101 - 1];
        this.mAutoSizeStepGranularityInPx = -1.0f;
    L9:
        return r102;
    L5:
        r102 = false;
        goto L6
    }

    private boolean supportsAutoSizeText() {
        return !(this.mTextView instanceof AppCompatEditText);
    }

    public int getAutoSizeMaxTextSize() {
        return Math.round(this.mAutoSizeMaxTextSizeInPx);
    }

    public int getAutoSizeMinTextSize() {
        return Math.round(this.mAutoSizeMinTextSizeInPx);
    }

    public int getAutoSizeStepGranularity() {
        return Math.round(this.mAutoSizeStepGranularityInPx);
    }

    private boolean setupAutoSizeText() {
        int r100 = 0;
        if (supportsAutoSizeText() == true) goto L5;
    L15:
        this.mNeedsAutoSizeText = false;
    L17:
        return this.mNeedsAutoSizeText;
    L5:
        if (this.mAutoSizeTextType != 1) goto L15;
        if (this.mHasPresetAutoSizeValues == true) goto L9;
    L10:
        int r101 = ((int) Math.floor((this.mAutoSizeMaxTextSizeInPx - this.mAutoSizeMinTextSizeInPx) / this.mAutoSizeStepGranularityInPx)) + 1;
        int[] r102 = new int[r101];
    L11:
        if (r100 >= r101) goto L13;
        r102[r100] = Math.round(this.mAutoSizeMinTextSizeInPx + (r100 * this.mAutoSizeStepGranularityInPx));
        r100 = r100 + 1;
        goto L11
    L13:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r102);
    L14:
        this.mNeedsAutoSizeText = true;
        goto L17
    L9:
        if (this.mAutoSizeTextSizesInPx.length != 0) goto L14;
        goto L10
    }

    public void autoSizeText() {
        if (isAutoSizeEnabled() == true) goto L6;
        return;
    L6:
        if (this.mNeedsAutoSizeText == true) goto L8;
    L31:
        this.mNeedsAutoSizeText = true;
        return;
    L8:
        if (this.mTextView.getMeasuredHeight() > 0) goto L10;
        return;
    L10:
        if (this.mTextView.getMeasuredWidth() > 0) goto L13;
        return;
    L13:
        if (this.mImpl.isHorizontallyScrollable(this.mTextView) == false) goto L15;
        int r100 = 1048576;
    L16:
        int r101 = (this.mTextView.getHeight() - this.mTextView.getCompoundPaddingBottom()) - this.mTextView.getCompoundPaddingTop();
        if (r100 <= 0) goto L35;
        if (r101 <= 0) goto L37;
        RectF r102 = TEMP_RECTF;
        monitor-enter(r102);
        r102.setEmpty();     // Catch: Throwable -> L27
        r102.right = r100;     // Catch: Throwable -> L27
        r102.bottom = r101;     // Catch: Throwable -> L27
        float r103 = findLargestTextSizeWhichFits(r102);     // Catch: Throwable -> L27
        if (r103 == this.mTextView.getTextSize()) goto L25;
        setTextSizeInternal(0, r103);     // Catch: Throwable -> L27
    L25:
        monitor-exit(r102);     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        throw th;
    L37:
        return;
    L35:
        return;
    L15:
        r100 = (this.mTextView.getMeasuredWidth() - this.mTextView.getTotalPaddingLeft()) - this.mTextView.getTotalPaddingRight();
        goto L16
    }

    public boolean isAutoSizeEnabled() {
        if (supportsAutoSizeText() == true) goto L5;
    L7:
        return false;
    L5:
        if (this.mAutoSizeTextType == 0) goto L7;
        return true;
    }

    public int[] getAutoSizeTextAvailableSizes() {
        return this.mAutoSizeTextSizesInPx;
    }

    public int getAutoSizeTextType() {
        return this.mAutoSizeTextType;
    }

    public AppCompatTextViewAutoSizeHelper(TextView r100) {
        this.mAutoSizeTextType = 0;
        this.mNeedsAutoSizeText = false;
        this.mAutoSizeStepGranularityInPx = -1.0f;
        this.mAutoSizeMinTextSizeInPx = -1.0f;
        this.mAutoSizeMaxTextSizeInPx = -1.0f;
        this.mAutoSizeTextSizesInPx = new int[0];
        this.mHasPresetAutoSizeValues = false;
        this.mTextView = r100;
        this.mContext = r100.getContext();
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 29) goto L6;
        this.mImpl = new Impl29();
        return;
    L6:
        if (r101 < 23) goto L8;
        this.mImpl = new Impl23();
        return;
    L8:
        this.mImpl = new Impl();
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatTextViewAutoSizeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private int[] cleanupAutoSizePresetSizes(int[] r100) {
        int r101 = r100.length;
        if (r101 != 0) goto L5;
        return r100;
    L5:
        Arrays.sort(r100);
        ArrayList r102 = new ArrayList();
        int r103 = 0;
        int r104 = 0;
    L6:
        if (r104 >= r101) goto L14;
        int r105 = r100[r104];
        if (r105 <= 0) goto L12;
        if (Collections.binarySearch(r102, Integer.valueOf(r105)) >= 0) goto L12;
        r102.add(Integer.valueOf(r105));
    L12:
        r104 = r104 + 1;
        goto L6
    L14:
        if (r101 != r102.size()) goto L16;
        return r100;
    L16:
        int r106 = r102.size();
        int[] r107 = new int[r106];
    L17:
        if (r103 >= r106) goto L19;
        r107[r103] = ((Integer) ListProtector.get(r102, r103)).intValue();
        r103 = r103 + 1;
        goto L17
    L19:
        return r107;
    }

    private int findLargestTextSizeWhichFits(RectF r100) {
        int r101 = this.mAutoSizeTextSizesInPx.length;
        if (r101 == 0) goto L13;
        int r102 = 1;
        int r103 = r101 - 1;
        int r104 = 0;
    L5:
        if (r102 > r103) goto L11;
        int r105 = (r102 + r103) / 2;
        if (suggestedSizeFitsInSpace(this.mAutoSizeTextSizesInPx[r105], r100) == true) goto L8;
        r104 = r105 - 1;
        r103 = r104;
        goto L5
    L8:
        int r106 = r105 + 1;
        r104 = r102;
        r102 = r106;
        goto L5
    L11:
        return this.mAutoSizeTextSizesInPx[r104];
    L13:
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    private static Field getTextViewField(String r100) {
        Field r101 = sTextViewFieldByNameCache.get(r100);     // Catch: NoSuchFieldException -> L8
        if (r101 != null) goto L7;
        r101 = TextView.class.getDeclaredField(r100);     // Catch: NoSuchFieldException -> L8
        if (r101 == null) goto L7;
        r101.setAccessible(true);     // Catch: NoSuchFieldException -> L8
        sTextViewFieldByNameCache.put(r100, r101);     // Catch: NoSuchFieldException -> L8
    L7:
        return r101;
    L9:
        return null;
    }

    private static Method getTextViewMethod(String r100) {
        Method r101 = sTextViewMethodByNameCache.get(r100);     // Catch: Exception -> L8
        if (r101 != null) goto L7;
        r101 = TextView.class.getDeclaredMethod(r100, new Class[0]);     // Catch: Exception -> L8
        if (r101 == null) goto L7;
        r101.setAccessible(true);     // Catch: Exception -> L8
        sTextViewMethodByNameCache.put(r100, r101);     // Catch: Exception -> L8
    L7:
        return r101;
    L9:
        return null;
    }

    private void setRawTextSize(float r100) {
        if (r100 == this.mTextView.getPaint().getTextSize()) goto L19;
        this.mTextView.getPaint().setTextSize(r100);
        boolean r101 = this.mTextView.isInLayout();
        if (this.mTextView.getLayout() == null) goto L20;
        this.mNeedsAutoSizeText = false;
        Method r102 = getTextViewMethod("nullLayouts");     // Catch: Exception -> L11
        if (r102 == null) goto L12;
        r102.invoke(this.mTextView, new Object[0]);     // Catch: Exception -> L11
    L12:
        if (r101 == true) goto L14;
        this.mTextView.requestLayout();
    L15:
        this.mTextView.invalidate();
        return;
    L14:
        this.mTextView.forceLayout();
        goto L15
    L20:
        return;
    }

    private void setupAutoSizeUniformPresetSizes(TypedArray r100) {
        int r101 = r100.length();
        int[] r102 = new int[r101];
        if (r101 <= 0) goto L10;
        int r103 = 0;
    L5:
        if (r103 >= r101) goto L7;
        r102[r103] = r100.getDimensionPixelSize(r103, -1);
        r103 = r103 + 1;
        goto L5
    L7:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r102);
        setupAutoSizeUniformPresetSizesConfiguration();
        return;
    }

    public void initTempTextPaint(int r100) {
        TextPaint r101 = this.mTempTextPaint;
        if (r101 != null) goto L5;
        this.mTempTextPaint = new TextPaint();
    L6:
        this.mTempTextPaint.set(this.mTextView.getPaint());
        this.mTempTextPaint.setTextSize(r100);
        return;
    L5:
        r101.reset();
        goto L6
    }

    public void setAutoSizeTextTypeWithDefaults(int r100) {
        if (supportsAutoSizeText() == false) goto L14;
        if (r100 != 0) goto L6;
        clearAutoSizeConfiguration();
        return;
    L6:
        if (r100 != 1) goto L11;
        DisplayMetrics r101 = INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatTextViewAutoSizeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources());
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(2, 12.0f, r101), TypedValue.applyDimension(2, 112.0f, r101), 1.0f);
        if (setupAutoSizeText() == false) goto L15;
        autoSizeText();
        return;
    L15:
        return;
    L11:
        throw new IllegalArgumentException("Unknown auto-size text type: " + r100);
    }

    private boolean suggestedSizeFitsInSpace(int r100, RectF r101) {
        CharSequence r102 = this.mTextView.getText();
        TransformationMethod r103 = this.mTextView.getTransformationMethod();
        if (r103 == null) goto L7;
        CharSequence r104 = r103.getTransformation(r102, this.mTextView);
        if (r104 == null) goto L7;
        r102 = r104;
    L7:
        int r105 = this.mTextView.getMaxLines();
        initTempTextPaint(r100);
        StaticLayout r106 = createLayout(r102, (Layout.Alignment) invokeAndReturnWithDefault(this.mTextView, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(r101.right), r105);
        if (r105 == (-1)) goto L15;
        if (r106.getLineCount() <= r105) goto L12;
    L13:
        return false;
    L12:
        if (r106.getLineEnd(r106.getLineCount() - 1) != r102.length()) goto L13;
    L15:
        if (r106.getHeight() <= r101.bottom) goto L17;
        return false;
    L17:
        return true;
    }

    public void loadFromAttributes(AttributeSet r110, int r111) {
        TypedArray r100 = this.mContext.obtainStyledAttributes(r110, new int[]{R.attr.textAppearance, com.larus.nova.R.attr.autoSizeMaxTextSize, com.larus.nova.R.attr.autoSizeMinTextSize, com.larus.nova.R.attr.autoSizePresetSizes, com.larus.nova.R.attr.autoSizeStepGranularity, com.larus.nova.R.attr.autoSizeTextType, com.larus.nova.R.attr.drawableBottomCompat, com.larus.nova.R.attr.drawableEndCompat, com.larus.nova.R.attr.drawableLeftCompat, com.larus.nova.R.attr.drawableRightCompat, com.larus.nova.R.attr.drawableStartCompat, com.larus.nova.R.attr.drawableTint, com.larus.nova.R.attr.drawableTintMode, com.larus.nova.R.attr.drawableTopCompat, com.larus.nova.R.attr.firstBaselineToTopHeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.lastBaselineToBottomHeight, com.larus.nova.R.attr.lineHeight, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale}, r111, 0);
        TextView r101 = this.mTextView;
        ViewCompat.saveAttributeDataForStyleable(r101, r101.getContext(), new int[]{R.attr.textAppearance, com.larus.nova.R.attr.autoSizeMaxTextSize, com.larus.nova.R.attr.autoSizeMinTextSize, com.larus.nova.R.attr.autoSizePresetSizes, com.larus.nova.R.attr.autoSizeStepGranularity, com.larus.nova.R.attr.autoSizeTextType, com.larus.nova.R.attr.drawableBottomCompat, com.larus.nova.R.attr.drawableEndCompat, com.larus.nova.R.attr.drawableLeftCompat, com.larus.nova.R.attr.drawableRightCompat, com.larus.nova.R.attr.drawableStartCompat, com.larus.nova.R.attr.drawableTint, com.larus.nova.R.attr.drawableTintMode, com.larus.nova.R.attr.drawableTopCompat, com.larus.nova.R.attr.firstBaselineToTopHeight, com.larus.nova.R.attr.fontFamily, com.larus.nova.R.attr.fontVariationSettings, com.larus.nova.R.attr.lastBaselineToBottomHeight, com.larus.nova.R.attr.lineHeight, com.larus.nova.R.attr.textAllCaps, com.larus.nova.R.attr.textLocale}, r110, r100, r111, 0);
        if (r100.hasValue(5) == false) goto L6;
        this.mAutoSizeTextType = r100.getInt(5, 0);
    L6:
        if (r100.hasValue(4) == false) goto L8;
        float r112 = r100.getDimension(4, -1.0f);
    L10:
        if (r100.hasValue(2) == false) goto L12;
        float r102 = r100.getDimension(2, -1.0f);
    L14:
        if (r100.hasValue(1) == false) goto L16;
        float r103 = r100.getDimension(1, -1.0f);
    L18:
        if (r100.hasValue(3) == false) goto L22;
        int r104 = r100.getResourceId(3, 0);
        if (r104 <= 0) goto L22;
        TypedArray r105 = r100.getResources().obtainTypedArray(r104);
        setupAutoSizeUniformPresetSizes(r105);
        r105.recycle();
    L22:
        r100.recycle();
        if (supportsAutoSizeText() == true) goto L25;
        this.mAutoSizeTextType = 0;
        return;
    L25:
        if (this.mAutoSizeTextType == 1) goto L27;
        return;
    L27:
        if (this.mHasPresetAutoSizeValues == true) goto L38;
        DisplayMetrics r106 = INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatTextViewAutoSizeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources());
        if (r102 != (-1.0f)) goto L32;
        r102 = TypedValue.applyDimension(2, 12.0f, r106);
    L32:
        if (r103 != (-1.0f)) goto L35;
        r103 = TypedValue.applyDimension(2, 112.0f, r106);
    L35:
        if (r112 != (-1.0f)) goto L37;
        r112 = 1.0f;
    L37:
        validateAndSetAutoSizeTextTypeUniformConfiguration(r102, r103, r112);
    L38:
        setupAutoSizeText();
        return;
    L16:
        r103 = -1.0f;
        goto L18
    L12:
        r102 = -1.0f;
        goto L14
    L8:
        r112 = -1.0f;
        goto L10
    }

    public void setAutoSizeTextTypeUniformWithPresetSizes(int[] r100, int r101) throws IllegalArgumentException {
        if (supportsAutoSizeText() == false) goto L23;
        int r102 = r100.length;
        int r103 = 0;
        if (r102 <= 0) goto L17;
        int[] r104 = new int[r102];
        if (r101 != 0) goto L9;
        r104 = Arrays.copyOf(r100, r102);
    L12:
        this.mAutoSizeTextSizesInPx = cleanupAutoSizePresetSizes(r104);
        if (setupAutoSizeUniformPresetSizesConfiguration() == true) goto L19;
        throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(r100));
    L19:
        if (setupAutoSizeText() == false) goto L24;
        autoSizeText();
        return;
    L24:
        return;
    L9:
        DisplayMetrics r105 = INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatTextViewAutoSizeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources());
    L10:
        if (r103 >= r102) goto L12;
        r104[r103] = Math.round(TypedValue.applyDimension(r101, r100[r103], r105));
        r103 = r103 + 1;
        goto L10
    L17:
        this.mHasPresetAutoSizeValues = false;
        goto L19
    }

    public void setTextSizeInternal(int r100, float r101) {
        Context r102 = this.mContext;
        if (r102 != null) goto L5;
        Resources r103 = Resources.getSystem();
    L6:
        setRawTextSize(TypedValue.applyDimension(r100, r101, INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatTextViewAutoSizeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r103)));
        return;
    L5:
        r103 = r102.getResources();
        goto L6
    }

    private static <T> T accessAndReturnWithDefault(Object r100, String r101, T r102) {
        Field r103 = getTextViewField(r101);     // Catch: IllegalAccessException -> L7
        if (r103 != null) goto L5;
        return r102;
    L5:
        return (T) r103.get(r100);
    L8:
        return r102;
    }

    private StaticLayout createStaticLayoutForMeasuringPre16(CharSequence r110, Layout.Alignment r111, int r112) {
        float r100 = ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingMult", Float.valueOf(1.0f))).floatValue();
        float r101 = ((Float) accessAndReturnWithDefault(this.mTextView, "mSpacingAdd", Float.valueOf(0.0f))).floatValue();
        boolean r102 = ((Boolean) accessAndReturnWithDefault(this.mTextView, "mIncludePad", Boolean.TRUE)).booleanValue();
        return new StaticLayout(r110, this.mTempTextPaint, r112, r111, r100, r101, r102);
    }

    private StaticLayout createStaticLayoutForMeasuringPre23(CharSequence r110, Layout.Alignment r111, int r112) {
        float r100 = this.mTextView.getLineSpacingMultiplier();
        float r101 = this.mTextView.getLineSpacingExtra();
        boolean r102 = this.mTextView.getIncludeFontPadding();
        return new StaticLayout(r110, this.mTempTextPaint, r112, r111, r100, r101, r102);
    }

    public static <T> T invokeAndReturnWithDefault(Object r100, String r101, T r102) {
    L12:
        return (T) getTextViewMethod(r101).invoke(r100, new Object[0]);
    L6:
        return r102;
    L4:
        th = move-exception;
        throw th;
    }

    private void validateAndSetAutoSizeTextTypeUniformConfiguration(float r100, float r101, float r102) throws IllegalArgumentException {
        if (r100 <= 0.0f) goto L15;
        if (r101 <= r100) goto L13;
        if (r102 <= 0.0f) goto L11;
        this.mAutoSizeTextType = 1;
        this.mAutoSizeMinTextSizeInPx = r100;
        this.mAutoSizeMaxTextSizeInPx = r101;
        this.mAutoSizeStepGranularityInPx = r102;
        this.mHasPresetAutoSizeValues = false;
        return;
    L11:
        throw new IllegalArgumentException("The auto-size step granularity (" + r102 + "px) is less or equal to (0px)");
    L13:
        throw new IllegalArgumentException("Maximum auto-size text size (" + r101 + "px) is less or equal to minimum auto-size text size (" + r100 + "px)");
    L15:
        throw new IllegalArgumentException("Minimum auto-size text size (" + r100 + "px) is less or equal to (0px)");
    }

    private StaticLayout createStaticLayoutForMeasuring(CharSequence r100, Layout.Alignment r101, int r102, int r103) {
        StaticLayout.Builder r104 = StaticLayout.Builder.obtain(r100, 0, r100.length(), this.mTempTextPaint, r102);
        StaticLayout.Builder r105 = r104.setAlignment(r101).setLineSpacing(this.mTextView.getLineSpacingExtra(), this.mTextView.getLineSpacingMultiplier()).setIncludePad(this.mTextView.getIncludeFontPadding()).setBreakStrategy(this.mTextView.getBreakStrategy()).setHyphenationFrequency(this.mTextView.getHyphenationFrequency());
        if (r103 != (-1)) goto L5;
        r103 = Integer.MAX_VALUE;
    L5:
        r105.setMaxLines(r103);
        this.mImpl.computeAndSetTextDirection(r104, this.mTextView);     // Catch: ClassCastException -> L9
    L8:
        return r104.build();
    }

    public StaticLayout createLayout(CharSequence r100, Layout.Alignment r101, int r102, int r103) {
        if (Build.VERSION.SDK_INT < 23) goto L7;
        return createStaticLayoutForMeasuring(r100, r101, r102, r103);
    L7:
        return createStaticLayoutForMeasuringPre23(r100, r101, r102);
    }

    public void setAutoSizeTextTypeUniformWithConfiguration(int r100, int r101, int r102, int r103) throws IllegalArgumentException {
        if (supportsAutoSizeText() == false) goto L8;
        DisplayMetrics r104 = INVOKEVIRTUAL_androidx_appcompat_widget_AppCompatTextViewAutoSizeHelper_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(this.mContext.getResources());
        validateAndSetAutoSizeTextTypeUniformConfiguration(TypedValue.applyDimension(r103, r100, r104), TypedValue.applyDimension(r103, r101, r104), TypedValue.applyDimension(r103, r102, r104));
        if (setupAutoSizeText() == false) goto L9;
        autoSizeText();
        return;
    L9:
        return;
    }
}
