package com.bytedance.android.live.liveinteract.plantform.dynamicframe.model;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/live/liveinteract/plantform/dynamicframe/model/LayerIndex;", "", "Background", "Seat", "Biz", "multilink-business-platform_saasRelease"}, k = 1, mv = {1, 5, 1})
public final enum LayerIndex extends Enum<LayerIndex> {
    public static final LayerIndex Background = null;
    public static final LayerIndex Biz = null;
    public static final LayerIndex Seat = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LayerIndex[] f77075a = null;

    static {
        LayerIndex r100 = new LayerIndex("Background", 0);
        Background = r100;
        LayerIndex r101 = new LayerIndex("Seat", 1);
        Seat = r101;
        LayerIndex r102 = new LayerIndex("Biz", 2);
        Biz = r102;
        f77075a = new LayerIndex[]{r100, r101, r102};
    }

    public static LayerIndex valueOf(String r100) {
        return (LayerIndex) a.a(LayerIndex.class, r100);
    }

    public static LayerIndex[] values() {
        return (LayerIndex[]) f77075a.clone();
    }

    public LayerIndex(String r100, int r101) {
        super(r100, r101);
    }
}
