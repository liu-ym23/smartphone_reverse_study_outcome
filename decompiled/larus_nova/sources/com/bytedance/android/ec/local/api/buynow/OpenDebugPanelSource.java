package com.bytedance.android.ec.local.api.buynow;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/ec/local/api/buynow/OpenDebugPanelSource;", "", "", "index", "I", "getIndex", "()I", "YATA", "SLICE", "ORDER_LIST", "CART", "BUYNOW", "SKU", "FRONTIER", "ec-local-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum OpenDebugPanelSource extends Enum<OpenDebugPanelSource> {
    public static final OpenDebugPanelSource BUYNOW = null;
    public static final OpenDebugPanelSource CART = null;
    public static final OpenDebugPanelSource FRONTIER = null;
    public static final OpenDebugPanelSource ORDER_LIST = null;
    public static final OpenDebugPanelSource SKU = null;
    public static final OpenDebugPanelSource SLICE = null;
    public static final OpenDebugPanelSource YATA = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OpenDebugPanelSource[] f47845a = null;
    private final int index;

    static {
        OpenDebugPanelSource r100 = new OpenDebugPanelSource("YATA", 0, 0);
        YATA = r100;
        OpenDebugPanelSource r101 = new OpenDebugPanelSource("SLICE", 1, 1);
        SLICE = r101;
        OpenDebugPanelSource r102 = new OpenDebugPanelSource("ORDER_LIST", 2, 2);
        ORDER_LIST = r102;
        OpenDebugPanelSource r103 = new OpenDebugPanelSource("CART", 3, 3);
        CART = r103;
        OpenDebugPanelSource r104 = new OpenDebugPanelSource("BUYNOW", 4, 4);
        BUYNOW = r104;
        OpenDebugPanelSource r105 = new OpenDebugPanelSource("SKU", 5, 5);
        SKU = r105;
        OpenDebugPanelSource r106 = new OpenDebugPanelSource("FRONTIER", 6, 6);
        FRONTIER = r106;
        f47845a = new OpenDebugPanelSource[]{r100, r101, r102, r103, r104, r105, r106};
    }

    public static OpenDebugPanelSource valueOf(String r100) {
        return (OpenDebugPanelSource) a.a(OpenDebugPanelSource.class, r100);
    }

    public static OpenDebugPanelSource[] values() {
        return (OpenDebugPanelSource[]) f47845a.clone();
    }

    public final int getIndex() {
        return this.index;
    }

    public OpenDebugPanelSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.index = r102;
    }
}
