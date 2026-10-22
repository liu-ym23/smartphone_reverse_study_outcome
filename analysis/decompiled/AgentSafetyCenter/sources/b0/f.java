package b0;

import android.content.res.Configuration;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import d2.i0;
import java.util.List;
import k0.c1;
import k0.e0;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends yb.l implements xb.l {

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f1728c;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ c1 f1729f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ f(c1 c1Var, int i) {
        super(1);
        this.f1728c = i;
        this.f1729f = c1Var;
    }

    @Override // xb.l
    public final Object invoke(Object obj) {
        int i = this.f1728c;
        jb.v vVar = jb.v.f6774a;
        c1 c1Var = this.f1729f;
        switch (i) {
            case 0:
                c0.f fVar = (c0.f) obj;
                c1Var.setValue(fVar.f2135c ? fVar.f2134b : fVar.f2133a);
                break;
            case 1:
                List list = (List) obj;
                if (c1Var != null) {
                    c1Var.setValue(list);
                    break;
                }
                break;
            case 2:
                c1Var.setValue((i0) obj);
                break;
            default:
                Configuration configuration = new Configuration((Configuration) obj);
                e0 e0Var = AndroidCompositionLocals_androidKt.f981a;
                c1Var.setValue(configuration);
                break;
        }
        return vVar;
    }
}
