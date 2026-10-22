package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 A2\u00020\u00012\u00020\u0002:\u0001AB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B5\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u000e\u00108\u001a\b\u0012\u0004\u0012\u0002090\u001aH\u0016J\"\u0010:\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020\u000fH\u0016J\u0018\u0010?\u001a\u00020;2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010@\u001a\u00020\u000fH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010 \"\u0004\b%\u0010\"R\u001c\u0010&\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010 \"\u0004\b(\u0010\"R\u001c\u0010)\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010 \"\u0004\b+\u0010\"R\u001c\u0010,\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010 \"\u0004\b.\u0010\"R\u001c\u0010/\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010 \"\u0004\b1\u0010\"R\"\u00102\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u001c\"\u0004\b4\u0010\u001eR\u001c\u00105\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0016\"\u0004\b7\u0010\u0018¨\u0006B"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "duration", "", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;I)V", "getDuration", "()I", "setDuration", "(I)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "markers", "", "getMarkers", "()Ljava/util/List;", "setMarkers", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "recordStatus", "getRecordStatus", "setRecordStatus", "recordType", "getRecordType", "setRecordType", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceAppPackage", "getSourceAppPackage", "setSourceAppPackage", "summary", "getSummary", "setSummary", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class RecordingEntity extends AppEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 2;
    private static final int RELATED_VERSION = 1;
    private int duration;

    @NotNull
    private FileEntity file;

    @Nullable
    private List<Integer> markers;

    @NotNull
    private String name;

    @Nullable
    private String recordStatus;

    @Nullable
    private String recordType;

    @Nullable
    private String sourceAppName;

    @Nullable
    private String sourceAppPackage;

    @Nullable
    private String summary;

    @Nullable
    private List<String> todoList;

    @Nullable
    private FileEntity transcript;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/RecordingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<RecordingEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RecordingEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.RecordingEntity");
            return (RecordingEntity) r11;
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public RecordingEntity[] newArray(int r10) {
            return new RecordingEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RecordingEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public RecordingEntity(@NotNull Parcel r11) {
        q.g(r11, "parcel");
        String r10 = EntityExtKt.f(r11);
        long r12 = r11.readLong();
        long r13 = r11.readLong();
        String r14 = EntityExtKt.f(r11);
        Parcelable r15 = r11.readParcelable(FileEntity.class.getClassLoader());
        q.d(r15);
        this(r10, r12, r13, r14, (FileEntity) r15, r11.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r16 = r11.readInt();
        this.transcript = (FileEntity) r11.readParcelable(FileEntity.class.getClassLoader());
        this.summary = r11.readString();
        ArrayList r17 = new ArrayList();
        r11.readList(r17, String.class.getClassLoader());
        this.todoList = r17;
        ArrayList r18 = new ArrayList();
        r11.readList(r18, Integer.TYPE.getClassLoader());
        this.markers = r18;
        this.sourceAppName = r11.readString();
        this.sourceAppPackage = r11.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 2, r16);
    }

    public final int getDuration() {
        return this.duration;
    }

    @NotNull
    public final FileEntity getFile() {
        return this.file;
    }

    @Nullable
    public final List<Integer> getMarkers() {
        return this.markers;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getRecordStatus() {
        return this.recordStatus;
    }

    @Nullable
    public final String getRecordType() {
        return this.recordType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    @NotNull
    public List<Uri> getSharedUris() {
        return this.file.getSharedUris();
    }

    @Nullable
    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    @Nullable
    public final String getSourceAppPackage() {
        return this.sourceAppPackage;
    }

    @Nullable
    public final String getSummary() {
        return this.summary;
    }

    @Nullable
    public final List<String> getTodoList() {
        return this.todoList;
    }

    @Nullable
    public final FileEntity getTranscript() {
        return this.transcript;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        String r13 = null;
        if (r12 != 1) goto L5;
        Object r14 = r10.readValue(r11);
        if ((r14 instanceof String) == false) goto L14;
        r13 = (String) r14;
    L14:
        this.recordType = r13;
        return;
    L5:
        if (r12 != 2) goto L17;
        Object r15 = r10.readValue(r11);
        if ((r15 instanceof String) == false) goto L10;
        r13 = (String) r15;
    L10:
        this.recordStatus = r13;
        return;
    }

    public final void setDuration(int r10) {
        this.duration = r10;
    }

    public final void setFile(@NotNull FileEntity r10) {
        q.g(r10, "<set-?>");
        this.file = r10;
    }

    public final void setMarkers(@Nullable List<Integer> r10) {
        this.markers = r10;
    }

    public final void setName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.name = r10;
    }

    public final void setRecordStatus(@Nullable String r10) {
        this.recordStatus = r10;
    }

    public final void setRecordType(@Nullable String r10) {
        this.recordType = r10;
    }

    public final void setSourceAppName(@Nullable String r10) {
        this.sourceAppName = r10;
    }

    public final void setSourceAppPackage(@Nullable String r10) {
        this.sourceAppPackage = r10;
    }

    public final void setSummary(@Nullable String r10) {
        this.summary = r10;
    }

    public final void setTodoList(@Nullable List<String> r10) {
        this.todoList = r10;
    }

    public final void setTranscript(@Nullable FileEntity r10) {
        this.transcript = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        r10.writeParcelable(this.file, r11);
        r10.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(2);
        r10.writeParcelable(this.transcript, r11);
        r10.writeString(this.summary);
        r10.writeList(this.todoList);
        r10.writeList(this.markers);
        r10.writeString(this.sourceAppName);
        r10.writeString(this.sourceAppPackage);
        r10.writeValue(this.recordType);
        r10.writeValue(this.recordStatus);
    }

    public RecordingEntity(@NotNull String r11, long r12, long r14, @NotNull String r16, @NotNull FileEntity r17, int r18) {
        q.g(r11, "id");
        q.g(r16, "name");
        q.g(r17, "file");
        super(r11, r12, r14, 501);
        this.name = r16;
        this.file = r17;
        this.duration = r18;
    }
}
