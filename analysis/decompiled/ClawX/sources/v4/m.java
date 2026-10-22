package v4;

import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.p;
import p5.q;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m extends f {

    /* renamed from: b, reason: collision with root package name */
    public final List f5980b;

    /* renamed from: c, reason: collision with root package name */
    public final l f5981c;
    public Object d;

    /* renamed from: e, reason: collision with root package name */
    public final f5.c[] f5982e;

    /* renamed from: f, reason: collision with root package name */
    public int f5983f;

    /* renamed from: g, reason: collision with root package name */
    public int f5984g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(Object initial, Object context, List blocks) {
        super(context);
        p.e(initial, "initial");
        p.e(context, "context");
        p.e(blocks, "blocks");
        this.f5980b = blocks;
        this.f5981c = new l(this);
        this.d = initial;
        this.f5982e = new f5.c[blocks.size()];
        this.f5983f = -1;
    }

    @Override // v4.f
    public final Object a(Object obj, h5.c cVar) {
        this.f5984g = 0;
        if (this.f5980b.size() == 0) {
            return obj;
        }
        p.e(obj, "<set-?>");
        this.d = obj;
        if (this.f5983f < 0) {
            return d(cVar);
        }
        throw new IllegalStateException("Already started");
    }

    @Override // a6.f0
    public final f5.h b() {
        return this.f5981c.getContext();
    }

    @Override // v4.f
    public final Object c() {
        return this.d;
    }

    @Override // v4.f
    public final Object d(f5.c frame) {
        Object obj;
        if (this.f5984g == this.f5980b.size()) {
            obj = this.d;
        } else {
            f5.c cVarU = b8.h.u(frame);
            int i8 = this.f5983f + 1;
            this.f5983f = i8;
            f5.c[] cVarArr = this.f5982e;
            cVarArr[i8] = cVarU;
            if (f(true)) {
                int i9 = this.f5983f;
                if (i9 < 0) {
                    throw new IllegalStateException("No more continuations to resume");
                }
                this.f5983f = i9 - 1;
                cVarArr[i9] = null;
                obj = this.d;
            } else {
                obj = g5.a.f2984a;
            }
        }
        if (obj == g5.a.f2984a) {
            p.e(frame, "frame");
        }
        return obj;
    }

    @Override // v4.f
    public final Object e(f5.c cVar, Object obj) {
        p.e(obj, "<set-?>");
        this.d = obj;
        return d(cVar);
    }

    public final boolean f(boolean z) {
        q interceptor;
        Object subject;
        l continuation;
        do {
            int i8 = this.f5984g;
            List list = this.f5980b;
            if (i8 == list.size()) {
                if (z) {
                    return true;
                }
                g(this.d);
                return false;
            }
            this.f5984g = i8 + 1;
            interceptor = (q) list.get(i8);
            try {
                subject = this.d;
                continuation = this.f5981c;
                p.e(interceptor, "interceptor");
                p.e(subject, "subject");
                p.e(continuation, "continuation");
                d0.a(3, interceptor);
            } catch (Throwable th) {
                g(a.a.o(th));
                return false;
            }
        } while (interceptor.invoke(this, subject, continuation) != g5.a.f2984a);
        return false;
    }

    public final void g(Object obj) {
        int i8 = this.f5983f;
        if (i8 < 0) {
            throw new IllegalStateException("No more continuations to resume");
        }
        f5.c[] cVarArr = this.f5982e;
        f5.c cVar = cVarArr[i8];
        p.b(cVar);
        int i9 = this.f5983f;
        this.f5983f = i9 - 1;
        cVarArr[i9] = null;
        if (!(obj instanceof b5.h)) {
            cVar.resumeWith(obj);
            return;
        }
        Throwable thA = b5.i.a(obj);
        p.b(thA);
        try {
            thA.getCause();
        } catch (Throwable unused) {
        }
        cVar.resumeWith(a.a.o(thA));
    }
}
