package n8;

import java.io.IOException;
import java.lang.reflect.Method;
import kotlin.KotlinNullPointerException;
import kotlin.jvm.internal.i;
import kotlinx.coroutines.CancellableContinuationImpl;
import okhttp3.Response;
import okhttp3.h;
import retrofit2.HttpException;
import xd.r;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class c implements ad.c, xd.d {

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ int f10652g;
    public final /* synthetic */ CancellableContinuationImpl h;

    public /* synthetic */ c(CancellableContinuationImpl cancellableContinuationImpl, int i10) {
        this.f10652g = i10;
        this.h = cancellableContinuationImpl;
    }

    @Override // xd.d
    public void a(xd.b bVar, Throwable th) {
        this.h.resumeWith(kotlin.c.a(th));
    }

    @Override // xd.d
    public void b(xd.b bVar, r rVar) {
        boolean z = rVar.f13907a.r;
        CancellableContinuationImpl cancellableContinuationImpl = this.h;
        if (!z) {
            cancellableContinuationImpl.resumeWith(kotlin.c.a(new HttpException(rVar)));
            return;
        }
        Object obj = rVar.f13908b;
        if (obj != null) {
            cancellableContinuationImpl.resumeWith(obj);
            return;
        }
        h hVarA = bVar.a();
        hVarA.getClass();
        kotlin.jvm.internal.c cVarA = i.a(xd.i.class);
        Object objCast = xb.a.e(cVarA).cast(hVarA.f10996e.get(cVarA));
        if (objCast == null) {
            KotlinNullPointerException kotlinNullPointerException = new KotlinNullPointerException();
            kotlin.jvm.internal.g.j(kotlinNullPointerException, kotlin.jvm.internal.g.class.getName());
            throw kotlinNullPointerException;
        }
        Method method = ((xd.i) objCast).f13798a;
        StringBuilder sb2 = new StringBuilder("Response from ");
        Class<?> declaringClass = method.getDeclaringClass();
        if (declaringClass == null) {
            IllegalStateException illegalStateException = new IllegalStateException("method.declaringClass".concat(" must not be null"));
            kotlin.jvm.internal.g.j(illegalStateException, kotlin.jvm.internal.g.class.getName());
            throw illegalStateException;
        }
        sb2.append(declaringClass.getName());
        sb2.append('.');
        sb2.append(method.getName());
        sb2.append(" was null but response body type was declared as non-null");
        cancellableContinuationImpl.resumeWith(kotlin.c.a(new KotlinNullPointerException(sb2.toString())));
    }

    @Override // ad.c
    public void onFailure(ad.b bVar, IOException iOException) {
        switch (this.f10652g) {
            case 0:
                this.h.resumeWith(kotlin.c.a(iOException));
                break;
            default:
                this.h.resumeWith(kotlin.c.a(iOException));
                break;
        }
    }

    @Override // ad.c
    public void onResponse(ad.b bVar, Response response) {
        switch (this.f10652g) {
            case 0:
                this.h.resumeWith(response);
                break;
            default:
                this.h.resumeWith(response);
                break;
        }
    }
}
