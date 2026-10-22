package com.bytedance.android.live.browser.jsbridge.base;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import e7.j0;
import e7.k0;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0003\u0019\u0007\u0015B\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel;", "Le7/k0;", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$Code;", "code", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$Code;", "getCode", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$Code;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$b;", "status_params", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$b;", "getStatus_params", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$b;", "c", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$b;)V", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$a;", "common_params", "Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$a;", "getCommon_params", "()Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$a;", "b", "(Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$a;)V", "<init>", "()V", "Code", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveGetInteractToolInfoResultModel implements k0 {

    @SerializedName("code")
    private Code code;

    @SerializedName("common_params")
    private a common_params;

    @SerializedName("status_params")
    private b status_params;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f63059a = null;
        private final int value;

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("NO_PERMISSION", 2, -1);
            NO_PERMISSION = r102;
            Code r103 = new Code("NOT_REGISTER", 3, -2);
            NOT_REGISTER = r103;
            f63059a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f63059a.clone();
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

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$a;", "", "", "effect_sdk_version", "Ljava/lang/String;", "getEffect_sdk_version", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("effect_sdk_version")
        private String effect_sdk_version;

        public a() {
        }

        public final void a(String r100) {
            this.effect_sdk_version = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0004\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/live/browser/jsbridge/base/LiveGetInteractToolInfoResultModel$b;", "", "", "downloading_id", "Ljava/lang/String;", "getDownloading_id", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "use_status", "getUse_status", "d", "repel_status", "getRepel_status", "c", "is_video_merge", "e", "", "count_limit", "Ljava/lang/Number;", "getCount_limit", "()Ljava/lang/Number;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Number;)V", "<init>", "()V", "livehybrid-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("count_limit")
        private Number count_limit;

        @SerializedName("downloading_id")
        private String downloading_id;

        @SerializedName("is_video_merge")
        private String is_video_merge;

        @SerializedName("repel_status")
        private String repel_status;

        @SerializedName("use_status")
        private String use_status;

        public b() {
        }

        public final void a(Number r100) {
            this.count_limit = r100;
        }

        public final void b(String r100) {
            this.downloading_id = r100;
        }

        public final void c(String r100) {
            this.repel_status = r100;
        }

        public final void d(String r100) {
            this.use_status = r100;
        }

        public final void e(String r100) {
            this.is_video_merge = r100;
        }
    }

    public LiveGetInteractToolInfoResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.common_params = r100;
    }

    public final void c(b r100) {
        this.status_params = r100;
    }
}
