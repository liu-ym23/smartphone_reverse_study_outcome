package K9;

import F9.A;
import F9.G;
import F9.M;
import F9.z;
import J9.i;
import java.util.ArrayList;
import kotlin.jvm.internal.k;

/* loaded from: classes4.dex */
public final class g implements z {

    /* renamed from: a, reason: collision with root package name */
    public final i f915a;
    public final ArrayList b;
    public final int c;
    public final G6.c d;
    public final G e;
    public final int f;
    public final int g;
    public final int h;
    public int i;

    public g(i iVar, ArrayList arrayList, int i, G6.c cVar, G g, int i6, int i10, int i11) {
        this.f915a = iVar;
        this.b = arrayList;
        this.c = i;
        this.d = cVar;
        this.e = g;
        this.f = i6;
        this.g = i10;
        this.h = i11;
    }

    public static g a(g gVar, int i, G6.c cVar, G g, int i6) {
        if ((i6 & 1) != 0) {
            i = gVar.c;
        }
        int i10 = i;
        if ((i6 & 2) != 0) {
            cVar = gVar.d;
        }
        G6.c cVar2 = cVar;
        if ((i6 & 4) != 0) {
            g = gVar.e;
        }
        G request = g;
        int i11 = gVar.f;
        int i12 = gVar.g;
        int i13 = gVar.h;
        k.f(request, "request");
        return new g(gVar.f915a, gVar.b, i10, cVar2, request, i11, i12, i13);
    }

    public final M b(G request) {
        k.f(request, "request");
        ArrayList arrayList = this.b;
        int size = arrayList.size();
        int i = this.c;
        if (i >= size) {
            throw new IllegalStateException("Check failed.");
        }
        this.i++;
        G6.c cVar = this.d;
        if (cVar != null) {
            if (!((J9.e) cVar.e).d(request.f626a)) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i - 1) + " must retain the same host and port").toString());
            }
            if (this.i != 1) {
                throw new IllegalStateException(("network interceptor " + arrayList.get(i - 1) + " must call proceed() exactly once").toString());
            }
        }
        int i6 = i + 1;
        g gVarA = a(this, i6, null, request, 58);
        A a3 = (A) arrayList.get(i);
        M mIntercept = a3.intercept(gVarA);
        if (mIntercept == null) {
            throw new NullPointerException("interceptor " + a3 + " returned null");
        }
        if (cVar != null && i6 < arrayList.size() && gVarA.i != 1) {
            throw new IllegalStateException(("network interceptor " + a3 + " must call proceed() exactly once").toString());
        }
        if (mIntercept.g != null) {
            return mIntercept;
        }
        throw new IllegalStateException(("interceptor " + a3 + " returned a response with no body").toString());
    }
}
