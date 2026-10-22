package com.bytedance.android.live.wallet.utils.monitor;

import com.bytedance.android.live.core.monitor.LiveSlardarMonitor;
import fd1.b;
import org.json.JSONException;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes7.dex */
public final class OrderMonitor {

    public static final enum Stage extends Enum<Stage> {
        public static final Stage ALI_PAY = null;
        public static final Stage CHECK_ORDER = null;
        public static final Stage CONSUME = null;
        public static final Stage CREATE_ORDER = null;
        public static final Stage GOOGLE_PAY = null;
        public static final Stage VERIFY = null;
        public static final Stage WALLET = null;
        public static final Stage WECHAT_PAY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Stage[] f102762a = null;
        private final String domain;

        static {
            Stage r100 = new Stage("CREATE_ORDER", 0, "create");
            CREATE_ORDER = r100;
            Stage r101 = new Stage("ALI_PAY", 1, "alipay");
            ALI_PAY = r101;
            Stage r102 = new Stage("WECHAT_PAY", 2, "wxpay");
            WECHAT_PAY = r102;
            Stage r103 = new Stage("GOOGLE_PAY", 3, "google_pay");
            GOOGLE_PAY = r103;
            Stage r104 = new Stage("CHECK_ORDER", 4, "check");
            CHECK_ORDER = r104;
            Stage r105 = new Stage("WALLET", 5, "wallet");
            WALLET = r105;
            Stage r110 = new Stage("VERIFY", 6, "verify");
            VERIFY = r110;
            Stage r111 = new Stage("CONSUME", 7, "consume");
            CONSUME = r111;
            f102762a = new Stage[]{r100, r101, r102, r103, r104, r105, r110, r111};
        }

        public static Stage[] values() {
            return (Stage[]) f102762a.clone();
        }

        public static /* synthetic */ String access$000(Stage r100) {
            return r100.domain;
        }

        public static Stage valueOf(String r100) {
            return (Stage) a.a(Stage.class, r100);
        }

        public Stage(String r100, int r101, String r102) {
            super(r100, r101);
            this.domain = r102;
        }
    }

    public static void a(Stage r100, String r101, String r102, JSONObject r103) {
        if (r103 == null) goto L10;
    L6:
        r103.put("errorDomain", Stage.access$000(r100));     // Catch: JSONException -> L4
        r103.put("errorCode", r101);     // Catch: JSONException -> L4
        r103.put("errorDesc", r102);     // Catch: JSONException -> L4
        int r104 = b.f476458a;     // Catch: JSONException -> L4
        LiveSlardarMonitor.monitorStatusRate("hotsoon_live_recharge_failure_rate", 1, r103);     // Catch: JSONException -> L4
        return;
    L4:
        e = move-exception;
        e.printStackTrace();
        return;
    L10:
        r103 = new JSONObject();     // Catch: JSONException -> L4
        goto L6
    }
}
