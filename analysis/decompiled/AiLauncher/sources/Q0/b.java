package Q0;

import android.annotation.SuppressLint;
import android.text.Editable;

/* loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f5392a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile Editable.Factory f5393b;

    /* renamed from: c, reason: collision with root package name */
    public static Class<?> f5394c;

    @SuppressLint({"PrivateApi"})
    public b() {
        try {
            f5394c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f5393b == null) {
            synchronized (f5392a) {
                try {
                    if (f5393b == null) {
                        f5393b = new b();
                    }
                } finally {
                }
            }
        }
        return f5393b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f5394c;
        return cls != null ? O0.h.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
