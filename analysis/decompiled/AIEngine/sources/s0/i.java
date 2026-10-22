package s0;

import java.util.ArrayList;
import s0.j;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class i implements u0.a<j.a> {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f11852a;

    public i(String str) {
        this.f11852a = str;
    }

    @Override // u0.a
    public final void accept(j.a aVar) {
        j.a aVar2 = aVar;
        synchronized (j.f11855c) {
            try {
                p.o<String, ArrayList<u0.a<j.a>>> oVar = j.f11856d;
                ArrayList<u0.a<j.a>> arrayList = oVar.get(this.f11852a);
                if (arrayList == null) {
                    return;
                }
                oVar.remove(this.f11852a);
                for (int i10 = 0; i10 < arrayList.size(); i10++) {
                    arrayList.get(i10).accept(aVar2);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
