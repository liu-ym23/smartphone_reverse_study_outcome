package com.bytedance.android.livesdk.jsbridge.methods;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.ContextUtil;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.ies.web.jsbridge2.CallContext;
import com.google.gson.annotations.SerializedName;
import com.huawei.hms.adapter.internal.CommonCode;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import io.reactivex.disposables.CompositeDisposable;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes9.dex */
public final class y extends com.bytedance.ies.web.jsbridge2.f<a, JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CompositeDisposable f142248a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f142249b;

    public static final class a {

        @SerializedName(EventConstant.Key.AGE_LARGER_14)
        public int ageLargerFourteen;

        @SerializedName("api_request_params")
        public Map<String, String> apiRequestParams;

        @SerializedName("cert_type")
        public int certType;

        @SerializedName(LocationMonitorConst.CERT_TOKEN)
        public String certoken;

        @SerializedName("children_cert_token")
        public String childrenCertToken;

        @SerializedName("conversation_id")
        public String conversationId;

        @SerializedName("enter_from")
        public String enterFrom;

        @SerializedName(BytedCertConstant.CertKey.IDENTITY_CODE)
        public String identityCode;

        @SerializedName(BytedCertConstant.CertKey.IDENTITY_NAME)
        public String identityName;

        @SerializedName("is_simplified")
        public int isSimplified;

        @SerializedName("skip_record_verify")
        public boolean isSkipRecordVerify;

        @SerializedName(CommonCode.MapKey.TRANSACTION_ID)
        public String transactionId;

        @SerializedName("url")
        public String url;

        @SerializedName("verified_page_source")
        public String verifiedPageSource;

        @SerializedName("youth_cert_scene")
        public int youthCertScene;

        public a() {
        }
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void onTerminate() {
        this.f142248a.clear();
    }

    public y() {
        this.f142248a = new CompositeDisposable();
    }

    @Override // com.bytedance.ies.web.jsbridge2.f
    public final void invoke(a r110, CallContext r111) throws Exception {
        final a r112 = r110;
        Activity r100 = ContextUtil.contextToActivity(r111.getContext());
        if (r100 != null) goto L6;
        return;
    L6:
        if (com.bytedance.android.live.core.verify.utils.a.j() == false) goto L8;
        finishWithResult(com.bytedance.android.live.browser.jsbridge.s.a(-1000, "aliyun service proxy is unavaliable"));
        return;
    L8:
        w80.a r101 = new w80.a();
        r101.transactionId = r112.transactionId;
        r101.url = r112.url;
        r101.certToken = r112.certoken;
        r101.certType = r112.certType;
        r101.childrenCertToken = r112.childrenCertToken;
        r101.youthCertScene = r112.youthCertScene;
        r101.ageLargerFourteen = r112.ageLargerFourteen;
        r101.verifiedPageSource = r112.verifiedPageSource;
        r101.apiRequestParams = r112.apiRequestParams;
        this.f142249b = r112.enterFrom;
        Bundle r102 = new Bundle();
        ALogger.e("AliYunVerifyMethod", "doAliYunVerify isSimplified->" + r112.isSimplified);
        if (r112.isSimplified != 1) goto L11;
        String r113 = "simplified_realname";
    L12:
        r102.putString("verify_type", r113);
        if (TextUtils.isEmpty(r112.verifiedPageSource) == false) goto L15;
        String r114 = "";
    L16:
        r102.putString("verified_page_source", r114);
        r102.putString(EventConstant.Key.AGE_LARGER_14, String.valueOf(r112.ageLargerFourteen));
        r102.putString("conversation_id", r112.conversationId);
        com.bytedance.android.live.core.verify.utils.a.o(r100, r101, this.f142249b, r102, 3, null, false, new w(this), new x(this, r112), r112.isSkipRecordVerify, true);
        return;
    L15:
        r114 = r112.verifiedPageSource;
        goto L16
    L11:
        r113 = "realname";
        goto L12
    }
}
