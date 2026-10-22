package g3;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import androidx.room.MultiInstanceInvalidationService;

/* loaded from: classes.dex */
public final class m extends RemoteCallbackList {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f3824a;

    public m(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f3824a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object obj) {
        q7.k.e((h) iInterface, "callback");
        q7.k.e(obj, "cookie");
        this.f3824a.f1045g.remove((Integer) obj);
    }
}
