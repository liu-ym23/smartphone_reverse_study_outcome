package androidx.room;

import android.content.Context;
import h0.AbstractC0587a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class w {

    /* renamed from: a, reason: collision with root package name */
    public final Context f4247a;

    /* renamed from: b, reason: collision with root package name */
    public final Class f4248b;

    /* renamed from: c, reason: collision with root package name */
    public final String f4249c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f4250d;

    /* renamed from: e, reason: collision with root package name */
    public final ArrayList f4251e;

    /* renamed from: f, reason: collision with root package name */
    public final ArrayList f4252f;

    /* renamed from: g, reason: collision with root package name */
    public Executor f4253g;

    /* renamed from: h, reason: collision with root package name */
    public Executor f4254h;

    /* renamed from: i, reason: collision with root package name */
    public k0.f f4255i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f4256j;

    /* renamed from: k, reason: collision with root package name */
    public final y f4257k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f4258l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f4259m;

    /* renamed from: n, reason: collision with root package name */
    public final long f4260n;

    /* renamed from: o, reason: collision with root package name */
    public final z f4261o;

    /* renamed from: p, reason: collision with root package name */
    public final LinkedHashSet f4262p;

    /* renamed from: q, reason: collision with root package name */
    public HashSet f4263q;

    public w(Context context, Class klass, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        this.f4247a = context;
        this.f4248b = klass;
        this.f4249c = str;
        this.f4250d = new ArrayList();
        this.f4251e = new ArrayList();
        this.f4252f = new ArrayList();
        this.f4257k = y.f4264a;
        this.f4258l = true;
        this.f4260n = -1L;
        this.f4261o = new z(0);
        this.f4262p = new LinkedHashSet();
    }

    public final void a(AbstractC0587a... migrations) {
        Intrinsics.checkNotNullParameter(migrations, "migrations");
        if (this.f4263q == null) {
            this.f4263q = new HashSet();
        }
        for (AbstractC0587a abstractC0587a : migrations) {
            HashSet hashSet = this.f4263q;
            Intrinsics.checkNotNull(hashSet);
            hashSet.add(Integer.valueOf(abstractC0587a.startVersion));
            HashSet hashSet2 = this.f4263q;
            Intrinsics.checkNotNull(hashSet2);
            hashSet2.add(Integer.valueOf(abstractC0587a.endVersion));
        }
        this.f4261o.a((AbstractC0587a[]) Arrays.copyOf(migrations, migrations.length));
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00be  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.room.A b() throws java.lang.ClassNotFoundException {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.w.b():androidx.room.A");
    }
}
