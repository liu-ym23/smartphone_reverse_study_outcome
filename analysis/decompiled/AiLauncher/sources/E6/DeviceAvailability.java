package E6;

import com.autonavi.aps.amapapi.config.Const;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\f\u001a\u00020\u000bHÖ\u0001¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u000f\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0012\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014¨\u0006\u0019"}, d2 = {"LE6/b;", "", "", "cpu", "gpu", "npu", "<init>", "(ZZZ)V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Z", "getCpu", "()Z", Const.INTENT_KEY_PKGNAME, "getGpu", "c", "getNpu", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* renamed from: E6.b, reason: from toString */
/* loaded from: classes3.dex */
public final /* data */ class DeviceAvailability {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean cpu;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean gpu;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
    public final boolean npu;

    public DeviceAvailability(boolean z10, boolean z11, boolean z12) {
        this.cpu = z10;
        this.gpu = z11;
        this.npu = z12;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DeviceAvailability)) {
            return false;
        }
        DeviceAvailability deviceAvailability = (DeviceAvailability) other;
        return this.cpu == deviceAvailability.cpu && this.gpu == deviceAvailability.gpu && this.npu == deviceAvailability.npu;
    }

    public int hashCode() {
        return (((Boolean.hashCode(this.cpu) * 31) + Boolean.hashCode(this.gpu)) * 31) + Boolean.hashCode(this.npu);
    }

    public String toString() {
        return "DeviceAvailability(cpu=" + this.cpu + ", gpu=" + this.gpu + ", npu=" + this.npu + ")";
    }
}
