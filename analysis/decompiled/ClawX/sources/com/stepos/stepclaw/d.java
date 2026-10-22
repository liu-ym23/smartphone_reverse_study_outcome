package com.stepos.stepclaw;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements p5.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1559a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ StepClawApp f1560b;

    public /* synthetic */ d(StepClawApp stepClawApp, int i8) {
        this.f1559a = i8;
        this.f1560b = stepClawApp;
    }

    @Override // p5.a
    public final Object invoke() {
        int i8 = this.f1559a;
        StepClawApp stepClawApp = this.f1560b;
        switch (i8) {
            case 0:
                return StepClawApp.runtime_delegate$lambda$0(stepClawApp);
            default:
                return StepClawApp.attachBaseContext$lambda$0(stepClawApp);
        }
    }
}
