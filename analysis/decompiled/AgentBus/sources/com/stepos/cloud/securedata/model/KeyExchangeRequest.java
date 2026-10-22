package com.stepos.cloud.securedata.model;

import f3.b;
import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;
import sa.a;
import wa.g;
import wa.l;
import z6.d;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 \u00152\u00020\u0001:\u0002\u0016\u0015B9\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\n\u0010\u000bJ'\u0010\u0014\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0001¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0017"}, d2 = {"Lcom/stepos/cloud/securedata/model/KeyExchangeRequest;", "", "", "seen0", "", "appId", "deviceId", "encryptedAesKey", "Lwa/l;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lwa/l;)V", "self", "Lva/a;", "output", "Lua/d;", "serialDesc", "Lc7/r;", "write$Self$sdk_release", "(Lcom/stepos/cloud/securedata/model/KeyExchangeRequest;Lva/a;Lua/d;)V", "write$Self", "Companion", "z6/d", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class KeyExchangeRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f2714a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2715b;

    /* renamed from: c, reason: collision with root package name */
    public final String f2716c;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/cloud/securedata/model/KeyExchangeRequest$Companion;", "", "Lsa/a;", "Lcom/stepos/cloud/securedata/model/KeyExchangeRequest;", "serializer", "()Lsa/a;", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(f fVar) {
        }

        public final a serializer() {
            return d.f11826a;
        }
    }

    public /* synthetic */ KeyExchangeRequest(int i2, String str, String str2, String str3, l lVar) {
        if (7 != (i2 & 7)) {
            g.a(i2, 7, d.f11826a.a());
            throw null;
        }
        this.f2714a = str;
        this.f2715b = str2;
        this.f2716c = str3;
    }

    public static KeyExchangeRequest copy$default(KeyExchangeRequest keyExchangeRequest, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = keyExchangeRequest.f2714a;
        }
        if ((i2 & 2) != 0) {
            str2 = keyExchangeRequest.f2715b;
        }
        if ((i2 & 4) != 0) {
            str3 = keyExchangeRequest.f2716c;
        }
        keyExchangeRequest.getClass();
        k.e(str, "appId");
        k.e(str2, "deviceId");
        k.e(str3, "encryptedAesKey");
        return new KeyExchangeRequest(str, str2, str3);
    }

    public static final /* synthetic */ void write$Self$sdk_release(KeyExchangeRequest self, va.a output, ua.d serialDesc) {
        b bVar = (b) output;
        bVar.k(serialDesc, 0, self.f2714a);
        bVar.k(serialDesc, 1, self.f2715b);
        bVar.k(serialDesc, 2, self.f2716c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyExchangeRequest)) {
            return false;
        }
        KeyExchangeRequest keyExchangeRequest = (KeyExchangeRequest) obj;
        return k.a(this.f2714a, keyExchangeRequest.f2714a) && k.a(this.f2715b, keyExchangeRequest.f2715b) && k.a(this.f2716c, keyExchangeRequest.f2716c);
    }

    public final int hashCode() {
        return this.f2716c.hashCode() + x.g(this.f2715b, this.f2714a.hashCode() * 31, 31);
    }

    public final String toString() {
        return a1.a.m(a1.a.p("KeyExchangeRequest(appId=", this.f2714a, ", deviceId=", this.f2715b, ", encryptedAesKey="), this.f2716c, ")");
    }

    public KeyExchangeRequest(String str, String str2, String str3) {
        k.e(str, "appId");
        k.e(str2, "deviceId");
        k.e(str3, "encryptedAesKey");
        this.f2714a = str;
        this.f2715b = str2;
        this.f2716c = str3;
    }
}
