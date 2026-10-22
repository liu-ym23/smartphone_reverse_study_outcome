package com.android.ttcjpaysdk.bindcard.base.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard$BindCardInput;", "Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard$BindCardOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "BindCardInput", "BindCardOutput", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbBindCard extends AbsJSBMethod<BindCardInput, BindCardOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rR\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard$BindCardInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "bind_type", "", "riskInfoParams", "Lorg/json/JSONObject;", "app_id", "merchant_id", "card_info", "create_order_data", "need_loading", "delay_on_success", "", "(Ljava/lang/String;Lorg/json/JSONObject;Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;Lorg/json/JSONObject;Ljava/lang/String;I)V", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BindCardInput implements IJSBParams {
        public String app_id;
        public String bind_type;
        public JSONObject card_info;
        public JSONObject create_order_data;
        public int delay_on_success;
        public String merchant_id;
        public String need_loading;
        public JSONObject riskInfoParams;

        public BindCardInput() {
            this(null, null, null, null, null, null, null, 0, 255, null);
        }

        public BindCardInput(String r100, JSONObject r101, String r102, String r103, JSONObject r104, JSONObject r105, String r106, int r107) {
            Intrinsics.checkNotNullParameter(r100, "bind_type");
            Intrinsics.checkNotNullParameter(r101, "riskInfoParams");
            Intrinsics.checkNotNullParameter(r102, "app_id");
            Intrinsics.checkNotNullParameter(r103, "merchant_id");
            Intrinsics.checkNotNullParameter(r104, "card_info");
            Intrinsics.checkNotNullParameter(r105, "create_order_data");
            Intrinsics.checkNotNullParameter(r106, "need_loading");
            this.bind_type = r100;
            this.riskInfoParams = r101;
            this.app_id = r102;
            this.merchant_id = r103;
            this.card_info = r104;
            this.create_order_data = r105;
            this.need_loading = r106;
            this.delay_on_success = r107;
        }

        public /* synthetic */ BindCardInput(String r110, JSONObject r111, String r112, String r113, JSONObject r114, JSONObject r115, String r116, int r117, int r118, DefaultConstructorMarker r119) {
            String r100 = "";
            if ((r118 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r118 & 2) == 0) goto L9;
            JSONObject r102 = new JSONObject();
        L11:
            if ((r118 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r118 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r118 & 16) == 0) goto L21;
            JSONObject r105 = new JSONObject();
        L23:
            if ((r118 & 32) == 0) goto L25;
            JSONObject r106 = new JSONObject();
        L27:
            if ((r118 & 64) != 0) goto L31;
            r100 = r116;
        L31:
            if ((r118 & 128) == 0) goto L33;
            int r107 = 0;
        L34:
            this(r101, r102, r103, r104, r105, r106, r100, r107);
            return;
        L33:
            r107 = r117;
            goto L34
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

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/bindcard/base/jsb/abs/AbsJsbBindCard$BindCardOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "result", "", "(Ljava/lang/String;)V", "bdpay-bindcard-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class BindCardOutput extends JSBBaseOutput {
        public String result;

        /* JADX WARN: Multi-variable type inference failed */
        public BindCardOutput() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public BindCardOutput(String r100) {
            Intrinsics.checkNotNullParameter(r100, "result");
            this.result = r100;
        }

        public /* synthetic */ BindCardOutput(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    public AbsJsbBindCard() {
        this.name = "ttcjpay.bindCard";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
