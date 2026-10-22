package androidx.appcompat.app;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class H implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final View f2535a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2536b;

    /* renamed from: c, reason: collision with root package name */
    public Method f2537c;

    /* renamed from: d, reason: collision with root package name */
    public Context f2538d;

    public H(View view, String str) {
        this.f2535a = view;
        this.f2536b = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        Method method;
        if (this.f2537c == null) {
            View view2 = this.f2535a;
            Context context = view2.getContext();
            while (true) {
                String str2 = this.f2536b;
                if (context == null) {
                    int id = view2.getId();
                    if (id == -1) {
                        str = "";
                    } else {
                        str = " with id '" + view2.getContext().getResources().getResourceEntryName(id) + "'";
                    }
                    StringBuilder sbW = B0.g.w("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
                    sbW.append(view2.getClass());
                    sbW.append(str);
                    throw new IllegalStateException(sbW.toString());
                }
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f2537c = method;
                        this.f2538d = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
        }
        try {
            this.f2537c.invoke(this.f2538d, view);
        } catch (IllegalAccessException e4) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e4);
        } catch (InvocationTargetException e5) {
            throw new IllegalStateException("Could not execute method for android:onClick", e5);
        }
    }
}
