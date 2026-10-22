package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: PhotoCropParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoCropParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoCropParams> CREATOR = null;
    private PhotoEntity photo;

    /* JADX INFO: compiled from: PhotoCropParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoCropParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoCropParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            PhotoCropParams r1 = new PhotoCropParams((PhotoEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(PhotoCropParams.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin"));
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
        public /* bridge */ /* synthetic */ PhotoCropParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoCropParams[] newArray(int r1) {
            return new PhotoCropParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoCropParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoCropParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoCropParams copy$default(PhotoCropParams r0, PhotoEntity r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        return r0.copy(r1);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final PhotoCropParams copy(PhotoEntity r1) {
        return new PhotoCropParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoCropParams.class) == true) goto L8;
        return false;
    L8:
        PhotoCropParams r6 = (PhotoCropParams) ZeusTransformUtils.preCheckCast(r5, PhotoCropParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.photo, r6.photo) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        PhotoEntity r0 = this.photo;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.hashCode();
    }

    public String toString() {
        return "PhotoCropParams(photo=" + this.photo + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(0);
        o.e(r3, "out");
        r3.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.photo, Parcelable.class, "com.obric.aiagent.plugin"), r4);
    }

    public PhotoCropParams(PhotoEntity r1) {
        this.photo = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoCropParams(PhotoEntity r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final void setPhoto(PhotoEntity r1) {
        this.photo = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PhotoCropParams.class) == false) goto L5;
        PhotoEntity r3 = this.photo;
        if (r3 != null) goto L10;
        r3 = ((PhotoCropParams) ZeusTransformUtils.preCheckCast(r4, PhotoCropParams.class, "com.obric.aiagent.plugin")).photo;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoCropParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.photo);
    }
}
