package com.bytedance.android.annie.bridge;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0002\u0018\u0013B\u0007¢\u0006\u0004\b2\u00103R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R$\u0010\u001b\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R$\u0010\"\u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010*\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.¨\u00064"}, d2 = {"Lcom/bytedance/android/annie/bridge/i;", "", "", "", "mediaType", "Ljava/util/List;", "getMediaType", "()Ljava/util/List;", "setMediaType", "(Ljava/util/List;)V", "", "maxCount", "Ljava/lang/Integer;", "getMaxCount", "()Ljava/lang/Integer;", "setMaxCount", "(Ljava/lang/Integer;)V", "sourceType", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setSourceType", "(Ljava/lang/String;)V", "cameraType", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCameraType", "Lcom/bytedance/android/annie/bridge/i$a;", "imageParams", "Lcom/bytedance/android/annie/bridge/i$a;", "getImageParams", "()Lcom/bytedance/android/annie/bridge/i$a;", "setImageParams", "(Lcom/bytedance/android/annie/bridge/i$a;)V", "Lcom/bytedance/android/annie/bridge/i$b;", "videoParams", "Lcom/bytedance/android/annie/bridge/i$b;", "getVideoParams", "()Lcom/bytedance/android/annie/bridge/i$b;", "setVideoParams", "(Lcom/bytedance/android/annie/bridge/i$b;)V", "", "needBase64Data", "Ljava/lang/Boolean;", "getNeedBase64Data", "()Ljava/lang/Boolean;", "setNeedBase64Data", "(Ljava/lang/Boolean;)V", "saveToPhotoAlbum", "getSaveToPhotoAlbum", "setSaveToPhotoAlbum", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("cameraType")
    private String cameraType;

    @SerializedName("imageParams")
    private a imageParams;

    @SerializedName("maxCount")
    private Integer maxCount;

    @SerializedName("mediaType")
    private List<String> mediaType;

    @SerializedName("needBase64Data")
    private Boolean needBase64Data;

    @SerializedName("saveToPhotoAlbum")
    private Boolean saveToPhotoAlbum;

    @SerializedName("sourceType")
    private String sourceType;

    @SerializedName("videoParams")
    private b videoParams;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\r\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/bytedance/android/annie/bridge/i$a;", "", "", "cropWidth", "Ljava/lang/String;", "getCropWidth", "()Ljava/lang/String;", "setCropWidth", "(Ljava/lang/String;)V", "cropHeight", "getCropHeight", "setCropHeight", "", "compressMaxSize", "Ljava/lang/Integer;", "getCompressMaxSize", "()Ljava/lang/Integer;", "setCompressMaxSize", "(Ljava/lang/Integer;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("compressMaxSize")
        private Integer compressMaxSize;

        @SerializedName("cropHeight")
        private String cropHeight;

        @SerializedName("cropWidth")
        private String cropWidth;

        public a() {
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/annie/bridge/i$b;", "", "", "durationLimit", "Ljava/lang/Integer;", "getDurationLimit", "()Ljava/lang/Integer;", "setDurationLimit", "(Ljava/lang/Integer;)V", "<init>", "()V", "annie_release"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("durationLimit")
        private Integer durationLimit;

        public b() {
        }
    }

    public i() {
    }

    public final String a() {
        return this.cameraType;
    }

    public final String b() {
        return this.sourceType;
    }
}
