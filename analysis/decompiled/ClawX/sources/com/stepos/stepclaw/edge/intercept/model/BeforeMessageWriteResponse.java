package com.stepos.stepclaw.edge.intercept.model;

import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.BooleanSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0087\b\u0018\u0000 (2\u00020\u0001:\u0002()B\u001f\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J(\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u001cHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010\"\u001a\u00020\u00022\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\"\u0010#R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010$\u001a\u0004\b%\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010&\u001a\u0004\b'\u0010\u0019¨\u0006*"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeMessageWriteResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "block", "Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", OperationResult.EXTRA_MESSAGE, "<init>", "(Ljava/lang/Boolean;Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Boolean;Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/BeforeMessageWriteResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Boolean;", "component2", "()Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "copy", "(Ljava/lang/Boolean;Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;)Lcom/stepos/stepclaw/edge/intercept/model/BeforeMessageWriteResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Boolean;", "getBlock", "Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "getMessage", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class BeforeMessageWriteResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Boolean block;
    private final MessageItem message;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tJ\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/BeforeMessageWriteResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "empty", "Lcom/stepos/stepclaw/edge/intercept/model/BeforeMessageWriteResponse;", "blocked", "modified", OperationResult.EXTRA_MESSAGE, "Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "serializer", "Lkotlinx/serialization/KSerializer;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BeforeMessageWriteResponse blocked() {
            return new BeforeMessageWriteResponse(Boolean.TRUE, (MessageItem) null, 2, (i) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BeforeMessageWriteResponse empty() {
            return new BeforeMessageWriteResponse((Boolean) null, (MessageItem) (0 == true ? 1 : 0), 3, (i) (0 == true ? 1 : 0));
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final BeforeMessageWriteResponse modified(MessageItem message) {
            p.e(message, "message");
            return new BeforeMessageWriteResponse((Boolean) null, message, 1, (i) (0 == true ? 1 : 0));
        }

        public final KSerializer<BeforeMessageWriteResponse> serializer() {
            return BeforeMessageWriteResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BeforeMessageWriteResponse() {
        this((Boolean) null, (MessageItem) (0 == true ? 1 : 0), 3, (i) (0 == true ? 1 : 0));
    }

    public static /* synthetic */ BeforeMessageWriteResponse copy$default(BeforeMessageWriteResponse beforeMessageWriteResponse, Boolean bool, MessageItem messageItem, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            bool = beforeMessageWriteResponse.block;
        }
        if ((i8 & 2) != 0) {
            messageItem = beforeMessageWriteResponse.message;
        }
        return beforeMessageWriteResponse.copy(bool, messageItem);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(BeforeMessageWriteResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.block != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, BooleanSerializer.INSTANCE, self.block);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && self.message == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 1, MessageItem$$serializer.INSTANCE, self.message);
    }

    /* renamed from: component1, reason: from getter */
    public final Boolean getBlock() {
        return this.block;
    }

    /* renamed from: component2, reason: from getter */
    public final MessageItem getMessage() {
        return this.message;
    }

    public final BeforeMessageWriteResponse copy(Boolean block, MessageItem message) {
        return new BeforeMessageWriteResponse(block, message);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BeforeMessageWriteResponse)) {
            return false;
        }
        BeforeMessageWriteResponse beforeMessageWriteResponse = (BeforeMessageWriteResponse) other;
        return p.a(this.block, beforeMessageWriteResponse.block) && p.a(this.message, beforeMessageWriteResponse.message);
    }

    public final Boolean getBlock() {
        return this.block;
    }

    public final MessageItem getMessage() {
        return this.message;
    }

    public int hashCode() {
        Boolean bool = this.block;
        int iHashCode = (bool == null ? 0 : bool.hashCode()) * 31;
        MessageItem messageItem = this.message;
        return iHashCode + (messageItem != null ? messageItem.hashCode() : 0);
    }

    public String toString() {
        return "BeforeMessageWriteResponse(block=" + this.block + ", message=" + this.message + ")";
    }

    public /* synthetic */ BeforeMessageWriteResponse(int i8, Boolean bool, MessageItem messageItem, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.block = null;
        } else {
            this.block = bool;
        }
        if ((i8 & 2) == 0) {
            this.message = null;
        } else {
            this.message = messageItem;
        }
    }

    public BeforeMessageWriteResponse(Boolean bool, MessageItem messageItem) {
        this.block = bool;
        this.message = messageItem;
    }

    public /* synthetic */ BeforeMessageWriteResponse(Boolean bool, MessageItem messageItem, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : bool, (i8 & 2) != 0 ? null : messageItem);
    }
}
