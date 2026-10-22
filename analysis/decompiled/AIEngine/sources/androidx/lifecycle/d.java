package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import java.util.HashMap;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d implements o {

    /* renamed from: a, reason: collision with root package name */
    public final h[] f2263a;

    public d(h[] hVarArr) {
        this.f2263a = hVarArr;
    }

    @Override // androidx.lifecycle.o
    public final void a(q qVar, Lifecycle.Event event) {
        new HashMap();
        h[] hVarArr = this.f2263a;
        for (h hVar : hVarArr) {
            hVar.a();
        }
        for (h hVar2 : hVarArr) {
            hVar2.a();
        }
    }
}
