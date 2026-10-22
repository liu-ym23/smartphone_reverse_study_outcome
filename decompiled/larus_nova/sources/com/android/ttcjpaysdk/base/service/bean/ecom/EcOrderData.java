package com.android.ttcjpaysdk.base.service.bean.ecom;

import android.text.TextUtils;
import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.utils.CJBasicCommonUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006\u0018"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ecom/EcOrderData;", "", "service", "", "paySdkInfo", "Lorg/json/JSONObject;", "extJSON", Segment.JsonKey.START, "errMsg", "", "skipPay", "", "(ILorg/json/JSONObject;Lorg/json/JSONObject;ILjava/lang/String;Z)V", "getErrMsg", "()Ljava/lang/String;", "getExtJSON", "()Lorg/json/JSONObject;", "getPaySdkInfo", "getService", "()I", "getSkipPay", "()Z", "getSt", "Companion", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EcOrderData {
    public static final Companion Companion = null;
    private final String errMsg;
    private final JSONObject extJSON;
    private final JSONObject paySdkInfo;
    private final int service;
    private final boolean skipPay;

    /* JADX INFO: renamed from: st, reason: collision with root package name */
    private final int f29361st;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J.\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/base/service/bean/ecom/EcOrderData$Companion;", "", "()V", "create", "Lcom/android/ttcjpaysdk/base/service/bean/ecom/EcOrderData;", "oriSdkInfo", "Lorg/json/JSONObject;", "subWay", "", "extJSON", "responseJSON", "timeInfo", "Lcom/android/ttcjpaysdk/base/service/bean/ecom/EcOrderTimeInfo;", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final EcOrderData create(JSONObject r110, String r111, JSONObject r112, JSONObject r113, EcOrderTimeInfo r114) throws IllegalArgumentException {
            Intrinsics.checkNotNullParameter(r110, "oriSdkInfo");
            Intrinsics.checkNotNullParameter(r111, "subWay");
            Intrinsics.checkNotNullParameter(r112, "extJSON");
            Intrinsics.checkNotNullParameter(r113, "responseJSON");
            Intrinsics.checkNotNullParameter(r114, "timeInfo");
            int r100 = JSONObjectProtectorUtils.getInt(r113, Segment.JsonKey.START);
            String r101 = JSONObjectProtectorUtils.getString(r113, "msg");
            if (r100 != 0) goto L5;
            int r102 = JSONObjectProtectorUtils.getInt(r110, "sdk_service");
            JSONObject r115 = JSONObjectProtectorUtils.getJSONObject(r113, "data");
            JSONObject r116 = r115.optJSONObject("data");
            if (r116 == null) goto L9;
            JSONObject r117 = r116.optJSONObject("sdk_info");
        L10:
            if (r117 != null) goto L12;
            r117 = new JSONObject();
        L12:
            String r103 = r115.optString("order_id");
            JSONArray r104 = r115.optJSONArray("orderIds");
            boolean r105 = false;
            if (TextUtils.isEmpty(r103) == true) goto L15;
            String r106 = r103;
        L23:
            if (TextUtils.isEmpty(r106) == true) goto L42;
            boolean r107 = r115.optBoolean("skipPay", false);
            if (r107 == false) goto L27;
        L29:
            if (r105 == false) goto L31;
            String r118 = r117.optString("url");
            JSONObject r108 = new JSONObject();
            r108.put("app_id", "wx50d801314d9eb858");
            r108.put("mweb_url", r118);
            r108.put("url", r118);
            r117 = r108;
        L31:
            JSONObjectProtectorUtils.getJSONObject(r112, "track_info").put(b.B0, r106);
            JSONObject r119 = JSONObjectProtectorUtils.getJSONObject(r112, "timestamp_info");
            r119.put("create_order_request", r114.getCreateOrderRequestTs());
            r119.put("create_order_response", r114.getCreateOrderResponseTs());
            if (r102 == 1) goto L40;
            if (r102 == 2) goto L40;
            r112.put("sdk_show_info", JSONObjectProtectorUtils.getJSONObject(new JSONObject(JSONObjectProtectorUtils.getString(r117, "zg_info")), "sdk_show_info"));     // Catch: Throwable -> L37
        L37:
            th = move-exception;
            CJBasicCommonUtils.reportCatchException("EcOrderData#create", th);
            CJBasicCommonUtils.logCatch("CJCatch", "EcOrderData#create", th);
        L40:
            return new EcOrderData(r102, r117, r112, r100, r101, r107);
        L27:
            if (Intrinsics.areEqual(r111, "0") == true) goto L29;
            r105 = true;
            goto L29
        L42:
            throw new IllegalArgumentException("no available order id " + r103 + ',' + r104);
        L15:
            if (r104 != null) goto L17;
        L21:
            r106 = "";
            goto L23
        L17:
            if (r104.length() <= 0) goto L21;
            r106 = JSONArrayProtectorUtils.getString(r104, 0);
            if (TextUtils.isEmpty(r106) == true) goto L21;
        L9:
            r117 = null;
            goto L10
        L5:
            return new EcOrderData(-1, new JSONObject(), r112, r100, r101, false);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public final String getErrMsg() {
        return this.errMsg;
    }

    public final JSONObject getExtJSON() {
        return this.extJSON;
    }

    public final JSONObject getPaySdkInfo() {
        return this.paySdkInfo;
    }

    public final int getService() {
        return this.service;
    }

    public final boolean getSkipPay() {
        return this.skipPay;
    }

    public final int getSt() {
        return this.f29361st;
    }

    public EcOrderData(int r100, JSONObject r101, JSONObject r102, int r103, String r104, boolean r105) {
        Intrinsics.checkNotNullParameter(r101, "paySdkInfo");
        Intrinsics.checkNotNullParameter(r102, "extJSON");
        Intrinsics.checkNotNullParameter(r104, "errMsg");
        this.service = r100;
        this.paySdkInfo = r101;
        this.extJSON = r102;
        this.f29361st = r103;
        this.errMsg = r104;
        this.skipPay = r105;
    }
}
