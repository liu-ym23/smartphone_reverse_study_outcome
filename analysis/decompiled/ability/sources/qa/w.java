package qa;

import java.lang.reflect.Array;
import java.util.Iterator;

/* loaded from: classes4.dex */
public final class w extends U {
    public final /* synthetic */ int d;
    public final /* synthetic */ U e;

    public /* synthetic */ w(U u, int i) {
        this.d = i;
        this.e = u;
    }

    @Override // qa.U
    public final void a(I i, Object obj) {
        switch (this.d) {
            case 0:
                Iterable iterable = (Iterable) obj;
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        this.e.a(i, it.next());
                    }
                    break;
                }
                break;
            default:
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i6 = 0; i6 < length; i6++) {
                        this.e.a(i, Array.get(obj, i6));
                    }
                    break;
                }
                break;
        }
    }
}
