package kotlinx.serialization.json.internal;

import com.stepos.deepbinder.core.exception.ErrorCodes;
import java.util.LinkedHashMap;
import kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import rb.c;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
@c(c = "kotlinx.serialization.json.internal.JsonTreeReader", f = "JsonTreeReader.kt", l = {ErrorCodes.GET_INSTANCE_METHOD_INVOCATION_ERROR}, m = "readObject")
/* loaded from: classes.dex */
final class JsonTreeReader$readObject$2 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public lb.a f10130a;

    /* renamed from: b, reason: collision with root package name */
    public a f10131b;

    /* renamed from: c, reason: collision with root package name */
    public LinkedHashMap f10132c;

    /* renamed from: d, reason: collision with root package name */
    public String f10133d;

    /* renamed from: e, reason: collision with root package name */
    public /* synthetic */ Object f10134e;
    public final /* synthetic */ a h;

    /* renamed from: j, reason: collision with root package name */
    public int f10135j;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JsonTreeReader$readObject$2(a aVar, BaseContinuationImpl baseContinuationImpl) {
        super(baseContinuationImpl);
        this.h = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.f10134e = obj;
        this.f10135j |= Integer.MIN_VALUE;
        return a.a(this.h, null, this);
    }
}
