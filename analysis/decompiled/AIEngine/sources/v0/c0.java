package v0;

import android.text.TextUtils;
import android.view.View;
import v0.e0;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c0 extends e0.b<CharSequence> {
    @Override // v0.e0.b
    public final CharSequence a(View view) {
        return e0.i.b(view);
    }

    @Override // v0.e0.b
    public final void b(View view, CharSequence charSequence) {
        e0.i.c(view, charSequence);
    }

    @Override // v0.e0.b
    public final boolean d(CharSequence charSequence, CharSequence charSequence2) {
        return !TextUtils.equals(charSequence, charSequence2);
    }
}
