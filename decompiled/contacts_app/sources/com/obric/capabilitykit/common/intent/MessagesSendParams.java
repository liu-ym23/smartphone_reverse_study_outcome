package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import com.obric.aikernel.sdk.ext.Params;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.versionedparcelable.ParcelUtils;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MessagesSendParams.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessagesSendParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/common/intent/ContactTarget;", Params.CONTENT, "Lcom/obric/capabilitykit/common/intent/MessageContent;", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;Lcom/obric/capabilitykit/common/intent/MessageContent;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/MessageContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/MessageContent;)V", "getTarget", "()Lcom/obric/capabilitykit/common/intent/ContactTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MessagesSendParams implements IntentParams, Parcelable, IUriSharableParams {
    public static final Parcelable.Creator<MessagesSendParams> CREATOR = null;
    private MessageContent content;
    private ContactTarget target;

    /* JADX INFO: compiled from: MessagesSendParams.kt */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MessagesSendParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final MessagesSendParams createFromParcel(Parcel r6) {
            int r0 = r6.readInt();
            Intrinsics.checkNotNullParameter(r6, "parcel");
            MessageContent r3 = null;
            if (r6.readInt() != 0) goto L5;
            ContactTarget r2 = null;
        L6:
            ContactTarget r4 = r2;
            if (r6.readInt() == 0) goto L10;
            r3 = MessageContent.CREATOR.createFromParcel(r6);
        L10:
            MessagesSendParams r1 = new MessagesSendParams(r4, r3);
            int r5 = Math.min(r0, 0);
            ClassLoader r7 = getClass().getClassLoader();
            int r8 = 1;
        L11:
            if (r8 > r5) goto L13;
            r8 = r8 + 1;
        L13:
            if (r8 > r0) goto L15;
            ParcelUtils.skipValueSafely(r6, r7);
            r8 = r8 + 1;
            goto L13
        L15:
            return r1;
        L5:
            r2 = ContactTarget.CREATOR.createFromParcel(r6);
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
        CREATOR = new Creator();
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
        if ((r5 instanceof MessagesSendParams) == true) goto L8;
        return false;
    L8:
        MessagesSendParams r6 = (MessagesSendParams) r5;
        if (Intrinsics.areEqual(this.target, r6.target) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r6.content) == true) goto L14;
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
        Intrinsics.checkNotNullParameter(r4, "out");
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
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    public /* synthetic */ MessagesSendParams(ContactTarget r2, MessageContent r3, int r4, DefaultConstructorMarker r5) {
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
    public IntentParams mergeParams(Object r2) {
        if ((r2 instanceof MessagesSendParams) == false) goto L5;
        ContactTarget r0 = this.target;
        if (r0 != null) goto L9;
        r0 = ((MessagesSendParams) r2).target;
    L9:
        MessageContent r1 = this.content;
        if (r1 != null) goto L13;
        r1 = ((MessagesSendParams) r2).content;
    L13:
        return new MessagesSendParams(r0, r1);
    L5:
        return this;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    public List<Object> getUriSharableParams() {
        return CollectionsKt.listOf(this.content);
    }
}
