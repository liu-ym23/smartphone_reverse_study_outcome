package retrofit2;

import Ua.InterfaceC1066l;
import Y8.t;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import f9.C4063a;
import kotlin.C4849c;
import kotlin.KotlinNullPointerException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import yc.n;
import yc.v;

@Metadata(d1 = {"\u0000&\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0010\u0001\n\u0002\b\u0003\u001a$\u0010\u0003\u001a\u00028\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\u0003\u0010\u0004\u001a(\u0010\u0005\u001a\u0004\u0018\u00018\u0000\"\b\b\u0000\u0010\u0001*\u00020\u0000*\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0002H\u0087@¢\u0006\u0004\b\u0005\u0010\u0004\u001a\u001a\u0010\u0007\u001a\u00020\u0006*\b\u0012\u0004\u0012\u00020\u00060\u0002H\u0087@¢\u0006\u0004\b\u0007\u0010\u0004\u001a&\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@¢\u0006\u0004\b\t\u0010\u0004\u001a\u0014\u0010\f\u001a\u00020\u000b*\u00020\nH\u0080@¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"", ExifInterface.GPS_DIRECTION_TRUE, "Lyc/d;", Const.INTENT_KEY_APIKEY, "(Lyc/d;Le9/c;)Ljava/lang/Object;", Const.INTENT_KEY_PKGNAME, "LY8/t;", Const.INTENT_KEY_UMID, "Lyc/v;", "c", "", "", "e", "(Ljava/lang/Throwable;Le9/c;)Ljava/lang/Object;", "retrofit"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class KotlinExtensions {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class a implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yc.d<T> f39889a;

        public a(yc.d<T> dVar) {
            this.f39889a = dVar;
        }

        public final void a(Throwable th) {
            this.f39889a.cancel();
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/KotlinExtensions$b", "Lyc/f;", "Lyc/d;", "call", "Lyc/v;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lyc/d;Lyc/v;)V", "", "t", Const.INTENT_KEY_PKGNAME, "(Lyc/d;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class b<T> implements yc.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1066l<T> f39890a;

        /* JADX WARN: Multi-variable type inference failed */
        public b(InterfaceC1066l<? super T> interfaceC1066l) {
            this.f39890a = interfaceC1066l;
        }

        @Override // yc.f
        public void a(yc.d<T> call, v<T> response) {
            p.i(call, "call");
            p.i(response, "response");
            if (!response.f()) {
                InterfaceC1066l<T> interfaceC1066l = this.f39890a;
                Result.Companion companion = Result.INSTANCE;
                interfaceC1066l.resumeWith(Result.b(C4849c.a(new HttpException(response))));
                return;
            }
            T tA = response.a();
            if (tA != null) {
                this.f39890a.resumeWith(Result.b(tA));
                return;
            }
            Object objJ = call.b().j(n.class);
            p.f(objJ);
            n nVar = (n) objJ;
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException("Response from " + nVar.b().getName() + '.' + nVar.a().getName() + " was null but response body type was declared as non-null");
            InterfaceC1066l<T> interfaceC1066l2 = this.f39890a;
            Result.Companion companion2 = Result.INSTANCE;
            interfaceC1066l2.resumeWith(Result.b(C4849c.a(kotlinNullPointerException)));
        }

        @Override // yc.f
        public void b(yc.d<T> call, Throwable t10) {
            p.i(call, "call");
            p.i(t10, "t");
            InterfaceC1066l<T> interfaceC1066l = this.f39890a;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(C4849c.a(t10)));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class c implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yc.d<T> f39891a;

        public c(yc.d<T> dVar) {
            this.f39891a = dVar;
        }

        public final void a(Throwable th) {
            this.f39891a.cancel();
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0001J/\u0010\u0007\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u000e\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000b\u001a\u00020\u00062\u000e\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/KotlinExtensions$d", "Lyc/f;", "Lyc/d;", "call", "Lyc/v;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lyc/d;Lyc/v;)V", "", "t", Const.INTENT_KEY_PKGNAME, "(Lyc/d;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d<T> implements yc.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1066l<T> f39892a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(InterfaceC1066l<? super T> interfaceC1066l) {
            this.f39892a = interfaceC1066l;
        }

        @Override // yc.f
        public void a(yc.d<T> call, v<T> response) {
            p.i(call, "call");
            p.i(response, "response");
            if (response.f()) {
                InterfaceC1066l<T> interfaceC1066l = this.f39892a;
                Result.Companion companion = Result.INSTANCE;
                interfaceC1066l.resumeWith(Result.b(response.a()));
            } else {
                InterfaceC1066l<T> interfaceC1066l2 = this.f39892a;
                Result.Companion companion2 = Result.INSTANCE;
                interfaceC1066l2.resumeWith(Result.b(C4849c.a(new HttpException(response))));
            }
        }

        @Override // yc.f
        public void b(yc.d<T> call, Throwable t10) {
            p.i(call, "call");
            p.i(t10, "t");
            InterfaceC1066l<T> interfaceC1066l = this.f39892a;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(C4849c.a(t10)));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class e implements InterfaceC5074l<Throwable, t> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ yc.d<T> f39893a;

        public e(yc.d<T> dVar) {
            this.f39893a = dVar;
        }

        public final void a(Throwable th) {
            this.f39893a.cancel();
        }

        @Override // p9.InterfaceC5074l
        public /* bridge */ /* synthetic */ t invoke(Throwable th) {
            a(th);
            return t.f7040a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J+\u0010\u0007\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ%\u0010\u000b\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"retrofit2/KotlinExtensions$f", "Lyc/f;", "Lyc/d;", "call", "Lyc/v;", UxipConstants.f30685x, "LY8/t;", Const.INTENT_KEY_APIKEY, "(Lyc/d;Lyc/v;)V", "", "t", Const.INTENT_KEY_PKGNAME, "(Lyc/d;Ljava/lang/Throwable;)V", "retrofit"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f<T> implements yc.f<T> {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC1066l<v<T>> f39894a;

        /* JADX WARN: Multi-variable type inference failed */
        public f(InterfaceC1066l<? super v<T>> interfaceC1066l) {
            this.f39894a = interfaceC1066l;
        }

        @Override // yc.f
        public void a(yc.d<T> call, v<T> response) {
            p.i(call, "call");
            p.i(response, "response");
            this.f39894a.resumeWith(Result.b(response));
        }

        @Override // yc.f
        public void b(yc.d<T> call, Throwable t10) {
            p.i(call, "call");
            p.i(t10, "t");
            InterfaceC1066l<v<T>> interfaceC1066l = this.f39894a;
            Result.Companion companion = Result.INSTANCE;
            interfaceC1066l.resumeWith(Result.b(C4849c.a(t10)));
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class g implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        public final /* synthetic */ InterfaceC4014c<?> f39895a;

        /* renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Throwable f39896b;

        public g(InterfaceC4014c<?> interfaceC4014c, Throwable th) {
            this.f39895a = interfaceC4014c;
            this.f39896b = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            InterfaceC4014c interfaceC4014cD = IntrinsicsKt__IntrinsicsJvmKt.d(this.f39895a);
            Result.Companion companion = Result.INSTANCE;
            interfaceC4014cD.resumeWith(Result.b(C4849c.a(this.f39896b)));
        }
    }

    public static final <T> Object a(yc.d<T> dVar, InterfaceC4014c<? super T> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        cVar.q(new a(dVar));
        dVar.A(new b(cVar));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    public static final <T> Object b(yc.d<T> dVar, InterfaceC4014c<? super T> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        cVar.q(new c(dVar));
        dVar.A(new d(cVar));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    public static final <T> Object c(yc.d<T> dVar, InterfaceC4014c<? super v<T>> interfaceC4014c) {
        kotlinx.coroutines.c cVar = new kotlinx.coroutines.c(IntrinsicsKt__IntrinsicsJvmKt.d(interfaceC4014c), 1);
        cVar.I();
        cVar.q(new e(dVar));
        dVar.A(new f(cVar));
        Object objC = cVar.C();
        if (objC == C4063a.g()) {
            g9.f.c(interfaceC4014c);
        }
        return objC;
    }

    public static final Object d(yc.d<t> dVar, InterfaceC4014c<? super t> interfaceC4014c) {
        p.g(dVar, "null cannot be cast to non-null type retrofit2.Call<kotlin.Unit?>");
        return b(dVar, interfaceC4014c);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object e(java.lang.Throwable r4, e9.InterfaceC4014c<?> r5) throws java.lang.Throwable {
        /*
            boolean r0 = r5 instanceof retrofit2.KotlinExtensions$suspendAndThrow$1
            if (r0 == 0) goto L13
            r0 = r5
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = (retrofit2.KotlinExtensions$suspendAndThrow$1) r0
            int r1 = r0.f39899c
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f39899c = r1
            goto L18
        L13:
            retrofit2.KotlinExtensions$suspendAndThrow$1 r0 = new retrofit2.KotlinExtensions$suspendAndThrow$1
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.f39898b
            java.lang.Object r1 = f9.C4063a.g()
            int r2 = r0.f39899c
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 == r3) goto L2d
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2d:
            java.lang.Object r4 = r0.f39897a
            java.lang.Throwable r4 = (java.lang.Throwable) r4
            kotlin.C4849c.b(r5)
            goto L5c
        L35:
            kotlin.C4849c.b(r5)
            r0.f39897a = r4
            r0.f39899c = r3
            Ua.I r5 = Ua.Y.a()
            kotlin.coroutines.d r2 = r0.getContext()
            retrofit2.KotlinExtensions$g r3 = new retrofit2.KotlinExtensions$g
            r3.<init>(r0, r4)
            r5.h1(r2, r3)
            java.lang.Object r4 = f9.C4063a.g()
            java.lang.Object r5 = f9.C4063a.g()
            if (r4 != r5) goto L59
            g9.f.c(r0)
        L59:
            if (r4 != r1) goto L5c
            return r1
        L5c:
            kotlin.KotlinNothingValueException r4 = new kotlin.KotlinNothingValueException
            r4.<init>()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: retrofit2.KotlinExtensions.e(java.lang.Throwable, e9.c):java.lang.Object");
    }
}
