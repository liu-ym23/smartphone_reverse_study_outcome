package com.stepos.common.utils.filestorage.internal;

import android.util.Log;
import com.stepos.common.utils.filestorage.exceptions.FileStorageException;
import com.stepos.core.common.cloud.BffModelProxy;
import java.io.IOException;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import lb.n;
import okhttp3.Response;
import okhttp3.g;
import okhttp3.h;
import okhttp3.internal.connection.d;
import rb.c;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "com.stepos.common.utils.filestorage.internal.GatewayClient$execute$2", f = "GatewayClient.kt", l = {115}, m = "invokeSuspend")
/* loaded from: classes.dex */
final class GatewayClient$execute$2 extends SuspendLambda implements p<CoroutineScope, qb.b<? super String>, Object> {

    /* renamed from: a, reason: collision with root package name */
    public long f6660a;

    /* renamed from: b, reason: collision with root package name */
    public String f6661b;

    /* renamed from: c, reason: collision with root package name */
    public String f6662c;

    /* renamed from: d, reason: collision with root package name */
    public String f6663d;

    /* renamed from: e, reason: collision with root package name */
    public int f6664e;
    public final /* synthetic */ h h;

    /* renamed from: j, reason: collision with root package name */
    public final /* synthetic */ b f6665j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GatewayClient$execute$2(h hVar, b bVar, qb.b<? super GatewayClient$execute$2> bVar2) {
        super(2, bVar2);
        this.h = hVar;
        this.f6665j = bVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final qb.b<n> create(Object obj, qb.b<?> bVar) {
        return new GatewayClient$execute$2(this.h, this.f6665j, bVar);
    }

    @Override // zb.p
    public final Object invoke(CoroutineScope coroutineScope, qb.b<? super String> bVar) {
        return ((GatewayClient$execute$2) create(coroutineScope, bVar)).invokeSuspend(n.f10413a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws FileStorageException.Network {
        String strConcat;
        String str;
        String str2;
        String str3;
        long j10;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f10059a;
        int i10 = this.f6664e;
        b bVar = this.f6665j;
        if (i10 == 0) {
            kotlin.c.b(obj);
            long jCurrentTimeMillis = System.currentTimeMillis();
            h hVar = this.h;
            String str4 = hVar.f10993b;
            g gVar = hVar.f10992a;
            String strB = gVar.b();
            String strD = gVar.d();
            if (strD == null || (strConcat = "?".concat(strD)) == null) {
                strConcat = "";
            }
            String strConcat2 = strB.concat(strConcat);
            String strA = hVar.a(BffModelProxy.HEADER_TRACE_ID);
            ai.onnxruntime.a.y(ai.onnxruntime.a.s("→ ", str4, " ", strConcat2, " trace="), strA, "FileStorage.Gateway");
            try {
                d dVarA = bVar.f6768d.a(hVar);
                this.f6661b = str4;
                this.f6662c = strConcat2;
                this.f6663d = strA;
                this.f6660a = jCurrentTimeMillis;
                this.f6664e = 1;
                try {
                    CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(jd.b.w(this), 1);
                    cancellableContinuationImpl.initCancellability();
                    cancellableContinuationImpl.invokeOnCancellation(new n8.b(bVar, dVarA, 0));
                    dVarA.Q(new n8.c(cancellableContinuationImpl, 0));
                    obj = cancellableContinuationImpl.getResult();
                    if (obj == coroutineSingletons) {
                        return coroutineSingletons;
                    }
                    str = str4;
                    j10 = jCurrentTimeMillis;
                    str2 = strConcat2;
                    str3 = strA;
                } catch (IOException e10) {
                    e = e10;
                    str = str4;
                    str2 = strConcat2;
                    str3 = strA;
                    String message = e.getMessage();
                    StringBuilder sbS = ai.onnxruntime.a.s("✗ ", str, " ", str2, " trace=");
                    sbS.append(str3);
                    sbS.append(" network error: ");
                    sbS.append(message);
                    Log.w("FileStorage.Gateway", sbS.toString());
                    throw new FileStorageException.Network(ai.onnxruntime.a.k("Network error: ", e.getMessage()), e);
                }
            } catch (IOException e11) {
                e = e11;
            }
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = this.f6660a;
            str3 = this.f6663d;
            str2 = this.f6662c;
            str = this.f6661b;
            try {
                kotlin.c.b(obj);
            } catch (IOException e12) {
                e = e12;
                String message2 = e.getMessage();
                StringBuilder sbS2 = ai.onnxruntime.a.s("✗ ", str, " ", str2, " trace=");
                sbS2.append(str3);
                sbS2.append(" network error: ");
                sbS2.append(message2);
                Log.w("FileStorage.Gateway", sbS2.toString());
                throw new FileStorageException.Network(ai.onnxruntime.a.k("Network error: ", e.getMessage()), e);
            }
        }
        Response response = (Response) obj;
        try {
            long jCurrentTimeMillis2 = System.currentTimeMillis() - j10;
            try {
                String strA2 = b.a(bVar, response);
                Log.i("FileStorage.Gateway", "← " + str + " " + str2 + " trace=" + str3 + " http=" + response.f10891d + " " + jCurrentTimeMillis2 + "ms");
                response.close();
                return strA2;
            } catch (FileStorageException e13) {
                Log.w("FileStorage.Gateway", "← " + str + " " + str2 + " trace=" + str3 + " http=" + response.f10891d + " " + jCurrentTimeMillis2 + "ms err=" + e13.getClass().getSimpleName() + ": " + e13.getMessage());
                throw e13;
            }
        } finally {
        }
    }
}
