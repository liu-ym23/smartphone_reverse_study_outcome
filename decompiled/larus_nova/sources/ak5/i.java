package ak5;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Interceptor;

/* JADX INFO: loaded from: classes18.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j f4020a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f4021b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final o f4022c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CopyOnWriteArrayList<y> f4023d;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CopyOnWriteArrayList<y> f4024a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public j.a f4025b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public h f4026c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public okhttp3.h f4027d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public boolean f4028e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public long f4029f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Interceptor f4030g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public int f4031h;

        public final i a() {
            j.a r100 = this.f4025b;
            x.f4059j = r100.f4032a;
            if ((r100 instanceof j.c) == false) goto L5;
            boolean r101 = this.f4028e;
            ((j.c) r100).f4033b = r101;
        L5:
            o r102 = new o(this.f4031h);
            r102.f4042c = this.f4030g;
            r102.f4041b = this.f4029f;
            r102.f4044e = this.f4027d;
            return new i(r100, this.f4026c, r102, this.f4024a);
        }

        public a() {
            this.f4024a = new CopyOnWriteArrayList();
            this.f4025b = new j.c();
        }

        public final void b(int r100) {
            if (r100 != 4) goto L6;
            this.f4025b = new j.d();
            return;
        L6:
            if (r100 != 5) goto L9;
            this.f4025b = new j.e();
            return;
        L9:
            if (r100 != 2) goto L12;
            this.f4025b = new j.f();
            return;
        L12:
            if (r100 != 6) goto L14;
            this.f4025b = new j.b();
            return;
        L14:
            this.f4025b = new j.c();
        }
    }

    public i(j r100, h r101, o r102, List<y> r103) {
        CopyOnWriteArrayList<y> r104 = new CopyOnWriteArrayList();
        this.f4023d = r104;
        this.f4020a = r100;
        this.f4021b = r101;
        this.f4022c = r102;
        r104.addAll(r103);
    }
}
