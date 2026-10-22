package androidx.emoji2.text;

import java.util.ArrayList;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class h implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f604a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final int f605b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f606c;

    public h(r6.x xVar, int i8) {
        this.f606c = xVar;
        this.f605b = i8;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f604a) {
            case 0:
                ArrayList arrayList = (ArrayList) this.f606c;
                int size = arrayList.size();
                int i8 = 0;
                if (this.f605b == 1) {
                    while (i8 < size) {
                        ((g) arrayList.get(i8)).a();
                        i8++;
                    }
                    break;
                } else {
                    while (i8 < size) {
                        ((g) arrayList.get(i8)).getClass();
                        i8++;
                    }
                    break;
                }
            default:
                w.b bVar = (w.b) ((r6.x) this.f606c).f5220a;
                if (bVar != null) {
                    bVar.d(this.f605b);
                    break;
                }
                break;
        }
    }

    public h(List list, int i8, Throwable th) {
        a.a.j(list, "initCallbacks cannot be null");
        this.f606c = new ArrayList(list);
        this.f605b = i8;
    }
}
