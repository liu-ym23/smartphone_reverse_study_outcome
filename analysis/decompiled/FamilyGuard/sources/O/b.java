package O;

import V3.o;
import V3.v;
import a4.C0428b;
import i4.p;
import j4.k;
import kotlin.coroutines.jvm.internal.l;
import v4.InterfaceC1193b;

/* loaded from: classes.dex */
public final class b implements L.f<d> {

    /* renamed from: a, reason: collision with root package name */
    private final L.f<d> f4279a;

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.preferences.core.PreferenceDataStore$updateData$2", f = "PreferenceDataStoreFactory.kt", l = {85}, m = "invokeSuspend")
    static final class a extends l implements p<d, Z3.e<? super d>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f4280a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f4281b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p<d, Z3.e<? super d>, Object> f4282c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(p<? super d, ? super Z3.e<? super d>, ? extends Object> pVar, Z3.e<? super a> eVar) {
            super(2, eVar);
            this.f4282c = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            a aVar = new a(this.f4282c, eVar);
            aVar.f4281b = obj;
            return aVar;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(d dVar, Z3.e<? super d> eVar) {
            return ((a) create(dVar, eVar)).invokeSuspend(v.f5542a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Object invokeSuspend(Object obj) {
            Object objE = C0428b.e();
            int i5 = this.f4280a;
            if (i5 == 0) {
                o.b(obj);
                d dVar = (d) this.f4281b;
                p<d, Z3.e<? super d>, Object> pVar = this.f4282c;
                this.f4280a = 1;
                obj = pVar.invoke(dVar, this);
                if (obj == objE) {
                    return objE;
                }
            } else {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                o.b(obj);
            }
            d dVar2 = (d) obj;
            ((O.a) dVar2).f();
            return dVar2;
        }
    }

    public b(L.f<d> fVar) {
        k.g(fVar, "delegate");
        this.f4279a = fVar;
    }

    @Override // L.f
    public InterfaceC1193b<d> a() {
        return this.f4279a.a();
    }

    @Override // L.f
    public Object b(p<? super d, ? super Z3.e<? super d>, ? extends Object> pVar, Z3.e<? super d> eVar) {
        return this.f4279a.b(new a(pVar, null), eVar);
    }
}
