package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;

/* JADX INFO: compiled from: LazyScopeAdapter.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class LazyScopeAdapter extends AbstractScopeAdapter {
    private final NotNullLazyValue<MemberScope> lazyScope;

    /* JADX WARN: Multi-variable type inference failed */
    public LazyScopeAdapter(Function0<? extends MemberScope> r3) {
        Intrinsics.checkNotNullParameter(r3, "getScope");
        this(null, r3, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ LazyScopeAdapter(StorageManager r1, Function0 r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L5;
        r1 = LockBasedStorageManager.NO_LOCKS;
        Intrinsics.checkNotNullExpressionValue(r1, "NO_LOCKS");
    L5:
        this(r1, r2);
    }

    public LazyScopeAdapter(StorageManager r2, final Function0<? extends MemberScope> r3) {
        Intrinsics.checkNotNullParameter(r2, "storageManager");
        Intrinsics.checkNotNullParameter(r3, "getScope");
        this.lazyScope = r2.createLazyValue(new LazyScopeAdapter$lazyScope$1(r3));
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.AbstractScopeAdapter
    protected MemberScope getWorkerScope() {
        return this.lazyScope.invoke();
    }
}
