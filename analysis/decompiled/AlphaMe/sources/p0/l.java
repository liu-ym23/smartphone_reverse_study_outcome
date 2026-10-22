package p0;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import com.stepos.alphame.utils.Property;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: p, reason: collision with root package name */
    public static final Matrix f13885p = new Matrix();

    /* renamed from: a, reason: collision with root package name */
    public final Path f13886a;

    /* renamed from: b, reason: collision with root package name */
    public final Path f13887b;

    /* renamed from: c, reason: collision with root package name */
    public final Matrix f13888c;

    /* renamed from: d, reason: collision with root package name */
    public Paint f13889d;

    /* renamed from: e, reason: collision with root package name */
    public Paint f13890e;

    /* renamed from: f, reason: collision with root package name */
    public PathMeasure f13891f;

    /* renamed from: g, reason: collision with root package name */
    public final i f13892g;

    /* renamed from: h, reason: collision with root package name */
    public float f13893h;

    /* renamed from: i, reason: collision with root package name */
    public float f13894i;

    /* renamed from: j, reason: collision with root package name */
    public float f13895j;

    /* renamed from: k, reason: collision with root package name */
    public float f13896k;

    /* renamed from: l, reason: collision with root package name */
    public int f13897l;

    /* renamed from: m, reason: collision with root package name */
    public String f13898m;

    /* renamed from: n, reason: collision with root package name */
    public Boolean f13899n;

    /* renamed from: o, reason: collision with root package name */
    public final q.f f13900o;

    public l() {
        this.f13888c = new Matrix();
        this.f13893h = Property.DEFAULT_FLOAT_VALUE;
        this.f13894i = Property.DEFAULT_FLOAT_VALUE;
        this.f13895j = Property.DEFAULT_FLOAT_VALUE;
        this.f13896k = Property.DEFAULT_FLOAT_VALUE;
        this.f13897l = 255;
        this.f13898m = null;
        this.f13899n = null;
        this.f13900o = new q.f();
        this.f13892g = new i();
        this.f13886a = new Path();
        this.f13887b = new Path();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01ed  */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v18 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(p0.i r19, android.graphics.Matrix r20, android.graphics.Canvas r21, int r22, int r23) {
        /*
            Method dump skipped, instructions count: 566
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: p0.l.a(p0.i, android.graphics.Matrix, android.graphics.Canvas, int, int):void");
    }

    public float getAlpha() {
        return getRootAlpha() / 255.0f;
    }

    public int getRootAlpha() {
        return this.f13897l;
    }

    public void setAlpha(float f4) {
        setRootAlpha((int) (f4 * 255.0f));
    }

    public void setRootAlpha(int i4) {
        this.f13897l = i4;
    }

    public l(l lVar) {
        this.f13888c = new Matrix();
        this.f13893h = Property.DEFAULT_FLOAT_VALUE;
        this.f13894i = Property.DEFAULT_FLOAT_VALUE;
        this.f13895j = Property.DEFAULT_FLOAT_VALUE;
        this.f13896k = Property.DEFAULT_FLOAT_VALUE;
        this.f13897l = 255;
        this.f13898m = null;
        this.f13899n = null;
        q.f fVar = new q.f(0);
        this.f13900o = fVar;
        this.f13892g = new i(lVar.f13892g, fVar);
        this.f13886a = new Path(lVar.f13886a);
        this.f13887b = new Path(lVar.f13887b);
        this.f13893h = lVar.f13893h;
        this.f13894i = lVar.f13894i;
        this.f13895j = lVar.f13895j;
        this.f13896k = lVar.f13896k;
        this.f13897l = lVar.f13897l;
        this.f13898m = lVar.f13898m;
        String str = lVar.f13898m;
        if (str != null) {
            fVar.put(str, this);
        }
        this.f13899n = lVar.f13899n;
    }
}
