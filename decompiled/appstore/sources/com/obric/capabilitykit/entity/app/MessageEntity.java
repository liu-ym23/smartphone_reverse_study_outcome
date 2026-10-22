package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.collections.t;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BE\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\b\u0010,\u001a\u00020-H\u0016J\"\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000203H\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "telephones", "", "text", "contacts", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;JJLjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", KevaImpl.PrivateConstants.FILES_DIR_NAME, "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getFiles", "setFiles", "(Ljava/util/List;)V", "groupChat", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "getGroupChat", "()Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "setGroupChat", "(Lcom/obric/capabilitykit/entity/app/GroupChatEntity;)V", "messageStatusType", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "getMessageStatusType", "()Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "setMessageStatusType", "(Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;)V", "messageType", "Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "getMessageType", "()Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "setMessageType", "(Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;)V", "getTelephones", "getText", "()Ljava/lang/String;", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessageEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 3;

    @Nullable
    private final List<ContactEntity> contacts;

    @Nullable
    private List<FileEntity> files;

    @Nullable
    private GroupChatEntity groupChat;

    @Nullable
    private MessageStatusTypeEnum messageStatusType;

    @Nullable
    private MessageTypeEnum messageType;

    @NotNull
    private final List<String> telephones;

    @NotNull
    private final String text;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/MessageEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MessageEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MessageEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MessageEntity");
            return (MessageEntity) r11;
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public MessageEntity[] newArray(int r10) {
            return new MessageEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MessageEntity(@NotNull Parcel r11) {
        q.g(r11, "parcel");
        String r10 = EntityExtKt.f(r11);
        long r12 = r11.readLong();
        long r13 = r11.readLong();
        List r14 = r11.createStringArrayList();
        if (r14 != null) goto L5;
        r14 = t.i();
    L5:
        this(r10, r12, r13, r14, EntityExtKt.f(r11), r11.createTypedArrayList(ContactEntity.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r15 = r11.readInt();
        this.messageType = MessageTypeEnum.Companion.a(r11.readString());
        this.files = r11.createTypedArrayList(FileEntity.CREATOR);
        this.messageStatusType = MessageStatusTypeEnum.Companion.a(r11.readString());
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 1, r15);
    }

    @Nullable
    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    @NotNull
    public DisplayRepresentation getDisplayRepresentation() {
        List<ContactEntity> r10 = this.contacts;
        if (r10 == null) goto L10;
        ContactEntity r11 = (ContactEntity) b0.a0(r10, 0);
        if (r11 == null) goto L10;
        String r12 = r11.getName();
        if (r12 == null) goto L10;
    L9:
        String r13 = r12;
        List<ContactEntity> r14 = this.contacts;
        if (r14 == null) goto L19;
        ContactEntity r15 = (ContactEntity) b0.a0(r14, 0);
        if (r15 == null) goto L19;
        FileEntity r16 = r15.getAvatar();
        if (r16 == null) goto L19;
        Uri r17 = r16.getContentUrl();
    L18:
        Uri r18 = r17;
        return new DisplayRepresentation(r18, r13, this.text, getLastModifiedTime());
    L19:
        r17 = null;
    L10:
        r12 = this.telephones.get(0);
        goto L9
    }

    @Nullable
    public final List<FileEntity> getFiles() {
        return this.files;
    }

    @Nullable
    public final GroupChatEntity getGroupChat() {
        return this.groupChat;
    }

    @Nullable
    public final MessageStatusTypeEnum getMessageStatusType() {
        return this.messageStatusType;
    }

    @Nullable
    public final MessageTypeEnum getMessageType() {
        return this.messageType;
    }

    @NotNull
    public final List<String> getTelephones() {
        return this.telephones;
    }

    @NotNull
    public final String getText() {
        return this.text;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L6;
        this.groupChat = (GroupChatEntity) r10.readValue(r11);
        return;
    }

    public final void setFiles(@Nullable List<FileEntity> r10) {
        this.files = r10;
    }

    public final void setGroupChat(@Nullable GroupChatEntity r10) {
        this.groupChat = r10;
    }

    public final void setMessageStatusType(@Nullable MessageStatusTypeEnum r10) {
        this.messageStatusType = r10;
    }

    public final void setMessageType(@Nullable MessageTypeEnum r10) {
        this.messageType = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeStringList(this.telephones);
        r10.writeString(this.text);
        r10.writeTypedList(this.contacts);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(1);
        MessageTypeEnum r12 = this.messageType;
        String r13 = null;
        if (r12 == null) goto L5;
        String r14 = r12.name();
    L6:
        r10.writeString(r14);
        r10.writeTypedList(this.files);
        MessageStatusTypeEnum r15 = this.messageStatusType;
        if (r15 == null) goto L9;
        r13 = r15.name();
    L9:
        r10.writeString(r13);
        r10.writeValue(this.groupChat);
        return;
    L5:
        r14 = null;
        goto L6
    }

    public MessageEntity(@NotNull String r11, long r12, long r14, @NotNull List<String> r16, @NotNull String r17, @Nullable List<ContactEntity> r18) {
        q.g(r11, "id");
        q.g(r16, "telephones");
        q.g(r17, "text");
        super(r11, r12, r14, 101);
        this.telephones = r16;
        this.text = r17;
        this.contacts = r18;
    }

    public /* synthetic */ MessageEntity(String r11, long r12, long r14, List r16, String r17, List r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 32) == 0) goto L5;
        List r10 = null;
    L6:
        this(r11, r12, r14, r16, r17, r10);
        return;
    L5:
        r10 = r18;
        goto L6
    }
}
