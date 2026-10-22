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

/* JADX INFO: compiled from: PhotoUpdateAlbumParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoUpdateAlbumParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoUpdateAlbumParams> CREATOR = null;
    private AlbumEntity album;
    private String name;

    /* JADX INFO: compiled from: PhotoUpdateAlbumParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoUpdateAlbumParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoUpdateAlbumParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            PhotoUpdateAlbumParams r1 = new PhotoUpdateAlbumParams((AlbumEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(PhotoUpdateAlbumParams.class.getClassLoader()), AlbumEntity.class, "com.obric.aiagent.plugin"), r6.readString());
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
        public /* bridge */ /* synthetic */ PhotoUpdateAlbumParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoUpdateAlbumParams[] newArray(int r1) {
            return new PhotoUpdateAlbumParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoUpdateAlbumParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoUpdateAlbumParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoUpdateAlbumParams copy$default(PhotoUpdateAlbumParams r0, AlbumEntity r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.album;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.name;
    L9:
        return r0.copy(r1, r2);
    }

    public final AlbumEntity component1() {
        return this.album;
    }

    public final String component2() {
        return this.name;
    }

    public final PhotoUpdateAlbumParams copy(AlbumEntity r1, String r2) {
        return new PhotoUpdateAlbumParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoUpdateAlbumParams.class) == true) goto L8;
        return false;
    L8:
        PhotoUpdateAlbumParams r6 = (PhotoUpdateAlbumParams) ZeusTransformUtils.preCheckCast(r5, PhotoUpdateAlbumParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.album, r6.album) == true) goto L12;
        return false;
    L12:
        if (o.a(this.name, r6.name) == true) goto L14;
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
        String r4 = this.name;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoUpdateAlbumParams(album=" + this.album + ", name=" + this.name + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.album, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeString(this.name);
    }

    public PhotoUpdateAlbumParams(AlbumEntity r1, String r2) {
        this.album = r1;
        this.name = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoUpdateAlbumParams(AlbumEntity r2, String r3, int r4, h r5) {
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

    public final String getName() {
        return this.name;
    }

    public final void setName(String r1) {
        this.name = r1;
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
        if (ZeusTransformUtils.instanceOf(r4, PhotoUpdateAlbumParams.class) == false) goto L5;
        AlbumEntity r1 = this.album;
        if (r1 != null) goto L9;
        r1 = ((PhotoUpdateAlbumParams) ZeusTransformUtils.preCheckCast(r4, PhotoUpdateAlbumParams.class, "com.obric.aiagent.plugin")).album;
    L9:
        String r3 = this.name;
        if (r3 != null) goto L13;
        r3 = ((PhotoUpdateAlbumParams) ZeusTransformUtils.preCheckCast(r4, PhotoUpdateAlbumParams.class, "com.obric.aiagent.plugin")).name;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoUpdateAlbumParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.album);
    }
}
