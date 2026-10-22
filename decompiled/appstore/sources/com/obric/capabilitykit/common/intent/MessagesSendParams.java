package com.obric.capabilitykit.common.intent;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import be.a;
import com.bytedanceos.common.model.AppInfo;
import com.bytedanceos.common.toolbox.ServerElements;
import com.obric.capabilitykit.common.execution.urishare.IUriSharableParams;
import com.obric.versionedparcelable.VersionedParcelable;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.s;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Parcelize
@Keep
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0007HÆ\u0003J!\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019HÖ\u0003J\u0010\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u001bH\u0016J\t\u0010\u001c\u001a\u00020\u0015HÖ\u0001J\u0012\u0010\u001d\u001a\u00020\u00012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0016J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\u0019\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020\u0015HÖ\u0001R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006&"}, d2 = {"Lcom/obric/capabilitykit/common/intent/MessagesSendParams;", "Lcom/obric/capabilitykit/common/intent/IntentParams;", "Landroid/os/Parcelable;", "Lcom/obric/capabilitykit/common/execution/urishare/IUriSharableParams;", "target", "Lcom/obric/capabilitykit/common/intent/ContactTarget;", ServerElements.CONTENT, "Lcom/obric/capabilitykit/common/intent/MessageContent;", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;Lcom/obric/capabilitykit/common/intent/MessageContent;)V", "getContent", "()Lcom/obric/capabilitykit/common/intent/MessageContent;", "setContent", "(Lcom/obric/capabilitykit/common/intent/MessageContent;)V", "getTarget", "()Lcom/obric/capabilitykit/common/intent/ContactTarget;", "setTarget", "(Lcom/obric/capabilitykit/common/intent/ContactTarget;)V", "component1", "component2", "copy", "describeContents", "", "equals", "", AppInfo.SEARCH_SOURCE_EXTENAL, "", "getUriSharableParams", "", "hashCode", "mergeParams", "params", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "intentcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class MessagesSendParams implements IntentParams, Parcelable, IUriSharableParams {

    @NotNull
    public static final Parcelable.Creator<MessagesSendParams> CREATOR = null;

    @Nullable
    private MessageContent content;

    @Nullable
    private ContactTarget target;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class Creator implements Parcelable.Creator<MessagesSendParams> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MessagesSendParams createFromParcel(@NotNull Parcel r10) {
            int r11 = r10.readInt();
            q.g(r10, "parcel");
            MessageContent r12 = null;
            if (r10.readInt() != 0) goto L5;
            ContactTarget r13 = null;
        L6:
            ContactTarget r14 = r13;
            if (r10.readInt() == 0) goto L10;
            r12 = MessageContent.CREATOR.createFromParcel(r10);
        L10:
            MessagesSendParams r15 = new MessagesSendParams(r14, r12);
            int r16 = Math.min(r11, 0);
            ClassLoader r17 = Creator.class.getClassLoader();
            int r18 = 1;
        L11:
            if (r18 > r16) goto L13;
            r18 = r18 + 1;
        L13:
            if (r18 > r11) goto L15;
            a.d(r10, r17);
            r18 = r18 + 1;
            goto L13
        L15:
            return r15;
        L5:
            r13 = ContactTarget.CREATOR.createFromParcel(r10);
            goto L6
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @NotNull
        public final MessagesSendParams[] newArray(int r10) {
            return new MessagesSendParams[r10];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessagesSendParams createFromParcel(Parcel r10) {
            return createFromParcel(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ MessagesSendParams[] newArray(int r10) {
            return newArray(r10);
        }
    }

    static {
        CREATOR = new Creator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MessagesSendParams() {
        Object[] r10 = 0 == true ? 1 : 0;
        this(null, r10, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ MessagesSendParams copy$default(MessagesSendParams r10, ContactTarget r11, MessageContent r12, int r13, Object r14) {
        if ((r13 & 1) == 0) goto L6;
        r11 = r10.target;
    L6:
        if ((r13 & 2) == 0) goto L9;
        r12 = r10.content;
    L9:
        return r10.copy(r11, r12);
    }

    @Nullable
    public final ContactTarget component1() {
        return this.target;
    }

    @Nullable
    public final MessageContent component2() {
        return this.content;
    }

    @NotNull
    public final MessagesSendParams copy(@Nullable ContactTarget r10, @Nullable MessageContent r11) {
        return new MessagesSendParams(r10, r11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof MessagesSendParams) == true) goto L8;
        return false;
    L8:
        MessagesSendParams r11 = (MessagesSendParams) r10;
        if (q.b(this.target, r11.target) == true) goto L12;
        return false;
    L12:
        if (q.b(this.content, r11.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Nullable
    public final MessageContent getContent() {
        return this.content;
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @Nullable
    public String getSubActionValue() {
        return IntentParams.DefaultImpls.getSubActionValue(this);
    }

    @Nullable
    public final ContactTarget getTarget() {
        return this.target;
    }

    @Override // com.obric.capabilitykit.common.execution.urishare.IUriSharableParams
    @NotNull
    public List<Object> getUriSharableParams() {
        return s.e(this.content);
    }

    public int hashCode() {
        ContactTarget r10 = this.target;
        int r11 = 0;
        if (r10 != null) goto L5;
        int r12 = 0;
    L6:
        int r13 = r12 * 31;
        MessageContent r14 = this.content;
        if (r14 == null) goto L11;
        r11 = r14.hashCode();
    L11:
        return r13 + r11;
    L5:
        r12 = r10.hashCode();
        goto L6
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    public boolean isParamsCompleted() {
        return IntentParams.DefaultImpls.isParamsCompleted(this);
    }

    @Override // com.obric.capabilitykit.common.intent.IntentParams
    @NotNull
    public IntentParams mergeParams(@Nullable Object r10) {
        if ((r10 instanceof MessagesSendParams) == true) goto L5;
        return this;
    L5:
        ContactTarget r11 = this.target;
        if (r11 != null) goto L8;
        r11 = ((MessagesSendParams) r10).target;
    L8:
        MessageContent r12 = this.content;
        if (r12 != null) goto L12;
        r12 = ((MessagesSendParams) r10).content;
    L12:
        return new MessagesSendParams(r11, r12);
    }

    public final void setContent(@Nullable MessageContent r10) {
        this.content = r10;
    }

    public final void setTarget(@Nullable ContactTarget r10) {
        this.target = r10;
    }

    @NotNull
    public String toString() {
        return "MessagesSendParams(target=" + this.target + ", content=" + this.content + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(0);
        q.g(r10, "out");
        ContactTarget r12 = this.target;
        if (r12 != null) goto L5;
        r10.writeInt(0);
    L6:
        MessageContent r13 = this.content;
        if (r13 != null) goto L9;
        r10.writeInt(0);
        return;
    L9:
        r10.writeInt(1);
        r13.writeToParcel(r10, r11);
        return;
    L5:
        r10.writeInt(1);
        r12.writeToParcel(r10, r11);
        goto L6
    }

    public MessagesSendParams(@Nullable ContactTarget r10, @Nullable MessageContent r11) {
        this.target = r10;
        this.content = r11;
    }

    public /* synthetic */ MessagesSendParams(ContactTarget r10, MessageContent r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 1) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 2) == 0) goto L8;
        r11 = null;
    L8:
        this(r10, r11);
    }
}
