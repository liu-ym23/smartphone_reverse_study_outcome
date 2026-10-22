package C0;

import androidx.work.impl.WorkDatabase;
import java.util.Iterator;
import t0.C0913H;

/* loaded from: classes.dex */
public final class c extends d {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ C0913H f289b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f290c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f291d = false;

    public c(C0913H c0913h, String str) {
        this.f289b = c0913h;
        this.f290c = str;
    }

    @Override // C0.d
    public final void b() {
        C0913H c0913h = this.f289b;
        WorkDatabase workDatabase = c0913h.f15327d;
        workDatabase.beginTransaction();
        try {
            Iterator it = workDatabase.g().h(this.f290c).iterator();
            while (it.hasNext()) {
                d.a(c0913h, (String) it.next());
            }
            workDatabase.setTransactionSuccessful();
            workDatabase.endTransaction();
            if (this.f291d) {
                t0.w.b(c0913h.f15326c, c0913h.f15327d, c0913h.f15329f);
            }
        } catch (Throwable th) {
            workDatabase.endTransaction();
            throw th;
        }
    }
}
