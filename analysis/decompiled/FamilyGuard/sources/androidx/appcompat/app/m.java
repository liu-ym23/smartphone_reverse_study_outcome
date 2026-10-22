package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.appcompat.widget.A;
import androidx.appcompat.widget.C0434d;
import androidx.appcompat.widget.C0436f;
import androidx.appcompat.widget.C0437g;
import androidx.appcompat.widget.C0438h;
import androidx.appcompat.widget.C0442l;
import androidx.appcompat.widget.C0446p;
import androidx.appcompat.widget.C0448s;
import androidx.appcompat.widget.C0451v;
import androidx.appcompat.widget.C0452w;
import androidx.appcompat.widget.C0454y;
import androidx.appcompat.widget.D;
import androidx.appcompat.widget.F;
import androidx.appcompat.widget.X;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public class m {

    /* renamed from: b, reason: collision with root package name */
    private static final Class<?>[] f7643b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    private static final int[] f7644c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    private static final int[] f7645d = {R.attr.accessibilityHeading};

    /* renamed from: e, reason: collision with root package name */
    private static final int[] f7646e = {R.attr.accessibilityPaneTitle};

    /* renamed from: f, reason: collision with root package name */
    private static final int[] f7647f = {R.attr.screenReaderFocusable};

    /* renamed from: g, reason: collision with root package name */
    private static final String[] f7648g = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: h, reason: collision with root package name */
    private static final q.i<String, Constructor<? extends View>> f7649h = new q.i<>();

    /* renamed from: a, reason: collision with root package name */
    private final Object[] f7650a = new Object[2];

    private static class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        private final View f7651a;

        /* renamed from: b, reason: collision with root package name */
        private final String f7652b;

        /* renamed from: c, reason: collision with root package name */
        private Method f7653c;

        /* renamed from: d, reason: collision with root package name */
        private Context f7654d;

        public a(View view, String str) {
            this.f7651a = view;
            this.f7652b = str;
        }

        private void a(Context context) {
            String str;
            Method method;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(this.f7652b, View.class)) != null) {
                        this.f7653c = method;
                        this.f7654d = context;
                        return;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id = this.f7651a.getId();
            if (id == -1) {
                str = BuildConfig.FLAVOR;
            } else {
                str = " with id '" + this.f7651a.getContext().getResources().getResourceEntryName(id) + "'";
            }
            throw new IllegalStateException("Could not find method " + this.f7652b + "(View) in a parent or ancestor Context for android:onClick attribute defined on view " + this.f7651a.getClass() + str);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (this.f7653c == null) {
                a(this.f7651a.getContext());
            }
            try {
                this.f7653c.invoke(this.f7654d, view);
            } catch (IllegalAccessException e6) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e6);
            } catch (InvocationTargetException e7) {
                throw new IllegalStateException("Could not execute method for android:onClick", e7);
            }
        }
    }

    private void a(Context context, View view, AttributeSet attributeSet) {
    }

    private void b(View view, AttributeSet attributeSet) {
        Context context = view.getContext();
        if ((context instanceof ContextWrapper) && view.hasOnClickListeners()) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f7644c);
            String string = typedArrayObtainStyledAttributes.getString(0);
            if (string != null) {
                view.setOnClickListener(new a(view, string));
            }
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    private View s(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        String str3;
        q.i<String, Constructor<? extends View>> iVar = f7649h;
        Constructor<? extends View> constructor = iVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    str3 = str2 + str;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                str3 = str;
            }
            constructor = Class.forName(str3, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f7643b);
            iVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f7650a);
    }

    private View t(Context context, String str, AttributeSet attributeSet) {
        if (str.equals("view")) {
            str = attributeSet.getAttributeValue(null, "class");
        }
        try {
            Object[] objArr = this.f7650a;
            objArr[0] = context;
            objArr[1] = attributeSet;
            if (-1 != str.indexOf(46)) {
                return s(context, str, null);
            }
            int i5 = 0;
            while (true) {
                String[] strArr = f7648g;
                if (i5 >= strArr.length) {
                    return null;
                }
                View viewS = s(context, str, strArr[i5]);
                if (viewS != null) {
                    return viewS;
                }
                i5++;
            }
        } catch (Exception unused) {
            return null;
        } finally {
            Object[] objArr2 = this.f7650a;
            objArr2[0] = null;
            objArr2[1] = null;
        }
    }

    private static Context u(Context context, AttributeSet attributeSet, boolean z5, boolean z6) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.f17213x3, 0, 0);
        int resourceId = z5 ? typedArrayObtainStyledAttributes.getResourceId(g.j.f17218y3, 0) : 0;
        if (z6 && resourceId == 0 && (resourceId = typedArrayObtainStyledAttributes.getResourceId(g.j.f17223z3, 0)) != 0) {
            Log.i("AppCompatViewInflater", "app:theme is now deprecated. Please move to using android:theme instead.");
        }
        typedArrayObtainStyledAttributes.recycle();
        return (resourceId == 0 || ((context instanceof androidx.appcompat.view.d) && ((androidx.appcompat.view.d) context).c() == resourceId)) ? context : new androidx.appcompat.view.d(context, resourceId);
    }

    private void v(View view, String str) {
        if (view != null) {
            return;
        }
        throw new IllegalStateException(getClass().getName() + " asked to inflate view for <" + str + ">, but returned null");
    }

    protected C0434d c(Context context, AttributeSet attributeSet) {
        return new C0434d(context, attributeSet);
    }

    protected C0436f d(Context context, AttributeSet attributeSet) {
        return new C0436f(context, attributeSet);
    }

    protected C0437g e(Context context, AttributeSet attributeSet) {
        return new C0437g(context, attributeSet);
    }

    protected C0438h f(Context context, AttributeSet attributeSet) {
        return new C0438h(context, attributeSet);
    }

    protected C0442l g(Context context, AttributeSet attributeSet) {
        return new C0442l(context, attributeSet);
    }

    protected C0446p h(Context context, AttributeSet attributeSet) {
        return new C0446p(context, attributeSet);
    }

    protected androidx.appcompat.widget.r i(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.r(context, attributeSet);
    }

    protected C0448s j(Context context, AttributeSet attributeSet) {
        return new C0448s(context, attributeSet);
    }

    protected C0451v k(Context context, AttributeSet attributeSet) {
        return new C0451v(context, attributeSet);
    }

    protected C0452w l(Context context, AttributeSet attributeSet) {
        return new C0452w(context, attributeSet);
    }

    protected C0454y m(Context context, AttributeSet attributeSet) {
        return new C0454y(context, attributeSet);
    }

    protected A n(Context context, AttributeSet attributeSet) {
        return new A(context, attributeSet);
    }

    protected D o(Context context, AttributeSet attributeSet) {
        return new D(context, attributeSet);
    }

    protected F p(Context context, AttributeSet attributeSet) {
        return new F(context, attributeSet);
    }

    protected View q(Context context, String str, AttributeSet attributeSet) {
        return null;
    }

    public final View r(View view, String str, Context context, AttributeSet attributeSet, boolean z5, boolean z6, boolean z7, boolean z8) {
        Context context2;
        View viewL;
        context2 = (!z5 || view == null) ? context : view.getContext();
        if (z6 || z7) {
            context2 = u(context2, attributeSet, z6, z7);
        }
        if (z8) {
            context2 = X.b(context2);
        }
        str.getClass();
        switch (str) {
            case "RatingBar":
                viewL = l(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckedTextView":
                viewL = f(context2, attributeSet);
                v(viewL, str);
                break;
            case "MultiAutoCompleteTextView":
                viewL = j(context2, attributeSet);
                v(viewL, str);
                break;
            case "TextView":
                viewL = o(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageButton":
                viewL = h(context2, attributeSet);
                v(viewL, str);
                break;
            case "SeekBar":
                viewL = m(context2, attributeSet);
                v(viewL, str);
                break;
            case "Spinner":
                viewL = n(context2, attributeSet);
                v(viewL, str);
                break;
            case "RadioButton":
                viewL = k(context2, attributeSet);
                v(viewL, str);
                break;
            case "ToggleButton":
                viewL = p(context2, attributeSet);
                v(viewL, str);
                break;
            case "ImageView":
                viewL = i(context2, attributeSet);
                v(viewL, str);
                break;
            case "AutoCompleteTextView":
                viewL = c(context2, attributeSet);
                v(viewL, str);
                break;
            case "CheckBox":
                viewL = e(context2, attributeSet);
                v(viewL, str);
                break;
            case "EditText":
                viewL = g(context2, attributeSet);
                v(viewL, str);
                break;
            case "Button":
                viewL = d(context2, attributeSet);
                v(viewL, str);
                break;
            default:
                viewL = q(context2, str, attributeSet);
                break;
        }
        if (viewL == null && context != context2) {
            viewL = t(context2, str, attributeSet);
        }
        if (viewL != null) {
            b(viewL, attributeSet);
            a(context2, viewL, attributeSet);
        }
        return viewL;
    }
}
