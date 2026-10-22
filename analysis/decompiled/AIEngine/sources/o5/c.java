package o5;

import com.stepos.core.ota.confirmui.i;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import o5.b;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements s5.a {

    /* renamed from: a, reason: collision with root package name */
    public final b f10765a;

    public c(b bVar) {
        this.f10765a = bVar;
    }

    @Override // s5.a
    public final boolean b(String str) {
        List arrayList;
        b bVar = this.f10765a;
        ArrayList arrayList2 = bVar.f10759a;
        if (arrayList2.isEmpty()) {
            arrayList = Collections.EMPTY_LIST;
        } else {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int size = arrayList2.size();
            int i10 = 0;
            String strA = null;
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                p5.e eVar = (p5.e) obj;
                if (eVar.b()) {
                    arrayList4.add(eVar);
                } else {
                    if (strA == null) {
                        strA = d.a(str);
                    }
                    b.a(eVar, str, strA, arrayList3, 0);
                }
            }
            if (str.length() <= 1000) {
                if (strA == null) {
                    strA = d.a(str);
                }
                int size2 = arrayList4.size();
                int i12 = 0;
                while (i12 < size2) {
                    Object obj2 = arrayList4.get(i12);
                    i12++;
                    b.a((p5.e) obj2, str, strA, arrayList3, 0);
                }
            } else {
                t5.a.a(str, 1000, 50, new i(bVar, arrayList4, arrayList3));
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int size3 = arrayList3.size();
            while (i10 < size3) {
                Object obj3 = arrayList3.get(i10);
                i10++;
                q5.a aVar = (q5.a) obj3;
                linkedHashMap.putIfAbsent(new b.a(aVar.f11620e, aVar.f11621f, aVar.f11617b, aVar.f11618c, aVar.f11619d), aVar);
            }
            arrayList = new ArrayList(linkedHashMap.values());
        }
        return !arrayList.isEmpty();
    }
}
