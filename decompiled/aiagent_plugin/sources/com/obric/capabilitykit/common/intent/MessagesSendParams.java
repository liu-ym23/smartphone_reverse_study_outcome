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

/* JADX INFO: compiled from: MessagesSendParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MessagesSendParams implements Parcelable, IUriSharableParams, IntentParams {
    public static final Parcelable.Creator<MessagesSendParams> CREATOR = null;
    private MessageContent content;
    private ContactTarget target;

    /* JADX INFO: compiled from: MessagesSendParams.kt */
    public static final class Creator implements Parcelable.Creator<MessagesSendParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessagesSendParams createFromParcel(Parcel r7) {
            int r0 = r7.readInt();
            o.e(r7, "parcel");
            MessageContent r3 = null;
            if (r7.readInt() != 0) goto L5;
            ContactTarget r2 = null;
        L6:
            ContactTarget r4 = (ContactTarget) ZeusTransformUtils.preCheckCast(r2, ContactTarget.class, "com.obric.aiagent.plugin");
            if (r7.readInt() == 0) goto L10;
            r3 = MessageContent.CREATOR.createFromParcel(r7);
        L10:
            MessagesSendParams r1 = new MessagesSendParams(r4, (MessageContent) ZeusTransformUtils.preCheckCast(r3, MessageContent.class, "com.obric.aiagent.plugin"));
            int r5 = Math.min(r0, 0);
            ClassLoader r6 = getClass().getClassLoader();
            int r8 = 1;
        L11:
            if (r8 > r5) goto L13;
            r8 = r8 + 1;
        L13:
            if (r8 > r0) goto L15;
            a.a(r7, r6);
            r8 = r8 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r2 = ContactTarget.CREATOR.createFromParcel(r7);
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessagesSendParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessagesSendParams[] newArray(int r1) {
            return new MessagesSendParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessagesSendParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessagesSendParams() {
        Object[] r0 = 0 == true ? 1 : 0;
        this(null, r0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessagesSendParams copy$default(MessagesSendParams r0, ContactTarget r1, MessageContent r2, int r3, Object r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = r0.target;
    L6:
        if ((r3 & 2) == 0) goto L9;
        r2 = r0.content;
    L9:
        return r0.copy(r1, r2);
    }

    public final ContactTarget component1() {
        return this.target;
    }

    public final MessageContent component2() {
        return this.content;
    }

    public final MessagesSendParams copy(ContactTarget r1, MessageContent r2) {
        return new MessagesSendParams(r1, r2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MessagesSendParams.class) == true) goto L8;
        return false;
    L8:
        MessagesSendParams r6 = (MessagesSendParams) ZeusTransformUtils.preCheckCast(r5, MessagesSendParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (o.a(this.content, r6.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        ContactTarget r0 = this.target;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        MessageContent r4 = this.content;
        if (r4 == null) goto L11;
        r1 = r4.hashCode();
    L11:
        return r3 + r1;
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "MessagesSendParams(target=" + this.target + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r4, int r5) {
        r4.writeInt(0);
        o.e(r4, "out");
        ContactTarget r1 = this.target;
        if (r1 != null) goto L5;
        r4.writeInt(0);
    L6:
        MessageContent r3 = this.content;
        if (r3 != null) goto L9;
        r4.writeInt(0);
        return;
    L9:
        r4.writeInt(1);
        r3.writeToParcel(r4, r5);
        return;
    L5:
        r4.writeInt(1);
        r1.writeToParcel(r4, r5);
        goto L6
    }

    public MessagesSendParams(ContactTarget r1, MessageContent r2) {
        this.target = r1;
        this.content = r2;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.a.a(this);
    }

    public /* synthetic */ MessagesSendParams(ContactTarget r2, MessageContent r3, int r4, h r5) {
        if ((r4 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 2) == 0) goto L8;
        r3 = null;
    L8:
        this(r2, r3);
    }

    public final ContactTarget getTarget() {
        return this.target;
    }

    public final void setTarget(ContactTarget r1) {
        this.target = r1;
    }

    public final MessageContent getContent() {
        return this.content;
    }

    public final void setContent(MessageContent r1) {
        this.content = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, MessagesSendParams.class) == false) goto L5;
        ContactTarget r1 = this.target;
        if (r1 != null) goto L9;
        r1 = ((MessagesSendParams) ZeusTransformUtils.preCheckCast(r4, MessagesSendParams.class, "com.obric.aiagent.plugin")).target;
    L9:
        MessageContent r3 = this.content;
        if (r3 != null) goto L13;
        r3 = ((MessagesSendParams) ZeusTransformUtils.preCheckCast(r4, MessagesSendParams.class, "com.obric.aiagent.plugin")).content;
    L13:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new MessagesSendParams(r1, r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return p.a(this.content);
    }
}
