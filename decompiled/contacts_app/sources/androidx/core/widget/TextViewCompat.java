package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.ss.android.http.legacy.protocol.HTTP;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;
    private static final int LINES = 1;
    private static final String LOG_TAG = "TextViewCompat";
    private static Field sMaxModeField;
    private static boolean sMaxModeFieldFetched;
    private static Field sMaximumField;
    private static boolean sMaximumFieldFetched;
    private static Field sMinModeField;
    private static boolean sMinModeFieldFetched;
    private static Field sMinimumField;
    private static boolean sMinimumFieldFetched;

    static class Api16Impl {
        private Api16Impl() {
        }

        static int getMaxLines(TextView r0) {
            return r0.getMaxLines();
        }

        static int getMinLines(TextView r0) {
            return r0.getMinLines();
        }

        static boolean getIncludeFontPadding(TextView r0) {
            return r0.getIncludeFontPadding();
        }
    }

    static class Api17Impl {
        private Api17Impl() {
        }

        static void setCompoundDrawablesRelative(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelative(r1, r2, r3, r4);
        }

        static int getLayoutDirection(View r0) {
            return r0.getLayoutDirection();
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static Drawable[] getCompoundDrawablesRelative(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }

        static void setTextDirection(View r0, int r1) {
            r0.setTextDirection(r1);
        }

        static Locale getTextLocale(TextView r0) {
            return r0.getTextLocale();
        }

        static int getTextDirection(View r0) {
            return r0.getTextDirection();
        }
    }

    static class Api23Impl {
        private Api23Impl() {
        }

        static int getBreakStrategy(TextView r0) {
            return r0.getBreakStrategy();
        }

        static void setBreakStrategy(TextView r0, int r1) {
            r0.setBreakStrategy(r1);
        }

        static int getHyphenationFrequency(TextView r0) {
            return r0.getHyphenationFrequency();
        }

        static void setHyphenationFrequency(TextView r0, int r1) {
            r0.setHyphenationFrequency(r1);
        }

        static PorterDuff.Mode getCompoundDrawableTintMode(TextView r0) {
            return r0.getCompoundDrawableTintMode();
        }

        static ColorStateList getCompoundDrawableTintList(TextView r0) {
            return r0.getCompoundDrawableTintList();
        }

        static void setCompoundDrawableTintList(TextView r0, ColorStateList r1) {
            r0.setCompoundDrawableTintList(r1);
        }

        static void setCompoundDrawableTintMode(TextView r0, PorterDuff.Mode r1) {
            r0.setCompoundDrawableTintMode(r1);
        }
    }

    static class Api24Impl {
        private Api24Impl() {
        }

        static DecimalFormatSymbols getInstance(Locale r0) {
            return DecimalFormatSymbols.getInstance(r0);
        }
    }

    static class Api26Impl {
        private Api26Impl() {
        }

        static void setAutoSizeTextTypeWithDefaults(TextView r0, int r1) {
            r0.setAutoSizeTextTypeWithDefaults(r1);
        }

        static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setAutoSizeTextTypeUniformWithConfiguration(r1, r2, r3, r4);
        }

        static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) {
            r0.setAutoSizeTextTypeUniformWithPresetSizes(r1, r2);
        }

        static int getAutoSizeTextType(TextView r0) {
            return r0.getAutoSizeTextType();
        }

        static int getAutoSizeStepGranularity(TextView r0) {
            return r0.getAutoSizeStepGranularity();
        }

        static int getAutoSizeMinTextSize(TextView r0) {
            return r0.getAutoSizeMinTextSize();
        }

        static int getAutoSizeMaxTextSize(TextView r0) {
            return r0.getAutoSizeMaxTextSize();
        }

        static int[] getAutoSizeTextAvailableSizes(TextView r0) {
            return r0.getAutoSizeTextAvailableSizes();
        }
    }

    static class Api28Impl {
        private Api28Impl() {
        }

        static void setFirstBaselineToTopHeight(TextView r0, int r1) {
            r0.setFirstBaselineToTopHeight(r1);
        }

        static PrecomputedText.Params getTextMetricsParams(TextView r0) {
            return r0.getTextMetricsParams();
        }

        static String[] getDigitStrings(DecimalFormatSymbols r0) {
            return r0.getDigitStrings();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    private static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback r1, TextView r2) {
            this.mCallback = r1;
            this.mTextView = r2;
            this.mInitializedMenuBuilderReferences = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r1, Menu r2) {
            return this.mCallback.onCreateActionMode(r1, r2);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r1, Menu r2) {
            recomputeProcessTextMenuItems(r2);
            return this.mCallback.onPrepareActionMode(r1, r2);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r1, MenuItem r2) {
            return this.mCallback.onActionItemClicked(r1, r2);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r1) {
            this.mCallback.onDestroyActionMode(r1);
        }

        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        private void recomputeProcessTextMenuItems(Menu r9) {
            Context r0 = this.mTextView.getContext();
            PackageManager r1 = r0.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L28;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r2 = Class.forName("com.android.internal.view.menu.MenuBuilder");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r2;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r2.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L28:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r3 = r9.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r4 = r9.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r4 < 0) goto L22;
            MenuItem r6 = r9.getItem(r4);     // Catch: Throwable -> L27
            if (r6.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r6.getIntent().getAction()) == false) goto L21;
            r3.invoke(r9, new Object[]{Integer.valueOf(r4)});     // Catch: Throwable -> L27
        L21:
            r4 = r4 - 1;
            goto L15
        L22:
            List<ResolveInfo> r5 = getSupportedActivities(r0, r1);
            int r7 = 0;
        L24:
            if (r7 >= r5.size()) goto L37;
            ResolveInfo r8 = r5.get(r7);
            r9.add(0, 0, r7 + 100, r8.loadLabel(r1)).setIntent(createProcessTextIntentForResolveInfo(r8, this.mTextView)).setShowAsAction(1);
            r7 = r7 + 1;
            goto L24
        L37:
            return;
        L11:
            if (this.mMenuBuilderClass.isInstance(r9) == false) goto L13;
            r3 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        private List<ResolveInfo> getSupportedActivities(Context r4, PackageManager r5) {
            ArrayList r0 = new ArrayList();
            if ((r4 instanceof Activity) == true) goto L5;
            return r0;
        L5:
            Iterator<ResolveInfo> r6 = r5.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r6.hasNext() == false) goto L11;
            ResolveInfo r1 = r6.next();
            if (isSupportedActivity(r1, r4) == false) goto L7;
            r0.add(r1);
            goto L7
        L11:
            return r0;
        }

        private boolean isSupportedActivity(ResolveInfo r3, Context r4) {
            if (r4.getPackageName().equals(r3.activityInfo.packageName) == false) goto L6;
            return true;
        L6:
            if (r3.activityInfo.exported == true) goto L9;
            return false;
        L9:
            if (r3.activityInfo.permission != null) goto L11;
            return true;
        L11:
            if (r4.checkSelfPermission(r3.activityInfo.permission) != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r2, TextView r3) {
            return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r3)).setClassName(r2.activityInfo.packageName, r2.activityInfo.name);
        }

        private boolean isEditable(TextView r1) {
            if ((r1 instanceof Editable) == true) goto L5;
        L9:
            return false;
        L5:
            if (r1.onCheckIsTextEditor() == false) goto L9;
            if (r1.isEnabled() == false) goto L9;
            return true;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType(HTTP.PLAIN_TEXT_TYPE);
        }
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView r0, ActionMode.Callback r1) {
        return r1;
    }

    private TextViewCompat() {
    }

    private static Field retrieveField(String r3) {
        Field r0 = null;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r0;
    L5:
        Log.e(LOG_TAG, "Could not retrieve " + r3 + " field.");
        return r0;
    }

    private static int retrieveIntFromField(Field r1, TextView r2) {
        return r1.getInt(r2);
    L4:
        Log.d(LOG_TAG, "Could not retrieve value of " + r1.getName() + " field.");
        return -1;
    }

    public static void setCompoundDrawablesRelative(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        Api17Impl.setCompoundDrawablesRelative(r0, r1, r2, r3, r4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r0, r1, r2, r3, r4);
    }

    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r0, int r1, int r2, int r3, int r4) {
        Api17Impl.setCompoundDrawablesRelativeWithIntrinsicBounds(r0, r1, r2, r3, r4);
    }

    public static int getMaxLines(TextView r0) {
        return Api16Impl.getMaxLines(r0);
    }

    public static int getMinLines(TextView r0) {
        return Api16Impl.getMinLines(r0);
    }

    public static void setTextAppearance(TextView r0, int r1) {
        r0.setTextAppearance(r1);
    }

    public static Drawable[] getCompoundDrawablesRelative(TextView r0) {
        return Api17Impl.getCompoundDrawablesRelative(r0);
    }

    public static void setAutoSizeTextTypeWithDefaults(TextView r0, int r1) {
        Api26Impl.setAutoSizeTextTypeWithDefaults(r0, r1);
    }

    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView r0, int r1, int r2, int r3, int r4) throws IllegalArgumentException {
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r0, r1, r2, r3, r4);
    }

    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r0, int[] r1, int r2) throws IllegalArgumentException {
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r0, r1, r2);
    }

    public static int getAutoSizeTextType(TextView r0) {
        return Api26Impl.getAutoSizeTextType(r0);
    }

    public static int getAutoSizeStepGranularity(TextView r0) {
        return Api26Impl.getAutoSizeStepGranularity(r0);
    }

    public static int getAutoSizeMinTextSize(TextView r0) {
        return Api26Impl.getAutoSizeMinTextSize(r0);
    }

    public static int getAutoSizeMaxTextSize(TextView r0) {
        return Api26Impl.getAutoSizeMaxTextSize(r0);
    }

    public static int[] getAutoSizeTextAvailableSizes(TextView r0) {
        return Api26Impl.getAutoSizeTextAvailableSizes(r0);
    }

    public static void setCustomSelectionActionModeCallback(TextView r0, ActionMode.Callback r1) {
        r0.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r0, r1));
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback r1) {
        if ((r1 instanceof OreoCallback) == true) goto L5;
        return r1;
    L5:
        return ((OreoCallback) r1).getWrappedCallback();
    }

    public static void setFirstBaselineToTopHeight(TextView r0, int r1) {
        Preconditions.checkArgumentNonnegative(r1);
        Api28Impl.setFirstBaselineToTopHeight(r0, r1);
    }

    public static void setLastBaselineToBottomHeight(TextView r3, int r4) {
        Preconditions.checkArgumentNonnegative(r4);
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (Api16Impl.getIncludeFontPadding(r3) == false) goto L5;
        int r1 = r0.bottom;
    L7:
        if (r4 <= Math.abs(r1)) goto L10;
        int r5 = r4 - r1;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r5);
        return;
    L10:
        return;
    L5:
        r1 = r0.descent;
        goto L7
    }

    public static int getFirstBaselineToTopHeight(TextView r1) {
        return r1.getPaddingTop() - r1.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView r1) {
        return r1.getPaddingBottom() + r1.getPaint().getFontMetricsInt().bottom;
    }

    public static void setLineHeight(TextView r2, int r3) {
        Preconditions.checkArgumentNonnegative(r3);
        int r0 = r2.getPaint().getFontMetricsInt(null);
        if (r3 == r0) goto L6;
        r2.setLineSpacing(r3 - r0, 1.0f);
        return;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView r1) {
        return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(r1));
    }

    public static void setTextMetricsParams(TextView r2, PrecomputedTextCompat.Params r3) {
        Api17Impl.setTextDirection(r2, getTextDirection(r3.getTextDirection()));
        r2.getPaint().set(r3.getTextPaint());
        Api23Impl.setBreakStrategy(r2, r3.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(r2, r3.getHyphenationFrequency());
    }

    public static void setPrecomputedText(TextView r0, PrecomputedTextCompat r1) {
        r0.setText(r1.getPrecomputedText());
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView r4) {
        if ((r4.getTransformationMethod() instanceof PasswordTransformationMethod) == true) goto L5;
        boolean r2 = false;
        if ((r4.getInputType() & 15) != 3) goto L18;
        byte r5 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(Api17Impl.getTextLocale(r4)))[0].codePointAt(0));
        if (r5 == 1) goto L16;
        if (r5 == 2) goto L16;
        return TextDirectionHeuristics.LTR;
    L16:
        return TextDirectionHeuristics.RTL;
    L18:
        if (Api17Impl.getLayoutDirection(r4) != 1) goto L21;
        r2 = true;
    L21:
        switch(Api17Impl.getTextDirection(r4)) {
            case 2: goto L35;
            case 3: goto L33;
            case 4: goto L31;
            case 5: goto L29;
            case 6: goto L27;
            case 7: goto L25;
            default: goto L22;
        };
    L22:
        if (r2 == false) goto L37;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L37:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L25:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L27:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L29:
        return TextDirectionHeuristics.LOCALE;
    L31:
        return TextDirectionHeuristics.RTL;
    L33:
        return TextDirectionHeuristics.LTR;
    L35:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L5:
        return TextDirectionHeuristics.LTR;
    }

    private static int getTextDirection(TextDirectionHeuristic r2) {
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
        return 1;
    L6:
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L9;
        return 1;
    L9:
        if (r2 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r2 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r2 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r2 != TextDirectionHeuristics.LOCALE) goto L25;
        return 5;
    L25:
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L29;
        return 6;
    L29:
        if (r2 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L32;
        return 7;
    L32:
        return 1;
    }

    public static void setCompoundDrawableTintList(TextView r0, ColorStateList r1) {
        Preconditions.checkNotNull(r0);
        Api23Impl.setCompoundDrawableTintList(r0, r1);
    }

    public static ColorStateList getCompoundDrawableTintList(TextView r0) {
        Preconditions.checkNotNull(r0);
        return Api23Impl.getCompoundDrawableTintList(r0);
    }

    public static void setCompoundDrawableTintMode(TextView r0, PorterDuff.Mode r1) {
        Preconditions.checkNotNull(r0);
        Api23Impl.setCompoundDrawableTintMode(r0, r1);
    }

    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView r0) {
        Preconditions.checkNotNull(r0);
        return Api23Impl.getCompoundDrawableTintMode(r0);
    }
}
