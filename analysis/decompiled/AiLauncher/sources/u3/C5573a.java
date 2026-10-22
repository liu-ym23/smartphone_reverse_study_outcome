package u3;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import com.google.android.gms.common.internal.C1669j;
import v3.InterfaceC5656a;
import y3.C5938b;

/* renamed from: u3.a, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public class C5573a {

    /* renamed from: a, reason: collision with root package name */
    public final InterfaceC5656a f42425a;

    /* renamed from: b, reason: collision with root package name */
    public final Rect f42426b;

    /* renamed from: c, reason: collision with root package name */
    public final Point[] f42427c;

    public C5573a(InterfaceC5656a interfaceC5656a, Matrix matrix) {
        this.f42425a = (InterfaceC5656a) C1669j.k(interfaceC5656a);
        Rect rectA = interfaceC5656a.a();
        if (rectA != null && matrix != null) {
            C5938b.c(rectA, matrix);
        }
        this.f42426b = rectA;
        Point[] pointArrD = interfaceC5656a.d();
        if (pointArrD != null && matrix != null) {
            C5938b.b(pointArrD, matrix);
        }
        this.f42427c = pointArrD;
    }

    public Point[] a() {
        return this.f42427c;
    }

    public int b() {
        int format = this.f42425a.getFormat();
        if (format > 4096 || format == 0) {
            return -1;
        }
        return format;
    }

    public String c() {
        return this.f42425a.b();
    }

    public int d() {
        return this.f42425a.c();
    }
}
