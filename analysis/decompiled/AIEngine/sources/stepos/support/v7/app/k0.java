package stepos.support.v7.app;

import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class k0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f12148a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f12149b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StepOSAlertController f12150c;

    public k0(StepOSAlertController stepOSAlertController, View view, View view2) {
        this.f12150c = stepOSAlertController;
        this.f12148a = view;
        this.f12149b = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSAlertController.q(this.f12150c.f12041j, this.f12148a, this.f12149b);
    }
}
