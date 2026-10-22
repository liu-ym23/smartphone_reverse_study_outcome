package v3;

import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6769a;
    public final LinkedHashMap b;

    public b(int i) {
        this.f6769a = i;
        switch (i) {
            case 1:
                this.b = new LinkedHashMap();
                break;
            default:
                this.b = new LinkedHashMap();
                break;
        }
    }

    public void a(C2057a c2057a) {
        ((List) this.b.computeIfAbsent(c2057a.b, new reactor.util.retry.a(1))).add(c2057a);
    }

    public String toString() {
        switch (this.f6769a) {
            case 0:
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Iterator it = this.b.values().iterator();
                while (it.hasNext()) {
                    for (C2057a c2057a : (List) it.next()) {
                        String str = c2057a.f6768a;
                        String string = c2057a.b.toString();
                        ((Map) ((Map) linkedHashMap.computeIfAbsent(string, new reactor.util.retry.a(2))).computeIfAbsent(str, new reactor.util.retry.a(3))).put(c2057a.d.toString(), c2057a.e);
                    }
                }
                try {
                    return D3.b.f377a.writerWithDefaultPrettyPrinter().writeValueAsString(linkedHashMap);
                } catch (JsonProcessingException unused) {
                    return "";
                }
            default:
                return super.toString();
        }
    }
}
