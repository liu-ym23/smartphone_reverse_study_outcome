package n3;

import android.text.TextUtils;
import android.view.View;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends b4.c {
    public final /* synthetic */ int i;

    public b0(int i, Class cls, int i3, int i10, int i11) {
        this.i = i11;
        this.f1897c = i;
        this.f1900h = cls;
        this.f1899g = i3;
        this.f1898f = i10;
    }

    @Override // b4.c
    public final Object c(View view) {
        switch (this.i) {
            case 0:
                return h0.a(view);
            default:
                return j0.b(view);
        }
    }

    @Override // b4.c
    public final void d(View view, Object obj) {
        switch (this.i) {
            case 0:
                h0.d(view, (CharSequence) obj);
                break;
            default:
                j0.c(view, (CharSequence) obj);
                break;
        }
    }

    @Override // b4.c
    public final boolean g(Object obj, Object obj2) {
        boolean zEquals;
        switch (this.i) {
            case 0:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
            default:
                zEquals = TextUtils.equals((CharSequence) obj, (CharSequence) obj2);
                break;
        }
        return !zEquals;
    }
}
