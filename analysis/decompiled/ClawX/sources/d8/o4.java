package d8;

import java.util.HashMap;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class o4 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public long f2106f;

    /* renamed from: g, reason: collision with root package name */
    public int f2107g;

    /* renamed from: h, reason: collision with root package name */
    public int f2108h;

    /* renamed from: j, reason: collision with root package name */
    public byte[] f2109j;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        String string;
        this.f2106f = uVar.e();
        this.f2107g = uVar.f();
        this.f2108h = uVar.f();
        byte[] bArrA = uVar.a();
        this.f2109j = bArrA;
        int i8 = this.f2108h;
        HashMap map = n4.f2097b;
        Integer num = (Integer) map.get(Integer.valueOf(i8));
        int iIntValue = num == null ? -1 : num.intValue();
        if (iIntValue != -1 && iIntValue != bArrA.length) {
            StringBuilder sb = new StringBuilder("Digest size for ");
            sb.append(n4.f2096a.d(i8));
            sb.append(" be exactly ");
            Integer num2 = (Integer) map.get(Integer.valueOf(i8));
            sb.append(num2 != null ? num2.intValue() : -1);
            sb.append(" bytes, got ");
            sb.append(bArrA.length);
            string = sb.toString();
        } else if (bArrA.length < 12) {
            string = "Digest size must be at least 12 bytes, got " + bArrA.length;
        } else {
            string = null;
        }
        if (string != null) {
            throw new l4(string);
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2106f);
        sb.append(" ");
        sb.append(this.f2107g);
        sb.append(" ");
        String strE = m0.f.e(sb, this.f2108h, " ");
        if (!p2.a()) {
            return strE + b8.h.O(this.f2109j);
        }
        return strE + "(" + a.a.h0(b8.h.O(this.f2109j), 48, true);
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.l(this.f2106f);
        jVar.m(this.f2107g);
        jVar.m(this.f2108h);
        jVar.h(this.f2109j);
    }
}
