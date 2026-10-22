package k1;

import android.text.Editable;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends Editable.Factory {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f9837a = new Object();

    /* renamed from: b, reason: collision with root package name */
    public static volatile b f9838b;

    /* renamed from: c, reason: collision with root package name */
    public static Class<?> f9839c;

    @Override // android.text.Editable.Factory
    public final Editable newEditable(CharSequence charSequence) {
        Class<?> cls = f9839c;
        return cls != null ? new i1.f(cls, charSequence) : super.newEditable(charSequence);
    }
}
