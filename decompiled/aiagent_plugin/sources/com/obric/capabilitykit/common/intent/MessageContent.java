package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntity;
import com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.app.NoteEntity;
import com.obric.capabilitykit.entity.app.PhotoEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: Params.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MessageContent implements Parcelable, IUriSharerEntityCollection {
    public static final Parcelable.Creator<MessageContent> CREATOR = null;
    private final ContactEntity contact;
    private final NoteEntity note;
    private final PhotoEntity photo;
    private final String text;

    /* JADX INFO: compiled from: Params.kt */
    public static final class Creator implements Parcelable.Creator<MessageContent> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessageContent createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            MessageContent r1 = new MessageContent(r9.readString(), (PhotoEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(MessageContent.class.getClassLoader()), PhotoEntity.class, "com.obric.aiagent.plugin"), (NoteEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(MessageContent.class.getClassLoader()), NoteEntity.class, "com.obric.aiagent.plugin"), (ContactEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(MessageContent.class.getClassLoader()), ContactEntity.class, "com.obric.aiagent.plugin"));
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r3 = 1;
        L3:
            if (r3 > r2) goto L5;
            r3 = r3 + 1;
        L5:
            if (r3 > r0) goto L7;
            a.a(r9, r8);
            r3 = r3 + 1;
            goto L5
        L7:
            return r1;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageContent createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessageContent[] newArray(int r1) {
            return new MessageContent[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageContent[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public static /* synthetic */ MessageContent copy$default(MessageContent r0, String r1, PhotoEntity r2, NoteEntity r3, ContactEntity r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.text;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.photo;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.note;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.contact;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final String component1() {
        return this.text;
    }

    public final PhotoEntity component2() {
        return this.photo;
    }

    public final NoteEntity component3() {
        return this.note;
    }

    public final ContactEntity component4() {
        return this.contact;
    }

    public final MessageContent copy(String r1, PhotoEntity r2, NoteEntity r3, ContactEntity r4) {
        return new MessageContent(r1, r2, r3, r4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MessageContent.class) == true) goto L8;
        return false;
    L8:
        MessageContent r6 = (MessageContent) ZeusTransformUtils.preCheckCast(r5, MessageContent.class, "com.obric.aiagent.plugin");
        if (o.a(this.text, r6.text) == true) goto L12;
        return false;
    L12:
        if (o.a(this.photo, r6.photo) == true) goto L15;
        return false;
    L15:
        if (o.a(this.note, r6.note) == true) goto L18;
        return false;
    L18:
        if (o.a(this.contact, r6.contact) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        String r0 = this.text;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        PhotoEntity r4 = this.photo;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        NoteEntity r7 = this.note;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        ContactEntity r10 = this.contact;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageContent(text=" + this.text + ", photo=" + this.photo + ", note=" + this.note + ", contact=" + this.contact + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        r4.writeString(this.text);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.photo, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.note, Parcelable.class, "com.obric.aiagent.plugin"), r5);
        r4.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(this.contact, Parcelable.class, "com.obric.aiagent.plugin"), r5);
    }

    public MessageContent(String r1, PhotoEntity r2, NoteEntity r3, ContactEntity r4) {
        this.text = r1;
        this.photo = r2;
        this.note = r3;
        this.contact = r4;
    }

    public final String getText() {
        return this.text;
    }

    public final PhotoEntity getPhoto() {
        return this.photo;
    }

    public final NoteEntity getNote() {
        return this.note;
    }

    public final ContactEntity getContact() {
        return this.contact;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharerEntityCollection
    public List<IUriSharerEntity> getUriSharersEntities() {
        return p.b(new IUriSharerEntity[]{(IUriSharerEntity) ZeusTransformUtils.preCheckCast(this.photo, IUriSharerEntity.class, "com.obric.aiagent.plugin"), (IUriSharerEntity) ZeusTransformUtils.preCheckCast(this.note, IUriSharerEntity.class, "com.obric.aiagent.plugin"), (IUriSharerEntity) ZeusTransformUtils.preCheckCast(this.contact, IUriSharerEntity.class, "com.obric.aiagent.plugin")});
    }
}
