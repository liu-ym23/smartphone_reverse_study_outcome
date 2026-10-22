package androidx.lifecycle;

import android.os.Handler;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class Z implements G {

    /* renamed from: h, reason: collision with root package name */
    public static final Z f3905h = new Z();

    /* renamed from: a, reason: collision with root package name */
    public int f3906a;

    /* renamed from: b, reason: collision with root package name */
    public int f3907b;

    /* renamed from: e, reason: collision with root package name */
    public Handler f3910e;

    /* renamed from: c, reason: collision with root package name */
    public boolean f3908c = true;

    /* renamed from: d, reason: collision with root package name */
    public boolean f3909d = true;

    /* renamed from: f, reason: collision with root package name */
    public final I f3911f = new I(this);

    /* renamed from: g, reason: collision with root package name */
    public final androidx.activity.d f3912g = new androidx.activity.d(6, this);

    public final void a() {
        int i4 = this.f3907b + 1;
        this.f3907b = i4;
        if (i4 == 1) {
            if (this.f3908c) {
                this.f3911f.e(EnumC0326x.ON_RESUME);
                this.f3908c = false;
            } else {
                Handler handler = this.f3910e;
                Intrinsics.checkNotNull(handler);
                handler.removeCallbacks(this.f3912g);
            }
        }
    }

    @Override // androidx.lifecycle.G
    public final AbstractC0328z getLifecycle() {
        return this.f3911f;
    }
}
