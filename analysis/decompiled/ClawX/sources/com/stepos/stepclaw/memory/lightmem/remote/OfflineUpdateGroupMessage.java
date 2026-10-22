package com.stepos.stepclaw.memory.lightmem.remote;

import b5.e;
import b5.f;
import b8.h;
import com.stepos.stepclaw.SecurePrefs;
import java.util.List;
import java.util.Map;
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
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import q3.a;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\t\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0002*)B)\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004¢\u0006\u0004\b\t\u0010\nB?\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\"\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ6\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b \u0010\u0019J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0019R)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010'\u001a\u0004\b(\u0010\u001b¨\u0006+"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "group_id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "search_memories", "<init>", "(ILjava/util/Map;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "component2", "()Ljava/util/Map;", "copy", "(ILjava/util/Map;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage;", "toString", "()Ljava/lang/String;", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "I", "getGroup_id", "Ljava/util/Map;", "getSearch_memories", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineUpdateGroupMessage {
    private final int group_id;
    private final Map<String, List<CatchMemoryItem>> search_memories;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final e[] $childSerializers = {null, h.w(f.f889a, new a(1))};

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineUpdateGroupMessage;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineUpdateGroupMessage> serializer() {
            return OfflineUpdateGroupMessage$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OfflineUpdateGroupMessage(int i8, int i9, Map map, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 3, OfflineUpdateGroupMessage$$serializer.INSTANCE.getDescriptor());
        }
        this.group_id = i9;
        this.search_memories = map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(CatchMemoryItem$$serializer.INSTANCE));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflineUpdateGroupMessage copy$default(OfflineUpdateGroupMessage offlineUpdateGroupMessage, int i8, Map map, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = offlineUpdateGroupMessage.group_id;
        }
        if ((i9 & 2) != 0) {
            map = offlineUpdateGroupMessage.search_memories;
        }
        return offlineUpdateGroupMessage.copy(i8, map);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineUpdateGroupMessage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        output.encodeIntElement(serialDesc, 0, self.group_id);
        output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) eVarArr[1].getValue(), self.search_memories);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroup_id() {
        return this.group_id;
    }

    public final Map<String, List<CatchMemoryItem>> component2() {
        return this.search_memories;
    }

    public final OfflineUpdateGroupMessage copy(int group_id, Map<String, ? extends List<CatchMemoryItem>> search_memories) {
        p.e(search_memories, "search_memories");
        return new OfflineUpdateGroupMessage(group_id, search_memories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineUpdateGroupMessage)) {
            return false;
        }
        OfflineUpdateGroupMessage offlineUpdateGroupMessage = (OfflineUpdateGroupMessage) other;
        return this.group_id == offlineUpdateGroupMessage.group_id && p.a(this.search_memories, offlineUpdateGroupMessage.search_memories);
    }

    public final int getGroup_id() {
        return this.group_id;
    }

    public final Map<String, List<CatchMemoryItem>> getSearch_memories() {
        return this.search_memories;
    }

    public int hashCode() {
        return this.search_memories.hashCode() + (Integer.hashCode(this.group_id) * 31);
    }

    public String toString() {
        return "OfflineUpdateGroupMessage(group_id=" + this.group_id + ", search_memories=" + this.search_memories + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfflineUpdateGroupMessage(int i8, Map<String, ? extends List<CatchMemoryItem>> search_memories) {
        p.e(search_memories, "search_memories");
        this.group_id = i8;
        this.search_memories = search_memories;
    }
}
