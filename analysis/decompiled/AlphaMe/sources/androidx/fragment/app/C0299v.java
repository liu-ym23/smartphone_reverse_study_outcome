package androidx.fragment.app;

import android.view.View;
import androidx.lifecycle.EnumC0326x;

/* renamed from: androidx.fragment.app.v, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0299v implements androidx.lifecycle.E {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ D f3834a;

    public C0299v(D d4) {
        this.f3834a = d4;
    }

    @Override // androidx.lifecycle.E
    public final void a(androidx.lifecycle.G g4, EnumC0326x enumC0326x) {
        View view;
        if (enumC0326x != EnumC0326x.ON_STOP || (view = this.f3834a.mView) == null) {
            return;
        }
        view.cancelPendingInputEvents();
    }
}
