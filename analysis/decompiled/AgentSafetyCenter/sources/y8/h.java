package y8;

import android.content.Context;
import t.i1;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public abstract class h {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ fc.c[] f15969a;

    /* renamed from: b, reason: collision with root package name */
    public static final x3.b f15970b;

    static {
        yb.o oVar = new yb.o(h.class, "ledgerCacheStore", "getLedgerCacheStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 1);
        yb.v.f16099a.getClass();
        f15969a = new fc.c[]{oVar};
        f15970b = i1.q("agent_ledger_cache");
    }

    public static final v3.f a(Context context) {
        return f15970b.a(context, f15969a[0]);
    }
}
