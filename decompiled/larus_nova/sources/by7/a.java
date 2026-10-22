package by7;

import com.ixigua.lib.track.TrackParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TrackParams f21463a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public e f21464b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final List<Class<? extends d>> f21465c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f21466d;

    public final void b() {
        g.f21473d.onEvent(this.f21466d, c());
    }

    public final JSONObject c() {
        e r100 = this.f21464b;
        if (r100 == null) goto L17;
        ey7.b.a(r100, this.f21463a);
        if ((!((ArrayList) this.f21465c).isEmpty()) == false) goto L17;
        String r101 = ey7.e.a(r100);
        if (r101 == null) goto L9;
        j r102 = ey7.e.f474811a.get(r101);
    L10:
        if (r102 == null) goto L17;
        Iterator r103 = ((ArrayList) this.f21465c).iterator();
        if (r103.hasNext() == false) goto L17;
        Class r104 = (Class) r103.next();
        throw null;
    L9:
        r102 = null;
    L17:
        return this.f21463a.makeJSONObject();
    }

    public a(String r100) {
        this.f21466d = r100;
        this.f21463a = new TrackParams();
        this.f21465c = new ArrayList();
    }

    public final void a(e r100) {
        this.f21464b = r100;
    }

    public final void d(String r100, Object r101) {
        this.f21463a.put(r100, r101);
    }
}
