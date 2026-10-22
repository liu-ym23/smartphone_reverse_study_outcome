package com.android.ttcjpaysdk.base.service;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.android.ttcjpaysdk.base.service.bean.H5ParamBuilder;
import com.android.ttcjpaysdk.base.service.bean.H5SchemeParamBuilder;
import com.android.ttcjpaysdk.ttcjpayapi.ICJPayXBridgeCallback;
import com.android.ttcjpaysdk.ttcjpayapi.TTCJPayRealNamePasswordCallback;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONObject;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
public interface ICJPayH5Service extends ICJPayService {

    public static final enum WxH5PayFrom extends Enum<WxH5PayFrom> {
        private static final /* synthetic */ WxH5PayFrom[] $VALUES = null;
        public static final WxH5PayFrom CJPayConfirmFragment = null;
        public static final WxH5PayFrom CJPayWXPaymentService = null;
        public static final WxH5PayFrom CJUnifyPayThirdPayProcess = null;
        public static final WxH5PayFrom CJWXPayH5Execute = null;
        public static final WxH5PayFrom JSBRequestWXH5Payment = null;
        private final String from;

        private static /* synthetic */ WxH5PayFrom[] $values() {
            return new WxH5PayFrom[]{CJPayWXPaymentService, CJWXPayH5Execute, CJUnifyPayThirdPayProcess, CJPayConfirmFragment, JSBRequestWXH5Payment};
        }

        static {
            CJPayWXPaymentService = new WxH5PayFrom("CJPayWXPaymentService", 0, "CJPayWXPaymentService");
            CJWXPayH5Execute = new WxH5PayFrom("CJWXPayH5Execute", 1, "CJWXPayH5Execute");
            CJUnifyPayThirdPayProcess = new WxH5PayFrom("CJUnifyPayThirdPayProcess", 2, "CJUnifyPayThirdPayProcess");
            CJPayConfirmFragment = new WxH5PayFrom("CJPayConfirmFragment", 3, "CJPayConfirmFragment");
            JSBRequestWXH5Payment = new WxH5PayFrom("JSBRequestWXH5Payment", 4, "JSBRequestWXH5Payment");
            $VALUES = $values();
        }

        public static WxH5PayFrom[] values() {
            return (WxH5PayFrom[]) $VALUES.clone();
        }

        public String getFrom() {
            return this.from;
        }

        public static WxH5PayFrom valueOf(String r100) {
            return (WxH5PayFrom) a.a(WxH5PayFrom.class, r100);
        }

        private WxH5PayFrom(String r100, int r101, String r102) {
            super(r100, r101);
            this.from = r102;
        }
    }

    View createLynxCard(Context r100, String r101, Map<String, ?> r102, ICJExternalLynxCardCallback r103, ICJExternalEventCenterCallback r104);

    ICJLynxComponent createLynxComponent(Context r100, String r101, Object r102, int r103, ICJExternalLynxCardCallback r104);

    ICJLynxComponent createLynxComponent(Context r100, String r101, Object r102, ICJExternalLynxCardCallback r103);

    ICJLynxComponent createLynxComponent(Context r100, String r101, Map<String, ?> r102, ICJExternalLynxCardCallback r103);

    WeakReference<Context> getTopH5Activity();

    Map<String, Class<? extends Object>> getXBridgeMethods();

    void handleCloseCallback(Context r100, JSONObject r101);

    void handleXBridgeMethod(Context r100, String r101, JSONObject r102, ICJPayXBridgeCallback r103);

    boolean isWhiteUrl(String r100);

    void openH5ForWXMiniApp(Activity r100, JSONObject r101, JSONObject r102);

    void openH5ForWXPay(Activity r100, JSONObject r101, JSONObject r102, WxH5PayFrom r103);

    void openH5ForWxIndependentSign(Activity r100, String r101, String r102, JSONObject r103);

    void openH5SetPassword(Activity r100, String r101, String r102, String r103, TTCJPayRealNamePasswordCallback r104, JSONObject r105);

    void registerXBridgeMethods();

    void releaseLynxCard(View r100);

    void rrpUpload();

    void startH5(H5ParamBuilder r100);

    void startH5ByScheme(H5SchemeParamBuilder r100);

    void startH5CashDesk(H5ParamBuilder r100);

    void startH5ModalView(H5ParamBuilder r100);
}
