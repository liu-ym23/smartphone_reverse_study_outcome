package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.bytedance.android.ec.core.event.a;
import com.bytedance.android.livesdkapi.app.AppConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbTtpay;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbTtpay$TtpayInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbTtpay$TtpayOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "TtpayInput", "TtpayOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbTtpay extends AbsJSBMethod<TtpayInput, TtpayOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0012\u0010\n\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbTtpay$TtpayInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "sdk_info", "", "service", "", "sub_way", "ext", AppConstants.BUNDLE_REFERER, a.KEY_DID, "aid", "riskInfoParams", "Lorg/json/JSONObject;", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILorg/json/JSONObject;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TtpayInput implements IJSBParams {
        public int aid;
        public String did;
        public String ext;
        public String referer;
        public JSONObject riskInfoParams;
        public String sdk_info;
        public int service;
        public String sub_way;

        public TtpayInput() {
            this(null, 0, null, null, null, null, 0, null, 255, null);
        }

        public TtpayInput(String r100, int r101, String r102, String r103, String r104, String r105, int r106, JSONObject r107) {
            Intrinsics.checkNotNullParameter(r100, "sdk_info");
            Intrinsics.checkNotNullParameter(r102, "sub_way");
            Intrinsics.checkNotNullParameter(r103, "ext");
            Intrinsics.checkNotNullParameter(r104, AppConstants.BUNDLE_REFERER);
            Intrinsics.checkNotNullParameter(r105, a.KEY_DID);
            Intrinsics.checkNotNullParameter(r107, "riskInfoParams");
            this.sdk_info = r100;
            this.service = r101;
            this.sub_way = r102;
            this.ext = r103;
            this.referer = r104;
            this.did = r105;
            this.aid = r106;
            this.riskInfoParams = r107;
        }

        public /* synthetic */ TtpayInput(String r110, int r111, String r112, String r113, String r114, String r115, int r116, JSONObject r117, int r118, DefaultConstructorMarker r119) {
            String r100 = "";
            if ((r118 & 1) == 0) goto L5;
            String r101 = "";
        L6:
            int r102 = -1;
            if ((r118 & 2) == 0) goto L9;
            int r103 = -1;
        L11:
            if ((r118 & 4) == 0) goto L13;
            String r104 = "";
        L15:
            if ((r118 & 8) == 0) goto L17;
            String r105 = "";
        L19:
            if ((r118 & 16) == 0) goto L21;
            String r106 = "";
        L23:
            if ((r118 & 32) != 0) goto L27;
            r100 = r115;
        L27:
            if ((r118 & 64) != 0) goto L31;
            r102 = r116;
        L31:
            if ((r118 & 128) == 0) goto L33;
            JSONObject r107 = new JSONObject();
        L34:
            this(r101, r103, r104, r105, r106, r100, r102, r107);
            return;
        L33:
            r107 = r117;
            goto L34
        L21:
            r106 = r114;
            goto L23
        L17:
            r105 = r113;
            goto L19
        L13:
            r104 = r112;
            goto L15
        L9:
            r103 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L6
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbTtpay$TtpayOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "data", "(ILjava/lang/String;Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class TtpayOutput extends JSBBaseOutput {
        public int code;
        public String data;
        public String msg;

        public TtpayOutput() {
            this(0, null, null, 7, null);
        }

        public TtpayOutput(int r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.msg = r101;
            this.data = r102;
        }

        public /* synthetic */ TtpayOutput(int r100, String r101, String r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = "";
        L11:
            this(r100, r101, r102);
        }
    }

    public AbsJsbTtpay() {
        this.name = "ttcjpay.ttpay";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
