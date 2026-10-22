package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.CloudDocumentEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OfficeMessageContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<OfficeMessageContent> CREATOR = null;
    private final CloudDocumentEntity doc;
    private final PhotoEntity[] photos;
    private final String text;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<OfficeMessageContent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeMessageContent createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            String r1 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r2 = null;
        L9:
            OfficeMessageContent r5 = new OfficeMessageContent(r1, r2, (CloudDocumentEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(OfficeMessageContent.class.getClassLoader()), CloudDocumentEntity.class, "com.obric.aiagent.plugin"));
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r4 = 1;
        L10:
            if (r4 > r3) goto L12;
            r4 = r4 + 1;
        L12:
            if (r4 > r0) goto L14;
            a.a(r10, r9);
            r4 = r4 + 1;
            goto L12
        L14:
            return r5;
        L5:
            int r6 = r10.readInt();
            PhotoEntity[] r7 = new PhotoEntity[r6];
            int r8 = 0;
        L6:
            if (r8 == r6) goto L8;
            r7[r8] = (PhotoEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(OfficeMessageContent.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        L8:
            r2 = r7;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeMessageContent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeMessageContent[] newArray(int r1) {
            return new OfficeMessageContent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeMessageContent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ OfficeMessageContent copy$default(OfficeMessageContent r0, String r1, PhotoEntity[] r2, CloudDocumentEntity r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.photos;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.doc;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final CloudDocumentEntity component3() {
        return this.doc;
    }

    public final OfficeMessageContent copy(String r1, PhotoEntity[] r2, CloudDocumentEntity r3) {
        return new OfficeMessageContent(r1, r2, r3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeMessageContent.class) == true) goto L8;
        return false;
    L8:
        OfficeMessageContent r6 = (OfficeMessageContent) ZeusTransformUtils.preCheckCast(r5, OfficeMessageContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.photos, r6.photos) == true) goto L15;
        return false;
    L15:
        if (o.a(this.doc, r6.doc) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity[] r4 = this.photos;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        CloudDocumentEntity r7 = this.doc;
        if (r7 == null) goto L15;
        r1 = r7.hashCode();
    L15:
        return r6 + r1;
    L9:
        r5 = Arrays.hashCode(r4);
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "OfficeMessageContent(text=" + this.text + ", photos=" + Arrays.toString(this.photos) + ", doc=" + this.doc + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r7, int r8) {
        int r0 = 0;
        r7.writeInt(0);
        o.e(r7, "out");
        r7.writeString(this.text);
        PhotoEntity[] r1 = this.photos;
        if (r1 != null) goto L5;
        r7.writeInt(0);
    L8:
        r7.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.doc, Parcelable.class, "com.obric.aiagent.plugin"), r8);
        return;
    L5:
        r7.writeInt(1);
        int r3 = r1.length;
        r7.writeInt(r3);
    L6:
        if (r0 == r3) goto L8;
        r7.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r1[r0], Parcelable.class, "com.obric.aiagent.plugin"), r8);
        r0 = r0 + 1;
        goto L6
    }

    public OfficeMessageContent(String r1, PhotoEntity[] r2, CloudDocumentEntity r3) {
        this.text = r1;
        this.photos = r2;
        this.doc = r3;
    }

    public final String getText() {
        return this.text;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    public final CloudDocumentEntity getDoc() {
        return this.doc;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    public List<IUriSharerEntity> getUriSharersEntities() {
        PhotoEntity[] r0 = this.photos;
        if (r0 == null) goto L7;
        List<IUriSharerEntity> r1 = i.g(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return p.b();
    }
}
