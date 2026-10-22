package com.bytedance.android.annie.bridge;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.constants.DBDefinition;
import e7.j0;
import e7.k0;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b.\u0010/R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R0\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R0\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u001b\u0018\u00010\"8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u001d\u001a\u0004\b$\u0010\u001f\"\u0004\b%\u0010!R*\u0010(\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010&8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel;", "Le7/k0;", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$Code;", "code", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$Code;", "getCode", "()Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$Code;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$Code;)V", "", "clientCode", "Ljava/lang/Integer;", "getClientCode", "()Ljava/lang/Integer;", "setClientCode", "(Ljava/lang/Integer;)V", "httpCode", "getHttpCode", "setHttpCode", "", "msg", "Ljava/lang/String;", "getMsg", "()Ljava/lang/String;", "b", "(Ljava/lang/String;)V", "", "", "header", "Ljava/util/Map;", "getHeader", "()Ljava/util/Map;", "setHeader", "(Ljava/util/Map;)V", "", "response", "getResponse", "setResponse", "", "Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$ChooseAndUploadTempFiles;", "tempFiles", "Ljava/util/List;", "getTempFiles", "()Ljava/util/List;", "setTempFiles", "(Ljava/util/List;)V", "<init>", "()V", "ChooseAndUploadTempFiles", "Code", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class ChooseAndUploadResultModel implements k0 {

    @SerializedName("clientCode")
    private Integer clientCode;

    @SerializedName("code")
    private Code code;

    @SerializedName("header")
    private Map<String, ? extends Object> header;

    @SerializedName("httpCode")
    private Integer httpCode;

    @SerializedName("msg")
    private String msg;

    @SerializedName("response")
    private Map<String, Object> response;

    @SerializedName("tempFiles")
    private List<ChooseAndUploadTempFiles> tempFiles;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0001\u001eB\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0004\u001a\u0004\b\u0014\u0010\u0006\"\u0004\b\u0015\u0010\bR$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001f"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$ChooseAndUploadTempFiles;", "", "", "url", "Ljava/lang/String;", "getUrl", "()Ljava/lang/String;", "setUrl", "(Ljava/lang/String;)V", "path", "getPath", "setPath", "", "size", "Ljava/lang/Long;", "getSize", "()Ljava/lang/Long;", "setSize", "(Ljava/lang/Long;)V", "mediaType", "getMediaType", "setMediaType", DBDefinition.MIME_TYPE, "getMimeType", "setMimeType", "base64Data", "getBase64Data", "setBase64Data", "<init>", "()V", "MediaType", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class ChooseAndUploadTempFiles {

        @SerializedName("base64Data")
        private String base64Data;

        @SerializedName("mediaType")
        private String mediaType;

        @SerializedName(DBDefinition.MIME_TYPE)
        private String mimeType;

        @SerializedName("path")
        private String path;

        @SerializedName("size")
        private Long size;

        @SerializedName("url")
        private String url;

        @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$ChooseAndUploadTempFiles$MediaType;", "", "", "mediaType", "from", "toString", "Image", "Video", "annie_release"}, k = 1, mv = {1, 4, 3})
        public static final enum MediaType extends Enum<MediaType> {
            public static final MediaType Image = null;
            public static final MediaType Video = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ MediaType[] f38423a = null;

            public static MediaType valueOf(String r100) {
                return (MediaType) r27.a.a(MediaType.class, r100);
            }

            public static MediaType[] values() {
                return (MediaType[]) f38423a.clone();
            }

            static {
                MediaType r100 = new MediaType("Image", 0);
                Image = r100;
                MediaType r101 = new MediaType("Video", 1);
                Video = r101;
                f38423a = new MediaType[]{r100, r101};
            }

            @Override // java.lang.Enum
            public String toString() {
                if (this != Image) goto L6;
                return "image";
            L6:
                if (this != Video) goto L8;
                return "video";
            L8:
                return "";
            }

            public MediaType from(String r100) {
                Intrinsics.checkNotNullParameter(r100, "mediaType");
                String r101 = r100.toLowerCase();
                if (TextUtils.equals("image", r101) == false) goto L7;
                return Image;
            L7:
                if (TextUtils.equals("denied", r101) == true) goto L9;
                return null;
            L9:
                return Video;
            }

            public MediaType(String r100, int r101) {
                super(r100, r101);
            }
        }

        public ChooseAndUploadTempFiles() {
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/annie/bridge/ChooseAndUploadResultModel$Code;", "", "Le7/j0;", "", "getCode", "value", "I", "getValue", "()I", "Success", "Failed", "InvalidParam", "NetworkUnreachable", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final enum Code extends Enum<Code> implements j0 {
        public static final Code Failed = null;
        public static final Code InvalidParam = null;
        public static final Code NetworkUnreachable = null;
        public static final Code Success = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Code[] f38424a = null;
        private final int value;

        public static Code valueOf(String r100) {
            return (Code) r27.a.a(Code.class, r100);
        }

        public static Code[] values() {
            return (Code[]) f38424a.clone();
        }

        static {
            Code r100 = new Code("Success", 0, 1);
            Success = r100;
            Code r101 = new Code("Failed", 1, 0);
            Failed = r101;
            Code r102 = new Code("InvalidParam", 2, -3);
            InvalidParam = r102;
            Code r103 = new Code("NetworkUnreachable", 3, -1001);
            NetworkUnreachable = r103;
            f38424a = new Code[]{r100, r101, r102, r103};
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

    public ChooseAndUploadResultModel() {
    }

    public final void a(Code r100) {
        this.code = r100;
    }

    public final void b(String r100) {
        this.msg = r100;
    }
}
