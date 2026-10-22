package com.bytedance.android.scope.tree;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/scope/tree/DependencyType;", "", "LookupBeforeParent", "LookupAfterParent", "runtime"}, k = 1, mv = {1, 4, 3})
public final enum DependencyType extends Enum<DependencyType> {
    public static final DependencyType LookupAfterParent = null;
    public static final DependencyType LookupBeforeParent = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DependencyType[] f163457a = null;

    static {
        DependencyType r100 = new DependencyType("LookupBeforeParent", 0);
        LookupBeforeParent = r100;
        DependencyType r101 = new DependencyType("LookupAfterParent", 1);
        LookupAfterParent = r101;
        f163457a = new DependencyType[]{r100, r101};
    }

    public static DependencyType valueOf(String r100) {
        return (DependencyType) r27.a.a(DependencyType.class, r100);
    }

    public static DependencyType[] values() {
        return (DependencyType[]) f163457a.clone();
    }

    public DependencyType(String r100, int r101) {
        super(r100, r101);
    }
}
