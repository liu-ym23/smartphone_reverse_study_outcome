package com.android.ttcjpaysdk.outer.pay.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.bytedance.android.ec.core.event.a;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/jsb/abs/AbsJsbDypay;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/outer/pay/jsb/abs/AbsJsbDypay$DypayInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "DypayInput", "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbDypay extends AbsJSBMethod<DypayInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tR\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/android/ttcjpaysdk/outer/pay/jsb/abs/AbsJsbDypay$DypayInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "sdk_info", "", "cur_page_url", "riskInfoParams", "Lorg/json/JSONObject;", a.KEY_DID, "aid", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;)V", "outer-pay_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DypayInput implements IJSBParams {
        public String aid;
        public String cur_page_url;
        public String did;
        public JSONObject riskInfoParams;
        public String sdk_info;

        public DypayInput() {
            this(null, null, null, null, null, 31, null);
        }

        public DypayInput(String r100, String r101, JSONObject r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "sdk_info");
            Intrinsics.checkNotNullParameter(r101, "cur_page_url");
            Intrinsics.checkNotNullParameter(r102, "riskInfoParams");
            Intrinsics.checkNotNullParameter(r103, a.KEY_DID);
            Intrinsics.checkNotNullParameter(r104, "aid");
            this.sdk_info = r100;
            this.cur_page_url = r101;
            this.riskInfoParams = r102;
            this.did = r103;
            this.aid = r104;
        }

        public /* synthetic */ DypayInput(String r100, String r101, JSONObject r102, String r103, String r104, int r110, DefaultConstructorMarker r111) {
            if ((r110 & 1) == 0) goto L5;
            String r112 = "";
        L7:
            if ((r110 & 2) == 0) goto L9;
            String r105 = "";
        L11:
            if ((r110 & 4) == 0) goto L13;
            r102 = new JSONObject();
        L13:
            JSONObject r106 = r102;
            if ((r110 & 8) == 0) goto L16;
            String r107 = "";
        L18:
            if ((r110 & 16) == 0) goto L20;
            String r113 = "";
        L21:
            this(r112, r105, r106, r107, r113);
            return;
        L20:
            r113 = r104;
            goto L21
        L16:
            r107 = r103;
            goto L18
        L9:
            r105 = r101;
            goto L11
        L5:
            r112 = r100;
            goto L7
        }
    }

    public AbsJsbDypay() {
        this.name = "ttcjpay.dypay";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
