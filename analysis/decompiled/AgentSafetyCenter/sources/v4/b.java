package v4;

import ab.e;
import android.os.Bundle;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import java.lang.invoke.VarHandle;
import java.util.LinkedHashMap;
import r2.i;
import t4.f;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public f f14764a;

    /* renamed from: b, reason: collision with root package name */
    public e f14765b;

    /* renamed from: c, reason: collision with root package name */
    public i f14766c;

    /* renamed from: d, reason: collision with root package name */
    public LinkedHashMap f14767d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f14768e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f14769f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f14770g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f14771h;

    public final void a() {
        f fVar = this.f14764a;
        if (fVar.getLifecycle().b() != p.f1419f) {
            od.f.e("Restarter must be created only during owner's initialization stage");
            return;
        }
        if (this.f14768e) {
            od.f.e("SavedStateRegistry was already attached.");
            return;
        }
        this.f14765b.invoke();
        q lifecycle = fVar.getLifecycle();
        a aVar = new a();
        aVar.f14763c = this;
        VarHandle.storeStoreFence();
        lifecycle.a(aVar);
        this.f14768e = true;
    }
}
