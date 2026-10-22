package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
import com.stepos.stepclaw.provider.contract.OperationResult;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0017\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B7\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005¢\u0006\u0004\b\t\u0010\nBK\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJ\"\u0010\u001f\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0003¢\u0006\u0004\b\u001f\u0010 J@\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005HÆ\u0001¢\u0006\u0004\b!\u0010\"J\u0010\u0010#\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b#\u0010\u001dJ\u0010\u0010$\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b$\u0010%J\u001a\u0010'\u001a\u00020\u00192\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001dR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010)\u001a\u0004\b+\u0010\u001dR)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010,\u001a\u0004\b-\u0010 ¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/AutoCatchResponse;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "status", OperationResult.EXTRA_MESSAGE, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "memory", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;Ljava/lang/String;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/AutoCatchResponse;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, OperationResult.EXTRA_SUCCESS, "()Z", "component1", "()Ljava/lang/String;", "component2", "component3", "()Ljava/util/Map;", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;)Lcom/stepos/stepclaw/memory/lightmem/remote/AutoCatchResponse;", "toString", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getStatus", "getMessage", "Ljava/util/Map;", "getMemory", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class AutoCatchResponse {
    private final Map<String, List<CatchMemoryItem>> memory;
    private final String message;
    private final String status;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, null, h.w(f.f889a, new r(20))};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/AutoCatchResponse$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/AutoCatchResponse;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<AutoCatchResponse> serializer() {
            return AutoCatchResponse$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public AutoCatchResponse() {
        this((String) null, (String) null, (Map) null, 7, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(CatchMemoryItem$$serializer.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutoCatchResponse copy$default(AutoCatchResponse autoCatchResponse, String str, String str2, Map map, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = autoCatchResponse.status;
        }
        if ((i8 & 2) != 0) {
            str2 = autoCatchResponse.message;
        }
        if ((i8 & 4) != 0) {
            map = autoCatchResponse.memory;
        }
        return autoCatchResponse.copy(str, str2, map);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(AutoCatchResponse self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || !p.a(self.status, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 0, self.status);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.message, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.message);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && p.a(self.memory, t.f1093a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) eVarArr[2].getValue(), self.memory);
    }

    /* renamed from: component1, reason: from getter */
    public final String getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMessage() {
        return this.message;
    }

    public final Map<String, List<CatchMemoryItem>> component3() {
        return this.memory;
    }

    public final AutoCatchResponse copy(String status, String message, Map<String, ? extends List<CatchMemoryItem>> memory) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(memory, "memory");
        return new AutoCatchResponse(status, message, memory);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutoCatchResponse)) {
            return false;
        }
        AutoCatchResponse autoCatchResponse = (AutoCatchResponse) other;
        return p.a(this.status, autoCatchResponse.status) && p.a(this.message, autoCatchResponse.message) && p.a(this.memory, autoCatchResponse.memory);
    }

    public final Map<String, List<CatchMemoryItem>> getMemory() {
        return this.memory;
    }

    public final String getMessage() {
        return this.message;
    }

    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        return this.memory.hashCode() + b.f(this.status.hashCode() * 31, 31, this.message);
    }

    public final boolean success() {
        return p.a(this.status, OperationResult.EXTRA_SUCCESS);
    }

    public String toString() {
        String str = this.status;
        String str2 = this.message;
        Map<String, List<CatchMemoryItem>> map = this.memory;
        StringBuilder sbV = b.v("AutoCatchResponse(status=", str, ", message=", str2, ", memory=");
        sbV.append(map);
        sbV.append(")");
        return sbV.toString();
    }

    public /* synthetic */ AutoCatchResponse(int i8, String str, String str2, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.status = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.status = str;
        }
        if ((i8 & 2) == 0) {
            this.message = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.message = str2;
        }
        if ((i8 & 4) == 0) {
            this.memory = t.f1093a;
        } else {
            this.memory = map;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutoCatchResponse(String status, String message, Map<String, ? extends List<CatchMemoryItem>> memory) {
        p.e(status, "status");
        p.e(message, "message");
        p.e(memory, "memory");
        this.status = status;
        this.message = message;
        this.memory = memory;
    }

    public /* synthetic */ AutoCatchResponse(String str, String str2, Map map, int i8, i iVar) {
        this((i8 & 1) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str, (i8 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2, (i8 & 4) != 0 ? t.f1093a : map);
    }
}
