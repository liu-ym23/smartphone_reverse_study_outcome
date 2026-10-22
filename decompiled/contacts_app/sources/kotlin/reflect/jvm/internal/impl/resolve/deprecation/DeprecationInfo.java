package kotlin.reflect.jvm.internal.impl.resolve.deprecation;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeprecationInfo.kt */
/* JADX INFO: loaded from: classes4.dex */
public abstract class DeprecationInfo implements Comparable<DeprecationInfo> {
    public abstract DeprecationLevelValue getDeprecationLevel();

    public abstract boolean getPropagatesToOverrides();

    public DeprecationInfo() {
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(DeprecationInfo r1) {
        return compareTo2(r1);
    }

    /* JADX INFO: renamed from: compareTo, reason: avoid collision after fix types in other method */
    public int compareTo2(DeprecationInfo r3) {
        Intrinsics.checkNotNullParameter(r3, "other");
        int r0 = getDeprecationLevel().compareTo(r3.getDeprecationLevel());
        if (r0 == 0) goto L5;
        return r0;
    L5:
        if (getPropagatesToOverrides() == false) goto L7;
        return r0;
    L7:
        if (r3.getPropagatesToOverrides() == false) goto L12;
        return 1;
    L12:
        return r0;
    }
}
