package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.bytedance.crash.general.HardwareInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class PhotoEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 2;
    private AssetTypeEnum assetType;
    private String caption;
    private List<PhotoFaceEntity> faces;
    private FileEntity file;
    private long fileSize;
    private List<AlbumEntity> inAlbum;
    private boolean isFavorite;
    private MetaLocation location;
    private final String name;
    private String ocr;
    private final String resolution;
    private List<VideoFrame> searchFrames;
    private String sourceAppName;
    private String sourceDevice;
    private String sourcePackageName;
    private List<String> tags;
    private List<VideoFrame> videoFrames;

    public static final class CREATOR implements Parcelable.Creator<PhotoEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        public static final /* synthetic */ List access$requireAlbumList(CREATOR r0, ArrayList r1) {
            return r0.requireAlbumList(r1);
        }

        public static final /* synthetic */ FileEntity access$requireFileEntity(CREATOR r0, FileEntity r1) {
            return r0.requireFileEntity(r1);
        }

        private final List<AlbumEntity> requireAlbumList(ArrayList<AlbumEntity> r1) {
            if (r1 == null) goto L5;
            return r1;
        L5:
            throw new IllegalArgumentException("PhotoEntity.inAlbum must not be null".toString());
        }

        private final FileEntity requireFileEntity(FileEntity r1) {
            if (r1 == null) goto L5;
            return r1;
        L5:
            throw new IllegalArgumentException("PhotoEntity.file must not be null".toString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoEntity");
            return (PhotoEntity) ZeusTransformUtils.preCheckCast(r1, PhotoEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoEntity[] newArray(int r1) {
            return new PhotoEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public PhotoEntity(Parcel r19) {
        o.e(r19, "parcel");
        String r1 = EntityExtKt.a(r19);
        long r2 = r19.readLong();
        long r4 = r19.readLong();
        String r6 = EntityExtKt.a(r19);
        CREATOR r0 = CREATOR;
        FileEntity r7 = CREATOR.access$requireFileEntity(r0, (FileEntity) ZeusTransformUtils.preCheckCast(r19.readParcelable(FileEntity.class.getClassLoader()), FileEntity.class, "com.obric.aiagent.plugin"));
        AssetTypeEnum r8 = AssetTypeEnum.Companion.a(r19.readString());
        if (r8 != null) goto L5;
        r8 = AssetTypeEnum.PHOTO;
    L5:
        this(r1, r2, r4, r6, r7, r8, CREATOR.access$requireAlbumList(r0, r19.createTypedArrayList(AlbumEntity.CREATOR)), EntityExtKt.a(r19), r19.readLong(), EntityExtKt.b(r19));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r19);
        int r3 = r19.readInt();
        this.tags = r19.createStringArrayList();
        this.faces = r19.createTypedArrayList(PhotoFaceEntity.CREATOR);
        this.location = (MetaLocation) ZeusTransformUtils.preCheckCast(r19.readParcelable(FileEntity.class.getClassLoader()), MetaLocation.class, "com.obric.aiagent.plugin");
        this.caption = r19.readString();
        this.ocr = r19.readString();
        this.sourcePackageName = r19.readString();
        this.sourceAppName = r19.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r19, 3, r3);
    }

    public PhotoEntity(String r14, long r15, long r17, String r19, FileEntity r20, AssetTypeEnum r21, List<AlbumEntity> r22, String r23, long r24, boolean r26) {
        List<AlbumEntity> r12 = (List) ZeusTransformUtils.wrapperContextForParams(r22, List.class, "com.obric.aiagent.plugin");
        o.e(r14, DbHelper.COL_ID);
        o.e(r19, "name");
        o.e(r20, "file");
        o.e(r21, "assetType");
        o.e(r12, "inAlbum");
        o.e(r23, HardwareInfo.KEY_HW_DISPLAY_RESOLUTION);
        super(r14, r15, r17, 301);
        this.name = r19;
        this.file = r20;
        this.assetType = r21;
        this.inAlbum = r12;
        this.resolution = r23;
        this.fileSize = r24;
        this.isFavorite = r26;
    }

    public /* synthetic */ PhotoEntity(String r16, long r17, long r19, String r21, FileEntity r22, AssetTypeEnum r23, List r24, String r25, long r26, boolean r28, int r29, h r30) {
        List r10 = (List) ZeusTransformUtils.wrapperContextForParams(r24, List.class, "com.obric.aiagent.plugin");
        if ((r29 & 512) == 0) goto L5;
        boolean r14 = false;
    L6:
        this(r16, r17, r19, r21, r22, r23, r10, r25, r26, r14);
        return;
    L5:
        r14 = r28;
        goto L6
    }

    public final AssetTypeEnum getAssetType() {
        return this.assetType;
    }

    public final String getCaption() {
        return this.caption;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(this.file.getContentUrl(), this.name, null, getLastModifiedTime(), 4, null);
    }

    public final List<PhotoFaceEntity> getFaces() {
        return this.faces;
    }

    public final FileEntity getFile() {
        return this.file;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    public final List<AlbumEntity> getInAlbum() {
        return this.inAlbum;
    }

    public final MetaLocation getLocation() {
        return this.location;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOcr() {
        return this.ocr;
    }

    public final String getResolution() {
        return this.resolution;
    }

    public final List<VideoFrame> getSearchFrames() {
        return this.searchFrames;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity
    public List<Uri> getSharedUris() {
        return this.file.getSharedUris();
    }

    public final String getSourceAppName() {
        return this.sourceAppName;
    }

    public final String getSourceDevice() {
        return this.sourceDevice;
    }

    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    public final List<String> getTags() {
        return this.tags;
    }

    public final List<VideoFrame> getVideoFrames() {
        return this.videoFrames;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r4, ClassLoader r5, int r6) {
        o.e(r4, "parcel");
        List<VideoFrame> r1 = null;
        String r2 = null;
        List<VideoFrame> r3 = null;
        if (r6 != 1) goto L5;
        Object r7 = ParcelUtils.INSTANCE.readValueSafely(r4, r5);
        if (ZeusTransformUtils.instanceOf(r7, List.class) == false) goto L20;
        r1 = (List) ZeusTransformUtils.preCheckCast(r7, List.class, "com.obric.aiagent.plugin");
    L20:
        this.videoFrames = r1;
        return;
    L5:
        if (r6 != 2) goto L7;
        Object r8 = ParcelUtils.INSTANCE.readValueSafely(r4, r5);
        if (ZeusTransformUtils.instanceOf(r8, List.class) == false) goto L16;
        r3 = (List) ZeusTransformUtils.preCheckCast(r8, List.class, "com.obric.aiagent.plugin");
    L16:
        this.searchFrames = r3;
        return;
    L7:
        if (r6 != 3) goto L24;
        Object r9 = ParcelUtils.INSTANCE.readValueSafely(r4, r5);
        if (ZeusTransformUtils.instanceOf(r9, String.class) == false) goto L12;
        r2 = (String) ZeusTransformUtils.preCheckCast(r9, String.class, "com.obric.aiagent.plugin");
    L12:
        this.sourceDevice = r2;
        return;
    }

    public final void setAssetType(AssetTypeEnum r2) {
        o.e(r2, "<set-?>");
        this.assetType = r2;
    }

    public final void setCaption(String r1) {
        this.caption = r1;
    }

    public final void setFaces(List<PhotoFaceEntity> r3) {
        this.faces = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setFavorite(boolean r1) {
        this.isFavorite = r1;
    }

    public final void setFile(FileEntity r2) {
        o.e(r2, "<set-?>");
        this.file = r2;
    }

    public final void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public final void setInAlbum(List<AlbumEntity> r3) {
        List<AlbumEntity> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.inAlbum = r4;
    }

    public final void setLocation(MetaLocation r1) {
        this.location = r1;
    }

    public final void setOcr(String r1) {
        this.ocr = r1;
    }

    public final void setSearchFrames(List<VideoFrame> r3) {
        this.searchFrames = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourceDevice(String r1) {
        this.sourceDevice = r1;
    }

    public final void setSourcePackageName(String r1) {
        this.sourcePackageName = r1;
    }

    public final void setTags(List<String> r3) {
        this.tags = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setVideoFrames(List<VideoFrame> r3) {
        this.videoFrames = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        o.e(r3, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeString(this.name);
        r3.writeParcelable(this.file, r4);
        r3.writeString(this.assetType.name());
        r3.writeTypedList(this.inAlbum);
        r3.writeString(this.resolution);
        r3.writeLong(this.fileSize);
        EntityExtKt.a(r3, this.isFavorite);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeInt(3);
        r3.writeStringList(this.tags);
        r3.writeTypedList(this.faces);
        r3.writeParcelable(this.location, r4);
        r3.writeString(this.caption);
        r3.writeString(this.ocr);
        r3.writeString(this.sourcePackageName);
        r3.writeString(this.sourceAppName);
        r3.writeValue(this.videoFrames);
        r3.writeValue(this.searchFrames);
        r3.writeValue(this.sourceDevice);
    }
}
