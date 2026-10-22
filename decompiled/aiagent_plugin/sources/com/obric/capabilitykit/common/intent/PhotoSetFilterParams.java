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

/* JADX INFO: compiled from: PhotoSetFilterParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class PhotoSetFilterParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<PhotoSetFilterParams> CREATOR = null;
    private String filter;
    private PhotoEntity photo;

    /* JADX INFO: compiled from: PhotoSetFilterParams.kt */
    public static final class Creator implements Parcelable.Creator<PhotoSetFilterParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetFilterParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            o.e(r6, "parcel");
            PhotoSetFilterParams r1 = new PhotoSetFilterParams((PhotoEntity) ZeusTransformUtils.preCheckCast(r6.readParcelable(PhotoSetFilterParams.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin"), r6.readString());
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
        public /* bridge */ /* synthetic */ PhotoSetFilterParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final PhotoSetFilterParams[] newArray(int r1) {
            return new PhotoSetFilterParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ PhotoSetFilterParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PhotoSetFilterParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ PhotoSetFilterParams copy$default(PhotoSetFilterParams r0, PhotoEntity r1, String r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.photo;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.filter;
    L9:
        return r0.copy(r1, r2);
    }

    public final PhotoEntity component1() {
        return this.photo;
    }

    public final String component2() {
        return this.filter;
    }

    public final PhotoSetFilterParams copy(PhotoEntity r1, String r2) {
        return new PhotoSetFilterParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, PhotoSetFilterParams.class) == true) goto L8;
        return false;
    L8:
        PhotoSetFilterParams r6 = (PhotoSetFilterParams) ZeusTransformUtils.preCheckCast(r5, PhotoSetFilterParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.photo, r6.photo) == true) goto L12;
        return false;
    L12:
        if (o.a(this.filter, r6.filter) == true) goto L14;
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
        String r4 = this.filter;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "PhotoSetFilterParams(photo=" + this.photo + ", filter=" + this.filter + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.photo, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeString(this.filter);
    }

    public PhotoSetFilterParams(PhotoEntity r1, String r2) {
        this.photo = r1;
        this.filter = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ PhotoSetFilterParams(PhotoEntity r2, String r3, int r4, h r5) {
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

    public final String getFilter() {
        return this.filter;
    }

    public final void setFilter(String r1) {
        this.filter = r1;
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
        if (ZeusTransformUtils.instanceOf(r4, PhotoSetFilterParams.class) == false) goto L5;
        PhotoEntity r1 = this.photo;
        if (r1 != null) goto L9;
        r1 = ((PhotoSetFilterParams) ZeusTransformUtils.preCheckCast(r4, PhotoSetFilterParams.class, "com.obric.aiagent.plugin")).photo;
    L9:
        String r3 = this.filter;
        if (r3 != null) goto L13;
        r3 = ((PhotoSetFilterParams) ZeusTransformUtils.preCheckCast(r4, PhotoSetFilterParams.class, "com.obric.aiagent.plugin")).filter;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new PhotoSetFilterParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.photo);
    }
}
