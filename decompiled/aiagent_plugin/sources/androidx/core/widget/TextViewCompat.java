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
import android.os.Build;
import android.text.Editable;
import android.text.PrecomputedText;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import androidx.core.text.PrecomputedTextCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public final class TextViewCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Field f1535a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f1536b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Field f1537c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f1538d;

    private static class OreoCallback implements ActionMode.Callback {
        private static final int MENU_ITEM_ORDER_PROCESS_TEXT_INTENT_ACTIONS_START = 100;
        private final ActionMode.Callback mCallback;
        private boolean mCanUseMenuBuilderReferences;
        private boolean mInitializedMenuBuilderReferences;
        private Class<?> mMenuBuilderClass;
        private Method mMenuBuilderRemoveItemAtMethod;
        private final TextView mTextView;

        OreoCallback(ActionMode.Callback r3, TextView r4) {
            this.mCallback = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
            this.mTextView = r4;
            this.mInitializedMenuBuilderReferences = false;
        }

        @Override // android.view.ActionMode.Callback
        public boolean onCreateActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            return this.mCallback.onCreateActionMode(r3, r5);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onPrepareActionMode(ActionMode r3, Menu r4) {
            Menu r5 = (Menu) ZeusTransformUtils.wrapperContextForParams(r4, Menu.class, "com.obric.aiagent.plugin");
            recomputeProcessTextMenuItems(r5);
            return this.mCallback.onPrepareActionMode(r3, r5);
        }

        @Override // android.view.ActionMode.Callback
        public boolean onActionItemClicked(ActionMode r3, MenuItem r4) {
            MenuItem r5 = (MenuItem) ZeusTransformUtils.wrapperContextForParams(r4, MenuItem.class, "com.obric.aiagent.plugin");
            return this.mCallback.onActionItemClicked(r3, r5);
        }

        @Override // android.view.ActionMode.Callback
        public void onDestroyActionMode(ActionMode r1) {
            this.mCallback.onDestroyActionMode(r1);
        }

        ActionMode.Callback getWrappedCallback() {
            return this.mCallback;
        }

        private void recomputeProcessTextMenuItems(Menu r10) {
            Menu r11 = (Menu) ZeusTransformUtils.wrapperContextForParams(r10, Menu.class, "com.obric.aiagent.plugin");
            Context r0 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mTextView.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            PackageManager r2 = r0.getPackageManager();
            if (this.mInitializedMenuBuilderReferences == true) goto L30;
            this.mInitializedMenuBuilderReferences = true;
            Class<?> r3 = ZeusTransformUtils.forName("com.android.internal.view.menu.MenuBuilder", "com.obric.aiagent.plugin");     // Catch: Throwable -> L7
            this.mMenuBuilderClass = r3;     // Catch: Throwable -> L7
            this.mMenuBuilderRemoveItemAtMethod = r3.getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L7
            this.mCanUseMenuBuilderReferences = true;     // Catch: Throwable -> L7
        L7:
            this.mMenuBuilderClass = null;
            this.mMenuBuilderRemoveItemAtMethod = null;
            this.mCanUseMenuBuilderReferences = false;
        L30:
            if (this.mCanUseMenuBuilderReferences == true) goto L11;
        L13:
            Method r4 = r11.getClass().getDeclaredMethod("removeItemAt", new Class[]{Integer.TYPE});     // Catch: Throwable -> L27
        L14:
            int r5 = r11.size() - 1;     // Catch: Throwable -> L27
        L15:
            if (r5 < 0) goto L22;
            MenuItem r7 = r11.getItem(r5);     // Catch: Throwable -> L27
            if (r7.getIntent() == null) goto L21;
            if ("android.intent.action.PROCESS_TEXT".equals(r7.getIntent().getAction()) == false) goto L21;
            r4.invoke(r11, new Object[]{Integer.valueOf(r5)});     // Catch: Throwable -> L27
        L21:
            r5 = r5 - 1;
            goto L15
        L22:
            List<ResolveInfo> r1 = getSupportedActivities(r0, r2);
            int r6 = 0;
        L24:
            if (r6 >= r1.size()) goto L37;
            ResolveInfo r8 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r1.get(r6), ResolveInfo.class, "com.obric.aiagent.plugin");
            r11.add(0, 0, r6 + 100, r8.loadLabel(r2)).setIntent(createProcessTextIntentForResolveInfo(r8, this.mTextView)).setShowAsAction(1);
            r6 = r6 + 1;
            goto L24
        L37:
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(this.mMenuBuilderClass, r11) == false) goto L13;
            r4 = this.mMenuBuilderRemoveItemAtMethod;     // Catch: Throwable -> L27
        }

        private List<ResolveInfo> getSupportedActivities(Context r5, PackageManager r6) {
            Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            ArrayList r0 = new ArrayList();
            if (ZeusTransformUtils.instanceOf(r7, Activity.class) == true) goto L5;
            return r0;
        L5:
            Iterator<ResolveInfo> r8 = r6.queryIntentActivities(createProcessTextIntent(), 0).iterator();
        L7:
            if (r8.hasNext() == false) goto L11;
            ResolveInfo r2 = (ResolveInfo) ZeusTransformUtils.preCheckCast(r8.next(), ResolveInfo.class, "com.obric.aiagent.plugin");
            if (isSupportedActivity(r2, r7) == false) goto L7;
            r0.add(r2);
            goto L7
        L11:
            return r0;
        }

        private boolean isSupportedActivity(ResolveInfo r3, Context r4) {
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if (r2.getPackageName().equals(r3.activityInfo.packageName) == false) goto L6;
            return true;
        L6:
            if (r3.activityInfo.exported == true) goto L9;
            return false;
        L9:
            if (r3.activityInfo.permission != null) goto L11;
            return true;
        L11:
            if (r2.checkSelfPermission(r3.activityInfo.permission) != 0) goto L14;
            return true;
        L14:
            return false;
        }

        private Intent createProcessTextIntentForResolveInfo(ResolveInfo r2, TextView r3) {
            return createProcessTextIntent().putExtra("android.intent.extra.PROCESS_TEXT_READONLY", !isEditable(r3)).setClassName(r2.activityInfo.packageName, r2.activityInfo.name);
        }

        private boolean isEditable(TextView r1) {
            if (ZeusTransformUtils.instanceOf(r1, Editable.class) == true) goto L5;
        L9:
            return false;
        L5:
            if (r1.onCheckIsTextEditor() == false) goto L9;
            if (r1.isEnabled() == false) goto L9;
            return true;
        }

        private Intent createProcessTextIntent() {
            return new Intent().setAction("android.intent.action.PROCESS_TEXT").setType("text/plain");
        }
    }

    static class a {
        static int a(TextView r0) {
            return r0.getMaxLines();
        }

        static int b(TextView r0) {
            return r0.getMinLines();
        }

        static boolean c(TextView r0) {
            return r0.getIncludeFontPadding();
        }
    }

    static class b {
        static void a(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelative(r1, r2, r3, r4);
        }

        static int a(View r0) {
            return r0.getLayoutDirection();
        }

        static void b(TextView r0, Drawable r1, Drawable r2, Drawable r3, Drawable r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static void a(TextView r0, int r1, int r2, int r3, int r4) {
            r0.setCompoundDrawablesRelativeWithIntrinsicBounds(r1, r2, r3, r4);
        }

        static Drawable[] a(TextView r0) {
            return r0.getCompoundDrawablesRelative();
        }

        static void a(View r0, int r1) {
            r0.setTextDirection(r1);
        }

        static Locale b(TextView r0) {
            return r0.getTextLocale();
        }

        static int b(View r0) {
            return r0.getTextDirection();
        }
    }

    static class c {
        static int a(TextView r0) {
            return r0.getBreakStrategy();
        }

        static void a(TextView r0, int r1) {
            r0.setBreakStrategy(r1);
        }

        static int b(TextView r0) {
            return r0.getHyphenationFrequency();
        }

        static void b(TextView r0, int r1) {
            r0.setHyphenationFrequency(r1);
        }

        static PorterDuff.Mode c(TextView r0) {
            return r0.getCompoundDrawableTintMode();
        }

        static ColorStateList d(TextView r0) {
            return r0.getCompoundDrawableTintList();
        }

        static void a(TextView r0, ColorStateList r1) {
            r0.setCompoundDrawableTintList(r1);
        }

        static void a(TextView r0, PorterDuff.Mode r1) {
            r0.setCompoundDrawableTintMode(r1);
        }
    }

    static class d {
        static DecimalFormatSymbols a(Locale r0) {
            return DecimalFormatSymbols.getInstance(r0);
        }
    }

    static class e {
        static CharSequence a(PrecomputedText r0) {
            return r0;
        }

        static void a(TextView r0, int r1) {
            r0.setFirstBaselineToTopHeight(r1);
        }

        static PrecomputedText.Params a(TextView r0) {
            return r0.getTextMetricsParams();
        }

        static String[] a(DecimalFormatSymbols r0) {
            return r0.getDigitStrings();
        }
    }

    private static Field a(String r3) {
        Field r0 = null;
        r0 = TextView.class.getDeclaredField(r3);     // Catch: NoSuchFieldException -> L5
        r0.setAccessible(true);     // Catch: NoSuchFieldException -> L5
        return r0;
    L5:
        a("TextViewCompat", "Could not retrieve " + r3 + " field.");
        return r0;
    }

    private static int a(Field r1, TextView r2) {
        return r1.getInt(r2);
    L4:
        b("TextViewCompat", "Could not retrieve value of " + r1.getName() + " field.");
        return -1;
    }

    public static void a(TextView r2, Drawable r3, Drawable r4, Drawable r5, Drawable r6) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        b.a(r2, r3, r4, r5, r6);
        return;
    L6:
        if (Build.VERSION.SDK_INT < 17) goto L18;
        boolean r1 = true;
        if (b.a(r2) == 1) goto L11;
        r1 = false;
    L11:
        if (r1 == false) goto L13;
        Drawable r0 = r5;
    L14:
        if (r1 == true) goto L17;
        r3 = r5;
    L17:
        r2.setCompoundDrawables(r0, r4, r3, r6);
        return;
    L13:
        r0 = r3;
        goto L14
    L18:
        r2.setCompoundDrawables(r3, r4, r5, r6);
    }

    public static int a(TextView r2) {
        if (Build.VERSION.SDK_INT < 16) goto L7;
        return a.a(r2);
    L7:
        if (f1538d == true) goto L9;
        f1537c = a("mMaxMode");
        f1538d = true;
    L9:
        Field r0 = f1537c;
        if (r0 != null) goto L12;
        return -1;
    L12:
        if (a(r0, r2) == 1) goto L14;
        return -1;
    L14:
        if (f1536b == true) goto L16;
        f1535a = a("mMaximum");
        f1536b = true;
    L16:
        Field r1 = f1535a;
        if (r1 != null) goto L19;
        return -1;
    L19:
        return a(r1, r2);
    }

    public static void a(TextView r3, int r4) {
        if (Build.VERSION.SDK_INT < 23) goto L5;
        r3.setTextAppearance(r4);
        return;
    L5:
        r3.setTextAppearance((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), r4);
    }

    public static Drawable[] b(TextView r4) {
        if (Build.VERSION.SDK_INT < 18) goto L7;
        return b.a(r4);
    L7:
        if (Build.VERSION.SDK_INT < 17) goto L17;
        boolean r1 = true;
        if (b.a(r4) == 1) goto L12;
        r1 = false;
    L12:
        Drawable[] r5 = r4.getCompoundDrawables();
        if (r1 == false) goto L15;
        Drawable r2 = r5[2];
        Drawable r3 = r5[0];
        r5[0] = r2;
        r5[2] = r3;
    L15:
        return r5;
    L17:
        return r4.getCompoundDrawables();
    }

    public static ActionMode.Callback a(TextView r2, ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 26) goto L5;
    L12:
        return r4;
    L5:
        if (Build.VERSION.SDK_INT > 27) goto L12;
        if (ZeusTransformUtils.instanceOf(r4, OreoCallback.class) == true) goto L12;
        if (r4 == null) goto L12;
        return new OreoCallback(r4, r2);
    }

    public static ActionMode.Callback a(ActionMode.Callback r3) {
        ActionMode.Callback r4 = (ActionMode.Callback) ZeusTransformUtils.wrapperContextForParams(r3, ActionMode.Callback.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r4, OreoCallback.class) == true) goto L5;
        return r4;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return r4;
    L7:
        return ((OreoCallback) ZeusTransformUtils.preCheckCast(r4, OreoCallback.class, "com.obric.aiagent.plugin")).getWrappedCallback();
    }

    public static void b(TextView r3, int r4) {
        androidx.core.util.g.a(r4);
        if (Build.VERSION.SDK_INT < 28) goto L6;
        e.a(r3, r4);
        return;
    L6:
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) goto L9;
    L12:
        int r1 = r0.top;
    L14:
        if (r4 <= Math.abs(r1)) goto L17;
        int r5 = r4 + r1;
        r3.setPadding(r3.getPaddingLeft(), r5, r3.getPaddingRight(), r3.getPaddingBottom());
        return;
    L17:
        return;
    L9:
        if (a.c(r3) == true) goto L12;
        r1 = r0.ascent;
        goto L14
    }

    public static void c(TextView r3, int r4) {
        androidx.core.util.g.a(r4);
        Paint.FontMetricsInt r0 = r3.getPaint().getFontMetricsInt();
        if (Build.VERSION.SDK_INT >= 16) goto L5;
    L8:
        int r1 = r0.bottom;
    L10:
        if (r4 <= Math.abs(r1)) goto L13;
        int r5 = r4 - r1;
        r3.setPadding(r3.getPaddingLeft(), r3.getPaddingTop(), r3.getPaddingRight(), r5);
        return;
    L13:
        return;
    L5:
        if (a.c(r3) == true) goto L8;
        r1 = r0.descent;
        goto L10
    }

    public static int c(TextView r1) {
        return r1.getPaddingTop() - r1.getPaint().getFontMetricsInt().top;
    }

    public static int d(TextView r1) {
        return r1.getPaddingBottom() + r1.getPaint().getFontMetricsInt().bottom;
    }

    public static void d(TextView r2, int r3) {
        androidx.core.util.g.a(r3);
        int r0 = r2.getPaint().getFontMetricsInt(null);
        if (r3 == r0) goto L6;
        r2.setLineSpacing(r3 - r0, 1.0f);
        return;
    }

    public static PrecomputedTextCompat.b e(TextView r3) {
        if (Build.VERSION.SDK_INT >= 28) goto L5;
        PrecomputedTextCompat.b.a r0 = new PrecomputedTextCompat.b.a(new TextPaint(r3.getPaint()));
        if (Build.VERSION.SDK_INT < 23) goto L10;
        r0.a(c.a(r3));
        r0.b(c.b(r3));
    L10:
        if (Build.VERSION.SDK_INT < 18) goto L13;
        r0.a(f(r3));
    L13:
        return r0.a();
    L5:
        return new PrecomputedTextCompat.b(e.a(r3));
    }

    public static void a(TextView r2, PrecomputedTextCompat.b r3) {
        if (Build.VERSION.SDK_INT < 18) goto L6;
        b.a(r2, a(r3.b()));
    L6:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        float r0 = r3.a().getTextScaleX();
        r2.getPaint().set(r3.a());
        if (r0 != r2.getTextScaleX()) goto L10;
        r2.setTextScaleX((r0 / 2.0f) + 1.0f);
    L10:
        r2.setTextScaleX(r0);
        return;
    L11:
        r2.getPaint().set(r3.a());
        c.a(r2, r3.c());
        c.b(r2, r3.d());
    }

    public static void a(TextView r2, PrecomputedTextCompat r3) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        r2.setText(e.a(r3.getPrecomputedText()));
        return;
    L6:
        if (e(r2).a(r3.getParams()) == false) goto L10;
        r2.setText(r3);
        return;
    L10:
        throw new IllegalArgumentException("Given text can not be applied to TextView.");
    }

    private static TextDirectionHeuristic f(TextView r4) {
        if (ZeusTransformUtils.instanceOf(r4.getTransformationMethod(), PasswordTransformationMethod.class) == true) goto L5;
        boolean r2 = false;
        if (Build.VERSION.SDK_INT < 28) goto L20;
        if ((r4.getInputType() & 15) != 3) goto L20;
        byte r5 = Character.getDirectionality(e.a(d.a(b.b(r4)))[0].codePointAt(0));
        if (r5 == 1) goto L18;
        if (r5 == 2) goto L18;
        return TextDirectionHeuristics.LTR;
    L18:
        return TextDirectionHeuristics.RTL;
    L20:
        if (b.a(r4) != 1) goto L23;
        r2 = true;
    L23:
        switch(b.b(r4)) {
            case 2: goto L37;
            case 3: goto L35;
            case 4: goto L33;
            case 5: goto L31;
            case 6: goto L29;
            case 7: goto L27;
            default: goto L24;
        };
    L24:
        if (r2 == false) goto L39;
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

    private static int a(TextDirectionHeuristic r2) {
        TextDirectionHeuristic r3 = (TextDirectionHeuristic) ZeusTransformUtils.wrapperContextForParams(r2, TextDirectionHeuristic.class, "com.obric.aiagent.plugin");
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L6;
        return 1;
    L6:
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L9;
        return 1;
    L9:
        if (r3 != TextDirectionHeuristics.ANYRTL_LTR) goto L13;
        return 2;
    L13:
        if (r3 != TextDirectionHeuristics.LTR) goto L17;
        return 3;
    L17:
        if (r3 != TextDirectionHeuristics.RTL) goto L21;
        return 4;
    L21:
        if (r3 != TextDirectionHeuristics.LOCALE) goto L25;
        return 5;
    L25:
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_LTR) goto L29;
        return 6;
    L29:
        if (r3 != TextDirectionHeuristics.FIRSTSTRONG_RTL) goto L32;
        return 7;
    L32:
        return 1;
    }

    public static void a(TextView r2, ColorStateList r3) {
        androidx.core.util.g.a(r2);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        c.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L10;
        ((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin")).setSupportCompoundDrawablesTintList(r3);
        return;
    }

    public static void a(TextView r2, PorterDuff.Mode r3) {
        androidx.core.util.g.a(r2);
        if (Build.VERSION.SDK_INT < 24) goto L6;
        c.a(r2, r3);
        return;
    L6:
        if (ZeusTransformUtils.instanceOf(r2, k.class) == false) goto L10;
        ((k) ZeusTransformUtils.preCheckCast(r2, k.class, "com.obric.aiagent.plugin")).setSupportCompoundDrawablesTintMode(r3);
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int b(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.d(r1, r2);
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r0, String r1) {
        return Log.e(r0, r1);
    }
}
