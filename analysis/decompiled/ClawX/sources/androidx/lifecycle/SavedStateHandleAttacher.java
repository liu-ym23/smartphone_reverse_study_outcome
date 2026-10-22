package androidx.lifecycle;

import android.os.Bundle;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Landroidx/lifecycle/SavedStateHandleAttacher;", "Landroidx/lifecycle/p;", "lifecycle-viewmodel-savedstate_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SavedStateHandleAttacher implements p {

    /* renamed from: a, reason: collision with root package name */
    public final f0 f695a;

    public SavedStateHandleAttacher(f0 f0Var) {
        this.f695a = f0Var;
    }

    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (lVar != l.ON_CREATE) {
            throw new IllegalStateException(("Next event must be ON_CREATE, it was " + lVar).toString());
        }
        rVar.d().e(this);
        f0 f0Var = this.f695a;
        if (f0Var.f709b) {
            return;
        }
        Bundle bundleA = f0Var.f708a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = f0Var.f710c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        f0Var.f710c = bundle;
        f0Var.f709b = true;
    }
}
