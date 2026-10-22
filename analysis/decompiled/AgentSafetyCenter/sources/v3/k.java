package v3;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashSet;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class k extends yb.l implements xb.a {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f14666c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ z f14667f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(z zVar, int i) {
        super(0);
        this.f14666c = i;
        this.f14667f = zVar;
    }

    @Override // xb.a
    public final Object invoke() throws IOException {
        switch (this.f14666c) {
            case 0:
                return ((g0) this.f14667f.f14760n.getValue()).f14638b;
            default:
                d0 d0Var = this.f14667f.f14752c;
                File canonicalFile = ((File) d0Var.f14620b.invoke()).getCanonicalFile();
                synchronized (d0.f14618d) {
                    String absolutePath = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = d0.f14617c;
                    if (linkedHashSet.contains(absolutePath)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + absolutePath + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    absolutePath.getClass();
                    linkedHashSet.add(absolutePath);
                }
                p0 p0Var = (p0) d0Var.f14619a.invoke(canonicalFile);
                ad.l lVar = new ad.l(canonicalFile, 28);
                p0Var.getClass();
                g0 g0Var = new g0();
                g0Var.f14637a = canonicalFile;
                g0Var.f14638b = p0Var;
                g0Var.f14639c = lVar;
                g0Var.f14640d = new AtomicBoolean(false);
                g0Var.f14641e = new sc.c();
                VarHandle.storeStoreFence();
                return g0Var;
        }
    }
}
