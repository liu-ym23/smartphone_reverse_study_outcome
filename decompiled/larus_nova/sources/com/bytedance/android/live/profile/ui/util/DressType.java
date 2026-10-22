package com.bytedance.android.live.profile.ui.util;

import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\r\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/profile/ui/util/DressType;", "", "PanelBgPng", "PanelEnterWebp", "PanelLoopWebp", "Border9Png", "BorderEnterWebp", "BorderLoopWebp", "BorderPng", "PanelRightBgPng", "PanelExitWebp", "MainButton9Png", "MainButtonWebp", "ParallaxAsset", "live-profile-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum DressType extends Enum<DressType> {
    public static final DressType Border9Png = null;
    public static final DressType BorderEnterWebp = null;
    public static final DressType BorderLoopWebp = null;
    public static final DressType BorderPng = null;
    public static final DressType MainButton9Png = null;
    public static final DressType MainButtonWebp = null;
    public static final DressType PanelBgPng = null;
    public static final DressType PanelEnterWebp = null;
    public static final DressType PanelExitWebp = null;
    public static final DressType PanelLoopWebp = null;

    @Deprecated(message = "此装扮坑位和代码已删除")
    public static final DressType PanelRightBgPng = null;
    public static final DressType ParallaxAsset = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DressType[] f86924a = null;

    static {
        DressType r100 = new DressType("PanelBgPng", 0);
        PanelBgPng = r100;
        DressType r101 = new DressType("PanelEnterWebp", 1);
        PanelEnterWebp = r101;
        DressType r102 = new DressType("PanelLoopWebp", 2);
        PanelLoopWebp = r102;
        DressType r103 = new DressType("Border9Png", 3);
        Border9Png = r103;
        DressType r104 = new DressType("BorderEnterWebp", 4);
        BorderEnterWebp = r104;
        DressType r105 = new DressType("BorderLoopWebp", 5);
        BorderLoopWebp = r105;
        DressType r106 = new DressType("BorderPng", 6);
        BorderPng = r106;
        DressType r107 = new DressType("PanelRightBgPng", 7);
        PanelRightBgPng = r107;
        DressType r108 = new DressType("PanelExitWebp", 8);
        PanelExitWebp = r108;
        DressType r109 = new DressType("MainButton9Png", 9);
        MainButton9Png = r109;
        DressType r110 = new DressType("MainButtonWebp", 10);
        MainButtonWebp = r110;
        DressType r111 = new DressType("ParallaxAsset", 11);
        ParallaxAsset = r111;
        f86924a = new DressType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111};
    }

    public static DressType valueOf(String r100) {
        return (DressType) r27.a.a(DressType.class, r100);
    }

    public static DressType[] values() {
        return (DressType[]) f86924a.clone();
    }

    public DressType(String r100, int r101) {
        super(r100, r101);
    }
}
