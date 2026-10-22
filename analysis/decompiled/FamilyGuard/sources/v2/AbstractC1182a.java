package v2;

import androidx.lifecycle.AbstractC0545z;
import f2.C0702g;

/* renamed from: v2.a, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public abstract class AbstractC1182a {

    /* renamed from: a, reason: collision with root package name */
    private final e f23310a;

    public AbstractC1182a(e eVar) {
        this.f23310a = eVar;
    }

    protected AbstractC0545z<Object> G() {
        return this.f23310a.c();
    }

    public void H() {
        C0702g.b("BaseProxy", "initialize() called");
        this.f23310a.init();
    }

    public void I() {
        this.f23310a.a();
    }

    public AbstractC0545z<Boolean> b() {
        return this.f23310a.b();
    }
}
