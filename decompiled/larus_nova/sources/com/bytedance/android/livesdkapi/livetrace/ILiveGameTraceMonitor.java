package com.bytedance.android.livesdkapi.livetrace;

import com.android.ttcjpaysdk.bindcard.base.constants.BindCardPayConfirmConstants;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\bf\u0018\u0000 \u00122\u00020\u0001:\u0004\u0011\u0012\u0013\u0014J.\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&J\\\u0010\u0002\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0007H&¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor;", "", "reportTraceEvent", "", "traceMetaWrapper", "Lcom/bytedance/android/livesdkapi/livetrace/TraceMetaWrapper;", "category", "Lorg/json/JSONObject;", "metric", "extra", "business_type", "", "event_type", "step", BindCardPayConfirmConstants.Key.TRACE_ID, "room_id", "log_id", "BusinessType", "Companion", "EventType", "Step", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveGameTraceMonitor {
    public static final String BUSINESS_TYPE = "business_type";
    public static final Companion Companion = null;
    public static final String EVENT_TYPE = "event_type";
    public static final String PRODUCT_ID = "webcast_client_game_promote";
    public static final String STEP = "step";
    public static final String TAG = "ILiveGameTraceMonitor";
    public static final String WILDCARD = "*";

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$BusinessType;", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface BusinessType {
        public static final Companion Companion = null;
        public static final String LIVE_PROMOTE = "live_promote";
        public static final String VIDEO_PROMOTE = "video_promote";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$BusinessType$Companion;", "", "()V", "LIVE_PROMOTE", "", "VIDEO_PROMOTE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String LIVE_PROMOTE = "live_promote";
            public static final String VIDEO_PROMOTE = "video_promote";

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$Companion;", "", "()V", "BUSINESS_TYPE", "", "EVENT_TYPE", "PRODUCT_ID", "STEP", "TAG", "WILDCARD", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final String BUSINESS_TYPE = "business_type";
        public static final String EVENT_TYPE = "event_type";
        public static final String PRODUCT_ID = "webcast_client_game_promote";
        public static final String STEP = "step";
        public static final String TAG = "ILiveGameTraceMonitor";
        public static final String WILDCARD = "*";

        private Companion() {
        }

        static {
            $$INSTANCE = new Companion();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$EventType;", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface EventType {
        public static final String ACTIVE_PROMOTE = "active_promote";
        public static final Companion Companion = null;
        public static final String PASSIVE_PROMOTE = "passive_promote";
        public static final String PROMOTE_BEFORE_LIVE = "promote_before_live";
        public static final String PROMOTE_IN_LIVE = "promote_in_live";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$EventType$Companion;", "", "()V", "ACTIVE_PROMOTE", "", "PASSIVE_PROMOTE", "PROMOTE_BEFORE_LIVE", "PROMOTE_IN_LIVE", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String ACTIVE_PROMOTE = "active_promote";
            public static final String PASSIVE_PROMOTE = "passive_promote";
            public static final String PROMOTE_BEFORE_LIVE = "promote_before_live";
            public static final String PROMOTE_IN_LIVE = "promote_in_live";

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0086\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$Step;", "", "Companion", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Step {
        public static final String ADD_LABEL_SUCCESS = "add_label_success";
        public static final Companion Companion = null;
        public static final String LABEL_CLICK = "label_click";
        public static final String LABEL_DELETE = "label_delete";
        public static final String LABEL_SHOW = "label_show";
        public static final String LABEL_TICK = "label_tick";
        public static final String OPEN_PROMOTION_PAGE = "open_promotion_page";
        public static final String OPEN_PROMOTION_PAGE_FINISHED = "open_promotion_page_finished";
        public static final String PREVIEW_TOOLBAR_REQUEST = "preview_toolbar_request";
        public static final String PROMOTE_CLICK = "promote_click";
        public static final String PUBLISH_PAGE_SHOW = "publish_page_show";
        public static final String SHOW_PROMOTE_TIP = "show_promote_tip";
        public static final String TRANSFER_PAGE_SCHEMA_ERROR = "transfer_page_schema_error";
        public static final String TRANSFER_PAGE_SCHEMA_REQUEST = "transfer_page_schema_request";
        public static final String UPDATE_ANCHOR_CONTENT = "update_anchor_content";
        public static final String UPDATE_ANCHOR_CONTENT_FAIL = "update_anchor_content_fail";

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/livesdkapi/livetrace/ILiveGameTraceMonitor$Step$Companion;", "", "()V", "ADD_LABEL_SUCCESS", "", "LABEL_CLICK", "LABEL_DELETE", "LABEL_SHOW", "LABEL_TICK", "OPEN_PROMOTION_PAGE", "OPEN_PROMOTION_PAGE_FINISHED", "PREVIEW_TOOLBAR_REQUEST", "PROMOTE_CLICK", "PUBLISH_PAGE_SHOW", "SHOW_PROMOTE_TIP", "TRANSFER_PAGE_SCHEMA_ERROR", "TRANSFER_PAGE_SCHEMA_REQUEST", "UPDATE_ANCHOR_CONTENT", "UPDATE_ANCHOR_CONTENT_FAIL", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;
            public static final String ADD_LABEL_SUCCESS = "add_label_success";
            public static final String LABEL_CLICK = "label_click";
            public static final String LABEL_DELETE = "label_delete";
            public static final String LABEL_SHOW = "label_show";
            public static final String LABEL_TICK = "label_tick";
            public static final String OPEN_PROMOTION_PAGE = "open_promotion_page";
            public static final String OPEN_PROMOTION_PAGE_FINISHED = "open_promotion_page_finished";
            public static final String PREVIEW_TOOLBAR_REQUEST = "preview_toolbar_request";
            public static final String PROMOTE_CLICK = "promote_click";
            public static final String PUBLISH_PAGE_SHOW = "publish_page_show";
            public static final String SHOW_PROMOTE_TIP = "show_promote_tip";
            public static final String TRANSFER_PAGE_SCHEMA_ERROR = "transfer_page_schema_error";
            public static final String TRANSFER_PAGE_SCHEMA_REQUEST = "transfer_page_schema_request";
            public static final String UPDATE_ANCHOR_CONTENT = "update_anchor_content";
            public static final String UPDATE_ANCHOR_CONTENT_FAIL = "update_anchor_content_fail";

            private Companion() {
            }

            static {
                $$INSTANCE = new Companion();
            }
        }

        static {
            Companion = Companion.$$INSTANCE;
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    void reportTraceEvent(TraceMetaWrapper r100, JSONObject r101, JSONObject r102, JSONObject r103);

    void reportTraceEvent(String r100, String r101, String r102, String r103, String r104, String r105, JSONObject r106, JSONObject r107, JSONObject r108);
}
