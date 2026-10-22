package i1;

import android.graphics.PathMeasure;
import java.lang.invoke.VarHandle;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class g extends yb.l implements xb.a {

    /* renamed from: f, reason: collision with root package name */
    public static final g f5670f;

    /* renamed from: g, reason: collision with root package name */
    public static final g f5671g;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f5672c;

    static {
        int i = 0;
        f5670f = new g(i, 0);
        f5671g = new g(i, 1);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ g(int i, int i3) {
        super(i);
        this.f5672c = i3;
    }

    @Override // xb.a
    public final Object invoke() {
        switch (this.f5672c) {
            case 0:
                PathMeasure pathMeasure = new PathMeasure();
                d1.j jVar = new d1.j();
                jVar.f3001a = pathMeasure;
                VarHandle.storeStoreFence();
                return jVar;
            default:
                return jb.v.f6774a;
        }
    }
}
