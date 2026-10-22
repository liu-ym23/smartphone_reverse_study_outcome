package com.android.ttcjpaysdk.facelive.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.NothingOutput;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerifyFullPage;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerifyFullPage$FaceVerifyFullPageInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/NothingOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "buildLogData", "Lorg/json/JSONObject;", "code", "", "msg", "ticket", "FaceVerifyFullPageInput", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbFaceVerifyFullPage extends AbsJSBMethod<FaceVerifyFullPageInput, NothingOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerifyFullPage$FaceVerifyFullPageInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "app_id", "", "merchant_id", "order_id", "server_source", "risk_source", "live_route", "is_signed", "configuration_params", "ext_params", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceVerifyFullPageInput implements IJSBParams {
        public String app_id;
        public String configuration_params;
        public String ext_params;
        public String is_signed;
        public String live_route;
        public String merchant_id;
        public String order_id;
        public String risk_source;
        public String server_source;

        public FaceVerifyFullPageInput() {
            this(null, null, null, null, null, null, null, null, null, 511, null);
        }

        public FaceVerifyFullPageInput(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110) {
            Intrinsics.checkNotNullParameter(r100, "app_id");
            Intrinsics.checkNotNullParameter(r101, "merchant_id");
            Intrinsics.checkNotNullParameter(r102, "order_id");
            Intrinsics.checkNotNullParameter(r103, "server_source");
            Intrinsics.checkNotNullParameter(r104, "risk_source");
            Intrinsics.checkNotNullParameter(r105, "live_route");
            Intrinsics.checkNotNullParameter(r106, "is_signed");
            Intrinsics.checkNotNullParameter(r107, "configuration_params");
            Intrinsics.checkNotNullParameter(r110, "ext_params");
            this.app_id = r100;
            this.merchant_id = r101;
            this.order_id = r102;
            this.server_source = r103;
            this.risk_source = r104;
            this.live_route = r105;
            this.is_signed = r106;
            this.configuration_params = r107;
            this.ext_params = r110;
        }

        public /* synthetic */ FaceVerifyFullPageInput(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r118, int r210, DefaultConstructorMarker r211) {
            String r100 = "";
            if ((r210 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r210 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r210 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r210 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r210 & 16) == 0) goto L21;
            String r105 = "";
        L23:
            if ((r210 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r210 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r210 & 128) == 0) goto L33;
            String r108 = "";
        L35:
            if ((r210 & 256) != 0) goto L38;
            r100 = r118;
        L38:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r100);
            return;
        L33:
            r108 = r117;
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

    public AbsJsbFaceVerifyFullPage() {
        this.name = "ttcjpay.faceVerifyFullPage";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }

    public final JSONObject buildLogData(int r100, String r101, String r102) {
        JSONObject r103 = new JSONObject();
        KtSafeMethodExtensionKt.safePut(r103, "code", Integer.valueOf(r100));
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        KtSafeMethodExtensionKt.safePut(r103, "msg", r101);
        if (r102 != null) goto L8;
        r102 = "";
    L8:
        KtSafeMethodExtensionKt.safePut(r103, "ticket", r102);
        return r103;
    }
}
