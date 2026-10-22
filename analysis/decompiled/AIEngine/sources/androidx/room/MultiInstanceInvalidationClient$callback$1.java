package androidx.room;

import androidx.appcompat.widget.z0;
import androidx.room.IMultiInstanceInvalidationCallback;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class MultiInstanceInvalidationClient$callback$1 extends IMultiInstanceInvalidationCallback.Stub {
    final /* synthetic */ i this$0;

    public MultiInstanceInvalidationClient$callback$1(i iVar) {
        this.this$0 = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onInvalidation$lambda$0(i this$0, String[] tables) {
        kotlin.jvm.internal.g.f(this$0, "this$0");
        kotlin.jvm.internal.g.f(tables, "$tables");
        this$0.getClass();
        throw null;
    }

    @Override // androidx.room.IMultiInstanceInvalidationCallback
    public void onInvalidation(String[] tables) {
        kotlin.jvm.internal.g.f(tables, "tables");
        i iVar = this.this$0;
        iVar.getClass();
        new z0(iVar, tables);
        throw null;
    }
}
