package S6;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.function.BiConsumer;

/* loaded from: classes3.dex */
public final /* synthetic */ class d implements BiConsumer {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1178a;
    public final /* synthetic */ K1.a b;
    public final /* synthetic */ ArrayList c;

    public /* synthetic */ d(K1.a aVar, ArrayList arrayList, int i) {
        this.f1178a = i;
        this.b = aVar;
        this.c = arrayList;
    }

    @Override // java.util.function.BiConsumer
    public final void accept(Object obj, Object obj2) {
        String str = (String) obj;
        String str2 = (String) obj2;
        switch (this.f1178a) {
            case 0:
                if (((c) this.b.d).test(str.toLowerCase())) {
                    this.c.add(new AbstractMap.SimpleEntry(str, str2));
                    break;
                }
                break;
            default:
                if (((c) this.b.d).test(str.toLowerCase())) {
                    this.c.add(new AbstractMap.SimpleEntry(str, str2));
                    break;
                }
                break;
        }
    }
}
