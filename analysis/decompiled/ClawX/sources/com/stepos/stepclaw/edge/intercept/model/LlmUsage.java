package com.stepos.stepclaw.edge.intercept.model;

import com.stepos.stepclaw.SecurePrefs;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.IntSerializer;
import kotlinx.serialization.internal.SerializationConstructorMarker;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0087\b\u0018\u0000 -2\u00020\u0001:\u0002.-BC\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\b\u0010\tBM\b\u0010\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\rJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0019\u0010\u0017J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001a\u0010\u0017J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u001b\u0010\u0017JL\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u001f\u001a\u00020\u001eHÖ\u0001¢\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b!\u0010\"J\u001a\u0010%\u001a\u00020$2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b%\u0010&R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010'\u001a\u0004\b(\u0010\u0017R\u0019\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010'\u001a\u0004\b)\u0010\u0017R\u0019\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010'\u001a\u0004\b*\u0010\u0017R\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0006\u0010'\u001a\u0004\b+\u0010\u0017R\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0007\u0010'\u001a\u0004\b,\u0010\u0017¨\u0006/"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "input", "output", "cacheRead", "cacheWrite", "total", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "seen0", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "serializationConstructorMarker", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "self", "Lkotlinx/serialization/encoding/CompositeEncoder;", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "Lb5/a0;", "write$Self$step_edge_release", "(Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;Lkotlinx/serialization/encoding/CompositeEncoder;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "component1", "()Ljava/lang/Integer;", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/Integer;", "getInput", "getOutput", "getCacheRead", "getCacheWrite", "getTotal", "Companion", "$serializer", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
@Serializable
/* loaded from: classes.dex */
public final /* data */ class LlmUsage {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Integer cacheRead;
    private final Integer cacheWrite;
    private final Integer input;
    private final Integer output;
    private final Integer total;

    /* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage$Companion;", SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID, "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/stepos/stepclaw/edge/intercept/model/LlmUsage;", "step-edge_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final KSerializer<LlmUsage> serializer() {
            return LlmUsage$$serializer.INSTANCE;
        }

        private Companion() {
        }
    }

    public LlmUsage() {
        this((Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 31, (i) null);
    }

    public static /* synthetic */ LlmUsage copy$default(LlmUsage llmUsage, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i8, Object obj) {
        if ((i8 & 1) != 0) {
            num = llmUsage.input;
        }
        if ((i8 & 2) != 0) {
            num2 = llmUsage.output;
        }
        if ((i8 & 4) != 0) {
            num3 = llmUsage.cacheRead;
        }
        if ((i8 & 8) != 0) {
            num4 = llmUsage.cacheWrite;
        }
        if ((i8 & 16) != 0) {
            num5 = llmUsage.total;
        }
        Integer num6 = num5;
        Integer num7 = num3;
        return llmUsage.copy(num, num2, num7, num4, num6);
    }

    public static final /* synthetic */ void write$Self$step_edge_release(LlmUsage self, CompositeEncoder output, SerialDescriptor serialDesc) {
        if (output.shouldEncodeElementDefault(serialDesc, 0) || self.input != null) {
            output.encodeNullableSerializableElement(serialDesc, 0, IntSerializer.INSTANCE, self.input);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 1) || self.output != null) {
            output.encodeNullableSerializableElement(serialDesc, 1, IntSerializer.INSTANCE, self.output);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 2) || self.cacheRead != null) {
            output.encodeNullableSerializableElement(serialDesc, 2, IntSerializer.INSTANCE, self.cacheRead);
        }
        if (output.shouldEncodeElementDefault(serialDesc, 3) || self.cacheWrite != null) {
            output.encodeNullableSerializableElement(serialDesc, 3, IntSerializer.INSTANCE, self.cacheWrite);
        }
        if (!output.shouldEncodeElementDefault(serialDesc, 4) && self.total == null) {
            return;
        }
        output.encodeNullableSerializableElement(serialDesc, 4, IntSerializer.INSTANCE, self.total);
    }

    /* renamed from: component1, reason: from getter */
    public final Integer getInput() {
        return this.input;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getOutput() {
        return this.output;
    }

    /* renamed from: component3, reason: from getter */
    public final Integer getCacheRead() {
        return this.cacheRead;
    }

    /* renamed from: component4, reason: from getter */
    public final Integer getCacheWrite() {
        return this.cacheWrite;
    }

    /* renamed from: component5, reason: from getter */
    public final Integer getTotal() {
        return this.total;
    }

    public final LlmUsage copy(Integer input, Integer output, Integer cacheRead, Integer cacheWrite, Integer total) {
        return new LlmUsage(input, output, cacheRead, cacheWrite, total);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LlmUsage)) {
            return false;
        }
        LlmUsage llmUsage = (LlmUsage) other;
        return p.a(this.input, llmUsage.input) && p.a(this.output, llmUsage.output) && p.a(this.cacheRead, llmUsage.cacheRead) && p.a(this.cacheWrite, llmUsage.cacheWrite) && p.a(this.total, llmUsage.total);
    }

    public final Integer getCacheRead() {
        return this.cacheRead;
    }

    public final Integer getCacheWrite() {
        return this.cacheWrite;
    }

    public final Integer getInput() {
        return this.input;
    }

    public final Integer getOutput() {
        return this.output;
    }

    public final Integer getTotal() {
        return this.total;
    }

    public int hashCode() {
        Integer num = this.input;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.output;
        int iHashCode2 = (iHashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.cacheRead;
        int iHashCode3 = (iHashCode2 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.cacheWrite;
        int iHashCode4 = (iHashCode3 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.total;
        return iHashCode4 + (num5 != null ? num5.hashCode() : 0);
    }

    public String toString() {
        return "LlmUsage(input=" + this.input + ", output=" + this.output + ", cacheRead=" + this.cacheRead + ", cacheWrite=" + this.cacheWrite + ", total=" + this.total + ")";
    }

    public /* synthetic */ LlmUsage(int i8, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, SerializationConstructorMarker serializationConstructorMarker) {
        if ((i8 & 1) == 0) {
            this.input = null;
        } else {
            this.input = num;
        }
        if ((i8 & 2) == 0) {
            this.output = null;
        } else {
            this.output = num2;
        }
        if ((i8 & 4) == 0) {
            this.cacheRead = null;
        } else {
            this.cacheRead = num3;
        }
        if ((i8 & 8) == 0) {
            this.cacheWrite = null;
        } else {
            this.cacheWrite = num4;
        }
        if ((i8 & 16) == 0) {
            this.total = null;
        } else {
            this.total = num5;
        }
    }

    public LlmUsage(Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.input = num;
        this.output = num2;
        this.cacheRead = num3;
        this.cacheWrite = num4;
        this.total = num5;
    }

    public /* synthetic */ LlmUsage(Integer num, Integer num2, Integer num3, Integer num4, Integer num5, int i8, i iVar) {
        this((i8 & 1) != 0 ? null : num, (i8 & 2) != 0 ? null : num2, (i8 & 4) != 0 ? null : num3, (i8 & 8) != 0 ? null : num4, (i8 & 16) != 0 ? null : num5);
    }
}
