package m8;

import android.content.res.Resources;
import java.time.LocalDate;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class b0 extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public boolean f8304c;

    /* renamed from: f, reason: collision with root package name */
    public sc.a f8305f;

    /* renamed from: g, reason: collision with root package name */
    public Resources f8306g;

    /* renamed from: h, reason: collision with root package name */
    public LocalDate f8307h;
    public f i;

    /* renamed from: j, reason: collision with root package name */
    public String f8308j;

    /* renamed from: k, reason: collision with root package name */
    public int f8309k;

    /* renamed from: l, reason: collision with root package name */
    public int f8310l;

    /* renamed from: m, reason: collision with root package name */
    public long f8311m;

    /* renamed from: n, reason: collision with root package name */
    public long f8312n;

    /* renamed from: o, reason: collision with root package name */
    public long f8313o;

    /* renamed from: p, reason: collision with root package name */
    public /* synthetic */ Object f8314p;

    /* renamed from: q, reason: collision with root package name */
    public final /* synthetic */ k0 f8315q;

    /* renamed from: r, reason: collision with root package name */
    public int f8316r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(k0 k0Var, pb.c cVar) {
        super(cVar);
        this.f8315q = k0Var;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) {
        this.f8314p = obj;
        this.f8316r |= Integer.MIN_VALUE;
        return this.f8315q.J(false, this);
    }
}
