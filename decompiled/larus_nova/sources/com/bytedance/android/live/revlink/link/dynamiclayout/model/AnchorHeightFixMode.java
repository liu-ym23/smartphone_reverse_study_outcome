package com.bytedance.android.live.revlink.link.dynamiclayout.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/revlink/link/dynamiclayout/model/AnchorHeightFixMode;", "", "OriginContainerHeight", "RationTransformHeight", "PreviewHeight", "liverevlink-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum AnchorHeightFixMode extends Enum<AnchorHeightFixMode> {
    public static final AnchorHeightFixMode OriginContainerHeight = null;
    public static final AnchorHeightFixMode PreviewHeight = null;
    public static final AnchorHeightFixMode RationTransformHeight = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AnchorHeightFixMode[] f98597a = null;

    static {
        AnchorHeightFixMode r100 = new AnchorHeightFixMode("OriginContainerHeight", 0);
        OriginContainerHeight = r100;
        AnchorHeightFixMode r101 = new AnchorHeightFixMode("RationTransformHeight", 1);
        RationTransformHeight = r101;
        AnchorHeightFixMode r102 = new AnchorHeightFixMode("PreviewHeight", 2);
        PreviewHeight = r102;
        f98597a = new AnchorHeightFixMode[]{r100, r101, r102};
    }

    public static AnchorHeightFixMode valueOf(String r100) {
        return (AnchorHeightFixMode) a.a(AnchorHeightFixMode.class, r100);
    }

    public static AnchorHeightFixMode[] values() {
        return (AnchorHeightFixMode[]) f98597a.clone();
    }

    public AnchorHeightFixMode(String r100, int r101) {
        super(r100, r101);
    }
}
