package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import k4.r;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\b\u0087\b\u0018\u0000 +2\u00020\u0001:\u0002,+B)\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\b\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ4\u0010\u001d\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001f\u0010\u001bJ\u0010\u0010 \u001a\u00020\nHÖ\u0001¢\u0006\u0004\b \u0010!J\u001a\u0010$\u001a\u00020#2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b$\u0010%R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010&\u001a\u0004\b'\u0010\u0019R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010(\u001a\u0004\b)\u0010\u001bR\u0017\u0010\u0007\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b*\u0010\u001b¨\u0006-"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem;", "messages", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "model_name", "api_token", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/util/List;", "component2", "()Ljava/lang/String;", "component3", "copy", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/util/List;", "getMessages", "Ljava/lang/String;", "getModel_name", "getApi_token", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineTriggerFirstRequest {
    private final String api_token;
    private final List<OfflineTriggerMessageItem> messages;
    private final String model_name;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {h.w(f.f889a, new r(28)), null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerFirstRequest;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineTriggerFirstRequest> serializer() {
            return OfflineTriggerFirstRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OfflineTriggerFirstRequest(int i8, List list, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (1 != (i8 & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 1, OfflineTriggerFirstRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.messages = list;
        if ((i8 & 2) == 0) {
            this.model_name = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.model_name = str;
        }
        if ((i8 & 4) == 0) {
            this.api_token = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.api_token = str2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(OfflineTriggerMessageItem$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflineTriggerFirstRequest copy$default(OfflineTriggerFirstRequest offlineTriggerFirstRequest, List list, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            list = offlineTriggerFirstRequest.messages;
        }
        if ((i8 & 2) != 0) {
            str = offlineTriggerFirstRequest.model_name;
        }
        if ((i8 & 4) != 0) {
            str2 = offlineTriggerFirstRequest.api_token;
        }
        return offlineTriggerFirstRequest.copy(list, str, str2);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineTriggerFirstRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeSerializableElement(serialDesc, 0, (SerializationStrategy) $childSerializers[0].getValue(), self.messages);
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.model_name, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.model_name);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && p.a(self.api_token, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            return;
        }
        output.encodeStringElement(serialDesc, 2, self.api_token);
    }

    public final List<OfflineTriggerMessageItem> component1() {
        return this.messages;
    }

    /* renamed from: component2, reason: from getter */
    public final String getModel_name() {
        return this.model_name;
    }

    /* renamed from: component3, reason: from getter */
    public final String getApi_token() {
        return this.api_token;
    }

    public final OfflineTriggerFirstRequest copy(List<OfflineTriggerMessageItem> messages, String model_name, String api_token) {
        p.e(messages, "messages");
        p.e(model_name, "model_name");
        p.e(api_token, "api_token");
        return new OfflineTriggerFirstRequest(messages, model_name, api_token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineTriggerFirstRequest)) {
            return false;
        }
        OfflineTriggerFirstRequest offlineTriggerFirstRequest = (OfflineTriggerFirstRequest) other;
        return p.a(this.messages, offlineTriggerFirstRequest.messages) && p.a(this.model_name, offlineTriggerFirstRequest.model_name) && p.a(this.api_token, offlineTriggerFirstRequest.api_token);
    }

    public final String getApi_token() {
        return this.api_token;
    }

    public final List<OfflineTriggerMessageItem> getMessages() {
        return this.messages;
    }

    public final String getModel_name() {
        return this.model_name;
    }

    public int hashCode() {
        return this.api_token.hashCode() + b.f(this.messages.hashCode() * 31, 31, this.model_name);
    }

    public String toString() {
        List<OfflineTriggerMessageItem> list = this.messages;
        String str = this.model_name;
        String str2 = this.api_token;
        StringBuilder sb = new StringBuilder("OfflineTriggerFirstRequest(messages=");
        sb.append(list);
        sb.append(", model_name=");
        sb.append(str);
        sb.append(", api_token=");
        return m0.f.f(sb, str2, ")");
    }

    public OfflineTriggerFirstRequest(List<OfflineTriggerMessageItem> messages, String model_name, String api_token) {
        p.e(messages, "messages");
        p.e(model_name, "model_name");
        p.e(api_token, "api_token");
        this.messages = messages;
        this.model_name = model_name;
        this.api_token = api_token;
    }

    public /* synthetic */ OfflineTriggerFirstRequest(List list, String str, String str2, int i8, i iVar) {
        this(list, (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2);
    }
}
