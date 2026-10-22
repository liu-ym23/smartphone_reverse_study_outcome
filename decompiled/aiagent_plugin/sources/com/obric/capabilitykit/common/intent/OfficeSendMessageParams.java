package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.p;
import d.h.b.h;
import d.h.b.o;
import java.util.List;

/* JADX INFO: compiled from: OfficeSendMessageParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class OfficeSendMessageParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<OfficeSendMessageParams> CREATOR = null;
    private OfficeMessageContent content;
    private String target;
    private String targetId;
    private String targetType;
    Integer version;

    /* JADX INFO: compiled from: OfficeSendMessageParams.kt */
    public static final class Creator implements Parcelable.Creator<OfficeSendMessageParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSendMessageParams createFromParcel(Parcel r12) {
            int r0 = r12.readInt();
            o.e(r12, "parcel");
            String r3 = r12.readString();
            String r4 = r12.readString();
            String r5 = r12.readString();
            if (r12.readInt() != 0) goto L5;
            OfficeMessageContent r2 = null;
        L6:
            OfficeSendMessageParams r1 = new OfficeSendMessageParams(r3, r4, r5, (OfficeMessageContent) ZeusTransformUtils.preCheckCast(r2, OfficeMessageContent.class, "com.obric.aiagent.plugin"), null, 16, null);
            int r6 = Math.min(r0, 1);
            ClassLoader r11 = getClass().getClassLoader();
            int r7 = 1;
        L7:
            if (r7 > r6) goto L13;
            if (r7 != 1) goto L12;
            Object r8 = a.b(r12, r11);
            if (r8 == null) goto L12;
            r1.version = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.aiagent.plugin");
        L12:
            r7 = r7 + 1;
        L13:
            if (r7 > r0) goto L15;
            a.a(r12, r11);
            r7 = r7 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r2 = OfficeMessageContent.CREATOR.createFromParcel(r12);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSendMessageParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final OfficeSendMessageParams[] newArray(int r1) {
            return new OfficeSendMessageParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ OfficeSendMessageParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    public OfficeSendMessageParams() {
        this(null, null, null, null, null, 31, null);
    }

    public static /* synthetic */ OfficeSendMessageParams copy$default(OfficeSendMessageParams r3, String r4, String r5, String r6, OfficeMessageContent r7, Integer r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.target;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.targetId;
    L8:
        String r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.targetType;
    L11:
        String r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.content;
    L14:
        OfficeMessageContent r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.version;
    L17:
        String r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public static /* synthetic */ void getVersion$annotations() {
    }

    public final String component1() {
        return this.target;
    }

    public final String component2() {
        return this.targetId;
    }

    public final String component3() {
        return this.targetType;
    }

    public final OfficeMessageContent component4() {
        return this.content;
    }

    public final Integer component5() {
        return this.version;
    }

    public final OfficeSendMessageParams copy(String r7, String r8, String r9, OfficeMessageContent r10, Integer r11) {
        return new OfficeSendMessageParams(r7, r8, r9, r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, OfficeSendMessageParams.class) == true) goto L8;
        return false;
    L8:
        OfficeSendMessageParams r6 = (OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r5, OfficeSendMessageParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.targetId, r6.targetId) == true) goto L15;
        return false;
    L15:
        if (o.a(this.targetType, r6.targetType) == true) goto L18;
        return false;
    L18:
        if (o.a(this.content, r6.content) == true) goto L21;
        return false;
    L21:
        if (o.a(this.version, r6.version) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        String r4 = this.targetId;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.targetType;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        OfficeMessageContent r10 = this.content;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.version;
        if (r13 == null) goto L23;
        r1 = r13.hashCode();
    L23:
        return r12 + r1;
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "OfficeSendMessageParams(target=" + this.target + ", targetId=" + this.targetId + ", targetType=" + this.targetType + ", content=" + this.content + ", version=" + this.version + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r3, int r4) {
        r3.writeInt(1);
        o.e(r3, "out");
        r3.writeString(this.target);
        r3.writeString(this.targetId);
        r3.writeString(this.targetType);
        OfficeMessageContent r1 = this.content;
        if (r1 != null) goto L5;
        r3.writeInt(0);
    L6:
        r3.writeValue(this.version);
        return;
    L5:
        r3.writeInt(1);
        r1.writeToParcel(r3, r4);
        goto L6
    }

    public OfficeSendMessageParams(String r1, String r2, String r3, OfficeMessageContent r4, Integer r5) {
        this.target = r1;
        this.targetId = r2;
        this.targetType = r3;
        this.content = r4;
        this.version = r5;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ OfficeSendMessageParams(String r2, String r3, String r4, OfficeMessageContent r5, Integer r6, int r7, h r8) {
        if ((r7 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r4 = null;
    L12:
        if ((r7 & 8) == 0) goto L15;
        r5 = null;
    L15:
        if ((r7 & 16) == 0) goto L17;
        r6 = null;
    L17:
        this(r2, r3, r4, r5, r6);
    }

    public final String getTarget() {
        return this.target;
    }

    public final void setTarget(String r1) {
        this.target = r1;
    }

    public final String getTargetId() {
        return this.targetId;
    }

    public final void setTargetId(String r1) {
        this.targetId = r1;
    }

    public final String getTargetType() {
        return this.targetType;
    }

    public final void setTargetType(String r1) {
        this.targetType = r1;
    }

    public final OfficeMessageContent getContent() {
        return this.content;
    }

    public final void setContent(OfficeMessageContent r1) {
        this.content = r1;
    }

    public final Integer getVersion() {
        return this.version;
    }

    public final void setVersion(Integer r1) {
        this.version = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r10) {
        if (ZeusTransformUtils.instanceOf(r10, OfficeSendMessageParams.class) == false) goto L5;
        String r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r10, OfficeSendMessageParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        String r4 = r1;
        String r2 = this.targetId;
        if (r2 != null) goto L12;
        r2 = ((OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r10, OfficeSendMessageParams.class, "com.obric.aiagent.plugin")).targetId;
    L12:
        String r5 = r2;
        String r3 = this.targetType;
        if (r3 != null) goto L15;
        r3 = ((OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r10, OfficeSendMessageParams.class, "com.obric.aiagent.plugin")).targetType;
    L15:
        String r6 = r3;
        OfficeMessageContent r7 = this.content;
        if (r7 != null) goto L18;
        r7 = ((OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r10, OfficeSendMessageParams.class, "com.obric.aiagent.plugin")).content;
    L18:
        OfficeMessageContent r8 = r7;
        Integer r9 = this.version;
        if (r9 != null) goto L22;
        r9 = ((OfficeSendMessageParams) ZeusTransformUtils.preCheckCast(r10, OfficeSendMessageParams.class, "com.obric.aiagent.plugin")).version;
    L22:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new OfficeSendMessageParams(r4, r5, r6, r8, r9), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.content);
    }
}
