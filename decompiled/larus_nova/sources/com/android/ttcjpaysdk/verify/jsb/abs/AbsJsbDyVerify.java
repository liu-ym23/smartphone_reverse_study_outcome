package com.android.ttcjpaysdk.verify.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbDyVerify;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbDyVerify$DyVerifyInput;", "Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbDyVerify$DyVerifyOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "DyVerifyInput", "DyVerifyOutput", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbDyVerify extends AbsJSBMethod<DyVerifyInput, DyVerifyOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0012\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbDyVerify$DyVerifyInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "verify_id", "", "verify_token", ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS, "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DyVerifyInput implements IJSBParams {
        public JSONObject log_params;
        public String verify_id;
        public String verify_token;

        public DyVerifyInput() {
            this(null, null, null, 7, null);
        }

        public DyVerifyInput(String r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r100, "verify_id");
            Intrinsics.checkNotNullParameter(r101, "verify_token");
            Intrinsics.checkNotNullParameter(r102, ILiveRoomPlayFragmentConstant.EXTRA_REPLAY_LOG_PARAMS);
            this.verify_id = r100;
            this.verify_token = r101;
            this.log_params = r102;
        }

        public /* synthetic */ DyVerifyInput(String r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r103 & 2) == 0) goto L9;
            r101 = "";
        L9:
            if ((r103 & 4) == 0) goto L11;
            r102 = new JSONObject();
        L11:
            this(r100, r101, r102);
        }
    }

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u000bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbDyVerify$DyVerifyOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "verify_id", "cur_verify_product", "ext", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "buildLogData", "Lorg/json/JSONObject;", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DyVerifyOutput extends JSBBaseOutput {
        public int code;
        public String cur_verify_product;
        public String ext;
        public String msg;
        public String verify_id;

        public DyVerifyOutput() {
            this(0, null, null, null, null, 31, null);
        }

        public final JSONObject buildLogData() {
            JSONObject r100 = new JSONObject();
            KtSafeMethodExtensionKt.safePut(r100, "code", Integer.valueOf(this.code));
            KtSafeMethodExtensionKt.safePut(r100, "msg", this.msg);
            KtSafeMethodExtensionKt.safePut(r100, "verify_id", this.verify_id);
            KtSafeMethodExtensionKt.safePut(r100, "cur_verify_product", this.cur_verify_product);
            KtSafeMethodExtensionKt.safePut(r100, "ext", this.ext);
            return r100;
        }

        public DyVerifyOutput(int r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "verify_id");
            Intrinsics.checkNotNullParameter(r103, "cur_verify_product");
            Intrinsics.checkNotNullParameter(r104, "ext");
            this.code = r100;
            this.msg = r101;
            this.verify_id = r102;
            this.cur_verify_product = r103;
            this.ext = r104;
        }

        public /* synthetic */ DyVerifyOutput(int r100, String r101, String r102, String r103, String r104, int r105, DefaultConstructorMarker r110) {
            if ((r105 & 1) == 0) goto L5;
            r100 = -1;
        L5:
            String r106 = "";
            if ((r105 & 2) == 0) goto L8;
            String r111 = "";
        L10:
            if ((r105 & 4) == 0) goto L12;
            String r107 = "";
        L14:
            if ((r105 & 8) == 0) goto L16;
            String r108 = "";
        L18:
            if ((r105 & 16) != 0) goto L21;
            r106 = r104;
        L21:
            this(r100, r111, r107, r108, r106);
            return;
        L16:
            r108 = r103;
            goto L18
        L12:
            r107 = r102;
            goto L14
        L8:
            r111 = r101;
            goto L10
        }
    }

    public AbsJsbDyVerify() {
        this.name = "ttcjpay.dyVerify";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
