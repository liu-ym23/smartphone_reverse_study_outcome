package p6;

import com.stepos.base.ability.ApplyScope;
import java.util.Map;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i {

    /* renamed from: e, reason: collision with root package name */
    public static final i f11442e;

    /* renamed from: a, reason: collision with root package name */
    public final int f11443a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11444b;

    /* renamed from: c, reason: collision with root package name */
    public final ApplyScope f11445c;

    /* renamed from: d, reason: collision with root package name */
    public final Map<String, i> f11446d;

    static {
        int i10 = 0;
        f11442e = new i(i10, i10, (ApplyScope) null, 15);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public i() {
        int i10 = 0;
        this(i10, i10, (ApplyScope) null, 15);
    }

    public static i a(i iVar, int i10, int i11, Map packageOverride, int i12) {
        if ((i12 & 1) != 0) {
            i10 = iVar.f11443a;
        }
        if ((i12 & 2) != 0) {
            i11 = iVar.f11444b;
        }
        ApplyScope applyTo = iVar.f11445c;
        if ((i12 & 8) != 0) {
            packageOverride = iVar.f11446d;
        }
        kotlin.jvm.internal.g.f(applyTo, "applyTo");
        kotlin.jvm.internal.g.f(packageOverride, "packageOverride");
        return new i(i10, i11, applyTo, (Map<String, i>) packageOverride);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return this.f11443a == iVar.f11443a && this.f11444b == iVar.f11444b && this.f11445c == iVar.f11445c && kotlin.jvm.internal.g.b(this.f11446d, iVar.f11446d);
    }

    public final int hashCode() {
        return this.f11446d.hashCode() + ((this.f11445c.hashCode() + ai.onnxruntime.a.d(this.f11444b, Integer.hashCode(this.f11443a) * 31, 31)) * 31);
    }

    public final String toString() {
        StringBuilder sbD = h0.e.d(this.f11443a, "SegmentationConfig(maxChars=", this.f11444b, ", punctWindow=", ", applyTo=");
        sbD.append(this.f11445c);
        sbD.append(", packageOverride=");
        sbD.append(this.f11446d);
        sbD.append(")");
        return sbD.toString();
    }

    public i(int i10, int i11, ApplyScope applyTo, Map<String, i> map) {
        kotlin.jvm.internal.g.f(applyTo, "applyTo");
        this.f11443a = i10;
        this.f11444b = i11;
        this.f11445c = applyTo;
        this.f11446d = map;
    }

    public /* synthetic */ i(int i10, int i11, ApplyScope applyScope, int i12) {
        this((i12 & 1) != 0 ? 0 : i10, (i12 & 2) != 0 ? 80 : i11, (i12 & 4) != 0 ? ApplyScope.f6189b : applyScope, (Map<String, i>) kotlin.collections.b.d0());
    }
}
