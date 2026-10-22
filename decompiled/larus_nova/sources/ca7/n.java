package ca7;

import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes11.dex */
public final class n extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a f22968c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final HashMap<Object, a> f22969a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ArrayList<i> f22970b;

        public a() {
            this.f22969a = new HashMap();
            this.f22970b = new ArrayList();
        }
    }

    public n() {
        this.f22968c = new a();
    }

    @Override // ca7.c
    public final void c(da7.b r100) {
        if (b(r100) == true) goto L23;
        return;
    L23:
        String r101 = (String) r100.f467703g.d(r100);     // Catch: Exception -> L22
        if (r101 != null) goto L8;
        return;
    L8:
        String[] r102 = r101.split(HTTP.URL_DEFAULT);     // Catch: Exception -> L22
        a r103 = this.f22968c;     // Catch: Exception -> L22
        int r104 = 0;
    L9:
        if (r104 >= r102.length) goto L29;
        if (r103.f22970b.isEmpty() == true) goto L18;
        Iterator<i> r105 = r103.f22970b.iterator();     // Catch: Exception -> L22
    L15:
        if (r105.hasNext() == false) goto L18;
        i r106 = r105.next();     // Catch: Exception -> L22
        r106.e(r100, r100.f467703g);     // Catch: Exception -> L22
        r106.c(r100);     // Catch: Exception -> L22
    L18:
        if (r103.f22969a.containsKey(r102[r104]) == false) goto L28;
        r103 = r103.f22969a.get(r102[r104]);     // Catch: Exception -> L22
        r104 = r104 + 1;
        goto L9
    L28:
        return;
    L29:
        return;
    }

    @Override // ca7.c
    public final void e(da7.b r100, c r101) {
        r100.a(this).f467705a = true;
        r100.f467703g = r101;
    }
}
