package androidx.appfunctions.internal;

import C7.r;
import androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;

@J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1", f = "AppSearchAppFunctionReader.kt", l = {107, 107}, m = "emit", v = 1)
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1.AnonymousClass1<T> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1(AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1.AnonymousClass1<? super T> anonymousClass1, H7.c<? super AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1> cVar) {
        super(cVar);
        this.this$0 = anonymousClass1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.emit((r) null, (H7.c<? super r>) this);
    }
}
