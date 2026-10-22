package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.ContactSaveService;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.tracing.internal.TracingConstants;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.AssetTypeEnum;
import com.obric.capabilitykit.entity.meta.MetaLocation;
import com.obric.capabilitykit.entity.utils.ParcelUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B]\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010O\u001a\u00020PH\u0016J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u0011H\u0016J\"\u0010S\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016J\u0018\u0010Y\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020XH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u001c\u0010;\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001eR\"\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001c\u0010C\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010 R\u001c\u0010F\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R\"\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R\"\u0010L\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&¨\u0006\\"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "assetType", "Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "inAlbum", "", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "resolution", "fileSize", "isFavorite", "", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;Ljava/util/List;Ljava/lang/String;JZ)V", "getAssetType", "()Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "setAssetType", "(Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;)V", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "faces", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "getFaces", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "getFileSize", "()J", "setFileSize", "(J)V", "getInAlbum", "setInAlbum", "()Z", "setFavorite", "(Z)V", BatteryTypeInf.BATTERY_LOC_API, "Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "getLocation", "()Lcom/obric/capabilitykit/entity/meta/MetaLocation;", ContactSaveService.ACTION_SET_LOCATION, "(Lcom/obric/capabilitykit/entity/meta/MetaLocation;)V", "getName", "ocr", "getOcr", "setOcr", "getResolution", "searchFrames", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "getSearchFrames", "setSearchFrames", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", TracingConstants.KEY_TAGS, "getTags", "setTags", "videoFrames", "getVideoFrames", "setVideoFrames", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoEntity extends AppEntity implements IUriSharerEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 2;
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
    private String sourcePackageName;
    private List<String> tags;
    private List<VideoFrame> videoFrames;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<PhotoEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoEntity");
            return (PhotoEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 4;
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

    public PhotoEntity(Parcel r17) {
        Intrinsics.checkNotNullParameter(r17, "parcel");
        String r1 = EntityExtKt.readStringOrEmpty(r17);
        long r2 = r17.readLong();
        long r4 = r17.readLong();
        String r6 = EntityExtKt.readStringOrEmpty(r17);
        Parcelable r0 = r17.readParcelable(FileEntity.class.getClassLoader());
        Intrinsics.checkNotNull(r0);
        FileEntity r7 = (FileEntity) r0;
        AssetTypeEnum r3 = AssetTypeEnum.Companion.from(r17.readString());
        if (r3 != null) goto L5;
        r3 = AssetTypeEnum.PHOTO;
    L5:
        AssetTypeEnum r8 = r3;
        ArrayList r9 = r17.createTypedArrayList(AlbumEntity.CREATOR);
        Intrinsics.checkNotNull(r9);
        this(r1, r2, r4, r6, r7, r8, r9, EntityExtKt.readStringOrEmpty(r17), r17.readLong(), EntityExtKt.readBool(r17));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r17);
        int r5 = r17.readInt();
        this.tags = r17.createStringArrayList();
        this.faces = r17.createTypedArrayList(PhotoFaceEntity.CREATOR);
        this.location = (MetaLocation) r17.readParcelable(FileEntity.class.getClassLoader());
        this.caption = r17.readString();
        this.ocr = r17.readString();
        this.sourcePackageName = r17.readString();
        this.sourceAppName = r17.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r17, 2, r5);
    }

    public PhotoEntity(String r14, long r15, long r17, String r19, FileEntity r20, AssetTypeEnum r21, List<AlbumEntity> r22, String r23, long r24, boolean r26) {
        Intrinsics.checkNotNullParameter(r14, "id");
        Intrinsics.checkNotNullParameter(r19, "name");
        Intrinsics.checkNotNullParameter(r20, "file");
        Intrinsics.checkNotNullParameter(r21, "assetType");
        Intrinsics.checkNotNullParameter(r22, "inAlbum");
        Intrinsics.checkNotNullParameter(r23, "resolution");
        super(r14, r15, r17, 301);
        this.name = r19;
        this.file = r20;
        this.assetType = r21;
        this.inAlbum = r22;
        this.resolution = r23;
        this.fileSize = r24;
        this.isFavorite = r26;
    }

    public /* synthetic */ PhotoEntity(String r16, long r17, long r19, String r21, FileEntity r22, AssetTypeEnum r23, List r24, String r25, long r26, boolean r28, int r29, DefaultConstructorMarker r30) {
        if ((r29 & 512) == 0) goto L5;
        boolean r14 = false;
    L6:
        this(r16, r17, r19, r21, r22, r23, r24, r25, r26, r14);
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
    public void onReadSubClassExtensionField(Parcel r3, ClassLoader r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        List<VideoFrame> r1 = null;
        if (r5 != 1) goto L5;
        Object r6 = ParcelUtils.INSTANCE.readValueSafely(r3, r4);
        if ((r6 instanceof List) == false) goto L14;
        r1 = (List) r6;
    L14:
        this.videoFrames = r1;
        return;
    L5:
        if (r5 != 2) goto L17;
        Object r7 = ParcelUtils.INSTANCE.readValueSafely(r3, r4);
        if ((r7 instanceof List) == false) goto L10;
        r1 = (List) r7;
    L10:
        this.searchFrames = r1;
        return;
    }

    public final void setAssetType(AssetTypeEnum r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.assetType = r2;
    }

    public final void setCaption(String r1) {
        this.caption = r1;
    }

    public final void setFaces(List<PhotoFaceEntity> r1) {
        this.faces = r1;
    }

    public final void setFavorite(boolean r1) {
        this.isFavorite = r1;
    }

    public final void setFile(FileEntity r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.file = r2;
    }

    public final void setFileSize(long r1) {
        this.fileSize = r1;
    }

    public final void setInAlbum(List<AlbumEntity> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.inAlbum = r2;
    }

    public final void setLocation(MetaLocation r1) {
        this.location = r1;
    }

    public final void setOcr(String r1) {
        this.ocr = r1;
    }

    public final void setSearchFrames(List<VideoFrame> r1) {
        this.searchFrames = r1;
    }

    public final void setSourceAppName(String r1) {
        this.sourceAppName = r1;
    }

    public final void setSourcePackageName(String r1) {
        this.sourcePackageName = r1;
    }

    public final void setTags(List<String> r1) {
        this.tags = r1;
    }

    public final void setVideoFrames(List<VideoFrame> r1) {
        this.videoFrames = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeString(this.name);
        r3.writeParcelable(this.file, r4);
        r3.writeString(this.assetType.name());
        r3.writeTypedList(this.inAlbum);
        r3.writeString(this.resolution);
        r3.writeLong(this.fileSize);
        EntityExtKt.writeBool(r3, this.isFavorite);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r3);
        r3.writeInt(2);
        r3.writeStringList(this.tags);
        r3.writeTypedList(this.faces);
        r3.writeParcelable(this.location, r4);
        r3.writeString(this.caption);
        r3.writeString(this.ocr);
        r3.writeString(this.sourcePackageName);
        r3.writeString(this.sourceAppName);
        r3.writeValue(this.videoFrames);
        r3.writeValue(this.searchFrames);
    }
}
