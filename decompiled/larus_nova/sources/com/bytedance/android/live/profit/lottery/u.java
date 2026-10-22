package com.bytedance.android.live.profit.lottery;

import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class u extends com.bytedance.ies.web.jsbridge2.f<a, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.live.datacontext.k<Unit> f88208a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LotteryState f88209b;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/bytedance/android/live/profit/lottery/u$a;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "lotteryId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("lotteryId")
        private final String lotteryId;

        @SerializedName("type")
        private final String type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.type, r101.type) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.lotteryId, r101.lotteryId) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.type;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.lotteryId;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "Params(type=" + this.type + ", lotteryId=" + this.lotteryId + ")";
        }

        public final String a() {
            return this.lotteryId;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
    }

    public u(com.bytedance.live.datacontext.k<Unit> r100, LotteryState r101) {
        Intrinsics.checkNotNullParameter(r100, "onSubmit");
        this.f88208a = r100;
        this.f88209b = r101;
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r100, CallContext r101) {
        a r102 = r100;
        Intrinsics.checkNotNullParameter(r102, "params");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r103 = r102.getType();
        JsonElement r104 = null;
        LotteryState r105 = null;
        r104 = null;
        switch(r103.hashCode()) {
            case -1559401418: goto L33;
            case -990193242: goto L30;
            case 190538204: goto L16;
            case 1938485734: goto L6;
            default: goto L50;
        };
    L50:
        finishWithFailure();
        return;
    L6:
        if (r103.equals("get_lottery_left_time") == false) goto L50;
        LotteryState r106 = this.f88209b;
        if ((r106 instanceof LotteryState.g) == false) goto L11;
        r105 = r106;
    L11:
        LotteryState.g r107 = (LotteryState.g) r105;
        long r108 = 0;
        if (r107 == null) goto L14;
        r108 = Math.max(r107.f88032a.f88196c - System.currentTimeMillis(), 0);
    L14:
        JsonObject r109 = new JsonObject();
        r109.add("timeLeft", new JsonPrimitive(String.valueOf(r108)));
        Unit r110 = Unit.INSTANCE;
        finishWithResult(r109);
        return;
    L16:
        if (r103.equals("get_lottery_result") == false) goto L50;
        JsonObject r111 = new JsonObject();
        LotteryState r112 = this.f88209b;
        if ((r112 instanceof LotteryState.b) == true) goto L20;
        r112 = null;
    L20:
        LotteryState.b r113 = (LotteryState.b) r112;
        if (r113 == null) goto L25;
        p0 r114 = r113.f88025b;
        if (r114 == null) goto L25;
        r104 = r114.f88168d;
    L25:
        if (r104 != null) goto L28;
        r104 = JsonNull.INSTANCE;
    L28:
        r111.add("data", r104);
        finishWithResult(r111);
        return;
    L30:
        if (r103.equals("anchor_submit_success") == false) goto L50;
        this.f88208a.post(Unit.INSTANCE);
        finishWithSuccess();
        return;
    L33:
        if (r103.equals("get_result_extra_info") == false) goto L50;
        String r115 = r102.a();
        String r116 = "";
        if (r115 != null) goto L37;
        r115 = "";
    L37:
        ALogger.i("LotteryActionMethod", "from get_result_extra_info  lotteryId = ".concat(r115));
        JsonObject r117 = new JsonObject();
        if (TextUtils.isEmpty(r115) == true) goto L49;
        Map<String, String> r118 = b1.f88042a;
        Intrinsics.checkNotNullParameter(r115, "key");
        Map<String, String> r119 = b1.f88042a;
        if (r119.containsKey(r115) == false) goto L49;
        Intrinsics.checkNotNullParameter(r115, "key");
        String r120 = (String) ((LinkedHashMap) r119).get(r115);
        if (r120 != null) goto L44;
        r120 = "";
    L44:
        r117.add("resultExtraInfo", new JsonPrimitive(r120));
        StringBuilder r121 = new StringBuilder("result  lotteryId = ");
        r121.append(r115);
        r121.append("   resultExtraInfo = ");
        Intrinsics.checkNotNullParameter(r115, "key");
        String r122 = (String) ((LinkedHashMap) r119).get(r115);
        if (r122 == null) goto L48;
        r116 = r122;
    L48:
        r121.append(r116);
        ALogger.i("LotteryActionMethod", r121.toString());
    L49:
        ((LinkedHashMap) b1.f88042a).clear();
        finishWithResult(r117);
    }
}
