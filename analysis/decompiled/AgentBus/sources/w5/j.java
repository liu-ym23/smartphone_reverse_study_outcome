package w5;

import java.util.List;

/* loaded from: classes.dex */
public final class j extends i7.c {

    /* renamed from: f, reason: collision with root package name */
    public m f10719f;

    /* renamed from: g, reason: collision with root package name */
    public Object f10720g;

    /* renamed from: h, reason: collision with root package name */
    public Object f10721h;

    /* renamed from: i, reason: collision with root package name */
    public List f10722i;

    /* renamed from: j, reason: collision with root package name */
    public /* synthetic */ Object f10723j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ m f10724k;

    /* renamed from: l, reason: collision with root package name */
    public int f10725l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(m mVar, i7.c cVar) {
        super(cVar);
        this.f10724k = mVar;
    }

    @Override // i7.a
    public final Object invokeSuspend(Object obj) {
        this.f10723j = obj;
        this.f10725l |= Integer.MIN_VALUE;
        return this.f10724k.k(null, null, this);
    }
}
