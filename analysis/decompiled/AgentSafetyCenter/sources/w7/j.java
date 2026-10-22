package w7;

import java.lang.invoke.VarHandle;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class j extends d {

    /* renamed from: j, reason: collision with root package name */
    public p5.i f15317j;

    /* renamed from: k, reason: collision with root package name */
    public Map f15318k;

    /* renamed from: l, reason: collision with root package name */
    public Locale f15319l;

    @Override // w7.d
    public final e a() {
        String str;
        Map map = this.f15318k;
        if (map != null) {
            String str2 = (String) map.get("");
            HashMap map2 = this.f15295f;
            if (map2 != null && map2.get("property") != null && (str = (String) map.get(this.f15295f.get("property"))) != null) {
                str2 = str;
            }
            if (str2 != null && !"".equals(str2)) {
                this.f15296g = str2;
            }
        }
        if (this.f15296g == null && this.f15297h == null) {
            b.b bVar = new b.b(9);
            bVar.f1685f = this;
            VarHandle.storeStoreFence();
            this.f15297h = bVar;
        }
        return super.a();
    }
}
