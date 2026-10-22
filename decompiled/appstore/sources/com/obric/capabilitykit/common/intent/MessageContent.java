package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B-\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J9\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\u0010\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010!0 H\u0016J\t\u0010\"\u001a\u00020\u001aHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006)"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessageContent;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntityCollection;", "text", "", "photo", "Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "note", "Lcom/obric/capabilitykit/entity/app/NoteEntity;", "contact", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;Lcom/obric/capabilitykit/entity/app/PhotoEntity;Lcom/obric/capabilitykit/entity/app/NoteEntity;Lcom/obric/capabilitykit/entity/app/ContactEntity;)V", "getContact", "()Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getNote", "()Lcom/obric/capabilitykit/entity/app/NoteEntity;", "getPhoto", "()Lcom/obric/capabilitykit/entity/app/PhotoEntity;", "getText", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharersEntities", "", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharerEntity;", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class MessageContent implements Parcelable, IUriSharerEntityCollection {

    @NotNull
    public static final Parcelable.Creator<MessageContent> CREATOR = null;

    @Nullable
    private final ContactEntity contact;

    @Nullable
    private final NoteEntity note;

    @Nullable
    private final PhotoEntity photo;

    @Nullable
    private final String text;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MessageContent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MessageContent createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            MessageContent r12 = new MessageContent(r10.readString(), (PhotoEntity) r10.readParcelable(MessageContent.class.getClassLoader()), (NoteEntity) r10.readParcelable(MessageContent.class.getClassLoader()), (ContactEntity) r10.readParcelable(MessageContent.class.getClassLoader()));
            int r13 = Math.min(r11, 0);
            ClassLoader r14 = Creator.class.getClassLoader();
            int r15 = 1;
        L3:
            if (r15 > r13) goto L5;
            r15 = r15 + 1;
        L5:
            if (r15 > r11) goto L7;
            a.d(r10, r14);
            r15 = r15 + 1;
            goto L5
        L7:
            return r12;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MessageContent[] newArray(int r10) {
            return new MessageContent[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageContent createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageContent[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    public MessageContent(@Nullable String r10, @Nullable PhotoEntity r11, @Nullable NoteEntity r12, @Nullable ContactEntity r13) {
        this.text = r10;
        this.photo = r11;
        this.note = r12;
        this.contact = r13;
    }

    public static /* synthetic */ MessageContent copy$default(MessageContent r10, String r11, PhotoEntity r12, NoteEntity r13, ContactEntity r14, int r15, Object r16) {
        if ((r15 & 1) == 0) goto L6;
        r11 = r10.text;
    L6:
        if ((r15 & 2) == 0) goto L9;
        r12 = r10.photo;
    L9:
        if ((r15 & 4) == 0) goto L12;
        r13 = r10.note;
    L12:
        if ((r15 & 8) == 0) goto L15;
        r14 = r10.contact;
    L15:
        return r10.copy(r11, r12, r13, r14);
    }

    @Nullable
    public final String component1() {
        return this.text;
    }

    @Nullable
    public final PhotoEntity component2() {
        return this.photo;
    }

    @Nullable
    public final NoteEntity component3() {
        return this.note;
    }

    @Nullable
    public final ContactEntity component4() {
        return this.contact;
    }

    @NotNull
    public final MessageContent copy(@Nullable String r10, @Nullable PhotoEntity r11, @Nullable NoteEntity r12, @Nullable ContactEntity r13) {
        return new MessageContent(r10, r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MessageContent) == true) goto L8;
        return false;
    L8:
        MessageContent r11 = (MessageContent) r10;
        if (q.b(this.text, r11.text) == true) goto L12;
        return false;
    L12:
        if (q.b(this.photo, r11.photo) == true) goto L15;
        return false;
    L15:
        if (q.b(this.note, r11.note) == true) goto L18;
        return false;
    L18:
        if (q.b(this.contact, r11.contact) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Nullable
    public final ContactEntity getContact() {
        return this.contact;
    }

    @Nullable
    public final NoteEntity getNote() {
        return this.note;
    }

    @Nullable
    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    @Nullable
    public final String getText() {
        return this.text;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    @NotNull
    public List<IUriSharerEntity> getUriSharersEntities() {
        return t.l(new IUriSharerEntity[]{this.photo, this.note, this.contact});
    }

    public int hashCode() {
        String r10 = this.text;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        PhotoEntity r14 = this.photo;
        if (r14 != null) goto L9;
        int r15 = 0;
    L10:
        int r16 = (r13 + r15) * 31;
        NoteEntity r17 = this.note;
        if (r17 != null) goto L13;
        int r18 = 0;
    L14:
        int r19 = (r16 + r18) * 31;
        ContactEntity r20 = this.contact;
        if (r20 == null) goto L19;
        r11 = r20.hashCode();
    L19:
        return r19 + r11;
    L13:
        r18 = r17.hashCode();
        goto L14
    L9:
        r15 = r14.hashCode();
        goto L10
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @NotNull
    public String toString() {
        return "MessageContent(text=" + this.text + ", photo=" + this.photo + ", note=" + this.note + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        r10.writeString(this.text);
        r10.writeParcelable(this.photo, r11);
        r10.writeParcelable(this.note, r11);
        r10.writeParcelable(this.contact, r11);
    }
}
