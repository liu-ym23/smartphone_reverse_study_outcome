package k3;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class d implements Callable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f7220c;

    /* renamed from: f, reason: collision with root package name */
    public /* synthetic */ String f7221f;

    /* renamed from: g, reason: collision with root package name */
    public /* synthetic */ Context f7222g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ int f7223h;
    public /* synthetic */ Object i;

    public /* synthetic */ d(int i) {
        this.f7220c = i;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        switch (this.f7220c) {
            case 0:
                return g.b(this.f7221f, this.f7222g, List.of((c) this.i), this.f7223h);
            default:
                try {
                    return g.b(this.f7221f, this.f7222g, (ArrayList) this.i, this.f7223h);
                } catch (Throwable unused) {
                    return new f(-3);
                }
        }
    }
}
