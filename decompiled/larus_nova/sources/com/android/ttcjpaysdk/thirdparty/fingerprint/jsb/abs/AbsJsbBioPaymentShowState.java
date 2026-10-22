package com.android.ttcjpaysdk.thirdparty.fingerprint.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState$BioPaymentShowStateInput;", "Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState$BioPaymentShowStateOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "BioPaymentShowStateInput", "BioPaymentShowStateOutput", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbBioPaymentShowState extends AbsJSBMethod<BioPaymentShowStateInput, BioPaymentShowStateOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003¢\u0006\u0002\u0010\u0010R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState$BioPaymentShowStateInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "appId", "", "merchantId", a.KEY_DID, "uid", "aid", "timestamp", "signType", "sign", "onlyReturnDeviceType", "", "riskInfoParams", "Lorg/json/JSONObject;", "is_caijing_saas", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLorg/json/JSONObject;Ljava/lang/String;)V", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BioPaymentShowStateInput implements IJSBParams {
        public String aid;
        public String appId;
        public String did;
        public String is_caijing_saas;
        public String merchantId;
        public boolean onlyReturnDeviceType;
        public JSONObject riskInfoParams;
        public String sign;
        public String signType;
        public String timestamp;
        public String uid;

        public BioPaymentShowStateInput() {
            this(null, null, null, null, null, null, null, null, false, null, null, 2047, null);
        }

        public BioPaymentShowStateInput(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, boolean r110, JSONObject r111, String r112) {
            Intrinsics.checkNotNullParameter(r100, "appId");
            Intrinsics.checkNotNullParameter(r101, "merchantId");
            Intrinsics.checkNotNullParameter(r102, a.KEY_DID);
            Intrinsics.checkNotNullParameter(r103, "uid");
            Intrinsics.checkNotNullParameter(r104, "aid");
            Intrinsics.checkNotNullParameter(r105, "timestamp");
            Intrinsics.checkNotNullParameter(r106, "signType");
            Intrinsics.checkNotNullParameter(r107, "sign");
            Intrinsics.checkNotNullParameter(r111, "riskInfoParams");
            Intrinsics.checkNotNullParameter(r112, "is_caijing_saas");
            this.appId = r100;
            this.merchantId = r101;
            this.did = r102;
            this.uid = r103;
            this.aid = r104;
            this.timestamp = r105;
            this.signType = r106;
            this.sign = r107;
            this.onlyReturnDeviceType = r110;
            this.riskInfoParams = r111;
            this.is_caijing_saas = r112;
        }

        public /* synthetic */ BioPaymentShowStateInput(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r210, boolean r211, JSONObject r212, String r213, int r214, DefaultConstructorMarker r215) {
            String r100 = "";
            if ((r214 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r214 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r214 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r214 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r214 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r214 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r214 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r214 & 128) == 0) goto L33;
            String r108 = "";
        L35:
            if ((r214 & 256) == 0) goto L37;
            boolean r117 = false;
        L39:
            if ((r214 & 512) == 0) goto L41;
            JSONObject r118 = new JSONObject();
        L43:
            if ((r214 & 1024) != 0) goto L46;
            r100 = r213;
        L46:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r117, r118, r100);
            return;
        L41:
            r118 = r212;
            goto L43
        L37:
            r117 = r211;
            goto L39
        L33:
            r108 = r210;
            goto L35
        L29:
            r107 = r116;
            goto L31
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/thirdparty/fingerprint/jsb/abs/AbsJsbBioPaymentShowState$BioPaymentShowStateOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "show", "", "bioType", "msg", "style", "open", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-fingerprint_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BioPaymentShowStateOutput extends JSBBaseOutput {
        public String bioType;
        public String msg;
        public String open;
        public String show;
        public String style;

        public BioPaymentShowStateOutput() {
            this(null, null, null, null, null, 31, null);
        }

        public BioPaymentShowStateOutput(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "show");
            Intrinsics.checkNotNullParameter(r101, "bioType");
            Intrinsics.checkNotNullParameter(r102, "msg");
            Intrinsics.checkNotNullParameter(r103, "style");
            Intrinsics.checkNotNullParameter(r104, "open");
            this.show = r100;
            this.bioType = r101;
            this.msg = r102;
            this.style = r103;
            this.open = r104;
        }

        public /* synthetic */ BioPaymentShowStateOutput(String r100, String r101, String r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            String r112 = "";
        L7:
            if ((r110 & 2) == 0) goto L9;
            String r105 = "";
        L11:
            if ((r110 & 4) == 0) goto L13;
            String r106 = "";
        L15:
            if ((r110 & 8) == 0) goto L17;
            String r107 = "";
        L19:
            if ((r110 & 16) == 0) goto L21;
            String r113 = "";
        L22:
            this(r112, r105, r106, r107, r113);
            return;
        L21:
            r113 = r104;
            goto L22
        L17:
            r107 = r103;
            goto L19
        L13:
            r106 = r102;
            goto L15
        L9:
            r105 = r101;
            goto L11
        L5:
            r112 = r100;
            goto L7
        }
    }

    public AbsJsbBioPaymentShowState() {
        this.name = "ttcjpay.bioPaymentShowState";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
