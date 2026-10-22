package t3;

import java.util.LinkedHashMap;
import kotlin.jvm.internal.p;
import p5.l;
import r4.i;
import z3.y;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final LinkedHashMap f5577a = new LinkedHashMap();

    /* renamed from: b, reason: collision with root package name */
    public final LinkedHashMap f5578b = new LinkedHashMap();

    /* renamed from: c, reason: collision with root package name */
    public final LinkedHashMap f5579c = new LinkedHashMap();
    public l d = new o3.a(17);

    /* renamed from: e, reason: collision with root package name */
    public boolean f5580e = true;

    /* renamed from: f, reason: collision with root package name */
    public boolean f5581f = true;

    public d() {
        int i8 = i.f5103a;
    }

    public final void a(y plugin, l lVar) {
        p.e(plugin, "plugin");
        r4.a key = plugin.getKey();
        LinkedHashMap linkedHashMap = this.f5578b;
        linkedHashMap.put(plugin.getKey(), new b6.e((l) linkedHashMap.get(key), 1, lVar));
        r4.a key2 = plugin.getKey();
        LinkedHashMap linkedHashMap2 = this.f5577a;
        if (linkedHashMap2.containsKey(key2)) {
            return;
        }
        linkedHashMap2.put(plugin.getKey(), new c5.a(14, plugin));
    }
}
