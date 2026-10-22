package z4;

import a6.f0;
import b5.a0;
import h5.i;
import io.ktor.utils.io.j0;
import java.io.EOFException;
import java.io.IOException;
import org.tukaani.xz.common.Util;
import p5.p;
import x.f;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class a extends i implements p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f6528a = 0;

    /* renamed from: b, reason: collision with root package name */
    public int f6529b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ io.ktor.utils.io.p f6530c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(io.ktor.utils.io.p pVar, f5.c cVar) {
        super(2, cVar);
        this.f6530c = pVar;
    }

    @Override // h5.a
    public final f5.c create(Object obj, f5.c cVar) {
        switch (this.f6528a) {
            case 0:
                return new a(this.f6530c, cVar);
            default:
                return new a((c) this.f6530c, this.f6529b, cVar);
        }
    }

    @Override // p5.p
    public final Object invoke(Object obj, Object obj2) throws IOException {
        f0 f0Var = (f0) obj;
        f5.c cVar = (f5.c) obj2;
        switch (this.f6528a) {
            case 0:
                return ((a) create(f0Var, cVar)).invokeSuspend(a0.f883a);
            default:
                a aVar = (a) create(f0Var, cVar);
                a0 a0Var = a0.f883a;
                aVar.invokeSuspend(a0Var);
                return a0Var;
        }
    }

    @Override // h5.a
    public final Object invokeSuspend(Object obj) throws IOException {
        int i8 = this.f6528a;
        io.ktor.utils.io.p pVar = this.f6530c;
        switch (i8) {
            case 0:
                g5.a aVar = g5.a.f2984a;
                int i9 = this.f6529b;
                if (i9 != 0) {
                    if (i9 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    a.a.c0(obj);
                    return obj;
                }
                a.a.c0(obj);
                this.f6529b = 1;
                Object objD = pVar.d(1, this);
                return objD == aVar ? aVar : objD;
            default:
                c cVar = (c) pVar;
                j6.b bVar = cVar.f6534b;
                j6.a aVar2 = cVar.d;
                g5.a aVar3 = g5.a.f2984a;
                a.a.c0(obj);
                long jM = 0;
                while (f.W(aVar2) < this.f6529b && jM >= 0) {
                    try {
                        jM = bVar.m(aVar2, Util.VLI_MAX);
                    } catch (EOFException unused) {
                        jM = -1;
                    }
                }
                if (jM == -1) {
                    bVar.close();
                    cVar.f6536e.f0();
                    cVar.f6535c = new j0(null);
                }
                return a0.f883a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(c cVar, int i8, f5.c cVar2) {
        super(2, cVar2);
        this.f6530c = cVar;
        this.f6529b = i8;
    }
}
