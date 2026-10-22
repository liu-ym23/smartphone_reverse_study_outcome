package com.bytedance.android.gamecp.common.utils;

import com.bytedance.android.gamecp.common.model.ShowCardResult;
import com.bytedance.android.gamecp.common.monitor.LiveTracingMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class GameOrderMonitor extends hu.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final LiveTracingMonitor.EventModule f57161a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final GameOrderMonitor f57162b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/gamecp/common/utils/GameOrderMonitor$OrderCardSource;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "IM", "ENTER_ROOM", "gamecp-common_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum OrderCardSource extends Enum<OrderCardSource> {
        public static final OrderCardSource ENTER_ROOM = null;
        public static final OrderCardSource IM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ OrderCardSource[] f57163a = null;
        private final String value;

        static {
            OrderCardSource r100 = new OrderCardSource("IM", 0, "IM");
            IM = r100;
            OrderCardSource r101 = new OrderCardSource("ENTER_ROOM", 1, "enterRoom");
            ENTER_ROOM = r101;
            f57163a = new OrderCardSource[]{r100, r101};
        }

        public static OrderCardSource valueOf(String r100) {
            return (OrderCardSource) r27.a.a(OrderCardSource.class, r100);
        }

        public static OrderCardSource[] values() {
            return (OrderCardSource[]) f57163a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public OrderCardSource(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    static {
        f57162b = new GameOrderMonitor();
        f57161a = LiveTracingMonitor.EventModule.GAME_ORDER;
    }

    public GameOrderMonitor() {
    }

    public final void d(OrderCardSource r110, ShowCardResult r111) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "result");
        if (r111.getCode() != 0) goto L5;
        JSONObject r100 = new JSONObject();
        JSONObject r101 = new JSONObject();
        hu.a.b(r100, "type", r110.getValue());
        c(this, "ttlive_reserve_game_receive_show_card_signal", true, r101, r100, 20);
        return;
    L5:
        JSONObject r112 = new JSONObject();
        hu.a.b(r112, "error_msg", r111.getMsg());
        hu.a.a(r112, "error_code", r111.getCode());
        c(this, "ttlive_reserve_game_show_card_all", false, r112, null, 52);
    }

    public static void c(GameOrderMonitor r100, String r101, boolean r102, JSONObject r103, JSONObject r104, int r105) {
        if ((r105 & 8) == 0) goto L6;
        r103 = new JSONObject();
    L6:
        if ((r105 & 16) == 0) goto L8;
        JSONObject r106 = new JSONObject();
    L10:
        if ((r105 & 32) == 0) goto L12;
        r104 = new JSONObject();
    L12:
        r100.getClass();
        hu.a.a(r104, "status", !r102 ? 1 : 0);
        LiveTracingMonitor.b(r101, f57161a, r104, r106, r103);
        return;
    L8:
        r106 = null;
        goto L10
    }
}
