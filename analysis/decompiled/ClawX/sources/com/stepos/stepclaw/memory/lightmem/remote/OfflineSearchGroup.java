package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import b5.e;
import b5.f;
import b8.h;
import c5.s;
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
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 .2\u00020\u0001:\u0002/.B;\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006¢\u0006\u0004\b\t\u0010\nBM\b\u0010\u0012\u0006\u0010\u000b\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\t\u0010\u000eJ'\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0012H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0018\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0016\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0016\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001dJD\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00062\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006HÆ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b!\u0010\u001bJ\u0010\u0010\"\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\"\u0010\u0019J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0019R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010)\u001a\u0004\b*\u0010\u001bR\u001d\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010+\u001a\u0004\b,\u0010\u001dR\u001d\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010+\u001a\u0004\b-\u0010\u001d¨\u00060"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "group_id", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cluster_summary", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "cluster_memories", "search", "<init>", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IILjava/lang/String;Ljava/util/List;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()I", "component2", "()Ljava/lang/String;", "component3", "()Ljava/util/List;", "component4", "copy", "(ILjava/lang/String;Ljava/util/List;Ljava/util/List;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;", "toString", "hashCode", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "I", "getGroup_id", "Ljava/lang/String;", "getCluster_summary", "Ljava/util/List;", "getCluster_memories", "getSearch", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineSearchGroup {
    private static final e[] $childSerializers;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final List<String> cluster_memories;
    private final String cluster_summary;
    private final int group_id;
    private final List<String> search;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineSearchGroup;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineSearchGroup> serializer() {
            return OfflineSearchGroup$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    static {
        f fVar = f.f889a;
        $childSerializers = new e[]{null, null, h.w(fVar, new r(26)), h.w(fVar, new r(27))};
    }

    public OfflineSearchGroup() {
        this(0, (String) null, (List) null, (List) null, 15, (i) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_$0() {
        return new ArrayListSerializer(StringSerializer.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ OfflineSearchGroup copy$default(OfflineSearchGroup offlineSearchGroup, int i8, String str, List list, List list2, int i9, Object obj) {
        if ((i9 & 1) != 0) {
            i8 = offlineSearchGroup.group_id;
        }
        if ((i9 & 2) != 0) {
            str = offlineSearchGroup.cluster_summary;
        }
        if ((i9 & 4) != 0) {
            list = offlineSearchGroup.cluster_memories;
        }
        if ((i9 & 8) != 0) {
            list2 = offlineSearchGroup.search;
        }
        return offlineSearchGroup.copy(i8, str, list, list2);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineSearchGroup self, CompositeEncoder output, SerialDescriptor serialDesc) {
        e[] eVarArr = $childSerializers;
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.group_id != 0) {
            output.encodeIntElement(serialDesc, 0, self.group_id);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || !p.a(self.cluster_summary, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            output.encodeStringElement(serialDesc, 1, self.cluster_summary);
        }
        boolean zShouldEncodeElementDefault = output.shouldEncodeElementDefault(serialDesc, 2);
        s sVar = s.f1092a;
        if (zShouldEncodeElementDefault || !p.a(self.cluster_memories, sVar)) {
            output.encodeSerializableElement(serialDesc, 2, (SerializationStrategy) eVarArr[2].getValue(), self.cluster_memories);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 3) && p.a(self.search, sVar)) {
            return;
        }
        output.encodeSerializableElement(serialDesc, 3, (SerializationStrategy) eVarArr[3].getValue(), self.search);
    }

    /* renamed from: component1, reason: from getter */
    public final int getGroup_id() {
        return this.group_id;
    }

    /* renamed from: component2, reason: from getter */
    public final String getCluster_summary() {
        return this.cluster_summary;
    }

    public final List<String> component3() {
        return this.cluster_memories;
    }

    public final List<String> component4() {
        return this.search;
    }

    public final OfflineSearchGroup copy(int group_id, String cluster_summary, List<String> cluster_memories, List<String> search) {
        p.e(cluster_summary, "cluster_summary");
        p.e(cluster_memories, "cluster_memories");
        p.e(search, "search");
        return new OfflineSearchGroup(group_id, cluster_summary, cluster_memories, search);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineSearchGroup)) {
            return false;
        }
        OfflineSearchGroup offlineSearchGroup = (OfflineSearchGroup) other;
        return this.group_id == offlineSearchGroup.group_id && p.a(this.cluster_summary, offlineSearchGroup.cluster_summary) && p.a(this.cluster_memories, offlineSearchGroup.cluster_memories) && p.a(this.search, offlineSearchGroup.search);
    }

    public final List<String> getCluster_memories() {
        return this.cluster_memories;
    }

    public final String getCluster_summary() {
        return this.cluster_summary;
    }

    public final int getGroup_id() {
        return this.group_id;
    }

    public final List<String> getSearch() {
        return this.search;
    }

    public int hashCode() {
        return this.search.hashCode() + ((this.cluster_memories.hashCode() + b.f(Integer.hashCode(this.group_id) * 31, 31, this.cluster_summary)) * 31);
    }

    public String toString() {
        return "OfflineSearchGroup(group_id=" + this.group_id + ", cluster_summary=" + this.cluster_summary + ", cluster_memories=" + this.cluster_memories + ", search=" + this.search + ")";
    }

    public /* synthetic */ OfflineSearchGroup(int i8, int i9, String str, List list, List list2, SerializationConstructorMarker serializationConstructorMarker) {
        this.group_id = (i8 & 1) == 0 ? 0 : i9;
        if ((i8 & 2) == 0) {
            this.cluster_summary = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.cluster_summary = str;
        }
        int i10 = i8 & 4;
        s sVar = s.f1092a;
        if (i10 == 0) {
            this.cluster_memories = sVar;
        } else {
            this.cluster_memories = list;
        }
        if ((i8 & 8) == 0) {
            this.search = sVar;
        } else {
            this.search = list2;
        }
    }

    public OfflineSearchGroup(int i8, String cluster_summary, List<String> cluster_memories, List<String> search) {
        p.e(cluster_summary, "cluster_summary");
        p.e(cluster_memories, "cluster_memories");
        p.e(search, "search");
        this.group_id = i8;
        this.cluster_summary = cluster_summary;
        this.cluster_memories = cluster_memories;
        this.search = search;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ OfflineSearchGroup(int i8, String str, List list, List list2, int i9, i iVar) {
        i8 = (i9 & 1) != 0 ? 0 : i8;
        str = (i9 & 2) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str;
        int i10 = i9 & 4;
        s sVar = s.f1092a;
        this(i8, str, i10 != 0 ? sVar : list, (i9 & 8) != 0 ? sVar : list2);
    }
}
