package d8;

import java.util.BitSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class w1 extends w2 {

    /* renamed from: f, reason: collision with root package name */
    public x1 f2192f;

    /* renamed from: g, reason: collision with root package name */
    public BitSet f2193g;

    @Override // d8.w2
    public final void j(u uVar) throws l4 {
        this.f2192f = new x1(uVar);
        this.f2193g = new BitSet();
        int iRemaining = uVar.f2171a.remaining();
        for (int i8 = 0; i8 < iRemaining; i8++) {
            int iF = uVar.f();
            for (int i9 = 0; i9 < 8; i9++) {
                if (((1 << (7 - i9)) & iF) != 0) {
                    this.f2193g.set((i8 * 8) + i9);
                }
            }
        }
    }

    @Override // d8.w2
    public final String k() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f2192f);
        int length = this.f2193g.length();
        for (short s8 = 0; s8 < length; s8 = (short) (s8 + 1)) {
            if (this.f2193g.get(s8)) {
                sb.append(" ");
                sb.append(f4.f1995a.d(s8));
            }
        }
        return sb.toString();
    }

    @Override // d8.w2
    public final void l(b0.j jVar, n nVar, boolean z) {
        this.f2192f.j(jVar, null, z);
        int length = this.f2193g.length();
        int i8 = 0;
        for (int i9 = 0; i9 < length; i9++) {
            i8 |= this.f2193g.get(i9) ? 1 << (7 - (i9 % 8)) : 0;
            if (i9 % 8 == 7 || i9 == length - 1) {
                jVar.m(i8);
                i8 = 0;
            }
        }
    }
}
