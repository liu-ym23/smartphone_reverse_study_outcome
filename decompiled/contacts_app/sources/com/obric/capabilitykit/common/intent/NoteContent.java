package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/intent/NoteContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)Lcom/obric/capabilitykit/common/intent/NoteContent;", "describeContents", "", "equals", "", "other", "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class NoteContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<NoteContent> CREATOR = null;
    private final PhotoEntity[] photos;
    private final String text;

    /* JADX INFO: compiled from: Params.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NoteContent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final NoteContent createFromParcel(Parcel r8) {
            int r0 = r8.readInt();
            Intrinsics.checkNotNullParameter(r8, "parcel");
            String r1 = r8.readString();
            if (r8.readInt() != 0) goto L5;
            PhotoEntity[] r2 = null;
        L9:
            NoteContent r4 = new NoteContent(r1, r2);
            int r3 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r5 = 1;
        L10:
            if (r5 > r3) goto L12;
            r5 = r5 + 1;
        L12:
            if (r5 > r0) goto L14;
            ParcelUtils.skipValueSafely(r8, r7);
            r5 = r5 + 1;
            goto L12
        L14:
            return r4;
        L5:
            int r6 = r8.readInt();
            PhotoEntity[] r9 = new PhotoEntity[r6];
            int r10 = 0;
        L6:
            if (r10 == r6) goto L8;
            r9[r10] = (PhotoEntity) r8.readParcelable(NoteContent.class.getClassLoader());
            r10 = r10 + 1;
            goto L6
        L8:
            r2 = r9;
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
        CREATOR = new Creator();
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
        if ((r5 instanceof NoteContent) == true) goto L8;
        return false;
    L8:
        NoteContent r6 = (NoteContent) r5;
        if (Intrinsics.areEqual(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.photos, r6.photos) == true) goto L14;
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
    public void writeToParcel(Parcel r4, int r5) {
        int r0 = 0;
        r4.writeInt(0);
        Intrinsics.checkNotNullParameter(r4, "out");
        r4.writeString(this.text);
        PhotoEntity[] r3 = this.photos;
        if (r3 != null) goto L5;
        r4.writeInt(0);
        return;
    L5:
        r4.writeInt(1);
        int r1 = r3.length;
        r4.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r4.writeParcelable(r3[r0], r5);
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
        List<IUriSharerEntity> r1 = ArraysKt.toList(r0);
        if (r1 == null) goto L7;
        return r1;
    L7:
        return CollectionsKt.emptyList();
    }
}
