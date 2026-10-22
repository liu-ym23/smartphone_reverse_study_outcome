package x9;

import B9.h0;
import C7.r;
import S7.k;
import java.util.List;
import java.util.Map;
import z2.l;
import z9.C2199a;
import z9.g;
import z9.i;

/* loaded from: classes4.dex */
public final /* synthetic */ class d implements k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6884a;
    public final /* synthetic */ e b;

    public /* synthetic */ d(e eVar, int i) {
        this.f6884a = i;
        this.b = eVar;
    }

    @Override // S7.k
    public final Object invoke(Object obj) {
        C2199a buildSerialDescriptor = (C2199a) obj;
        switch (this.f6884a) {
            case 0:
                kotlin.jvm.internal.k.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                C2199a.a(buildSerialDescriptor, "type", h0.b);
                StringBuilder sb = new StringBuilder("kotlinx.serialization.Sealed<");
                e eVar = this.b;
                sb.append(eVar.f6885a.m());
                sb.append('>');
                d dVar = new d(eVar, 1);
                C2199a.a(buildSerialDescriptor, "value", l.l(sb.toString(), i.c, new g[0], dVar));
                List list = eVar.b;
                kotlin.jvm.internal.k.f(list, "<set-?>");
                buildSerialDescriptor.b = list;
                break;
            default:
                kotlin.jvm.internal.k.f(buildSerialDescriptor, "$this$buildSerialDescriptor");
                for (Map.Entry entry : this.b.e.entrySet()) {
                    C2199a.a(buildSerialDescriptor, (String) entry.getKey(), ((b) entry.getValue()).getDescriptor());
                }
                break;
        }
        return r.f317a;
    }
}
