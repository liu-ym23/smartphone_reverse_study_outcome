package com.bytedance.android.format.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR$\u0010\r\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R$\u0010\u0013\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\"\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\n\u001a\u0004\b\u0017\u0010\fR\u001a\u0010\u0018\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/format/model/GetAiPlayImageGenerateResultResponse;", "Ljava/io/Serializable;", "", "generateStatus", "I", "getGenerateStatus", "()I", "", "Lcom/bytedance/android/format/model/o0;", "imageList", "Ljava/util/List;", "getImageList", "()Ljava/util/List;", "openVideo", "Lcom/bytedance/android/format/model/o0;", "getOpenVideo", "()Lcom/bytedance/android/format/model/o0;", "setOpenVideo", "(Lcom/bytedance/android/format/model/o0;)V", "openVideoFirstFrame", "getOpenVideoFirstFrame", "setOpenVideoFirstFrame", "imageMedia", "getImageMedia", "nextReqWaitInterval", "getNextReqWaitInterval", "<init>", "()V", "Status", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GetAiPlayImageGenerateResultResponse implements Serializable {

    @SerializedName("generate_status")
    private final int generateStatus;

    @SerializedName("image_list")
    private final List<o0> imageList;

    @SerializedName("image_media")
    private final List<o0> imageMedia;

    @SerializedName("next_req_wait_time_s")
    private final int nextReqWaitInterval;

    @SerializedName("open_video")
    private o0 openVideo;

    @SerializedName("open_video_first_frame")
    private o0 openVideoFirstFrame;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/format/model/GetAiPlayImageGenerateResultResponse$Status;", "", "", "code", "I", "getCode", "()I", "UNKNOWN", "ING", "SUCCESS", "FAIL", "FREQUENCY_LIMIT", "format-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum Status extends Enum<Status> {
        public static final Status FAIL = null;
        public static final Status FREQUENCY_LIMIT = null;
        public static final Status ING = null;
        public static final Status SUCCESS = null;
        public static final Status UNKNOWN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Status[] f51341a = null;
        private final int code;

        static {
            Status r100 = new Status("UNKNOWN", 0, 0);
            UNKNOWN = r100;
            Status r101 = new Status("ING", 1, 1);
            ING = r101;
            Status r102 = new Status("SUCCESS", 2, 2);
            SUCCESS = r102;
            Status r103 = new Status("FAIL", 3, 3);
            FAIL = r103;
            Status r104 = new Status("FREQUENCY_LIMIT", 4, 4);
            FREQUENCY_LIMIT = r104;
            f51341a = new Status[]{r100, r101, r102, r103, r104};
        }

        public static Status valueOf(String r100) {
            return (Status) r27.a.a(Status.class, r100);
        }

        public static Status[] values() {
            return (Status[]) f51341a.clone();
        }

        public final int getCode() {
            return this.code;
        }

        public Status(String r100, int r101, int r102) {
            super(r100, r101);
            this.code = r102;
        }
    }

    public GetAiPlayImageGenerateResultResponse() {
    }

    public final int getGenerateStatus() {
        return this.generateStatus;
    }

    public final List<o0> getImageList() {
        return this.imageList;
    }

    public final List<o0> getImageMedia() {
        return this.imageMedia;
    }

    public final int getNextReqWaitInterval() {
        return this.nextReqWaitInterval;
    }

    public final o0 getOpenVideo() {
        return this.openVideo;
    }

    public final o0 getOpenVideoFirstFrame() {
        return this.openVideoFirstFrame;
    }

    public final void setOpenVideo(o0 r100) {
        this.openVideo = r100;
    }

    public final void setOpenVideoFirstFrame(o0 r100) {
        this.openVideoFirstFrame = r100;
    }
}
