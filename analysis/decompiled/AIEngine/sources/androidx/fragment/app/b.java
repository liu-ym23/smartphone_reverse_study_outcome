package androidx.fragment.app;

import androidx.fragment.app.SpecialEffectsController;
import java.util.ArrayList;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2077a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ SpecialEffectsController.Operation f2078b;

    public b(k kVar, ArrayList arrayList, SpecialEffectsController.Operation operation) {
        this.f2077a = arrayList;
        this.f2078b = operation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ArrayList arrayList = this.f2077a;
        SpecialEffectsController.Operation operation = this.f2078b;
        if (arrayList.contains(operation)) {
            arrayList.remove(operation);
            operation.f2054a.a(operation.f2056c.mView);
        }
    }
}
