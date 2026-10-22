package E3;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final a f2378a;

    /* renamed from: b, reason: collision with root package name */
    public final List<b> f2379b;

    public c(a aVar) {
        this.f2378a = aVar;
        ArrayList arrayList = new ArrayList();
        this.f2379b = arrayList;
        arrayList.add(new b(aVar, new int[]{1}));
    }

    public final b a(int i10) {
        if (i10 >= this.f2379b.size()) {
            List<b> list = this.f2379b;
            b bVarG = list.get(list.size() - 1);
            for (int size = this.f2379b.size(); size <= i10; size++) {
                a aVar = this.f2378a;
                bVarG = bVarG.g(new b(aVar, new int[]{1, aVar.c((size - 1) + aVar.d())}));
                this.f2379b.add(bVarG);
            }
        }
        return this.f2379b.get(i10);
    }

    public void b(int[] iArr, int i10) {
        if (i10 == 0) {
            throw new IllegalArgumentException("No error correction bytes");
        }
        int length = iArr.length - i10;
        if (length <= 0) {
            throw new IllegalArgumentException("No data bytes provided");
        }
        b bVarA = a(i10);
        int[] iArr2 = new int[length];
        System.arraycopy(iArr, 0, iArr2, 0, length);
        int[] iArrD = new b(this.f2378a, iArr2).h(i10, 1).b(bVarA)[1].d();
        int length2 = i10 - iArrD.length;
        for (int i11 = 0; i11 < length2; i11++) {
            iArr[length + i11] = 0;
        }
        System.arraycopy(iArrD, 0, iArr, length + length2, iArrD.length);
    }
}
