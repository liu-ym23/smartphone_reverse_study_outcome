package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class Q extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    public static final Object f9019c = new Object();

    /* renamed from: d, reason: collision with root package name */
    public static ArrayList<WeakReference<Q>> f9020d;

    /* renamed from: a, reason: collision with root package name */
    public final Resources f9021a;

    /* renamed from: b, reason: collision with root package name */
    public final Resources.Theme f9022b;

    public Q(Context context) {
        super(context);
        if (!a0.d()) {
            this.f9021a = new T(this, context.getResources());
            this.f9022b = null;
            return;
        }
        a0 a0Var = new a0(this, context.getResources());
        this.f9021a = a0Var;
        Resources.Theme themeNewTheme = a0Var.newTheme();
        this.f9022b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    public static boolean a(Context context) {
        return ((context instanceof Q) || (context.getResources() instanceof T) || (context.getResources() instanceof a0) || !a0.d()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f9019c) {
            try {
                ArrayList<WeakReference<Q>> arrayList = f9020d;
                if (arrayList == null) {
                    f9020d = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<Q> weakReference = f9020d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f9020d.remove(size);
                        }
                    }
                    for (int size2 = f9020d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<Q> weakReference2 = f9020d.get(size2);
                        Q q10 = weakReference2 != null ? weakReference2.get() : null;
                        if (q10 != null && q10.getBaseContext() == context) {
                            return q10;
                        }
                    }
                }
                Q q11 = new Q(context);
                f9020d.add(new WeakReference<>(q11));
                return q11;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f9021a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f9021a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f9022b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i10) {
        Resources.Theme theme = this.f9022b;
        if (theme == null) {
            super.setTheme(i10);
        } else {
            theme.applyStyle(i10, true);
        }
    }
}
