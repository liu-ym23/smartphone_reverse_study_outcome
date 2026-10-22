package com.android.ttcjpaysdk.bdpay.counter.outer.bean;

import com.android.ttcjpaysdk.base.ktextension.KtSafeMethodExtensionKt;
import com.larksuite.framework.apiplugin.common.LKBaseResponseModel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes28.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0012"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJDyPayResult;", "", "resultCode", "", "msg", "extraInfo", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/lang/String;Lorg/json/JSONObject;)V", "getExtraInfo", "()Lorg/json/JSONObject;", "getMsg", "()Ljava/lang/String;", "getResultCode", "addExtraInfo", "", "key", "value", "Companion", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CJDyPayResult {
    public static final Companion Companion = null;
    public static final String EXT_K_IS_INSUFFICIENT_BALANCE = "is_insufficient_balance";
    public static final String EXT_K_RETURN_URL = "return_url";
    private final JSONObject extraInfo;
    private final String msg;
    private final String resultCode;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004J$\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJDyPayResult$Companion;", "", "()V", "EXT_K_IS_INSUFFICIENT_BALANCE", "", "EXT_K_RETURN_URL", "createResult", "Lcom/android/ttcjpaysdk/bdpay/counter/outer/bean/CJDyPayResult;", LKBaseResponseModel.INNER_CODE_KEY, "", "extraInfo", "Lorg/json/JSONObject;", "msg", "createResultFromOuterCode", "outerCode", "bdpay-counter-outer_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final CJDyPayResult createResult(int r100, JSONObject r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "msg");
            if (r100 != 0) goto L5;
            String r103 = "0";
        L13:
            if (r101 != null) goto L16;
            r101 = new JSONObject();
        L16:
            return new CJDyPayResult(r103, r102, r101, null);
        L5:
            if (r100 != 101) goto L7;
            r103 = "3";
            goto L13
        L7:
            if (r100 == 104) goto L9;
            r103 = "2";
            goto L13
        L9:
            r103 = "1";
            goto L13
        }

        public final CJDyPayResult createResultFromOuterCode(String r100, JSONObject r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "outerCode");
            Intrinsics.checkNotNullParameter(r102, "msg");
            if (r101 != null) goto L6;
            r101 = new JSONObject();
        L6:
            return new CJDyPayResult(r100, r102, r101, null);
        }

        public static /* synthetic */ CJDyPayResult createResult$default(Companion r100, int r101, JSONObject r102, String r103, int r104, Object r105) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = "";
        L9:
            return r100.createResult(r101, r102, r103);
        }

        public static /* synthetic */ CJDyPayResult createResultFromOuterCode$default(Companion r100, String r101, JSONObject r102, String r103, int r104, Object r105) {
            if ((r104 & 2) == 0) goto L6;
            r102 = null;
        L6:
            if ((r104 & 4) == 0) goto L9;
            r103 = "";
        L9:
            return r100.createResultFromOuterCode(r101, r102, r103);
        }
    }

    static {
        Companion = new Companion(null);
    }

    public /* synthetic */ CJDyPayResult(String r100, String r101, JSONObject r102, DefaultConstructorMarker r103) {
        this(r100, r101, r102);
    }

    public final JSONObject getExtraInfo() {
        return this.extraInfo;
    }

    public final String getMsg() {
        return this.msg;
    }

    public final String getResultCode() {
        return this.resultCode;
    }

    public final void addExtraInfo(String r100, Object r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        KtSafeMethodExtensionKt.safePut(this.extraInfo, r100, r101);
    }

    private CJDyPayResult(String r100, String r101, JSONObject r102) {
        this.resultCode = r100;
        this.msg = r101;
        this.extraInfo = r102;
    }
}
