package com.bytedance.android.accessibilityLib_Core.processor;

/* JADX INFO: loaded from: classes43.dex */
public final class e {
    public static final boolean a(TraverseFromType r100) {
        if (r100 != TraverseFromType.ActivityCreated_PageIn) goto L5;
    L10:
        return true;
    L5:
        if (r100 == TraverseFromType.FragmentCreated) goto L10;
        if (r100 == TraverseFromType.ActivityPostResumed) goto L10;
        return false;
    }
}
