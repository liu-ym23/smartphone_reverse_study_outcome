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

/* JADX INFO: compiled from: PhotoSetFadeParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoSetFadeParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoSetFadeParams> CREATOR = null;
    private PhotoEntity photo;
    private Integer value;
    private String valueType;

    /* JADX INFO: compiled from: PhotoSetFadeParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoSetFadeParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetFadeParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            PhotoEntity r2 = (PhotoEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(PhotoSetFadeParams.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin");
            String r3 = r6.readString();
            if (r6.readInt() != 0) goto L5;
            Integer r4 = null;
        L6:
            PhotoSetFadeParams r1 = new PhotoSetFadeParams(r2, r3, r4);
            int r5 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r8 = 1;
        L7:
            if (r8 > r5) goto L9;
            r8 = r8 + 1;
        L9:
            if (r8 > r0) goto L11;
            a.a(r6, r7);
            r8 = r8 + 1;
            goto L9
        L11:
            return r1;
        L5:
            r4 = Integer.valueOf(r6.readInt());
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetFadeParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetFadeParams[] newArray(int r1) {
            return new PhotoSetFadeParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetFadeParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public PhotoSetFadeParams() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ PhotoSetFadeParams copy$default(PhotoSetFadeParams r0, PhotoEntity r1, String r2, Integer r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.valueType;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.value;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final String component2() {
        return this.valueType;
    }

    public final Integer component3() {
        return this.value;
    }

    public final PhotoSetFadeParams copy(PhotoEntity r1, String r2, Integer r3) {
        return new PhotoSetFadeParams(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoSetFadeParams.class) == true) goto L8;
        return false;
    L8:
        PhotoSetFadeParams r6 = (PhotoSetFadeParams) ZeusTransformUtils.preCheckCast(r5, PhotoSetFadeParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.photo, r6.photo) == true) goto L12;
        return false;
    L12:
        if (o.a(this.valueType, r6.valueType) == true) goto L15;
        return false;
    L15:
        if (o.a(this.value, r6.value) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        PhotoEntity r0 = this.photo;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.valueType;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Integer r7 = this.value;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetFadeParams(photo=" + this.photo + ", valueType=" + this.valueType + ", value=" + this.value + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(0);
        o.e(r5, "out");
        r5.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.photo, Parcelable.class, "com.obric.aiagent.plugin"), r6);
        r5.writeString(this.valueType);
        Integer r4 = this.value;
        if (r4 != null) goto L5;
        r5.writeInt(0);
        return;
    L5:
        r5.writeInt(1);
        r5.writeInt(r4.intValue());
    }

    public PhotoSetFadeParams(PhotoEntity r1, String r2, Integer r3) {
        this.photo = r1;
        this.valueType = r2;
        this.value = r3;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoSetFadeParams(PhotoEntity r2, String r3, Integer r4, int r5, h r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final void setPhoto(PhotoEntity r1) {
        this.photo = r1;
    }

    public final String getValueType() {
        return this.valueType;
    }

    public final void setValueType(String r1) {
        this.valueType = r1;
    }

    public final Integer getValue() {
        return this.value;
    }

    public final void setValue(Integer r1) {
        this.value = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.photo == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r5) {
        if (ZeusTransformUtils.instanceOf(r5, PhotoSetFadeParams.class) == false) goto L5;
        PhotoEntity r1 = this.photo;
        if (r1 != null) goto L9;
        r1 = ((PhotoSetFadeParams) ZeusTransformUtils.preCheckCast(r5, PhotoSetFadeParams.class, "com.obric.aiagent.plugin")).photo;
    L9:
        String r3 = this.valueType;
        if (r3 != null) goto L12;
        r3 = ((PhotoSetFadeParams) ZeusTransformUtils.preCheckCast(r5, PhotoSetFadeParams.class, "com.obric.aiagent.plugin")).valueType;
    L12:
        Integer r4 = this.value;
        if (r4 != null) goto L16;
        r4 = ((PhotoSetFadeParams) ZeusTransformUtils.preCheckCast(r5, PhotoSetFadeParams.class, "com.obric.aiagent.plugin")).value;
    L16:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoSetFadeParams(r1, r3, r4), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.photo);
    }
}
