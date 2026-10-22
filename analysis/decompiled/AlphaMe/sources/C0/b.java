package C0;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;
import t0.C0913H;

/* loaded from: classes.dex */
public final class b extends d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0913H f287b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UUID f288c;

    public b(C0913H c0913h, UUID uuid) {
        this.f287b = c0913h;
        this.f288c = uuid;
    }

    @Override // C0.d
    public final void b() {
        C0913H c0913h = this.f287b;
        WorkDatabase workDatabase = c0913h.f15327d;
        workDatabase.beginTransaction();
        try {
            d.a(c0913h, this.f288c.toString());
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            t0.w.b(c0913h.f15326c, c0913h.f15327d, c0913h.f15329f);
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
