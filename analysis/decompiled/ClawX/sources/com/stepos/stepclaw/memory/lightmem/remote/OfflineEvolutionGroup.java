package com.stepos.stepclaw.memory.lightmem.remote;

import b5.e;
import b5.f;
import b8.h;
import c5.s;
import c5.t;
import com.stepos.stepclaw.SecurePrefs;
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
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 /2\u00020\u0001:\u00020/B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006¢\u0006\u0004\b\u000b\u0010\fBO\b\u0010\u0012\u0006\u0010\r\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0018\u00010\u0004\u0012\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\u000b\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\"\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJF\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u001a\b\u0002\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00042\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006HÆ\u0001¢\u0006\u0004\b \u0010!J\u0010\u0010\"\u001a\u00020\u0005HÖ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u001bJ\u001a\u0010'\u001a\u00020&2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b'\u0010(R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010)\u001a\u0004\b*\u0010\u001bR)\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u00048\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b,\u0010\u001dR\u001d\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010-\u001a\u0004\b.\u0010\u001f¨\u00061"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionGroup;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "group_id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "Lcom/stepos/stepclaw/memory/lightmem/remote/CatchMemoryItem;", "add_memories", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionDeleteMemory;", "delete_memories", "<init>", "(ILjava/util/Map;Ljava/util/List;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/util/Map;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionGroup;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "component2", "()Ljava/util/Map;", "component3", "()Ljava/util/List;", "copy", "(ILjava/util/Map;Ljava/util/List;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionGroup;", "toString", "()Ljava/lang/String;", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "I", "getGroup_id", "Ljava/util/Map;", "getAdd_memories", "Ljava/util/List;", "getDelete_memories", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineEvolutionGroup {
    private static final e[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Map<String, List<CatchMemoryItem>> add_memories;
    private final List<OfflineEvolutionDeleteMemory> delete_memories;
    private final int group_id;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionGroup$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionGroup;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineEvolutionGroup> serializer() {
            return OfflineEvolutionGroup$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        f fVar = f.f889a;
        $childSerializers = new e[]{null, h.w(fVar, new r(24)), h.w(fVar, new r(25))};
    }

    public OfflineEvolutionGroup() {
        this(0, (Map) null, (List) null, 7, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new LinkedHashMapSerializer(StringSerializer.INSTANCE, new ArrayListSerializer(CatchMemoryItem$$serializer.INSTANCE));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(OfflineEvolutionDeleteMemory$$serializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflineEvolutionGroup copy$default(OfflineEvolutionGroup offlineEvolutionGroup, int i8, Map map, List list, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = offlineEvolutionGroup.group_id;
        }
        if ((i9 & 2) != 0) {
            map = offlineEvolutionGroup.add_memories;
        }
        if ((i9 & 4) != 0) {
            list = offlineEvolutionGroup.delete_memories;
        }
        return offlineEvolutionGroup.copy(i8, map, list);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineEvolutionGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.group_id != 0) {
            output.encodeIntElement(serialDesc, 0, self.group_id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.add_memories, t.f1093a)) {
            output.encodeSerializableElement(serialDesc, 1, (SerializationStrategy) eVarArr[1].getValue(), self.add_memories);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && p.a(self.delete_memories, s.f1092a)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) eVarArr[2].getValue(), self.delete_memories);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroup_id() {
        return this.group_id;
    }

    public final Map<String, List<CatchMemoryItem>> component2() {
        return this.add_memories;
    }

    public final List<OfflineEvolutionDeleteMemory> component3() {
        return this.delete_memories;
    }

    public final OfflineEvolutionGroup copy(int group_id, Map<String, ? extends List<CatchMemoryItem>> add_memories, List<OfflineEvolutionDeleteMemory> delete_memories) {
        p.e(add_memories, "add_memories");
        p.e(delete_memories, "delete_memories");
        return new OfflineEvolutionGroup(group_id, add_memories, delete_memories);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineEvolutionGroup)) {
            return false;
        }
        OfflineEvolutionGroup offlineEvolutionGroup = (OfflineEvolutionGroup) other;
        return this.group_id == offlineEvolutionGroup.group_id && p.a(this.add_memories, offlineEvolutionGroup.add_memories) && p.a(this.delete_memories, offlineEvolutionGroup.delete_memories);
    }

    public final Map<String, List<CatchMemoryItem>> getAdd_memories() {
        return this.add_memories;
    }

    public final List<OfflineEvolutionDeleteMemory> getDelete_memories() {
        return this.delete_memories;
    }

    public final int getGroup_id() {
        return this.group_id;
    }

    public int hashCode() {
        return this.delete_memories.hashCode() + ((this.add_memories.hashCode() + (Integer.hashCode(this.group_id) * 31)) * 31);
    }

    public String toString() {
        return "OfflineEvolutionGroup(group_id=" + this.group_id + ", add_memories=" + this.add_memories + ", delete_memories=" + this.delete_memories + ")";
    }

    public /* synthetic */ OfflineEvolutionGroup(int i8, int i9, Map map, List list, SerializationConstructorMarker serializationConstructorMarker) {
        this.group_id = (i8 & 1) == 0 ? 0 : i9;
        if ((i8 & 2) == 0) {
            this.add_memories = t.f1093a;
        } else {
            this.add_memories = map;
        }
        if ((i8 & 4) == 0) {
            this.delete_memories = s.f1092a;
        } else {
            this.delete_memories = list;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OfflineEvolutionGroup(int i8, Map<String, ? extends List<CatchMemoryItem>> add_memories, List<OfflineEvolutionDeleteMemory> delete_memories) {
        p.e(add_memories, "add_memories");
        p.e(delete_memories, "delete_memories");
        this.group_id = i8;
        this.add_memories = add_memories;
        this.delete_memories = delete_memories;
    }

    public /* synthetic */ OfflineEvolutionGroup(int i8, Map map, List list, int i9, i iVar) {
        this((i9 & 1) != 0 ? 0 : i8, (i9 & 2) != 0 ? t.f1093a : map, (i9 & 4) != 0 ? s.f1092a : list);
    }
}
