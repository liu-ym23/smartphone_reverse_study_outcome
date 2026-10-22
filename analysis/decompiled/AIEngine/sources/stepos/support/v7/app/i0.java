package stepos.support.v7.app;

import android.view.View;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f12141a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ View f12142b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StepOSAlertController f12143c;

    public i0(StepOSAlertController stepOSAlertController, View view, View view2) {
        this.f12143c = stepOSAlertController;
        this.f12141a = view;
        this.f12142b = view2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StepOSAlertController.q(this.f12143c.C, this.f12141a, this.f12142b);
    }
}
