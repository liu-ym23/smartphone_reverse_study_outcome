package androidx.appfunctions.internal;

import C7.r;
import S7.n;
import androidx.appfunctions.AppFunctionSearchSpec;
import androidx.appfunctions.internal.AppSearchAppFunctionReader;
import androidx.appsearch.app.GlobalSearchSession;
import androidx.core.location.LocationRequestCompat;
import kotlin.Metadata;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.flow.d;
import m9.InterfaceC1733z;
import o9.InterfaceC1786l;

@J7.c(c = "androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1", f = "AppSearchAppFunctionReader.kt", l = {LocationRequestCompat.QUALITY_LOW_POWER}, m = "invokeSuspend", v = 1)
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 1, 0})
/* loaded from: classes.dex */
public final class AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1 extends SuspendLambda implements n {
    final /* synthetic */ InterfaceC1786l $$this$callbackFlow;
    final /* synthetic */ AppSearchAppFunctionReader.AppSearchChannelObserver $appSearchChannelObserver;
    final /* synthetic */ AppFunctionSearchSpec $searchFunctionSpec;
    final /* synthetic */ GlobalSearchSession $session;
    int label;
    final /* synthetic */ AppSearchAppFunctionReader this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1(AppSearchAppFunctionReader.AppSearchChannelObserver appSearchChannelObserver, InterfaceC1786l interfaceC1786l, AppSearchAppFunctionReader appSearchAppFunctionReader, GlobalSearchSession globalSearchSession, AppFunctionSearchSpec appFunctionSearchSpec, H7.c<? super AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1> cVar) {
        super(2, cVar);
        this.$appSearchChannelObserver = appSearchChannelObserver;
        this.$$this$callbackFlow = interfaceC1786l;
        this.this$0 = appSearchAppFunctionReader;
        this.$session = globalSearchSession;
        this.$searchFunctionSpec = appFunctionSearchSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final H7.c<r> create(Object obj, H7.c<?> cVar) {
        return new AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1(this.$appSearchChannelObserver, this.$$this$callbackFlow, this.this$0, this.$session, this.$searchFunctionSpec, cVar);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
        int i = this.label;
        if (i == 0) {
            kotlin.b.b(obj);
            p9.c cVarE = d.e(this.$appSearchChannelObserver.observe(), AppSearchAppFunctionReader.Companion.m7getOBSERVER_DEBOUNCE_MILLISUwyO8pc());
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$$this$callbackFlow, this.this$0, this.$session, this.$searchFunctionSpec);
            this.label = 1;
            if (cVarE.collect(anonymousClass1, this) == coroutineSingletons) {
                return coroutineSingletons;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
        }
        return r.f317a;
    }

    @Override // S7.n
    public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
        return ((AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1, reason: invalid class name */
    public static final class AnonymousClass1<T> implements p9.d {
        final /* synthetic */ InterfaceC1786l $$this$callbackFlow;
        final /* synthetic */ AppFunctionSearchSpec $searchFunctionSpec;
        final /* synthetic */ GlobalSearchSession $session;
        final /* synthetic */ AppSearchAppFunctionReader this$0;

        public AnonymousClass1(InterfaceC1786l interfaceC1786l, AppSearchAppFunctionReader appSearchAppFunctionReader, GlobalSearchSession globalSearchSession, AppFunctionSearchSpec appFunctionSearchSpec) {
            this.$$this$callbackFlow = interfaceC1786l;
            this.this$0 = appSearchAppFunctionReader;
            this.$session = globalSearchSession;
            this.$searchFunctionSpec = appFunctionSearchSpec;
        }

        /* JADX WARN: Code restructure failed: missing block: B:21:0x0060, code lost:
        
            if (((o9.C1785k) r6).d.p(r7, r8) == r0) goto L22;
         */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object emit(C7.r r7, H7.c<? super C7.r> r8) {
            /*
                r6 = this;
                boolean r7 = r8 instanceof androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1
                if (r7 == 0) goto L13
                r7 = r8
                androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1 r7 = (androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1) r7
                int r0 = r7.label
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = r0 & r1
                if (r2 == 0) goto L13
                int r0 = r0 - r1
                r7.label = r0
                goto L18
            L13:
                androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1 r7 = new androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1$1$emit$1
                r7.<init>(r6, r8)
            L18:
                java.lang.Object r8 = r7.result
                kotlin.coroutines.intrinsics.CoroutineSingletons r0 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
                int r1 = r7.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L3a
                if (r1 == r3) goto L32
                if (r1 != r2) goto L2a
                kotlin.b.b(r8)
                goto L63
            L2a:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L32:
                java.lang.Object r6 = r7.L$0
                o9.l r6 = (o9.InterfaceC1786l) r6
                kotlin.b.b(r8)
                goto L53
            L3a:
                kotlin.b.b(r8)
                o9.l r8 = r6.$$this$callbackFlow
                androidx.appfunctions.internal.AppSearchAppFunctionReader r1 = r6.this$0
                androidx.appsearch.app.GlobalSearchSession r4 = r6.$session
                androidx.appfunctions.AppFunctionSearchSpec r6 = r6.$searchFunctionSpec
                r7.L$0 = r8
                r7.label = r3
                java.lang.Object r6 = androidx.appfunctions.internal.AppSearchAppFunctionReader.access$performSearch(r1, r4, r6, r7)
                if (r6 != r0) goto L50
                goto L62
            L50:
                r5 = r8
                r8 = r6
                r6 = r5
            L53:
                r1 = 0
                r7.L$0 = r1
                r7.label = r2
                o9.k r6 = (o9.C1785k) r6
                kotlinx.coroutines.channels.a r6 = r6.d
                java.lang.Object r6 = r6.p(r7, r8)
                if (r6 != r0) goto L63
            L62:
                return r0
            L63:
                C7.r r6 = C7.r.f317a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appfunctions.internal.AppSearchAppFunctionReader$searchAppFunctions$2$observerJob$1.AnonymousClass1.emit(C7.r, H7.c):java.lang.Object");
        }

        @Override // p9.d
        public /* bridge */ /* synthetic */ Object emit(Object obj, H7.c cVar) {
            return emit((r) obj, (H7.c<? super r>) cVar);
        }
    }
}
