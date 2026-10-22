package com.google.android.datatransport.cct.internal;

import com.google.android.datatransport.cct.internal.ClientInfo;
import d2.AbstractC3943a;

/* loaded from: classes2.dex */
public final class b extends ClientInfo {

    /* renamed from: a, reason: collision with root package name */
    public final ClientInfo.ClientType f19379a;

    /* renamed from: b, reason: collision with root package name */
    public final AbstractC3943a f19380b;

    /* renamed from: com.google.android.datatransport.cct.internal.b$b, reason: collision with other inner class name */
    public static final class C0222b extends ClientInfo.a {

        /* renamed from: a, reason: collision with root package name */
        public ClientInfo.ClientType f19381a;

        /* renamed from: b, reason: collision with root package name */
        public AbstractC3943a f19382b;

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo a() {
            return new b(this.f19381a, this.f19382b);
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a b(AbstractC3943a abstractC3943a) {
            this.f19382b = abstractC3943a;
            return this;
        }

        @Override // com.google.android.datatransport.cct.internal.ClientInfo.a
        public ClientInfo.a c(ClientInfo.ClientType clientType) {
            this.f19381a = clientType;
            return this;
        }
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public AbstractC3943a b() {
        return this.f19380b;
    }

    @Override // com.google.android.datatransport.cct.internal.ClientInfo
    public ClientInfo.ClientType c() {
        return this.f19379a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ClientInfo) {
            ClientInfo clientInfo = (ClientInfo) obj;
            ClientInfo.ClientType clientType = this.f19379a;
            if (clientType != null ? clientType.equals(clientInfo.c()) : clientInfo.c() == null) {
                AbstractC3943a abstractC3943a = this.f19380b;
                if (abstractC3943a != null ? abstractC3943a.equals(clientInfo.b()) : clientInfo.b() == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        ClientInfo.ClientType clientType = this.f19379a;
        int iHashCode = ((clientType == null ? 0 : clientType.hashCode()) ^ 1000003) * 1000003;
        AbstractC3943a abstractC3943a = this.f19380b;
        return iHashCode ^ (abstractC3943a != null ? abstractC3943a.hashCode() : 0);
    }

    public String toString() {
        return "ClientInfo{clientType=" + this.f19379a + ", androidClientInfo=" + this.f19380b + "}";
    }

    public b(ClientInfo.ClientType clientType, AbstractC3943a abstractC3943a) {
        this.f19379a = clientType;
        this.f19380b = abstractC3943a;
    }
}
