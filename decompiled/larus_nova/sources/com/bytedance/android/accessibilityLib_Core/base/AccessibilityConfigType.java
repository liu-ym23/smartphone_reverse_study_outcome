package com.bytedance.android.accessibilityLib_Core.base;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/base/AccessibilityConfigType;", "", "ContentDesc", "LargeArea", "MergeView", "More", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum AccessibilityConfigType extends Enum<AccessibilityConfigType> {
    public static final AccessibilityConfigType ContentDesc = null;
    public static final AccessibilityConfigType LargeArea = null;
    public static final AccessibilityConfigType MergeView = null;
    public static final AccessibilityConfigType More = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccessibilityConfigType[] f38114a = null;

    static {
        AccessibilityConfigType r100 = new AccessibilityConfigType("ContentDesc", 0);
        ContentDesc = r100;
        AccessibilityConfigType r101 = new AccessibilityConfigType("LargeArea", 1);
        LargeArea = r101;
        AccessibilityConfigType r102 = new AccessibilityConfigType("MergeView", 2);
        MergeView = r102;
        AccessibilityConfigType r103 = new AccessibilityConfigType("More", 3);
        More = r103;
        f38114a = new AccessibilityConfigType[]{r100, r101, r102, r103};
    }

    public static AccessibilityConfigType valueOf(String r100) {
        return (AccessibilityConfigType) a.a(AccessibilityConfigType.class, r100);
    }

    public static AccessibilityConfigType[] values() {
        return (AccessibilityConfigType[]) f38114a.clone();
    }

    public AccessibilityConfigType(String r100, int r101) {
        super(r100, r101);
    }
}
