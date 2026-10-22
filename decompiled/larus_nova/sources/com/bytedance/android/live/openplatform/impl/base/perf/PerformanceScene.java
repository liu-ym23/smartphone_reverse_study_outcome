package com.bytedance.android.live.openplatform.impl.base.perf;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes46.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/live/openplatform/impl/base/perf/PerformanceScene;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "UNKNOWN", "CHOOSE_PAGE", "CHOOSE_PAGE_LIST", "CHOOSE_PAGE_LYNX", "SHELF_MANAGEMENT_PAGE", "SHELF_DIALOG", "EXPLAIN_CARD_SETTING_DIALOG", "MINI_APP_CONTEXT", "SHELF_REQUEST", "SNOW_FLAKE", "EXPLAIN_CARD", "liveopenplatform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum PerformanceScene extends Enum<PerformanceScene> {
    public static final PerformanceScene CHOOSE_PAGE = null;
    public static final PerformanceScene CHOOSE_PAGE_LIST = null;
    public static final PerformanceScene CHOOSE_PAGE_LYNX = null;
    public static final PerformanceScene EXPLAIN_CARD = null;
    public static final PerformanceScene EXPLAIN_CARD_SETTING_DIALOG = null;
    public static final PerformanceScene MINI_APP_CONTEXT = null;
    public static final PerformanceScene SHELF_DIALOG = null;
    public static final PerformanceScene SHELF_MANAGEMENT_PAGE = null;
    public static final PerformanceScene SHELF_REQUEST = null;
    public static final PerformanceScene SNOW_FLAKE = null;
    public static final PerformanceScene UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PerformanceScene[] f84017a = null;
    private final String value;

    public static PerformanceScene valueOf(String r100) {
        return (PerformanceScene) a.a(PerformanceScene.class, r100);
    }

    public static PerformanceScene[] values() {
        return (PerformanceScene[]) f84017a.clone();
    }

    static {
        PerformanceScene r100 = new PerformanceScene("UNKNOWN", 0, "unknown");
        UNKNOWN = r100;
        PerformanceScene r101 = new PerformanceScene("CHOOSE_PAGE", 1, "open_choose_page");
        CHOOSE_PAGE = r101;
        PerformanceScene r102 = new PerformanceScene("CHOOSE_PAGE_LIST", 2, "open_choose_page_list");
        CHOOSE_PAGE_LIST = r102;
        PerformanceScene r103 = new PerformanceScene("CHOOSE_PAGE_LYNX", 3, "open_choose_page_lynx");
        CHOOSE_PAGE_LYNX = r103;
        PerformanceScene r104 = new PerformanceScene("SHELF_MANAGEMENT_PAGE", 4, "open_shelf_management_page");
        SHELF_MANAGEMENT_PAGE = r104;
        PerformanceScene r105 = new PerformanceScene("SHELF_DIALOG", 5, "shelf_dialog");
        SHELF_DIALOG = r105;
        PerformanceScene r106 = new PerformanceScene("EXPLAIN_CARD_SETTING_DIALOG", 6, "explain_card_setting_dialog");
        EXPLAIN_CARD_SETTING_DIALOG = r106;
        PerformanceScene r107 = new PerformanceScene("MINI_APP_CONTEXT", 7, "mini_app_context");
        MINI_APP_CONTEXT = r107;
        PerformanceScene r108 = new PerformanceScene("SHELF_REQUEST", 8, "shelf_request");
        SHELF_REQUEST = r108;
        PerformanceScene r109 = new PerformanceScene("SNOW_FLAKE", 9, "snow_icon");
        SNOW_FLAKE = r109;
        PerformanceScene r110 = new PerformanceScene("EXPLAIN_CARD", 10, "explain_card");
        EXPLAIN_CARD = r110;
        f84017a = new PerformanceScene[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110};
    }

    public final String getValue() {
        return this.value;
    }

    public PerformanceScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
