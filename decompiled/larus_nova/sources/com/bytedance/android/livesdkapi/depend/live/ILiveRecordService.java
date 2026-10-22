package com.bytedance.android.livesdkapi.depend.live;

import android.content.Intent;
import com.byted.cast.common.bean.State;
import com.bytedance.android.livesdkapi.depend.model.broadcast.AnchorVideoSticker;
import com.ss.android.socialbase.downloader.segment.Segment;
import io.reactivex.Observable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\bf\u0018\u00002\u00020\u0001:\u000512345J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH&J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H&J\b\u0010\u0015\u001a\u00020\tH&J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\b\u0010\u0018\u001a\u00020\u0019H&J\b\u0010\u001a\u001a\u00020\u0019H&J\b\u0010\u001b\u001a\u00020\u0019H&J\b\u0010\u001c\u001a\u00020\u0019H&J\b\u0010\u001d\u001a\u00020\tH&J\u0010\u0010\u001e\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH&J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000fH&J\u0010\u0010 \u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0003H&J\u0012\u0010!\u001a\u00020\t2\b\u0010\"\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u0019H&J\u0010\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020'H&JB\u0010(\u001a\n\u0012\u0004\u0012\u00020*\u0018\u00010)2\u0006\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u00032\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020.2\u0006\u00100\u001a\u00020.2\u0006\u0010\u0002\u001a\u00020\u0003H&R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u00066"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService;", "", "source", "", "getSource", "()Ljava/lang/String;", "setSource", "(Ljava/lang/String;)V", "addNeedDeleteVideoPath", "", "path", "addPublishStatusListener", "listener", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatusListener;", "addRecordStatsChangeListener", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "changePublishStatus", "status", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatus;", "progress", "", "deleteLastVideo", "getRecordPermissionIntent", "Landroid/content/Intent;", "isClearScreen", "", "isLivePublishVideo", "isPreview", "isRecording", "release", "removePublishStatusListener", "removeRecordStatsChangeListener", "removeVideo", "saveRecordPermissionIntent", "intent", "setClearScreen", "clearScreen", "setRecordStatus", "recording", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatus;", "startReqAndWriteMetadata", "Lio/reactivex/Observable;", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordMetaData;", "originFilePath", "customDstFilePath", "roomId", "", Segment.JsonKey.START, "ed", "PublishStatus", "PublishStatusListener", "RecordMetaData", "RecordStatus", "RecordStatusChangeListener", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveRecordService {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatus;", "", "status", "", "(Ljava/lang/String;II)V", "UNKNOW", "PUBLISH_START", "PUBLISH_PROGRESS", "PUBLISH_FAILED", "PUBLISH_FINISH", "SAVE_DRAFT_SUCCESS", "SAVE_DRAFT_FAILED", "ADMIN_RECORD_ANCHOR_PUBLISH_SUCCESS", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum PublishStatus extends Enum<PublishStatus> {
        private static final /* synthetic */ PublishStatus[] $VALUES = null;
        public static final PublishStatus ADMIN_RECORD_ANCHOR_PUBLISH_SUCCESS = null;
        public static final PublishStatus PUBLISH_FAILED = null;
        public static final PublishStatus PUBLISH_FINISH = null;
        public static final PublishStatus PUBLISH_PROGRESS = null;
        public static final PublishStatus PUBLISH_START = null;
        public static final PublishStatus SAVE_DRAFT_FAILED = null;
        public static final PublishStatus SAVE_DRAFT_SUCCESS = null;
        public static final PublishStatus UNKNOW = null;

        public static PublishStatus valueOf(String r100) {
            return (PublishStatus) a.a(PublishStatus.class, r100);
        }

        public static PublishStatus[] values() {
            return (PublishStatus[]) $VALUES.clone();
        }

        static {
            PublishStatus r100 = new PublishStatus("UNKNOW", 0, 0);
            UNKNOW = r100;
            PublishStatus r101 = new PublishStatus("PUBLISH_START", 1, 1);
            PUBLISH_START = r101;
            PublishStatus r102 = new PublishStatus("PUBLISH_PROGRESS", 2, 2);
            PUBLISH_PROGRESS = r102;
            PublishStatus r103 = new PublishStatus("PUBLISH_FAILED", 3, 3);
            PUBLISH_FAILED = r103;
            PublishStatus r104 = new PublishStatus("PUBLISH_FINISH", 4, 4);
            PUBLISH_FINISH = r104;
            PublishStatus r105 = new PublishStatus("SAVE_DRAFT_SUCCESS", 5, 5);
            SAVE_DRAFT_SUCCESS = r105;
            PublishStatus r106 = new PublishStatus("SAVE_DRAFT_FAILED", 6, 6);
            SAVE_DRAFT_FAILED = r106;
            PublishStatus r107 = new PublishStatus("ADMIN_RECORD_ANCHOR_PUBLISH_SUCCESS", 7, 7);
            ADMIN_RECORD_ANCHOR_PUBLISH_SUCCESS = r107;
            $VALUES = new PublishStatus[]{r100, r101, r102, r103, r104, r105, r106, r107};
        }

        private PublishStatus(String r100, int r101, int r102) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\b"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatusListener;", "", "onChange", "", "status", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$PublishStatus;", "progress", "", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface PublishStatusListener {
        void onChange(PublishStatus r100, int r101);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J+\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordMetaData;", "", "originFile", "", "newFile", "sticker", "Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;)V", "getNewFile", "()Ljava/lang/String;", "getOriginFile", "getSticker", "()Lcom/bytedance/android/livesdkapi/depend/model/broadcast/AnchorVideoSticker;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class RecordMetaData {
        private final String newFile;
        private final String originFile;
        private final AnchorVideoSticker sticker;

        public static /* synthetic */ RecordMetaData copy$default(RecordMetaData r100, String r101, String r102, AnchorVideoSticker r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.originFile;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.newFile;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.sticker;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final String component1() {
            return this.originFile;
        }

        public final String component2() {
            return this.newFile;
        }

        public final AnchorVideoSticker component3() {
            return this.sticker;
        }

        public final RecordMetaData copy(String r100, String r101, AnchorVideoSticker r102) {
            Intrinsics.checkNotNullParameter(r100, "originFile");
            return new RecordMetaData(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof RecordMetaData) == false) goto L12;
            RecordMetaData r101 = (RecordMetaData) r100;
            if (Intrinsics.areEqual(this.originFile, r101.originFile) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.newFile, r101.newFile) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.sticker, r101.sticker) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public int hashCode() {
            String r100 = this.originFile;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.newFile;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            AnchorVideoSticker r107 = this.sticker;
            if (r107 == null) goto L14;
            r101 = r107.hashCode();
        L14:
            return r106 + r101;
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "RecordMetaData(originFile=" + this.originFile + ", newFile=" + this.newFile + ", sticker=" + this.sticker + ")";
        }

        public final String getNewFile() {
            return this.newFile;
        }

        public final String getOriginFile() {
            return this.originFile;
        }

        public final AnchorVideoSticker getSticker() {
            return this.sticker;
        }

        public RecordMetaData(String r100, String r101, AnchorVideoSticker r102) {
            Intrinsics.checkNotNullParameter(r100, "originFile");
            this.originFile = r100;
            this.newFile = r101;
            this.sticker = r102;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatus;", "", "status", "", "(Ljava/lang/String;II)V", "UNKONW", "READY", State.RECORDING, "PREVIEW", "FINISH", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum RecordStatus extends Enum<RecordStatus> {
        private static final /* synthetic */ RecordStatus[] $VALUES = null;
        public static final RecordStatus FINISH = null;
        public static final RecordStatus PREVIEW = null;
        public static final RecordStatus READY = null;
        public static final RecordStatus RECORDING = null;
        public static final RecordStatus UNKONW = null;

        static {
            RecordStatus r100 = new RecordStatus("UNKONW", 0, 0);
            UNKONW = r100;
            RecordStatus r101 = new RecordStatus("READY", 1, 1);
            READY = r101;
            RecordStatus r102 = new RecordStatus(State.RECORDING, 2, 2);
            RECORDING = r102;
            RecordStatus r103 = new RecordStatus("PREVIEW", 3, 3);
            PREVIEW = r103;
            RecordStatus r104 = new RecordStatus("FINISH", 4, 4);
            FINISH = r104;
            $VALUES = new RecordStatus[]{r100, r101, r102, r103, r104};
        }

        public static RecordStatus valueOf(String r100) {
            return (RecordStatus) a.a(RecordStatus.class, r100);
        }

        public static RecordStatus[] values() {
            return (RecordStatus[]) $VALUES.clone();
        }

        private RecordStatus(String r100, int r101, int r102) {
            super(r100, r101);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatusChangeListener;", "", "onChange", "", "status", "Lcom/bytedance/android/livesdkapi/depend/live/ILiveRecordService$RecordStatus;", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface RecordStatusChangeListener {
        void onChange(RecordStatus r100);
    }

    void addNeedDeleteVideoPath(String r100);

    void addPublishStatusListener(PublishStatusListener r100);

    void addRecordStatsChangeListener(RecordStatusChangeListener r100);

    void changePublishStatus(PublishStatus r100, int r101);

    void deleteLastVideo();

    Intent getRecordPermissionIntent();

    String getSource();

    boolean isClearScreen();

    boolean isLivePublishVideo();

    boolean isPreview();

    boolean isRecording();

    void release();

    void removePublishStatusListener(PublishStatusListener r100);

    void removeRecordStatsChangeListener(RecordStatusChangeListener r100);

    void removeVideo(String r100);

    void saveRecordPermissionIntent(Intent r100);

    void setClearScreen(boolean r100);

    void setRecordStatus(RecordStatus r100);

    void setSource(String r100);

    Observable<RecordMetaData> startReqAndWriteMetadata(String r100, String r101, long r102, long r103, long r104, String r105);
}
