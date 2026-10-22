package androidx.compose.runtime;

import androidx.collection.MutableScatterSet;
import androidx.compose.runtime.SnapshotStateKt__SnapshotFlowKt;

/* loaded from: classes.dex */
public final /* synthetic */ class g implements S7.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1753a;
    public final /* synthetic */ Object b;

    public /* synthetic */ g(Object obj, int i) {
        this.f1753a = i;
        this.b = obj;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        int i = this.f1753a;
        Object obj2 = this.b;
        switch (i) {
            case 0:
                return Boolean.valueOf(NestedContentMap.usedContainer$lambda$2$lambda$1((MovableContentStateReference) obj2, (NestedMovableContent) obj));
            case 1:
                return SnapshotStateKt__SnapshotFlowKt.AnonymousClass1.invokeSuspend$lambda$0((MutableScatterSet) obj2, obj);
            case 2:
                return Boolean.valueOf(ComposerImpl.stackTraceForValue$lambda$43(obj2, obj));
            case 3:
                return MovableContentState.extractNestedStates$lambda$1((MovableContentState) obj2, (MovableContentStateReference) obj);
            case 4:
                return Recomposer.readObserverOf$lambda$85((ControlledComposition) obj2, obj);
            case 5:
                return Recomposer.effectJob$lambda$10$lambda$9((Recomposer) obj2, (Throwable) obj);
            case 6:
                return SnapshotMutableDoubleStateImpl.component2$lambda$4((SnapshotMutableDoubleStateImpl) obj2, ((Double) obj).doubleValue());
            case 7:
                return SnapshotMutableFloatStateImpl.component2$lambda$4((SnapshotMutableFloatStateImpl) obj2, ((Float) obj).floatValue());
            case 8:
                return SnapshotMutableIntStateImpl.component2$lambda$4((SnapshotMutableIntStateImpl) obj2, ((Integer) obj).intValue());
            case 9:
                return SnapshotMutableLongStateImpl.component2$lambda$4((SnapshotMutableLongStateImpl) obj2, ((Long) obj).longValue());
            default:
                return SnapshotMutableStateImpl.component2$lambda$6((SnapshotMutableStateImpl) obj2, obj);
        }
    }
}
