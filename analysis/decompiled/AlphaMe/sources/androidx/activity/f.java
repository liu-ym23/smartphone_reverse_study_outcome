package androidx.activity;

import android.os.Bundle;
import androidx.fragment.app.G;
import androidx.fragment.app.Y;
import j0.InterfaceC0630e;

/* loaded from: classes.dex */
public final /* synthetic */ class f implements InterfaceC0630e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2387a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2388b;

    public /* synthetic */ f(int i4, Object obj) {
        this.f2387a = i4;
        this.f2388b = obj;
    }

    @Override // j0.InterfaceC0630e
    public final Bundle a() {
        int i4 = this.f2387a;
        Object obj = this.f2388b;
        switch (i4) {
            case 0:
                return o.b((o) obj);
            case 1:
                return G.d((G) obj);
            default:
                return ((Y) obj).R();
        }
    }
}
