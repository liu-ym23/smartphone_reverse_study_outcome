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
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: PhotoShowPhotoParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoShowPhotoParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoShowPhotoParams> CREATOR = null;
    private Integer index;
    private PhotoEntity[] targets;

    /* JADX INFO: compiled from: PhotoShowPhotoParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoShowPhotoParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoShowPhotoParams createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            Integer r2 = null;
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r4 = null;
        L9:
            if (r10.readInt() == 0) goto L12;
            r2 = Integer.valueOf(r10.readInt());
        L12:
            PhotoShowPhotoParams r1 = new PhotoShowPhotoParams(r4, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L13:
            if (r5 > r3) goto L15;
            r5 = r5 + 1;
        L15:
            if (r5 > r0) goto L17;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L15
        L17:
            return r1;
        L5:
            int r6 = r10.readInt();
            r4 = new PhotoEntity[r6];
            int r7 = 0;
        L6:
            if (r7 == r6) goto L9;
            r4[r7] = (PhotoEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(PhotoShowPhotoParams.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin");
            r7 = r7 + 1;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoShowPhotoParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoShowPhotoParams[] newArray(int r1) {
            return new PhotoShowPhotoParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoShowPhotoParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoShowPhotoParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoShowPhotoParams copy$default(PhotoShowPhotoParams r0, PhotoEntity[] r1, Integer r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.index;
    L9:
        return r0.copy(r1, r2);
    }

    public final PhotoEntity[] component1() {
        return this.targets;
    }

    public final Integer component2() {
        return this.index;
    }

    public final PhotoShowPhotoParams copy(PhotoEntity[] r1, Integer r2) {
        return new PhotoShowPhotoParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoShowPhotoParams.class) == true) goto L8;
        return false;
    L8:
        PhotoShowPhotoParams r6 = (PhotoShowPhotoParams) ZeusTransformUtils.preCheckCast(r5, PhotoShowPhotoParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.targets, r6.targets) == true) goto L12;
        return false;
    L12:
        if (o.a(this.index, r6.index) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        PhotoEntity[] r0 = this.targets;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Integer r4 = this.index;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = Arrays.hashCode(r0);
        goto L6
    }

    public String toString() {
        return "PhotoShowPhotoParams(targets=" + Arrays.toString(this.targets) + ", index=" + this.index + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r9, int r10) {
        r9.writeInt(0);
        o.e(r9, "out");
        PhotoEntity[] r1 = this.targets;
        if (r1 != null) goto L5;
        r9.writeInt(0);
    L8:
        Integer r8 = this.index;
        if (r8 != null) goto L11;
        r9.writeInt(0);
        return;
    L11:
        r9.writeInt(1);
        r9.writeInt(r8.intValue());
        return;
    L5:
        r9.writeInt(1);
        int r3 = r1.length;
        r9.writeInt(r3);
        int r4 = 0;
    L6:
        if (r4 == r3) goto L8;
        r9.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1[r4], Parcelable.class, "com.obric.aiagent.plugin"), r10);
        r4 = r4 + 1;
        goto L6
    }

    public PhotoShowPhotoParams(PhotoEntity[] r1, Integer r2) {
        this.targets = r1;
        this.index = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoShowPhotoParams(PhotoEntity[] r2, Integer r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final PhotoEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(PhotoEntity[] r1) {
        this.targets = r1;
    }

    public final Integer getIndex() {
        return this.index;
    }

    public final void setIndex(Integer r1) {
        this.index = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, PhotoShowPhotoParams.class) == false) goto L5;
        PhotoEntity[] r1 = this.targets;
        if (r1 != null) goto L9;
        r1 = ((PhotoShowPhotoParams) ZeusTransformUtils.preCheckCast(r4, PhotoShowPhotoParams.class, "com.obric.aiagent.plugin")).targets;
    L9:
        Integer r3 = this.index;
        if (r3 != null) goto L13;
        r3 = ((PhotoShowPhotoParams) ZeusTransformUtils.preCheckCast(r4, PhotoShowPhotoParams.class, "com.obric.aiagent.plugin")).index;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoShowPhotoParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.targets);
    }
}
