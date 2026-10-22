package com.bytedance.android.live.revlink.link.core;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0012\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/live/revlink/link/core/UILayoutLayoutConfigIndex;", "", "", "layoutKey", "I", "getLayoutKey", "()I", "Normal", "Focus", "Full", "FullRecord", "FullRecordNormal", "PK", "PKWithAudience", "PKGame", "PKGameFull", "LinkGameHorizontal", "LinkGameLandscape", "MediaNormal", "MediaFocus", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum UILayoutLayoutConfigIndex extends Enum<UILayoutLayoutConfigIndex> {
    public static final UILayoutLayoutConfigIndex Focus = null;
    public static final UILayoutLayoutConfigIndex Full = null;
    public static final UILayoutLayoutConfigIndex FullRecord = null;
    public static final UILayoutLayoutConfigIndex FullRecordNormal = null;
    public static final UILayoutLayoutConfigIndex LinkGameHorizontal = null;
    public static final UILayoutLayoutConfigIndex LinkGameLandscape = null;
    public static final UILayoutLayoutConfigIndex MediaFocus = null;
    public static final UILayoutLayoutConfigIndex MediaNormal = null;
    public static final UILayoutLayoutConfigIndex Normal = null;
    public static final UILayoutLayoutConfigIndex PK = null;
    public static final UILayoutLayoutConfigIndex PKGame = null;
    public static final UILayoutLayoutConfigIndex PKGameFull = null;
    public static final UILayoutLayoutConfigIndex PKWithAudience = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UILayoutLayoutConfigIndex[] f98253a = null;
    private final int layoutKey;

    public static UILayoutLayoutConfigIndex valueOf(String r100) {
        return (UILayoutLayoutConfigIndex) a.a(UILayoutLayoutConfigIndex.class, r100);
    }

    public static UILayoutLayoutConfigIndex[] values() {
        return (UILayoutLayoutConfigIndex[]) f98253a.clone();
    }

    static {
        UILayoutLayoutConfigIndex r100 = new UILayoutLayoutConfigIndex("Normal", 0, 0);
        Normal = r100;
        UILayoutLayoutConfigIndex r101 = new UILayoutLayoutConfigIndex("Focus", 1, 1);
        Focus = r101;
        UILayoutLayoutConfigIndex r102 = new UILayoutLayoutConfigIndex("Full", 2, 2);
        Full = r102;
        UILayoutLayoutConfigIndex r103 = new UILayoutLayoutConfigIndex("FullRecord", 3, 3);
        FullRecord = r103;
        UILayoutLayoutConfigIndex r104 = new UILayoutLayoutConfigIndex("FullRecordNormal", 4, 4);
        FullRecordNormal = r104;
        UILayoutLayoutConfigIndex r105 = new UILayoutLayoutConfigIndex("PK", 5, 5);
        PK = r105;
        UILayoutLayoutConfigIndex r106 = new UILayoutLayoutConfigIndex("PKWithAudience", 6, 6);
        PKWithAudience = r106;
        UILayoutLayoutConfigIndex r107 = new UILayoutLayoutConfigIndex("PKGame", 7, 7);
        PKGame = r107;
        UILayoutLayoutConfigIndex r108 = new UILayoutLayoutConfigIndex("PKGameFull", 8, 8);
        PKGameFull = r108;
        UILayoutLayoutConfigIndex r109 = new UILayoutLayoutConfigIndex("LinkGameHorizontal", 9, 9);
        LinkGameHorizontal = r109;
        UILayoutLayoutConfigIndex r110 = new UILayoutLayoutConfigIndex("LinkGameLandscape", 10, 10);
        LinkGameLandscape = r110;
        UILayoutLayoutConfigIndex r111 = new UILayoutLayoutConfigIndex("MediaNormal", 11, 10000);
        MediaNormal = r111;
        UILayoutLayoutConfigIndex r112 = new UILayoutLayoutConfigIndex("MediaFocus", 12, 10001);
        MediaFocus = r112;
        f98253a = new UILayoutLayoutConfigIndex[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112};
    }

    public final int getLayoutKey() {
        return this.layoutKey;
    }

    public UILayoutLayoutConfigIndex(String r100, int r101, int r102) {
        super(r100, r101);
        this.layoutKey = r102;
    }
}
