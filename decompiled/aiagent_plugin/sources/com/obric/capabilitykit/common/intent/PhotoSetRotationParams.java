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

/* JADX INFO: compiled from: PhotoSetRotationParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoSetRotationParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoSetRotationParams> CREATOR = null;
    private Integer angle;
    private PhotoEntity photo;

    /* JADX INFO: compiled from: PhotoSetRotationParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoSetRotationParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetRotationParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            PhotoEntity r2 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(PhotoSetRotationParams.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin");
            if (r6.readInt() != 0) goto L5;
            Integer r3 = null;
        L6:
            PhotoSetRotationParams r1 = new PhotoSetRotationParams(r2, r3);
            int r4 = Math.min(r0, 0);
            ClassLoader r5 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r4) goto L9;
            r7 = r7 + 1;
        L9:
            if (r7 > r0) goto L11;
            a.a(r6, r5);
            r7 = r7 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r3 = Integer.valueOf(r6.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetRotationParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetRotationParams[] newArray(int r1) {
            return new PhotoSetRotationParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetRotationParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetRotationParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetRotationParams copy$default(PhotoSetRotationParams r0, PhotoEntity r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.angle;
    L9:
        return r0.copy(r1, r2);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final Integer component2() {
        return this.angle;
    }

    public final PhotoSetRotationParams copy(PhotoEntity r1, Integer r2) {
        return new PhotoSetRotationParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoSetRotationParams.class) == true) goto L8;
        return false;
    L8:
        PhotoSetRotationParams r6 = (PhotoSetRotationParams) ZeusTransformUtils.preCheckCast(r5, PhotoSetRotationParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.photo, r6.photo) == true) goto L12;
        return false;
    L12:
        if (o.a(this.angle, r6.angle) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PhotoEntity r0 = this.photo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.angle;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetRotationParams(photo=" + this.photo + ", angle=" + this.angle + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.photo, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        Integer r4 = this.angle;
        if (r4 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r4.intValue());
    }

    public PhotoSetRotationParams(PhotoEntity r1, Integer r2) {
        this.photo = r1;
        this.angle = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoSetRotationParams(PhotoEntity r2, Integer r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final void setPhoto(PhotoEntity r1) {
        this.photo = r1;
    }

    public final Integer getAngle() {
        return this.angle;
    }

    public final void setAngle(Integer r1) {
        this.angle = r1;
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
        if (ZeusTransformUtils.instanceOf(r4, PhotoSetRotationParams.class) == false) goto L5;
        PhotoEntity r1 = this.photo;
        if (r1 != null) goto L9;
        r1 = ((PhotoSetRotationParams) ZeusTransformUtils.preCheckCast(r4, PhotoSetRotationParams.class, "com.obric.aiagent.plugin")).photo;
    L9:
        Integer r3 = this.angle;
        if (r3 != null) goto L13;
        r3 = ((PhotoSetRotationParams) ZeusTransformUtils.preCheckCast(r4, PhotoSetRotationParams.class, "com.obric.aiagent.plugin")).angle;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoSetRotationParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.photo);
    }
}
