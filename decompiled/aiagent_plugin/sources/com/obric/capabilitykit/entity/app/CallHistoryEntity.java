package com.obric.capabilitykit.entity.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.bdturing.localstorage.DbHelper;
import com.obric.capabilitykit.entity.EntityExtKt;
import com.obric.capabilitykit.entity.enums.CallTypeEnum;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public final class CallHistoryEntity extends AppEntity {
    public static final CREATOR CREATOR = null;
    private static final int FIELD_VERSION = 4;
    private static final int RELATED_VERSION = 1;
    private CallTypeEnum callType;
    private List<String> carriers;
    private List<ContactEntity> contacts;
    private int duration;
    private boolean hasTranscript;
    private boolean isAIPickup;
    private String sourceNumber;
    private String tag;
    private List<String> telephones;
    private List<String> todoList;
    private String transcript;
    private String transcriptTitle;

    public static final class CREATOR implements Parcelable.Creator<CallHistoryEntity> {
        private CREATOR() {
        }

        public /* synthetic */ CREATOR(h r1) {
            this();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallHistoryEntity createFromParcel(Parcel r2) {
            o.e(r2, "parcel");
            AppEntity r1 = AppEntity.CREATOR.createFromParcel(r2);
            o.a(r1, "null cannot be cast to non-null type com.obric.capabilitykit.entity.app.CallHistoryEntity");
            return (CallHistoryEntity) ZeusTransformUtils.preCheckCast(r1, CallHistoryEntity.class, "com.obric.aiagent.plugin");
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        public final int getVersion() {
            return 5;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CallHistoryEntity[] newArray(int r1) {
            return new CallHistoryEntity[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CallHistoryEntity[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = new CREATOR(null);
    }

    public CallHistoryEntity(Parcel r12) {
        o.e(r12, "parcel");
        String r2 = EntityExtKt.a(r12);
        long r3 = r12.readLong();
        long r5 = r12.readLong();
        ArrayList<String> r0 = r12.createStringArrayList();
        if (r0 != null) goto L5;
        r0 = new ArrayList();
    L5:
        ArrayList<String> r7 = r0;
        ArrayList r8 = r12.createTypedArrayList(ContactEntity.CREATOR);
        CallTypeEnum r1 = CallTypeEnum.Companion.a(r12.readString());
        if (r1 != null) goto L8;
        r1 = CallTypeEnum.INCOMING_CALL_ANSWERED;
    L8:
        this(r2, r3, r5, r7, r8, r1, r12.readInt());
        readExtensionFieldFromParcel$capabilitykitcommon_release(r12);
        int r4 = r12.readInt();
        this.tag = r12.readString();
        this.isAIPickup = EntityExtKt.b(r12);
        this.hasTranscript = EntityExtKt.b(r12);
        this.transcript = r12.readString();
        readSubClassExtensionFieldFromParcel$capabilitykitcommon_release(r12, 4, r4);
    }

    public CallHistoryEntity(String r12, long r13, long r15, List<String> r17, List<ContactEntity> r18, CallTypeEnum r19, int r20) {
        List<String> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
        List<ContactEntity> r10 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        o.e(r12, DbHelper.COL_ID);
        o.e(r9, "telephones");
        o.e(r19, "callType");
        super(r12, r13, r15, 202);
        this.telephones = r9;
        this.contacts = r10;
        this.callType = r19;
        this.duration = r20;
    }

    public /* synthetic */ CallHistoryEntity(String r13, long r14, long r16, List r18, List r19, CallTypeEnum r20, int r21, int r22, h r23) {
        List r8 = (List) ZeusTransformUtils.wrapperContextForParams(r18, List.class, "com.obric.aiagent.plugin");
        List r0 = (List) ZeusTransformUtils.wrapperContextForParams(r19, List.class, "com.obric.aiagent.plugin");
        if ((r22 & 16) == 0) goto L5;
        r0 = null;
    L5:
        List r9 = r0;
        if ((r22 & 64) == 0) goto L8;
        int r11 = 0;
    L9:
        this(r13, r14, r16, r8, r9, r20, r11);
        return;
    L8:
        r11 = r21;
        goto L9
    }

    public final CallTypeEnum getCallType() {
        return this.callType;
    }

    public final List<String> getCarriers() {
        return this.carriers;
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
        List<String> r3 = this.carriers;
        if (r3 == null) goto L12;
        String r4 = (String) ZeusTransformUtils.preCheckCast(p.d(r3, 0), String.class, "com.obric.aiagent.plugin");
    L14:
        return new DisplayRepresentation(null, r5, r4, getLastModifiedTime());
    L12:
        r4 = null;
    L8:
        r2 = (String) ZeusTransformUtils.preCheckCast(this.telephones.get(0), String.class, "com.obric.aiagent.plugin");
        goto L9
    }

    public final int getDuration() {
        return this.duration;
    }

    public final boolean getHasTranscript() {
        return this.hasTranscript;
    }

    public final String getSourceNumber() {
        return this.sourceNumber;
    }

    public final String getTag() {
        return this.tag;
    }

    public final List<String> getTelephones() {
        return this.telephones;
    }

    public final List<String> getTodoList() {
        return this.todoList;
    }

    public final String getTranscript() {
        return this.transcript;
    }

    public final String getTranscriptTitle() {
        return this.transcriptTitle;
    }

    public final boolean isAIPickup() {
        return this.isAIPickup;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity
    public void onReadSubClassExtensionField(Parcel r4, ClassLoader r5, int r6) {
        o.e(r4, "parcel");
        if (r6 != 1) goto L5;
        this.carriers = (List) ZeusTransformUtils.preCheckCast(r4.readValue(r5), List.class, "com.obric.aiagent.plugin");
        return;
    L5:
        if (r6 == 2) goto L19;
        String r2 = null;
        if (r6 != 3) goto L9;
        Object r7 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r7, String.class) == false) goto L18;
        r2 = (String) ZeusTransformUtils.preCheckCast(r7, String.class, "com.obric.aiagent.plugin");
    L18:
        this.transcriptTitle = r2;
        return;
    L9:
        if (r6 != 4) goto L25;
        Object r8 = r4.readValue(r5);
        if (ZeusTransformUtils.instanceOf(r8, String.class) == false) goto L14;
        r2 = (String) ZeusTransformUtils.preCheckCast(r8, String.class, "com.obric.aiagent.plugin");
    L14:
        this.sourceNumber = r2;
        return;
    L25:
        return;
    L19:
        this.todoList = (List) ZeusTransformUtils.preCheckCast(r4.readValue(r5), List.class, "com.obric.aiagent.plugin");
    }

    public final void setAIPickup(boolean r1) {
        this.isAIPickup = r1;
    }

    public final void setCallType(CallTypeEnum r2) {
        o.e(r2, "<set-?>");
        this.callType = r2;
    }

    public final void setCarriers(List<String> r3) {
        this.carriers = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setContacts(List<ContactEntity> r3) {
        this.contacts = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setDuration(int r1) {
        this.duration = r1;
    }

    public final void setHasTranscript(boolean r1) {
        this.hasTranscript = r1;
    }

    public final void setSourceNumber(String r1) {
        this.sourceNumber = r1;
    }

    public final void setTag(String r1) {
        this.tag = r1;
    }

    public final void setTelephones(List<String> r3) {
        List<String> r4 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
        o.e(r4, "<set-?>");
        this.telephones = r4;
    }

    public final void setTodoList(List<String> r3) {
        this.todoList = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.aiagent.plugin");
    }

    public final void setTranscript(String r1) {
        this.transcript = r1;
    }

    public final void setTranscriptTitle(String r1) {
        this.transcriptTitle = r1;
    }

    @Override // com.obric.capabilitykit.entity.app.AppEntity, android.os.Parcelable
    public void writeToParcel(Parcel r1, int r2) {
        o.e(r1, "parcel");
        writeBaseFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeStringList(this.telephones);
        r1.writeTypedList(this.contacts);
        r1.writeString(this.callType.name());
        r1.writeInt(this.duration);
        writeExtensionFieldToParcel$capabilitykitcommon_release(r1);
        r1.writeInt(4);
        r1.writeString(this.tag);
        EntityExtKt.a(r1, this.isAIPickup);
        EntityExtKt.a(r1, this.hasTranscript);
        r1.writeString(this.transcript);
        r1.writeValue(this.carriers);
        r1.writeValue(this.todoList);
        r1.writeValue(this.transcriptTitle);
        r1.writeValue(this.sourceNumber);
    }
}
