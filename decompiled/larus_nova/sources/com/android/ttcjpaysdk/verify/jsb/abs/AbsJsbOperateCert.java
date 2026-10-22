package com.android.ttcjpaysdk.verify.jsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbOperateCert;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbOperateCert$OperateCertInput;", "Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbOperateCert$OperateCertOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "OperateCertInput", "OperateCertOutput", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbOperateCert extends AbsJSBMethod<OperateCertInput, OperateCertOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbOperateCert$OperateCertInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", "action_type", "", "action_params", "Lorg/json/JSONObject;", "(Ljava/lang/String;Lorg/json/JSONObject;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OperateCertInput implements IJSBParams {
        public JSONObject action_params;
        public String action_type;

        /* JADX WARN: Multi-variable type inference failed */
        public OperateCertInput() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3, 0 == true ? 1 : 0);
        }

        public OperateCertInput(String r100, JSONObject r101) {
            Intrinsics.checkNotNullParameter(r100, "action_type");
            Intrinsics.checkNotNullParameter(r101, "action_params");
            this.action_type = r100;
            this.action_params = r101;
        }

        public /* synthetic */ OperateCertInput(String r100, JSONObject r101, int r102, DefaultConstructorMarker r103) {
            if ((r102 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = new JSONObject();
        L8:
            this(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes39.dex */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/android/ttcjpaysdk/verify/jsb/abs/AbsJsbOperateCert$OperateCertOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "code", "", "msg", "", "data", "Lorg/json/JSONObject;", "(ILjava/lang/String;Lorg/json/JSONObject;)V", "dy-verify-sdk_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class OperateCertOutput extends JSBBaseOutput {
        public int code;
        public JSONObject data;
        public String msg;

        public OperateCertOutput() {
            this(0, null, null, 7, null);
        }

        public OperateCertOutput(int r100, String r101, JSONObject r102) {
            Intrinsics.checkNotNullParameter(r101, "msg");
            Intrinsics.checkNotNullParameter(r102, "data");
            this.code = r100;
            this.msg = r101;
            this.data = r102;
        }

        public /* synthetic */ OperateCertOutput(int r100, String r101, JSONObject r102, int r103, DefaultConstructorMarker r104) {
            if ((r103 & 1) == 0) goto L6;
            r100 = 0;
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

    public AbsJsbOperateCert() {
        this.name = "ttcjpay.operateCert";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
