package b0;

import androidx.emoji2.text.p;
import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g implements d0.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f825a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f826b;

    public /* synthetic */ g(int i8, Object obj) {
        this.f825a = i8;
        this.f826b = obj;
    }

    @Override // d0.a
    public final void accept(Object obj) {
        switch (this.f825a) {
            case 0:
                h hVar = (h) obj;
                if (hVar == null) {
                    hVar = new h(-3);
                }
                ((p) this.f826b).r(hVar);
                return;
            default:
                h hVar2 = (h) obj;
                synchronized (i.f831c) {
                    try {
                        j.j jVar = i.d;
                        ArrayList arrayList = (ArrayList) jVar.get((String) this.f826b);
                        if (arrayList == null) {
                            return;
                        }
                        jVar.remove((String) this.f826b);
                        for (int i8 = 0; i8 < arrayList.size(); i8++) {
                            ((d0.a) arrayList.get(i8)).accept(hVar2);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
