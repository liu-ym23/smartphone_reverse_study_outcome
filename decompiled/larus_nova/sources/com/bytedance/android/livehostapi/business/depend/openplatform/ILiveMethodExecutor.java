package com.bytedance.android.livehostapi.business.depend.openplatform;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0003\n\u000b\fJ\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\rÀ\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor;", "", "executeAsync", "", "param", "Lorg/json/JSONObject;", "executeCallback", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$ILiveMethodCallback;", "executeSync", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodExecuteResult;", "ILiveMethodCallback", "LiveMethodExecuteResult", "LiveMethodFailInfo", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveMethodExecutor {

    /* JADX INFO: renamed from: com.bytedance.android.livehostapi.business.depend.openplatform.ILiveMethodExecutor$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$executeAsync(ILiveMethodExecutor r100, JSONObject r101, ILiveMethodCallback r102) {
        }

        public static LiveMethodExecuteResult $default$executeSync(ILiveMethodExecutor r100, JSONObject r101) {
            return LiveMethodExecuteResult.Companion.buildSuccessResult(null);
        }

        public static /* synthetic */ LiveMethodExecuteResult access$executeSync$jd(ILiveMethodExecutor r100, JSONObject r101) {
            return $default$executeSync(r100, r101);
        }

        public static /* synthetic */ void access$executeAsync$jd(ILiveMethodExecutor r100, JSONObject r101, ILiveMethodCallback r102) {
            $default$executeAsync(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
    public static final class DefaultImpls {
        public static LiveMethodExecuteResult executeSync(ILiveMethodExecutor r100, JSONObject r101) {
            return CC.access$executeSync$jd(r100, r101);
        }

        public static void executeAsync(ILiveMethodExecutor r100, JSONObject r101, ILiveMethodCallback r102) {
            CC.access$executeAsync$jd(r100, r101, r102);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006À\u0006\u0003"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$ILiveMethodCallback;", "", "onResponse", "", "result", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodExecuteResult;", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface ILiveMethodCallback {
        void onResponse(LiveMethodExecuteResult r100);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodExecuteResult;", "", "result", "Lorg/json/JSONObject;", "failInfo", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodFailInfo;", "(Lorg/json/JSONObject;Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodFailInfo;)V", "getFailInfo", "()Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodFailInfo;", "getResult", "()Lorg/json/JSONObject;", "Companion", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveMethodExecuteResult {
        public static final Companion Companion = null;
        private final LiveMethodFailInfo failInfo;
        private final JSONObject result;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J4\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0010\u0010\r\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\f¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodExecuteResult$Companion;", "", "()V", "buildFailResult", "Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodExecuteResult;", "errCode", "", "errNo", "errorType", "", "errorMsg", "result", "Lorg/json/JSONObject;", "buildSuccessResult", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker r100) {
                this();
            }

            /* JADX WARN: Multi-variable type inference failed */
            public final LiveMethodExecuteResult buildSuccessResult(JSONObject r100) {
                return new LiveMethodExecuteResult(r100, null, 0 == true ? 1 : 0);
            }

            public final LiveMethodExecuteResult buildFailResult(int r100, int r101, String r102, String r103, JSONObject r104) {
                return new LiveMethodExecuteResult(r104, new LiveMethodFailInfo(r100, r101, r102, r103), null);
            }
        }

        static {
            Companion = new Companion(null);
        }

        public final LiveMethodFailInfo getFailInfo() {
            return this.failInfo;
        }

        public final JSONObject getResult() {
            return this.result;
        }

        private LiveMethodExecuteResult(JSONObject r100, LiveMethodFailInfo r101) {
            this.result = r100;
            this.failInfo = r101;
        }

        public /* synthetic */ LiveMethodExecuteResult(JSONObject r100, LiveMethodFailInfo r101, DefaultConstructorMarker r102) {
            this(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0006HÆ\u0003J5\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/livehostapi/business/depend/openplatform/ILiveMethodExecutor$LiveMethodFailInfo;", "", "errorCode", "", "errNo", "errorType", "", "errorMsg", "(IILjava/lang/String;Ljava/lang/String;)V", "getErrNo", "()I", "getErrorCode", "getErrorMsg", "()Ljava/lang/String;", "getErrorType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "hostapp-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class LiveMethodFailInfo {
        private final int errNo;
        private final int errorCode;
        private final String errorMsg;
        private final String errorType;

        public static /* synthetic */ LiveMethodFailInfo copy$default(LiveMethodFailInfo r100, int r101, int r102, String r103, String r104, int r105, Object r106) {
            if ((r105 & 1) == 0) goto L6;
            r101 = r100.errorCode;
        L6:
            if ((r105 & 2) == 0) goto L9;
            r102 = r100.errNo;
        L9:
            if ((r105 & 4) == 0) goto L12;
            r103 = r100.errorType;
        L12:
            if ((r105 & 8) == 0) goto L15;
            r104 = r100.errorMsg;
        L15:
            return r100.copy(r101, r102, r103, r104);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final int component2() {
            return this.errNo;
        }

        public final String component3() {
            return this.errorType;
        }

        public final String component4() {
            return this.errorMsg;
        }

        public final LiveMethodFailInfo copy(int r100, int r101, String r102, String r103) {
            return new LiveMethodFailInfo(r100, r101, r102, r103);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof LiveMethodFailInfo) == false) goto L14;
            LiveMethodFailInfo r101 = (LiveMethodFailInfo) r100;
            if (this.errorCode == r101.errorCode) goto L8;
            return false;
        L8:
            if (this.errNo == r101.errNo) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.errorType, r101.errorType) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.errorMsg, r101.errorMsg) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public int hashCode() {
            int r100 = ((this.errorCode * 31) + this.errNo) * 31;
            String r101 = this.errorType;
            int r102 = 0;
            if (r101 == null) goto L5;
            int r103 = r101.hashCode();
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.errorMsg;
            if (r105 == null) goto L10;
            r102 = r105.hashCode();
        L10:
            return r104 + r102;
        L5:
            r103 = 0;
            goto L6
        }

        public String toString() {
            return "LiveMethodFailInfo(errorCode=" + this.errorCode + ", errNo=" + this.errNo + ", errorType=" + this.errorType + ", errorMsg=" + this.errorMsg + ")";
        }

        public final int getErrNo() {
            return this.errNo;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }

        public final String getErrorMsg() {
            return this.errorMsg;
        }

        public final String getErrorType() {
            return this.errorType;
        }

        public LiveMethodFailInfo(int r100, int r101, String r102, String r103) {
            this.errorCode = r100;
            this.errNo = r101;
            this.errorType = r102;
            this.errorMsg = r103;
        }
    }

    void executeAsync(JSONObject r100, ILiveMethodCallback r101);

    LiveMethodExecuteResult executeSync(JSONObject r100);
}
