package androidx.activity;

import android.os.Build;
import androidx.lifecycle.l;
import androidx.lifecycle.p;
import androidx.lifecycle.r;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
class ComponentActivity$6 implements p {
    @Override // androidx.lifecycle.p
    public final void a(r rVar, l lVar) {
        if (lVar != l.ON_CREATE || Build.VERSION.SDK_INT < 33) {
            return;
        }
        int i8 = a.f242a;
        throw null;
    }
}
