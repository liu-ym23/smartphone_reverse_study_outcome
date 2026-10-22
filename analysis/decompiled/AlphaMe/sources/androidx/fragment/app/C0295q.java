package androidx.fragment.app;

import android.app.Dialog;
import android.view.View;

/* renamed from: androidx.fragment.app.q, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0295q extends J {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ J f3799a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ r f3800b;

    public C0295q(r rVar, J j4) {
        this.f3800b = rVar;
        this.f3799a = j4;
    }

    @Override // androidx.fragment.app.J
    public final View b(int i4) {
        J j4 = this.f3799a;
        if (j4.c()) {
            return j4.b(i4);
        }
        Dialog dialog = this.f3800b.f3820l;
        if (dialog != null) {
            return dialog.findViewById(i4);
        }
        return null;
    }

    @Override // androidx.fragment.app.J
    public final boolean c() {
        return this.f3799a.c() || this.f3800b.f3824p;
    }
}
