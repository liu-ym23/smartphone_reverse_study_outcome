package com.android.ttcjpaysdk.facelive.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerification;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerification$FaceVerificationInput;", "Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerification$FaceVerificationOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "FaceVerificationInput", "FaceVerificationOutput", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbFaceVerification extends AbsJSBMethod<FaceVerificationInput, FaceVerificationOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001Bi\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rR\u0012\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerification$FaceVerificationInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "scene", "", "ticket", "mode", "cert_app_id", "use_new_api", "eventParams", "retain_text", "compare_in_cert", "no_login_ticket", "aid", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceVerificationInput implements IJSBParams {
        public String aid;
        public String cert_app_id;
        public String compare_in_cert;
        public String eventParams;
        public String mode;
        public String no_login_ticket;
        public String retain_text;
        public String scene;
        public String ticket;
        public String use_new_api;

        public FaceVerificationInput() {
            this(null, null, null, null, null, null, null, null, null, null, 1023, null);
        }

        public FaceVerificationInput(String r100, String r101, String r102, String r103, String r104, String r105, String r106, String r107, String r110, String r111) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r101, "ticket");
            Intrinsics.checkNotNullParameter(r102, "mode");
            Intrinsics.checkNotNullParameter(r103, "cert_app_id");
            Intrinsics.checkNotNullParameter(r104, "use_new_api");
            Intrinsics.checkNotNullParameter(r105, "eventParams");
            Intrinsics.checkNotNullParameter(r106, "retain_text");
            Intrinsics.checkNotNullParameter(r107, "compare_in_cert");
            Intrinsics.checkNotNullParameter(r110, "no_login_ticket");
            Intrinsics.checkNotNullParameter(r111, "aid");
            this.scene = r100;
            this.ticket = r101;
            this.mode = r102;
            this.cert_app_id = r103;
            this.use_new_api = r104;
            this.eventParams = r105;
            this.retain_text = r106;
            this.compare_in_cert = r107;
            this.no_login_ticket = r110;
            this.aid = r111;
        }

        public /* synthetic */ FaceVerificationInput(String r110, String r111, String r112, String r113, String r114, String r115, String r116, String r117, String r210, String r211, int r212, DefaultConstructorMarker r213) {
            String r100 = "";
            if ((r212 & 1) == 0) goto L5;
            String r101 = "";
        L7:
            if ((r212 & 2) == 0) goto L9;
            String r102 = "";
        L11:
            if ((r212 & 4) == 0) goto L13;
            String r103 = "";
        L15:
            if ((r212 & 8) == 0) goto L17;
            String r104 = "";
        L19:
            if ((r212 & 16) == 0) goto L21;
            String r105 = "true";
        L23:
            if ((r212 & 32) == 0) goto L25;
            String r106 = "";
        L27:
            if ((r212 & 64) == 0) goto L29;
            String r107 = "";
        L31:
            if ((r212 & 128) == 0) goto L33;
            String r108 = "0";
        L35:
            if ((r212 & 256) == 0) goto L37;
            String r118 = "";
        L39:
            if ((r212 & 512) != 0) goto L42;
            r100 = r211;
        L42:
            this(r101, r102, r103, r104, r105, r106, r107, r108, r118, r100);
            return;
        L37:
            r118 = r210;
            goto L39
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

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/facelive/jsb/abs/AbsJsbFaceVerification$FaceVerificationOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "errMsg", "", "ticket", "faceData", "compare_in_cert", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "buildLogData", "Lorg/json/JSONObject;", "bdpay-facecheck_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class FaceVerificationOutput extends JSBBaseOutput {
        public int code;
        public String compare_in_cert;
        public String errMsg;
        public String faceData;
        public String ticket;

        public FaceVerificationOutput() {
            this(0, null, null, null, null, 31, null);
        }

        public final JSONObject buildLogData() {
            JSONObject r100 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r100, "code", Integer.valueOf(this.code));
            KtSafeMethodExtensionKt.safePut(r100, "msg", this.errMsg);
            KtSafeMethodExtensionKt.safePut(r100, "ticket", this.ticket);
            KtSafeMethodExtensionKt.safePut(r100, "compare_in_cert", this.compare_in_cert);
            return r100;
        }

        public FaceVerificationOutput(int r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "errMsg");
            Intrinsics.checkNotNullParameter(r102, "ticket");
            Intrinsics.checkNotNullParameter(r103, "faceData");
            Intrinsics.checkNotNullParameter(r104, "compare_in_cert");
            this.code = r100;
            this.errMsg = r101;
            this.ticket = r102;
            this.faceData = r103;
            this.compare_in_cert = r104;
        }

        public /* synthetic */ FaceVerificationOutput(int r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
            if ((r105 & 1) == 0) goto L5;
            r100 = 0;
        L5:
            String r106 = "";
            if ((r105 & 2) == 0) goto L8;
            String r111 = "";
        L10:
            if ((r105 & 4) == 0) goto L12;
            String r107 = "";
        L14:
            if ((r105 & 8) != 0) goto L18;
            r106 = r103;
        L18:
            if ((r105 & 16) == 0) goto L20;
            r104 = "0";
        L20:
            String r108 = r104;
            this(r100, r111, r107, r106, r108);
            return;
        L12:
            r107 = r102;
            goto L14
        L8:
            r111 = r101;
            goto L10
        }
    }

    public AbsJsbFaceVerification() {
        this.name = "ttcjpay.faceVerification";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
