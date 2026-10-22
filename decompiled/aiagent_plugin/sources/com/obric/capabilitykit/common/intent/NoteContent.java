package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.i;
import d.a.p;
import d.h.b.o;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NoteContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<NoteContent> CREATOR = null;
    private final PhotoEntity[] photos;
    private final String text;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<NoteContent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NoteContent createFromParcel(Parcel r10) {
            int r0 = r10.readInt();
            o.e(r10, "parcel");
            String r1 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r2 = null;
        L9:
            NoteContent r4 = new NoteContent(r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r9 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            a.a(r10, r9);
            r5 = r5 + 1;
            goto L12
        L14:
            return r4;
        L5:
            int r6 = r10.readInt();
            PhotoEntity[] r7 = new PhotoEntity[r6];
            int r8 = 0;
        L6:
            if (r8 == r6) goto L8;
            r7[r8] = (PhotoEntity) ZeusTransformUtils.preCheckCast(r10.readParcelable(NoteContent.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin");
            r8 = r8 + 1;
            goto L6
        L8:
            r2 = r7;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteContent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NoteContent[] newArray(int r1) {
            return new NoteContent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteContent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ NoteContent copy$default(NoteContent r0, String r1, PhotoEntity[] r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.photos;
    L9:
        return r0.copy(r1, r2);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity[] component2() {
        return this.photos;
    }

    public final NoteContent copy(String r1, PhotoEntity[] r2) {
        return new NoteContent(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, NoteContent.class) == true) goto L8;
        return false;
    L8:
        NoteContent r6 = (NoteContent) ZeusTransformUtils.preCheckCast(r5, NoteContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.photos, r6.photos) == true) goto L14;
        return false;
    L14:
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
        if (r4 == null) goto L11;
        r1 = Arrays.hashCode(r4);
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "NoteContent(text=" + this.text + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        r6.writeString(this.text);
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

    public NoteContent(String r1, PhotoEntity[] r2) {
        this.text = r1;
        this.photos = r2;
    }

    public final String getText() {
        return this.text;
    }

    public final PhotoEntity[] getPhotos() {
        return this.photos;
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
