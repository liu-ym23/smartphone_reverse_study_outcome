package b7;

import android.content.Context;
import kotlin.Result;
import kotlinx.coroutines.flow.Flow;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public interface a {
    boolean cancel();

    /* renamed from: close-IoAF18A, reason: not valid java name */
    Object mo9closeIoAF18A(qb.b<? super Result<lb.n>> bVar);

    k getConfig();

    /* renamed from: infer-0E7RQCE, reason: not valid java name */
    Object mo10infer0E7RQCE(Object obj, zb.l<? super Result<? extends Object>, lb.n> lVar, qb.b<? super Result<? extends Object>> bVar);

    Object inferStreaming(Object obj, qb.b<? super Flow<? extends Result<? extends Object>>> bVar);

    /* renamed from: initialize-gIAlu-s, reason: not valid java name */
    Object mo11initializegIAlus(Context context, qb.b<? super Result<lb.n>> bVar);

    boolean isReady();
}
