package com.bytedance.applog.map.api;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.apm.constant.UploadTypeInf;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0004\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/bytedance/applog/map/api/MapSignalSource;", "", "", "getSource", "source", "Ljava/lang/String;", "CLICK_BEFORE", "CLICK_AFTER", "PAGE_ENTERED", "TIMER", "TIMER_UPDATE", "MORE_DELAY", "DIALOG_SHOW", "DIALOG_HIDDEN", "ROOT_VIEW_ADDED", "ROOT_VIEW_REMOVED", "COLD_START", "CUSTOM", "PLACEHOLDER", "map-api_release"}, k = 1, mv = {1, 6, 0})
public final enum MapSignalSource extends Enum<MapSignalSource> {
    public static final MapSignalSource CLICK_AFTER = null;
    public static final MapSignalSource CLICK_BEFORE = null;
    public static final MapSignalSource COLD_START = null;
    public static final MapSignalSource CUSTOM = null;
    public static final MapSignalSource DIALOG_HIDDEN = null;
    public static final MapSignalSource DIALOG_SHOW = null;
    public static final MapSignalSource MORE_DELAY = null;
    public static final MapSignalSource PAGE_ENTERED = null;
    public static final MapSignalSource PLACEHOLDER = null;
    public static final MapSignalSource ROOT_VIEW_ADDED = null;
    public static final MapSignalSource ROOT_VIEW_REMOVED = null;
    public static final MapSignalSource TIMER = null;
    public static final MapSignalSource TIMER_UPDATE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MapSignalSource[] f192486a = null;
    private final String source;

    public static MapSignalSource valueOf(String r100) {
        return (MapSignalSource) r27.a.a(MapSignalSource.class, r100);
    }

    public static MapSignalSource[] values() {
        return (MapSignalSource[]) f192486a.clone();
    }

    static {
        MapSignalSource r100 = new MapSignalSource("CLICK_BEFORE", 0, "click_before");
        CLICK_BEFORE = r100;
        MapSignalSource r101 = new MapSignalSource("CLICK_AFTER", 1, "click_after");
        CLICK_AFTER = r101;
        MapSignalSource r102 = new MapSignalSource("PAGE_ENTERED", 2, "page_entered");
        PAGE_ENTERED = r102;
        MapSignalSource r103 = new MapSignalSource("TIMER", 3, UploadTypeInf.TIMER);
        TIMER = r103;
        MapSignalSource r104 = new MapSignalSource("TIMER_UPDATE", 4, "timer_update");
        TIMER_UPDATE = r104;
        MapSignalSource r105 = new MapSignalSource("MORE_DELAY", 5, "more_delay");
        MORE_DELAY = r105;
        MapSignalSource r110 = new MapSignalSource("DIALOG_SHOW", 6, "dialog_show");
        DIALOG_SHOW = r110;
        MapSignalSource r111 = new MapSignalSource("DIALOG_HIDDEN", 7, "dialog_hidden");
        DIALOG_HIDDEN = r111;
        MapSignalSource r112 = new MapSignalSource("ROOT_VIEW_ADDED", 8, "root_view_added");
        ROOT_VIEW_ADDED = r112;
        MapSignalSource r113 = new MapSignalSource("ROOT_VIEW_REMOVED", 9, "root_view_removed");
        ROOT_VIEW_REMOVED = r113;
        MapSignalSource r114 = new MapSignalSource("COLD_START", 10, "cold_start");
        COLD_START = r114;
        MapSignalSource r106 = new MapSignalSource("CUSTOM", 11, "custom");
        CUSTOM = r106;
        MapSignalSource r107 = new MapSignalSource("PLACEHOLDER", 12, GXTemplateKey.GAIAX_PLACEHOLDER);
        PLACEHOLDER = r107;
        f192486a = new MapSignalSource[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public final String getSource() {
        return this.source;
    }

    public MapSignalSource(String r100, int r101, String r102) {
        super(r100, r101);
        this.source = r102;
    }
}
