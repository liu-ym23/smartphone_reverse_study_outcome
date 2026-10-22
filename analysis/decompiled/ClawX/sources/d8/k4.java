package d8;

import java.util.ArrayList;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k4 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public byte[] f2054f;

    /* renamed from: g, reason: collision with root package name */
    public int f2055g;

    /* renamed from: h, reason: collision with root package name */
    public int[] f2056h;

    @Override // d8.w2
    public final void j(u uVar) {
        this.f2054f = uVar.b(4);
        this.f2055g = uVar.f();
        byte[] bArrA = uVar.a();
        ArrayList arrayList = new ArrayList();
        for (int i8 = 0; i8 < bArrA.length; i8++) {
            for (int i9 = 0; i9 < 8; i9++) {
                if ((bArrA[i8] & 255 & (1 << (7 - i9))) != 0) {
                    arrayList.add(Integer.valueOf((i8 * 8) + i9));
                }
            }
        }
        this.f2056h = new int[arrayList.size()];
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            this.f2056h[i10] = ((Integer) arrayList.get(i10)).intValue();
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(a.a.e0(this.f2054f));
        sb.append(" ");
        sb.append(this.f2055g);
        for (int i8 : this.f2056h) {
            sb.append(" ");
            sb.append(i8);
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        jVar.h(this.f2054f);
        jVar.m(this.f2055g);
        int[] iArr = this.f2056h;
        int i8 = (iArr[iArr.length - 1] / 8) + 1;
        byte[] bArr = new byte[i8];
        for (int i9 : iArr) {
            int i10 = i9 / 8;
            bArr[i10] = (byte) (((byte) (1 << (7 - (i9 % 8)))) | bArr[i10]);
        }
        jVar.g(0, i8, bArr);
    }
}
