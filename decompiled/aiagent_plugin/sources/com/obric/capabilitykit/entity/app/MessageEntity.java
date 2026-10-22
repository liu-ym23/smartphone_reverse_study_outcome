package com.obric.capabilitykit.entity.app;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.MessageStatusTypeEnum;
import com.obric.capabilitykit.entity.enums.MessageTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
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

    public static final class CREATOR implements Parcelable.Creator<MessageEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public MessageEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.MessageEntity");
            return (MessageEntity) ZeusTransformUtils.preCheckCast(r1, MessageEntity.class, "com.obric.aiagent.plugin");
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
        o.e(r11, "parcel");
        String r2 = EntityExtKt.a(r11);
        long r3 = r11.readLong();
        long r5 = r11.readLong();
        List r0 = r11.createStringArrayList();
        if (r0 != null) goto L5;
        r0 = p.b();
    L5:
        this(r2, r3, r5, r0, EntityExtKt.a(r11), r11.createTypedArrayList(ContactEntity.CREATOR));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r11);
        int r1 = r11.readInt();
        this.messageType = MessageTypeEnum.Companion.a(r11.readString());
        this.files = r11.createTypedArrayList(FileEntity.CREATOR);
        this.messageStatusType = MessageStatusTypeEnum.Companion.a(r11.readString());
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r11, 1, r1);
    }

    public MessageEntity(String r12, long r13, long r15, List<String> r17, String r18, List<ContactEntity> r19) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List<ContactEntity> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        o.e(r12, DbHelper.COL_ID);
        o.e(r9, "telephones");
        o.e(r18, "text");
        super(r12, r13, r15, 101);
        this.telephones = r9;
        this.text = r18;
        this.contacts = r10;
    }

    public /* synthetic */ MessageEntity(String r12, long r13, long r15, List r17, String r18, List r19, int r20, h r21) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if ((r20 & 32) == 0) goto L5;
        r0 = null;
    L5:
        this(r12, r13, r15, r8, r18, r0);
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public DisplayRepresentation getDisplayRepresentation() {
        List<ContactEntity> r0 = this.contacts;
        if (r0 == null) goto L8;
        ContactEntity r1 = (ContactEntity) ZeusTransformUtils.preCheckCast(p.d(r0, 0), ContactEntity.class, "com.obric.aiagent.plugin");
        if (r1 == null) goto L8;
        String r2 = r1.getName();
        if (r2 == null) goto L8;
    L9:
        String r5 = r2;
        List<ContactEntity> r3 = this.contacts;
        if (r3 == null) goto L16;
        ContactEntity r4 = (ContactEntity) ZeusTransformUtils.preCheckCast(p.d(r3, 0), ContactEntity.class, "com.obric.aiagent.plugin");
        if (r4 == null) goto L16;
        FileEntity r6 = r4.getAvatar();
        if (r6 == null) goto L16;
        Uri r7 = r6.getContentUrl();
    L18:
        return new DisplayRepresentation(r7, r5, this.text, getLastModifiedTime());
    L16:
        r7 = null;
    L8:
        r2 = (String) ZeusTransformUtils.preCheckCast(this.telephones.get(0), String.class, "com.obric.aiagent.plugin");
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
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.groupChat = (GroupChatEntity) ZeusTransformUtils.preCheckCast(r2.readValue(r3), GroupChatEntity.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setFiles(List<FileEntity> r3) {
        this.files = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
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
        o.e(r2, "parcel");
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
