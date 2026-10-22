package d8;

import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.TreeSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class g4 implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public final TreeSet f2008a = new TreeSet();

    public g4(u uVar) throws l4 {
        while (true) {
            ByteBuffer byteBuffer = uVar.f2171a;
            if (byteBuffer.remaining() <= 0) {
                return;
            }
            if (byteBuffer.remaining() < 2) {
                throw new l4("invalid bitmap descriptor");
            }
            int iF = uVar.f();
            if (iF < -1) {
                throw new l4("invalid ordering");
            }
            int iF2 = uVar.f();
            if (iF2 > byteBuffer.remaining()) {
                throw new l4("invalid bitmap");
            }
            for (int i8 = 0; i8 < iF2; i8++) {
                int iF3 = uVar.f();
                for (int i9 = 0; i9 < 8 && iF3 > 0; i9++) {
                    if (((1 << (7 - i9)) & iF3) != 0) {
                        this.f2008a.add(Integer.valueOf((i8 * 8) + (iF * 256) + i9));
                    }
                }
            }
        }
    }

    public static void a(b0.j jVar, TreeSet treeSet, int i8) {
        int iIntValue = ((((Integer) treeSet.last()).intValue() & 255) / 8) + 1;
        int[] iArr = new int[iIntValue];
        jVar.m(i8);
        jVar.m(iIntValue);
        Iterator it = treeSet.iterator();
        while (it.hasNext()) {
            int iIntValue2 = ((Integer) it.next()).intValue();
            int i9 = (iIntValue2 & 255) / 8;
            iArr[i9] = (1 << (7 - (iIntValue2 % 8))) | iArr[i9];
        }
        for (int i10 = 0; i10 < iIntValue; i10++) {
            jVar.m(iArr[i10]);
        }
    }

    public final void b(b0.j jVar) {
        TreeSet treeSet = this.f2008a;
        if (treeSet.isEmpty()) {
            return;
        }
        TreeSet treeSet2 = new TreeSet();
        Iterator it = treeSet.iterator();
        int i8 = -1;
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            int iIntValue = num.intValue() >> 8;
            if (iIntValue != i8) {
                if (!treeSet2.isEmpty()) {
                    a(jVar, treeSet2, i8);
                    treeSet2.clear();
                }
                i8 = iIntValue;
            }
            treeSet2.add(num);
        }
        a(jVar, treeSet2, i8);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator it = this.f2008a.iterator();
        while (it.hasNext()) {
            sb.append(f4.f1995a.d(((Integer) it.next()).intValue()));
            if (it.hasNext()) {
                sb.append(' ');
            }
        }
        return sb.toString();
    }
}
