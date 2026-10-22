package com.bytedance.android.livesdk.jsbridge.methods.upload;

import com.bytedance.android.livesdk.jsbridge.methods.upload.models.e;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import w20.aa;
import w20.z9;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0004\u0019\u0007\u000e\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel;", "Lw20/aa;", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$Code;", "code", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$Code;", "getCode", "()Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$Code;)V", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$a;", "data", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$a;", "getData", "()Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$a;", "b", "(Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$a;)V", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "<init>", "()V", "Code", "c", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UploadMediaResultModel implements aa {

    @SerializedName("code")
    private Code code;

    @SerializedName("data")
    private a data;

    @SerializedName("msg")
    private String msg;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$Code;", "", "Lw20/z9;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "NO_PERMISSION", "NOT_REGISTER", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements z9 {
        public static final Code Failed = null;
        public static final Code NOT_REGISTER = null;
        public static final Code NO_PERMISSION = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f142211a = null;
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
            f142211a = new Code[]{r100, r101, r102, r103};
        }

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f142211a.clone();
        }

        @Override // w20.z9
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

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0016\u0010\u0017R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007\"\u0004\b\r\u0010\tR*\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0007\"\u0004\b\u0015\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$a;", "", "", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$c;", "videoResultList", "Ljava/util/List;", "getVideoResultList", "()Ljava/util/List;", "c", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$b;", "imageResultList", "getImageResultList", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/models/a;", "imageResultListV2", "getImageResultListV2", "b", "Lcom/bytedance/android/livesdk/jsbridge/methods/upload/models/e;", "videoResultListV2", "getVideoResultListV2", "d", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("imageResultList")
        private List<b> imageResultList;

        @SerializedName("imageResultListV2")
        private List<com.bytedance.android.livesdk.jsbridge.methods.upload.models.a> imageResultListV2;

        @SerializedName("videoResultList")
        private List<c> videoResultList;

        @SerializedName("videoResultListV2")
        private List<e> videoResultListV2;

        public a() {
        }

        public final void a(List<b> r100) {
            this.imageResultList = r100;
        }

        public final void b(List<com.bytedance.android.livesdk.jsbridge.methods.upload.models.a> r100) {
            this.imageResultListV2 = r100;
        }

        public final void c(List<c> r100) {
            this.videoResultList = r100;
        }

        public final void d(List<e> r100) {
            this.videoResultListV2 = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$b;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "uri", "getUri", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("uri")
        private String uri;

        @SerializedName("url")
        private String url;

        public b() {
        }

        public final void a(String r100) {
            this.uri = r100;
        }

        public final void b(String r100) {
            this.url = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdk/jsbridge/methods/upload/UploadMediaResultModel$c;", "", "", "vid", "Ljava/lang/String;", "getVid", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "coverUri", "getCoverUri", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "videoMediaInfo", "getVideoMediaInfo", "c", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("coverUri")
        private String coverUri;

        @SerializedName("vid")
        private String vid;

        @SerializedName("videoMediaInfo")
        private String videoMediaInfo;

        public c() {
        }

        public final void a(String r100) {
            this.coverUri = r100;
        }

        public final void b(String r100) {
            this.vid = r100;
        }

        public final void c(String r100) {
            this.videoMediaInfo = r100;
        }
    }

    public UploadMediaResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(a r100) {
        this.data = r100;
    }
}
