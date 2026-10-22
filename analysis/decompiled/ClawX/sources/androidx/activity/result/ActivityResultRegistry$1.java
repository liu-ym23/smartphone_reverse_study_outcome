package androidx.activity.result;

import androidx.lifecycle.l;
import androidx.lifecycle.p;
import androidx.lifecycle.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class ActivityResultRegistry$1 implements p {
    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (l.ON_START.equals(lVar) || l.ON_STOP.equals(lVar) || l.ON_DESTROY.equals(lVar)) {
            throw null;
        }
    }
}
