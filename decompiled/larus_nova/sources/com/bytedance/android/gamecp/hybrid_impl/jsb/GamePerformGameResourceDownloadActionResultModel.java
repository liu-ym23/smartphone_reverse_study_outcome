package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0012\u0007B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel;", "Le7/k0;", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$Code;", "code", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$Code;", "getCode", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$Code;)V", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$a;", "data", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$a;", "getData", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$a;", "b", "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$a;)V", "<init>", "()V", "Code", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GamePerformGameResourceDownloadActionResultModel implements e7.k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements e7.j0 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f57455a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f57455a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f57455a.clone();
        }

        @Override // e7.j0
        public int getCode() {
            return this.value;
        }

        public final int getValue() {
            return this.value;
        }

        public Code(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0004\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/GamePerformGameResourceDownloadActionResultModel$a;", "", "", "errorCode", "Ljava/lang/Number;", "getErrorCode", "()Ljava/lang/Number;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Number;)V", "", "errorMsg", "Ljava/lang/String;", "getErrorMsg", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "<init>", "()V", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("errorCode")
        private Number errorCode;

        @SerializedName("errorMsg")
        private String errorMsg;

        public a() {
        }

        public final void a(Number r100) {
            this.errorCode = r100;
        }

        public final void b(String r100) {
            this.errorMsg = r100;
        }
    }

    public GamePerformGameResourceDownloadActionResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.data = r100;
    }
}
