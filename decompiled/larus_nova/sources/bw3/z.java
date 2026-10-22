package bw3;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class z implements Function1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ e0 f21142a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f0 f21143b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ double f21144c;

    public /* synthetic */ z(e0 r100, f0 r101, double r102) {
        this.f21142a = r100;
        this.f21143b = r101;
        this.f21144c = r102;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object r100) {
        final e0 r101 = this.f21142a;
        final f0 r102 = this.f21143b;
        final double r103 = this.f21144c;
        final boolean r104 = ((Boolean) r100).booleanValue();
        Function0 r105 = new b0(r101, r102, r104, r103);
        r101.getClass();
        e0.g(r105);
        return Unit.INSTANCE;
    }
}
