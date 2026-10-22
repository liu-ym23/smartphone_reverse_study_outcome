package k3;

import android.os.Bundle;
import androidx.lifecycle.k0;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import c.d;
import c.i;
import h4.n;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final i f5581a;

    /* renamed from: b, reason: collision with root package name */
    public final k0 f5582b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f5585e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f5586f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f5587g;

    /* renamed from: c, reason: collision with root package name */
    public final n f5583c = new n(5, false);

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f5584d = new LinkedHashMap();

    /* renamed from: h, reason: collision with root package name */
    public boolean f5588h = true;

    public a(i iVar, k0 k0Var) {
        this.f5581a = iVar;
        this.f5582b = k0Var;
    }

    public final void a() {
        x xVar = this.f5581a.f4074f;
        if (xVar.f1035c != q.f1021g) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.f5585e) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.f5582b.c();
        xVar.a(new d(2, this));
        this.f5585e = true;
    }
}
