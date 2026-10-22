package e2;

import java.util.Comparator;
import k0.s0;
import u1.g0;
import yb.k;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class d implements Comparator {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3422c;

    public /* synthetic */ d(int i) {
        this.f3422c = i;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f3422c) {
            case 0:
                jb.g gVar = (jb.g) obj;
                jb.g gVar2 = (jb.g) obj2;
                return (((Number) gVar.f6760f).intValue() - ((Number) gVar.f6759c).intValue()) - (((Number) gVar2.f6760f).intValue() - ((Number) gVar2.f6759c).intValue());
            case 1:
                return k.b(((s0) obj).f7059b, ((s0) obj2).f7059b);
            case 2:
                byte[] bArr = (byte[]) obj;
                byte[] bArr2 = (byte[]) obj2;
                if (bArr.length != bArr2.length) {
                    return bArr.length - bArr2.length;
                }
                for (int i = 0; i < bArr.length; i++) {
                    byte b10 = bArr[i];
                    byte b11 = bArr2[i];
                    if (b10 != b11) {
                        return b10 - b11;
                    }
                }
                return 0;
            case 3:
                g0 g0Var = (g0) obj;
                g0 g0Var2 = (g0) obj2;
                float f5 = g0Var.I.f13857p.I;
                float f10 = g0Var2.I.f13857p.I;
                return f5 == f10 ? k.b(g0Var.u(), g0Var2.u()) : Float.compare(f5, f10);
            default:
                String strE = ((b8.a) obj).e();
                String strE2 = ((b8.a) obj2).e();
                if (!strE.equals(strE2)) {
                    if (!strE.equals("discriminator")) {
                        if (!strE2.equals("discriminator")) {
                            if (!strE.equals("type")) {
                                if (!strE2.equals("type")) {
                                    if (!strE.equals("properties")) {
                                        if (!strE2.equals("properties")) {
                                            if (!strE.equals("patternProperties")) {
                                                if (!strE2.equals("patternProperties") && !strE.equals("unevaluatedItems")) {
                                                    if (!strE2.equals("unevaluatedItems")) {
                                                        if (!strE.equals("unevaluatedProperties")) {
                                                            if (strE2.equals("unevaluatedProperties")) {
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return 1;
                    }
                    return -1;
                }
                return 0;
        }
    }
}
