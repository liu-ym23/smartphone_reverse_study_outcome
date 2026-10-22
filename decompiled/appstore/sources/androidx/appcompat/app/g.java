package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.R$styleable;
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
import androidx.appcompat.widget.y;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.google.common.base.Ascii;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes.dex */
public class g {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final int[] sAccessibilityHeading = null;
    private static final int[] sAccessibilityPaneTitle = null;
    private static final String[] sClassPrefixList = null;
    private static final SimpleArrayMap sConstructorMap = null;
    private static final Class<?>[] sConstructorSignature = null;
    private static final int[] sOnClickAttrs = null;
    private static final int[] sScreenReaderFocusable = null;
    private final Object[] mConstructorArgs;

    public static class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f375a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f376b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public Method f377c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Context f378d;

        public a(View r10, String r11) {
            this.f375a = r10;
            this.f376b = r11;
        }

        public final void a(Context r10) {
        L2:
            if (r10 == null) goto L13;
            if (r10.isRestricted() == true) goto L10;
            Method r11 = r10.getClass().getMethod(this.f376b, new Class[]{View.class});     // Catch: NoSuchMethodException -> L19
            if (r11 == null) goto L10;
            this.f377c = r11;     // Catch: NoSuchMethodException -> L19
            this.f378d = r10;     // Catch: NoSuchMethodException -> L19
            return;
        L10:
            if ((r10 instanceof ContextWrapper) == true) goto L11;
            r10 = null;
            goto L2
        L11:
            r10 = ((ContextWrapper) r10).getBaseContext();
            goto L2
        L13:
            int r12 = this.f375a.getId();
            if (r12 != (-1)) goto L16;
            String r13 = "";
        L18:
            throw new IllegalStateException("Could not find method " + this.f376b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f375a.getClass() + r13);
        L16:
            r13 = " with id '" + this.f375a.getContext().getResources().getResourceEntryName(r12) + "'";
            goto L18
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r10) {
            if (this.f377c != null) goto L15;
            a(this.f375a.getContext());
        L15:
            this.f377c.invoke(this.f378d, new Object[]{r10});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L9
            return;
        L9:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L7:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }
    }

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{R.attr.onClick};
        sAccessibilityHeading = new int[]{R.attr.accessibilityHeading};
        sAccessibilityPaneTitle = new int[]{R.attr.accessibilityPaneTitle};
        sScreenReaderFocusable = new int[]{R.attr.screenReaderFocusable};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    public g() {
        this.mConstructorArgs = new Object[2];
    }

    public static Context e(Context r10, AttributeSet r11, boolean r12, boolean r13) {
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.View, 0, 0);
        if (r12 == false) goto L5;
        int r15 = r14.getResourceId(R$styleable.View_android_theme, 0);
    L6:
        if (r13 == false) goto L11;
        if (r15 != 0) goto L11;
        r15 = r14.getResourceId(R$styleable.View_theme, 0);
        if (r15 == 0) goto L11;
        Log.i(LOG_TAG, "app:theme is now deprecated. Please move to using android:theme instead.");
    L11:
        r14.recycle();
        if (r15 != 0) goto L14;
        return r10;
    L14:
        if ((r10 instanceof g.b) == false) goto L18;
        if (((g.b) r10).getThemeResId() != r15) goto L18;
        return r10;
    L18:
        return new g.b(r10, r15);
    L5:
        r15 = 0;
        goto L6
    }

    public final void a(Context r10, View r11, AttributeSet r12) {
    }

    public final void b(View r10, AttributeSet r11) {
        Context r12 = r10.getContext();
        if ((r12 instanceof ContextWrapper) == true) goto L5;
        return;
    L5:
        if (ViewCompat.O(r10) == false) goto L13;
        TypedArray r13 = r12.obtainStyledAttributes(r11, sOnClickAttrs);
        String r14 = r13.getString(0);
        if (r14 == null) goto L10;
        r10.setOnClickListener(new a(r10, r14));
    L10:
        r13.recycle();
        return;
    }

    public final View c(Context r10, String r11, String r12) {
        SimpleArrayMap r13 = sConstructorMap;
        Constructor r14 = (Constructor) r13.get(r11);
        if (r14 != null) goto L8;
        if (r12 != null) goto L12;
        String r15 = r11;
    L7:
        r14 = Class.forName(r15, false, r10.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);     // Catch: Exception -> L10
        r13.put(r11, r14);     // Catch: Exception -> L10
        goto L8
    L12:
        r15 = r12 + r11;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r14.setAccessible(true);     // Catch: Exception -> L10
        return (View) r14.newInstance(this.mConstructorArgs);
    }

    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r10, AttributeSet r11) {
        return new AppCompatAutoCompleteTextView(r10, r11);
    }

    public AppCompatButton createButton(Context r10, AttributeSet r11) {
        return new AppCompatButton(r10, r11);
    }

    public AppCompatCheckBox createCheckBox(Context r10, AttributeSet r11) {
        return new AppCompatCheckBox(r10, r11);
    }

    @NonNull
    public AppCompatCheckedTextView createCheckedTextView(Context r10, AttributeSet r11) {
        return new AppCompatCheckedTextView(r10, r11);
    }

    @NonNull
    public AppCompatEditText createEditText(Context r10, AttributeSet r11) {
        return new AppCompatEditText(r10, r11);
    }

    @NonNull
    public AppCompatImageButton createImageButton(Context r10, AttributeSet r11) {
        return new AppCompatImageButton(r10, r11);
    }

    @NonNull
    public AppCompatImageView createImageView(Context r10, AttributeSet r11) {
        return new AppCompatImageView(r10, r11);
    }

    @NonNull
    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r10, AttributeSet r11) {
        return new AppCompatMultiAutoCompleteTextView(r10, r11);
    }

    public AppCompatRadioButton createRadioButton(Context r10, AttributeSet r11) {
        return new AppCompatRadioButton(r10, r11);
    }

    @NonNull
    public AppCompatRatingBar createRatingBar(Context r10, AttributeSet r11) {
        return new AppCompatRatingBar(r10, r11);
    }

    @NonNull
    public AppCompatSeekBar createSeekBar(Context r10, AttributeSet r11) {
        return new AppCompatSeekBar(r10, r11);
    }

    @NonNull
    public AppCompatSpinner createSpinner(Context r10, AttributeSet r11) {
        return new AppCompatSpinner(r10, r11);
    }

    public AppCompatTextView createTextView(Context r10, AttributeSet r11) {
        return new AppCompatTextView(r10, r11);
    }

    @NonNull
    public AppCompatToggleButton createToggleButton(Context r10, AttributeSet r11) {
        return new AppCompatToggleButton(r10, r11);
    }

    @Nullable
    public View createView(Context r10, String r11, AttributeSet r12) {
        return null;
    }

    public final View d(Context r10, String r11, AttributeSet r12) {
        if (r11.equals("view") == false) goto L27;
        r11 = r12.getAttributeValue(null, "class");
    L27:
        Object[] r13 = this.mConstructorArgs;     // Catch: Throwable -> L16 Exception -> L25
        r13[0] = r10;     // Catch: Throwable -> L16 Exception -> L25
        r13[1] = r12;     // Catch: Throwable -> L16 Exception -> L25
        if ((-1) != r11.indexOf(46)) goto L20;
        int r14 = 0;
    L9:
        String[] r15 = sClassPrefixList;     // Catch: Throwable -> L16 Exception -> L25
        if (r14 >= r15.length) goto L18;
        View r16 = c(r10, r11, r15[r14]);     // Catch: Throwable -> L16 Exception -> L25
        if (r16 != null) goto L13;
        r14 = r14 + 1;
        goto L9
    L13:
        Object[] r17 = this.mConstructorArgs;
        r17[0] = null;
        r17[1] = null;
        return r16;
    L18:
        Object[] r18 = this.mConstructorArgs;
        r18[0] = null;
        r18[1] = null;
        return null;
    L20:
        View r19 = c(r10, r11, null);     // Catch: Throwable -> L16 Exception -> L25
        Object[] r20 = this.mConstructorArgs;
        r20[0] = null;
        r20[1] = null;
        return r19;
    L25:
        Object[] r21 = this.mConstructorArgs;
        r21[0] = null;
        r21[1] = null;
        return null;
    L16:
        th = move-exception;
        Object[] r22 = this.mConstructorArgs;
        r22[0] = null;
        r22[1] = null;
        throw th;
    }

    public final void f(View r10, String r11) {
        if (r10 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r11 + ">, but returned null");
    }

    @Nullable
    public final View createView(@Nullable View r10, @NonNull String r11, @NonNull Context r12, @NonNull AttributeSet r13, boolean r14, boolean r15, boolean r16, boolean r17) {
        if (r14 == false) goto L5;
        if (r10 == null) goto L5;
        Context r18 = r10.getContext();
    L6:
        if (r15 == true) goto L8;
        if (r16 == true) goto L8;
    L9:
        if (r17 == false) goto L11;
        r18 = y.b(r18);
    L11:
        r11.hashCode();
        byte r19 = -1;
        switch(r11.hashCode()) {
            case -1946472170: goto L67;
            case -1455429095: goto L63;
            case -1346021293: goto L59;
            case -938935918: goto L55;
            case -937446323: goto L51;
            case -658531749: goto L47;
            case -339785223: goto L43;
            case 776382189: goto L39;
            case 799298502: goto L35;
            case 1125864064: goto L31;
            case 1413872058: goto L27;
            case 1601505219: goto L23;
            case 1666676343: goto L19;
            case 2001146706: goto L15;
            default: goto L70;
        };
    L70:
        switch(r19) {
            case 0: goto L85;
            case 1: goto L84;
            case 2: goto L83;
            case 3: goto L82;
            case 4: goto L81;
            case 5: goto L80;
            case 6: goto L79;
            case 7: goto L78;
            case 8: goto L77;
            case 9: goto L76;
            case 10: goto L75;
            case 11: goto L74;
            case 12: goto L73;
            case 13: goto L72;
            default: goto L71;
        };
    L71:
        View r20 = createView(r18, r11, r13);
    L86:
        if (r20 != null) goto L89;
        if (r12 == r18) goto L89;
        r20 = d(r18, r11, r13);
    L89:
        if (r20 == null) goto L91;
        b(r20, r13);
        a(r18, r20, r13);
    L91:
        return r20;
    L72:
        r20 = createButton(r18, r13);
        f(r20, r11);
        goto L86
    L73:
        r20 = createEditText(r18, r13);
        f(r20, r11);
        goto L86
    L74:
        r20 = createCheckBox(r18, r13);
        f(r20, r11);
        goto L86
    L75:
        r20 = createAutoCompleteTextView(r18, r13);
        f(r20, r11);
        goto L86
    L76:
        r20 = createImageView(r18, r13);
        f(r20, r11);
        goto L86
    L77:
        r20 = createToggleButton(r18, r13);
        f(r20, r11);
        goto L86
    L78:
        r20 = createRadioButton(r18, r13);
        f(r20, r11);
        goto L86
    L79:
        r20 = createSpinner(r18, r13);
        f(r20, r11);
        goto L86
    L80:
        r20 = createSeekBar(r18, r13);
        f(r20, r11);
        goto L86
    L81:
        r20 = createImageButton(r18, r13);
        f(r20, r11);
        goto L86
    L82:
        r20 = createTextView(r18, r13);
        f(r20, r11);
        goto L86
    L83:
        r20 = createMultiAutoCompleteTextView(r18, r13);
        f(r20, r11);
        goto L86
    L84:
        r20 = createCheckedTextView(r18, r13);
        f(r20, r11);
        goto L86
    L85:
        r20 = createRatingBar(r18, r13);
        f(r20, r11);
        goto L86
    L15:
        if (r11.equals("Button") == false) goto L70;
        r19 = Ascii.CR;
        goto L70
    L19:
        if (r11.equals("EditText") == false) goto L70;
        r19 = Ascii.FF;
        goto L70
    L23:
        if (r11.equals("CheckBox") == false) goto L70;
        r19 = Ascii.VT;
        goto L70
    L27:
        if (r11.equals("AutoCompleteTextView") == false) goto L70;
        r19 = 10;
        goto L70
    L31:
        if (r11.equals("ImageView") == false) goto L70;
        r19 = 9;
        goto L70
    L35:
        if (r11.equals("ToggleButton") == false) goto L70;
        r19 = 8;
        goto L70
    L39:
        if (r11.equals("RadioButton") == false) goto L70;
        r19 = 7;
        goto L70
    L43:
        if (r11.equals("Spinner") == false) goto L70;
        r19 = 6;
        goto L70
    L47:
        if (r11.equals("SeekBar") == false) goto L70;
        r19 = 5;
        goto L70
    L51:
        if (r11.equals("ImageButton") == false) goto L70;
        r19 = 4;
        goto L70
    L55:
        if (r11.equals("TextView") == false) goto L70;
        r19 = 3;
        goto L70
    L59:
        if (r11.equals("MultiAutoCompleteTextView") == false) goto L70;
        r19 = 2;
        goto L70
    L63:
        if (r11.equals("CheckedTextView") == false) goto L70;
        r19 = 1;
        goto L70
    L67:
        if (r11.equals("RatingBar") == false) goto L70;
        r19 = 0;
    L8:
        r18 = e(r18, r13, r15, r16);
    L5:
        r18 = r12;
        goto L6
    }
}
