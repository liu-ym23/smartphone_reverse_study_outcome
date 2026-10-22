package qd;

import kotlin.jvm.internal.g;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@IgnoreJRERequirement
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final boolean f11657a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f11658b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f11659c;

    /* renamed from: d, reason: collision with root package name */
    public final Integer f11660d;

    /* renamed from: e, reason: collision with root package name */
    public final boolean f11661e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f11662f;

    public d(boolean z, Integer num, boolean z3, Integer num2, boolean z10, boolean z11) {
        this.f11657a = z;
        this.f11658b = num;
        this.f11659c = z3;
        this.f11660d = num2;
        this.f11661e = z10;
        this.f11662f = z11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f11657a == dVar.f11657a && g.b(this.f11658b, dVar.f11658b) && this.f11659c == dVar.f11659c && g.b(this.f11660d, dVar.f11660d) && this.f11661e == dVar.f11661e && this.f11662f == dVar.f11662f;
    }

    public final int hashCode() {
        int iHashCode = Boolean.hashCode(this.f11657a) * 31;
        Integer num = this.f11658b;
        int iF = ai.onnxruntime.a.f((iHashCode + (num == null ? 0 : num.hashCode())) * 31, 31, this.f11659c);
        Integer num2 = this.f11660d;
        return Boolean.hashCode(this.f11662f) + ai.onnxruntime.a.f((iF + (num2 != null ? num2.hashCode() : 0)) * 31, 31, this.f11661e);
    }

    public final String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.f11657a + ", clientMaxWindowBits=" + this.f11658b + ", clientNoContextTakeover=" + this.f11659c + ", serverMaxWindowBits=" + this.f11660d + ", serverNoContextTakeover=" + this.f11661e + ", unknownValues=" + this.f11662f + ')';
    }
}
