package com.stepos.cloud.securedata.model;

import f3.b;
import kotlin.Metadata;
import q7.f;
import q7.k;
import sa.a;
import ua.d;
import wa.g;
import wa.l;
import z6.c;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 \u00132\u00020\u0001:\u0002\u0014\u0013B#\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ'\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/stepos/cloud/securedata/model/KeyExchangeData;", "", "", "seen0", "", "idKey", "Lwa/l;", "serializationConstructorMarker", "<init>", "(IJLwa/l;)V", "self", "Lva/a;", "output", "Lua/d;", "serialDesc", "Lc7/r;", "write$Self$sdk_release", "(Lcom/stepos/cloud/securedata/model/KeyExchangeData;Lva/a;Lua/d;)V", "write$Self", "Companion", "z6/c", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KeyExchangeData {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final long f2713a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/cloud/securedata/model/KeyExchangeData$Companion;", "", "Lsa/a;", "Lcom/stepos/cloud/securedata/model/KeyExchangeData;", "serializer", "()Lsa/a;", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(f fVar) {
        }

        public final a serializer() {
            return c.f11825a;
        }
    }

    public /* synthetic */ KeyExchangeData(int i2, long j2, l lVar) {
        if (1 == (i2 & 1)) {
            this.f2713a = j2;
        } else {
            g.a(i2, 1, c.f11825a.a());
            throw null;
        }
    }

    public static KeyExchangeData copy$default(KeyExchangeData keyExchangeData, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = keyExchangeData.f2713a;
        }
        keyExchangeData.getClass();
        return new KeyExchangeData(j2);
    }

    public static final void write$Self$sdk_release(KeyExchangeData self, va.a output, d serialDesc) {
        long j2 = self.f2713a;
        b bVar = (b) output;
        bVar.getClass();
        k.e(serialDesc, "descriptor");
        bVar.j(serialDesc, 0);
        bVar.g(j2);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof KeyExchangeData) && this.f2713a == ((KeyExchangeData) obj).f2713a;
    }

    public final int hashCode() {
        return Long.hashCode(this.f2713a);
    }

    public final String toString() {
        return "KeyExchangeData(idKey=" + this.f2713a + ")";
    }

    public KeyExchangeData(long j2) {
        this.f2713a = j2;
    }
}
