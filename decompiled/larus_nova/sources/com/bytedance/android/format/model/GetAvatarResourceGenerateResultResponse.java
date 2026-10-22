package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/bytedance/android/format/model/GetAvatarResourceGenerateResultResponse;", "Ljava/io/Serializable;", "()V", "generateStatus", "", "getGenerateStatus", "()I", "setGenerateStatus", "(I)V", "virtualTopic", "", "getVirtualTopic", "()Ljava/lang/String;", "setVirtualTopic", "(Ljava/lang/String;)V", "GenerateStatus", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAvatarResourceGenerateResultResponse implements Serializable {

    @SerializedName("generate_status")
    private int generateStatus;

    @SerializedName("virtual_topic")
    private String virtualTopic;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/bytedance/android/format/model/GetAvatarResourceGenerateResultResponse$GenerateStatus;", "", "", "status", "I", "getStatus", "()I", "ResourceGenerateUnknown", "ResourceGenerating", "ResourceGenerated", "ResourceGenerateFailed", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum GenerateStatus extends Enum<GenerateStatus> {
        public static final GenerateStatus ResourceGenerateFailed = null;
        public static final GenerateStatus ResourceGenerateUnknown = null;
        public static final GenerateStatus ResourceGenerated = null;
        public static final GenerateStatus ResourceGenerating = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ GenerateStatus[] f51342a = null;
        private final int status;

        static {
            GenerateStatus r100 = new GenerateStatus("ResourceGenerateUnknown", 0, 0);
            ResourceGenerateUnknown = r100;
            GenerateStatus r101 = new GenerateStatus("ResourceGenerating", 1, 1);
            ResourceGenerating = r101;
            GenerateStatus r102 = new GenerateStatus("ResourceGenerated", 2, 2);
            ResourceGenerated = r102;
            GenerateStatus r103 = new GenerateStatus("ResourceGenerateFailed", 3, 3);
            ResourceGenerateFailed = r103;
            f51342a = new GenerateStatus[]{r100, r101, r102, r103};
        }

        public static GenerateStatus valueOf(String r100) {
            return (GenerateStatus) r27.a.a(GenerateStatus.class, r100);
        }

        public static GenerateStatus[] values() {
            return (GenerateStatus[]) f51342a.clone();
        }

        public final int getStatus() {
            return this.status;
        }

        public GenerateStatus(String r100, int r101, int r102) {
            super(r100, r101);
            this.status = r102;
        }
    }

    public GetAvatarResourceGenerateResultResponse() {
    }

    public final int getGenerateStatus() {
        return this.generateStatus;
    }

    public final String getVirtualTopic() {
        return this.virtualTopic;
    }

    public final void setGenerateStatus(int r100) {
        this.generateStatus = r100;
    }

    public final void setVirtualTopic(String r100) {
        this.virtualTopic = r100;
    }
}
