package com.google.android.datatransport.cct.internal;

import com.stepos.aiengine.update.AlgorithmUpdateBundle;
import com.stepos.statsapp.v3.lib.plugin.constants.Parameters;
import d2.AbstractC3943a;
import d2.AbstractC3949g;
import d2.AbstractC3950h;
import d2.AbstractC3951i;
import d2.C3944b;
import d2.C3945c;
import d2.C3946d;
import d2.C3947e;
import j3.C4765c;
import j3.InterfaceC4766d;
import j3.InterfaceC4767e;
import java.io.IOException;
import k3.InterfaceC4812a;

/* loaded from: classes2.dex */
public final class a implements InterfaceC4812a {

    /* renamed from: a, reason: collision with root package name */
    public static final InterfaceC4812a f19341a = new a();

    /* renamed from: com.google.android.datatransport.cct.internal.a$a, reason: collision with other inner class name */
    public static final class C0221a implements InterfaceC4766d<AbstractC3943a> {

        /* renamed from: a, reason: collision with root package name */
        public static final C0221a f19342a = new C0221a();

        /* renamed from: b, reason: collision with root package name */
        public static final C4765c f19343b = C4765c.d("sdkVersion");

        /* renamed from: c, reason: collision with root package name */
        public static final C4765c f19344c = C4765c.d(AlgorithmUpdateBundle.KEY_SUFFIX_MODEL);

        /* renamed from: d, reason: collision with root package name */
        public static final C4765c f19345d = C4765c.d("hardware");

        /* renamed from: e, reason: collision with root package name */
        public static final C4765c f19346e = C4765c.d(Parameters.DEVICE);

        /* renamed from: f, reason: collision with root package name */
        public static final C4765c f19347f = C4765c.d("product");

        /* renamed from: g, reason: collision with root package name */
        public static final C4765c f19348g = C4765c.d("osBuild");

        /* renamed from: h, reason: collision with root package name */
        public static final C4765c f19349h = C4765c.d("manufacturer");

        /* renamed from: i, reason: collision with root package name */
        public static final C4765c f19350i = C4765c.d("fingerprint");

        /* renamed from: j, reason: collision with root package name */
        public static final C4765c f19351j = C4765c.d("locale");

        /* renamed from: k, reason: collision with root package name */
        public static final C4765c f19352k = C4765c.d("country");

        /* renamed from: l, reason: collision with root package name */
        public static final C4765c f19353l = C4765c.d("mccMnc");

        /* renamed from: m, reason: collision with root package name */
        public static final C4765c f19354m = C4765c.d("applicationBuild");

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC3943a abstractC3943a, InterfaceC4767e interfaceC4767e) throws IOException {
            interfaceC4767e.a(f19343b, abstractC3943a.m());
            interfaceC4767e.a(f19344c, abstractC3943a.j());
            interfaceC4767e.a(f19345d, abstractC3943a.f());
            interfaceC4767e.a(f19346e, abstractC3943a.d());
            interfaceC4767e.a(f19347f, abstractC3943a.l());
            interfaceC4767e.a(f19348g, abstractC3943a.k());
            interfaceC4767e.a(f19349h, abstractC3943a.h());
            interfaceC4767e.a(f19350i, abstractC3943a.e());
            interfaceC4767e.a(f19351j, abstractC3943a.g());
            interfaceC4767e.a(f19352k, abstractC3943a.c());
            interfaceC4767e.a(f19353l, abstractC3943a.i());
            interfaceC4767e.a(f19354m, abstractC3943a.b());
        }
    }

    public static final class b implements InterfaceC4766d<AbstractC3949g> {

        /* renamed from: a, reason: collision with root package name */
        public static final b f19355a = new b();

        /* renamed from: b, reason: collision with root package name */
        public static final C4765c f19356b = C4765c.d("logRequest");

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC3949g abstractC3949g, InterfaceC4767e interfaceC4767e) throws IOException {
            interfaceC4767e.a(f19356b, abstractC3949g.c());
        }
    }

    public static final class c implements InterfaceC4766d<ClientInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final c f19357a = new c();

        /* renamed from: b, reason: collision with root package name */
        public static final C4765c f19358b = C4765c.d("clientType");

        /* renamed from: c, reason: collision with root package name */
        public static final C4765c f19359c = C4765c.d("androidClientInfo");

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(ClientInfo clientInfo, InterfaceC4767e interfaceC4767e) throws IOException {
            interfaceC4767e.a(f19358b, clientInfo.c());
            interfaceC4767e.a(f19359c, clientInfo.b());
        }
    }

    public static final class d implements InterfaceC4766d<AbstractC3950h> {

        /* renamed from: a, reason: collision with root package name */
        public static final d f19360a = new d();

        /* renamed from: b, reason: collision with root package name */
        public static final C4765c f19361b = C4765c.d("eventTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final C4765c f19362c = C4765c.d("eventCode");

        /* renamed from: d, reason: collision with root package name */
        public static final C4765c f19363d = C4765c.d("eventUptimeMs");

        /* renamed from: e, reason: collision with root package name */
        public static final C4765c f19364e = C4765c.d("sourceExtension");

        /* renamed from: f, reason: collision with root package name */
        public static final C4765c f19365f = C4765c.d("sourceExtensionJsonProto3");

        /* renamed from: g, reason: collision with root package name */
        public static final C4765c f19366g = C4765c.d("timezoneOffsetSeconds");

        /* renamed from: h, reason: collision with root package name */
        public static final C4765c f19367h = C4765c.d("networkConnectionInfo");

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC3950h abstractC3950h, InterfaceC4767e interfaceC4767e) throws IOException {
            interfaceC4767e.b(f19361b, abstractC3950h.c());
            interfaceC4767e.a(f19362c, abstractC3950h.b());
            interfaceC4767e.b(f19363d, abstractC3950h.d());
            interfaceC4767e.a(f19364e, abstractC3950h.f());
            interfaceC4767e.a(f19365f, abstractC3950h.g());
            interfaceC4767e.b(f19366g, abstractC3950h.h());
            interfaceC4767e.a(f19367h, abstractC3950h.e());
        }
    }

    public static final class e implements InterfaceC4766d<AbstractC3951i> {

        /* renamed from: a, reason: collision with root package name */
        public static final e f19368a = new e();

        /* renamed from: b, reason: collision with root package name */
        public static final C4765c f19369b = C4765c.d("requestTimeMs");

        /* renamed from: c, reason: collision with root package name */
        public static final C4765c f19370c = C4765c.d("requestUptimeMs");

        /* renamed from: d, reason: collision with root package name */
        public static final C4765c f19371d = C4765c.d("clientInfo");

        /* renamed from: e, reason: collision with root package name */
        public static final C4765c f19372e = C4765c.d("logSource");

        /* renamed from: f, reason: collision with root package name */
        public static final C4765c f19373f = C4765c.d("logSourceName");

        /* renamed from: g, reason: collision with root package name */
        public static final C4765c f19374g = C4765c.d("logEvent");

        /* renamed from: h, reason: collision with root package name */
        public static final C4765c f19375h = C4765c.d("qosTier");

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(AbstractC3951i abstractC3951i, InterfaceC4767e interfaceC4767e) throws IOException {
            interfaceC4767e.b(f19369b, abstractC3951i.g());
            interfaceC4767e.b(f19370c, abstractC3951i.h());
            interfaceC4767e.a(f19371d, abstractC3951i.b());
            interfaceC4767e.a(f19372e, abstractC3951i.d());
            interfaceC4767e.a(f19373f, abstractC3951i.e());
            interfaceC4767e.a(f19374g, abstractC3951i.c());
            interfaceC4767e.a(f19375h, abstractC3951i.f());
        }
    }

    public static final class f implements InterfaceC4766d<NetworkConnectionInfo> {

        /* renamed from: a, reason: collision with root package name */
        public static final f f19376a = new f();

        /* renamed from: b, reason: collision with root package name */
        public static final C4765c f19377b = C4765c.d("networkType");

        /* renamed from: c, reason: collision with root package name */
        public static final C4765c f19378c = C4765c.d("mobileSubtype");

        @Override // j3.InterfaceC4764b
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(NetworkConnectionInfo networkConnectionInfo, InterfaceC4767e interfaceC4767e) throws IOException {
            interfaceC4767e.a(f19377b, networkConnectionInfo.c());
            interfaceC4767e.a(f19378c, networkConnectionInfo.b());
        }
    }

    @Override // k3.InterfaceC4812a
    public void a(k3.b<?> bVar) {
        b bVar2 = b.f19355a;
        bVar.a(AbstractC3949g.class, bVar2);
        bVar.a(C3945c.class, bVar2);
        e eVar = e.f19368a;
        bVar.a(AbstractC3951i.class, eVar);
        bVar.a(C3947e.class, eVar);
        c cVar = c.f19357a;
        bVar.a(ClientInfo.class, cVar);
        bVar.a(com.google.android.datatransport.cct.internal.b.class, cVar);
        C0221a c0221a = C0221a.f19342a;
        bVar.a(AbstractC3943a.class, c0221a);
        bVar.a(C3944b.class, c0221a);
        d dVar = d.f19360a;
        bVar.a(AbstractC3950h.class, dVar);
        bVar.a(C3946d.class, dVar);
        f fVar = f.f19376a;
        bVar.a(NetworkConnectionInfo.class, fVar);
        bVar.a(com.google.android.datatransport.cct.internal.c.class, fVar);
    }
}
