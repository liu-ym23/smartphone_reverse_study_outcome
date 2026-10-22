package com.google.android.material.appbar;

import com.stepos.alphame.utils.Property;
import com.stepos.common.widget.C;

/* loaded from: classes.dex */
public final class l implements W.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10331a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10332b;

    public /* synthetic */ l(int i4, Object obj) {
        this.f10331a = i4;
        this.f10332b = obj;
    }

    @Override // W.i
    public final void a(boolean z4) {
        int i4 = this.f10331a;
        Object obj = this.f10332b;
        switch (i4) {
            case 0:
                StepOSAppBarBehavior stepOSAppBarBehavior = (StepOSAppBarBehavior) obj;
                stepOSAppBarBehavior.getClass();
                if (!stepOSAppBarBehavior.f10279r) {
                    stepOSAppBarBehavior.b();
                    break;
                }
                break;
            case 1:
                ((C) obj).f11447a.a();
                break;
            default:
                N3.d dVar = (N3.d) obj;
                dVar.f1518v = Property.DEFAULT_FLOAT_VALUE;
                if (!z4) {
                    dVar.f1517u = 0;
                    dVar.e();
                    break;
                }
                break;
        }
    }
}
