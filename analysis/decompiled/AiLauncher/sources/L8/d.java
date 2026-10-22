package L8;

import A8.e;
import android.graphics.Paint;

/* loaded from: classes4.dex */
public class d extends e {
    public d(e.a aVar) {
        super(aVar);
    }

    public static d k(e eVar) {
        return new d(eVar.e());
    }

    @Override // A8.e
    public int i(Paint paint) {
        int i10 = this.f1276c;
        return i10 < 0 ? (int) (paint.getStrokeWidth() + 0.5f) : i10;
    }

    @Override // A8.e
    public int j() {
        return this.f1274a;
    }

    public int l(Paint paint) {
        int i10 = this.f1275b;
        return i10 == 0 ? N8.a.a(paint.getColor(), 75) : i10;
    }

    public int m() {
        return this.f1278e;
    }

    public int n() {
        return this.f1279f;
    }

    public int o(Paint paint) {
        int i10 = this.f1277d;
        return i10 == 0 ? N8.a.a(paint.getColor(), 22) : i10;
    }
}
