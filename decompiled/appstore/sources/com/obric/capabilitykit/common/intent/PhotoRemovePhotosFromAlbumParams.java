package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B#\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0002\u0010\tJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u000fJ,\u0010\u0015\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0016J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\u0010\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u001eH\u0016J\t\u0010\u001f\u001a\u00020\u0018HÖ\u0001J\b\u0010 \u001a\u00020\u001aH\u0016J\u0012\u0010!\u001a\u00020\u00012\b\u0010\"\u001a\u0004\u0018\u00010\u001cH\u0016J\t\u0010#\u001a\u00020$HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u0018HÖ\u0001R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "album", "Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getAlbum", "()Lcom/obric/capabilitykit/entity/app/AlbumEntity;", "setAlbum", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;)V", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "setPhotos", "([Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "component1", "component2", "copy", "(Lcom/obric/capabilitykit/entity/app/AlbumEntity;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)Lcom/obric/capabilitykit/common/intent/PhotoRemovePhotosFromAlbumParams;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "isParamsCompleted", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class PhotoRemovePhotosFromAlbumParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> CREATOR = null;

    @Nullable
    private AlbumEntity album;

    @Nullable
    private PhotoEntity[] photos;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<PhotoRemovePhotosFromAlbumParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoRemovePhotosFromAlbumParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            AlbumEntity r12 = (AlbumEntity) r10.readParcelable(PhotoRemovePhotosFromAlbumParams.class.getClassLoader());
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r13 = null;
        L9:
            PhotoRemovePhotosFromAlbumParams r14 = new PhotoRemovePhotosFromAlbumParams(r12, r13);
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L10:
            if (r17 > r15) goto L12;
            r17 = r17 + 1;
        L12:
            if (r17 > r11) goto L14;
            a.d(r10, r16);
            r17 = r17 + 1;
            goto L12
        L14:
            return r14;
        L5:
            int r18 = r10.readInt();
            PhotoEntity[] r19 = new PhotoEntity[r18];
            int r20 = 0;
        L6:
            if (r20 == r18) goto L8;
            r19[r20] = (PhotoEntity) r10.readParcelable(PhotoRemovePhotosFromAlbumParams.class.getClassLoader());
            r20 = r20 + 1;
            goto L6
        L8:
            r13 = r19;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final PhotoRemovePhotosFromAlbumParams[] newArray(int r10) {
            return new PhotoRemovePhotosFromAlbumParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoRemovePhotosFromAlbumParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoRemovePhotosFromAlbumParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoRemovePhotosFromAlbumParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoRemovePhotosFromAlbumParams copy$default(PhotoRemovePhotosFromAlbumParams r10, AlbumEntity r11, PhotoEntity[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.album;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.photos;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final AlbumEntity component1() {
        return this.album;
    }

    @Nullable
    public final PhotoEntity[] component2() {
        return this.photos;
    }

    @NotNull
    public final PhotoRemovePhotosFromAlbumParams copy(@Nullable AlbumEntity r10, @Nullable PhotoEntity[] r11) {
        return new PhotoRemovePhotosFromAlbumParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L8;
        return false;
    L8:
        PhotoRemovePhotosFromAlbumParams r11 = (PhotoRemovePhotosFromAlbumParams) r10;
        if (q.b(this.album, r11.album) == true) goto L12;
        return false;
    L12:
        if (q.b(this.photos, r11.photos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final AlbumEntity getAlbum() {
        return this.album;
    }

    @Nullable
    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return t.l(new Object[]{this.album, this.photos});
    }

    public int hashCode() {
        AlbumEntity r10 = this.album;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        PhotoEntity[] r14 = this.photos;
        if (r14 == null) goto L11;
        r11 = Arrays.hashCode(r14);
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.album == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof PhotoRemovePhotosFromAlbumParams) == true) goto L5;
        return this;
    L5:
        AlbumEntity r11 = this.album;
        if (r11 != null) goto L8;
        r11 = ((PhotoRemovePhotosFromAlbumParams) r10).album;
    L8:
        PhotoEntity[] r12 = this.photos;
        if (r12 != null) goto L12;
        r12 = ((PhotoRemovePhotosFromAlbumParams) r10).photos;
    L12:
        return new PhotoRemovePhotosFromAlbumParams(r11, r12);
    }

    public final void setAlbum(@Nullable AlbumEntity r10) {
        this.album = r10;
    }

    public final void setPhotos(@Nullable PhotoEntity[] r10) {
        this.photos = r10;
    }

    @NotNull
    public String toString() {
        return "PhotoRemovePhotosFromAlbumParams(album=" + this.album + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeParcelable(this.album, r11);
        PhotoEntity[] r13 = this.photos;
        if (r13 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r13.length;
        r10.writeInt(r14);
    L6:
        if (r12 == r14) goto L10;
        r10.writeParcelable(r13[r12], r11);
        r12 = r12 + 1;
        goto L6
    }

    public PhotoRemovePhotosFromAlbumParams(@Nullable AlbumEntity r10, @Nullable PhotoEntity[] r11) {
        this.album = r10;
        this.photos = r11;
    }

    public /* synthetic */ PhotoRemovePhotosFromAlbumParams(AlbumEntity r10, PhotoEntity[] r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
