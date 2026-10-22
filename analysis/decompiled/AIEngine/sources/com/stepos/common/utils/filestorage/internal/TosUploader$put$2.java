package com.stepos.common.utils.filestorage.internal;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import bd.d;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import java.io.IOException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.g;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import mb.y;
import o8.f;
import okhttp3.Response;
import okhttp3.h;
import rb.c;
import zb.l;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.TosUploader$put$2", f = "TosUploader.kt", l = {58}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class TosUploader$put$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super f>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public long f6674a;

    /* renamed from: b, reason: collision with root package name */
    public String f6675b;

    /* renamed from: c, reason: collision with root package name */
    public int f6676c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f6677d;

    /* renamed from: e, reason: collision with root package name */
    public final /* synthetic */ Context f6678e;
    public final /* synthetic */ Uri h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ Long f6679j;

    /* renamed from: k, reason: collision with root package name */
    public final /* synthetic */ l<Long, n> f6680k;

    /* renamed from: l, reason: collision with root package name */
    public final /* synthetic */ String f6681l;

    /* renamed from: m, reason: collision with root package name */
    public final /* synthetic */ stepos.support.v7.app.palette.b f6682m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public TosUploader$put$2(String str, Context context, Uri uri, Long l10, l<? super Long, n> lVar, String str2, stepos.support.v7.app.palette.b bVar, qb.b<? super TosUploader$put$2> bVar2) {
        super(2, bVar2);
        this.f6677d = str;
        this.f6678e = context;
        this.h = uri;
        this.f6679j = l10;
        this.f6680k = lVar;
        this.f6681l = str2;
        this.f6682m = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new TosUploader$put$2(this.f6677d, this.f6678e, this.h, this.f6679j, this.f6680k, this.f6681l, this.f6682m, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super f> bVar) {
        return ((TosUploader$put$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws FileStorageException.TosPutFailed {
        ad.l lVarA;
        String str;
        String str2;
        Object result;
        long j10;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6676c;
        stepos.support.v7.app.palette.b bVar = this.f6682m;
        if (i10 == 0) {
            kotlin.c.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            String str3 = this.f6677d;
            g.f(str3, "<this>");
            try {
                lVarA = d.a(str3);
            } catch (IllegalArgumentException unused) {
                lVarA = null;
            }
            n8.g gVar = new n8.g(this.f6678e, this.h, lVarA, this.f6679j, this.f6680k);
            h.a aVar = new h.a();
            aVar.e(this.f6681l);
            aVar.c("PUT", gVar);
            h hVar = new h(aVar);
            String str4 = hVar.f10992a.f10980d;
            Long l10 = this.f6679j;
            str = "/";
            Log.i("FileStorage.Tos", "→ PUT " + str4 + " uri=" + this.h + " ct=" + str3 + " size=" + (l10 != null ? l10.longValue() : -1L));
            try {
                okhttp3.internal.connection.d dVarA = ((ad.n) bVar.h).a(hVar);
                this.f6675b = str4;
                this.f6674a = jCurrentTimeMillis;
                this.f6676c = 1;
                CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(this), 1);
                cancellableContinuationImpl.initCancellability();
                cancellableContinuationImpl.invokeOnCancellation(new n8.b(bVar, dVarA, 1));
                dVarA.Q(new n8.c(cancellableContinuationImpl, 1));
                result = cancellableContinuationImpl.getResult();
                if (result == coroutineSingletons) {
                    return coroutineSingletons;
                }
                str2 = str4;
                j10 = jCurrentTimeMillis;
            } catch (IOException e10) {
                e = e10;
                str2 = str4;
                Log.w("FileStorage.Tos", "✗ PUT " + str2 + " network error: " + e.getMessage());
                throw new FileStorageException.TosPutFailed(-1, ai.onnxruntime.a.k("TOS PUT network error: ", e.getMessage()), e);
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = this.f6674a;
            str2 = this.f6675b;
            try {
                kotlin.c.b(obj);
                result = obj;
                str = "/";
            } catch (IOException e11) {
                e = e11;
                Log.w("FileStorage.Tos", "✗ PUT " + str2 + " network error: " + e.getMessage());
                throw new FileStorageException.TosPutFailed(-1, ai.onnxruntime.a.k("TOS PUT network error: ", e.getMessage()), e);
            }
        }
        Response response = (Response) result;
        try {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - j10;
            try {
                f fVarE = stepos.support.v7.app.palette.b.e(bVar, response);
                int i11 = response.f10891d;
                String str5 = fVarE.f10803a;
                String str6 = fVarE.f10804b;
                String str7 = fVarE.f10809g;
                String str8 = fVarE.h;
                String str9 = fVarE.f10812k;
                String str10 = fVarE.f10813l;
                try {
                    Boolean bool = fVarE.f10815n;
                    StringBuilder sb2 = new StringBuilder("← PUT ");
                    sb2.append(str2);
                    sb2.append(" http=");
                    sb2.append(i11);
                    sb2.append(" ");
                    sb2.append(jCurrentTimeMillis2);
                    sb2.append("ms status=");
                    sb2.append(str5);
                    sb2.append(" fileId=");
                    sb2.append(str6);
                    sb2.append(" audit=");
                    sb2.append(str7);
                    String str11 = str;
                    sb2.append(str11);
                    sb2.append(str8);
                    sb2.append(" sensitive=");
                    sb2.append(str9);
                    sb2.append(str11);
                    sb2.append(str10);
                    sb2.append(" detectPassed=");
                    sb2.append(bool);
                    Log.i("FileStorage.Tos", sb2.toString());
                    response.close();
                    return fVarE;
                } catch (FileStorageException e12) {
                    e = e12;
                    response = response;
                    Log.w("FileStorage.Tos", "← PUT " + str2 + " http=" + response.f10891d + " " + jCurrentTimeMillis2 + "ms err=" + e.getClass().getSimpleName() + ": " + e.getMessage());
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    response = response;
                    Throwable th2 = th;
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        y.q(response, th2);
                        throw th3;
                    }
                }
            } catch (FileStorageException e13) {
                e = e13;
            } catch (Throwable th4) {
                th = th4;
            }
        } catch (Throwable th5) {
            th = th5;
        }
    }
}
