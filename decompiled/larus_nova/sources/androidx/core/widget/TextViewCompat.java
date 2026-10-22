package androidx.core.widget;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.icu.text.DecimalFormatSymbols;
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.annotation.ReplaceWith;
import androidx.core.text.PrecomputedTextCompat;
import androidx.core.util.Preconditions;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes3.dex */
public final class TextViewCompat {
    public static final int AUTO_SIZE_TEXT_TYPE_NONE = 0;
    public static final int AUTO_SIZE_TEXT_TYPE_UNIFORM = 1;

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api23Impl {
        private Api23Impl() {
        }

        public static int getBreakStrategy(TextView r100) {
            return r100.getBreakStrategy();
        }

        public static ColorStateList getCompoundDrawableTintList(TextView r100) {
            return r100.getCompoundDrawableTintList();
        }

        public static PorterDuff.Mode getCompoundDrawableTintMode(TextView r100) {
            return r100.getCompoundDrawableTintMode();
        }

        public static int getHyphenationFrequency(TextView r100) {
            return r100.getHyphenationFrequency();
        }

        public static void setBreakStrategy(TextView r100, int r101) {
            r100.setBreakStrategy(r101);
        }

        public static void setCompoundDrawableTintList(TextView r100, ColorStateList r101) {
            r100.setCompoundDrawableTintList(r101);
        }

        public static void setCompoundDrawableTintMode(TextView r100, PorterDuff.Mode r101) {
            r100.setCompoundDrawableTintMode(r101);
        }

        public static void setHyphenationFrequency(TextView r100, int r101) {
            r100.setHyphenationFrequency(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api24Impl {
        private Api24Impl() {
        }

        public static DecimalFormatSymbols getInstance(Locale r100) {
            return DecimalFormatSymbols.getInstance(r100);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api26Impl {
        private Api26Impl() {
        }

        public static int getAutoSizeMaxTextSize(TextView r100) {
            return r100.getAutoSizeMaxTextSize();
        }

        public static int getAutoSizeMinTextSize(TextView r100) {
            return r100.getAutoSizeMinTextSize();
        }

        public static int getAutoSizeStepGranularity(TextView r100) {
            return r100.getAutoSizeStepGranularity();
        }

        public static int[] getAutoSizeTextAvailableSizes(TextView r100) {
            return r100.getAutoSizeTextAvailableSizes();
        }

        public static int getAutoSizeTextType(TextView r100) {
            return r100.getAutoSizeTextType();
        }

        public static void setAutoSizeTextTypeWithDefaults(TextView r100, int r101) {
            r100.setAutoSizeTextTypeWithDefaults(r101);
        }

        public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r100, int[] r101, int r102) {
            r100.setAutoSizeTextTypeUniformWithPresetSizes(r101, r102);
        }

        public static void setAutoSizeTextTypeUniformWithConfiguration(TextView r100, int r101, int r102, int r103, int r104) {
            r100.setAutoSizeTextTypeUniformWithConfiguration(r101, r102, r103, r104);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api28Impl {
        public static CharSequence castToCharSequence(PrecomputedText r100) {
            return r100;
        }

        private Api28Impl() {
        }

        public static String[] getDigitStrings(DecimalFormatSymbols r100) {
            return r100.getDigitStrings();
        }

        public static PrecomputedText.Params getTextMetricsParams(TextView r100) {
            return r100.getTextMetricsParams();
        }

        public static void setFirstBaselineToTopHeight(TextView r100, int r101) {
            r100.setFirstBaselineToTopHeight(r101);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class Api34Impl {
        private Api34Impl() {
        }

        public static void setLineHeight(TextView r100, int r101, float r102) {
            r100.setLineHeight(r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes17.dex */
    @Retention(RetentionPolicy.SOURCE)
    public @interface AutoSizeTextType {
    }

    /* JADX INFO: loaded from: classes17.dex */
    public static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
            return Class.forName(r100);
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }

        public ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
        public static Class INVOKESTATIC_androidx_core_widget_TextViewCompat$OreoCallback_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
            ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
            FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
            if (el9.a.a() == true) goto L34;
            Class r103 = access$000(r100);     // Catch: Throwable -> L8
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
        L7:
            return r103;
        L8:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
            FastClassNotFoundHandler.b(r100);
        L12:
            throw th;
        L34:
            Class r104 = access$000(r100);     // Catch: Throwable -> L17
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
            FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
        L16:
            return r104;
        L17:
            th = move-exception;
            if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
            FastClassNotFoundHandler.b(r100);
        L22:
            if ((th instanceof PluginClassNotFoundException) == false) goto L24;
            throw th;
        L24:
            if ((th instanceof ClassNotFoundException) == true) goto L30;
            if ((th instanceof NoClassDefFoundError) == true) goto L30;
            throw th;
        L30:
            return MiraPluginFix.forName(r100);
        }

        private boolean isEditable(TextView r100) {
            if ((r100 instanceof Editable) == true) goto L5;
        L9:
            return false;
        L5:
            if (r100.onCheckIsTextEditor() == false) goto L9;
            if (r100.isEnabled() == false) goto L9;
            return true;
        }

        private void recomputeProcessTextMenuItems(Menu r100) {
            Context r101 = this.mTextView.getContext();
            PackageManager r102 = r101.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L28;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r103 = INVOKESTATIC_androidx_core_widget_TextViewCompat$OreoCallback_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.android.internal.view.menu.MenuBuilder");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r103;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r103.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L28:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r104 = r100.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r105 = r100.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r105 < 0) goto L22;
            MenuItem r106 = r100.getItem(r105);     // Catch: Throwable -> L27
            if (r106.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r106.getIntent().getAction()) == false) goto L21;
            r104.invoke(r100, new Object[]{Integer.valueOf(r105)});     // Catch: Throwable -> L27
        L21:
            r105 = r105 - 1;
            goto L15
        L22:
            List<ResolveInfo> r107 = getSupportedActivities(r101, r102);
            int r108 = 0;
        L24:
            if (r108 >= r107.size()) goto L37;
            ResolveInfo r109 = (ResolveInfo) ListProtector.get(r107, r108);
            r100.add(0, 0, r108 + 100, r109.loadLabel(r102)).setIntent(createProcessTextIntentForResolveInfo(r109, this.mTextView)).setShowAsAction(1);
            r108 = r108 + 1;
            goto L24
        L37:
            return;
        L11:
            if (this.mMenuBuilderClass.isInstance(r100) == false) goto L13;
            r104 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r100) {
            this.mCallback.onDestroyActionMode(r100);
        }

        public OreoCallback(ActionMode.Callback r100, TextView r101) {
            this.mCallback = r100;
            this.mTextView = r101;
            this.mInitializedMenuBuilderReferences = false;
        }

        private static int androidx_core_widget_TextViewCompat$OreoCallback_android_content_Context_checkSelfPermission(Context r110, String r111) {
            ArrayList r100 = new ArrayList();
            Object[] r101 = {r111};
            f06.b r112 = new f06.b("auto_cert_androidx_core_widget_TextViewCompat$OreoCallback_android_content_Context_checkSelfPermission");
            g06.a r102 = ApiHookConfig.f245611b.get(102608);
            if (r102 == null) goto L5;
            f06.a[] r103 = r102.f479473i;
        L6:
            f06.a[] r113 = r103;
            int r104 = r113.length;
            int r105 = 0;
        L8:
            if (r105 >= r104) goto L15;
            f06.a r106 = r113[r105];
            int r114 = r105;
            int r115 = r104;
            f06.d r107 = r106.preInvoke(102608, "android/content/Context", "checkSelfPermission", r110, r101, "int", r112);     // Catch: Exception -> L22
            if (r107.f474982a == true) goto L17;
            r100.add(r106);     // Catch: Exception -> L22
        L17:
            if (r107.f474982a == false) goto L21;
            return ((Integer) r107.f474983b).intValue();
        L21:
            return r110.checkSelfPermission(r111);
        L14:
            r105 = r114 + 1;
            r104 = r115;
            goto L8
        L15:
            r107 = new f06.d(false, null);
            goto L17
        L5:
            r103 = ApiHookConfig.f245613d;
            goto L6
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r100, TextView r101) {
            Intent r102 = createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r101));
            ActivityInfo r103 = r100.activityInfo;
            return r102.setClassName(r103.packageName, r103.name);
        }

        private List<ResolveInfo> getSupportedActivities(Context r100, PackageManager r101) {
            ArrayList r102 = new ArrayList();
            if ((r100 instanceof Activity) == true) goto L5;
            return r102;
        L5:
            Iterator<ResolveInfo> r103 = r101.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r103.hasNext() == false) goto L11;
            ResolveInfo r104 = r103.next();
            if (isSupportedActivity(r104, r100) == false) goto L7;
            r102.add(r104);
            goto L7
        L11:
            return r102;
        }

        private boolean isSupportedActivity(ResolveInfo r100, Context r101) {
            if (r101.getPackageName().equals(r100.activityInfo.packageName) == false) goto L5;
            return true;
        L5:
            ActivityInfo r102 = r100.activityInfo;
            if (r102.exported == true) goto L8;
            return false;
        L8:
            String r103 = r102.permission;
            if (r103 != null) goto L11;
            return true;
        L11:
            if (androidx_core_widget_TextViewCompat$OreoCallback_android_content_Context_checkSelfPermission(r101, r103) == 0) goto L16;
            return false;
        L16:
            return true;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
            return this.mCallback.onActionItemClicked(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r100, Menu r101) {
            return this.mCallback.onCreateActionMode(r100, r101);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r100, Menu r101) {
            recomputeProcessTextMenuItems(r101);
            return this.mCallback.onPrepareActionMode(r100, r101);
        }
    }

    private TextViewCompat() {
    }

    public static DisplayMetrics INVOKEVIRTUAL_androidx_core_widget_TextViewCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMaxTextSize(TextView r100) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMaxTextSize(r100);
    L7:
        if ((r100 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r100).getAutoSizeMaxTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeMinTextSize(TextView r100) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeMinTextSize(r100);
    L7:
        if ((r100 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r100).getAutoSizeMinTextSize();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeStepGranularity(TextView r100) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeStepGranularity(r100);
    L7:
        if ((r100 instanceof AutoSizeableTextView) == true) goto L9;
        return -1;
    L9:
        return ((AutoSizeableTextView) r100).getAutoSizeStepGranularity();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int[] getAutoSizeTextAvailableSizes(TextView r100) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextAvailableSizes(r100);
    L7:
        if ((r100 instanceof AutoSizeableTextView) == false) goto L11;
        return ((AutoSizeableTextView) r100).getAutoSizeTextAvailableSizes();
    L11:
        return new int[0];
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static int getAutoSizeTextType(TextView r100) {
        if (Build.VERSION.SDK_INT < 27) goto L7;
        return Api26Impl.getAutoSizeTextType(r100);
    L7:
        if ((r100 instanceof AutoSizeableTextView) == true) goto L9;
        return 0;
    L9:
        return ((AutoSizeableTextView) r100).getAutoSizeTextType();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static ColorStateList getCompoundDrawableTintList(TextView r100) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintList(r100);
    L7:
        if ((r100 instanceof TintableCompoundDrawablesView) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) r100).getSupportCompoundDrawablesTintList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static PorterDuff.Mode getCompoundDrawableTintMode(TextView r100) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 24) goto L7;
        return Api23Impl.getCompoundDrawableTintMode(r100);
    L7:
        if ((r100 instanceof TintableCompoundDrawablesView) == true) goto L9;
        return null;
    L9:
        return ((TintableCompoundDrawablesView) r100).getSupportCompoundDrawablesTintMode();
    }

    @ReplaceWith(expression = "textView.getCompoundDrawablesRelative()")
    public static Drawable[] getCompoundDrawablesRelative(TextView r100) {
        return r100.getCompoundDrawablesRelative();
    }

    public static int getFirstBaselineToTopHeight(TextView r100) {
        return r100.getPaddingTop() - r100.getPaint().getFontMetricsInt().top;
    }

    public static int getLastBaselineToBottomHeight(TextView r100) {
        return r100.getPaddingBottom() + r100.getPaint().getFontMetricsInt().bottom;
    }

    @ReplaceWith(expression = "textView.getMaxLines()")
    public static int getMaxLines(TextView r100) {
        return r100.getMaxLines();
    }

    @ReplaceWith(expression = "textView.getMinLines()")
    public static int getMinLines(TextView r100) {
        return r100.getMinLines();
    }

    private static int getTextDirection(TextDirectionHeuristic r100) {
        if (r100 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
        return 1;
    L6:
        if (r100 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L9;
        return 1;
    L9:
        if (r100 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r100 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r100 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r100 != TextDirectionHeuristics.LOCALE) goto L25;
        return 5;
    L25:
        if (r100 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L29;
        return 6;
    L29:
        if (r100 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L32;
        return 7;
    L32:
        return 1;
    }

    private static TextDirectionHeuristic getTextDirectionHeuristic(TextView r100) {
        if ((r100.getTransformationMethod() instanceof PasswordTransformationMethod) == true) goto L5;
        boolean r101 = false;
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if ((r100.getInputType() & 15) != 3) goto L20;
        byte r102 = Character.getDirectionality(Api28Impl.getDigitStrings(Api24Impl.getInstance(r100.getTextLocale()))[0].codePointAt(0));
        if (r102 == 1) goto L18;
        if (r102 == 2) goto L18;
        return TextDirectionHeuristics.LTR;
    L18:
        return TextDirectionHeuristics.RTL;
    L20:
        if (r100.getLayoutDirection() != 1) goto L23;
        r101 = true;
    L23:
        switch(r100.getTextDirection()) {
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            default: goto L24;
        };
    L24:
        if (r101 == false) goto L39;
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L39:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L27:
        return TextDirectionHeuristics.FIRSTSTRONG_RTL;
    L29:
        return TextDirectionHeuristics.FIRSTSTRONG_LTR;
    L31:
        return TextDirectionHeuristics.LOCALE;
    L33:
        return TextDirectionHeuristics.RTL;
    L35:
        return TextDirectionHeuristics.LTR;
    L37:
        return TextDirectionHeuristics.ANYRTL_LTR;
    L5:
        return TextDirectionHeuristics.LTR;
    }

    public static PrecomputedTextCompat.Params getTextMetricsParams(TextView r100) {
        int r101 = Build.VERSION.SDK_INT;
        if (r101 >= 28) goto L5;
        PrecomputedTextCompat.Params.Builder r102 = new PrecomputedTextCompat.Params.Builder(new TextPaint(r100.getPaint()));
        if (r101 < 23) goto L9;
        r102.setBreakStrategy(Api23Impl.getBreakStrategy(r100));
        r102.setHyphenationFrequency(Api23Impl.getHyphenationFrequency(r100));
    L9:
        r102.setTextDirection(getTextDirectionHeuristic(r100));
        return r102.build();
    L5:
        return new PrecomputedTextCompat.Params(Api28Impl.getTextMetricsParams(r100));
    }

    public static ActionMode.Callback unwrapCustomSelectionActionModeCallback(ActionMode.Callback r100) {
        if ((r100 instanceof OreoCallback) == true) goto L5;
        return r100;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return r100;
    L7:
        return ((OreoCallback) r100).getWrappedCallback();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeWithDefaults(TextView r100, int r101) {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeWithDefaults(r100, r101);
        return;
    L6:
        if ((r100 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r100).setAutoSizeTextTypeWithDefaults(r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintList(TextView r100, ColorStateList r101) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintList(r100, r101);
        return;
    L6:
        if ((r100 instanceof TintableCompoundDrawablesView) == false) goto L10;
        ((TintableCompoundDrawablesView) r100).setSupportCompoundDrawablesTintList(r101);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setCompoundDrawableTintMode(TextView r100, PorterDuff.Mode r101) {
        Preconditions.checkNotNull(r100);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        Api23Impl.setCompoundDrawableTintMode(r100, r101);
        return;
    L6:
        if ((r100 instanceof TintableCompoundDrawablesView) == false) goto L10;
        ((TintableCompoundDrawablesView) r100).setSupportCompoundDrawablesTintMode(r101);
        return;
    }

    @ReplaceWith(expression = "textView.setCustomSelectionActionModeCallback(callback)")
    public static void setCustomSelectionActionModeCallback(TextView r100, ActionMode.Callback r101) {
        r100.setCustomSelectionActionModeCallback(wrapCustomSelectionActionModeCallback(r100, r101));
    }

    public static void setFirstBaselineToTopHeight(TextView r100, int r101) {
        Preconditions.checkArgumentNonnegative(r101);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        Api28Impl.setFirstBaselineToTopHeight(r100, r101);
        return;
    L6:
        Paint.FontMetricsInt r102 = r100.getPaint().getFontMetricsInt();
        if (r100.getIncludeFontPadding() == false) goto L9;
        int r103 = r102.top;
    L11:
        if (r101 <= Math.abs(r103)) goto L14;
        int r104 = r101 + r103;
        r100.setPadding(r100.getPaddingLeft(), r104, r100.getPaddingRight(), r100.getPaddingBottom());
        return;
    L14:
        return;
    L9:
        r103 = r102.ascent;
        goto L11
    }

    public static void setLastBaselineToBottomHeight(TextView r100, int r101) {
        Preconditions.checkArgumentNonnegative(r101);
        Paint.FontMetricsInt r102 = r100.getPaint().getFontMetricsInt();
        if (r100.getIncludeFontPadding() == false) goto L5;
        int r103 = r102.bottom;
    L7:
        if (r101 <= Math.abs(r103)) goto L10;
        int r104 = r101 - r103;
        r100.setPadding(r100.getPaddingLeft(), r100.getPaddingTop(), r100.getPaddingRight(), r104);
        return;
    L10:
        return;
    L5:
        r103 = r102.descent;
        goto L7
    }

    public static void setLineHeight(TextView r100, int r101) {
        Preconditions.checkArgumentNonnegative(r101);
        int r102 = r100.getPaint().getFontMetricsInt(null);
        if (r101 == r102) goto L6;
        r100.setLineSpacing(r101 - r102, 1.0f);
        return;
    }

    public static void setPrecomputedText(TextView r100, PrecomputedTextCompat r101) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r100.setText(Api28Impl.castToCharSequence(r101.getPrecomputedText()));
        return;
    L6:
        if (getTextMetricsParams(r100).equalsWithoutTextDirection(r101.getParams()) == false) goto L10;
        r100.setText(r101);
        return;
    L10:
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    public static void setTextAppearance(TextView r100, int r101) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r100.setTextAppearance(r101);
        return;
    L5:
        r100.setTextAppearance(r100.getContext(), r101);
    }

    public static void setTextMetricsParams(TextView r100, PrecomputedTextCompat.Params r101) {
        r100.setTextDirection(getTextDirection(r101.getTextDirection()));
        if (Build.VERSION.SDK_INT >= 23) goto L8;
        float r102 = r101.getTextPaint().getTextScaleX();
        r100.getPaint().set(r101.getTextPaint());
        if (r102 != r100.getTextScaleX()) goto L7;
        r100.setTextScaleX((r102 / 2.0f) + 1.0f);
    L7:
        r100.setTextScaleX(r102);
        return;
    L8:
        r100.getPaint().set(r101.getTextPaint());
        Api23Impl.setBreakStrategy(r100, r101.getBreakStrategy());
        Api23Impl.setHyphenationFrequency(r100, r101.getHyphenationFrequency());
    }

    public static ActionMode.Callback wrapCustomSelectionActionModeCallback(TextView r100, ActionMode.Callback r101) {
        int r102 = Build.VERSION.SDK_INT;
        if (r102 >= 26) goto L5;
    L12:
        return r101;
    L5:
        if (r102 > 27) goto L12;
        if ((r101 instanceof OreoCallback) == true) goto L12;
        if (r101 == null) goto L12;
        return new OreoCallback(r101, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithPresetSizes(TextView r100, int[] r101, int r102) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithPresetSizes(r100, r101, r102);
        return;
    L6:
        if ((r100 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r100).setAutoSizeTextTypeUniformWithPresetSizes(r101, r102);
        return;
    }

    public static void setLineHeight(TextView r100, int r101, float r102) {
        if (Build.VERSION.SDK_INT < 34) goto L5;
        Api34Impl.setLineHeight(r100, r101, r102);
        return;
    L5:
        setLineHeight(r100, Math.round(TypedValue.applyDimension(r101, r102, INVOKEVIRTUAL_androidx_core_widget_TextViewCompat_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()))));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void setAutoSizeTextTypeUniformWithConfiguration(TextView r100, int r101, int r102, int r103, int r104) throws IllegalArgumentException {
        if (Build.VERSION.SDK_INT < 27) goto L6;
        Api26Impl.setAutoSizeTextTypeUniformWithConfiguration(r100, r101, r102, r103, r104);
        return;
    L6:
        if ((r100 instanceof AutoSizeableTextView) == false) goto L10;
        ((AutoSizeableTextView) r100).setAutoSizeTextTypeUniformWithConfiguration(r101, r102, r103, r104);
        return;
    }

    @ReplaceWith(expression = "textView.setCompoundDrawablesRelative(start, top, end, bottom)")
    public static void setCompoundDrawablesRelative(TextView r100, Drawable r101, Drawable r102, Drawable r103, Drawable r104) {
        r100.setCompoundDrawablesRelative(r101, r102, r103, r104);
    }

    @ReplaceWith(expression = "textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)")
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r100, int r101, int r102, int r103, int r104) {
        r100.setCompoundDrawablesRelativeWithIntrinsicBounds(r101, r102, r103, r104);
    }

    @ReplaceWith(expression = "textView.setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)")
    public static void setCompoundDrawablesRelativeWithIntrinsicBounds(TextView r100, Drawable r101, Drawable r102, Drawable r103, Drawable r104) {
        r100.setCompoundDrawablesRelativeWithIntrinsicBounds(r101, r102, r103, r104);
    }
}
