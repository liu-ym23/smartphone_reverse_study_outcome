package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.android.contacts.obricsync.SyncContractKt;
import com.bytedance.apm.constant.PerfConsts;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.contactsdk.loader.ContractKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u0000 %2\u00020\u0001:\u0001%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B%\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\u0006\u0010\n\u001a\u00020\u0006¢\u0006\u0002\u0010\u000bJ\"\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\"H\u0016R\u001c\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "name", "(Ljava/lang/String;JJLjava/lang/String;)V", SyncContractKt.COLUMN_AVATAR, "Lcom/obric/capabilitykit/entity/app/FileEntity;", "getAvatar", "()Lcom/obric/capabilitykit/entity/app/FileEntity;", "setAvatar", "(Lcom/obric/capabilitykit/entity/app/FileEntity;)V", ContractKt.PARAM_ACTION_DOMAIN_CONTACTS, "", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "getContacts", "()Ljava/util/List;", "setContacts", "(Ljava/util/List;)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", GloableSearchConfig.KEY_VERSION, "", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GroupChatEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 1;
    private static final int RELATED_VERSION = 2;
    private FileEntity avatar;
    private List<ContactEntity> contacts;
    private String name;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/GroupChatEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/entity/app/GroupChatEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<GroupChatEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupChatEntity createFromParcel(Parcel r1) {
            Intrinsics.checkNotNullParameter(r1, "parcel");
            AppEntity r0 = AppEntity.CREATOR.createFromParcel(r1);
            Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.GroupChatEntity");
            return (GroupChatEntity) r0;
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
        Intrinsics.checkNotNullParameter(r9, "parcel");
        this(EntityExtKt.readStringOrEmpty(r9), r9.readLong(), r9.readLong(), EntityExtKt.readStringOrEmpty(r9));
        readExtensionFieldFromParcel$capabilitykitcommon_release(r9);
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r9, 1, r9.readInt());
        this.contacts = r9.createTypedArrayList(ContactEntity.CREATOR);
    }

    public GroupChatEntity(String r9, long r10, long r12, String r14) {
        Intrinsics.checkNotNullParameter(r9, "id");
        Intrinsics.checkNotNullParameter(r14, "name");
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
        Intrinsics.checkNotNullParameter(r2, "parcel");
        if (r4 != 1) goto L6;
        this.avatar = (FileEntity) r2.readValue(r3);
        return;
    }

    public final void setAvatar(FileEntity r1) {
        this.avatar = r1;
    }

    public final void setContacts(List<ContactEntity> r1) {
        this.contacts = r1;
    }

    public final void setName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.name = r2;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeString(this.name);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(1);
        r1.writeValue(this.avatar);
        r1.writeTypedList(this.contacts);
    }
}
