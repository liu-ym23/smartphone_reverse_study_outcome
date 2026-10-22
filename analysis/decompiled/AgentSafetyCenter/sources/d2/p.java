package d2;

import java.util.ArrayList;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class p implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3157c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ ad.y f3158f;

    public /* synthetic */ p(int i) {
        this.f3157c = i;
    }

    @Override // xb.a
    public final Object invoke() {
        Object obj;
        Object obj2;
        int i = this.f3157c;
        ad.y yVar = this.f3158f;
        switch (i) {
            case 0:
                ArrayList arrayList = (ArrayList) yVar.f635e;
                if (arrayList.isEmpty()) {
                    obj = null;
                } else {
                    Object obj3 = arrayList.get(0);
                    float fC = ((r) obj3).f3166a.c();
                    int i3 = 1;
                    int size = arrayList.size() - 1;
                    if (1 <= size) {
                        while (true) {
                            Object obj4 = arrayList.get(i3);
                            float fC2 = ((r) obj4).f3166a.c();
                            if (Float.compare(fC, fC2) < 0) {
                                obj3 = obj4;
                                fC = fC2;
                            }
                            if (i3 != size) {
                                i3++;
                            }
                        }
                    }
                    obj = obj3;
                }
                r rVar = (r) obj;
                return Float.valueOf(rVar != null ? rVar.f3166a.c() : 0.0f);
            default:
                ArrayList arrayList2 = (ArrayList) yVar.f635e;
                if (arrayList2.isEmpty()) {
                    obj2 = null;
                } else {
                    Object obj5 = arrayList2.get(0);
                    float fB = ((r) obj5).f3166a.i.b();
                    int i10 = 1;
                    int size2 = arrayList2.size() - 1;
                    if (1 <= size2) {
                        while (true) {
                            Object obj6 = arrayList2.get(i10);
                            float fB2 = ((r) obj6).f3166a.i.b();
                            if (Float.compare(fB, fB2) < 0) {
                                obj5 = obj6;
                                fB = fB2;
                            }
                            if (i10 != size2) {
                                i10++;
                            }
                        }
                    }
                    obj2 = obj5;
                }
                r rVar2 = (r) obj2;
                return Float.valueOf(rVar2 != null ? rVar2.f3166a.i.b() : 0.0f);
        }
    }
}
