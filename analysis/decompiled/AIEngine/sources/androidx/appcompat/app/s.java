package androidx.appcompat.app;

import android.R;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class s {

    /* renamed from: b, reason: collision with root package name */
    public static final Class<?>[] f352b = {Context.class, AttributeSet.class};

    /* renamed from: c, reason: collision with root package name */
    public static final int[] f353c = {R.attr.onClick};

    /* renamed from: d, reason: collision with root package name */
    public static final String[] f354d = {"android.widget.", "android.view.", "android.webkit."};

    /* renamed from: e, reason: collision with root package name */
    public static final p.o<String, Constructor<? extends View>> f355e = new p.o<>();

    /* renamed from: a, reason: collision with root package name */
    public final Object[] f356a = new Object[2];

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a implements View.OnClickListener {

        /* renamed from: a, reason: collision with root package name */
        public final View f357a;

        /* renamed from: b, reason: collision with root package name */
        public final String f358b;

        /* renamed from: c, reason: collision with root package name */
        public Method f359c;

        /* renamed from: d, reason: collision with root package name */
        public Context f360d;

        public a(View view, String str) {
            this.f357a = view;
            this.f358b = str;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            String str;
            Method method;
            if (this.f359c == null) {
                View view2 = this.f357a;
                Context context = view2.getContext();
                while (true) {
                    String str2 = this.f358b;
                    if (context == null) {
                        int id2 = view2.getId();
                        if (id2 == -1) {
                            str = "";
                        } else {
                            str = " with id '" + view2.getContext().getResources().getResourceEntryName(id2) + "'";
                        }
                        StringBuilder sbQ = a0.a.q("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                        sbQ.append(view2.getClass());
                        sbQ.append(str);
                        throw new IllegalStateException(sbQ.toString());
                    }
                    try {
                        if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                            this.f359c = method;
                            this.f360d = context;
                        }
                    } catch (NoSuchMethodException unused) {
                    }
                    context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
                }
            }
            try {
                this.f359c.invoke(this.f360d, view);
            } catch (IllegalAccessException e10) {
                throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
            } catch (InvocationTargetException e11) {
                throw new IllegalStateException("Could not execute method for android:onClick", e11);
            }
        }
    }

    public androidx.appcompat.widget.c a(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.c(context, attributeSet);
    }

    public androidx.appcompat.widget.e b(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.e(context, attributeSet);
    }

    public androidx.appcompat.widget.f c(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.f(context, attributeSet);
    }

    public androidx.appcompat.widget.t d(Context context, AttributeSet attributeSet) {
        return new androidx.appcompat.widget.t(context, attributeSet);
    }

    public AppCompatTextView e(Context context, AttributeSet attributeSet) {
        return new AppCompatTextView(context, attributeSet);
    }

    public final View f(Context context, String str, String str2) throws NoSuchMethodException, SecurityException {
        String strConcat;
        p.o<String, Constructor<? extends View>> oVar = f355e;
        Constructor<? extends View> constructor = oVar.get(str);
        if (constructor == null) {
            if (str2 != null) {
                try {
                    strConcat = str2.concat(str);
                } catch (Exception unused) {
                    return null;
                }
            } else {
                strConcat = str;
            }
            constructor = Class.forName(strConcat, false, context.getClassLoader()).asSubclass(View.class).getConstructor(f352b);
            oVar.put(str, constructor);
        }
        constructor.setAccessible(true);
        return constructor.newInstance(this.f356a);
    }
}
