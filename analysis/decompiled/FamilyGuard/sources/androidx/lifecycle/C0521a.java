package androidx.lifecycle;

import android.app.Application;

/* renamed from: androidx.lifecycle.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public class C0521a extends T {

    /* renamed from: b, reason: collision with root package name */
    private final Application f10854b;

    public C0521a(Application application) {
        j4.k.g(application, "application");
        this.f10854b = application;
    }

    public <T extends Application> T K() {
        T t5 = (T) this.f10854b;
        j4.k.e(t5, "null cannot be cast to non-null type T of androidx.lifecycle.AndroidViewModel.getApplication");
        return t5;
    }
}
