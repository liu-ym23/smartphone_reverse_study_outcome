package t0;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* loaded from: classes.dex */
public final class y extends B0.f {

    /* renamed from: j, reason: collision with root package name */
    public static final String f15426j = s0.t.f("WorkContinuationImpl");

    /* renamed from: b, reason: collision with root package name */
    public final C0913H f15427b;

    /* renamed from: c, reason: collision with root package name */
    public final String f15428c;

    /* renamed from: d, reason: collision with root package name */
    public final int f15429d;

    /* renamed from: e, reason: collision with root package name */
    public final List f15430e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f15431f;

    /* renamed from: g, reason: collision with root package name */
    public final ArrayList f15432g = new ArrayList();

    /* renamed from: h, reason: collision with root package name */
    public boolean f15433h;

    /* renamed from: i, reason: collision with root package name */
    public C0929o f15434i;

    public y(C0913H c0913h, String str, int i4, List list) {
        this.f15427b = c0913h;
        this.f15428c = str;
        this.f15429d = i4;
        this.f15430e = list;
        this.f15431f = new ArrayList(list.size());
        for (int i5 = 0; i5 < list.size(); i5++) {
            if (i4 == 1 && ((s0.I) list.get(i5)).f14164b.f187u != LongCompanionObject.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String string = ((s0.I) list.get(i5)).f14163a.toString();
            Intrinsics.checkNotNullExpressionValue(string, "id.toString()");
            this.f15431f.add(string);
            this.f15432g.add(string);
        }
    }

    public static boolean J0(y yVar, HashSet hashSet) {
        hashSet.addAll(yVar.f15431f);
        HashSet hashSetK0 = K0(yVar);
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (hashSetK0.contains((String) it.next())) {
                return true;
            }
        }
        hashSet.removeAll(yVar.f15431f);
        return false;
    }

    public static HashSet K0(y yVar) {
        HashSet hashSet = new HashSet();
        yVar.getClass();
        return hashSet;
    }

    public final s0.B I0() {
        if (this.f15433h) {
            s0.t.d().g(f15426j, "Already enqueued work ids (" + TextUtils.join(", ", this.f15431f) + ")");
        } else {
            C0929o c0929o = new C0929o();
            this.f15427b.f15328e.a(new C0.e(this, c0929o));
            this.f15434i = c0929o;
        }
        return this.f15434i;
    }
}
