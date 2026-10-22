package stepos.support.v7.app;

import android.view.View;
import android.widget.AdapterView;
import stepos.support.v7.app.StepOSAlertController;
import stepos.support.v7.app.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class m0 implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StepOSAlertController f12154a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepOSAlertController.b f12155b;

    public m0(StepOSAlertController.b bVar, StepOSAlertController stepOSAlertController) {
        this.f12155b = bVar;
        this.f12154a = stepOSAlertController;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        c.a aVar = this.f12155b.f12058a;
        stepos.support.v7.view.menu.d dVar = aVar.f12093n;
        StepOSAlertController stepOSAlertController = this.f12154a;
        dVar.onClick(stepOSAlertController.f12032e, i10);
        aVar.getClass();
        stepOSAlertController.f12032e.dismiss();
    }
}
