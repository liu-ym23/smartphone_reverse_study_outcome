package com.android.ttcjpaysdk.base.h5.cjjsb.abs;

import com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.IJSBParams;
import com.android.ttcjpaysdk.base.h5.cjjsb.base.JSBBaseOutput;
import com.bytedance.badger.collect.impl.constants.Constants;
import com.bytedance.security.android.aopcheck.reporter.ReportConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b&\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0002\t\nB\u0005¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u0006X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetPhoneInfo;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/AbsJSBMethod;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetPhoneInfo$GetPhoneInfoInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetPhoneInfo$GetPhoneInfoOutput;", "()V", "name", "", "getName", "()Ljava/lang/String;", "GetPhoneInfoInput", "GetPhoneInfoOutput", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbsJsbGetPhoneInfo extends AbsJSBMethod<GetPhoneInfoInput, GetPhoneInfoOutput> {
    private final String name;

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetPhoneInfo$GetPhoneInfoInput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/IJSBParams;", ReportConstant.COMMON_ACTION_TYPE, "", "(Ljava/lang/String;)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetPhoneInfoInput implements IJSBParams {
        public String actionType;

        /* JADX WARN: Multi-variable type inference failed */
        public GetPhoneInfoInput() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public GetPhoneInfoInput(String r100) {
            Intrinsics.checkNotNullParameter(r100, ReportConstant.COMMON_ACTION_TYPE);
            this.actionType = r100;
        }

        public /* synthetic */ GetPhoneInfoInput(String r100, int r101, DefaultConstructorMarker r102) {
            if ((r101 & 1) == 0) goto L5;
            r100 = "";
        L5:
            this(r100);
        }
    }

    /* JADX INFO: loaded from: classes28.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nR\u0012\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/android/ttcjpaysdk/base/h5/cjjsb/abs/AbsJsbGetPhoneInfo$GetPhoneInfoOutput;", "Lcom/android/ttcjpaysdk/base/h5/cjjsb/base/JSBBaseOutput;", "result", "", Constants.OperatorKey.KEY_CARRIER, "maskPhone", "token", "providerAppId", Constants.OperatorKey.KEY_NETWORK_STATUS, "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V", "base-context_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class GetPhoneInfoOutput extends JSBBaseOutput {
        public String carrier;
        public String maskPhone;
        public int networkStatus;
        public String providerAppId;
        public String result;
        public String token;

        public GetPhoneInfoOutput() {
            this(null, null, null, null, null, 0, 63, null);
        }

        public GetPhoneInfoOutput(String r100, String r101, String r102, String r103, String r104, int r105) {
            Intrinsics.checkNotNullParameter(r100, "result");
            Intrinsics.checkNotNullParameter(r101, Constants.OperatorKey.KEY_CARRIER);
            Intrinsics.checkNotNullParameter(r102, "maskPhone");
            Intrinsics.checkNotNullParameter(r103, "token");
            Intrinsics.checkNotNullParameter(r104, "providerAppId");
            this.result = r100;
            this.carrier = r101;
            this.maskPhone = r102;
            this.token = r103;
            this.providerAppId = r104;
            this.networkStatus = r105;
        }

        public /* synthetic */ GetPhoneInfoOutput(String r100, String r101, String r102, String r103, String r104, int r110, int r111, DefaultConstructorMarker r112) {
            String r105 = "";
            if ((r111 & 1) == 0) goto L5;
            String r113 = "";
        L7:
            if ((r111 & 2) == 0) goto L9;
            String r106 = "";
        L11:
            if ((r111 & 4) == 0) goto L13;
            String r107 = "";
        L15:
            if ((r111 & 8) == 0) goto L17;
            String r108 = "";
        L19:
            if ((r111 & 16) != 0) goto L23;
            r105 = r104;
        L23:
            if ((r111 & 32) == 0) goto L25;
            int r114 = -1;
        L26:
            this(r113, r106, r107, r108, r105, r114);
            return;
        L25:
            r114 = r110;
            goto L26
        L17:
            r108 = r103;
            goto L19
        L13:
            r107 = r102;
            goto L15
        L9:
            r106 = r101;
            goto L11
        L5:
            r113 = r100;
            goto L7
        }
    }

    public AbsJsbGetPhoneInfo() {
        this.name = "ttcjpay.getPhoneInfo";
    }

    @Override // com.android.ttcjpaysdk.base.h5.cjjsb.base.AbsJSBMethod, cd4.m
    public final String getName() {
        return this.name;
    }
}
