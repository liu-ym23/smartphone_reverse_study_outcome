package E6;

import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ame.api.QuantizationType;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0015\b\u0086\b\u0018\u0000  2\u00020\u0001:\u0001\u0014B9\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0012\u001a\u00020\b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0010R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0015\u001a\u0004\b\u0017\u0010\u0010R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0015\u001a\u0004\b\u0018\u0010\u0010R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u0017\u0010\t\u001a\u00020\b8\u0006¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u0016\u0010\u001f¨\u0006!"}, d2 = {"LE6/a;", "", "", "dimension", "maxVectors", "topK", "Lcom/stepos/ame/api/QuantizationType;", "quantization", "", "enableTurboMode", "<init>", "(IIILcom/stepos/ame/api/QuantizationType;Z)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "I", Const.INTENT_KEY_PKGNAME, "c", "getTopK", Const.INTENT_KEY_UMID, "Lcom/stepos/ame/api/QuantizationType;", "getQuantization", "()Lcom/stepos/ame/api/QuantizationType;", "e", "Z", "()Z", "f", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: E6.a, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class AMEConfig {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final int dimension;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final int maxVectors;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final int topK;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
    public final QuantizationType quantization;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean enableTurboMode;

    public AMEConfig() {
        this(0, 0, 0, null, false, 31, null);
    }

    /* renamed from: a, reason: from getter */
    public final int getDimension() {
        return this.dimension;
    }

    /* renamed from: b, reason: from getter */
    public final boolean getEnableTurboMode() {
        return this.enableTurboMode;
    }

    /* renamed from: c, reason: from getter */
    public final int getMaxVectors() {
        return this.maxVectors;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AMEConfig)) {
            return false;
        }
        AMEConfig aMEConfig = (AMEConfig) other;
        return this.dimension == aMEConfig.dimension && this.maxVectors == aMEConfig.maxVectors && this.topK == aMEConfig.topK && this.quantization == aMEConfig.quantization && this.enableTurboMode == aMEConfig.enableTurboMode;
    }

    public int hashCode() {
        return (((((((Integer.hashCode(this.dimension) * 31) + Integer.hashCode(this.maxVectors)) * 31) + Integer.hashCode(this.topK)) * 31) + this.quantization.hashCode()) * 31) + Boolean.hashCode(this.enableTurboMode);
    }

    public String toString() {
        return "AMEConfig(dimension=" + this.dimension + ", maxVectors=" + this.maxVectors + ", topK=" + this.topK + ", quantization=" + this.quantization + ", enableTurboMode=" + this.enableTurboMode + ")";
    }

    public AMEConfig(int i10, int i11, int i12, QuantizationType quantization, boolean z10) {
        p.i(quantization, "quantization");
        this.dimension = i10;
        this.maxVectors = i11;
        this.topK = i12;
        this.quantization = quantization;
        this.enableTurboMode = z10;
    }

    public /* synthetic */ AMEConfig(int i10, int i11, int i12, QuantizationType quantizationType, boolean z10, int i13, i iVar) {
        this((i13 & 1) != 0 ? 512 : i10, (i13 & 2) != 0 ? 1000000 : i11, (i13 & 4) != 0 ? 10 : i12, (i13 & 8) != 0 ? QuantizationType.INT8 : quantizationType, (i13 & 16) != 0 ? true : z10);
    }
}
