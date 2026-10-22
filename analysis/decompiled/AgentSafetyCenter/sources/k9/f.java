package k9;

import android.content.Context;
import java.time.LocalDate;
import jb.i;
import xb.l;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public final class f extends pb.c {

    /* renamed from: c, reason: collision with root package name */
    public LocalDate f7369c;

    /* renamed from: f, reason: collision with root package name */
    public l f7370f;

    /* renamed from: g, reason: collision with root package name */
    public Context f7371g;

    /* renamed from: h, reason: collision with root package name */
    public /* synthetic */ Object f7372h;
    public final /* synthetic */ h i;

    /* renamed from: j, reason: collision with root package name */
    public int f7373j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(h hVar, pb.c cVar) {
        super(cVar);
        this.i = hVar;
    }

    @Override // pb.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        this.f7372h = obj;
        this.f7373j |= Integer.MIN_VALUE;
        Object objA = this.i.a(null, null, null, this);
        return objA == ob.a.f9351c ? objA : i.a(objA);
    }
}
