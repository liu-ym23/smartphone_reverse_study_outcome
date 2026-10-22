package androidx.core.view;

import android.view.View;
import q4.InterfaceC0988b;

/* loaded from: classes.dex */
public final class O {

    @kotlin.coroutines.jvm.internal.f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {409, 411}, m = "invokeSuspend")
    static final class a extends kotlin.coroutines.jvm.internal.k implements i4.p<q4.d<? super View>, Z3.e<? super V3.v>, Object> {

        /* renamed from: b, reason: collision with root package name */
        int f9750b;

        /* renamed from: c, reason: collision with root package name */
        private /* synthetic */ Object f9751c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f9752d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(View view, Z3.e<? super a> eVar) {
            super(2, eVar);
            this.f9752d = view;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        public final Z3.e<V3.v> create(Object obj, Z3.e<?> eVar) {
            a aVar = new a(this.f9752d, eVar);
            aVar.f9751c = obj;
            return aVar;
        }

        @Override // i4.p
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public final Object invoke(q4.d<? super View> dVar, Z3.e<? super V3.v> eVar) {
            return ((a) create(dVar, eVar)).invokeSuspend(V3.v.f5542a);
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x004c, code lost:
        
            if (r1.i(r5, r4) == r0) goto L17;
         */
        @Override // kotlin.coroutines.jvm.internal.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                java.lang.Object r0 = a4.C0428b.e()
                int r1 = r4.f9750b
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L22
                if (r1 == r3) goto L1a
                if (r1 != r2) goto L12
                V3.o.b(r5)
                goto L4f
            L12:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L1a:
                java.lang.Object r1 = r4.f9751c
                q4.d r1 = (q4.d) r1
                V3.o.b(r5)
                goto L37
            L22:
                V3.o.b(r5)
                java.lang.Object r5 = r4.f9751c
                r1 = r5
                q4.d r1 = (q4.d) r1
                android.view.View r5 = r4.f9752d
                r4.f9751c = r1
                r4.f9750b = r3
                java.lang.Object r5 = r1.c(r5, r4)
                if (r5 != r0) goto L37
                goto L4e
            L37:
                android.view.View r5 = r4.f9752d
                boolean r3 = r5 instanceof android.view.ViewGroup
                if (r3 == 0) goto L4f
                android.view.ViewGroup r5 = (android.view.ViewGroup) r5
                q4.b r5 = androidx.core.view.N.b(r5)
                r3 = 0
                r4.f9751c = r3
                r4.f9750b = r2
                java.lang.Object r4 = r1.i(r5, r4)
                if (r4 != r0) goto L4f
            L4e:
                return r0
            L4f:
                V3.v r4 = V3.v.f5542a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.O.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public static final InterfaceC0988b<View> a(View view) {
        return q4.e.b(new a(view, null));
    }
}
