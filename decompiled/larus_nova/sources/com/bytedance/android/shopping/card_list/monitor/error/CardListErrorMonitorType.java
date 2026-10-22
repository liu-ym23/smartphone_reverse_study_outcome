package com.bytedance.android.shopping.card_list.monitor.error;

import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.larus.bmhome.instruction.monitor.SuggestPromptErrorType;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/shopping/card_list/monitor/error/CardListErrorMonitorType;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", SuggestPromptErrorType.ERROR_TYPE_CRASH, "ADD_POINT", "SELF_GET_STORAGE", "CARD_LIST_LOAD_AGAIN", "LONG_FIRST_QUERY", "WHITE_SCREEN_7S", "CARD_LIST_SESSION_ID_MISMATCH", "PAGE_DESTROY_BEFORE_FIRST_SCREEN", "CARD_LIST_FIRST_QUERY_FAIL", "CARD_LIST_OTHER_QUERY_FAIL", "GET_QUERY_REJECT", "GET_QUERY_RESPONSE_ERROR", "QUERY_FOR_COUPON_RESPONSE_FAIL", "GET_OBJECT_FROM_MAP", "TRANSFORM_TO_DTO", "FIRST_FETCH_RESP_ERROR", "NETWORK_ERROR", "HYBRID_PANEL_OPEN_ERROR", "LOADING_VIEW_EXIT", "ERROR_VIEW_SHOW", "SELF_FUN_ERROR", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final enum CardListErrorMonitorType extends Enum<CardListErrorMonitorType> {
    public static final CardListErrorMonitorType ADD_POINT = null;
    public static final CardListErrorMonitorType CARD_LIST_FIRST_QUERY_FAIL = null;
    public static final CardListErrorMonitorType CARD_LIST_LOAD_AGAIN = null;
    public static final CardListErrorMonitorType CARD_LIST_OTHER_QUERY_FAIL = null;
    public static final CardListErrorMonitorType CARD_LIST_SESSION_ID_MISMATCH = null;
    public static final CardListErrorMonitorType CRASH = null;
    public static final CardListErrorMonitorType ERROR_VIEW_SHOW = null;
    public static final CardListErrorMonitorType FIRST_FETCH_RESP_ERROR = null;
    public static final CardListErrorMonitorType GET_OBJECT_FROM_MAP = null;
    public static final CardListErrorMonitorType GET_QUERY_REJECT = null;
    public static final CardListErrorMonitorType GET_QUERY_RESPONSE_ERROR = null;
    public static final CardListErrorMonitorType HYBRID_PANEL_OPEN_ERROR = null;
    public static final CardListErrorMonitorType LOADING_VIEW_EXIT = null;
    public static final CardListErrorMonitorType LONG_FIRST_QUERY = null;
    public static final CardListErrorMonitorType NETWORK_ERROR = null;
    public static final CardListErrorMonitorType PAGE_DESTROY_BEFORE_FIRST_SCREEN = null;
    public static final CardListErrorMonitorType QUERY_FOR_COUPON_RESPONSE_FAIL = null;
    public static final CardListErrorMonitorType SELF_FUN_ERROR = null;
    public static final CardListErrorMonitorType SELF_GET_STORAGE = null;
    public static final CardListErrorMonitorType TRANSFORM_TO_DTO = null;
    public static final CardListErrorMonitorType WHITE_SCREEN_7S = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardListErrorMonitorType[] f171684a = null;
    private final String value;

    public static CardListErrorMonitorType valueOf(String r100) {
        return (CardListErrorMonitorType) r27.a.a(CardListErrorMonitorType.class, r100);
    }

    public static CardListErrorMonitorType[] values() {
        return (CardListErrorMonitorType[]) f171684a.clone();
    }

    static {
        CardListErrorMonitorType r100 = new CardListErrorMonitorType(SuggestPromptErrorType.ERROR_TYPE_CRASH, 0, "crash");
        CRASH = r100;
        CardListErrorMonitorType r101 = new CardListErrorMonitorType("ADD_POINT", 1, "CardListYataFirstScreenDurationMonitor-ADD_POINT");
        ADD_POINT = r101;
        CardListErrorMonitorType r102 = new CardListErrorMonitorType("SELF_GET_STORAGE", 2, "selfGetStorage");
        SELF_GET_STORAGE = r102;
        CardListErrorMonitorType r103 = new CardListErrorMonitorType("CARD_LIST_LOAD_AGAIN", 3, "CARD_LIST_LOAD_AGAIN");
        CARD_LIST_LOAD_AGAIN = r103;
        CardListErrorMonitorType r104 = new CardListErrorMonitorType("LONG_FIRST_QUERY", 4, "long_first_query");
        LONG_FIRST_QUERY = r104;
        CardListErrorMonitorType r105 = new CardListErrorMonitorType("WHITE_SCREEN_7S", 5, "white_screen_7s");
        WHITE_SCREEN_7S = r105;
        CardListErrorMonitorType r106 = new CardListErrorMonitorType("CARD_LIST_SESSION_ID_MISMATCH", 6, "card_list_session_id_mismatch");
        CARD_LIST_SESSION_ID_MISMATCH = r106;
        CardListErrorMonitorType r107 = new CardListErrorMonitorType("PAGE_DESTROY_BEFORE_FIRST_SCREEN", 7, "page_destroy_before_first_screen");
        PAGE_DESTROY_BEFORE_FIRST_SCREEN = r107;
        CardListErrorMonitorType r108 = new CardListErrorMonitorType("CARD_LIST_FIRST_QUERY_FAIL", 8, "card_list_first_query_fail");
        CARD_LIST_FIRST_QUERY_FAIL = r108;
        CardListErrorMonitorType r109 = new CardListErrorMonitorType("CARD_LIST_OTHER_QUERY_FAIL", 9, "card_list_other_query_fail");
        CARD_LIST_OTHER_QUERY_FAIL = r109;
        CardListErrorMonitorType r110 = new CardListErrorMonitorType("GET_QUERY_REJECT", 10, "get_query_reject");
        GET_QUERY_REJECT = r110;
        CardListErrorMonitorType r111 = new CardListErrorMonitorType("GET_QUERY_RESPONSE_ERROR", 11, "get_query_response_error");
        GET_QUERY_RESPONSE_ERROR = r111;
        CardListErrorMonitorType r112 = new CardListErrorMonitorType("QUERY_FOR_COUPON_RESPONSE_FAIL", 12, "query_for_coupon_response_fail");
        QUERY_FOR_COUPON_RESPONSE_FAIL = r112;
        CardListErrorMonitorType r113 = new CardListErrorMonitorType("GET_OBJECT_FROM_MAP", 13, "get_object_from_map");
        GET_OBJECT_FROM_MAP = r113;
        CardListErrorMonitorType r114 = new CardListErrorMonitorType("TRANSFORM_TO_DTO", 14, "transform_to_dto");
        TRANSFORM_TO_DTO = r114;
        CardListErrorMonitorType r115 = new CardListErrorMonitorType("FIRST_FETCH_RESP_ERROR", 15, "first_fetch-response-error");
        FIRST_FETCH_RESP_ERROR = r115;
        CardListErrorMonitorType r116 = new CardListErrorMonitorType("NETWORK_ERROR", 16, BuyNowCloseMethod.NETWORK_ERROR);
        NETWORK_ERROR = r116;
        CardListErrorMonitorType r117 = new CardListErrorMonitorType("HYBRID_PANEL_OPEN_ERROR", 17, "hybrid_panel_open_error");
        HYBRID_PANEL_OPEN_ERROR = r117;
        CardListErrorMonitorType r118 = new CardListErrorMonitorType("LOADING_VIEW_EXIT", 18, "loading_view_exit");
        LOADING_VIEW_EXIT = r118;
        CardListErrorMonitorType r119 = new CardListErrorMonitorType("ERROR_VIEW_SHOW", 19, "ErrorView-Show");
        ERROR_VIEW_SHOW = r119;
        CardListErrorMonitorType r120 = new CardListErrorMonitorType("SELF_FUN_ERROR", 20, "SELF_FUN_ERROR");
        SELF_FUN_ERROR = r120;
        f171684a = new CardListErrorMonitorType[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r120};
    }

    public final String getValue() {
        return this.value;
    }

    public CardListErrorMonitorType(String r100, int r101, String r102) {
        super(r100, r101);
        this.value = r102;
    }
}
