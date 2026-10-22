package com.stepos.stepclaw.edge.intercept.model;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import m0.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002)*B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bB9\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0018J4\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u0018J\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\u00042\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0018R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u001aR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010$\u001a\u0004\b(\u0010\u0018¨\u0006+"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/MessageSendingResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cancel", "hint", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/MessageSendingResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Ljava/lang/Boolean;", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/stepos/stepclaw/edge/intercept/model/MessageSendingResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContent", "Ljava/lang/Boolean;", "getCancel", "getHint", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class MessageSendingResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean cancel;
    private final String content;
    private final String hint;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\bJ\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/MessageSendingResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "empty", "Lcom/stepos/stepclaw/edge/intercept/model/MessageSendingResponse;", "withHint", "hint", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cancelled", "modified", "content", "serializer", "Lkotlinx/serialization/KSerializer;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final MessageSendingResponse cancelled() {
            return new MessageSendingResponse((String) null, Boolean.TRUE, (String) null, 5, (i) null);
        }

        public final MessageSendingResponse empty() {
            return new MessageSendingResponse((String) null, (Boolean) null, (String) null, 7, (i) null);
        }

        public final MessageSendingResponse modified(String content) {
            p.e(content, "content");
            return new MessageSendingResponse(content, (Boolean) null, (String) null, 6, (i) null);
        }

        public final KSerializer<MessageSendingResponse> serializer() {
            return MessageSendingResponse$$serializer.INSTANCE;
        }

        public final MessageSendingResponse withHint(String hint) {
            p.e(hint, "hint");
            return new MessageSendingResponse((String) null, (Boolean) null, hint, 3, (i) null);
        }

        private Companion() {
        }
    }

    public MessageSendingResponse() {
        this((String) null, (Boolean) null, (String) null, 7, (i) null);
    }

    public static /* synthetic */ MessageSendingResponse copy$default(MessageSendingResponse messageSendingResponse, String str, Boolean bool, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = messageSendingResponse.content;
        }
        if ((i8 & 2) != 0) {
            bool = messageSendingResponse.cancel;
        }
        if ((i8 & 4) != 0) {
            str2 = messageSendingResponse.hint;
        }
        return messageSendingResponse.copy(str, bool, str2);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(MessageSendingResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.content != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, StringSerializer.INSTANCE, self.content);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.cancel != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, BooleanSerializer.INSTANCE, self.cancel);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && self.hint == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 2, StringSerializer.INSTANCE, self.hint);
    }

    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final Boolean getCancel() {
        return this.cancel;
    }

    /* renamed from: component3, reason: from getter */
    public final String getHint() {
        return this.hint;
    }

    public final MessageSendingResponse copy(String content, Boolean cancel, String hint) {
        return new MessageSendingResponse(content, cancel, hint);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageSendingResponse)) {
            return false;
        }
        MessageSendingResponse messageSendingResponse = (MessageSendingResponse) other;
        return p.a(this.content, messageSendingResponse.content) && p.a(this.cancel, messageSendingResponse.cancel) && p.a(this.hint, messageSendingResponse.hint);
    }

    public final Boolean getCancel() {
        return this.cancel;
    }

    public final String getContent() {
        return this.content;
    }

    public final String getHint() {
        return this.hint;
    }

    public int hashCode() {
        String str = this.content;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Boolean bool = this.cancel;
        int iHashCode2 = (iHashCode + (bool == null ? 0 : bool.hashCode())) * 31;
        String str2 = this.hint;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        String str = this.content;
        Boolean bool = this.cancel;
        String str2 = this.hint;
        StringBuilder sb = new StringBuilder("MessageSendingResponse(content=");
        sb.append(str);
        sb.append(", cancel=");
        sb.append(bool);
        sb.append(", hint=");
        return f.f(sb, str2, ")");
    }

    public /* synthetic */ MessageSendingResponse(int i8, String str, Boolean bool, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.content = null;
        } else {
            this.content = str;
        }
        if ((i8 & 2) == 0) {
            this.cancel = null;
        } else {
            this.cancel = bool;
        }
        if ((i8 & 4) == 0) {
            this.hint = null;
        } else {
            this.hint = str2;
        }
    }

    public MessageSendingResponse(String str, Boolean bool, String str2) {
        this.content = str;
        this.cancel = bool;
        this.hint = str2;
    }

    public /* synthetic */ MessageSendingResponse(String str, Boolean bool, String str2, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : str, (i8 & 2) != 0 ? null : bool, (i8 & 4) != 0 ? null : str2);
    }
}
