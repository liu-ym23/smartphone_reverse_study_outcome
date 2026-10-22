package com.stepos.stepclaw.edge.intercept.model;

import a.a;
import b5.h;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonElementSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*)B\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007B/\b\u0010\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u0006\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0010\u0010\u0016\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J$\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u001c\u0010\u0017J\u0010\u0010\u001d\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u001a\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b!\u0010\"R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010#\u001a\u0004\b$\u0010\u0017R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010%\u001a\u0004\b&\u0010\u0019R\u0011\u0010(\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b'\u0010\u0017¨\u0006+"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "role", "Lkotlinx/serialization/json/JsonElement;", "content", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Lkotlinx/serialization/json/JsonElement;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Lkotlinx/serialization/json/JsonElement;", "copy", "(Ljava/lang/String;Lkotlinx/serialization/json/JsonElement;)Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getRole", "Lkotlinx/serialization/json/JsonElement;", "getContent", "getContentText", "contentText", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class MessageItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final JsonElement content;
    private final String role;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/MessageItem$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/MessageItem;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<MessageItem> serializer() {
            return MessageItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ MessageItem(int i8, String str, JsonElement jsonElement, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i8 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 1, MessageItem$$serializer.INSTANCE.getDescriptor());
        }
        this.role = str;
        if ((i8 & 2) == 0) {
            this.content = JsonElementKt.JsonPrimitive(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID);
        } else {
            this.content = jsonElement;
        }
    }

    public static /* synthetic */ MessageItem copy$default(MessageItem messageItem, String str, JsonElement jsonElement, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = messageItem.role;
        }
        if ((i8 & 2) != 0) {
            jsonElement = messageItem.content;
        }
        return messageItem.copy(str, jsonElement);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(MessageItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.role);
        if (!output.shouldEncodeElementDefault(serialDesc, 1) && p.a(self.content, JsonElementKt.JsonPrimitive(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID))) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 1, JsonElementSerializer.INSTANCE, self.content);
    }

    /* renamed from: component1, reason: from getter */
    public final String getRole() {
        return this.role;
    }

    /* renamed from: component2, reason: from getter */
    public final JsonElement getContent() {
        return this.content;
    }

    public final MessageItem copy(String role, JsonElement content) {
        p.e(role, "role");
        p.e(content, "content");
        return new MessageItem(role, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MessageItem)) {
            return false;
        }
        MessageItem messageItem = (MessageItem) other;
        return p.a(this.role, messageItem.role) && p.a(this.content, messageItem.content);
    }

    public final JsonElement getContent() {
        return this.content;
    }

    public final String getContentText() {
        Object objO;
        try {
            objO = JsonElementKt.getJsonPrimitive(this.content).getContent();
        } catch (Throwable th) {
            objO = a.o(th);
        }
        if (objO instanceof h) {
            objO = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        }
        return (String) objO;
    }

    public final String getRole() {
        return this.role;
    }

    public int hashCode() {
        return this.content.hashCode() + (this.role.hashCode() * 31);
    }

    public String toString() {
        return "MessageItem(role=" + this.role + ", content=" + this.content + ")";
    }

    public MessageItem(String role, JsonElement content) {
        p.e(role, "role");
        p.e(content, "content");
        this.role = role;
        this.content = content;
    }

    public /* synthetic */ MessageItem(String str, JsonElement jsonElement, int i8, i iVar) {
        this(str, (i8 & 2) != 0 ? JsonElementKt.JsonPrimitive(SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID) : jsonElement);
    }
}
