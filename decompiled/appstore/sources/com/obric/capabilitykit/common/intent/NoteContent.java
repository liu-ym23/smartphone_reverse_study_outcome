package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.n;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0016\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\nJ,\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\u0010\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0016J\t\u0010\u001b\u001a\u00020\u0013HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0013HÖ\u0001R\u001b\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\""}, d2 = {"Lcom/obric/capabilitykit/common/intent/NoteContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photos", "", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)V", "getPhotos", "()[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "[Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;[Lcom/obric/capabilitykit/entity/app/PhotoEntity;)Lcom/obric/capabilitykit/common/intent/NoteContent;", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class NoteContent implements Parcelable, IUriSharerEntityCollection {

    @NotNull
    public static final Parcelable.Creator<NoteContent> CREATOR = null;

    @Nullable
    private final PhotoEntity[] photos;

    @Nullable
    private final String text;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<NoteContent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NoteContent createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            String r12 = r10.readString();
            if (r10.readInt() != 0) goto L5;
            PhotoEntity[] r13 = null;
        L9:
            NoteContent r14 = new NoteContent(r12, r13);
            int r15 = Math.min(r11, 0);
            ClassLoader r16 = Creator.class.getClassLoader();
            int r17 = 1;
        L10:
            if (r17 > r15) goto L12;
            r17 = r17 + 1;
        L12:
            if (r17 > r11) goto L14;
            a.d(r10, r16);
            r17 = r17 + 1;
            goto L12
        L14:
            return r14;
        L5:
            int r18 = r10.readInt();
            PhotoEntity[] r19 = new PhotoEntity[r18];
            int r20 = 0;
        L6:
            if (r20 == r18) goto L8;
            r19[r20] = (PhotoEntity) r10.readParcelable(NoteContent.class.getClassLoader());
            r20 = r20 + 1;
            goto L6
        L8:
            r13 = r19;
            goto L9
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final NoteContent[] newArray(int r10) {
            return new NoteContent[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteContent createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ NoteContent[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public NoteContent(@Nullable String r10, @Nullable PhotoEntity[] r11) {
        this.text = r10;
        this.photos = r11;
    }

    public static /* synthetic */ NoteContent copy$default(NoteContent r10, String r11, PhotoEntity[] r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.text;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.photos;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final String component1() {
        return this.text;
    }

    @Nullable
    public final PhotoEntity[] component2() {
        return this.photos;
    }

    @NotNull
    public final NoteContent copy(@Nullable String r10, @Nullable PhotoEntity[] r11) {
        return new NoteContent(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof NoteContent) == true) goto L8;
        return false;
    L8:
        NoteContent r11 = (NoteContent) r10;
        if (q.b(this.text, r11.text) == true) goto L12;
        return false;
    L12:
        if (q.b(this.photos, r11.photos) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final PhotoEntity[] getPhotos() {
        return this.photos;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    @NotNull
    public List<IUriSharerEntity> getUriSharersEntities() {
        PhotoEntity[] r10 = this.photos;
        if (r10 == null) goto L7;
        List<IUriSharerEntity> r11 = n.K(r10);
        if (r11 == null) goto L7;
        return r11;
    L7:
        return t.i();
    }

    public int hashCode() {
        String r10 = this.text;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        PhotoEntity[] r14 = this.photos;
        if (r14 == null) goto L11;
        r11 = Arrays.hashCode(r14);
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "NoteContent(text=" + this.text + ", photos=" + Arrays.toString(this.photos) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        int r12 = 0;
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.text);
        PhotoEntity[] r13 = this.photos;
        if (r13 != null) goto L5;
        r10.writeInt(0);
        return;
    L5:
        r10.writeInt(1);
        int r14 = r13.length;
        r10.writeInt(r14);
    L6:
        if (r12 == r14) goto L10;
        r10.writeParcelable(r13[r12], r11);
        r12 = r12 + 1;
        goto L6
    }
}
