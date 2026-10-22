package com.bytedance.android.shopping.commentv3.action;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0017\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/shopping/commentv3/action/ActionType;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "GROUP", "TRACKER", "FETCH", "ALERT", "TOAST", "REFRESH", "OPEN_SCHEMA", "SLICE_UPDATE", "STORE_UPDATE", "CACHE_UPDATE", "FETCH_COMMENT", "FILTER_EXPAND", "ENTER_BIG_PIC", "COMMENT_REPLY", "ENTER_PRODUCT_DETAIL", "ENTER_MEANINGLESS", "OPEN_SHEET_PANEL", "AUDIO_CONTROL", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum ActionType extends Enum<ActionType> {
    public static final ActionType ALERT = null;
    public static final ActionType AUDIO_CONTROL = null;
    public static final ActionType CACHE_UPDATE = null;
    public static final ActionType COMMENT_REPLY = null;
    public static final ActionType ENTER_BIG_PIC = null;
    public static final ActionType ENTER_MEANINGLESS = null;
    public static final ActionType ENTER_PRODUCT_DETAIL = null;
    public static final ActionType FETCH = null;
    public static final ActionType FETCH_COMMENT = null;
    public static final ActionType FILTER_EXPAND = null;
    public static final ActionType GROUP = null;
    public static final ActionType OPEN_SCHEMA = null;
    public static final ActionType OPEN_SHEET_PANEL = null;
    public static final ActionType REFRESH = null;
    public static final ActionType SLICE_UPDATE = null;
    public static final ActionType STORE_UPDATE = null;
    public static final ActionType TOAST = null;
    public static final ActionType TRACKER = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ActionType[] f172591a = null;
    private final String type;

    public static ActionType valueOf(String r100) {
        return (ActionType) a.a(ActionType.class, r100);
    }

    public static ActionType[] values() {
        return (ActionType[]) f172591a.clone();
    }

    static {
        ActionType r100 = new ActionType("GROUP", 0, "Group");
        GROUP = r100;
        ActionType r101 = new ActionType("TRACKER", 1, "Tracker");
        TRACKER = r101;
        ActionType r102 = new ActionType("FETCH", 2, "Fetch");
        FETCH = r102;
        ActionType r103 = new ActionType("ALERT", 3, "Alert");
        ALERT = r103;
        ActionType r104 = new ActionType("TOAST", 4, "Toast");
        TOAST = r104;
        ActionType r105 = new ActionType("REFRESH", 5, "Refresh");
        REFRESH = r105;
        ActionType r106 = new ActionType("OPEN_SCHEMA", 6, "OpenSchema");
        OPEN_SCHEMA = r106;
        ActionType r107 = new ActionType("SLICE_UPDATE", 7, "SliceUpdate");
        SLICE_UPDATE = r107;
        ActionType r108 = new ActionType("STORE_UPDATE", 8, "StoreUpdate");
        STORE_UPDATE = r108;
        ActionType r109 = new ActionType("CACHE_UPDATE", 9, "CacheUpdate");
        CACHE_UPDATE = r109;
        ActionType r110 = new ActionType("FETCH_COMMENT", 10, "FetchComment");
        FETCH_COMMENT = r110;
        ActionType r111 = new ActionType("FILTER_EXPAND", 11, "ExpandAnim");
        FILTER_EXPAND = r111;
        ActionType r112 = new ActionType("ENTER_BIG_PIC", 12, "EnterBigPic");
        ENTER_BIG_PIC = r112;
        ActionType r113 = new ActionType("COMMENT_REPLY", 13, "OpenReplyPanel");
        COMMENT_REPLY = r113;
        ActionType r114 = new ActionType("ENTER_PRODUCT_DETAIL", 14, "EnterProductDetail");
        ENTER_PRODUCT_DETAIL = r114;
        ActionType r115 = new ActionType("ENTER_MEANINGLESS", 15, "EnterMeaninglessPage");
        ENTER_MEANINGLESS = r115;
        ActionType r116 = new ActionType("OPEN_SHEET_PANEL", 16, "OpenSheetPanel");
        OPEN_SHEET_PANEL = r116;
        ActionType r117 = new ActionType("AUDIO_CONTROL", 17, "AudioControl");
        AUDIO_CONTROL = r117;
        f172591a = new ActionType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117};
    }

    public final String getType() {
        return this.type;
    }

    public ActionType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
