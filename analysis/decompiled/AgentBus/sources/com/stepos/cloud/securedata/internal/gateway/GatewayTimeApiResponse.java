package com.stepos.cloud.securedata.internal.gateway;

import f3.b;
import kotlin.Metadata;
import q7.f;
import q7.k;
import sa.a;
import ua.d;
import wa.g;
import wa.l;
import y6.e;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0015B7\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/stepos/cloud/securedata/internal/gateway/GatewayTimeApiResponse;", "", "", "seen0", "code", "status", "", "data", "Lwa/l;", "serializationConstructorMarker", "<init>", "(ILjava/lang/Integer;Ljava/lang/Integer;JLwa/l;)V", "self", "Lva/a;", "output", "Lua/d;", "serialDesc", "Lc7/r;", "write$Self$sdk_release", "(Lcom/stepos/cloud/securedata/internal/gateway/GatewayTimeApiResponse;Lva/a;Lua/d;)V", "write$Self", "Companion", "y6/e", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class GatewayTimeApiResponse {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final Integer f2707a;

    /* renamed from: b, reason: collision with root package name */
    public final Integer f2708b;

    /* renamed from: c, reason: collision with root package name */
    public final long f2709c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/cloud/securedata/internal/gateway/GatewayTimeApiResponse$Companion;", "", "Lsa/a;", "Lcom/stepos/cloud/securedata/internal/gateway/GatewayTimeApiResponse;", "serializer", "()Lsa/a;", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(f fVar) {
        }

        public final a serializer() {
            return e.f11690a;
        }
    }

    public /* synthetic */ GatewayTimeApiResponse(int i2, Integer num, Integer num2, long j2, l lVar) {
        if (4 != (i2 & 4)) {
            g.a(i2, 4, e.f11690a.a());
            throw null;
        }
        if ((i2 & 1) == 0) {
            this.f2707a = null;
        } else {
            this.f2707a = num;
        }
        if ((i2 & 2) == 0) {
            this.f2708b = null;
        } else {
            this.f2708b = num2;
        }
        this.f2709c = j2;
    }

    public static GatewayTimeApiResponse copy$default(GatewayTimeApiResponse gatewayTimeApiResponse, Integer num, Integer num2, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = gatewayTimeApiResponse.f2707a;
        }
        if ((i2 & 2) != 0) {
            num2 = gatewayTimeApiResponse.f2708b;
        }
        if ((i2 & 4) != 0) {
            j2 = gatewayTimeApiResponse.f2709c;
        }
        gatewayTimeApiResponse.getClass();
        return new GatewayTimeApiResponse(num, num2, j2);
    }

    public static final void write$Self$sdk_release(GatewayTimeApiResponse self, va.a output, d serialDesc) {
        if (output.f(serialDesc) || self.f2707a != null) {
            output.b(serialDesc, 0, wa.d.f10965a, self.f2707a);
        }
        if (output.f(serialDesc) || self.f2708b != null) {
            output.b(serialDesc, 1, wa.d.f10965a, self.f2708b);
        }
        long j2 = self.f2709c;
        b bVar = (b) output;
        bVar.j(serialDesc, 2);
        bVar.g(j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GatewayTimeApiResponse)) {
            return false;
        }
        GatewayTimeApiResponse gatewayTimeApiResponse = (GatewayTimeApiResponse) obj;
        return k.a(this.f2707a, gatewayTimeApiResponse.f2707a) && k.a(this.f2708b, gatewayTimeApiResponse.f2708b) && this.f2709c == gatewayTimeApiResponse.f2709c;
    }

    public final int hashCode() {
        Integer num = this.f2707a;
        int iHashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.f2708b;
        return Long.hashCode(this.f2709c) + ((iHashCode + (num2 != null ? num2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        return "GatewayTimeApiResponse(code=" + this.f2707a + ", status=" + this.f2708b + ", data=" + this.f2709c + ")";
    }

    public GatewayTimeApiResponse(Integer num, Integer num2, long j2) {
        this.f2707a = num;
        this.f2708b = num2;
        this.f2709c = j2;
    }

    public /* synthetic */ GatewayTimeApiResponse(Integer num, Integer num2, long j2, int i2, f fVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2, j2);
    }
}
