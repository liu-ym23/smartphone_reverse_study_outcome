package d2;

import android.graphics.Matrix;
import android.graphics.Path;
import java.util.ArrayList;
import s1.o0;
import s8.u2;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class n implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3144c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ int f3145f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ int f3146g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f3147h;

    public /* synthetic */ n(int i) {
        this.f3144c = i;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f3144c) {
            case 0:
                d1.h hVar = (d1.h) this.f3147h;
                int i = this.f3145f;
                int i3 = this.f3146g;
                q qVar = (q) obj;
                a aVar = qVar.f3159a;
                int iA = qVar.a(i);
                int iA2 = qVar.a(i3);
                CharSequence charSequence = aVar.f3040e;
                if (iA < 0 || iA > iA2 || iA2 > charSequence.length()) {
                    StringBuilder sbU = k0.a.u("start(", iA, ") or end(", ") is out of range [0..", iA2);
                    sbU.append(charSequence.length());
                    sbU.append("], or start > end!");
                    i2.a.a(sbU.toString());
                }
                Path path = new Path();
                e2.i iVar = aVar.f3039d;
                iVar.f3438e.getSelectionPath(iA, iA2, path);
                int i10 = iVar.f3440g;
                if (i10 != 0 && !path.isEmpty()) {
                    path.offset(0.0f, i10);
                }
                float f5 = qVar.f3164f;
                long jFloatToRawIntBits = (Float.floatToRawIntBits(f5) & 4294967295L) | (Float.floatToRawIntBits(0.0f) << 32);
                Matrix matrix = new Matrix();
                matrix.setTranslate(Float.intBitsToFloat((int) (jFloatToRawIntBits >> 32)), Float.intBitsToFloat((int) (jFloatToRawIntBits & 4294967295L)));
                path.transform(matrix);
                int i11 = (int) 0;
                hVar.f2990a.addPath(path, Float.intBitsToFloat(i11), Float.intBitsToFloat(i11));
                return jb.v.f6774a;
            default:
                ArrayList arrayList = (ArrayList) this.f3147h;
                int i12 = this.f3145f;
                int i13 = this.f3146g;
                s1.n0 n0Var = (s1.n0) obj;
                n0Var.getClass();
                int size = arrayList.size();
                int i14 = 0;
                int i15 = 0;
                while (i15 < size) {
                    Object obj2 = arrayList.get(i15);
                    i15++;
                    u2 u2Var = (u2) obj2;
                    ArrayList arrayList2 = u2Var.f12009a;
                    int size2 = arrayList2.size();
                    int i16 = 0;
                    int i17 = 0;
                    int i18 = 0;
                    while (i18 < size2) {
                        Object obj3 = arrayList2.get(i18);
                        i18++;
                        int i19 = i16 + 1;
                        if (i16 < 0) {
                            ac.a.a0();
                            throw null;
                        }
                        o0 o0Var = (o0) obj3;
                        if (i16 > 0) {
                            i17 += i13;
                        }
                        s1.n0.l(n0Var, o0Var, i17, i14);
                        i17 += o0Var.f11277c;
                        i16 = i19;
                    }
                    i14 += u2Var.f12010b + i12;
                }
                return jb.v.f6774a;
        }
    }
}
