package g4;

import java.util.Iterator;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class e extends h5.c {

    /* renamed from: a, reason: collision with root package name */
    public Object f2970a;

    /* renamed from: b, reason: collision with root package name */
    public Iterator f2971b;

    /* renamed from: c, reason: collision with root package name */
    public Object f2972c;
    public /* synthetic */ Object d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ f f2973e;

    /* renamed from: f, reason: collision with root package name */
    public int f2974f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(f fVar, h5.c cVar) {
        super(cVar);
        this.f2973e = fVar;
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f2974f |= Integer.MIN_VALUE;
        return this.f2973e.d(null, this);
    }
}
