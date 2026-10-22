package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.AlbumEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PhotoOpenAlbumParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoOpenAlbumParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoOpenAlbumParams> CREATOR = null;
    private AlbumEntity album;

    /* JADX INFO: compiled from: PhotoOpenAlbumParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoOpenAlbumParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoOpenAlbumParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            PhotoOpenAlbumParams r1 = new PhotoOpenAlbumParams((AlbumEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(PhotoOpenAlbumParams.class.getClassLoader()), AlbumEntity.class, "com.obric.aiagent.plugin"));
            int r2 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r6, r5);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoOpenAlbumParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoOpenAlbumParams[] newArray(int r1) {
            return new PhotoOpenAlbumParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoOpenAlbumParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoOpenAlbumParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoOpenAlbumParams copy$default(PhotoOpenAlbumParams r0, AlbumEntity r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.album;
    L6:
        return r0.copy(r1);
    }

    public final AlbumEntity component1() {
        return this.album;
    }

    public final PhotoOpenAlbumParams copy(AlbumEntity r1) {
        return new PhotoOpenAlbumParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoOpenAlbumParams.class) == true) goto L8;
        return false;
    L8:
        PhotoOpenAlbumParams r6 = (PhotoOpenAlbumParams) ZeusTransformUtils.preCheckCast(r5, PhotoOpenAlbumParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.album, r6.album) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        AlbumEntity r0 = this.album;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "PhotoOpenAlbumParams(album=" + this.album + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.album, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }

    public PhotoOpenAlbumParams(AlbumEntity r1) {
        this.album = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoOpenAlbumParams(AlbumEntity r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final AlbumEntity getAlbum() {
        return this.album;
    }

    public final void setAlbum(AlbumEntity r1) {
        this.album = r1;
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
        if (ZeusTransformUtils.instanceOf(r4, PhotoOpenAlbumParams.class) == false) goto L5;
        AlbumEntity r3 = this.album;
        if (r3 != null) goto L10;
        r3 = ((PhotoOpenAlbumParams) ZeusTransformUtils.preCheckCast(r4, PhotoOpenAlbumParams.class, "com.obric.aiagent.plugin")).album;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoOpenAlbumParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.album);
    }
}
