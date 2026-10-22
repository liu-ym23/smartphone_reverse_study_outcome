package h7;

import com.stepos.base.strategy.DataSensitivity;
import com.stepos.base.strategy.ExecutionPreference;
import com.stepos.base.strategy.NetworkPolicy;
import kotlin.jvm.internal.g;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: d, reason: collision with root package name */
    public static final b f9362d = new b(DataSensitivity.f6384a, NetworkPolicy.f6390a, ExecutionPreference.f6386a);

    /* renamed from: a, reason: collision with root package name */
    public final DataSensitivity f9363a;

    /* renamed from: b, reason: collision with root package name */
    public final NetworkPolicy f9364b;

    /* renamed from: c, reason: collision with root package name */
    public final ExecutionPreference f9365c;

    public b(DataSensitivity dataSensitivity, NetworkPolicy networkPolicy, ExecutionPreference executionPreference) {
        this.f9363a = dataSensitivity;
        this.f9364b = networkPolicy;
        this.f9365c = executionPreference;
    }

    public static b a(b bVar, ExecutionPreference executionPreference) {
        bVar.getClass();
        bVar.getClass();
        DataSensitivity dataSensitivity = bVar.f9363a;
        bVar.getClass();
        NetworkPolicy networkPolicy = bVar.f9364b;
        bVar.getClass();
        g.f(executionPreference, "executionPreference");
        return new b(dataSensitivity, networkPolicy, executionPreference);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return Float.compare(0.05f, 0.05f) == 0 && this.f9363a == bVar.f9363a && Float.compare(0.8f, 0.8f) == 0 && this.f9364b == bVar.f9364b && this.f9365c == bVar.f9365c;
    }

    public final int hashCode() {
        return this.f9365c.hashCode() + ((this.f9364b.hashCode() + a0.a.a(0.8f, (this.f9363a.hashCode() + a0.a.a(0.05f, Long.hashCode(2000L) * 31, 31)) * 31, 31)) * 31);
    }

    public final String toString() {
        return "ExecutionConstraints(maxLatencyMs=2000, maxCost=0.05, dataSensitivity=" + this.f9363a + ", minAccuracy=0.8, networkPolicy=" + this.f9364b + ", executionPreference=" + this.f9365c + ")";
    }
}
