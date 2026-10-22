package com.android.ttcjpaysdk.thirdparty.fingerprint.jsb.abs;

import com.alipay.sdk.m.k.b;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState$SwitchBioPaymentStateInput;", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState$SwitchBioPaymentStateOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "SwitchBioPaymentStateInput", "SwitchBioPaymentStateOutput", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbSwitchBioPaymentState extends AbsJSBMethod<SwitchBioPaymentStateInput, SwitchBioPaymentStateOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0003¢\u0006\u0002\u0010\u0016R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState$SwitchBioPaymentStateInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "appId", "", "merchantId", a.KEY_DID, "uid", "open", "signType", "sign", "timestamp", "member_biz_order_no", "verify_type", "verify_info", "Lorg/json/JSONObject;", "riskInfoParams", "source", b.B0, "process_info", "is_from_guide", "", "is_caijing_saas", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;ZLjava/lang/String;)V", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwitchBioPaymentStateInput implements IJSBParams {
        public String appId;
        public String did;
        public String is_caijing_saas;
        public boolean is_from_guide;
        public String member_biz_order_no;
        public String merchantId;
        public String open;
        public JSONObject process_info;
        public JSONObject riskInfoParams;
        public String sign;
        public String signType;
        public String source;
        public String timestamp;
        public String trade_no;
        public String uid;
        public JSONObject verify_info;
        public String verify_type;

        public SwitchBioPaymentStateInput() {
            this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, null, 131071, null);
        }

        public SwitchBioPaymentStateInput(String r110, String r111, String r112, String r210, String r211, String r212, String r213, String r214, String r215, String r216, JSONObject r217, JSONObject r218, String r219, String r310, JSONObject r311, boolean r312, String r313) {
            Intrinsics.checkNotNullParameter(r110, "appId");
            Intrinsics.checkNotNullParameter(r111, "merchantId");
            Intrinsics.checkNotNullParameter(r112, a.KEY_DID);
            Intrinsics.checkNotNullParameter(r210, "uid");
            Intrinsics.checkNotNullParameter(r211, "open");
            Intrinsics.checkNotNullParameter(r212, "signType");
            Intrinsics.checkNotNullParameter(r213, "sign");
            Intrinsics.checkNotNullParameter(r214, "timestamp");
            Intrinsics.checkNotNullParameter(r215, "member_biz_order_no");
            Intrinsics.checkNotNullParameter(r216, "verify_type");
            Intrinsics.checkNotNullParameter(r217, "verify_info");
            Intrinsics.checkNotNullParameter(r218, "riskInfoParams");
            Intrinsics.checkNotNullParameter(r219, "source");
            Intrinsics.checkNotNullParameter(r310, b.B0);
            Intrinsics.checkNotNullParameter(r311, "process_info");
            Intrinsics.checkNotNullParameter(r313, "is_caijing_saas");
            this.appId = r110;
            this.merchantId = r111;
            this.did = r112;
            this.uid = r210;
            this.open = r211;
            this.signType = r212;
            this.sign = r213;
            this.timestamp = r214;
            this.member_biz_order_no = r215;
            this.verify_type = r216;
            this.verify_info = r217;
            this.riskInfoParams = r218;
            this.source = r219;
            this.trade_no = r310;
            this.process_info = r311;
            this.is_from_guide = r312;
            this.is_caijing_saas = r313;
        }

        public /* synthetic */ SwitchBioPaymentStateInput(String r110, String r210, String r211, String r212, String r213, String r214, String r215, String r216, String r217, String r218, JSONObject r219, JSONObject r310, String r311, String r312, JSONObject r313, boolean r314, String r315, int r316, DefaultConstructorMarker r317) {
            if ((r316 & 1) == 0) goto L5;
            String r100 = "";
        L7:
            if ((r316 & 2) == 0) goto L9;
            String r101 = "";
        L11:
            if ((r316 & 4) == 0) goto L13;
            String r102 = "";
        L15:
            if ((r316 & 8) == 0) goto L17;
            String r103 = "";
        L19:
            if ((r316 & 16) == 0) goto L21;
            String r104 = "";
        L23:
            if ((r316 & 32) == 0) goto L25;
            String r105 = "";
        L27:
            if ((r316 & 64) == 0) goto L29;
            String r106 = "";
        L31:
            if ((r316 & 128) == 0) goto L33;
            String r107 = "";
        L35:
            if ((r316 & 256) == 0) goto L37;
            String r111 = "";
        L39:
            if ((r316 & 512) == 0) goto L41;
            String r112 = "";
        L43:
            if ((r316 & 1024) == 0) goto L45;
            JSONObject r113 = new JSONObject();
        L47:
            if ((r316 & 2048) == 0) goto L49;
            JSONObject r114 = new JSONObject();
        L51:
            if ((r316 & 4096) == 0) goto L53;
            String r115 = "";
        L55:
            if ((r316 & 8192) == 0) goto L57;
            String r116 = "";
        L59:
            if ((r316 & 16384) == 0) goto L61;
            JSONObject r108 = new JSONObject();
        L63:
            if ((r316 & 32768) == 0) goto L65;
            boolean r117 = false;
        L67:
            if ((r316 & 65536) == 0) goto L69;
            String r109 = "";
        L70:
            this(r100, r101, r102, r103, r104, r105, r106, r107, r111, r112, r113, r114, r115, r116, r108, r117, r109);
            return;
        L69:
            r109 = r315;
            goto L70
        L65:
            r117 = r314;
            goto L67
        L61:
            r108 = r313;
            goto L63
        L57:
            r116 = r312;
            goto L59
        L53:
            r115 = r311;
            goto L55
        L49:
            r114 = r310;
            goto L51
        L45:
            r113 = r219;
            goto L47
        L41:
            r112 = r218;
            goto L43
        L37:
            r111 = r217;
            goto L39
        L33:
            r107 = r216;
            goto L35
        L29:
            r106 = r215;
            goto L31
        L25:
            r105 = r214;
            goto L27
        L21:
            r104 = r213;
            goto L23
        L17:
            r103 = r212;
            goto L19
        L13:
            r102 = r211;
            goto L15
        L9:
            r101 = r210;
            goto L11
        L5:
            r100 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbSwitchBioPaymentState$SwitchBioPaymentStateOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "bioPaymentState", "style", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SwitchBioPaymentStateOutput extends JSBBaseOutput {
        public String bioPaymentState;
        public String code;
        public String msg;
        public int style;

        public SwitchBioPaymentStateOutput() {
            this(null, null, null, 0, 15, null);
        }

        public SwitchBioPaymentStateOutput(String r100, String r101, String r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "bioPaymentState");
            this.code = r100;
            this.msg = r101;
            this.bioPaymentState = r102;
            this.style = r103;
        }

        public /* synthetic */ SwitchBioPaymentStateOutput(String r100, String r101, String r102, int r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = 0;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    public AbsJsbSwitchBioPaymentState() {
        this.name = "ttcjpay.switchBioPaymentState";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
