package x1;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle;
import b6.g;
import java.util.LinkedHashMap;
import mb.y;
import w1.d;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public final d f13696a;

    /* renamed from: b, reason: collision with root package name */
    public final g f13697b;

    /* renamed from: e, reason: collision with root package name */
    public boolean f13700e;

    /* renamed from: f, reason: collision with root package name */
    public Bundle f13701f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f13702g;

    /* renamed from: c, reason: collision with root package name */
    public final y f13698c = new y();

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashMap f13699d = new LinkedHashMap();
    public boolean h = true;

    public a(d dVar, g gVar) {
        this.f13696a = dVar;
        this.f13697b = gVar;
    }

    public final void a() {
        d dVar = this.f13696a;
        if (dVar.getLifecycle().b() != Lifecycle.State.f2215b) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        if (this.f13700e) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        this.f13697b.invoke();
        dVar.getLifecycle().a(new b.g(this, 1));
        this.f13700e = true;
    }
}
