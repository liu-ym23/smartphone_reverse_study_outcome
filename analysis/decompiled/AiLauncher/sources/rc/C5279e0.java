package rc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.scilab.forge.jlatexmath.ParseException;

/* renamed from: rc.e0, reason: case insensitive filesystem */
/* loaded from: classes5.dex */
public class C5279e0 extends AbstractC5276d {

    /* renamed from: j, reason: collision with root package name */
    public static R0 f39270j = new R0(0, 1.0f, 0.0f, 0.0f);

    /* renamed from: k, reason: collision with root package name */
    public static R0 f39271k = new R0(0, 0.5f, 0.0f, 0.0f);

    /* renamed from: l, reason: collision with root package name */
    public static R0 f39272l = new R0(1, 0.0f, 1.0f, 0.0f);

    /* renamed from: m, reason: collision with root package name */
    public static R0 f39273m = new R0(1, 0.0f, 0.4f, 0.0f);

    /* renamed from: n, reason: collision with root package name */
    public static R0 f39274n = new R0(1, 0.0f, 0.4f, 0.0f);

    /* renamed from: o, reason: collision with root package name */
    public static final AbstractC5284h f39275o = new U0(0.0f, 0.0f, 0.0f, 0.0f);

    /* renamed from: p, reason: collision with root package name */
    public static R0 f39276p = new R0(2);

    /* renamed from: d, reason: collision with root package name */
    public C5274c f39277d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f39278e;

    /* renamed from: f, reason: collision with root package name */
    public Map<Integer, r1> f39279f;

    /* renamed from: g, reason: collision with root package name */
    public int f39280g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f39281h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f39282i;

    public C5279e0(boolean z10, C5274c c5274c, String str, boolean z11) throws ParseException, NumberFormatException {
        this.f39279f = new HashMap();
        this.f39281h = z10;
        this.f39277d = c5274c;
        this.f39280g = 0;
        this.f39282i = z11;
        k(new StringBuffer(str));
    }

    /* JADX WARN: Removed duplicated region for block: B:65:0x01fc  */
    @Override // rc.AbstractC5276d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public rc.AbstractC5284h f(rc.Y0 r28) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.C5279e0.f(rc.Y0):rc.h");
    }

    public final AbstractC5284h i(Y0 y02, AbstractC5284h[] abstractC5284hArr, float[] fArr, int i10, int i11) {
        C5287i0 c5287i0 = (C5287i0) this.f39277d.f39230o.get(i10).get(i11);
        int iK = c5287i0.k();
        int i12 = i11;
        float fK = 0.0f;
        while (i12 < (i11 + iK) - 1) {
            float f10 = fArr[i12];
            i12++;
            fK += f10 + abstractC5284hArr[i12].k();
            if (this.f39279f.get(Integer.valueOf(i12)) != null) {
                fK += this.f39279f.get(Integer.valueOf(i12)).i(y02);
            }
        }
        float f11 = fK + fArr[i12];
        c5287i0.q(c5287i0.f(y02).k() <= f11 ? f11 : 0.0f);
        return c5287i0.f(y02);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00d5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public rc.AbstractC5284h[] j(rc.Y0 r10, float r11) {
        /*
            Method dump skipped, instructions count: 330
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rc.C5279e0.j(rc.Y0, float):rc.h[]");
    }

    public final void k(StringBuffer stringBuffer) throws ParseException, NumberFormatException {
        int iU;
        int length = stringBuffer.length();
        ArrayList arrayList = new ArrayList();
        int i10 = 0;
        while (i10 < length) {
            char cCharAt = stringBuffer.charAt(i10);
            if (cCharAt != '\t' && cCharAt != ' ') {
                if (cCharAt == '*') {
                    int i11 = i10 + 1;
                    d1 d1Var = new d1(this.f39281h, stringBuffer.substring(i11), new a1(), false);
                    String[] strArrS = d1Var.s(2, 0);
                    iU = i11 + d1Var.u();
                    int i12 = Integer.parseInt(strArrS[1]);
                    String str = "";
                    for (int i13 = 0; i13 < i12; i13++) {
                        str = str + strArrS[2];
                    }
                    stringBuffer.insert(iU, str);
                    length = stringBuffer.length();
                } else if (cCharAt == '@') {
                    int i14 = i10 + 1;
                    d1 d1Var2 = new d1(this.f39281h, stringBuffer.substring(i14), new a1(), false);
                    AbstractC5276d abstractC5276dG = d1Var2.g();
                    this.f39277d.f39231p++;
                    int i15 = 0;
                    while (true) {
                        C5274c c5274c = this.f39277d;
                        if (i15 >= c5274c.f39232q) {
                            break;
                        }
                        c5274c.f39230o.get(i15).add(arrayList.size(), abstractC5276dG);
                        i15++;
                    }
                    arrayList.add(5);
                    iU = i14 + d1Var2.u();
                } else if (cCharAt == 'c') {
                    arrayList.add(2);
                } else if (cCharAt == 'l') {
                    arrayList.add(0);
                } else if (cCharAt == 'r') {
                    arrayList.add(1);
                } else if (cCharAt != '|') {
                    arrayList.add(2);
                } else {
                    int i16 = 1;
                    while (true) {
                        int i17 = i10 + 1;
                        if (i17 >= length) {
                            i10 = i17;
                            break;
                        } else {
                            if (stringBuffer.charAt(i17) != '|') {
                                break;
                            }
                            i16++;
                            i10 = i17;
                        }
                    }
                    this.f39279f.put(Integer.valueOf(arrayList.size()), new r1(i16));
                }
                i10 = iU - 1;
            }
            i10++;
        }
        for (int size = arrayList.size(); size < this.f39277d.f39231p; size++) {
            arrayList.add(2);
        }
        if (arrayList.size() == 0) {
            this.f39278e = new int[]{2};
            return;
        }
        Integer[] numArr = (Integer[]) arrayList.toArray(new Integer[0]);
        this.f39278e = new int[numArr.length];
        for (int i18 = 0; i18 < numArr.length; i18++) {
            this.f39278e[i18] = numArr[i18].intValue();
        }
    }

    public C5279e0(boolean z10, C5274c c5274c, String str) {
        this(z10, c5274c, str, false);
    }

    public C5279e0(boolean z10, C5274c c5274c, int i10) {
        this(z10, c5274c, i10, false);
    }

    public C5279e0(boolean z10, C5274c c5274c, int i10, boolean z11) {
        this.f39279f = new HashMap();
        this.f39281h = z10;
        this.f39277d = c5274c;
        this.f39280g = i10;
        this.f39282i = z11;
        if (i10 != 1 && i10 != 5) {
            this.f39278e = new int[c5274c.f39231p];
            int i11 = 0;
            while (true) {
                int i12 = this.f39277d.f39231p;
                if (i11 >= i12) {
                    return;
                }
                int[] iArr = this.f39278e;
                iArr[i11] = 1;
                int i13 = i11 + 1;
                if (i13 < i12) {
                    iArr[i13] = 0;
                }
                i11 += 2;
            }
        } else {
            this.f39278e = new int[c5274c.f39231p];
            for (int i14 = 0; i14 < this.f39277d.f39231p; i14++) {
                this.f39278e[i14] = 2;
            }
        }
    }
}
