package stepai.aios.guiagent.util;

import J7.c;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@c(c = "stepai.aios.guiagent.util.AppUtils", f = "AppUtils.kt", l = {33, 49}, m = "openAppAndReturnPackage-yxL6bBk", v = 1)
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
final class AppUtils$openAppAndReturnPackage$1 extends ContinuationImpl {

    /* renamed from: a, reason: collision with root package name */
    public String f6175a;
    public String b;
    public long c;
    public /* synthetic */ Object d;
    public final /* synthetic */ a e;
    public int f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppUtils$openAppAndReturnPackage$1(a aVar, ContinuationImpl continuationImpl) {
        super(continuationImpl);
        this.e = aVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.d = obj;
        this.f |= Integer.MIN_VALUE;
        Serializable serializableB = this.e.b(null, 0L, null, this);
        return serializableB == CoroutineSingletons.f4909a ? serializableB : new Result(serializableB);
    }
}
