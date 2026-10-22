package a1;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q extends p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ j.e f62a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f63b;

    public q(r rVar, j.e eVar) {
        this.f63b = rVar;
        this.f62a = eVar;
    }

    @Override // a1.m
    public final void f(o oVar) {
        ((ArrayList) this.f62a.get(this.f63b.f65b)).remove(oVar);
        oVar.x(this);
    }
}
