package v0;

import android.view.View;
import java.util.List;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class q {

    /* renamed from: a, reason: collision with root package name */
    public boolean f5908a;

    /* renamed from: b, reason: collision with root package name */
    public int f5909b;

    /* renamed from: c, reason: collision with root package name */
    public int f5910c;
    public int d;

    /* renamed from: e, reason: collision with root package name */
    public int f5911e;

    /* renamed from: f, reason: collision with root package name */
    public int f5912f;

    /* renamed from: g, reason: collision with root package name */
    public int f5913g;

    /* renamed from: h, reason: collision with root package name */
    public int f5914h;

    /* renamed from: i, reason: collision with root package name */
    public int f5915i;

    /* renamed from: j, reason: collision with root package name */
    public List f5916j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f5917k;

    public final void a(View view) {
        if (this.f5916j.size() <= 0) {
            this.d = -1;
        } else {
            ((n0) this.f5916j.get(0)).getClass();
            throw null;
        }
    }

    public final View b(h0 h0Var) {
        List list = this.f5916j;
        if (list == null) {
            View viewD = h0Var.d(this.d);
            this.d += this.f5911e;
            return viewD;
        }
        if (list.size() <= 0) {
            return null;
        }
        ((n0) this.f5916j.get(0)).getClass();
        throw null;
    }
}
