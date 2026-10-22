package ad2;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b'\u0010(R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR*\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR$\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u001f\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#¨\u0006)"}, d2 = {"Lad2/c0;", "", "Lad2/c0$a;", faceverify.w.META_COLL_KEY_AUTH_INFO, "Lad2/c0$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lad2/c0$a;", "setAuthInfo", "(Lad2/c0$a;)V", "", "uploadServerPath", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "setUploadServerPath", "(Ljava/lang/String;)V", "videoUploadExtra", ce.f26391f, "setVideoUploadExtra", "fileType", "c", "setFileType", "", "filePathList", "Ljava/util/List;", "b", "()Ljava/util/List;", "setFilePathList", "(Ljava/util/List;)V", "", "useUploaderV2", "Ljava/lang/Boolean;", "f", "()Ljava/lang/Boolean;", "setUseUploaderV2", "(Ljava/lang/Boolean;)V", "needEncrypt", "d", "setNeedEncrypt", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c0 {

    @SerializedName(faceverify.w.META_COLL_KEY_AUTH_INFO)
    private a authInfo;

    @SerializedName("filePathList")
    private List<String> filePathList;

    @SerializedName("fileType")
    private String fileType;

    @SerializedName("needEncrypt")
    private Boolean needEncrypt;

    @SerializedName("uploadServerPath")
    private String uploadServerPath;

    @SerializedName("useUploaderV2")
    private Boolean useUploaderV2;

    @SerializedName("videoUploadExtra")
    private String videoUploadExtra;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lad2/c0$a;", "", "", "ak", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAk", "(Ljava/lang/String;)V", "sk", "b", "setSk", Segment.JsonKey.START, "d", "setSt", "spaceName", "c", "setSpaceName", "<init>", "()V", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        /* JADX INFO: renamed from: ak, reason: collision with root package name */
        @SerializedName("ak")
        private String f2945ak;

        /* JADX INFO: renamed from: sk, reason: collision with root package name */
        @SerializedName("sk")
        private String f2946sk;

        @SerializedName("spaceName")
        private String spaceName;

        /* JADX INFO: renamed from: st, reason: collision with root package name */
        @SerializedName(Segment.JsonKey.START)
        private String f2947st;

        public a() {
        }

        public final String a() {
            return this.f2945ak;
        }

        public final String b() {
            return this.f2946sk;
        }

        public final String c() {
            return this.spaceName;
        }

        public final String d() {
            return this.f2947st;
        }
    }

    public c0() {
    }

    public final a a() {
        return this.authInfo;
    }

    public final List<String> b() {
        return this.filePathList;
    }

    public final String c() {
        return this.fileType;
    }

    public final Boolean d() {
        return this.needEncrypt;
    }

    public final String e() {
        return this.uploadServerPath;
    }

    public final Boolean f() {
        return this.useUploaderV2;
    }

    public final String g() {
        return this.videoUploadExtra;
    }
}
