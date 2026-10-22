package v0;

import android.view.Window;
import android.view.WindowInsetsController;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public class n0 extends mb.y {

    /* renamed from: a, reason: collision with root package name */
    public final WindowInsetsController f13330a;

    /* renamed from: b, reason: collision with root package name */
    public final Window f13331b;

    public n0(Window window, w wVar) {
        WindowInsetsController insetsController = window.getInsetsController();
        new p.o();
        this.f13330a = insetsController;
        this.f13331b = window;
    }

    public boolean T() {
        WindowInsetsController windowInsetsController = this.f13330a;
        windowInsetsController.setSystemBarsAppearance(0, 0);
        return (windowInsetsController.getSystemBarsAppearance() & 8) != 0;
    }
}
