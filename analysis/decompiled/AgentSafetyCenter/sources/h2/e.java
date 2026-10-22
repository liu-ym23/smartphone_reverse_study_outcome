package h2;

import jb.v;
import yb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class e extends l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final e f5286f;

    /* renamed from: g, reason: collision with root package name */
    public static final e f5287g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5288c;

    static {
        int i = 1;
        f5286f = new e(i, 0);
        f5287g = new e(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ e(int i, int i3) {
        super(i);
        this.f5288c = i3;
    }

    @Override // xb.l
    public final /* synthetic */ Object invoke(Object obj) {
        switch (this.f5288c) {
            case 0:
                return v.f6774a;
            default:
                throw null;
        }
    }
}
