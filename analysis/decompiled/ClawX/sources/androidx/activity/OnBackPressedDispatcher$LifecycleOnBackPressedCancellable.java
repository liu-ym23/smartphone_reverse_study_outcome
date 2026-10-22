package androidx.activity;

import androidx.lifecycle.l;
import androidx.lifecycle.p;
import androidx.lifecycle.r;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"androidx/activity/OnBackPressedDispatcher$LifecycleOnBackPressedCancellable", "Landroidx/lifecycle/p;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "activity_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class OnBackPressedDispatcher$LifecycleOnBackPressedCancellable implements p {
    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (lVar == l.ON_START) {
            throw null;
        }
        if (lVar != l.ON_STOP && lVar == l.ON_DESTROY) {
            throw null;
        }
    }
}
