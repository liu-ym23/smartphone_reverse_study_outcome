package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.b0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 C2\u00020\u0001:\u0001CB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004BO\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000b\u0012\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000b\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\b\u0010:\u001a\u00020;H\u0016J\"\u0010<\u001a\u00020=2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\u0011H\u0016J\u0018\u0010A\u001a\u00020=2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010B\u001a\u00020\u0011H\u0016R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0019\"\u0004\b\u001d\u0010\u001bR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010%\"\u0004\b)\u0010'R\u001c\u0010*\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R \u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00060\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0019\"\u0004\b0\u0010\u001bR\"\u00101\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0019\"\u0004\b3\u0010\u001bR\u001c\u00104\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010,\"\u0004\b6\u0010.R\u001c\u00107\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010,\"\u0004\b9\u0010.¨\u0006D"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "id", "", "createTime", "", "modifyTime", "telephones", "", "contacts", "Lcom/obric/capabilitykit/entity/app/ContactEntity;", "callType", "Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "duration", "", "(Ljava/lang/String;JJLjava/util/List;Ljava/util/List;Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;I)V", "getCallType", "()Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;", "setCallType", "(Lcom/obric/capabilitykit/entity/enums/CallTypeEnum;)V", "carriers", "getCarriers", "()Ljava/util/List;", "setCarriers", "(Ljava/util/List;)V", "getContacts", "setContacts", "getDuration", "()I", "setDuration", "(I)V", "hasTranscript", "", "getHasTranscript", "()Z", "setHasTranscript", "(Z)V", "isAIPickup", "setAIPickup", "tag", "getTag", "()Ljava/lang/String;", "setTag", "(Ljava/lang/String;)V", "getTelephones", "setTelephones", "todoList", "getTodoList", "setTodoList", "transcript", "getTranscript", "setTranscript", "transcriptTitle", "getTranscriptTitle", "setTranscriptTitle", "getDisplayRepresentation", "Lcom/obric/capabilitykit/entity/app/DisplayRepresentation;", "onReadSubClassExtensionField", "", "currentClassLoader", "Ljava/lang/ClassLoader;", "version", "writeToParcel", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CallHistoryEntity extends AppEntity {

    @NotNull
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 3;
    private static final int RELATED_VERSION = 1;

    @NotNull
    private CallTypeEnum callType;

    @Nullable
    private List<String> carriers;

    @Nullable
    private List<ContactEntity> contacts;
    private int duration;
    private boolean hasTranscript;
    private boolean isAIPickup;

    @Nullable
    private String tag;

    @NotNull
    private List<String> telephones;

    @Nullable
    private List<String> todoList;

    @Nullable
    private String transcript;

    @Nullable
    private String transcriptTitle;

    @Keep
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0087\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0006\u0010\n\u001a\u00020\u0005J\u001d\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/obric/capabilitykit/entity/app/CallHistoryEntity$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "()V", "FIELD_VERSION", "", "RELATED_VERSION", "createFromParcel", "parcel", "Landroid/os/Parcel;", "getVersion", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/entity/app/CallHistoryEntity;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CREATOR implements Parcelable.Creator<CallHistoryEntity> {
        private CREATOR() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CallHistoryEntity createFromParcel(@NotNull Parcel r10) {
            q.g(r10, "parcel");
            AppEntity r11 = AppEntity.CREATOR.createFromParcel(r10);
            q.e(r11, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CallHistoryEntity");
            return (CallHistoryEntity) r11;
        }

        public final int getVersion() {
            return 4;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public CallHistoryEntity[] newArray(int r10) {
            return new CallHistoryEntity[r10];
        }

        public /* synthetic */ CREATOR(DefaultConstructorMarker r10) {
            this();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CallHistoryEntity(@NotNull Parcel r12) {
        q.g(r12, "parcel");
        String r10 = EntityExtKt.f(r12);
        long r11 = r12.readLong();
        long r13 = r12.readLong();
        ArrayList<String> r14 = r12.createStringArrayList();
        if (r14 != null) goto L5;
        r14 = new ArrayList();
    L5:
        ArrayList<String> r15 = r14;
        ArrayList r16 = r12.createTypedArrayList(ContactEntity.CREATOR);
        CallTypeEnum r17 = CallTypeEnum.Companion.a(r12.readString());
        if (r17 != null) goto L8;
        r17 = CallTypeEnum.INCOMING_CALL_ANSWERED;
    L8:
        this(r10, r11, r13, r15, r16, r17, r12.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        int r18 = r12.readInt();
        this.tag = r12.readString();
        this.isAIPickup = EntityExtKt.e(r12);
        this.hasTranscript = EntityExtKt.e(r12);
        this.transcript = r12.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 3, r18);
    }

    @NotNull
    public final CallTypeEnum getCallType() {
        return this.callType;
    }

    @Nullable
    public final List<String> getCarriers() {
        return this.carriers;
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
        List<String> r14 = this.carriers;
        if (r14 == null) goto L15;
        String r15 = (String) b0.a0(r14, 0);
    L14:
        String r16 = r15;
        return new DisplayRepresentation(null, r13, r16, getLastModifiedTime());
    L15:
        r15 = null;
    L10:
        r12 = this.telephones.get(0);
        goto L9
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getHasTranscript() {
        return this.hasTranscript;
    }

    @Nullable
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final List<String> getTelephones() {
        return this.telephones;
    }

    @Nullable
    public final List<String> getTodoList() {
        return this.todoList;
    }

    @Nullable
    public final String getTranscript() {
        return this.transcript;
    }

    @Nullable
    public final String getTranscriptTitle() {
        return this.transcriptTitle;
    }

    public final boolean isAIPickup() {
        return this.isAIPickup;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(@NotNull Parcel r10, @Nullable ClassLoader r11, int r12) {
        q.g(r10, "parcel");
        if (r12 != 1) goto L5;
        this.carriers = (List) r10.readValue(r11);
        return;
    L5:
        if (r12 != 2) goto L7;
        this.todoList = (List) r10.readValue(r11);
        return;
    L7:
        if (r12 != 3) goto L19;
        Object r13 = r10.readValue(r11);
        if ((r13 instanceof String) == false) goto L12;
        String r14 = (String) r13;
    L13:
        this.transcriptTitle = r14;
        return;
    L12:
        r14 = null;
        goto L13
    }

    public final void setAIPickup(boolean r10) {
        this.isAIPickup = r10;
    }

    public final void setCallType(@NotNull CallTypeEnum r10) {
        q.g(r10, "<set-?>");
        this.callType = r10;
    }

    public final void setCarriers(@Nullable List<String> r10) {
        this.carriers = r10;
    }

    public final void setContacts(@Nullable List<ContactEntity> r10) {
        this.contacts = r10;
    }

    public final void setDuration(int r10) {
        this.duration = r10;
    }

    public final void setHasTranscript(boolean r10) {
        this.hasTranscript = r10;
    }

    public final void setTag(@Nullable String r10) {
        this.tag = r10;
    }

    public final void setTelephones(@NotNull List<String> r10) {
        q.g(r10, "<set-?>");
        this.telephones = r10;
    }

    public final void setTodoList(@Nullable List<String> r10) {
        this.todoList = r10;
    }

    public final void setTranscript(@Nullable String r10) {
        this.transcript = r10;
    }

    public final void setTranscriptTitle(@Nullable String r10) {
        this.transcriptTitle = r10;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        q.g(r10, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeStringList(this.telephones);
        r10.writeTypedList(this.contacts);
        r10.writeString(this.callType.name());
        r10.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r10);
        r10.writeInt(3);
        r10.writeString(this.tag);
        EntityExtKt.g(r10, this.isAIPickup);
        EntityExtKt.g(r10, this.hasTranscript);
        r10.writeString(this.transcript);
        r10.writeValue(this.carriers);
        r10.writeValue(this.todoList);
        r10.writeValue(this.transcriptTitle);
    }

    public CallHistoryEntity(@NotNull String r11, long r12, long r14, @NotNull List<String> r16, @Nullable List<ContactEntity> r17, @NotNull CallTypeEnum r18, int r19) {
        q.g(r11, "id");
        q.g(r16, "telephones");
        q.g(r18, "callType");
        super(r11, r12, r14, 202);
        this.telephones = r16;
        this.contacts = r17;
        this.callType = r18;
        this.duration = r19;
    }

    public /* synthetic */ CallHistoryEntity(String r12, long r13, long r15, List r17, List r18, CallTypeEnum r19, int r20, int r21, DefaultConstructorMarker r22) {
        if ((r21 & 16) == 0) goto L5;
        List r10 = null;
    L7:
        if ((r21 & 64) == 0) goto L9;
        int r11 = 0;
    L10:
        this(r12, r13, r15, r17, r10, r19, r11);
        return;
    L9:
        r11 = r20;
        goto L10
    L5:
        r10 = r18;
        goto L7
    }
}
