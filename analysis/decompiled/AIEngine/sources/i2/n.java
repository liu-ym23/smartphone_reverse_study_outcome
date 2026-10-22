package i2;

import android.text.TextUtils;
import androidx.lifecycle.j0;
import androidx.work.ExistingWorkPolicy;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class n extends h2.r {

    /* renamed from: i, reason: collision with root package name */
    public static final String f9475i = h2.j.f("WorkContinuationImpl");

    /* renamed from: a, reason: collision with root package name */
    public final androidx.work.impl.b f9476a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9477b;

    /* renamed from: c, reason: collision with root package name */
    public final ExistingWorkPolicy f9478c;

    /* renamed from: d, reason: collision with root package name */
    public final List<? extends h2.s> f9479d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f9480e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f9481f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f9482g;
    public h2.n h;

    public n() {
        throw null;
    }

    public n(androidx.work.impl.b bVar, String str, ExistingWorkPolicy existingWorkPolicy, List list) {
        this.f9476a = bVar;
        this.f9477b = str;
        this.f9478c = existingWorkPolicy;
        this.f9479d = list;
        this.f9480e = new ArrayList(list.size());
        this.f9481f = new ArrayList();
        for (int i10 = 0; i10 < list.size(); i10++) {
            if (existingWorkPolicy == ExistingWorkPolicy.f2774a && ((h2.s) list.get(i10)).f9284b.f11523u != Long.MAX_VALUE) {
                throw new IllegalArgumentException("Next Schedule Time Override must be used with ExistingPeriodicWorkPolicyUPDATE (preferably) or KEEP");
            }
            String string = ((h2.s) list.get(i10)).f9283a.toString();
            kotlin.jvm.internal.g.e(string, "id.toString()");
            this.f9480e.add(string);
            this.f9481f.add(string);
        }
    }

    public static HashSet b(n nVar) {
        HashSet hashSet = new HashSet();
        nVar.getClass();
        return hashSet;
    }

    public final h2.m a() {
        if (this.f9482g) {
            h2.j.d().g(f9475i, "Already enqueued work ids (" + TextUtils.join(", ", this.f9480e) + ")");
        } else {
            androidx.work.impl.b bVar = this.f9476a;
            this.h = h2.p.a(bVar.f2878b.f2825m, "EnqueueRunnable_" + this.f9478c.name(), bVar.f2880d.c(), new j0(this, 9));
        }
        return this.h;
    }
}
