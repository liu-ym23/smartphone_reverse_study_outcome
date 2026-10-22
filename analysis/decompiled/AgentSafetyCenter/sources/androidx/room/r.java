package androidx.room;

import android.content.Context;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class r {

    /* renamed from: a, reason: collision with root package name */
    public final yb.e f1605a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f1606b;

    /* renamed from: c, reason: collision with root package name */
    public final String f1607c;

    /* renamed from: f, reason: collision with root package name */
    public Executor f1610f;

    /* renamed from: g, reason: collision with root package name */
    public Executor f1611g;

    /* renamed from: h, reason: collision with root package name */
    public h5.o f1612h;
    public boolean i;

    /* renamed from: l, reason: collision with root package name */
    public final t f1615l;

    /* renamed from: m, reason: collision with root package name */
    public final LinkedHashSet f1616m;

    /* renamed from: n, reason: collision with root package name */
    public final LinkedHashSet f1617n;

    /* renamed from: o, reason: collision with root package name */
    public final ArrayList f1618o;

    /* renamed from: p, reason: collision with root package name */
    public boolean f1619p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f1620q;

    /* renamed from: r, reason: collision with root package name */
    public final boolean f1621r;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f1608d = new ArrayList();

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f1609e = new ArrayList();

    /* renamed from: j, reason: collision with root package name */
    public final s f1613j = s.f1622c;

    /* renamed from: k, reason: collision with root package name */
    public final long f1614k = -1;

    public r(Context context, Class cls, String str) {
        t tVar = new t(0);
        tVar.f1627b = new LinkedHashMap();
        VarHandle.storeStoreFence();
        this.f1615l = tVar;
        this.f1616m = new LinkedHashSet();
        this.f1617n = new LinkedHashSet();
        this.f1618o = new ArrayList();
        this.f1619p = true;
        this.f1621r = true;
        this.f1605a = yb.v.a(cls);
        this.f1606b = context;
        this.f1607c = str;
    }

    public final void a(q4.a... aVarArr) {
        for (q4.a aVar : aVarArr) {
            Integer numValueOf = Integer.valueOf(aVar.f10073a);
            LinkedHashSet linkedHashSet = this.f1617n;
            linkedHashSet.add(numValueOf);
            linkedHashSet.add(Integer.valueOf(aVar.f10074b));
        }
        q4.a[] aVarArr2 = (q4.a[]) Arrays.copyOf(aVarArr, aVarArr.length);
        t tVar = this.f1615l;
        tVar.getClass();
        for (q4.a aVar2 : aVarArr2) {
            tVar.a(aVar2);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:160:0x045c, code lost:
    
        g5.f.s("Unexpected auto migration specs found. Annotate AutoMigrationSpec implementation with @ProvidedAutoMigrationSpec annotation or remove this spec from the builder.");
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0463, code lost:
    
        return null;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.room.u b() throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 1641
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.r.b():androidx.room.u");
    }
}
