package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FormatModeEnum;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.collections.y;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 92\u00020\u00012\u00020\u0002:\u00019B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BO\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010-\u001a\u00020.H\u0016J\u000e\u0010/\u001a\b\u0012\u0004\u0012\u0002000\u0014H\u0016J\"\u00101\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\b\u00103\u001a\u0004\u0018\u0001042\u0006\u00105\u001a\u000206H\u0016J\u0018\u00107\u001a\u0002022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u00108\u001a\u000206H\u0016R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u001e\"\u0004\b\u001f\u0010 R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010%\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u0017\"\u0004\b(\u0010\u0019R\u001a\u0010\f\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\"\"\u0004\b,\u0010$¨\u0006:"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "title", "text", "formatMode", "Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", "noteFolder", "isFavorite", "", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;Ljava/lang/String;Z)V", KevaImpl.PrivateConstants.FILES_DIR_NAME, "", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getFiles", "()Ljava/util/List;", "setFiles", "(Ljava/util/List;)V", "getFormatMode", "()Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;", "setFormatMode", "(Lcom/obric/capabilitykit/entity/enums/FormatModeEnum;)V", "()Z", "setFavorite", "(Z)V", "getNoteFolder", "()Ljava/lang/String;", "setNoteFolder", "(Ljava/lang/String;)V", "recordings", "Lcom/obric/capabilitykit/entity/app/RecordingEntity;", "getRecordings", "setRecordings", "getText", "setText", "getTitle", "setTitle", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NoteEntity extends AppEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 5;

    @Nullable
    private List<FileEntity> files;

    @Nullable
    private FormatModeEnum formatMode;
    private boolean isFavorite;

    @Nullable
    private String noteFolder;

    @Nullable
    private List<RecordingEntity> recordings;

    @NotNull
    private String text;

    @NotNull
    private String title;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/NoteEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/NoteEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<NoteEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoteEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.NoteEntity");
            return (NoteEntity) r11;
        }

        public final int getVersion() {
            return 6;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public NoteEntity[] newArray(int r10) {
            return new NoteEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public NoteEntity(@NotNull Parcel r13) {
        q.g(r13, "parcel");
        this(EntityExtKt.f(r13), r13.readLong(), r13.readLong(), EntityExtKt.f(r13), EntityExtKt.f(r13), FormatModeEnum.Companion.a(r13.readString()), r13.readString(), EntityExtKt.e(r13));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r13);
        int r10 = r13.readInt();
        this.files = r13.createTypedArrayList(FileEntity.CREATOR);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r13, 1, r10);
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    @NotNull
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(null, this.title, null, getLastModifiedTime(), 5, null);
    }

    @Nullable
    public final List<FileEntity> getFiles() {
        return this.files;
    }

    @Nullable
    public final FormatModeEnum getFormatMode() {
        return this.formatMode;
    }

    @Nullable
    public final String getNoteFolder() {
        return this.noteFolder;
    }

    @Nullable
    public final List<RecordingEntity> getRecordings() {
        return this.recordings;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    @NotNull
    public List<Uri> getSharedUris() {
        List<FileEntity> r10 = this.files;
        if (r10 == null) goto L9;
        ArrayList r11 = new ArrayList();
        Iterator<T> r12 = r10.iterator();
    L6:
        if (r12.hasNext() == false) goto L11;
        y.v(r11, ((FileEntity) r12.next()).getSharedUris());
        goto L6
    L11:
        return r11;
    L9:
        return t.i();
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L6;
        this.recordings = (List) r10.readValue(r11);
        return;
    }

    public final void setFavorite(boolean r10) {
        this.isFavorite = r10;
    }

    public final void setFiles(@Nullable List<FileEntity> r10) {
        this.files = r10;
    }

    public final void setFormatMode(@Nullable FormatModeEnum r10) {
        this.formatMode = r10;
    }

    public final void setNoteFolder(@Nullable String r10) {
        this.noteFolder = r10;
    }

    public final void setRecordings(@Nullable List<RecordingEntity> r10) {
        this.recordings = r10;
    }

    public final void setText(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.text = r10;
    }

    public final void setTitle(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.title = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.title);
        r10.writeString(this.text);
        FormatModeEnum r12 = this.formatMode;
        if (r12 == null) goto L5;
        String r13 = r12.name();
    L6:
        r10.writeString(r13);
        r10.writeString(this.noteFolder);
        EntityExtKt.g(r10, this.isFavorite);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(1);
        r10.writeTypedList(this.files);
        r10.writeValue(this.recordings);
        return;
    L5:
        r13 = null;
        goto L6
    }

    public NoteEntity(@NotNull String r11, long r12, long r14, @NotNull String r16, @NotNull String r17, @Nullable FormatModeEnum r18, @Nullable String r19, boolean r20) {
        q.g(r11, "id");
        q.g(r16, "title");
        q.g(r17, "text");
        super(r11, r12, r14, 601);
        this.title = r16;
        this.text = r17;
        this.formatMode = r18;
        this.noteFolder = r19;
        this.isFavorite = r20;
    }

    public /* synthetic */ NoteEntity(String r15, long r16, long r18, String r20, String r21, FormatModeEnum r22, String r23, boolean r24, int r25, DefaultConstructorMarker r26) {
        if ((r25 & 32) == 0) goto L5;
        FormatModeEnum r11 = null;
    L7:
        if ((r25 & 64) == 0) goto L9;
        String r12 = null;
    L11:
        if ((r25 & 128) == 0) goto L13;
        boolean r13 = false;
    L14:
        this(r15, r16, r18, r20, r21, r11, r12, r13);
        return;
    L13:
        r13 = r24;
        goto L14
    L9:
        r12 = r23;
        goto L11
    L5:
        r11 = r22;
        goto L7
    }
}
