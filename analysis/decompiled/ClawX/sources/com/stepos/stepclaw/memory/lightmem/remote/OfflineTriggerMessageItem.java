package com.stepos.stepclaw.memory.lightmem.remote;

import a8.b;
import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0087\b\u0018\u0000 62\u00020\u0001:\u000276B/\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0002¢\u0006\u0004\b\n\u0010\u000bBG\b\u0010\u0012\u0006\u0010\r\u001a\u00020\f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0004\b\n\u0010\u0010J'\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0015\u001a\u00020\u0014H\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u001a\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001c\u001a\u00020\u0004HÆ\u0003¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001e\u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b\u001e\u0010\u001fJ\u0010\u0010 \u001a\u00020\u0006HÆ\u0003¢\u0006\u0004\b \u0010\u001fJ\u0010\u0010!\u001a\u00020\u0002HÆ\u0003¢\u0006\u0004\b!\u0010\u001bJB\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u0002HÆ\u0001¢\u0006\u0004\b\"\u0010#J\u0010\u0010$\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b$\u0010\u001bJ\u0010\u0010%\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b%\u0010&J\u001a\u0010)\u001a\u00020(2\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b)\u0010*R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010+\u001a\u0004\b,\u0010\u001bR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010-\u001a\u0004\b.\u0010\u001dR \u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0007\u0010/\u0012\u0004\b1\u00102\u001a\u0004\b0\u0010\u001fR \u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0012\n\u0004\b\b\u0010/\u0012\u0004\b4\u00102\u001a\u0004\b3\u0010\u001fR\u0017\u0010\t\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\t\u0010+\u001a\u0004\b5\u0010\u001b¨\u00068"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "content", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "confidence", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "create_at", "memory_index", "state", "<init>", "(Ljava/lang/String;DJJLjava/lang/String;)V", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/String;DJJLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_memory_release", "(Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/String;", "component2", "()D", "component3", "()J", "component4", "component5", "copy", "(Ljava/lang/String;DJJLjava/lang/String;)Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem;", "toString", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getContent", "D", "getConfidence", "J", "getCreate_at", "getCreate_at$annotations", "()V", "getMemory_index", "getMemory_index$annotations", "getState", "Companion", "$serializer", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class OfflineTriggerMessageItem {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final double confidence;
    private final String content;
    private final long create_at;
    private final long memory_index;
    private final String state;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/memory/lightmem/remote/OfflineTriggerMessageItem;", "step-memory_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<OfflineTriggerMessageItem> serializer() {
            return OfflineTriggerMessageItem$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public /* synthetic */ OfflineTriggerMessageItem(int i8, String str, double d, long j4, long j8, String str2, SerializationConstructorMarker serializationConstructorMarker) {
        if (31 != (i8 & 31)) {
            PluginExceptionsKt.throwMissingFieldException(i8, 31, OfflineTriggerMessageItem$$serializer.INSTANCE.getDescriptor());
        }
        this.content = str;
        this.confidence = d;
        this.create_at = j4;
        this.memory_index = j8;
        this.state = str2;
    }

    public static /* synthetic */ OfflineTriggerMessageItem copy$default(OfflineTriggerMessageItem offlineTriggerMessageItem, String str, double d, long j4, long j8, String str2, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            str = offlineTriggerMessageItem.content;
        }
        if ((i8 & 2) != 0) {
            d = offlineTriggerMessageItem.confidence;
        }
        if ((i8 & 4) != 0) {
            j4 = offlineTriggerMessageItem.create_at;
        }
        if ((i8 & 8) != 0) {
            j8 = offlineTriggerMessageItem.memory_index;
        }
        if ((i8 & 16) != 0) {
            str2 = offlineTriggerMessageItem.state;
        }
        String str3 = str2;
        long j9 = j8;
        return offlineTriggerMessageItem.copy(str, d, j4, j9, str3);
    }

    public static final /* synthetic */ void write$Self$step_memory_release(OfflineTriggerMessageItem self, CompositeEncoder output, SerialDescriptor serialDesc) {
        output.encodeStringElement(serialDesc, 0, self.content);
        output.encodeDoubleElement(serialDesc, 1, self.confidence);
        output.encodeLongElement(serialDesc, 2, self.create_at);
        output.encodeLongElement(serialDesc, 3, self.memory_index);
        output.encodeStringElement(serialDesc, 4, self.state);
    }

    /* renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    /* renamed from: component2, reason: from getter */
    public final double getConfidence() {
        return this.confidence;
    }

    /* renamed from: component3, reason: from getter */
    public final long getCreate_at() {
        return this.create_at;
    }

    /* renamed from: component4, reason: from getter */
    public final long getMemory_index() {
        return this.memory_index;
    }

    /* renamed from: component5, reason: from getter */
    public final String getState() {
        return this.state;
    }

    public final OfflineTriggerMessageItem copy(String content, double confidence, long create_at, long memory_index, String state) {
        p.e(content, "content");
        p.e(state, "state");
        return new OfflineTriggerMessageItem(content, confidence, create_at, memory_index, state);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof OfflineTriggerMessageItem)) {
            return false;
        }
        OfflineTriggerMessageItem offlineTriggerMessageItem = (OfflineTriggerMessageItem) other;
        return p.a(this.content, offlineTriggerMessageItem.content) && Double.compare(this.confidence, offlineTriggerMessageItem.confidence) == 0 && this.create_at == offlineTriggerMessageItem.create_at && this.memory_index == offlineTriggerMessageItem.memory_index && p.a(this.state, offlineTriggerMessageItem.state);
    }

    public final double getConfidence() {
        return this.confidence;
    }

    public final String getContent() {
        return this.content;
    }

    public final long getCreate_at() {
        return this.create_at;
    }

    public final long getMemory_index() {
        return this.memory_index;
    }

    public final String getState() {
        return this.state;
    }

    public int hashCode() {
        return this.state.hashCode() + b.e(b.e((Double.hashCode(this.confidence) + (this.content.hashCode() * 31)) * 31, 31, this.create_at), 31, this.memory_index);
    }

    public String toString() {
        return "OfflineTriggerMessageItem(content=" + this.content + ", confidence=" + this.confidence + ", create_at=" + this.create_at + ", memory_index=" + this.memory_index + ", state=" + this.state + ")";
    }

    public OfflineTriggerMessageItem(String content, double d, long j4, long j8, String state) {
        p.e(content, "content");
        p.e(state, "state");
        this.content = content;
        this.confidence = d;
        this.create_at = j4;
        this.memory_index = j8;
        this.state = state;
    }

    @SerialName("create_at")
    public static /* synthetic */ void getCreate_at$annotations() {
    }

    @SerialName("memory_index")
    public static /* synthetic */ void getMemory_index$annotations() {
    }
}
