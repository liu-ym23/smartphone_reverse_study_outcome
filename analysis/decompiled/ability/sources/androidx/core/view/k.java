package androidx.core.view;

import android.view.ViewConfiguration;
import androidx.core.util.Supplier;

/* loaded from: classes2.dex */
public final /* synthetic */ class k implements Supplier {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1943a;
    public final /* synthetic */ ViewConfiguration b;

    public /* synthetic */ k(ViewConfiguration viewConfiguration, int i) {
        this.f1943a = i;
        this.b = viewConfiguration;
    }

    @Override // androidx.core.util.Supplier
    public final Object get() {
        int scaledMaximumFlingVelocity;
        int i = this.f1943a;
        ViewConfiguration viewConfiguration = this.b;
        switch (i) {
            case 0:
                scaledMaximumFlingVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
                break;
            default:
                scaledMaximumFlingVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
                break;
        }
        return Integer.valueOf(scaledMaximumFlingVelocity);
    }
}
