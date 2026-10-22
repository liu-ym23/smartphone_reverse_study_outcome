package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.keva.KevaImpl;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.obric.contactsdk.loader.ContractKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 62\u00020\u0001:\u00016B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BE\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\u0002\u0010\u000fJ\b\u0010,\u001a\u00020-H\u0016J\"\u0010.\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u0001012\u0006\u00102\u001a\u000203H\u0016J\u0018\u00104\u001a\u00020/2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u00105\u001a\u000203H\u0016R\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0011\"\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0011R\u0011\u0010\f\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+¨\u00067"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "telephones", "", "text", ContractKt.PARAM_ACTION_DOMAIN_CONTACTS, "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "(Ljava/lang/String;JJLjava/util/List;Ljava/lang/String;Ljava/util/List;)V", "getContacts", "()Ljava/util/List;", KevaImpl.PrivateConstants.FILES_DIR_NAME, "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getFiles", "setFiles", "(Ljava/util/List;)V", "groupChat", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "getGroupChat", "()Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "setGroupChat", "(Lcom/obric/capabilitykit/entity/app/GroupChatEntity;)V", "messageStatusType", "Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "getMessageStatusType", "()Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;", "setMessageStatusType", "(Lcom/obric/capabilitykit/entity/enums/MessageStatusTypeEnum;)V", "messageType", "Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "getMessageType", "()Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;", "setMessageType", "(Lcom/obric/capabilitykit/entity/enums/MessageTypeEnum;)V", "getTelephones", "getText", "()Ljava/lang/String;", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessageEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 3;
    private final List<ContactEntity> contacts;
    private List<FileEntity> files;
    private GroupChatEntity groupChat;
    private MessageStatusTypeEnum messageStatusType;
    private MessageTypeEnum messageType;
    private final List<String> telephones;
    private final String text;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/MessageEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/MessageEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/MessageEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<MessageEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MessageEntity");
            return (MessageEntity) r0;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageEntity[] newArray(int r1) {
            return new MessageEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessageEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public MessageEntity(Parcel r11) {
        Intrinsics.checkNotNullParameter(r11, "parcel");
        String r2 = EntityExtKt.readStringOrEmpty(r11);
        long r3 = r11.readLong();
        long r5 = r11.readLong();
        List r0 = r11.createStringArrayList();
        if (r0 != null) goto L5;
        r0 = CollectionsKt.emptyList();
    L5:
        this(r2, r3, r5, r0, EntityExtKt.readStringOrEmpty(r11), r11.createTypedArrayList(ContactEntity.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r1 = r11.readInt();
        this.messageType = MessageTypeEnum.Companion.from(r11.readString());
        this.files = r11.createTypedArrayList(FileEntity.CREATOR);
        this.messageStatusType = MessageStatusTypeEnum.Companion.from(r11.readString());
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 1, r1);
    }

    public MessageEntity(String r11, long r12, long r14, List<String> r16, String r17, List<ContactEntity> r18) {
        Intrinsics.checkNotNullParameter(r11, "id");
        Intrinsics.checkNotNullParameter(r16, "telephones");
        Intrinsics.checkNotNullParameter(r17, "text");
        super(r11, r12, r14, 101);
        this.telephones = r16;
        this.text = r17;
        this.contacts = r18;
    }

    public /* synthetic */ MessageEntity(String r11, long r12, long r14, List r16, String r17, List r18, int r19, DefaultConstructorMarker r20) {
        if ((r19 & 32) == 0) goto L5;
        List r9 = null;
    L6:
        this(r11, r12, r14, r16, r17, r9);
        return;
    L5:
        r9 = r18;
        goto L6
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<ContactEntity> r0 = this.contacts;
        if (r0 == null) goto L8;
        ContactEntity r1 = (ContactEntity) CollectionsKt.getOrNull(r0, 0);
        if (r1 == null) goto L8;
        String r2 = r1.getName();
        if (r2 == null) goto L8;
    L9:
        String r4 = r2;
        List<ContactEntity> r3 = this.contacts;
        if (r3 == null) goto L16;
        ContactEntity r5 = (ContactEntity) CollectionsKt.getOrNull(r3, 0);
        if (r5 == null) goto L16;
        FileEntity r6 = r5.getAvatar();
        if (r6 == null) goto L16;
        Uri r7 = r6.getContentUrl();
    L18:
        return new DisplayRepresentation(r7, r4, this.text, getLastModifiedTime());
    L16:
        r7 = null;
    L8:
        r2 = this.telephones.get(0);
        goto L9
    }

    public final List<FileEntity> getFiles() {
        return this.files;
    }

    public final GroupChatEntity getGroupChat() {
        return this.groupChat;
    }

    public final MessageStatusTypeEnum getMessageStatusType() {
        return this.messageStatusType;
    }

    public final MessageTypeEnum getMessageType() {
        return this.messageType;
    }

    public final List<String> getTelephones() {
        return this.telephones;
    }

    public final String getText() {
        return this.text;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L6;
        this.groupChat = (GroupChatEntity) r2.readValue(r3);
        return;
    }

    public final void setFiles(List<FileEntity> r1) {
        this.files = r1;
    }

    public final void setGroupChat(GroupChatEntity r1) {
        this.groupChat = r1;
    }

    public final void setMessageStatusType(MessageStatusTypeEnum r1) {
        this.messageStatusType = r1;
    }

    public final void setMessageType(MessageTypeEnum r1) {
        this.messageType = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeStringList(this.telephones);
        r2.writeString(this.text);
        r2.writeTypedList(this.contacts);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r2);
        r2.writeInt(1);
        MessageTypeEnum r4 = this.messageType;
        String r0 = null;
        if (r4 == null) goto L5;
        String r5 = r4.name();
    L6:
        r2.writeString(r5);
        r2.writeTypedList(this.files);
        MessageStatusTypeEnum r6 = this.messageStatusType;
        if (r6 == null) goto L9;
        r0 = r6.name();
    L9:
        r2.writeString(r0);
        r2.writeValue(this.groupChat);
        return;
    L5:
        r5 = null;
        goto L6
    }
}
