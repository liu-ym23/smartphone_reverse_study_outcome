package com.bytedance.android.gamecp.hybrid_impl.jsb;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/CancelGamePromoteDownloadResultModel;", "Le7/k0;", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/CancelGamePromoteDownloadResultModel$Code;", "code", "Lcom/bytedance/android/gamecp/hybrid_impl/jsb/CancelGamePromoteDownloadResultModel$Code;", "getCode", "()Lcom/bytedance/android/gamecp/hybrid_impl/jsb/CancelGamePromoteDownloadResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/gamecp/hybrid_impl/jsb/CancelGamePromoteDownloadResultModel$Code;)V", "", "data", "Ljava/lang/String;", "getData", "()Ljava/lang/String;", "setData", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CancelGamePromoteDownloadResultModel implements e7.k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private String data;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/gamecp/hybrid_impl/jsb/CancelGamePromoteDownloadResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "gamecp-hybrid-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements e7.j0 {
        public static final Code Failed = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f57442a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            f57442a = new Code[]{r100, r101};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f57442a.clone();
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

    public CancelGamePromoteDownloadResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }
}
