package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
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
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 [2\u00020\u00012\u00020\u0002:\u0001[B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B]\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0010\u0013\u001a\u00020\u0007\u0012\u0006\u0010\u0014\u001a\u00020\t\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016¢\u0006\u0002\u0010\u0017J\b\u0010O\u001a\u00020PH\u0016J\u000e\u0010Q\u001a\b\u0012\u0004\u0012\u00020R0\u0011H\u0016J\"\u0010S\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010U\u001a\u0004\u0018\u00010V2\u0006\u0010W\u001a\u00020XH\u0016J\u0018\u0010Y\u001a\u00020T2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010Z\u001a\u00020XH\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010$\"\u0004\b0\u0010&R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u00101\"\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b:\u0010\u001eR\u001c\u0010;\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u001e\"\u0004\b=\u0010 R\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\u001eR\"\u0010?\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010$\"\u0004\bB\u0010&R\u001c\u0010C\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u001e\"\u0004\bE\u0010 R\u001c\u0010F\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u001e\"\u0004\bH\u0010 R\"\u0010I\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010$\"\u0004\bK\u0010&R\"\u0010L\u001a\n\u0012\u0004\u0012\u00020@\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010$\"\u0004\bN\u0010&¨\u0006\\"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "file", "Lcom/obric/capabilitykit/entity/app/FileEntity;", "assetType", "Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "inAlbum", "", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "resolution", "fileSize", "isFavorite", "", "(Ljava/lang/String;JJLjava/lang/String;Lcom/obric/capabilitykit/entity/app/FileEntity;Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;Ljava/util/List;Ljava/lang/String;JZ)V", "getAssetType", "()Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;", "setAssetType", "(Lcom/obric/capabilitykit/entity/enums/AssetTypeEnum;)V", "caption", "getCaption", "()Ljava/lang/String;", "setCaption", "(Ljava/lang/String;)V", "faces", "Lcom/obric/capabilitykit/entity/app/PhotoFaceEntity;", "getFaces", "()Ljava/util/List;", "setFaces", "(Ljava/util/List;)V", "getFile", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setFile", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", "getFileSize", "()J", "setFileSize", "(J)V", "getInAlbum", "setInAlbum", "()Z", "setFavorite", "(Z)V", "location", "Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "getLocation", "()Lcom/obric/capabilitykit/entity/meta/MetaLocation;", "setLocation", "(Lcom/obric/capabilitykit/entity/meta/MetaLocation;)V", "getName", "ocr", "getOcr", "setOcr", "getResolution", "searchFrames", "Lcom/obric/capabilitykit/entity/app/VideoFrame;", "getSearchFrames", "setSearchFrames", "sourceAppName", "getSourceAppName", "setSourceAppName", "sourcePackageName", "getSourcePackageName", "setSourcePackageName", TracingConstants.KEY_TAGS, "getTags", "setTags", "videoFrames", "getVideoFrames", "setVideoFrames", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "getSharedUris", "Landroid/net/Uri;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PhotoEntity extends AppEntity implements IUriSharerEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 2;
    private static final int RELATED_VERSION = 2;

    @NotNull
    private AssetTypeEnum assetType;

    @Nullable
    private String caption;

    @Nullable
    private List<PhotoFaceEntity> faces;

    @NotNull
    private FileEntity file;
    private long fileSize;

    @NotNull
    private List<AlbumEntity> inAlbum;
    private boolean isFavorite;

    @Nullable
    private MetaLocation location;

    @NotNull
    private final String name;

    @Nullable
    private String ocr;

    @NotNull
    private final String resolution;

    @Nullable
    private List<VideoFrame> searchFrames;

    @Nullable
    private String sourceAppName;

    @Nullable
    private String sourcePackageName;

    @Nullable
    private List<String> tags;

    @Nullable
    private List<VideoFrame> videoFrames;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/PhotoEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<PhotoEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PhotoEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.PhotoEntity");
            return (PhotoEntity) r11;
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public PhotoEntity[] newArray(int r10) {
            return new PhotoEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public PhotoEntity(@NotNull Parcel r18) {
        q.g(r18, "parcel");
        String r10 = EntityExtKt.f(r18);
        long r11 = r18.readLong();
        long r12 = r18.readLong();
        String r13 = EntityExtKt.f(r18);
        Parcelable r14 = r18.readParcelable(FileEntity.class.getClassLoader());
        q.d(r14);
        FileEntity r15 = (FileEntity) r14;
        AssetTypeEnum r16 = AssetTypeEnum.Companion.a(r18.readString());
        if (r16 != null) goto L5;
        r16 = AssetTypeEnum.PHOTO;
    L5:
        AssetTypeEnum r17 = r16;
        ArrayList r19 = r18.createTypedArrayList(AlbumEntity.CREATOR);
        q.d(r19);
        this(r10, r11, r12, r13, r15, r17, r19, EntityExtKt.f(r18), r18.readLong(), EntityExtKt.e(r18));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r18);
        int r20 = r18.readInt();
        this.tags = r18.createStringArrayList();
        this.faces = r18.createTypedArrayList(PhotoFaceEntity.CREATOR);
        this.location = (MetaLocation) r18.readParcelable(FileEntity.class.getClassLoader());
        this.caption = r18.readString();
        this.ocr = r18.readString();
        this.sourcePackageName = r18.readString();
        this.sourceAppName = r18.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r18, 2, r20);
    }

    @NotNull
    public final AssetTypeEnum getAssetType() {
        return this.assetType;
    }

    @Nullable
    public final String getCaption() {
        return this.caption;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    @NotNull
    public DisplayRepresentation getDisplayRepresentation() {
        return new DisplayRepresentation(this.file.getContentUrl(), this.name, null, getLastModifiedTime(), 4, null);
    }

    @Nullable
    public final List<PhotoFaceEntity> getFaces() {
        return this.faces;
    }

    @NotNull
    public final FileEntity getFile() {
        return this.file;
    }

    public final long getFileSize() {
        return this.fileSize;
    }

    @NotNull
    public final List<AlbumEntity> getInAlbum() {
        return this.inAlbum;
    }

    @Nullable
    public final MetaLocation getLocation() {
        return this.location;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getOcr() {
        return this.ocr;
    }

    @NotNull
    public final String getResolution() {
        return this.resolution;
    }

    @Nullable
    public final List<VideoFrame> getSearchFrames() {
        return this.searchFrames;
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
    public final String getSourcePackageName() {
        return this.sourcePackageName;
    }

    @Nullable
    public final List<String> getTags() {
        return this.tags;
    }

    @Nullable
    public final List<VideoFrame> getVideoFrames() {
        return this.videoFrames;
    }

    public final boolean isFavorite() {
        return this.isFavorite;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        List<VideoFrame> r13 = null;
        if (r12 != 1) goto L5;
        Object r14 = ParcelUtils.INSTANCE.readValueSafely(r10, r11);
        if ((r14 instanceof List) == false) goto L14;
        r13 = (List) r14;
    L14:
        this.videoFrames = r13;
        return;
    L5:
        if (r12 != 2) goto L17;
        Object r15 = ParcelUtils.INSTANCE.readValueSafely(r10, r11);
        if ((r15 instanceof List) == false) goto L10;
        r13 = (List) r15;
    L10:
        this.searchFrames = r13;
        return;
    }

    public final void setAssetType(@NotNull AssetTypeEnum r10) {
        q.g(r10, "<set-?>");
        this.assetType = r10;
    }

    public final void setCaption(@Nullable String r10) {
        this.caption = r10;
    }

    public final void setFaces(@Nullable List<PhotoFaceEntity> r10) {
        this.faces = r10;
    }

    public final void setFavorite(boolean r10) {
        this.isFavorite = r10;
    }

    public final void setFile(@NotNull FileEntity r10) {
        q.g(r10, "<set-?>");
        this.file = r10;
    }

    public final void setFileSize(long r10) {
        this.fileSize = r10;
    }

    public final void setInAlbum(@NotNull List<AlbumEntity> r10) {
        q.g(r10, "<set-?>");
        this.inAlbum = r10;
    }

    public final void setLocation(@Nullable MetaLocation r10) {
        this.location = r10;
    }

    public final void setOcr(@Nullable String r10) {
        this.ocr = r10;
    }

    public final void setSearchFrames(@Nullable List<VideoFrame> r10) {
        this.searchFrames = r10;
    }

    public final void setSourceAppName(@Nullable String r10) {
        this.sourceAppName = r10;
    }

    public final void setSourcePackageName(@Nullable String r10) {
        this.sourcePackageName = r10;
    }

    public final void setTags(@Nullable List<String> r10) {
        this.tags = r10;
    }

    public final void setVideoFrames(@Nullable List<VideoFrame> r10) {
        this.videoFrames = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeString(this.name);
        r10.writeParcelable(this.file, r11);
        r10.writeString(this.assetType.name());
        r10.writeTypedList(this.inAlbum);
        r10.writeString(this.resolution);
        r10.writeLong(this.fileSize);
        EntityExtKt.g(r10, this.isFavorite);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(2);
        r10.writeStringList(this.tags);
        r10.writeTypedList(this.faces);
        r10.writeParcelable(this.location, r11);
        r10.writeString(this.caption);
        r10.writeString(this.ocr);
        r10.writeString(this.sourcePackageName);
        r10.writeString(this.sourceAppName);
        r10.writeValue(this.videoFrames);
        r10.writeValue(this.searchFrames);
    }

    public PhotoEntity(@NotNull String r14, long r15, long r17, @NotNull String r19, @NotNull FileEntity r20, @NotNull AssetTypeEnum r21, @NotNull List<AlbumEntity> r22, @NotNull String r23, long r24, boolean r26) {
        q.g(r14, "id");
        q.g(r19, "name");
        q.g(r20, "file");
        q.g(r21, "assetType");
        q.g(r22, "inAlbum");
        q.g(r23, "resolution");
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
}
