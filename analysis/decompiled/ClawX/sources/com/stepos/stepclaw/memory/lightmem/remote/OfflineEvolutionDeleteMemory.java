package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
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
import kotlinx.serialization.json.JsonNames;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 ,2\u00020\u0001:\u0002-,B!\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\n\u001a\u00020\t\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0007\u0010\rJ'\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0017\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0019\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u001aJ.\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u001e\u0010\u001aJ\u0010\u0010\u001f\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u001a\u0010#\u001a\u00020\"2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b#\u0010$R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010%\u001a\u0004\b&\u0010\u0018R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b(\u0010\u001aR \u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0006\u0010'\u0012\u0004\b*\u0010+\u001a\u0004\b)\u0010\u001a¨\u0006."}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionDeleteMemory;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memory_index", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "memory_type", "content", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(IJLjava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionDeleteMemory;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()J", "component2", "()Ljava/lang/String;", "component3", "copy", "(JLjava/lang/String;Ljava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionDeleteMemory;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "J", "getMemory_index", "Ljava/lang/String;", "getMemory_type", "getContent", "getContent$annotations", "()V", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineEvolutionDeleteMemory {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String content;
    private final long memory_index;
    private final String memory_type;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionDeleteMemory$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineEvolutionDeleteMemory;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineEvolutionDeleteMemory> serializer() {
            return OfflineEvolutionDeleteMemory$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OfflineEvolutionDeleteMemory(int i8, long j4, String str, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (3 != (i8 & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 3, OfflineEvolutionDeleteMemory$$serializer.INSTANCE.getDescriptor());
        }
        this.memory_index = j4;
        this.memory_type = str;
        if ((i8 & 4) == 0) {
            this.content = SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
        } else {
            this.content = str2;
        }
    }

    public static /* synthetic */ OfflineEvolutionDeleteMemory copy$default(OfflineEvolutionDeleteMemory offlineEvolutionDeleteMemory, long j4, String str, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            j4 = offlineEvolutionDeleteMemory.memory_index;
        }
        if ((i8 & 2) != 0) {
            str = offlineEvolutionDeleteMemory.memory_type;
        }
        if ((i8 & 4) != 0) {
            str2 = offlineEvolutionDeleteMemory.content;
        }
        return offlineEvolutionDeleteMemory.copy(j4, str, str2);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineEvolutionDeleteMemory self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeLongElement(serialDesc, 0, self.memory_index);
        output.encodeStringElement(serialDesc, 1, self.memory_type);
        if (!output.shouldEncodeElementDefault(serialDesc, 2) && p.a(self.content, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID)) {
            return;
        }
        output.encodeStringElement(serialDesc, 2, self.content);
    }

    /* renamed from: component1, reason: from getter */
    public final long getMemory_index() {
        return this.memory_index;
    }

    /* renamed from: component2, reason: from getter */
    public final String getMemory_type() {
        return this.memory_type;
    }

    /* renamed from: component3, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final OfflineEvolutionDeleteMemory copy(long memory_index, String memory_type, String content) {
        p.e(memory_type, "memory_type");
        p.e(content, "content");
        return new OfflineEvolutionDeleteMemory(memory_index, memory_type, content);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineEvolutionDeleteMemory)) {
            return false;
        }
        OfflineEvolutionDeleteMemory offlineEvolutionDeleteMemory = (OfflineEvolutionDeleteMemory) other;
        return this.memory_index == offlineEvolutionDeleteMemory.memory_index && p.a(this.memory_type, offlineEvolutionDeleteMemory.memory_type) && p.a(this.content, offlineEvolutionDeleteMemory.content);
    }

    public final String getContent() {
        return this.content;
    }

    public final long getMemory_index() {
        return this.memory_index;
    }

    public final String getMemory_type() {
        return this.memory_type;
    }

    public int hashCode() {
        return this.content.hashCode() + b.f(Long.hashCode(this.memory_index) * 31, 31, this.memory_type);
    }

    public String toString() {
        return "OfflineEvolutionDeleteMemory(memory_index=" + this.memory_index + ", memory_type=" + this.memory_type + ", content=" + this.content + ")";
    }

    public OfflineEvolutionDeleteMemory(long j4, String memory_type, String content) {
        p.e(memory_type, "memory_type");
        p.e(content, "content");
        this.memory_index = j4;
        this.memory_type = memory_type;
        this.content = content;
    }

    public /* synthetic */ OfflineEvolutionDeleteMemory(long j4, String str, String str2, int i8, i iVar) {
        this(j4, str, (i8 & 4) != 0 ? SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID : str2);
    }

    @JsonNames(names = {"content", "memory_content"})
    public static /* synthetic */ void getContent$annotations() {
    }
}
