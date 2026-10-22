package b6;

import i5.f;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class b extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public f f1532f;

    /* renamed from: g, reason: collision with root package name */
    public String f1533g;

    /* renamed from: h, reason: collision with root package name */
    public c5.b f1534h;

    /* renamed from: i, reason: collision with root package name */
    public Iterator f1535i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f1536j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ f f1537k;

    /* renamed from: l, reason: collision with root package name */
    public int f1538l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(f fVar, i7.c cVar) {
        super(cVar);
        this.f1537k = fVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f1536j = obj;
        this.f1538l |= Integer.MIN_VALUE;
        return this.f1537k.K(null, this);
    }
}
