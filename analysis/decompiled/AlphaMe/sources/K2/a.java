package K2;

import androidx.appcompat.widget.RunnableC0209k;
import com.stepos.statsrpk.service.d;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class a extends Q2.b {

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ int f1042e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c f1043f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ a(c cVar, long j4, int i4) {
        super(j4);
        this.f1042e = i4;
        this.f1043f = cVar;
    }

    @Override // Q2.b
    public final void b() {
        int i4 = 16;
        int i5 = this.f1042e;
        c cVar = this.f1043f;
        switch (i5) {
            case 0:
                Iterator it = cVar.f1048c.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar != null) {
                        d dVar = (d) bVar;
                        dVar.f12382d.execute(new RunnableC0209k(i4, dVar, "CHANGE_NAME_NETWORKCONNECT"));
                    }
                }
                cVar.f1046a.a();
                break;
            default:
                Iterator it2 = cVar.f1048c.iterator();
                while (it2.hasNext()) {
                    b bVar2 = (b) it2.next();
                    if (bVar2 != null) {
                        d dVar2 = (d) bVar2;
                        dVar2.f12382d.execute(new RunnableC0209k(i4, dVar2, "CHANGE_NAME_POWER"));
                    }
                }
                cVar.f1047b.a();
                break;
        }
    }
}
