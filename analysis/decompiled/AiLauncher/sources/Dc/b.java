package Dc;

import Cc.e;
import Cc.f;
import Ec.d;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: classes5.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public final char[] f2331a;

    /* renamed from: b, reason: collision with root package name */
    public final e f2332b;

    /* renamed from: c, reason: collision with root package name */
    public final d f2333c;

    public b(String str, e eVar, a aVar) {
        this.f2331a = str.toCharArray();
        this.f2332b = eVar;
        Paint paint = new Paint(1);
        paint.setTypeface(eVar.g());
        paint.setTextSize(eVar.e());
        paint.getTextBounds(str, 0, str.length(), new Rect());
        this.f2333c = new d.a(r4.left, r4.top, r4.width(), r4.height());
    }

    public void a(f fVar, int i10, int i11) {
        e eVarA = fVar.a();
        e eVar = this.f2332b;
        boolean z10 = eVar != eVarA;
        if (z10) {
            fVar.u(eVar);
        }
        char[] cArr = this.f2331a;
        fVar.b(cArr, 0, cArr.length, i10, i11);
        if (z10) {
            fVar.u(eVarA);
        }
    }

    public d b() {
        return this.f2333c;
    }
}
