package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class RecordingEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 1;
    private int duration;
    private FileEntity file;
    private List<Integer> markers;
    private String name;
    private String recordStatus;
    private String recordType;
    private String sourceAppName;
    private String sourceAppPackage;
    private String sourceDevice;
    private String summary;
    private List<String> todoList;
    private FileEntity transcript;

    public static final class CREATOR implements Parcelable.Creator<RecordingEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        public static final /* synthetic */ FileEntity access$requireFileEntity(CREATOR r0, FileEntity r1) {
            return r0.requireFileEntity(r1);
        }

        private final FileEntity requireFileEntity(FileEntity r1) {
            if (r1 == null) goto L5;
            return r1;
        L5:
            throw new IllegalArgumentException("RecordingEntity.file must not be null".toString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RecordingEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.RecordingEntity");
            return (RecordingEntity) ZeusTransformUtils.preCheckCast(r1, RecordingEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 4;
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

    public RecordingEntity(Parcel r12) {
        o.e(r12, "parcel");
        this(EntityExtKt.a(r12), r12.readLong(), r12.readLong(), EntityExtKt.a(r12), CREATOR.access$requireFileEntity(CREATOR, (FileEntity) ZeusTransformUtils.preCheckCast(r12.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.aiagent.plugin")), r12.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        int r0 = r12.readInt();
        this.transcript = (FileEntity) ZeusTransformUtils.preCheckCast(r12.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.aiagent.plugin");
        this.summary = r12.readString();
        ArrayList r1 = new ArrayList();
        r12.readList(r1, String.class.getClassLoader());
        this.todoList = r1;
        ArrayList r2 = new ArrayList();
        r12.readList(r2, Integer.TYPE.getClassLoader());
        this.markers = r2;
        this.sourceAppName = r12.readString();
        this.sourceAppPackage = r12.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 3, r0);
    }

    public RecordingEntity(String r11, long r12, long r14, String r16, FileEntity r17, int r18) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r16, "name");
        o.e(r17, "file");
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

    public final String getSourceDevice() {
        return this.sourceDevice;
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
    public void onReadSubClassExtensionField(Parcel r4, ClassLoader r5, int r6) {
        o.e(r4, "parcel");
        String r1 = null;
        if (r6 != 1) goto L5;
        Object r7 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L20;
        r1 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L20:
        this.recordType = r1;
        return;
    L5:
        if (r6 != 2) goto L7;
        Object r8 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L16;
        r1 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L16:
        this.recordStatus = r1;
        return;
    L7:
        if (r6 != 3) goto L24;
        Object r9 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L12;
        r1 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L12:
        this.sourceDevice = r1;
        return;
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setFile(FileEntity r2) {
        o.e(r2, "<set-?>");
        this.file = r2;
    }

    public final void setMarkers(List<Integer> r3) {
        this.markers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
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

    public final void setSourceDevice(String r1) {
        this.sourceDevice = r1;
    }

    public final void setSummary(String r1) {
        this.summary = r1;
    }

    public final void setTodoList(List<String> r3) {
        this.todoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setTranscript(FileEntity r1) {
        this.transcript = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        o.e(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeString(this.name);
        r2.writeParcelable(this.file, r3);
        r2.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(3);
        r2.writeParcelable(this.transcript, r3);
        r2.writeString(this.summary);
        r2.writeList(this.todoList);
        r2.writeList(this.markers);
        r2.writeString(this.sourceAppName);
        r2.writeString(this.sourceAppPackage);
        r2.writeValue(this.recordType);
        r2.writeValue(this.recordStatus);
        r2.writeValue(this.sourceDevice);
    }
}
