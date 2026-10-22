package com.bytedance.android.livesdk.feed.tab.monitor;

import android.os.SystemClock;
import com.bytedance.android.live.api.exceptions.local.ResponseNoDataException;
import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.android.live.core.monitor.BaseMonitor;
import com.bytedance.android.live.core.monitor.LiveTracingMonitor;
import com.bytedance.android.live.core.network.CustomApiServerException;
import com.bytedance.android.live.network.response.BaseResponse;
import com.ss.android.http.legacy.client.HttpResponseException;
import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class FeedTabMonitor extends BaseMonitor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f124482a;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006j\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/feed/tab/monitor/FeedTabMonitor$Action;", "", "", "action", "Ljava/lang/String;", "getAction", "()Ljava/lang/String;", SocialConstants.PARAM_APP_DESC, "getDesc", "TRIGGER_ACTION_BOOST", "TRIGGER_ACTION_BOOST_LATE", "TRIGGER_ACTION_ENTER_ROOM", "TRIGGER_ACTION_OPEN_TAB_PAGE", "DEFAULT", "livefeed_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Action extends Enum<Action> {
        public static final Action DEFAULT = null;
        public static final Action TRIGGER_ACTION_BOOST = null;
        public static final Action TRIGGER_ACTION_BOOST_LATE = null;
        public static final Action TRIGGER_ACTION_ENTER_ROOM = null;
        public static final Action TRIGGER_ACTION_OPEN_TAB_PAGE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Action[] f124483a = null;
        private final String action;
        private final String desc;

        static {
            Action r100 = new Action("TRIGGER_ACTION_BOOST", 0, "boost", "冷启");
            TRIGGER_ACTION_BOOST = r100;
            Action r101 = new Action("TRIGGER_ACTION_BOOST_LATE", 1, "boost_1min", "冷启1min");
            TRIGGER_ACTION_BOOST_LATE = r101;
            Action r102 = new Action("TRIGGER_ACTION_ENTER_ROOM", 2, "enter_room", "进房");
            TRIGGER_ACTION_ENTER_ROOM = r102;
            Action r103 = new Action("TRIGGER_ACTION_OPEN_TAB_PAGE", 3, "open_tab_page", "打开tab页面");
            TRIGGER_ACTION_OPEN_TAB_PAGE = r103;
            Action r104 = new Action("DEFAULT", 4, "default", "默认");
            DEFAULT = r104;
            f124483a = new Action[]{r100, r101, r102, r103, r104};
        }

        public static Action valueOf(String r100) {
            return (Action) r27.a.a(Action.class, r100);
        }

        public static Action[] values() {
            return (Action[]) f124483a.clone();
        }

        public final String getAction() {
            return this.action;
        }

        public final String getDesc() {
            return this.desc;
        }

        public Action(String r100, int r101, String r102, String r103) {
            super(r100, r101);
            this.action = r102;
            this.desc = r103;
        }
    }

    public static final class a {
    }

    static {
    }

    public FeedTabMonitor() {
    }

    public final void m(Action r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        BaseMonitor.add(r101, "status", 0);
        BaseMonitor.add(r101, "trigger_action", r100.getAction());
        JSONObject r102 = new JSONObject();
        if (this.f124482a <= 0) goto L5;
        long r103 = SystemClock.uptimeMillis() - this.f124482a;
    L6:
        this.f124482a = 0;
        if (r103 <= 0) goto L9;
        BaseMonitor.add(r102, "latency", r103);
    L9:
        LiveTracingMonitor.e("ttlive_service_request_tab_api_all", LiveTracingMonitor.EventModule.FEED_TAB, LiveTracingMonitor.EventType.SERVER_API_CALL, r101, r102, null);
        return;
    L5:
        r103 = 0;
        goto L6
    }

    public final void l(Action r110, Throwable r111) {
        Intrinsics.checkNotNullParameter(r110, "action");
        if (this.f124482a <= 0) goto L5;
        SystemClock.uptimeMillis();
    L5:
        this.f124482a = 0;
        boolean r100 = r111 instanceof CustomApiServerException;
        if (r100 == false) goto L9;
        int r101 = ((CustomApiServerException) r111).getErrorCode();
    L18:
        JSONObject r102 = new JSONObject();
        boolean r103 = true;
        BaseMonitor.add(r102, "status", 1);
        BaseMonitor.add(r102, "status_code", r101);
        BaseMonitor.add(r102, "trigger_action", r110.getAction());
        JSONObject r112 = new JSONObject();
        if (r100 == false) goto L22;
        String r104 = ((CustomApiServerException) r111).getXTtLogId();
    L28:
        if (r104 != null) goto L30;
    L33:
        boolean r105 = true;
    L34:
        if (r105 == true) goto L36;
        BaseMonitor.add(r112, "logId", r104);
    L36:
        BaseMonitor.add(r112, "error_code", r101);
        if ((r111 instanceof ApiServerException) == false) goto L40;
        String r113 = ((ApiServerException) r111).getErrorMsg();
    L46:
        if (r113 != null) goto L48;
    L51:
        if (r103 == true) goto L53;
        BaseMonitor.add(r112, "error_msg", r113);
    L53:
        LiveTracingMonitor.EventModule r114 = LiveTracingMonitor.EventModule.FEED_TAB;
        LiveTracingMonitor.EventType r106 = LiveTracingMonitor.EventType.SERVER_API_CALL;
        LiveTracingMonitor.e("ttlive_service_request_tab_api_error", r114, r106, r102, null, r112);
        LiveTracingMonitor.e("ttlive_service_request_tab_api_all", r114, r106, r102, null, r112);
        return;
    L48:
        if (r113.length() == 0) goto L51;
        r103 = false;
        goto L51
    L40:
        if ((r111 instanceof NetworkErrorException) == false) goto L43;
        r113 = r111.getMessage();
        goto L46
    L43:
        if ((r111 instanceof Exception) == false) goto L45;
        r113 = r111.getMessage();
        goto L46
    L45:
        r113 = null;
        goto L46
    L30:
        if (r104.length() == 0) goto L33;
        r105 = false;
        goto L34
    L22:
        if ((r111 instanceof ResponseNoDataException) == false) goto L26;
        BaseResponse r107 = ((ResponseNoDataException) r111).getResponse();
        if (r107 == null) goto L26;
        r104 = r107.logId;
    L26:
        r104 = null;
        goto L28
    L9:
        if ((r111 instanceof HttpResponseException) == false) goto L12;
        r101 = ((HttpResponseException) r111).getStatusCode();
        goto L18
    L12:
        if ((r111 instanceof ApiException) == false) goto L15;
        r101 = ((ApiException) r111).getErrorCode();
        goto L18
    L15:
        if ((r111 instanceof NetworkErrorException) == false) goto L17;
        r101 = ((NetworkErrorException) r111).statusCode;
        goto L18
    L17:
        r101 = -1;
        goto L18
    }
}
