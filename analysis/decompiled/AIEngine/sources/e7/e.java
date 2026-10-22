package e7;

import android.util.Log;
import com.stepos.base.protocol.ProtocolType;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f8613a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f8614b = new LinkedHashMap();

    public final void a(b bVar) {
        String lowerCase = bVar.getType().name().toLowerCase(Locale.ROOT);
        kotlin.jvm.internal.g.e(lowerCase, "toLowerCase(...)");
        Log.d("ProtocolManager", "addProtocol: name=" + lowerCase + ", type=" + bVar.getType() + ", class=" + bVar.getClass().getSimpleName());
        this.f8613a.put(lowerCase, bVar);
        ProtocolType type = bVar.getType();
        LinkedHashMap linkedHashMap = this.f8614b;
        Object arrayList = linkedHashMap.get(type);
        if (arrayList == null) {
            arrayList = new ArrayList();
            linkedHashMap.put(type, arrayList);
        }
        ((List) arrayList).add(bVar);
    }

    public final <T extends b> T b(ProtocolType protocolType) {
        List list = (List) this.f8614b.get(protocolType);
        T t8 = list != null ? (T) kotlin.collections.a.v0(list) : null;
        if (t8 != null) {
            return t8;
        }
        return null;
    }
}
