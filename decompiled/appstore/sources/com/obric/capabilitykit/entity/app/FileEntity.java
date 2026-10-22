package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import androidx.annotation.Keep;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.io.g;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BG\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010)\u001a\u00020'H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "fileName", "fileSize", "contentUrl", "Landroid/net/Uri;", "fileType", "Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", "mimeType", "(Ljava/lang/String;JJLjava/lang/String;JLandroid/net/Uri;Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;Ljava/lang/String;)V", "getContentUrl", "()Landroid/net/Uri;", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getFileSize", "()J", "setFileSize", "(J)V", "getFileType", "()Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", "getMimeType", "getSharedUris", "", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileEntity extends AppEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;

    @NotNull
    private final Uri contentUrl;

    @NotNull
    private String fileName;
    private long fileSize;

    @NotNull
    private final FileTypeEnum fileType;

    @Nullable
    private final String mimeType;

    @Keep
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "create", "file", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/FileEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<FileEntity> {
        private CREATOR() {
        }

        public static /* synthetic */ FileEntity create$default(CREATOR r10, File r11, Uri r12, int r13, Object r14) {
            if ((r13 & 2) == 0) goto L6;
            r12 = Uri.fromFile(r11);
            q.f(r12, "fromFile(file)");
        L6:
            return r10.create(r11, r12);
        }

        @NotNull
        public final FileEntity create(@NotNull File r14, @NotNull Uri r15) {
            q.g(r14, "file");
            q.g(r15, "uri");
            String r12 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(g.c(r14));
            if (r14.isDirectory() == false) goto L6;
            FileTypeEnum r13 = FileTypeEnum.DIRECTORY;
        L5:
            FileTypeEnum r11 = r13;
            String r10 = String.valueOf(r14.lastModified());
            long r16 = r14.lastModified();
            long r17 = r14.lastModified();
            String r18 = r14.getName();
            q.f(r18, "file.name");
            return new FileEntity(r10, r16, r17, r18, r14.length(), r15, r11, r12);
        L6:
            r13 = FileTypeEnum.FILE;
            goto L5
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FileEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.FileEntity");
            return (FileEntity) r11;
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public FileEntity[] newArray(int r10) {
            return new FileEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public FileEntity(@NotNull Parcel r14) {
        q.g(r14, "parcel");
        String r10 = EntityExtKt.f(r14);
        long r11 = r14.readLong();
        long r12 = r14.readLong();
        String r13 = EntityExtKt.f(r14);
        long r15 = r14.readLong();
        Parcelable r16 = r14.readParcelable(Uri.class.getClassLoader());
        q.d(r16);
        Uri r17 = (Uri) r16;
        FileTypeEnum r18 = FileTypeEnum.Companion.a(r14.readString());
        if (r18 != null) goto L5;
        r18 = FileTypeEnum.FILE;
    L5:
        this(r10, r11, r12, r13, r15, r17, r18, r14.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    @NotNull
    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    @NotNull
    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    public final FileTypeEnum getFileType() {
        return this.fileType;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    @NotNull
    public List<Uri> getSharedUris() {
        return s.e(this.contentUrl);
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
    }

    public final void setFileName(@NotNull String r10) {
        q.g(r10, "<set-?>");
        this.fileName = r10;
    }

    public final void setFileSize(long r10) {
        this.fileSize = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.fileName);
        r10.writeLong(this.fileSize);
        r10.writeParcelable(this.contentUrl, r11);
        r10.writeString(this.fileType.name());
        r10.writeString(this.mimeType);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(0);
    }

    public FileEntity(@NotNull String r12, long r13, long r15, @NotNull String r17, long r18, @NotNull Uri r20, @NotNull FileTypeEnum r21, @Nullable String r22) {
        q.g(r12, "id");
        q.g(r17, "fileName");
        q.g(r20, "contentUrl");
        q.g(r21, "fileType");
        super(r12, r13, r15, EntityType.FILE);
        this.fileName = r17;
        this.fileSize = r18;
        this.contentUrl = r20;
        this.fileType = r21;
        this.mimeType = r22;
    }
}
