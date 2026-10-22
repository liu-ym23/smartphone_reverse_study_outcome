package io.modelcontextprotocol.kotlin.sdk;

import java.util.List;
import kotlin.C4848b;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import p9.InterfaceC5063a;
import pb.C5083B;
import pb.C5094f;
import pb.E0;
import pb.T0;
import v9.C5684m;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 !2\u00020\u0001:\u0002\"!B5\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nBI\b\u0010\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\t\u0010\u000fJ'\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013H\u0001¢\u0006\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0006\u0010\u001c\u001a\u0004\b\u001d\u0010\u001eR\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001f\u0010\u001eR\u0019\u0010\b\u001a\u0004\u0018\u00010\u00058\u0006¢\u0006\f\n\u0004\b\b\u0010\u001c\u001a\u0004\b \u0010\u001e¨\u0006#"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "", "", "Lio/modelcontextprotocol/kotlin/sdk/ModelHint;", "hints", "", "costPriority", "speedPriority", "intelligencePriority", "<init>", "(Ljava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)V", "", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(ILjava/util/List;Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self$kotlin_sdk", "(Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "write$Self", "Ljava/util/List;", "getHints", "()Ljava/util/List;", "Ljava/lang/Double;", "getCostPriority", "()Ljava/lang/Double;", "getSpeedPriority", "getIntelligencePriority", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public final class ModelPreferences {
    private final Double costPriority;
    private final List<ModelHint> hints;
    private final Double intelligencePriority;
    private final Double speedPriority;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Y8.h<KSerializer<Object>>[] $childSerializers = {C4848b.a(LazyThreadSafetyMode.PUBLICATION, new InterfaceC5063a() { // from class: io.modelcontextprotocol.kotlin.sdk.A
        @Override // p9.InterfaceC5063a
        public final Object invoke() {
            return ModelPreferences._childSerializers$_anonymous_();
        }
    }), null, null, null};

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/ModelPreferences;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<ModelPreferences> serializer() {
            return ModelPreferences$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ ModelPreferences(int i10, List list, Double d10, Double d11, Double d12, T0 t02) {
        if (15 != (i10 & 15)) {
            E0.a(i10, 15, ModelPreferences$$serializer.INSTANCE.getDescriptor());
        }
        this.hints = list;
        this.costPriority = d10;
        this.speedPriority = d11;
        this.intelligencePriority = d12;
        if (d10 != null && !C5684m.b(0.0d, 1.0d).a(d10)) {
            throw new IllegalArgumentException("costPriority must be in 0.0 <= x <= 1.0 value range");
        }
        if (d11 != null && !C5684m.b(0.0d, 1.0d).a(d11)) {
            throw new IllegalArgumentException("costPriority must be in 0.0 <= x <= 1.0 value range");
        }
        if (d12 != null && !C5684m.b(0.0d, 1.0d).a(d12)) {
            throw new IllegalArgumentException("intelligencePriority must be in 0.0 <= x <= 1.0 value range");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ KSerializer _childSerializers$_anonymous_() {
        return new C5094f(ModelHint$$serializer.INSTANCE);
    }

    public static final /* synthetic */ void write$Self$kotlin_sdk(ModelPreferences self, ob.d output, SerialDescriptor serialDesc) {
        output.k(serialDesc, 0, $childSerializers[0].getValue(), self.hints);
        C5083B c5083b = C5083B.f38260a;
        output.k(serialDesc, 1, c5083b, self.costPriority);
        output.k(serialDesc, 2, c5083b, self.speedPriority);
        output.k(serialDesc, 3, c5083b, self.intelligencePriority);
    }

    public final Double getCostPriority() {
        return this.costPriority;
    }

    public final List<ModelHint> getHints() {
        return this.hints;
    }

    public final Double getIntelligencePriority() {
        return this.intelligencePriority;
    }

    public final Double getSpeedPriority() {
        return this.speedPriority;
    }

    public ModelPreferences(List<ModelHint> list, Double d10, Double d11, Double d12) {
        this.hints = list;
        this.costPriority = d10;
        this.speedPriority = d11;
        this.intelligencePriority = d12;
        if (d10 != null && !C5684m.b(0.0d, 1.0d).a(d10)) {
            throw new IllegalArgumentException("costPriority must be in 0.0 <= x <= 1.0 value range");
        }
        if (d11 != null && !C5684m.b(0.0d, 1.0d).a(d11)) {
            throw new IllegalArgumentException("costPriority must be in 0.0 <= x <= 1.0 value range");
        }
        if (d12 != null && !C5684m.b(0.0d, 1.0d).a(d12)) {
            throw new IllegalArgumentException("intelligencePriority must be in 0.0 <= x <= 1.0 value range");
        }
    }
}
