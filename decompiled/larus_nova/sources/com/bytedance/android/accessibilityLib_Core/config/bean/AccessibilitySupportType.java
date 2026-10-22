package com.bytedance.android.accessibilityLib_Core.config.bean;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/accessibilityLib_Core/config/bean/AccessibilitySupportType;", "", "SetLabel", "Merge", "CustomView", "accessibilityLib_Core_release"}, k = 1, mv = {1, 4, 1})
public final enum AccessibilitySupportType extends Enum<AccessibilitySupportType> {
    public static final AccessibilitySupportType CustomView = null;
    public static final AccessibilitySupportType Merge = null;
    public static final AccessibilitySupportType SetLabel = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccessibilitySupportType[] f38150a = null;

    static {
        AccessibilitySupportType r100 = new AccessibilitySupportType("SetLabel", 0);
        SetLabel = r100;
        AccessibilitySupportType r101 = new AccessibilitySupportType("Merge", 1);
        Merge = r101;
        AccessibilitySupportType r102 = new AccessibilitySupportType("CustomView", 2);
        CustomView = r102;
        f38150a = new AccessibilitySupportType[]{r100, r101, r102};
    }

    public static AccessibilitySupportType valueOf(String r100) {
        return (AccessibilitySupportType) r27.a.a(AccessibilitySupportType.class, r100);
    }

    public static AccessibilitySupportType[] values() {
        return (AccessibilitySupportType[]) f38150a.clone();
    }

    public AccessibilitySupportType(String r100, int r101) {
        super(r100, r101);
    }
}
