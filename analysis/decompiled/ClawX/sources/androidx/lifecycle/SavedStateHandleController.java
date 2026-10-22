package androidx.lifecycle;

import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/SavedStateHandleController;", "Landroidx/lifecycle/p;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandleController implements p {

    /* renamed from: a, reason: collision with root package name */
    public boolean f696a;

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (lVar == l.ON_DESTROY) {
            this.f696a = false;
            rVar.d().e(this);
        }
    }
}
