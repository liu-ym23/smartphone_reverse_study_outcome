package t;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.DragEvent;
import java.io.Closeable;
import java.io.IOException;
import java.lang.invoke.VarHandle;
import java.util.Set;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13047a = 5;

    public static final x0.d a(String str) {
        Set setP = h5.t.P(str);
        x0.d dVar = new x0.d();
        dVar.f15514b = setP;
        VarHandle.storeStoreFence();
        return dVar;
    }

    public static final y3.e b(String str) {
        y3.e eVar = new y3.e();
        eVar.f15891a = str;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public static final void c(long j10, u.f0 f0Var) {
        if (f0Var == u.f0.f13453c) {
            if (o2.a.h(j10) != Integer.MAX_VALUE) {
                return;
            }
            od.f.e("Vertically scrollable component was measured with an infinity maximum height constraints, which is disallowed. One of the common reasons is nesting layouts like LazyColumn and Column(Modifier.verticalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyColumn scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        } else {
            if (o2.a.i(j10) != Integer.MAX_VALUE) {
                return;
            }
            od.f.e("Horizontally scrollable component was measured with an infinity maximum width constraints, which is disallowed. One of the common reasons is nesting layouts like LazyRow and Row(Modifier.horizontalScroll()). If you want to add a header before the list of items please add a header as a separate item() before the main items() inside the LazyRow scope. There are could be other reasons for this to happen: your ComposeView was added into a LinearLayout with some weight, you applied Modifier.wrapContentSize(unbounded = true) or wrote a custom layout. Please try to remove the source of infinite constraints in the hierarchy above the scrolling container.");
        }
    }

    public static final void d(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                com.stepos.statsrpk.h.b(th, th2);
            }
        }
    }

    public static void e(Closeable closeable) throws IOException {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e10) {
                Log.e("CommonUtils", "closeQuietly error " + e10.getMessage());
            }
        }
    }

    public static final int f(int i, Object obj, x.h hVar) {
        int iB;
        return (obj == null || hVar.c() == 0 || (i < hVar.c() && obj.equals(hVar.d(i))) || (iB = hVar.f15415d.b(obj)) == -1) ? i : iB;
    }

    public static final String[] g(x0.l lVar) {
        lVar.getClass();
        return (String[]) ((x0.d) lVar).f15514b.toArray(new String[0]);
    }

    public static final long h(sa.c cVar) {
        DragEvent dragEvent = (DragEvent) cVar.f12170f;
        float x6 = dragEvent.getX();
        float y10 = dragEvent.getY();
        return (Float.floatToRawIntBits(x6) << 32) | (Float.floatToRawIntBits(y10) & 4294967295L);
    }

    public static final Bundle i(Bundle bundle, String str) {
        Bundle bundle2 = bundle.getBundle(str);
        if (bundle2 != null) {
            return bundle2;
        }
        g5.f.s(k0.a.C("No valid saved state was found for the key '", str, "'. It may be missing, null, or not of the expected type. This can occur if the value was saved with a different type or if the saved state was modified unexpectedly."));
        return null;
    }

    public static boolean j(Context context) {
        try {
            String strG = t1.e.g("persist.stepos.usagestats.debug", "");
            if (strG == null) {
                return false;
            }
            if (strG.equals("all")) {
                return true;
            }
            return strG.equals(context.getPackageName());
        } catch (Exception e10) {
            Log.e("CommonUtils", "isDebugMode error " + e10.getMessage());
            return false;
        }
    }

    public static final y3.e k(String str) {
        y3.e eVar = new y3.e();
        eVar.f15891a = str;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public static final w0.m l(k0.s sVar, w0.m mVar) {
        if (mVar.a(w0.i.f15112c)) {
            return mVar;
        }
        sVar.Y(1219399079);
        w0.m mVar2 = (w0.m) mVar.c(w0.j.f15113c, new b0.s(sVar, 8));
        sVar.q(false);
        return mVar2;
    }

    public static final w0.m m(k0.s sVar, w0.m mVar) {
        sVar.X(439770924);
        w0.m mVarL = l(sVar, mVar);
        sVar.q(false);
        return mVarL;
    }

    public static final y3.e n(String str) {
        y3.e eVar = new y3.e();
        eVar.f15891a = str;
        VarHandle.storeStoreFence();
        return eVar;
    }

    public int hashCode() {
        switch (this.f13047a) {
            case 5:
                return toString().hashCode();
            default:
                return super.hashCode();
        }
    }

    public String toString() {
        switch (this.f13047a) {
            case 5:
                String strC = yb.v.a(getClass()).c();
                strC.getClass();
                return strC;
            default:
                return super.toString();
        }
    }
}
