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
public final class AuditoryRecordingEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private int duration;
    private FileEntity file;
    private List<Integer> markers;
    private String name;
    private String sourceAppName;
    private String sourceAppPackage;
    private final int state;
    private String summary;
    private List<String> todoList;
    private FileEntity transcript;

    public static final class CREATOR implements Parcelable.Creator<AuditoryRecordingEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditoryRecordingEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AuditoryRecordingEntity");
            return (AuditoryRecordingEntity) ZeusTransformUtils.preCheckCast(r1, AuditoryRecordingEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AuditoryRecordingEntity[] newArray(int r1) {
            return new AuditoryRecordingEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AuditoryRecordingEntity(Parcel r13) {
        o.e(r13, "parcel");
        String r2 = EntityExtKt.a(r13);
        long r3 = r13.readLong();
        long r5 = r13.readLong();
        String r7 = EntityExtKt.a(r13);
        int r8 = r13.readInt();
        Parcelable r0 = r13.readParcelable(FileEntity.class.getClassLoader());
        o.a(r0);
        this(r2, r3, r5, r7, r8, (FileEntity) ZeusTransformUtils.preCheckCast(r0, FileEntity.class, "com.obric.aiagent.plugin"), r13.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        int r1 = r13.readInt();
        this.transcript = (FileEntity) ZeusTransformUtils.preCheckCast(r13.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.aiagent.plugin");
        this.summary = r13.readString();
        ArrayList r4 = new ArrayList();
        r13.readList(r4, String.class.getClassLoader());
        this.todoList = r4;
        ArrayList r6 = new ArrayList();
        r13.readList(r6, Integer.TYPE.getClassLoader());
        this.markers = r6;
        this.sourceAppName = r13.readString();
        this.sourceAppPackage = r13.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 0, r1);
    }

    public AuditoryRecordingEntity(String r11, long r12, long r14, String r16, int r17, FileEntity r18, int r19) {
        o.e(r11, DbHelper.COL_ID);
        o.e(r16, "name");
        o.e(r18, "file");
        super(r11, r12, r14, EntityType.AUDITORY_RECORDING);
        this.name = r16;
        this.state = r17;
        this.file = r18;
        this.duration = r19;
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

    public final int getState() {
        return this.state;
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
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
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

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourceAppPackage(String r1) {
        this.sourceAppPackage = r1;
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
        r2.writeInt(this.state);
        r2.writeParcelable(this.file, r3);
        r2.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(0);
        r2.writeParcelable(this.transcript, r3);
        r2.writeString(this.summary);
        r2.writeList(this.todoList);
        r2.writeList(this.markers);
        r2.writeString(this.sourceAppName);
        r2.writeString(this.sourceAppPackage);
    }
}
