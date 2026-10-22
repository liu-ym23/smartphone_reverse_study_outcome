package com.bytedance.android.shopping.abscontainer.common_biz.constant;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0014\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/shopping/abscontainer/common_biz/constant/WidgetName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "BODY", "MASK_BACKGROUND", "MASK_LAYER", "DIALOG", "TOP", "GUIDE", "HEADER_CEILING", "HEADER", "FOOTER", "POPUP", "CONTENT", "OVERLAY", "DEBUG", "GLOBAL_LOADING", "PANEL_CONTAINER", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum WidgetName extends Enum<WidgetName> {
    public static final WidgetName BODY = null;
    public static final WidgetName CONTENT = null;
    public static final WidgetName DEBUG = null;
    public static final WidgetName DIALOG = null;
    public static final WidgetName FOOTER = null;
    public static final WidgetName GLOBAL_LOADING = null;
    public static final WidgetName GUIDE = null;
    public static final WidgetName HEADER = null;
    public static final WidgetName HEADER_CEILING = null;
    public static final WidgetName MASK_BACKGROUND = null;
    public static final WidgetName MASK_LAYER = null;
    public static final WidgetName OVERLAY = null;
    public static final WidgetName PANEL_CONTAINER = null;
    public static final WidgetName POPUP = null;
    public static final WidgetName TOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ WidgetName[] f164229a = null;
    private final String value;

    public static WidgetName valueOf(String r100) {
        return (WidgetName) a.a(WidgetName.class, r100);
    }

    public static WidgetName[] values() {
        return (WidgetName[]) f164229a.clone();
    }

    static {
        WidgetName r100 = new WidgetName("BODY", 0, ContainerPosition.BODY);
        BODY = r100;
        WidgetName r101 = new WidgetName("MASK_BACKGROUND", 1, "mask_background");
        MASK_BACKGROUND = r101;
        WidgetName r102 = new WidgetName("MASK_LAYER", 2, "mask_layer");
        MASK_LAYER = r102;
        WidgetName r103 = new WidgetName("DIALOG", 3, "dialog");
        DIALOG = r103;
        WidgetName r104 = new WidgetName("TOP", 4, "top");
        TOP = r104;
        WidgetName r105 = new WidgetName("GUIDE", 5, "guide");
        GUIDE = r105;
        WidgetName r106 = new WidgetName("HEADER_CEILING", 6, "header_ceiling");
        HEADER_CEILING = r106;
        WidgetName r107 = new WidgetName("HEADER", 7, "header");
        HEADER = r107;
        WidgetName r108 = new WidgetName("FOOTER", 8, ContainerPosition.FOOTER);
        FOOTER = r108;
        WidgetName r109 = new WidgetName("POPUP", 9, "popup");
        POPUP = r109;
        WidgetName r110 = new WidgetName("CONTENT", 10, "content");
        CONTENT = r110;
        WidgetName r111 = new WidgetName("OVERLAY", 11, "overlay");
        OVERLAY = r111;
        WidgetName r112 = new WidgetName("DEBUG", 12, "debug");
        DEBUG = r112;
        WidgetName r113 = new WidgetName("GLOBAL_LOADING", 13, "global_loading");
        GLOBAL_LOADING = r113;
        WidgetName r114 = new WidgetName("PANEL_CONTAINER", 14, "panel_container");
        PANEL_CONTAINER = r114;
        f164229a = new WidgetName[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114};
    }

    public final String getValue() {
        return this.value;
    }

    public WidgetName(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
