package ch2;

import com.bytedance.android.livesdk.livecommerce.utils.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import si2.p;
import xi2.l;
import xi2.n;

/* JADX INFO: loaded from: classes10.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<p> f23758a;

    public a() {
        this.f23758a = new ArrayList();
    }

    public final void a(n r100) {
        if (r100 == null) goto L9;
        List<l> r101 = r100.couponList;
        if (r101 == null) goto L11;
        ((ArrayList) this.f23758a).clear();
        Iterator<l> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L12;
        p r103 = k.b(r102.next());
        ((ArrayList) this.f23758a).add(r103);
        goto L7
    L12:
        return;
    L11:
        return;
    }
}
