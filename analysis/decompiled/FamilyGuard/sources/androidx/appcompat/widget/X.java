package androidx.appcompat.widget;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.AssetManager;
import android.content.res.Resources;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class X extends ContextWrapper {

    /* renamed from: c, reason: collision with root package name */
    private static final Object f8458c = new Object();

    /* renamed from: d, reason: collision with root package name */
    private static ArrayList<WeakReference<X>> f8459d;

    /* renamed from: a, reason: collision with root package name */
    private final Resources f8460a;

    /* renamed from: b, reason: collision with root package name */
    private final Resources.Theme f8461b;

    private X(Context context) {
        super(context);
        if (!g0.c()) {
            this.f8460a = new Z(this, context.getResources());
            this.f8461b = null;
            return;
        }
        g0 g0Var = new g0(this, context.getResources());
        this.f8460a = g0Var;
        Resources.Theme themeNewTheme = g0Var.newTheme();
        this.f8461b = themeNewTheme;
        themeNewTheme.setTo(context.getTheme());
    }

    private static boolean a(Context context) {
        return ((context instanceof X) || (context.getResources() instanceof Z) || (context.getResources() instanceof g0) || !g0.c()) ? false : true;
    }

    public static Context b(Context context) {
        if (!a(context)) {
            return context;
        }
        synchronized (f8458c) {
            try {
                ArrayList<WeakReference<X>> arrayList = f8459d;
                if (arrayList == null) {
                    f8459d = new ArrayList<>();
                } else {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        WeakReference<X> weakReference = f8459d.get(size);
                        if (weakReference == null || weakReference.get() == null) {
                            f8459d.remove(size);
                        }
                    }
                    for (int size2 = f8459d.size() - 1; size2 >= 0; size2--) {
                        WeakReference<X> weakReference2 = f8459d.get(size2);
                        X x5 = weakReference2 != null ? weakReference2.get() : null;
                        if (x5 != null && x5.getBaseContext() == context) {
                            return x5;
                        }
                    }
                }
                X x6 = new X(context);
                f8459d.add(new WeakReference<>(x6));
                return x6;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.f8460a.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.f8460a;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.f8461b;
        return theme == null ? super.getTheme() : theme;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i5) {
        Resources.Theme theme = this.f8461b;
        if (theme == null) {
            super.setTheme(i5);
        } else {
            theme.applyStyle(i5, true);
        }
    }
}
