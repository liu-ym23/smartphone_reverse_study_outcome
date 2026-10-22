package e7;

import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Pair;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name */
    public static final Object f8615a = kotlin.collections.b.g0(new Pair(ProtocolType.f6378a, kotlin.jvm.internal.i.a(h.class)), new Pair(ProtocolType.f6379b, kotlin.jvm.internal.i.a(i.class)), new Pair(ProtocolType.f6381d, kotlin.jvm.internal.i.a(c.class)), new Pair(ProtocolType.f6382e, kotlin.jvm.internal.i.a(d.class)), new Pair(ProtocolType.f6380c, kotlin.jvm.internal.i.a(a.class)), new Pair(ProtocolType.h, kotlin.jvm.internal.i.a(g.class)));

    /* renamed from: b, reason: collision with root package name */
    public static final LinkedHashMap f8616b = new LinkedHashMap();

    /* JADX WARN: Type inference failed for: r4v0, types: [java.lang.Object, java.util.Map] */
    public static b a(b7.a model, ProtocolType protocolType) {
        kotlin.jvm.internal.g.f(model, "model");
        try {
            ec.c cVar = (ec.c) f8615a.get(protocolType);
            if (cVar == null) {
                throw new IllegalArgumentException("Unknown protocol type: " + protocolType);
            }
            if (cVar.b(model)) {
                return (b) model;
            }
            Log.w("ProtocolRegistry", "Model " + kotlin.jvm.internal.i.a(model.getClass()).c() + " does not implement " + protocolType);
            return null;
        } catch (Exception e10) {
            Log.e("ProtocolRegistry", "Failed to bind protocol " + protocolType + " to model: " + e10.getMessage());
            return null;
        }
    }

    public static void b(kotlin.jvm.internal.c cVar, Set supportedProtocols) {
        kotlin.jvm.internal.g.f(supportedProtocols, "supportedProtocols");
        f8616b.put(cVar, supportedProtocols);
        Log.d("ProtocolRegistry", "Registered model " + cVar.c() + " with protocols: " + supportedProtocols);
    }
}
