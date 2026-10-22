package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class h extends RemoteCallbackList {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f1539a;

    public h(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f1539a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object obj) {
        ((IMultiInstanceInvalidationCallback) iInterface).getClass();
        obj.getClass();
        this.f1539a.f1481f.remove((Integer) obj);
    }
}
