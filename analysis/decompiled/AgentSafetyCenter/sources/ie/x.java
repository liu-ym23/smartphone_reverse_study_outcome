package ie;

import java.lang.reflect.Array;
import java.util.Iterator;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
public final class x extends w0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f6097b;

    /* renamed from: c, reason: collision with root package name */
    public /* synthetic */ w0 f6098c;

    @Override // ie.w0
    public final void a(l0 l0Var, Object obj) {
        switch (this.f6097b) {
            case 0:
                Iterable iterable = (Iterable) obj;
                if (iterable != null) {
                    Iterator it = iterable.iterator();
                    while (it.hasNext()) {
                        this.f6098c.a(l0Var, it.next());
                    }
                    break;
                }
                break;
            default:
                if (obj != null) {
                    int length = Array.getLength(obj);
                    for (int i = 0; i < length; i++) {
                        this.f6098c.a(l0Var, Array.get(obj, i));
                    }
                    break;
                }
                break;
        }
    }
}
