package s1;

import androidx.lifecycle.q;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s0;
import androidx.lifecycle.x;
import com.stepos.core.common.util.TraceIdKeys;
import java.io.PrintWriter;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.g;
import kotlin.jvm.internal.i;
import p.p;
import q1.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends s1.a {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11874a;

    /* renamed from: b, reason: collision with root package name */
    public final C0139b f11875b;

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    public static class a<D> extends x<D> {
        @Override // androidx.lifecycle.w
        public final void d() {
            throw null;
        }

        @Override // androidx.lifecycle.w
        public final void e() {
            throw null;
        }

        public final String toString() {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("LoaderInfo{");
            sb2.append(Integer.toHexString(System.identityHashCode(this)));
            sb2.append(" #0 : ");
            sb2.append("null");
            sb2.append("}}");
            return sb2.toString();
        }
    }

    /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
    /* renamed from: s1.b$b, reason: collision with other inner class name */
    public static class C0139b extends q0 {

        /* renamed from: c, reason: collision with root package name */
        public static final a f11876c = new a();

        /* renamed from: b, reason: collision with root package name */
        public final p<a> f11877b = new p<>();

        /* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
        /* renamed from: s1.b$b$a */
        public static class a implements r0.b {
            @Override // androidx.lifecycle.r0.b
            public final <T extends q0> T a(Class<T> cls) {
                return new C0139b();
            }
        }

        @Override // androidx.lifecycle.q0
        public final void b() {
            p<a> pVar = this.f11877b;
            int i10 = pVar.f11388c;
            if (i10 > 0) {
                pVar.e(0).getClass();
                throw null;
            }
            Object[] objArr = pVar.f11387b;
            for (int i11 = 0; i11 < i10; i11++) {
                objArr[i11] = null;
            }
            pVar.f11388c = 0;
        }
    }

    public b(q qVar, s0 store) {
        this.f11874a = qVar;
        g.f(store, "store");
        a.C0127a defaultCreationExtras = a.C0127a.f11487b;
        g.f(defaultCreationExtras, "defaultCreationExtras");
        r1.b bVar = new r1.b(store, C0139b.f11876c, defaultCreationExtras);
        c cVarA = i.a(C0139b.class);
        String strD = cVarA.d();
        if (strD == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        this.f11875b = (C0139b) bVar.a(cVarA, "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(strD));
    }

    @Deprecated
    public final void b(PrintWriter printWriter, String str) {
        p<a> pVar = this.f11875b.f11877b;
        if (pVar.f11388c > 0) {
            printWriter.print(str);
            printWriter.println("Loaders:");
            String str2 = str + "    ";
            if (pVar.f11388c <= 0) {
                return;
            }
            a aVarE = pVar.e(0);
            printWriter.print(str);
            printWriter.print("  #");
            printWriter.print(pVar.f11386a[0]);
            printWriter.print(": ");
            printWriter.println(aVarE.toString());
            printWriter.print(str2);
            printWriter.print("mId=");
            printWriter.print(0);
            printWriter.print(" mArgs=");
            printWriter.println((Object) null);
            printWriter.print(str2);
            printWriter.print("mLoader=");
            printWriter.println((Object) null);
            throw null;
        }
    }

    public final String toString() {
        int iLastIndexOf;
        StringBuilder sb2 = new StringBuilder(TraceIdKeys.MAX_LENGTH);
        sb2.append("LoaderManager{");
        sb2.append(Integer.toHexString(System.identityHashCode(this)));
        sb2.append(" in ");
        Object obj = this.f11874a;
        String simpleName = obj.getClass().getSimpleName();
        if (simpleName.length() <= 0 && (iLastIndexOf = (simpleName = obj.getClass().getName()).lastIndexOf(46)) > 0) {
            simpleName = simpleName.substring(iLastIndexOf + 1);
        }
        sb2.append(simpleName);
        sb2.append('{');
        sb2.append(Integer.toHexString(System.identityHashCode(obj)));
        sb2.append("}}");
        return sb2.toString();
    }
}
