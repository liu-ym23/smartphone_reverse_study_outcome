package h;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g0 implements View.OnClickListener {

    /* renamed from: c, reason: collision with root package name */
    public View f4830c;

    /* renamed from: f, reason: collision with root package name */
    public String f4831f;

    /* renamed from: g, reason: collision with root package name */
    public Method f4832g;

    /* renamed from: h, reason: collision with root package name */
    public Context f4833h;

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        String str;
        Method method;
        View view2 = this.f4830c;
        if (this.f4832g == null) {
            Context context = view2.getContext();
            String str2 = this.f4831f;
            while (context != null) {
                try {
                    if (!context.isRestricted() && (method = context.getClass().getMethod(str2, View.class)) != null) {
                        this.f4832g = method;
                        this.f4833h = context;
                    }
                } catch (NoSuchMethodException unused) {
                }
                context = context instanceof ContextWrapper ? ((ContextWrapper) context).getBaseContext() : null;
            }
            int id2 = view2.getId();
            if (id2 == -1) {
                str = "";
            } else {
                str = " with id '" + view2.getContext().getResources().getResourceEntryName(id2) + "'";
            }
            StringBuilder sbO = androidx.activity.b.o("Could not find method ", str2, "(View) in a parent or ancestor Context for android:onClick attribute defined on view ");
            sbO.append(view2.getClass());
            sbO.append(str);
            throw new IllegalStateException(sbO.toString());
        }
        try {
            this.f4832g.invoke(this.f4833h, view);
        } catch (IllegalAccessException e10) {
            throw new IllegalStateException("Could not execute non-public method for android:onClick", e10);
        } catch (InvocationTargetException e11) {
            throw new IllegalStateException("Could not execute method for android:onClick", e11);
        }
    }
}
