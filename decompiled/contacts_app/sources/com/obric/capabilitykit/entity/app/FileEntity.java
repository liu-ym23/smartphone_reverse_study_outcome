package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.obric.contactsdk.loader.ContractKt;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005BG\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\t\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0012J\u000e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000e0!H\u0016J\"\u0010\"\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010$\u001a\u0004\u0018\u00010%2\u0006\u0010&\u001a\u00020'H\u0016J\u0018\u0010(\u001a\u00020#2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010)\u001a\u00020'H\u0016R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u000b\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\f\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016¨\u0006+"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "fileName", "fileSize", "contentUrl", "Landroid/net/Uri;", "fileType", "Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", "mimeType", "(Ljava/lang/String;JJLjava/lang/String;JLandroid/net/Uri;Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;Ljava/lang/String;)V", "getContentUrl", "()Landroid/net/Uri;", "getFileName", "()Ljava/lang/String;", "setFileName", "(Ljava/lang/String;)V", "getFileSize", "()J", "setFileSize", "(J)V", "getFileType", "()Lcom/obric/capabilitykit/entity/enums/FileTypeEnum;", "getMimeType", "getSharedUris", "", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FileEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private final Uri contentUrl;
    private String fileName;
    private long fileSize;
    private final FileTypeEnum fileType;
    private final String mimeType;

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0006\u0010\u000f\u001a\u00020\u0005J\u001d\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/capabilitykit/entity/app/FileEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", ContractKt.OBRIC_ACTION_CREATE, "file", "Ljava/io/File;", "uri", "Landroid/net/Uri;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/FileEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<FileEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        public static /* synthetic */ FileEntity create$default(CREATOR r0, File r1, Uri r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = Uri.fromFile(r1);
            Intrinsics.checkNotNullExpressionValue(r2, "fromFile(file)");
        L6:
            return r0.create(r1, r2);
        }

        public final FileEntity create(File r14, Uri r15) {
            Intrinsics.checkNotNullParameter(r14, "file");
            Intrinsics.checkNotNullParameter(r15, "uri");
            String r12 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(FilesKt.getExtension(r14));
            if (r14.isDirectory() == false) goto L5;
            FileTypeEnum r13 = FileTypeEnum.DIRECTORY;
        L6:
            String r2 = String.valueOf(r14.lastModified());
            long r3 = r14.lastModified();
            long r5 = r14.lastModified();
            String r7 = r14.getName();
            Intrinsics.checkNotNullExpressionValue(r7, "file.name");
            long r8 = r14.length();
            return new FileEntity(r2, r3, r5, r7, r8, r15, r13, r12);
        L5:
            r13 = FileTypeEnum.FILE;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.FileEntity");
            return (FileEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 0;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileEntity[] newArray(int r1) {
            return new FileEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ FileEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public FileEntity(Parcel r14) {
        Intrinsics.checkNotNullParameter(r14, "parcel");
        String r2 = EntityExtKt.readStringOrEmpty(r14);
        long r3 = r14.readLong();
        long r5 = r14.readLong();
        String r7 = EntityExtKt.readStringOrEmpty(r14);
        long r8 = r14.readLong();
        Parcelable r0 = r14.readParcelable(Uri.class.getClassLoader());
        Intrinsics.checkNotNull(r0);
        Uri r10 = (Uri) r0;
        FileTypeEnum r1 = FileTypeEnum.Companion.from(r14.readString());
        if (r1 != null) goto L5;
        r1 = FileTypeEnum.FILE;
    L5:
        this(r2, r3, r5, r7, r8, r10, r1, r14.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    public FileEntity(String r12, long r13, long r15, String r17, long r18, Uri r20, FileTypeEnum r21, String r22) {
        Intrinsics.checkNotNullParameter(r12, "id");
        Intrinsics.checkNotNullParameter(r17, "fileName");
        Intrinsics.checkNotNullParameter(r20, "contentUrl");
        Intrinsics.checkNotNullParameter(r21, "fileType");
        super(r12, r13, r15, EntityType.FILE);
        this.fileName = r17;
        this.fileSize = r18;
        this.contentUrl = r20;
        this.fileType = r21;
        this.mimeType = r22;
    }

    public final Uri getContentUrl() {
        return this.contentUrl;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final FileTypeEnum getFileType() {
        return this.fileType;
    }

    public final String getMimeType() {
        return this.mimeType;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return CollectionsKt.listOf(this.contentUrl);
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
    }

    public final void setFileName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.fileName = r2;
    }

    public final void setFileSize(long r1) {
        this.fileSize = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeString(this.fileName);
        r3.writeLong(this.fileSize);
        r3.writeParcelable(this.contentUrl, r4);
        r3.writeString(this.fileType.name());
        r3.writeString(this.mimeType);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeInt(0);
    }
}
