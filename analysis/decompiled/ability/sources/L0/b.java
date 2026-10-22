package L0;

import android.os.Message;
import java.util.Iterator;

/* loaded from: classes2.dex */
public final class b implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f924a;
    public final /* synthetic */ f b;

    public /* synthetic */ b(f fVar, int i) {
        this.f924a = i;
        this.b = fVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f924a) {
            case 0:
                Iterator it = this.b.f.iterator();
                while (it.hasNext()) {
                    ((e) it.next()).e(System.currentTimeMillis());
                }
                if (this.b.c) {
                    h hVar = this.b.b;
                    hVar.c(Message.obtain(hVar.d, this), 30000L);
                    break;
                }
                break;
            default:
                Iterator it2 = this.b.g.iterator();
                while (it2.hasNext()) {
                    ((e) it2.next()).e(System.currentTimeMillis());
                }
                if (this.b.c) {
                    h hVar2 = this.b.b;
                    hVar2.c(Message.obtain(hVar2.d, this), f.h);
                    break;
                }
                break;
        }
    }
}
