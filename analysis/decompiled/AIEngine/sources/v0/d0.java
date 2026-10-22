package v0;

import android.view.View;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class d0 extends e0.b<Boolean> {
    @Override // v0.e0.b
    public final Boolean a(View view) {
        return Boolean.valueOf(e0.g.b(view));
    }

    @Override // v0.e0.b
    public final void b(View view, Boolean bool) {
        e0.g.d(view, bool.booleanValue());
    }

    @Override // v0.e0.b
    public final boolean d(Boolean bool, Boolean bool2) {
        Boolean bool3 = bool;
        Boolean bool4 = bool2;
        return !((bool3 != null && bool3.booleanValue()) == (bool4 != null && bool4.booleanValue()));
    }
}
