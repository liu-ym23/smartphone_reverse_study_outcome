package r2;

import android.os.Handler;
import java.lang.invoke.VarHandle;
import jb.v;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class c extends yb.l implements xb.l {

    /* renamed from: f, reason: collision with root package name */
    public static final c f10370f;

    /* renamed from: g, reason: collision with root package name */
    public static final c f10371g;

    /* renamed from: h, reason: collision with root package name */
    public static final c f10372h;
    public static final c i;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f10373c;

    static {
        int i3 = 1;
        f10370f = new c(i3, 0);
        f10371g = new c(i3, 1);
        f10372h = new c(i3, 2);
        i = new c(i3, 3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ c(int i3, int i10) {
        super(i3);
        this.f10373c = i10;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i3 = this.f10373c;
        v vVar = v.f6774a;
        switch (i3) {
            case 0:
                h hVar = (h) obj;
                Handler handler = hVar.getHandler();
                g gVar = hVar.f10402u;
                b bVar = new b(0);
                bVar.f10369f = gVar;
                VarHandle.storeStoreFence();
                handler.post(bVar);
                break;
            case 1:
                break;
            case 2:
                break;
            default:
                break;
        }
        return vVar;
    }
}
