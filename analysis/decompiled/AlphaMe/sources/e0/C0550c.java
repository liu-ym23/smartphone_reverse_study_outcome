package e0;

import B0.g;
import androidx.lifecycle.G;
import androidx.lifecycle.t0;
import java.io.PrintWriter;
import q.m;

/* renamed from: e0.c, reason: case insensitive filesystem */
/* loaded from: classes.dex */
public final class C0550c extends AbstractC0548a {

    /* renamed from: a, reason: collision with root package name */
    public final G f12499a;

    /* renamed from: b, reason: collision with root package name */
    public final C0549b f12500b;

    public C0550c(G g4, t0 t0Var) {
        this.f12499a = g4;
        this.f12500b = (C0549b) new android.support.v4.media.session.c(t0Var, C0549b.f12497b).e(C0549b.class);
    }

    public final void b(String str, PrintWriter printWriter) {
        m mVar = this.f12500b.f12498a;
        if (mVar.f13973c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            if (mVar.f13973c <= 0) {
                return;
            }
            g.y(mVar.f13972b[0]);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(mVar.f13971a[0]);
            printWriter.print(": ");
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        G g4 = this.f12499a;
        if (g4 == null) {
            sb.append("null");
        } else {
            String simpleName = g4.getClass().getSimpleName();
            if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = g4.getClass().getName()).lastIndexOf(46)) > 0) {
                simpleName = simpleName.substring(iLastIndexOf + 1);
            }
            sb.append(simpleName);
            sb.append('{');
            sb.append(Integer.toHexString(System.identityHashCode(g4)));
        }
        sb.append("}}");
        return sb.toString();
    }
}
