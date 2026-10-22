package androidx.lifecycle;

import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/DefaultLifecycleObserverAdapter;", "Landroidx/lifecycle/p;", "lifecycle-common"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultLifecycleObserverAdapter implements p {

    /* renamed from: a, reason: collision with root package name */
    public final d f691a;

    /* renamed from: b, reason: collision with root package name */
    public final p f692b;

    public DefaultLifecycleObserverAdapter(d dVar, p pVar) {
        this.f691a = dVar;
        this.f692b = pVar;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        int i8 = e.f705a[lVar.ordinal()];
        if (i8 == 3) {
            this.f691a.c();
        } else if (i8 == 7) {
            throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        p pVar = this.f692b;
        if (pVar != null) {
            pVar.a(rVar, lVar);
        }
    }
}
