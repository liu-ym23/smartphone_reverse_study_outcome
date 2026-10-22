package androidx.room;

import android.os.IInterface;
import android.os.RemoteCallbackList;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class t extends RemoteCallbackList {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MultiInstanceInvalidationService f4243a;

    public t(MultiInstanceInvalidationService multiInstanceInvalidationService) {
        this.f4243a = multiInstanceInvalidationService;
    }

    @Override // android.os.RemoteCallbackList
    public final void onCallbackDied(IInterface iInterface, Object cookie) {
        IMultiInstanceInvalidationCallback callback = (IMultiInstanceInvalidationCallback) iInterface;
        Intrinsics.checkNotNullParameter(callback, "callback");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        this.f4243a.f4195b.remove((Integer) cookie);
    }
}
