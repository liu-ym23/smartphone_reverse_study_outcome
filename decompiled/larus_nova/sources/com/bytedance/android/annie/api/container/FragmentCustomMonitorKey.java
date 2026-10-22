package com.bytedance.android.annie.api.container;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/android/annie/api/container/FragmentCustomMonitorKey;", "", "IsPrerender", "IsContainerPreload", "IsUserOpen", "RealOpenTime", "HasReload", "annie-api_release"}, k = 1, mv = {1, 4, 3})
public final enum FragmentCustomMonitorKey extends Enum<FragmentCustomMonitorKey> {
    public static final FragmentCustomMonitorKey HasReload = null;
    public static final FragmentCustomMonitorKey IsContainerPreload = null;
    public static final FragmentCustomMonitorKey IsPrerender = null;
    public static final FragmentCustomMonitorKey IsUserOpen = null;
    public static final FragmentCustomMonitorKey RealOpenTime = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FragmentCustomMonitorKey[] f38400a = null;

    public static FragmentCustomMonitorKey valueOf(String r100) {
        return (FragmentCustomMonitorKey) a.a(FragmentCustomMonitorKey.class, r100);
    }

    public static FragmentCustomMonitorKey[] values() {
        return (FragmentCustomMonitorKey[]) f38400a.clone();
    }

    static {
        FragmentCustomMonitorKey r100 = new FragmentCustomMonitorKey("IsPrerender", 0);
        IsPrerender = r100;
        FragmentCustomMonitorKey r101 = new FragmentCustomMonitorKey("IsContainerPreload", 1);
        IsContainerPreload = r101;
        FragmentCustomMonitorKey r102 = new FragmentCustomMonitorKey("IsUserOpen", 2);
        IsUserOpen = r102;
        FragmentCustomMonitorKey r103 = new FragmentCustomMonitorKey("RealOpenTime", 3);
        RealOpenTime = r103;
        FragmentCustomMonitorKey r104 = new FragmentCustomMonitorKey("HasReload", 4);
        HasReload = r104;
        f38400a = new FragmentCustomMonitorKey[]{r100, r101, r102, r103, r104};
    }

    public FragmentCustomMonitorKey(String r100, int r101) {
        super(r100, r101);
    }
}
