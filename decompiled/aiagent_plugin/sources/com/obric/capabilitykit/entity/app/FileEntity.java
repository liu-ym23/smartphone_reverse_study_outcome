package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.FileTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.f.k;
import d.h.b.h;
import d.h.b.o;
import java.io.File;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class FileEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 0;
    private static final int RELATED_VERSION = 0;
    private final Uri contentUrl;
    private String fileName;
    private long fileSize;
    private final FileTypeEnum fileType;
    private final String mimeType;

    public static final class CREATOR implements Parcelable.Creator<FileEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        public static /* synthetic */ FileEntity create$default(CREATOR r0, File r1, Uri r2, int r3, Object r4) {
            if ((r3 & 2) == 0) goto L6;
            r2 = Uri.fromFile(r1);
            o.c(r2, "fromFile(file)");
        L6:
            return r0.create(r1, r2);
        }

        public final FileEntity create(File r14, Uri r15) {
            o.e(r14, "file");
            o.e(r15, "uri");
            String r12 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(k.f(r14));
            if (r14.isDirectory() == false) goto L5;
            FileTypeEnum r13 = FileTypeEnum.DIRECTORY;
        L6:
            String r2 = String.valueOf(r14.lastModified());
            long r3 = r14.lastModified();
            long r5 = r14.lastModified();
            String r7 = r14.getName();
            o.c(r7, "file.name");
            long r8 = r14.length();
            return new FileEntity(r2, r3, r5, r7, r8, r15, r13, r12);
        L5:
            r13 = FileTypeEnum.FILE;
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FileEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.FileEntity");
            return (FileEntity) ZeusTransformUtils.preCheckCast(r1, FileEntity.class, "com.obric.aiagent.plugin");
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
        o.e(r14, "parcel");
        String r2 = EntityExtKt.a(r14);
        long r3 = r14.readLong();
        long r5 = r14.readLong();
        String r7 = EntityExtKt.a(r14);
        long r8 = r14.readLong();
        Parcelable r0 = r14.readParcelable(Uri.class.getClassLoader());
        o.a(r0);
        Uri r10 = (Uri) ZeusTransformUtils.preCheckCast(r0, Uri.class, "com.obric.aiagent.plugin");
        FileTypeEnum r1 = FileTypeEnum.Companion.a(r14.readString());
        if (r1 != null) goto L5;
        r1 = FileTypeEnum.FILE;
    L5:
        this(r2, r3, r5, r7, r8, r10, r1, r14.readString());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r14);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r14, 0, r14.readInt());
    }

    public FileEntity(String r12, long r13, long r15, String r17, long r18, Uri r20, FileTypeEnum r21, String r22) {
        o.e(r12, DbHelper.COL_ID);
        o.e(r17, "fileName");
        o.e(r20, "contentUrl");
        o.e(r21, "fileType");
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
        return p.a(this.contentUrl);
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r1, ClassLoader r2, int r3) {
        o.e(r1, "parcel");
    }

    public final void setFileName(String r2) {
        o.e(r2, "<set-?>");
        this.fileName = r2;
    }

    public final void setFileSize(long r1) {
        this.fileSize = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
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
