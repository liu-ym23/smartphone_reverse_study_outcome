package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.InflateException;
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
import androidx.collection.SimpleArrayMap;
import androidx.core.view.ViewCompat;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes2.dex */
public class AppCompatViewInflater {
    private static final String LOG_TAG = "AppCompatViewInflater";
    private static final String[] sClassPrefixList = null;
    private static final SimpleArrayMap<String, Constructor<? extends View>> sConstructorMap = null;
    private static final Class<?>[] sConstructorSignature = null;
    private static final int[] sOnClickAttrs = null;
    private final Object[] mConstructorArgs;

    public static class DeclaredOnClickListener implements View.OnClickListener {
        private final View mHostView;
        private final String mMethodName;
        private Context mResolvedContext;
        private Method mResolvedMethod;

        private void resolveMethod(Context r100) {
        L2:
            if (r100 == null) goto L14;
            if (r100.isRestricted() == true) goto L11;
            Method r101 = r100.getClass().getMethod(this.mMethodName, new Class[]{View.class});     // Catch: NoSuchMethodException -> L9
            if (r101 == null) goto L11;
            this.mResolvedMethod = r101;     // Catch: NoSuchMethodException -> L9
            this.mResolvedContext = r100;     // Catch: NoSuchMethodException -> L9
            return;
        L11:
            if ((r100 instanceof ContextWrapper) == true) goto L12;
            r100 = null;
            goto L2
        L12:
            r100 = ((ContextWrapper) r100).getBaseContext();
            goto L2
        L14:
            int r102 = this.mHostView.getId();
            if (r102 != (-1)) goto L17;
            String r103 = "";
        L19:
            throw new IllegalStateException("Could not find method " + this.mMethodName + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.mHostView.getClass() + r103);
        L17:
            r103 = " with id '" + this.mHostView.getContext().getResources().getResourceEntryName(r102) + "'";
            goto L19
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View r100) {
            if (this.mResolvedMethod != null) goto L13;
            resolveMethod(this.mHostView.getContext());
        L13:
            this.mResolvedMethod.invoke(this.mResolvedContext, new Object[]{r100});     // Catch: InvocationTargetException -> L7 IllegalAccessException -> L10
            return;
        L10:
            e = move-exception;
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e);
        L7:
            e = move-exception;
            throw new IllegalStateException("Could not execute method for android:onClick", e);
        }

        public DeclaredOnClickListener(View r100, String r101) {
            this.mHostView = r100;
            this.mMethodName = r101;
        }
    }

    static {
        sConstructorSignature = new Class[]{Context.class, AttributeSet.class};
        sOnClickAttrs = new int[]{R.attr.onClick};
        sClassPrefixList = new String[]{"android.widget.", "android.view.", "android.webkit."};
        sConstructorMap = new SimpleArrayMap();
    }

    public static /* synthetic */ Class access$000(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        return Class.forName(r100, r101, r102);
    }

    public View createView(Context r100, String r101, AttributeSet r102) {
        return null;
    }

    public AppCompatViewInflater() {
        this.mConstructorArgs = new Object[2];
    }

    private void checkOnClickListener(View r100, AttributeSet r101) {
        Context r102 = r100.getContext();
        if ((r102 instanceof ContextWrapper) == true) goto L5;
        return;
    L5:
        if (ViewCompat.hasOnClickListeners(r100) == false) goto L13;
        TypedArray r103 = r102.obtainStyledAttributes(r101, sOnClickAttrs);
        String r104 = r103.getString(0);
        if (r104 == null) goto L10;
        r100.setOnClickListener(new DeclaredOnClickListener(r100, r104));
    L10:
        r103.recycle();
        return;
    }

    private void verifyNotNull(View r100, String r101) {
        if (r100 == null) goto L5;
        return;
    L5:
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + r101 + ">, but returned null");
    }

    public AppCompatAutoCompleteTextView createAutoCompleteTextView(Context r100, AttributeSet r101) {
        return new AppCompatAutoCompleteTextView(r100, r101);
    }

    public AppCompatButton createButton(Context r100, AttributeSet r101) {
        return new AppCompatButton(r100, r101);
    }

    public AppCompatCheckBox createCheckBox(Context r100, AttributeSet r101) {
        return new AppCompatCheckBox(r100, r101);
    }

    public AppCompatCheckedTextView createCheckedTextView(Context r100, AttributeSet r101) {
        return new AppCompatCheckedTextView(r100, r101);
    }

    public AppCompatEditText createEditText(Context r100, AttributeSet r101) {
        return new AppCompatEditText(r100, r101);
    }

    public AppCompatImageButton createImageButton(Context r100, AttributeSet r101) {
        return new AppCompatImageButton(r100, r101);
    }

    public AppCompatImageView createImageView(Context r100, AttributeSet r101) {
        return new AppCompatImageView(r100, r101);
    }

    public AppCompatMultiAutoCompleteTextView createMultiAutoCompleteTextView(Context r100, AttributeSet r101) {
        return new AppCompatMultiAutoCompleteTextView(r100, r101);
    }

    public AppCompatRadioButton createRadioButton(Context r100, AttributeSet r101) {
        return new AppCompatRadioButton(r100, r101);
    }

    public AppCompatRatingBar createRatingBar(Context r100, AttributeSet r101) {
        return new AppCompatRatingBar(r100, r101);
    }

    public AppCompatSeekBar createSeekBar(Context r100, AttributeSet r101) {
        return new AppCompatSeekBar(r100, r101);
    }

    public AppCompatSpinner createSpinner(Context r100, AttributeSet r101) {
        return new AppCompatSpinner(r100, r101);
    }

    public AppCompatTextView createTextView(Context r100, AttributeSet r101) {
        return new AppCompatTextView(r100, r101);
    }

    public AppCompatToggleButton createToggleButton(Context r100, AttributeSet r101) {
        return new AppCompatToggleButton(r100, r101);
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_androidx_appcompat_app_AppCompatViewInflater_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100, boolean r101, ClassLoader r102) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r103 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r104 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r105 = access$000(r100, r101, r102);     // Catch: Throwable -> L8
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r105;
    L8:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class r106 = access$000(r100, r101, r102);     // Catch: Throwable -> L17
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r106;
    L17:
        th = move-exception;
        if (r104 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
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

    private View createViewByPrefix(Context r100, String r101, String r102) throws ClassNotFoundException, InflateException {
        SimpleArrayMap<String, Constructor<? extends View>> r103 = sConstructorMap;
        Constructor<? extends View> r104 = r103.get(r101);
        if (r104 != null) goto L8;
        if (r102 != null) goto L12;
        String r105 = r101;
    L7:
        r104 = INVOKESTATIC_androidx_appcompat_app_AppCompatViewInflater_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(r105, false, r100.getClassLoader()).asSubclass(View.class).getConstructor(sConstructorSignature);     // Catch: Exception -> L10
        r103.put(r101, r104);     // Catch: Exception -> L10
        goto L8
    L12:
        r105 = r102 + r101;     // Catch: Exception -> L10
    L10:
        return null;
    L8:
        r104.setAccessible(true);     // Catch: Exception -> L10
        return r104.newInstance(this.mConstructorArgs);
    }

    private View createViewFromTag(Context r100, String r101, AttributeSet r102) {
        if (r101.equals("view") == false) goto L26;
        r101 = r102.getAttributeValue(null, "class");
    L26:
        Object[] r103 = this.mConstructorArgs;     // Catch: Throwable -> L21 Exception -> L24
        r103[0] = r100;     // Catch: Throwable -> L21 Exception -> L24
        r103[1] = r102;     // Catch: Throwable -> L21 Exception -> L24
        if ((-1) != r101.indexOf(46)) goto L18;
        int r104 = 0;
    L9:
        String[] r105 = sClassPrefixList;     // Catch: Throwable -> L21 Exception -> L24
        if (r104 >= r105.length) goto L16;
        View r106 = createViewByPrefix(r100, r101, r105[r104]);     // Catch: Throwable -> L21 Exception -> L24
        if (r106 != null) goto L13;
        r104 = r104 + 1;
        goto L9
    L13:
        Object[] r107 = this.mConstructorArgs;
        r107[0] = null;
        r107[1] = null;
        return r106;
    L16:
        Object[] r108 = this.mConstructorArgs;
        r108[0] = null;
        r108[1] = null;
        return null;
    L18:
        View r109 = createViewByPrefix(r100, r101, null);     // Catch: Throwable -> L21 Exception -> L24
        Object[] r110 = this.mConstructorArgs;
        r110[0] = null;
        r110[1] = null;
        return r109;
    L24:
        Object[] r111 = this.mConstructorArgs;
        r111[0] = null;
        r111[1] = null;
        return null;
    L21:
        th = move-exception;
        Object[] r112 = this.mConstructorArgs;
        r112[0] = null;
        r112[1] = null;
        throw th;
    }

    private static Context themifyContext(Context r100, AttributeSet r101, boolean r102, boolean r103) {
        TypedArray r104 = r100.obtainStyledAttributes(r101, new int[]{R.attr.theme, R.attr.focusable, com.larus.nova.R.attr.paddingEnd, com.larus.nova.R.attr.paddingStart, com.larus.nova.R.attr.theme}, 0, 0);
        if (r102 == false) goto L5;
        int r105 = r104.getResourceId(0, 0);
    L6:
        if (r103 == false) goto L9;
        if (r105 != 0) goto L9;
        r105 = r104.getResourceId(4, 0);
    L9:
        r104.recycle();
        if (r105 != 0) goto L12;
        return r100;
    L12:
        if ((r100 instanceof ContextThemeWrapper) == false) goto L16;
        if (((ContextThemeWrapper) r100).getThemeResId() != r105) goto L16;
        return r100;
    L16:
        return new ContextThemeWrapper(r100, r105);
    L5:
        r105 = 0;
        goto L6
    }

    public final View createView(View r100, String r101, Context r102, AttributeSet r103, boolean r104, boolean r105, boolean r106, boolean r107) {
        if (r104 == false) goto L5;
        if (r100 == null) goto L5;
        Context r108 = r100.getContext();
    L6:
        if (r105 == true) goto L8;
        if (r106 == true) goto L8;
    L9:
        if (r107 == false) goto L11;
        r108 = TintContextWrapper.wrap(r108);
    L11:
        r101.getClass();
        byte r109 = -1;
        switch(r101.hashCode()) {
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
        switch(r109) {
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
        View r110 = createView(r108, r101, r103);
    L86:
        if (r110 != null) goto L89;
        if (r102 == r108) goto L89;
        r110 = createViewFromTag(r108, r101, r103);
    L89:
        if (r110 == null) goto L91;
        checkOnClickListener(r110, r103);
    L91:
        return r110;
    L72:
        r110 = createButton(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L73:
        r110 = createEditText(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L74:
        r110 = createCheckBox(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L75:
        r110 = createAutoCompleteTextView(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L76:
        r110 = createImageView(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L77:
        r110 = createToggleButton(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L78:
        r110 = createRadioButton(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L79:
        r110 = createSpinner(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L80:
        r110 = createSeekBar(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L81:
        r110 = createImageButton(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L82:
        r110 = createTextView(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L83:
        r110 = createMultiAutoCompleteTextView(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L84:
        r110 = createCheckedTextView(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L85:
        r110 = createRatingBar(r108, r103);
        verifyNotNull(r110, r101);
        goto L86
    L15:
        if (r101.equals("Button") == false) goto L70;
        r109 = HTTP.CR;
        goto L70
    L19:
        if (r101.equals("EditText") == false) goto L70;
        r109 = 12;
        goto L70
    L23:
        if (r101.equals("CheckBox") == false) goto L70;
        r109 = 11;
        goto L70
    L27:
        if (r101.equals("AutoCompleteTextView") == false) goto L70;
        r109 = 10;
        goto L70
    L31:
        if (r101.equals("ImageView") == false) goto L70;
        r109 = 9;
        goto L70
    L35:
        if (r101.equals("ToggleButton") == false) goto L70;
        r109 = 8;
        goto L70
    L39:
        if (r101.equals("RadioButton") == false) goto L70;
        r109 = 7;
        goto L70
    L43:
        if (r101.equals("Spinner") == false) goto L70;
        r109 = 6;
        goto L70
    L47:
        if (r101.equals("SeekBar") == false) goto L70;
        r109 = 5;
        goto L70
    L51:
        if (r101.equals("ImageButton") == false) goto L70;
        r109 = 4;
        goto L70
    L55:
        if (r101.equals("TextView") == false) goto L70;
        r109 = 3;
        goto L70
    L59:
        if (r101.equals("MultiAutoCompleteTextView") == false) goto L70;
        r109 = 2;
        goto L70
    L63:
        if (r101.equals("CheckedTextView") == false) goto L70;
        r109 = 1;
        goto L70
    L67:
        if (r101.equals("RatingBar") == false) goto L70;
        r109 = 0;
    L8:
        r108 = themifyContext(r108, r103, r105, r106);
    L5:
        r108 = r102;
        goto L6
    }
}
