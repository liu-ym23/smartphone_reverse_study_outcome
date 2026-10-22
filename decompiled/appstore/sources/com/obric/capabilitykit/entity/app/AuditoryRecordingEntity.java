package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.common.wschannel.WsConstants;
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
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0001=B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B=\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\r¢\u0006\u0002\u0010\u0011J\u000e\u00104\u001a\b\u0012\u0004\u0012\u0002050\u001bH\u0016J\"\u00106\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\b\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\rH\u0016J\u0018\u0010;\u001a\u0002072\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010<\u001a\u00020\rH\u0016R\u001a\u0010\u0010\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\"\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R\u001c\u0010'\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0013R\u001c\u0010+\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010!\"\u0004\b-\u0010#R\"\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u001d\"\u0004\b0\u0010\u001fR\u001c\u00101\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0017\"\u0004\b3\u0010\u0019¨\u0006>"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", WsConstants.KEY_CONNECTION_STATE, "", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "duration", "(Ljava/lang/String;JJLjava/lang/String;ILcom/obric/capabilitykit/entity/app/FileEntity;I)V", "getDuration", "()I", "setDuration", "(I)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "markers", "", "getMarkers", "()Ljava/util/List;", "setMarkers", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourceAppPackage", "getSourceAppPackage", "setSourceAppPackage", "getState", "summary", "getSummary", "setSummary", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AuditoryRecordingEntity extends AppEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private int duration;

    @NotNull
    private FileEntity file;

    @Nullable
    private List<Integer> markers;

    @NotNull
    private String name;

    @Nullable
    private String sourceAppName;

    @Nullable
    private String sourceAppPackage;
    private final int state;

    @Nullable
    private String summary;

    @Nullable
    private List<String> todoList;

    @Nullable
    private FileEntity transcript;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/AuditoryRecordingEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<AuditoryRecordingEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AuditoryRecordingEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.AuditoryRecordingEntity");
            return (AuditoryRecordingEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public AuditoryRecordingEntity[] newArray(int r10) {
            return new AuditoryRecordingEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ AuditoryRecordingEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public AuditoryRecordingEntity(@NotNull Parcel r12) {
        q.g(r12, "parcel");
        String r10 = EntityExtKt.f(r12);
        long r11 = r12.readLong();
        long r13 = r12.readLong();
        String r14 = EntityExtKt.f(r12);
        int r15 = r12.readInt();
        Parcelable r16 = r12.readParcelable(FileEntity.class.getClassLoader());
        q.d(r16);
        this(r10, r11, r13, r14, r15, (FileEntity) r16, r12.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        int r17 = r12.readInt();
        this.transcript = (FileEntity) r12.readParcelable(FileEntity.class.getClassLoader());
        this.summary = r12.readString();
        ArrayList r18 = new ArrayList();
        r12.readList(r18, String.class.getClassLoader());
        this.todoList = r18;
        ArrayList r19 = new ArrayList();
        r12.readList(r19, Integer.TYPE.getClassLoader());
        this.markers = r19;
        this.sourceAppName = r12.readString();
        this.sourceAppPackage = r12.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 0, r17);
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

    public final int getState() {
        return this.state;
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
        r10.writeInt(this.state);
        r10.writeParcelable(this.file, r11);
        r10.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(0);
        r10.writeParcelable(this.transcript, r11);
        r10.writeString(this.summary);
        r10.writeList(this.todoList);
        r10.writeList(this.markers);
        r10.writeString(this.sourceAppName);
        r10.writeString(this.sourceAppPackage);
    }

    public AuditoryRecordingEntity(@NotNull String r11, long r12, long r14, @NotNull String r16, int r17, @NotNull FileEntity r18, int r19) {
        q.g(r11, "id");
        q.g(r16, "name");
        q.g(r18, "file");
        super(r11, r12, r14, 502);
        this.name = r16;
        this.state = r17;
        this.file = r18;
        this.duration = r19;
    }
}
