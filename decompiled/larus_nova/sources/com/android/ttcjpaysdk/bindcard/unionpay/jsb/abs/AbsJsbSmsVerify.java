package com.android.ttcjpaysdk.bindcard.unionpay.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify$SmsVerifyInput;", "Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify$SmsVerifyOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "SmsVerifyInput", "SmsVerifyOutput", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbSmsVerify extends AbsJSBMethod<SmsVerifyInput, SmsVerifyOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tR\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify$SmsVerifyInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "card_info", "Lorg/json/JSONObject;", "merchant_id", "", "app_id", "is_skip_set_pwd", "", "(Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Z)V", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SmsVerifyInput implements IJSBParams {
        public String app_id;
        public JSONObject card_info;
        public boolean is_skip_set_pwd;
        public String merchant_id;

        public SmsVerifyInput() {
            this(null, null, null, false, 15, null);
        }

        public SmsVerifyInput(JSONObject r100, String r101, String r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "card_info");
            Intrinsics.checkNotNullParameter(r101, "merchant_id");
            Intrinsics.checkNotNullParameter(r102, "app_id");
            this.card_info = r100;
            this.merchant_id = r101;
            this.app_id = r102;
            this.is_skip_set_pwd = r103;
        }

        public /* synthetic */ SmsVerifyInput(JSONObject r100, String r101, String r102, boolean r103, int r104, DefaultConstructorMarker r105) {
            if ((r104 & 1) == 0) goto L6;
            r100 = new JSONObject();
        L6:
            if ((r104 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r104 & 4) == 0) goto L12;
            r102 = "";
        L12:
            if ((r104 & 8) == 0) goto L14;
            r103 = false;
        L14:
            this(r100, r101, r102, r103);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/unionpay/jsb/abs/AbsJsbSmsVerify$SmsVerifyOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "(ILjava/lang/String;)V", "bdpay-bindcard-unionpay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class SmsVerifyOutput extends JSBBaseOutput {
        public int code;
        public String msg;

        /* JADX WARN: Multi-variable type inference failed */
        public SmsVerifyOutput() {
            int r100 = 0;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        public SmsVerifyOutput(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            this.code = r100;
            this.msg = r101;
        }

        public /* synthetic */ SmsVerifyOutput(int r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = 0;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    public AbsJsbSmsVerify() {
        this.name = "ttcjpay.smsVerify";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
