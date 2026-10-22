package p5;

import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public final class a extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public c f8406f;

    /* renamed from: g, reason: collision with root package name */
    public String f8407g;

    /* renamed from: h, reason: collision with root package name */
    public m f8408h;

    /* renamed from: i, reason: collision with root package name */
    public Set f8409i;

    /* renamed from: j, reason: collision with root package name */
    public Iterator f8410j;

    /* renamed from: k, reason: collision with root package name */
    public int f8411k;

    /* renamed from: l, reason: collision with root package name */
    public /* synthetic */ Object f8412l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ c f8413m;

    /* renamed from: n, reason: collision with root package name */
    public int f8414n;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, i7.c cVar2) {
        super(cVar2);
        this.f8413m = cVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f8412l = obj;
        this.f8414n |= Integer.MIN_VALUE;
        return this.f8413m.a(null, null, this);
    }
}
