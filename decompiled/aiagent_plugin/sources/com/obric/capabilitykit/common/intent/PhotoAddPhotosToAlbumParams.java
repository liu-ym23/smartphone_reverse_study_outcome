package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PhotoAddPhotosToAlbumParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoAddPhotosToAlbumParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoAddPhotosToAlbumParams> CREATOR = null;
    private AlbumEntity album;
    private PhotoEntity[] photos;

    /* JADX INFO: compiled from: PhotoAddPhotosToAlbumParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoAddPhotosToAlbumParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoAddPhotosToAlbumParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            AlbumEntity r1 = (AlbumEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(PhotoAddPhotosToAlbumParams.class.getClassLoader()), AlbumEntity.class, "com.obric.aiagent.plugin");
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r2 = null;
        L9:
            PhotoAddPhotosToAlbumParams r3 = new PhotoAddPhotosToAlbumParams(r1, r2);
            int r4 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r4) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L12
        L14:
            return r3;
        L5:
            int r6 = r10.readInt();
            PhotoEntity[] r7 = new PhotoEntity[r6];
            int r8 = 0;
        L6:
            if (r8 == r6) goto L8;
            r7[r8] = (PhotoEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(PhotoAddPhotosToAlbumParams.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        L8:
            r2 = r7;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoAddPhotosToAlbumParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoAddPhotosToAlbumParams[] newArray(int r1) {
            return new PhotoAddPhotosToAlbumParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoAddPhotosToAlbumParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoAddPhotosToAlbumParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoAddPhotosToAlbumParams copy$default(PhotoAddPhotosToAlbumParams r0, AlbumEntity r1, PhotoEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.album;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.photos;
    L9:
        return r0.copy(r1, r2);
    }

    public final AlbumEntity component1() {
        return this.album;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final PhotoAddPhotosToAlbumParams copy(AlbumEntity r1, PhotoEntity[] r2) {
        return new PhotoAddPhotosToAlbumParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoAddPhotosToAlbumParams.class) == true) goto L8;
        return false;
    L8:
        PhotoAddPhotosToAlbumParams r6 = (PhotoAddPhotosToAlbumParams) ZeusTransformUtils.preCheckCast(r5, PhotoAddPhotosToAlbumParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.album, r6.album) == true) goto L12;
        return false;
    L12:
        if (o.a(this.photos, r6.photos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        AlbumEntity r0 = this.album;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity[] r4 = this.photos;
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoAddPhotosToAlbumParams(album=" + this.album + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.album, Parcelable.class, "com.obric.aiagent.plugin"), r7);
        PhotoEntity[] r5 = this.photos;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        int r1 = r5.length;
        r6.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r0 = r0 + 1;
        goto L6
    }

    public PhotoAddPhotosToAlbumParams(AlbumEntity r1, PhotoEntity[] r2) {
        this.album = r1;
        this.photos = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoAddPhotosToAlbumParams(AlbumEntity r2, PhotoEntity[] r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final AlbumEntity getAlbum() {
        return this.album;
    }

    public final void setAlbum(AlbumEntity r1) {
        this.album = r1;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public final void setPhotos(PhotoEntity[] r1) {
        this.photos = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.album == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PhotoAddPhotosToAlbumParams.class) == false) goto L5;
        AlbumEntity r1 = this.album;
        if (r1 != null) goto L9;
        r1 = ((PhotoAddPhotosToAlbumParams) ZeusTransformUtils.preCheckCast(r4, PhotoAddPhotosToAlbumParams.class, "com.obric.aiagent.plugin")).album;
    L9:
        PhotoEntity[] r3 = this.photos;
        if (r3 != null) goto L13;
        r3 = ((PhotoAddPhotosToAlbumParams) ZeusTransformUtils.preCheckCast(r4, PhotoAddPhotosToAlbumParams.class, "com.obric.aiagent.plugin")).photos;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoAddPhotosToAlbumParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.b(new Object[]{this.album, this.photos});
    }
}
