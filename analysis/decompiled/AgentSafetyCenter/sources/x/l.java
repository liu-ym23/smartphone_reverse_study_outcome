package x;

import java.util.List;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class l extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final l f15436f;

    /* renamed from: g, reason: collision with root package name */
    public static final l f15437g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f15438c;

    static {
        int i = 1;
        f15436f = new l(i, 0);
        f15437g = new l(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ l(int i, int i3) {
        super(i);
        this.f15438c = i3;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        switch (this.f15438c) {
            case 0:
                return v.f6774a;
            case 1:
                List list = (List) obj;
                return new r(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
            default:
                ((Number) obj).intValue();
                return null;
        }
    }
}
