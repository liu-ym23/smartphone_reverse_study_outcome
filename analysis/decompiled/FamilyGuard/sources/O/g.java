package O;

import V3.o;
import V3.v;
import a4.C0428b;
import i4.p;
import kotlin.coroutines.jvm.internal.l;

/* loaded from: classes.dex */
public final class g {

    @kotlin.coroutines.jvm.internal.f(c = "androidx.datastore.preferences.core.PreferencesKt$edit$2", f = "Preferences.kt", l = {329}, m = "invokeSuspend")
    static final class a extends l implements p<d, Z3.e<? super d>, Object> {

        /* renamed from: a, reason: collision with root package name */
        int f4288a;

        /* renamed from: b, reason: collision with root package name */
        /* synthetic */ Object f4289b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ p<O.a, Z3.e<? super v>, Object> f4290c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        a(p<? super O.a, ? super Z3.e<? super v>, ? extends Object> pVar, Z3.e<? super a> eVar) {
            super(2, eVar);
            this.f4290c = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<v> create(Object obj, Z3.e<?> eVar) {
            a aVar = new a(this.f4290c, eVar);
            aVar.f4289b = obj;
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
            int i5 = this.f4288a;
            if (i5 != 0) {
                if (i5 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                O.a aVar = (O.a) this.f4289b;
                o.b(obj);
                return aVar;
            }
            o.b(obj);
            O.a aVarC = ((d) this.f4289b).c();
            p<O.a, Z3.e<? super v>, Object> pVar = this.f4290c;
            this.f4289b = aVarC;
            this.f4288a = 1;
            return pVar.invoke(aVarC, this) == objE ? objE : aVarC;
        }
    }

    public static final Object a(L.f<d> fVar, p<? super O.a, ? super Z3.e<? super v>, ? extends Object> pVar, Z3.e<? super d> eVar) {
        return fVar.b(new a(pVar, null), eVar);
    }
}
