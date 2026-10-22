package i4;

import android.view.View;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.lifecycle.d1;
import androidx.lifecycle.s0;
import androidx.room.c;
import k0.e0;
import k0.s;
import k0.z;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final e0 f5776a = z.n(new c(12));

    public static d1 a(s sVar) {
        d1 d1VarE = (d1) sVar.j(f5776a);
        if (d1VarE == null) {
            sVar.X(1260197608);
            d1VarE = s0.e((View) sVar.j(AndroidCompositionLocals_androidKt.f986f));
        } else {
            sVar.X(1260196492);
        }
        sVar.q(false);
        return d1VarE;
    }
}
