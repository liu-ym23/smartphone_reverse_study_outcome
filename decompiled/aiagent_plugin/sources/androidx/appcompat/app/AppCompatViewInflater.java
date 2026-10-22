package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.view.ContextThemeWrapper;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatCheckedTextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatMultiAutoCompleteTextView;
import androidx.appcompat.widget.AppCompatRadioButton;
import androidx.appcompat.widget.AppCompatRatingBar;
import androidx.appcompat.widget.AppCompatSeekBar;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.AppCompatToggleButton;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.ViewCompat;
import com.obric.aiagent.apm.impl.BuildConfig;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes.dex */
public class AppCompatViewInflater {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Class<?>[] f232a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int[] f233b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int[] f234c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f235d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int[] f236e = null;
    private static final String[] f = null;
    private static final androidx.b.g<String, Constructor<? extends View>> g = null;
    private final Object[] h;

    private static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        public DeclaredOnClickListener(View r1, String r2) {
            this.mHostView = r1;
            this.mMethodName = r2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r4) {
            if (this.mResolvedMethod != null) goto L13;
            resolveMethod((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHostView.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"));
        L13:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r4});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L10
            return;
        L10:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L7:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }

        private void resolveMethod(Context r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r7, Context.class, "com.obric.aiagent.plugin");
        L3:
            if (r8 == null) goto L14;
            if (r8.isRestricted() == true) goto L11;
            Method r0 = r8.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L20
            if (r0 == null) goto L11;
            this.mResolvedMethod = r0;     // Catch: NoSuchMethodException -> L20
            this.mResolvedContext = ZeusTransformUtils.wrapperContext(r8, "com.obric.aiagent.plugin");     // Catch: NoSuchMethodException -> L20
            return;
        L11:
            if (ZeusTransformUtils.instanceOf(r8, ContextWrapper.class) == true) goto L12;
            r8 = null;
            goto L3
        L12:
            r8 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(((ContextWrapper) ZeusTransformUtils.preCheckCast(r8, ContextWrapper.class, "com.obric.aiagent.plugin")).getBaseContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
            goto L3
        L14:
            int r9 = this.mHostView.getId();
            if (r9 != (-1)) goto L17;
            String r10 = "";
        L19:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r10);
        L17:
            r10 = " with id '" + ZeusTransformUtils.getResources((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(this.mHostView.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin"), "com.obric.aiagent.plugin").getResourceEntryName(r9) + "'";
            goto L19
        }
    }

    public View a(Context r1, String r2, AttributeSet r3) {
        Context r0 = (Context) ZeusTransformUtils.wrapperContextForParams(r1, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin");
        return null;
    }

    public AppCompatViewInflater() {
        this.h = new Object[2];
    }

    static {
        f232a = new Class[]{Context.class, AttributeSet.class};
        f233b = new int[]{R.attr.onClick};
        f234c = new int[]{R.attr.accessibilityHeading};
        f235d = new int[]{R.attr.accessibilityPaneTitle};
        f236e = new int[]{R.attr.screenReaderFocusable};
        f = new String[]{"android.widget.", "android.view.", "android.webkit."};
        g = new androidx.b.g();
    }

    public final View a(View r3, String r4, Context r5, AttributeSet r6, boolean r7, boolean r8, boolean r9, boolean r10) {
        Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r12 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r6, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r7 == false) goto L6;
        if (r3 == null) goto L6;
        Context r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L7:
        if (r8 == true) goto L9;
        if (r9 == true) goto L9;
    L10:
        if (r10 == false) goto L12;
        r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(TintContextWrapper.wrap(r13), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L12:
        r4.hashCode();
        byte r14 = -1;
        switch(r4.hashCode()) {
            case -1946472170: goto L68;
            case -1455429095: goto L64;
            case -1346021293: goto L60;
            case -938935918: goto L56;
            case -937446323: goto L52;
            case -658531749: goto L48;
            case -339785223: goto L44;
            case 776382189: goto L40;
            case 799298502: goto L36;
            case 1125864064: goto L32;
            case 1413872058: goto L28;
            case 1601505219: goto L24;
            case 1666676343: goto L20;
            case 2001146706: goto L16;
            default: goto L71;
        };
    L71:
        switch(r14) {
            case 0: goto L86;
            case 1: goto L85;
            case 2: goto L84;
            case 3: goto L83;
            case 4: goto L82;
            case 5: goto L81;
            case 6: goto L80;
            case 7: goto L79;
            case 8: goto L78;
            case 9: goto L77;
            case 10: goto L76;
            case 11: goto L75;
            case 12: goto L74;
            case 13: goto L73;
            default: goto L72;
        };
    L72:
        View r15 = a(r13, r4, r12);
    L87:
        if (r15 != null) goto L90;
        if (r11 == r13) goto L90;
        r15 = b(r13, r4, r12);
    L90:
        if (r15 == null) goto L92;
        a(r15, r12);
        a(r13, r15, r12);
    L92:
        return r15;
    L73:
        r15 = c(r13, r12);
        a(r15, r4);
        goto L87
    L74:
        r15 = d(r13, r12);
        a(r15, r4);
        goto L87
    L75:
        r15 = g(r13, r12);
        a(r15, r4);
        goto L87
    L76:
        r15 = j(r13, r12);
        a(r15, r4);
        goto L87
    L77:
        r15 = b(r13, r12);
        a(r15, r4);
        goto L87
    L78:
        r15 = n(r13, r12);
        a(r15, r4);
        goto L87
    L79:
        r15 = h(r13, r12);
        a(r15, r4);
        goto L87
    L80:
        r15 = e(r13, r12);
        a(r15, r4);
        goto L87
    L81:
        r15 = m(r13, r12);
        a(r15, r4);
        goto L87
    L82:
        r15 = f(r13, r12);
        a(r15, r4);
        goto L87
    L83:
        r15 = a(r13, r12);
        a(r15, r4);
        goto L87
    L84:
        r15 = k(r13, r12);
        a(r15, r4);
        goto L87
    L85:
        r15 = i(r13, r12);
        a(r15, r4);
        goto L87
    L86:
        r15 = l(r13, r12);
        a(r15, r4);
        goto L87
    L16:
        if (r4.equals("Button") == false) goto L71;
        r14 = 13;
        goto L71
    L20:
        if (r4.equals("EditText") == false) goto L71;
        r14 = 12;
        goto L71
    L24:
        if (r4.equals("CheckBox") == false) goto L71;
        r14 = 11;
        goto L71
    L28:
        if (r4.equals("AutoCompleteTextView") == false) goto L71;
        r14 = 10;
        goto L71
    L32:
        if (r4.equals("ImageView") == false) goto L71;
        r14 = 9;
        goto L71
    L36:
        if (r4.equals("ToggleButton") == false) goto L71;
        r14 = 8;
        goto L71
    L40:
        if (r4.equals("RadioButton") == false) goto L71;
        r14 = 7;
        goto L71
    L44:
        if (r4.equals("Spinner") == false) goto L71;
        r14 = 6;
        goto L71
    L48:
        if (r4.equals("SeekBar") == false) goto L71;
        r14 = 5;
        goto L71
    L52:
        if (r4.equals("ImageButton") == false) goto L71;
        r14 = 4;
        goto L71
    L56:
        if (r4.equals("TextView") == false) goto L71;
        r14 = 3;
        goto L71
    L60:
        if (r4.equals("MultiAutoCompleteTextView") == false) goto L71;
        r14 = 2;
        goto L71
    L64:
        if (r4.equals("CheckedTextView") == false) goto L71;
        r14 = 1;
        goto L71
    L68:
        if (r4.equals("RatingBar") == false) goto L71;
        r14 = 0;
    L9:
        r13 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(a(r13, r12, r8, r9), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
    L6:
        r13 = r11;
        goto L7
    }

    public AppCompatTextView a(Context r2, AttributeSet r3) {
        return new AppCompatTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatImageView b(Context r2, AttributeSet r3) {
        return new AppCompatImageView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatButton c(Context r2, AttributeSet r3) {
        return new AppCompatButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatEditText d(Context r2, AttributeSet r3) {
        return new AppCompatEditText((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatSpinner e(Context r2, AttributeSet r3) {
        return new AppCompatSpinner((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatImageButton f(Context r2, AttributeSet r3) {
        return new AppCompatImageButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatCheckBox g(Context r2, AttributeSet r3) {
        return new AppCompatCheckBox((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatRadioButton h(Context r2, AttributeSet r3) {
        return new AppCompatRadioButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatCheckedTextView i(Context r2, AttributeSet r3) {
        return new AppCompatCheckedTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatAutoCompleteTextView j(Context r2, AttributeSet r3) {
        return new AppCompatAutoCompleteTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatMultiAutoCompleteTextView k(Context r2, AttributeSet r3) {
        return new AppCompatMultiAutoCompleteTextView((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatRatingBar l(Context r2, AttributeSet r3) {
        return new AppCompatRatingBar((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatSeekBar m(Context r2, AttributeSet r3) {
        return new AppCompatSeekBar((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    public AppCompatToggleButton n(Context r2, AttributeSet r3) {
        return new AppCompatToggleButton((Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.aiagent.plugin"));
    }

    private void a(View r2, String r3) {
        if (r2 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r3 + ">, but returned null");
    }

    private View b(Context r6, String r7, AttributeSet r8) {
        Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r8, AttributeSet.class, "com.obric.aiagent.plugin");
        if (r7.equals("view") == false) goto L26;
        r7 = r10.getAttributeValue(null, "class");
    L26:
        Object[] r3 = this.h;     // Catch: Throwable -> L21 Exception -> L24
        r3[0] = r9;     // Catch: Throwable -> L21 Exception -> L24
        r3[1] = r10;     // Catch: Throwable -> L21 Exception -> L24
        if ((-1) != r7.indexOf(46)) goto L18;
        int r11 = 0;
    L9:
        String[] r4 = f;     // Catch: Throwable -> L21 Exception -> L24
        if (r11 >= r4.length) goto L16;
        View r5 = a(r9, r7, r4[r11]);     // Catch: Throwable -> L21 Exception -> L24
        if (r5 != null) goto L13;
        r11 = r11 + 1;
        goto L9
    L13:
        Object[] r12 = this.h;
        r12[0] = null;
        r12[1] = null;
        return r5;
    L16:
        Object[] r13 = this.h;
        r13[0] = null;
        r13[1] = null;
        return null;
    L18:
        View r14 = a(r9, r7, null);     // Catch: Throwable -> L21 Exception -> L24
        Object[] r15 = this.h;
        r15[0] = null;
        r15[1] = null;
        return r14;
    L24:
        Object[] r16 = this.h;
        r16[0] = null;
        r16[1] = null;
        return null;
    L21:
        th = move-exception;
        Object[] r17 = this.h;
        r17[0] = null;
        r17[1] = null;
        throw th;
    }

    private void a(View r3, AttributeSet r4) {
        AttributeSet r2 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
        Context r5 = (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r3.getContext(), "com.obric.aiagent.plugin"), Context.class, "com.obric.aiagent.plugin");
        if (ZeusTransformUtils.instanceOf(r5, ContextWrapper.class) == true) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 15) goto L7;
    L9:
        TypedArray r6 = r5.obtainStyledAttributes(r2, f233b);
        String r7 = r6.getString(0);
        if (r7 == null) goto L12;
        r3.setOnClickListener(new DeclaredOnClickListener(r3, r7));
    L12:
        r6.recycle();
        return;
    L7:
        if (ViewCompat.J(r3) == true) goto L9;
    }

    private View a(Context r5, String r6, String r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
        androidx.b.g<String, Constructor<? extends View>> r0 = g;
        Constructor<? extends View> r2 = (Constructor) ZeusTransformUtils.preCheckCast(r0.get(r6), Constructor.class, "com.obric.aiagent.plugin");
        if (r2 != null) goto L8;
        if (r7 != null) goto L12;
        String r9 = r6;
    L7:
        r2 = Class.forName(r9, false, r8.getClassLoader()).asSubclass(View.class).getConstructor(f232a);     // Catch: Exception -> L10
        r0.put(r6, r2);     // Catch: Exception -> L10
        goto L8
    L12:
        r9 = r7 + r6;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r2.setAccessible(true);     // Catch: Exception -> L10
        return (View) ZeusTransformUtils.preCheckCast(r2.newInstance(this.h), View.class, "com.obric.aiagent.plugin");
    }

    private static Context a(Context r4, AttributeSet r5, boolean r6, boolean r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
        TypedArray r9 = r8.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin"), com.obric.aiagent.plugin.R.styleable.View, 0, 0);
        if (r6 == false) goto L5;
        int r10 = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.View_android_theme, "styleable", "View_android_theme"), 0);
    L6:
        if (r7 == false) goto L11;
        if (r10 != 0) goto L11;
        r10 = r9.getResourceId(ZeusTransformUtils.mapRes(com.obric.aiagent.plugin.R.styleable.View_theme, "styleable", "View_theme"), 0);
        if (r10 == 0) goto L11;
        a("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
    L11:
        r9.recycle();
        if (r10 != 0) goto L14;
        return r8;
    L14:
        if (ZeusTransformUtils.instanceOf(r8, ContextThemeWrapper.class) == false) goto L18;
        if (((ContextThemeWrapper) ZeusTransformUtils.preCheckCast(r8, ContextThemeWrapper.class, "com.obric.aiagent.plugin")).getThemeResId() != r10) goto L18;
        return r8;
    L18:
        return new ContextThemeWrapper(r8, r10);
    L5:
        r10 = 0;
        goto L6
    }

    private void a(Context r3, View r4, AttributeSet r5) {
        Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
        AttributeSet r6 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r5, AttributeSet.class, "com.obric.aiagent.plugin");
        if (Build.VERSION.SDK_INT >= 19) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT > 28) goto L19;
        TypedArray r7 = r2.obtainStyledAttributes(r6, f234c);
        if (r7.hasValue(0) == false) goto L10;
        ViewCompat.d(r4, r7.getBoolean(0, false));
    L10:
        r7.recycle();
        TypedArray r8 = r2.obtainStyledAttributes(r6, f235d);
        if (r8.hasValue(0) == false) goto L13;
        ViewCompat.b(r4, r8.getString(0));
    L13:
        r8.recycle();
        TypedArray r9 = r2.obtainStyledAttributes(r6, f236e);
        if (r9.hasValue(0) == false) goto L16;
        ViewCompat.c(r4, r9.getBoolean(0, false));
    L16:
        r9.recycle();
        return;
    }

    @Skip({BuildConfig.LIBRARY_PACKAGE_NAME})
    public static int a(String r1, String r2) {
        if (com.obric.aiagent.apm.impl.a.a() == false) goto L5;
        return 0;
    L5:
        return Log.i(r1, r2);
    }
}
