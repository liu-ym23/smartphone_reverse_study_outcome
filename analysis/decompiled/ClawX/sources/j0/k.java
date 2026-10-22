package j0;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashSet;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class k extends kotlin.jvm.internal.q implements p5.a {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f3382b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f3383c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ k(c0 c0Var, int i8) {
        super(0);
        this.f3382b = i8;
        this.f3383c = c0Var;
    }

    @Override // p5.a
    public final Object invoke() throws IOException {
        switch (this.f3382b) {
            case 0:
                return ((j0) this.f3383c.f3329k.getValue()).f3379b;
            default:
                g0 g0Var = this.f3383c.f3321a;
                File canonicalFile = ((File) g0Var.f3348b.invoke()).getCanonicalFile();
                synchronized (g0.d) {
                    String path = canonicalFile.getAbsolutePath();
                    LinkedHashSet linkedHashSet = g0.f3346c;
                    if (linkedHashSet.contains(path)) {
                        throw new IllegalStateException(("There are multiple DataStores active for the same file: " + path + ". You should either maintain your DataStore as a singleton or confirm that there is no two DataStore's active on the same file (by confirming that the scope is cancelled).").toString());
                    }
                    kotlin.jvm.internal.p.d(path, "path");
                    linkedHashSet.add(path);
                }
                return new j0(canonicalFile, (u0) g0Var.f3347a.invoke(canonicalFile), new androidx.lifecycle.e0(1, canonicalFile));
        }
    }
}
