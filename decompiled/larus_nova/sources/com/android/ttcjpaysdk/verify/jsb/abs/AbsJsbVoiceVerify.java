package com.android.ttcjpaysdk.verify.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbVoiceVerify;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbVoiceVerify$VoiceVerifyInput;", "Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbVoiceVerify$VoiceVerifyOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "VoiceVerifyInput", "VoiceVerifyOutput", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbVoiceVerify extends AbsJSBMethod<VoiceVerifyInput, VoiceVerifyOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eR\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbVoiceVerify$VoiceVerifyInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "merchantId", "", "appId", "verifyType", "memberBizOrderNo", "voiceText", "verifyGroupNum", "", "useDenoise", "", "extParams", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZLorg/json/JSONObject;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoiceVerifyInput implements IJSBParams {
        public String appId;
        public JSONObject extParams;
        public String memberBizOrderNo;
        public String merchantId;
        public boolean useDenoise;
        public int verifyGroupNum;
        public String verifyType;
        public String voiceText;

        public VoiceVerifyInput() {
            this(null, null, null, null, null, 0, false, null, 255, null);
        }

        public VoiceVerifyInput(String r100, String r101, String r102, String r103, String r104, int r105, boolean r106, JSONObject r107) {
            Intrinsics.checkNotNullParameter(r100, "merchantId");
            Intrinsics.checkNotNullParameter(r101, "appId");
            Intrinsics.checkNotNullParameter(r102, "verifyType");
            Intrinsics.checkNotNullParameter(r103, "memberBizOrderNo");
            Intrinsics.checkNotNullParameter(r104, "voiceText");
            Intrinsics.checkNotNullParameter(r107, "extParams");
            this.merchantId = r100;
            this.appId = r101;
            this.verifyType = r102;
            this.memberBizOrderNo = r103;
            this.voiceText = r104;
            this.verifyGroupNum = r105;
            this.useDenoise = r106;
            this.extParams = r107;
        }

        public /* synthetic */ VoiceVerifyInput(String r100, String r110, String r111, String r112, String r113, int r114, boolean r115, JSONObject r116, int r117, DefaultConstructorMarker r118) {
            String r101 = "";
            if ((r117 & 1) == 0) goto L5;
            String r102 = "";
        L7:
            if ((r117 & 2) == 0) goto L9;
            String r103 = "";
        L11:
            if ((r117 & 4) == 0) goto L13;
            String r104 = "";
        L15:
            if ((r117 & 8) == 0) goto L17;
            String r105 = "";
        L19:
            if ((r117 & 16) != 0) goto L23;
            r101 = r113;
        L23:
            if ((r117 & 32) == 0) goto L25;
            int r106 = 0;
        L27:
            if ((r117 & 64) == 0) goto L29;
            boolean r107 = true;
        L31:
            if ((r117 & 128) == 0) goto L33;
            JSONObject r108 = new JSONObject();
        L34:
            this(r102, r103, r104, r105, r101, r106, r107, r108);
            return;
        L33:
            r108 = r116;
            goto L34
        L29:
            r107 = r115;
            goto L31
        L25:
            r106 = r114;
            goto L27
        L17:
            r105 = r112;
            goto L19
        L13:
            r104 = r111;
            goto L15
        L9:
            r103 = r110;
            goto L11
        L5:
            r102 = r100;
            goto L7
        }
    }

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbVoiceVerify$VoiceVerifyOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "bizCode", "", "bizMsg", "", "(ILjava/lang/String;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class VoiceVerifyOutput extends JSBBaseOutput {
        public int bizCode;
        public String bizMsg;

        /* JADX WARN: Multi-variable type inference failed */
        public VoiceVerifyOutput() {
            int r100 = 0;
            this(r100, null, 3, 0 == true ? 1 : 0);
        }

        public VoiceVerifyOutput(int r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "bizMsg");
            this.bizCode = r100;
            this.bizMsg = r101;
        }

        public /* synthetic */ VoiceVerifyOutput(int r100, String r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = -1;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = "";
        L8:
            this(r100, r101);
        }
    }

    public AbsJsbVoiceVerify() {
        this.name = "ttcjpay.voiceVerify";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
