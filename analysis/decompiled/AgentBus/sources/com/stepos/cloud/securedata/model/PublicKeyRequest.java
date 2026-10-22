package com.stepos.cloud.securedata.model;

import f3.b;
import kotlin.Metadata;
import m.x;
import q7.f;
import q7.k;
import sa.a;
import ua.d;
import wa.l;
import z6.g;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0081\b\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0014B/\b\u0010\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ'\u0010\u0013\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000eH\u0001¢\u0006\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/stepos/cloud/securedata/model/PublicKeyRequest;", "", "", "seen0", "", "appId", "deviceId", "Lwa/l;", "serializationConstructorMarker", "<init>", "(ILjava/lang/String;Ljava/lang/String;Lwa/l;)V", "self", "Lva/a;", "output", "Lua/d;", "serialDesc", "Lc7/r;", "write$Self$sdk_release", "(Lcom/stepos/cloud/securedata/model/PublicKeyRequest;Lva/a;Lua/d;)V", "write$Self", "Companion", "z6/g", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final /* data */ class PublicKeyRequest {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: a, reason: collision with root package name */
    public final String f2721a;

    /* renamed from: b, reason: collision with root package name */
    public final String f2722b;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\u0013\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/cloud/securedata/model/PublicKeyRequest$Companion;", "", "Lsa/a;", "Lcom/stepos/cloud/securedata/model/PublicKeyRequest;", "serializer", "()Lsa/a;", "sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public Companion(f fVar) {
        }

        public final a serializer() {
            return g.f11829a;
        }
    }

    public /* synthetic */ PublicKeyRequest(int i2, String str, String str2, l lVar) {
        if (3 != (i2 & 3)) {
            wa.g.a(i2, 3, g.f11829a.a());
            throw null;
        }
        this.f2721a = str;
        this.f2722b = str2;
    }

    public static PublicKeyRequest copy$default(PublicKeyRequest publicKeyRequest, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = publicKeyRequest.f2721a;
        }
        if ((i2 & 2) != 0) {
            str2 = publicKeyRequest.f2722b;
        }
        publicKeyRequest.getClass();
        k.e(str, "appId");
        k.e(str2, "deviceId");
        return new PublicKeyRequest(str, str2);
    }

    public static final /* synthetic */ void write$Self$sdk_release(PublicKeyRequest self, va.a output, d serialDesc) {
        b bVar = (b) output;
        bVar.k(serialDesc, 0, self.f2721a);
        bVar.k(serialDesc, 1, self.f2722b);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PublicKeyRequest)) {
            return false;
        }
        PublicKeyRequest publicKeyRequest = (PublicKeyRequest) obj;
        return k.a(this.f2721a, publicKeyRequest.f2721a) && k.a(this.f2722b, publicKeyRequest.f2722b);
    }

    public final int hashCode() {
        return this.f2722b.hashCode() + (this.f2721a.hashCode() * 31);
    }

    public final String toString() {
        return x.x("PublicKeyRequest(appId=", this.f2721a, ", deviceId=", this.f2722b, ")");
    }

    public PublicKeyRequest(String str, String str2) {
        k.e(str, "appId");
        k.e(str2, "deviceId");
        this.f2721a = str;
        this.f2722b = str2;
    }
}
