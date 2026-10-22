package btc;

import android.text.Spanned;
import android.text.method.MovementMethod;
import android.widget.TextView;
import ctc.d;
import lsc.j;
import lsc.r;
import msc.o;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends lsc.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MovementMethod f20713a;

    public b(d r100) {
        this.f20713a = r100;
    }

    @Override // lsc.a, lsc.j
    public final void j(j.a r100) {
        ((o) ((r) r100).c(o.class)).f515536b = true;
    }

    @Override // lsc.a, lsc.j
    public final void f(TextView r100, Spanned r101) {
        MovementMethod r102 = r100.getMovementMethod();
        MovementMethod r103 = this.f20713a;
        if (r102 == r103) goto L6;
        r100.setMovementMethod(r103);
        return;
    }
}
