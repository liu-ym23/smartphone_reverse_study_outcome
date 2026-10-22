package androidx.fragment.app;

import android.graphics.Rect;
import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f2140a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Rect f2141b;

    public h(j0 j0Var, View view, Rect rect) {
        this.f2140a = view;
        this.f2141b = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        j0.g(this.f2140a, this.f2141b);
    }
}
