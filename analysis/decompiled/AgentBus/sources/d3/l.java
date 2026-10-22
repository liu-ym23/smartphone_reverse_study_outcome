package d3;

import android.os.Build;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* loaded from: classes.dex */
public final class l extends f {

    /* renamed from: c, reason: collision with root package name */
    public final OnBackInvokedDispatcher f2830c;

    /* renamed from: d, reason: collision with root package name */
    public final int f2831d;

    /* renamed from: e, reason: collision with root package name */
    public final OnBackInvokedCallback f2832e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2833f;

    public l(OnBackInvokedDispatcher onBackInvokedDispatcher, int i2) {
        this.f2830c = onBackInvokedDispatcher;
        this.f2831d = i2;
        this.f2832e = Build.VERSION.SDK_INT == 33 ? new OnBackInvokedCallback() { // from class: d3.m
            public final void onBackInvoked() {
                this.f2834a.a();
            }
        } : new n(this);
    }

    @Override // d3.f
    public final void b(boolean z4) {
        if (z4 && !this.f2833f) {
            this.f2830c.registerOnBackInvokedCallback(this.f2831d, this.f2832e);
            this.f2833f = true;
        } else {
            if (z4 || !this.f2833f) {
                return;
            }
            this.f2830c.unregisterOnBackInvokedCallback(this.f2832e);
            this.f2833f = false;
        }
    }
}
