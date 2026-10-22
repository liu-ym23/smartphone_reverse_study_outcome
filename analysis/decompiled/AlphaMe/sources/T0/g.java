package T0;

import Z2.F;
import android.graphics.Bitmap;
import android.os.SystemClock;
import android.util.Log;
import com.stepos.alphame.ocr.OcrTrace;
import g3.C0580d;
import java.util.ArrayList;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes.dex */
public final class g extends SuspendLambda implements Function2 {

    /* renamed from: a, reason: collision with root package name */
    public C0580d f1818a;

    /* renamed from: b, reason: collision with root package name */
    public h f1819b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap f1820c;

    /* renamed from: d, reason: collision with root package name */
    public long f1821d;

    /* renamed from: e, reason: collision with root package name */
    public int f1822e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ h f1823f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ long f1824g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ Bitmap f1825h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(h hVar, long j4, Bitmap bitmap, Continuation continuation) {
        super(2, continuation);
        this.f1823f = hVar;
        this.f1824g = j4;
        this.f1825h = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new g(this.f1823f, this.f1824g, this.f1825h, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return ((g) create((F) obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        h hVar;
        Bitmap bitmap;
        C0580d c0580d;
        long j4;
        Object objM22constructorimpl;
        Object objM22constructorimpl2;
        boolean z4;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = this.f1822e;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            hVar = this.f1823f;
            C0580d c0580d2 = hVar.f1827b;
            long j5 = this.f1824g;
            bitmap = this.f1825h;
            this.f1818a = c0580d2;
            this.f1819b = hVar;
            this.f1820c = bitmap;
            this.f1821d = j5;
            this.f1822e = 1;
            if (c0580d2.d(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            c0580d = c0580d2;
            j4 = j5;
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j4 = this.f1821d;
            bitmap = this.f1820c;
            hVar = this.f1819b;
            c0580d = this.f1818a;
            ResultKt.throwOnFailure(obj);
        }
        try {
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            long j6 = jElapsedRealtime - j4;
            if (hVar.f1828c.b()) {
                hVar.f1828c.f(bitmap);
                try {
                    U0.b bVar = hVar.f1828c;
                    try {
                        Result.Companion companion = Result.INSTANCE;
                        if (bVar.b()) {
                            bVar.e(hVar.f1835j, hVar.f1834i, hVar.f1836k);
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        objM22constructorimpl = Result.m22constructorimpl(Boolean.valueOf(z4));
                    } catch (Throwable th) {
                        Result.Companion companion2 = Result.INSTANCE;
                        objM22constructorimpl = Result.m22constructorimpl(ResultKt.createFailure(th));
                    }
                    Throwable thM25exceptionOrNullimpl = Result.m25exceptionOrNullimpl(objM22constructorimpl);
                    if (thM25exceptionOrNullimpl != null) {
                        if (U0.b.f1891s) {
                            Log.i(OcrTrace.TAG, "runSync lockWait=" + j6 + "ms held=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms result=ERR:" + thM25exceptionOrNullimpl);
                        }
                        objM22constructorimpl2 = Result.m22constructorimpl(ResultKt.createFailure(thM25exceptionOrNullimpl));
                    } else if (((Boolean) objM22constructorimpl).booleanValue()) {
                        String str = hVar.f1828c.f1904m;
                        Intrinsics.checkNotNullExpressionValue(str, "outputResult(...)");
                        U0.b bVar2 = hVar.f1828c;
                        float f4 = bVar2.f1898g;
                        Bitmap bitmap2 = bVar2.f1902k;
                        Intrinsics.checkNotNullExpressionValue(bitmap2, "outputImage(...)");
                        ArrayList arrayList = hVar.f1828c.f1905n;
                        Intrinsics.checkNotNullExpressionValue(arrayList, "outputRawResult(...)");
                        V0.a aVar = new V0.a(str, f4, bitmap2, arrayList);
                        if (U0.b.f1891s) {
                            Log.i(OcrTrace.TAG, "runSync lockWait=" + j6 + "ms held=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms result=OK");
                        }
                        objM22constructorimpl2 = Result.m22constructorimpl(aVar);
                    } else {
                        if (U0.b.f1891s) {
                            Log.i(OcrTrace.TAG, "runSync lockWait=" + j6 + "ms held=" + (SystemClock.elapsedRealtime() - jElapsedRealtime) + "ms result=RUN_FALSE");
                        }
                        objM22constructorimpl2 = Result.m22constructorimpl(ResultKt.createFailure(new X0.a("请检查模型是否已成功加载！", 1)));
                    }
                    hVar.f1828c.c();
                } catch (Throwable th2) {
                    hVar.f1828c.c();
                    throw th2;
                }
            } else {
                if (U0.b.f1891s) {
                    Log.i(OcrTrace.TAG, "runSync lockWait=" + j6 + "ms result=NOT_LOADED");
                }
                Result.Companion companion3 = Result.INSTANCE;
                objM22constructorimpl2 = Result.m22constructorimpl(ResultKt.createFailure(new X0.a("请先加载模型！", 1)));
            }
            Result resultM21boximpl = Result.m21boximpl(objM22constructorimpl2);
            c0580d.e(null);
            return resultM21boximpl;
        } catch (Throwable th3) {
            c0580d.e(null);
            throw th3;
        }
    }
}
