package A8;

import android.content.Context;
import android.graphics.Paint;

/* loaded from: classes4.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    public final int f1274a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1275b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1276c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1277d;

    /* renamed from: e, reason: collision with root package name */
    public final int f1278e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1279f;

    public static class a {

        /* renamed from: a, reason: collision with root package name */
        public int f1280a;

        /* renamed from: b, reason: collision with root package name */
        public int f1281b;

        /* renamed from: c, reason: collision with root package name */
        public int f1282c = -1;

        /* renamed from: d, reason: collision with root package name */
        public int f1283d;

        /* renamed from: e, reason: collision with root package name */
        public int f1284e;

        /* renamed from: f, reason: collision with root package name */
        public int f1285f;

        public e g() {
            return new e(this);
        }

        public a h(int i10) {
            this.f1281b = i10;
            return this;
        }

        public a i(int i10) {
            this.f1282c = i10;
            return this;
        }

        public a j(int i10) {
            this.f1280a = i10;
            return this;
        }

        public a k(int i10) {
            this.f1284e = i10;
            return this;
        }

        public a l(int i10) {
            this.f1285f = i10;
            return this;
        }

        public a m(int i10) {
            this.f1283d = i10;
            return this;
        }
    }

    public e(a aVar) {
        this.f1274a = aVar.f1280a;
        this.f1275b = aVar.f1281b;
        this.f1276c = aVar.f1282c;
        this.f1277d = aVar.f1283d;
        this.f1278e = aVar.f1284e;
        this.f1279f = aVar.f1285f;
    }

    public static a f(Context context) {
        N8.b bVarA = N8.b.a(context);
        return h().j(bVarA.b(4)).i(bVarA.b(1));
    }

    public static e g(Context context) {
        return f(context).g();
    }

    public static a h() {
        return new a();
    }

    public void a(Paint paint) {
        int iA = this.f1275b;
        if (iA == 0) {
            iA = N8.a.a(paint.getColor(), 75);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
    }

    public void b(Paint paint) {
        paint.setColor(this.f1278e);
        paint.setStyle(Paint.Style.FILL);
    }

    public void c(Paint paint) {
        paint.setColor(this.f1279f);
        paint.setStyle(Paint.Style.FILL);
    }

    public void d(Paint paint) {
        int iA = this.f1277d;
        if (iA == 0) {
            iA = N8.a.a(paint.getColor(), 22);
        }
        paint.setColor(iA);
        paint.setStyle(Paint.Style.FILL);
    }

    public a e() {
        return new a().j(this.f1274a).h(this.f1275b).i(this.f1276c).m(this.f1277d).k(this.f1278e).l(this.f1279f);
    }

    public int i(Paint paint) {
        int i10 = this.f1276c;
        return i10 == -1 ? (int) (paint.getStrokeWidth() + 0.5f) : i10;
    }

    public int j() {
        return this.f1274a;
    }
}
