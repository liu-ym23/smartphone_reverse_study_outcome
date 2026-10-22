package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class GroupChatEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 2;
    private FileEntity avatar;
    private List<ContactEntity> contacts;
    private String name;

    public static final class CREATOR implements Parcelable.Creator<GroupChatEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupChatEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.GroupChatEntity");
            return (GroupChatEntity) ZeusTransformUtils.preCheckCast(r1, GroupChatEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GroupChatEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 3;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupChatEntity[] newArray(int r1) {
            return new GroupChatEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ GroupChatEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public GroupChatEntity(Parcel r9) {
        o.e(r9, "parcel");
        this(EntityExtKt.a(r9), r9.readLong(), r9.readLong(), EntityExtKt.a(r9));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r9);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r9, 1, r9.readInt());
        this.contacts = r9.createTypedArrayList(ContactEntity.CREATOR);
    }

    public GroupChatEntity(String r9, long r10, long r12, String r14) {
        o.e(r9, DbHelper.COL_ID);
        o.e(r14, "name");
        super(r9, r10, r12, 203);
        this.name = r14;
    }

    public final FileEntity getAvatar() {
        return this.avatar;
    }

    public final List<ContactEntity> getContacts() {
        return this.contacts;
    }

    public final String getName() {
        return this.name;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r2, ClassLoader r3, int r4) {
        o.e(r2, "parcel");
        if (r4 != 1) goto L6;
        this.avatar = (FileEntity) ZeusTransformUtils.preCheckCast(r2.readValue(r3), FileEntity.class, "com.obric.aiagent.plugin");
        return;
    }

    public final void setAvatar(FileEntity r1) {
        this.avatar = r1;
    }

    public final void setContacts(List<ContactEntity> r3) {
        this.contacts = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setName(String r2) {
        o.e(r2, "<set-?>");
        this.name = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(1);
        r1.writeValue(this.avatar);
        r1.writeTypedList(this.contacts);
    }
}
