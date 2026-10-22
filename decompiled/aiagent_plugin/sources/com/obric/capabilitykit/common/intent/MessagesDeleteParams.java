package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.a.a;
import com.obric.capabilitykit.entity.app.MessageEntity;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.Arrays;

/* JADX INFO: compiled from: MessagesDeleteParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MessagesDeleteParams implements Parcelable, IntentParams {
    public static final Parcelable.Creator<MessagesDeleteParams> CREATOR = null;
    private MessageEntity[] targets;

    /* JADX INFO: compiled from: MessagesDeleteParams.kt */
    public static final class Creator implements Parcelable.Creator<MessagesDeleteParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessagesDeleteParams createFromParcel(Parcel r9) {
            int r0 = r9.readInt();
            o.e(r9, "parcel");
            if (r9.readInt() != 0) goto L5;
            MessageEntity[] r1 = null;
        L9:
            MessagesDeleteParams r3 = new MessagesDeleteParams(r1);
            int r2 = Math.min(r0, 0);
            ClassLoader r8 = getClass().getClassLoader();
            int r4 = 1;
        L10:
            if (r4 > r2) goto L12;
            r4 = r4 + 1;
        L12:
            if (r4 > r0) goto L14;
            a.a(r9, r8);
            r4 = r4 + 1;
            goto L12
        L14:
            return r3;
        L5:
            int r5 = r9.readInt();
            MessageEntity[] r6 = new MessageEntity[r5];
            int r7 = 0;
        L6:
            if (r7 == r5) goto L8;
            r6[r7] = (MessageEntity) ZeusTransformUtils.preCheckCast(r9.readParcelable(MessagesDeleteParams.class.getClassLoader()), MessageEntity.class, "com.obric.aiagent.plugin");
            r7 = r7 + 1;
            goto L6
        L8:
            r1 = r6;
            goto L9
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessagesDeleteParams createFromParcel(Parcel r1) {
            return createFromParcel(r1);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessagesDeleteParams[] newArray(int r1) {
            return new MessagesDeleteParams[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessagesDeleteParams[] newArray(int r1) {
            return newArray(r1);
        }
    }

    static {
        CREATOR = (Parcelable.Creator) ZeusTransformUtils.preCheckCast(new Creator(), Parcelable.Creator.class, "com.obric.aiagent.plugin");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessagesDeleteParams() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessagesDeleteParams copy$default(MessagesDeleteParams r0, MessageEntity[] r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L6;
        r1 = r0.targets;
    L6:
        return r0.copy(r1);
    }

    public final MessageEntity[] component1() {
        return this.targets;
    }

    public final MessagesDeleteParams copy(MessageEntity[] r1) {
        return new MessagesDeleteParams(r1);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (ZeusTransformUtils.instanceOf(r5, MessagesDeleteParams.class) == true) goto L8;
        return false;
    L8:
        MessagesDeleteParams r6 = (MessagesDeleteParams) ZeusTransformUtils.preCheckCast(r5, MessagesDeleteParams.class, "com.obric.aiagent.plugin");
        if (o.a(this.targets, r6.targets) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        MessageEntity[] r0 = this.targets;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return Arrays.hashCode(r0);
    }

    public String toString() {
        return "MessagesDeleteParams(targets=" + Arrays.toString(this.targets) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r6, int r7) {
        int r0 = 0;
        r6.writeInt(0);
        o.e(r6, "out");
        MessageEntity[] r5 = this.targets;
        if (r5 != null) goto L5;
        r6.writeInt(0);
        return;
    L5:
        r6.writeInt(1);
        int r1 = r5.length;
        r6.writeInt(r1);
    L6:
        if (r0 == r1) goto L10;
        r6.writeParcelable((Parcelable) ZeusTransformUtils.preCheckCast(r5[r0], Parcelable.class, "com.obric.aiagent.plugin"), r7);
        r0 = r0 + 1;
        goto L6
    }

    public MessagesDeleteParams(MessageEntity[] r1) {
        this.targets = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public String getSubActionValue() {
        return IntentParams.a.b(this);
    }

    public /* synthetic */ MessagesDeleteParams(MessageEntity[] r1, int r2, h r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = null;
    L5:
        this(r1);
    }

    public final MessageEntity[] getTargets() {
        return this.targets;
    }

    public final void setTargets(MessageEntity[] r1) {
        this.targets = r1;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        if (this.targets == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public IntentParams mergeParams(Object r4) {
        if (ZeusTransformUtils.instanceOf(r4, MessagesDeleteParams.class) == false) goto L5;
        MessageEntity[] r3 = this.targets;
        if (r3 != null) goto L10;
        r3 = ((MessagesDeleteParams) ZeusTransformUtils.preCheckCast(r4, MessagesDeleteParams.class, "com.obric.aiagent.plugin")).targets;
    L10:
        return (IntentParams) ZeusTransformUtils.preCheckCast(new MessagesDeleteParams(r3), IntentParams.class, "com.obric.aiagent.plugin");
    L5:
        return (IntentParams) ZeusTransformUtils.preCheckCast(this, IntentParams.class, "com.obric.aiagent.plugin");
    }
}
