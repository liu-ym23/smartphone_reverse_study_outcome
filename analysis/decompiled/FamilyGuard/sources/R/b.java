package R;

import android.text.Editable;
import androidx.emoji2.text.n;

/* loaded from: classes.dex */
final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    private static final Object f4940a = new Object();

    /* renamed from: b, reason: collision with root package name */
    private static volatile Editable.Factory f4941b;

    /* renamed from: c, reason: collision with root package name */
    private static Class<?> f4942c;

    private b() {
        try {
            f4942c = Class.forName("android.text.DynamicLayout$ChangeWatcher", false, b.class.getClassLoader());
        } catch (Throwable unused) {
        }
    }

    public static Editable.Factory getInstance() {
        if (f4941b == null) {
            synchronized (f4940a) {
                try {
                    if (f4941b == null) {
                        f4941b = new b();
                    }
                } finally {
                }
            }
        }
        return f4941b;
    }

    @Override // android.text.Editable.Factory
    public Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f4942c;
        return cls != null ? n.c(cls, charSequence) : super.newEditable(charSequence);
    }
}
