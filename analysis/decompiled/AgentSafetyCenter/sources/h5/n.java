package h5;

import android.text.TextUtils;
import g5.f0;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class n {
    public static final String i = g5.u.f("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final r f5354a;

    /* renamed from: b, reason: collision with root package name */
    public final String f5355b;

    /* renamed from: c, reason: collision with root package name */
    public final int f5356c;

    /* renamed from: d, reason: collision with root package name */
    public final List f5357d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f5358e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f5359f = new ArrayList();

    /* renamed from: g, reason: collision with root package name */
    public boolean f5360g;

    /* renamed from: h, reason: collision with root package name */
    public g5.j f5361h;

    public n(r rVar, String str, int i3, List list, int i10) {
        this.f5354a = rVar;
        this.f5355b = str;
        this.f5356c = i3;
        this.f5357d = list;
        this.f5358e = new ArrayList(list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            if (i3 == 1 && ((f0) list.get(i11)).f4314b.f9783u != Long.MAX_VALUE) {
                g5.f.s("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
                throw null;
            }
            String string = ((f0) list.get(i11)).f4313a.toString();
            string.getClass();
            this.f5358e.add(string);
            this.f5359f.add(string);
        }
    }

    public static HashSet b(n nVar) {
        HashSet hashSet = new HashSet();
        nVar.getClass();
        return hashSet;
    }

    public final g5.j a() {
        String str;
        if (this.f5360g) {
            g5.u.d().g(i, "Already enqueued work ids (" + TextUtils.join(", ", this.f5358e) + ")");
        } else {
            r rVar = this.f5354a;
            g5.j jVar = rVar.f5371b.f4279m;
            int i3 = 4;
            int i10 = this.f5356c;
            if (i10 == 1) {
                str = "REPLACE";
            } else if (i10 == 2) {
                str = "KEEP";
            } else if (i10 == 3) {
                str = "APPEND";
            } else {
                if (i10 != 4) {
                    throw null;
                }
                str = "APPEND_OR_REPLACE";
            }
            String strConcat = "EnqueueRunnable_".concat(str);
            androidx.room.b0 b0Var = (androidx.room.b0) rVar.f5373d.f9730c;
            ab.e eVar = new ab.e(i3);
            eVar.f393f = this;
            VarHandle.storeStoreFence();
            this.f5361h = id.c.x(jVar, strConcat, b0Var, eVar);
        }
        return this.f5361h;
    }
}
