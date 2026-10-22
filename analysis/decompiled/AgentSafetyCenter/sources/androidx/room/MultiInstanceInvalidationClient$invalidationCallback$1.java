package androidx.room;

import androidx.room.IMultiInstanceInvalidationCallback;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$invalidationCallback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ g this$0;

    public MultiInstanceInvalidationClient$invalidationCallback$1(g gVar) {
        this.this$0 = gVar;
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(String[] strArr) {
        strArr.getClass();
        g gVar = this.this$0;
        gVar.getClass();
        kc.w.u(null, null, null, new androidx.lifecycle.h0(strArr, gVar, (nb.c) null), 3);
    }
}
