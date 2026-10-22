package com.bytedance.android.accessibilityLib_Core.processor;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/processor/TraverseFromType;", "", "None", "InternalVisitViewGlobalLayoutChange", "ActivityCreated_PageIn", "ActivityPostResumed", "FragmentCreated", "FragmentGlobalLayoutChange", "ActivityGlobalLayoutChange", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum TraverseFromType extends Enum<TraverseFromType> {
    public static final TraverseFromType ActivityCreated_PageIn = null;
    public static final TraverseFromType ActivityGlobalLayoutChange = null;
    public static final TraverseFromType ActivityPostResumed = null;
    public static final TraverseFromType FragmentCreated = null;
    public static final TraverseFromType FragmentGlobalLayoutChange = null;
    public static final TraverseFromType InternalVisitViewGlobalLayoutChange = null;
    public static final TraverseFromType None = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TraverseFromType[] f38288a = null;

    static {
        TraverseFromType r100 = new TraverseFromType("None", 0);
        None = r100;
        TraverseFromType r101 = new TraverseFromType("InternalVisitViewGlobalLayoutChange", 1);
        InternalVisitViewGlobalLayoutChange = r101;
        TraverseFromType r102 = new TraverseFromType("ActivityCreated_PageIn", 2);
        ActivityCreated_PageIn = r102;
        TraverseFromType r103 = new TraverseFromType("ActivityPostResumed", 3);
        ActivityPostResumed = r103;
        TraverseFromType r104 = new TraverseFromType("FragmentCreated", 4);
        FragmentCreated = r104;
        TraverseFromType r105 = new TraverseFromType("FragmentGlobalLayoutChange", 5);
        FragmentGlobalLayoutChange = r105;
        TraverseFromType r106 = new TraverseFromType("ActivityGlobalLayoutChange", 6);
        ActivityGlobalLayoutChange = r106;
        f38288a = new TraverseFromType[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static TraverseFromType valueOf(String r100) {
        return (TraverseFromType) r27.a.a(TraverseFromType.class, r100);
    }

    public static TraverseFromType[] values() {
        return (TraverseFromType[]) f38288a.clone();
    }

    public TraverseFromType(String r100, int r101) {
        super(r100, r101);
    }
}
