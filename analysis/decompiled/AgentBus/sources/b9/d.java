package b9;

import androidx.datastore.preferences.protobuf.k;
import b0.s2;
import c0.h0;
import i1.a1;
import q7.w;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1555a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1556b;

    /* renamed from: c, reason: collision with root package name */
    public final int f1557c;

    public /* synthetic */ d(int i2, int i10, int i11, byte b10) {
        this.f1555a = i11;
        this.f1556b = i2;
        this.f1557c = i10;
    }

    public static b a(d dVar) {
        return new b(dVar.f1556b + dVar.f1557c, 1, 0, (byte) 0);
    }

    public static b b() {
        return new b(0, 1, 0, (byte) 0);
    }

    public abstract void c(k kVar, b0.c cVar, s2 s2Var, a1 a1Var, h0 h0Var);

    public b0.a d(k kVar) {
        return null;
    }

    public String toString() {
        switch (this.f1555a) {
            case 1:
                String strT = w.f8821a.b(getClass()).t();
                return strT == null ? "" : strT;
            default:
                return super.toString();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ d(int i2, int i10, int i11) {
        this((i11 & 1) != 0 ? 0 : i2, (i11 & 2) != 0 ? 0 : i10, 1, (byte) 0);
        this.f1555a = 1;
    }
}
