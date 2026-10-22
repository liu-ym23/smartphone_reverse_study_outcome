package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.callsummary.widget.CallSummaryWidget;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001aH\u0016J\"\u0010:\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0018\u0010?\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u000fH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010&\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010/\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\"\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001c\u00105\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018¨\u0006B"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "duration", "", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;I)V", "getDuration", "()I", "setDuration", "(I)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "markers", "", "getMarkers", "()Ljava/util/List;", "setMarkers", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "recordStatus", "getRecordStatus", "setRecordStatus", "recordType", "getRecordType", "setRecordType", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceAppPackage", "getSourceAppPackage", "setSourceAppPackage", CallSummaryWidget.PROVIDER_BUNDLE_PARAMS_DATA_SUMMARY, "getSummary", "setSummary", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecordingEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 2;
    private static final int RELATED_VERSION = 1;
    private int duration;
    private FileEntity file;
    private List<Integer> markers;
    private String name;
    private String recordStatus;
    private String recordType;
    private String sourceAppName;
    private String sourceAppPackage;
    private String summary;
    private List<String> todoList;
    private FileEntity transcript;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<RecordingEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.RecordingEntity");
            return (RecordingEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingEntity[] newArray(int r1) {
            return new RecordingEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public RecordingEntity(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        String r2 = EntityExtKt.readStringOrEmpty(r11);
        long r3 = r11.readLong();
        long r5 = r11.readLong();
        String r7 = EntityExtKt.readStringOrEmpty(r11);
        Parcelable r0 = r11.readParcelable(FileEntity.class.getClassLoader());
        Intrinsics.checkNotNull(r0);
        this(r2, r3, r5, r7, (FileEntity) r0, r11.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r1 = r11.readInt();
        this.transcript = (FileEntity) r11.readParcelable(FileEntity.class.getClassLoader());
        this.summary = r11.readString();
        ArrayList r4 = new ArrayList();
        r11.readList(r4, String.class.getClassLoader());
        this.todoList = r4;
        ArrayList r6 = new ArrayList();
        r11.readList(r6, Integer.TYPE.getClassLoader());
        this.markers = r6;
        this.sourceAppName = r11.readString();
        this.sourceAppPackage = r11.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 2, r1);
    }

    public RecordingEntity(String r11, long r12, long r14, String r16, FileEntity r17, int r18) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r16, "name");
        Intrinsics.checkNotNullParameter(r17, "file");
        super(r11, r12, r14, 501);
        this.name = r16;
        this.file = r17;
        this.duration = r18;
    }

    public final int getDuration() {
        return this.duration;
    }

    public final FileEntity getFile() {
        return this.file;
    }

    public final List<Integer> getMarkers() {
        return this.markers;
    }

    public final String getName() {
        return this.name;
    }

    public final String getRecordStatus() {
        return this.recordStatus;
    }

    public final String getRecordType() {
        return this.recordType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return this.file.getSharedUris();
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceAppPackage() {
        return this.sourceAppPackage;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final FileEntity getTranscript() {
        return this.transcript;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        String r1 = null;
        if (r5 != 1) goto L5;
        Object r6 = r3.readValue(r4);
        if ((r6 instanceof String) == false) goto L14;
        r1 = (String) r6;
    L14:
        this.recordType = r1;
        return;
    L5:
        if (r5 != 2) goto L17;
        Object r7 = r3.readValue(r4);
        if ((r7 instanceof String) == false) goto L10;
        r1 = (String) r7;
    L10:
        this.recordStatus = r1;
        return;
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setFile(FileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.file = r2;
    }

    public final void setMarkers(List<Integer> r1) {
        this.markers = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    public final void setRecordStatus(String r1) {
        this.recordStatus = r1;
    }

    public final void setRecordType(String r1) {
        this.recordType = r1;
    }

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourceAppPackage(String r1) {
        this.sourceAppPackage = r1;
    }

    public final void setSummary(String r1) {
        this.summary = r1;
    }

    public final void setTodoList(List<String> r1) {
        this.todoList = r1;
    }

    public final void setTranscript(FileEntity r1) {
        this.transcript = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeParcelable(this.file, r3);
        r2.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(2);
        r2.writeParcelable(this.transcript, r3);
        r2.writeString(this.summary);
        r2.writeList(this.todoList);
        r2.writeList(this.markers);
        r2.writeString(this.sourceAppName);
        r2.writeString(this.sourceAppPackage);
        r2.writeValue(this.recordType);
        r2.writeValue(this.recordStatus);
    }
}
