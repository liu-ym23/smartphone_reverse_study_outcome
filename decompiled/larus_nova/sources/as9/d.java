package as9;

import android.content.Context;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import zr9.e;
import zr9.f;

/* JADX INFO: loaded from: classes31.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static volatile d f16167c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f16168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<zr9.a> f16169b;

    public class a implements zr9.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f16170a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f16171b;

        @Override // zr9.b
        public final String getDescription() {
            return "Unite thermalListener";
        }

        public a(d r100) {
            this.f16171b = r100;
            this.f16170a = -1;
        }

        @Override // zr9.b
        public final void a(f r100) {
            if (r100 != null) goto L4;
            return;
        L4:
            if (((ArrayList) this.f16171b.f16169b).isEmpty() == false) goto L6;
            return;
        L6:
            if (r100.f573434a == this.f16170a) goto L33;
            List<zr9.a> r101 = this.f16171b.f16169b;
            monitor-enter(r101);
            int r102 = r100.f573434a;     // Catch: Throwable -> L24
            int r103 = this.f16170a;     // Catch: Throwable -> L24
            if (r102 <= r103) goto L16;
            Iterator r104 = ((ArrayList) this.f16171b.f16169b).iterator();     // Catch: Throwable -> L24
        L14:
            if (r104.hasNext() == false) goto L21;
            ((zr9.a) r104.next()).a(r100);     // Catch: Throwable -> L24
        L21:
            monitor-exit(r101);     // Catch: Throwable -> L24
            this.f16170a = r100.f573434a;
            return;
        L16:
            if (r102 >= r103) goto L21;
            Iterator r105 = ((ArrayList) this.f16171b.f16169b).iterator();     // Catch: Throwable -> L24
        L19:
            if (r105.hasNext() == false) goto L21;
            ((zr9.a) r105.next()).b(r100);     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;
        }
    }

    public d(Context r100) {
        ArrayList r101 = new ArrayList();
        this.f16169b = r101;
        c r102 = new c(r100);
        this.f16168a = r102;
        if (bs9.a.f20322a == false) goto L5;
        r101.add(new e());
    L5:
        r102.c(new a(this));
    }
}
