package com.stepos.cloud.securedata.model;

import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;
import ua.d;
import wa.g;
import wa.l;
import z6.a;
import z6.b;
import z6.c;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 \u00162\u00020\u0001:\u0002\u0017\u0016B7\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0015\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/stepos/cloud/securedata/model/KeyExchangeApiResponse;", "Lz6/a;", "", "seen0", "code", "", "msg", "Lcom/stepos/cloud/securedata/model/KeyExchangeData;", "data", "Lwa/l;", "serializationConstructorMarker", "<init>", "(IILjava/lang/String;Lcom/stepos/cloud/securedata/model/KeyExchangeData;Lwa/l;)V", "self", "Lva/a;", "output", "Lua/d;", "serialDesc", "Lc7/r;", "write$Self$sdk_release", "(Lcom/stepos/cloud/securedata/model/KeyExchangeApiResponse;Lva/a;Lua/d;)V", "write$Self", "Companion", "z6/b", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KeyExchangeApiResponse implements a {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final int f2710a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2711b;

    /* renamed from: c, reason: collision with root package name */
    public final KeyExchangeData f2712c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/cloud/securedata/model/KeyExchangeApiResponse$Companion;", "", "Lsa/a;", "Lcom/stepos/cloud/securedata/model/KeyExchangeApiResponse;", "serializer", "()Lsa/a;", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(f fVar) {
        }

        public final sa.a serializer() {
            return b.f11824a;
        }
    }

    public /* synthetic */ KeyExchangeApiResponse(int i2, int i10, String str, KeyExchangeData keyExchangeData, l lVar) {
        if (3 != (i2 & 3)) {
            g.a(i2, 3, b.f11824a.a());
            throw null;
        }
        this.f2710a = i10;
        this.f2711b = str;
        if ((i2 & 4) == 0) {
            this.f2712c = null;
        } else {
            this.f2712c = keyExchangeData;
        }
    }

    public static KeyExchangeApiResponse copy$default(KeyExchangeApiResponse keyExchangeApiResponse, int i2, String str, KeyExchangeData keyExchangeData, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            i2 = keyExchangeApiResponse.f2710a;
        }
        if ((i10 & 2) != 0) {
            str = keyExchangeApiResponse.f2711b;
        }
        if ((i10 & 4) != 0) {
            keyExchangeData = keyExchangeApiResponse.f2712c;
        }
        keyExchangeApiResponse.getClass();
        k.e(str, "msg");
        return new KeyExchangeApiResponse(i2, str, keyExchangeData);
    }

    public static final void write$Self$sdk_release(KeyExchangeApiResponse self, va.a output, d serialDesc) {
        int i2 = self.f2710a;
        KeyExchangeData keyExchangeData = self.f2712c;
        f3.b bVar = (f3.b) output;
        bVar.getClass();
        k.e(serialDesc, "descriptor");
        bVar.j(serialDesc, 0);
        bVar.e(i2);
        bVar.k(serialDesc, 1, self.f2711b);
        if (!bVar.f(serialDesc) && keyExchangeData == null) {
            return;
        }
        bVar.b(serialDesc, 2, c.f11825a, keyExchangeData);
    }

    @Override // z6.a
    /* renamed from: a, reason: from getter */
    public final String getF2718b() {
        return this.f2711b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyExchangeApiResponse)) {
            return false;
        }
        KeyExchangeApiResponse keyExchangeApiResponse = (KeyExchangeApiResponse) obj;
        return this.f2710a == keyExchangeApiResponse.f2710a && k.a(this.f2711b, keyExchangeApiResponse.f2711b) && k.a(this.f2712c, keyExchangeApiResponse.f2712c);
    }

    @Override // z6.a
    /* renamed from: getCode, reason: from getter */
    public final int getF2717a() {
        return this.f2710a;
    }

    public final int hashCode() {
        int iG = x.g(this.f2711b, Integer.hashCode(this.f2710a) * 31, 31);
        KeyExchangeData keyExchangeData = this.f2712c;
        return iG + (keyExchangeData == null ? 0 : Long.hashCode(keyExchangeData.f2713a));
    }

    public final String toString() {
        return "KeyExchangeApiResponse(code=" + this.f2710a + ", msg=" + this.f2711b + ", data=" + this.f2712c + ")";
    }

    public KeyExchangeApiResponse(int i2, String str, KeyExchangeData keyExchangeData) {
        k.e(str, "msg");
        this.f2710a = i2;
        this.f2711b = str;
        this.f2712c = keyExchangeData;
    }

    public /* synthetic */ KeyExchangeApiResponse(int i2, String str, KeyExchangeData keyExchangeData, int i10, f fVar) {
        this(i2, str, (i10 & 4) != 0 ? null : keyExchangeData);
    }
}
