package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
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
import q3.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0002\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0019\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u0010\u0010\u001d\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001d\u0010\u001aJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ>\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\b\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\u001aJ\u0010\u0010\"\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010&\u001a\u00020%2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010\u001aR\u001d\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006¢\u0006\f\n\u0004\b\u0006\u0010*\u001a\u0004\b+\u0010\u001cR\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010(\u001a\u0004\b,\u0010\u001aR\u0017\u0010\b\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010(\u001a\u0004\b-\u0010\u001a¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "unique_id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage;", "messages", "model_name", "api_token", "<init>", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()Ljava/util/List;", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getUnique_id", "Ljava/util/List;", "getMessages", "getModel_name", "getApi_token", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineUpdateFirstRequest {
    private final String api_token;
    private final List<OfflineUpdateGroupMessage> messages;
    private final String model_name;
    private final String unique_id;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, h.w(f.f889a, new a(0)), null, null};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateFirstRequest;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineUpdateFirstRequest> serializer() {
            return OfflineUpdateFirstRequest$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OfflineUpdateFirstRequest(int i8, String str, List list, String str2, String str3, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 3, OfflineUpdateFirstRequest$$serializer.INSTANCE.getDescriptor());
        }
        this.unique_id = str;
        this.messages = list;
        if ((i8 & 4) == 0) {
            this.model_name = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.model_name = str2;
        }
        if ((i8 & 8) == 0) {
            this.api_token = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.api_token = str3;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(OfflineUpdateGroupMessage$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflineUpdateFirstRequest copy$default(OfflineUpdateFirstRequest offlineUpdateFirstRequest, String str, List list, String str2, String str3, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = offlineUpdateFirstRequest.unique_id;
        }
        if ((i8 & 2) != 0) {
            list = offlineUpdateFirstRequest.messages;
        }
        if ((i8 & 4) != 0) {
            str2 = offlineUpdateFirstRequest.model_name;
        }
        if ((i8 & 8) != 0) {
            str3 = offlineUpdateFirstRequest.api_token;
        }
        return offlineUpdateFirstRequest.copy(str, list, str2, str3);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineUpdateFirstRequest self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        output.encodeStringElement(serialDesc, 0, self.unique_id);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) eVarArr[1].getValue(), self.messages);
        if (output.shouldEncodeElementDefault(serialDesc, 2) || !p.a(self.model_name, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 2, self.model_name);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && p.a(self.api_token, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            return;
        }
        output.encodeStringElement(serialDesc, 3, self.api_token);
    }

    /* renamed from: component1, reason: from getter */
    public final String getUnique_id() {
        return this.unique_id;
    }

    public final List<OfflineUpdateGroupMessage> component2() {
        return this.messages;
    }

    /* renamed from: component3, reason: from getter */
    public final String getModel_name() {
        return this.model_name;
    }

    /* renamed from: component4, reason: from getter */
    public final String getApi_token() {
        return this.api_token;
    }

    public final OfflineUpdateFirstRequest copy(String unique_id, List<OfflineUpdateGroupMessage> messages, String model_name, String api_token) {
        p.e(unique_id, "unique_id");
        p.e(messages, "messages");
        p.e(model_name, "model_name");
        p.e(api_token, "api_token");
        return new OfflineUpdateFirstRequest(unique_id, messages, model_name, api_token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineUpdateFirstRequest)) {
            return false;
        }
        OfflineUpdateFirstRequest offlineUpdateFirstRequest = (OfflineUpdateFirstRequest) other;
        return p.a(this.unique_id, offlineUpdateFirstRequest.unique_id) && p.a(this.messages, offlineUpdateFirstRequest.messages) && p.a(this.model_name, offlineUpdateFirstRequest.model_name) && p.a(this.api_token, offlineUpdateFirstRequest.api_token);
    }

    public final String getApi_token() {
        return this.api_token;
    }

    public final List<OfflineUpdateGroupMessage> getMessages() {
        return this.messages;
    }

    public final String getModel_name() {
        return this.model_name;
    }

    public final String getUnique_id() {
        return this.unique_id;
    }

    public int hashCode() {
        return this.api_token.hashCode() + b.f((this.messages.hashCode() + (this.unique_id.hashCode() * 31)) * 31, 31, this.model_name);
    }

    public String toString() {
        return "OfflineUpdateFirstRequest(unique_id=" + this.unique_id + ", messages=" + this.messages + ", model_name=" + this.model_name + ", api_token=" + this.api_token + ")";
    }

    public OfflineUpdateFirstRequest(String unique_id, List<OfflineUpdateGroupMessage> messages, String model_name, String api_token) {
        p.e(unique_id, "unique_id");
        p.e(messages, "messages");
        p.e(model_name, "model_name");
        p.e(api_token, "api_token");
        this.unique_id = unique_id;
        this.messages = messages;
        this.model_name = model_name;
        this.api_token = api_token;
    }

    public /* synthetic */ OfflineUpdateFirstRequest(String str, List list, String str2, String str3, int i8, i iVar) {
        this(str, list, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 8) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str3);
    }
}
