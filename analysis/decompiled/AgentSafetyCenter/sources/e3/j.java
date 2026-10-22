package e3;

import android.util.Log;
import io.modelcontextprotocol.spec.McpStreamableServerSession;
import o8.n;
import p.a0;
import v1.t;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final /* synthetic */ class j implements Runnable {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f3477c;

    public /* synthetic */ j(int i) {
        this.f3477c = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f3477c) {
            case 0:
                return;
            case 1:
                McpStreamableServerSession.lambda$delete$2();
                return;
            case 2:
                n.f9330k = null;
                if (n.f9324d != 0 || n.f9327g) {
                    return;
                }
                Log.d("ScreenLockAuthManager", "no activity started: clear screen lock session");
                n.b();
                return;
            default:
                a0 a0Var = t.L0;
                synchronized (a0Var) {
                    Object[] objArr = a0Var.f9516a;
                    int i = a0Var.f9517b;
                    for (int i3 = 0; i3 < i; i3++) {
                        t.m(((t) objArr[i3]).getRoot());
                    }
                }
                return;
        }
    }

    private final void a() {
    }
}
