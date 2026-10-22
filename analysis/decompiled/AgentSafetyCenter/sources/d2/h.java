package d2;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f3105a = 0;

    static {
        new g("", 0);
    }

    public static final List a(g gVar, int i, int i3, a9.d dVar) {
        List list;
        if (i == i3 || (list = gVar.f3100c) == null) {
            return null;
        }
        if (i != 0 || i3 < gVar.f3101f.length()) {
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i10 = 0; i10 < size; i10++) {
                e eVar = (e) list.get(i10);
                if ((dVar != null ? ((Boolean) dVar.invoke(eVar.f3077a)).booleanValue() : true) && b(i, i3, eVar.f3078b, eVar.f3079c)) {
                    arrayList.add(new e(p5.f.q(eVar.f3078b, i, i3) - i, p5.f.q(eVar.f3079c, i, i3) - i, (b) eVar.f3077a, eVar.f3080d));
                }
            }
            return arrayList;
        }
        if (dVar == null) {
            return list;
        }
        ArrayList arrayList2 = new ArrayList(list.size());
        int size2 = list.size();
        for (int i11 = 0; i11 < size2; i11++) {
            Object obj = list.get(i11);
            if (((Boolean) dVar.invoke(((e) obj).f3077a)).booleanValue()) {
                arrayList2.add(obj);
            }
        }
        return arrayList2;
    }

    public static final boolean b(int i, int i3, int i10, int i11) {
        return ((i < i11) & (i10 < i3)) | (((i == i3) | (i10 == i11)) & (i == i10));
    }
}
