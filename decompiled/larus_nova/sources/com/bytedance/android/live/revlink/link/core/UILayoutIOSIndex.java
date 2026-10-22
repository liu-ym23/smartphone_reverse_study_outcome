package com.bytedance.android.live.revlink.link.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/UILayoutIOSIndex;", "", "None", "DoublePK", "PKWithGuest", "PKGame", "MultiNormal", "MultiFocus", "MultiFullIncludeScreenV", "MultiFullScreenH", "LinkGameHorizontal", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UILayoutIOSIndex extends Enum<UILayoutIOSIndex> {
    public static final UILayoutIOSIndex DoublePK = null;
    public static final UILayoutIOSIndex LinkGameHorizontal = null;
    public static final UILayoutIOSIndex MultiFocus = null;
    public static final UILayoutIOSIndex MultiFullIncludeScreenV = null;
    public static final UILayoutIOSIndex MultiFullScreenH = null;
    public static final UILayoutIOSIndex MultiNormal = null;
    public static final UILayoutIOSIndex None = null;
    public static final UILayoutIOSIndex PKGame = null;
    public static final UILayoutIOSIndex PKWithGuest = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UILayoutIOSIndex[] f98252a = null;

    static {
        UILayoutIOSIndex r100 = new UILayoutIOSIndex("None", 0);
        None = r100;
        UILayoutIOSIndex r101 = new UILayoutIOSIndex("DoublePK", 1);
        DoublePK = r101;
        UILayoutIOSIndex r102 = new UILayoutIOSIndex("PKWithGuest", 2);
        PKWithGuest = r102;
        UILayoutIOSIndex r103 = new UILayoutIOSIndex("PKGame", 3);
        PKGame = r103;
        UILayoutIOSIndex r104 = new UILayoutIOSIndex("MultiNormal", 4);
        MultiNormal = r104;
        UILayoutIOSIndex r105 = new UILayoutIOSIndex("MultiFocus", 5);
        MultiFocus = r105;
        UILayoutIOSIndex r106 = new UILayoutIOSIndex("MultiFullIncludeScreenV", 6);
        MultiFullIncludeScreenV = r106;
        UILayoutIOSIndex r107 = new UILayoutIOSIndex("MultiFullScreenH", 7);
        MultiFullScreenH = r107;
        UILayoutIOSIndex r108 = new UILayoutIOSIndex("LinkGameHorizontal", 8);
        LinkGameHorizontal = r108;
        f98252a = new UILayoutIOSIndex[]{r100, r101, r102, r103, r104, r105, r106, r107, r108};
    }

    public static UILayoutIOSIndex valueOf(String r100) {
        return (UILayoutIOSIndex) a.a(UILayoutIOSIndex.class, r100);
    }

    public static UILayoutIOSIndex[] values() {
        return (UILayoutIOSIndex[]) f98252a.clone();
    }

    public UILayoutIOSIndex(String r100, int r101) {
        super(r100, r101);
    }
}
