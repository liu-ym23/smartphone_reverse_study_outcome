package h5;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class h implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ List f5343c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ p5.j f5344f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ g5.a f5345g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ WorkDatabase f5346h;

    @Override // java.lang.Runnable
    public final void run() {
        List list = this.f5343c;
        p5.j jVar = this.f5344f;
        g5.a aVar = this.f5345g;
        WorkDatabase workDatabase = this.f5346h;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((f) it.next()).c(jVar.f9734a);
        }
        i.b(aVar, workDatabase, list);
    }
}
