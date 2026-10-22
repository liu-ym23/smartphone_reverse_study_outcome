package io.modelcontextprotocol.kotlin.sdk;

import kotlin.Metadata;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.SerialDescriptor;
import pb.C5083B;
import pb.E0;
import pb.T0;
import pb.Y0;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0017\u0018\u0000 \u001f2\u00020\u0001:\u0002 \u001fB#\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tB7\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\b\u0010\rJ'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0003\u001a\u00020\u00028\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006!"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Progress;", "Lio/modelcontextprotocol/kotlin/sdk/ProgressBase;", "", "progress", "", "total", "", "message", "<init>", "(ILjava/lang/Double;Ljava/lang/String;)V", "seen0", "Lpb/T0;", "serializationConstructorMarker", "(IILjava/lang/Double;Ljava/lang/String;Lpb/T0;)V", "self", "Lob/d;", "output", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDesc", "LY8/t;", "write$Self", "(Lio/modelcontextprotocol/kotlin/sdk/Progress;Lob/d;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "I", "getProgress", "()I", "Ljava/lang/Double;", "getTotal", "()Ljava/lang/Double;", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Companion", "$serializer", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
@lb.l
/* loaded from: classes4.dex */
public class Progress implements ProgressBase {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String message;
    private final int progress;
    private final Double total;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lio/modelcontextprotocol/kotlin/sdk/Progress$Companion;", "", "<init>", "()V", "Lkotlinx/serialization/KSerializer;", "Lio/modelcontextprotocol/kotlin/sdk/Progress;", "serializer", "()Lkotlinx/serialization/KSerializer;", "kotlin-sdk"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public final KSerializer<Progress> serializer() {
            return Progress$$serializer.INSTANCE;
        }

        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }
    }

    public /* synthetic */ Progress(int i10, int i11, Double d10, String str, T0 t02) {
        if (7 != (i10 & 7)) {
            E0.a(i10, 7, Progress$$serializer.INSTANCE.getDescriptor());
        }
        this.progress = i11;
        this.total = d10;
        this.message = str;
    }

    public static final /* synthetic */ void write$Self(Progress self, ob.d output, SerialDescriptor serialDesc) {
        output.t(serialDesc, 0, self.getProgress());
        output.k(serialDesc, 1, C5083B.f38260a, self.getTotal());
        output.k(serialDesc, 2, Y0.f38329a, self.getMessage());
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ProgressBase
    public String getMessage() {
        return this.message;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ProgressBase
    public int getProgress() {
        return this.progress;
    }

    @Override // io.modelcontextprotocol.kotlin.sdk.ProgressBase
    public Double getTotal() {
        return this.total;
    }

    public Progress(int i10, Double d10, String str) {
        this.progress = i10;
        this.total = d10;
        this.message = str;
    }
}
