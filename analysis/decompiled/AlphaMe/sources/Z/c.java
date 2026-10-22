package Z;

import X.A;
import android.text.Editable;

/* loaded from: classes.dex */
public final class c extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f2127a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile c f2128b;

    /* renamed from: c, reason: collision with root package name */
    public static Class f2129c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class cls = f2129c;
        return cls != null ? new A(cls, charSequence) : super.newEditable(charSequence);
    }
}
