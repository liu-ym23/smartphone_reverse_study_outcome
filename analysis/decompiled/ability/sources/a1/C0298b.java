package a1;

import android.content.SharedPreferences;
import android.os.Process;
import g1.AbstractC1451a;

/* renamed from: a1.b, reason: case insensitive filesystem */
/* loaded from: classes2.dex */
public final class C0298b implements m1.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ M9.f f1628a;

    public C0298b(M9.f fVar) {
        this.f1628a = fVar;
    }

    @Override // m1.b
    public final void b() {
        ((SharedPreferences) this.f1628a.d).edit().putString(AbstractC1451a.A(), Process.myPid() + ",false").apply();
    }

    @Override // m1.b
    public final void c() {
        ((SharedPreferences) this.f1628a.d).edit().putString(AbstractC1451a.A(), Process.myPid() + ",true").apply();
    }
}
