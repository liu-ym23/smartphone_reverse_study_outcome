package c7;

import b6.f;
import com.stepos.core.common.log.AIEngineLogger;
import com.stepos.core.common.log.TraceContext;
import java.util.function.BiFunction;
import zb.p;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class a implements BiFunction {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3300a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f3301b;

    public /* synthetic */ a(p pVar, int i10) {
        this.f3300a = i10;
        this.f3301b = pVar;
    }

    @Override // java.util.function.BiFunction
    public final Object apply(Object obj, Object obj2) {
        int i10 = this.f3300a;
        p pVar = this.f3301b;
        switch (i10) {
            case 0:
                return (Long) ((f) pVar).invoke(obj, obj2);
            case 1:
                return AIEngineLogger.perfEnd$lambda$3((com.stepos.core.common.log.a) pVar, obj, obj2);
            default:
                return TraceContext.updateStats$lambda$10((b6.c) pVar, obj, obj2);
        }
    }
}
