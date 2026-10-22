package com.bytedance.android.accessibilityLib_Core.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/AccessiblityScope;", "", "View", "ViewGroup", "Fragment", "Activity", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum AccessiblityScope extends Enum<AccessiblityScope> {
    public static final AccessiblityScope Activity = null;
    public static final AccessiblityScope Fragment = null;
    public static final AccessiblityScope View = null;
    public static final AccessiblityScope ViewGroup = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccessiblityScope[] f38115a = null;

    static {
        AccessiblityScope r100 = new AccessiblityScope("View", 0);
        View = r100;
        AccessiblityScope r101 = new AccessiblityScope("ViewGroup", 1);
        ViewGroup = r101;
        AccessiblityScope r102 = new AccessiblityScope("Fragment", 2);
        Fragment = r102;
        AccessiblityScope r103 = new AccessiblityScope("Activity", 3);
        Activity = r103;
        f38115a = new AccessiblityScope[]{r100, r101, r102, r103};
    }

    public static AccessiblityScope valueOf(String r100) {
        return (AccessiblityScope) a.a(AccessiblityScope.class, r100);
    }

    public static AccessiblityScope[] values() {
        return (AccessiblityScope[]) f38115a.clone();
    }

    public AccessiblityScope(String r100, int r101) {
        super(r100, r101);
    }
}
