package io.ktor.server.routing;

import La.H;
import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.fasterxml.jackson.core.JsonPointer;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.CodecsKt;
import io.ktor.http.HttpStatusCode;
import io.ktor.http.ParametersBuilder;
import io.ktor.http.ParametersKt;
import io.ktor.http.URLDecodeException;
import io.ktor.server.application.PipelineCall;
import io.ktor.server.plugins.BadRequestException;
import io.ktor.server.request.ApplicationRequestPropertiesKt;
import io.ktor.server.routing.RouteSelectorEvaluation;
import io.ktor.server.routing.RoutingResolveResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import p9.InterfaceC5074l;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0018\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u001d\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\r0\u00062\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J@\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00162\u0006\u0010\u0019\u001a\u00020\u0018H\u0082@¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001d\u0010!\u001a\u00020 2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00150\u0006H\u0002¢\u0006\u0004\b!\u0010\"J/\u0010$\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020#2\u0016\u0010\u0017\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u0016H\u0002¢\u0006\u0004\b$\u0010%J\u0010\u0010&\u001a\u00020\u001cH\u0086@¢\u0006\u0004\b&\u0010'R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010(\u001a\u0004\b)\u0010*R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010+\u001a\u0004\b,\u0010-R&\u0010\n\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00070\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010.R\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\r0\u00068\u0006¢\u0006\f\n\u0004\b/\u0010.\u001a\u0004\b0\u00101R\u0017\u00102\u001a\u00020 8\u0006¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b4\u00105R\u0016\u00106\u001a\u0004\u0018\u00010\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107R$\u00108\u001a\u0012\u0012\u0004\u0012\u00020\u00150\u0014j\b\u0012\u0004\u0012\u00020\u0015`\u00168\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u0018\u0010:\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u0010=¨\u0006>"}, d2 = {"Lio/ktor/server/routing/RoutingResolveContext;", "", "Lio/ktor/server/routing/RoutingNode;", "routing", "Lio/ktor/server/application/PipelineCall;", "call", "", "Lkotlin/Function1;", "Lio/ktor/server/routing/RoutingResolveTrace;", "LY8/t;", "tracers", "<init>", "(Lio/ktor/server/routing/RoutingNode;Lio/ktor/server/application/PipelineCall;Ljava/util/List;)V", "", "path", M5.e.FAIL_PARSE, "(Ljava/lang/String;)Ljava/util/List;", "entry", "", "segmentIndex", "Ljava/util/ArrayList;", "Lio/ktor/server/routing/RoutingResolveResult$Success;", "Lkotlin/collections/ArrayList;", "trait", "", "matchedQuality", "handleRoute", "(Lio/ktor/server/routing/RoutingNode;ILjava/util/ArrayList;DLe9/c;)Ljava/lang/Object;", "Lio/ktor/server/routing/RoutingResolveResult;", "findBestRoute", "()Lio/ktor/server/routing/RoutingResolveResult;", Const.STR_NEW, "", "isBetterResolve", "(Ljava/util/List;)Z", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "updateFailedEvaluation", "(Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;Ljava/util/ArrayList;)V", "resolve", "(Le9/c;)Ljava/lang/Object;", "Lio/ktor/server/routing/RoutingNode;", "getRouting", "()Lio/ktor/server/routing/RoutingNode;", "Lio/ktor/server/application/PipelineCall;", "getCall", "()Lio/ktor/server/application/PipelineCall;", "Ljava/util/List;", "segments", "getSegments", "()Ljava/util/List;", "hasTrailingSlash", "Z", "getHasTrailingSlash", "()Z", "trace", "Lio/ktor/server/routing/RoutingResolveTrace;", "resolveResult", "Ljava/util/ArrayList;", "failedEvaluation", "Lio/ktor/server/routing/RouteSelectorEvaluation$Failure;", "failedEvaluationDepth", "I", "ktor-server-core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RoutingResolveContext {
    private final PipelineCall call;
    private RouteSelectorEvaluation.Failure failedEvaluation;
    private int failedEvaluationDepth;
    private final boolean hasTrailingSlash;
    private final ArrayList<RoutingResolveResult.Success> resolveResult;
    private final RoutingNode routing;
    private final List<String> segments;
    private final RoutingResolveTrace trace;
    private final List<InterfaceC5074l<RoutingResolveTrace, Y8.t>> tracers;

    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingResolveContext", f = "RoutingResolveContext.kt", l = {107, 167}, m = "handleRoute")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.routing.RoutingResolveContext$handleRoute$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        double D$0;
        int I$0;
        int I$1;
        int I$2;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoutingResolveContext.this.handleRoute(null, 0, null, 0.0d, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.routing.RoutingResolveContext", f = "RoutingResolveContext.kt", l = {92}, m = "resolve")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.routing.RoutingResolveContext$resolve$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43991 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        public C43991(InterfaceC4014c<? super C43991> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RoutingResolveContext.this.resolve(this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public RoutingResolveContext(RoutingNode routing, PipelineCall call, List<? extends InterfaceC5074l<? super RoutingResolveTrace, Y8.t>> tracers) throws BadRequestException {
        kotlin.jvm.internal.p.i(routing, "routing");
        kotlin.jvm.internal.p.i(call, "call");
        kotlin.jvm.internal.p.i(tracers, "tracers");
        this.routing = routing;
        this.call = call;
        this.tracers = tracers;
        RoutingResolveTrace routingResolveTrace = null;
        this.hasTrailingSlash = H.j0(ApplicationRequestPropertiesKt.path(call.getRequest()), JsonPointer.SEPARATOR, false, 2, null);
        this.resolveResult = new ArrayList<>(16);
        this.failedEvaluation = RouteSelectorEvaluation.INSTANCE.getFailedPath();
        try {
            List<String> list = parse(ApplicationRequestPropertiesKt.path(call.getRequest()));
            this.segments = list;
            if (!tracers.isEmpty()) {
                routingResolveTrace = new RoutingResolveTrace(call, list);
            }
            this.trace = routingResolveTrace;
        } catch (URLDecodeException e10) {
            throw new BadRequestException("Url decode failed for " + ApplicationRequestPropertiesKt.getUri(this.call.getRequest()), e10);
        }
    }

    private final RoutingResolveResult findBestRoute() {
        HttpStatusCode notFound;
        ArrayList<RoutingResolveResult.Success> arrayList = this.resolveResult;
        if (arrayList.isEmpty()) {
            RoutingNode routingNode = this.routing;
            RouteSelectorEvaluation.Failure failure = this.failedEvaluation;
            if (failure == null || (notFound = failure.getFailureStatusCode()) == null) {
                notFound = HttpStatusCode.INSTANCE.getNotFound();
            }
            return new RoutingResolveResult.Failure(routingNode, "No matched subtrees found", notFound);
        }
        int i10 = 0;
        ParametersBuilder parametersBuilderParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        int iO = C1173v.o(arrayList);
        double dMin = Double.MAX_VALUE;
        if (iO >= 0) {
            while (true) {
                RoutingResolveResult.Success success = arrayList.get(i10);
                kotlin.jvm.internal.p.h(success, "get(...)");
                RoutingResolveResult.Success success2 = success;
                parametersBuilderParametersBuilder$default.appendAll(success2.getParameters());
                dMin = Math.min(dMin, success2.getQuality() == -1.0d ? 1.0d : success2.getQuality());
                if (i10 == iO) {
                    break;
                }
                i10++;
            }
        }
        return new RoutingResolveResult.Success(((RoutingResolveResult.Success) Z8.F.C0(arrayList)).getRoute(), parametersBuilderParametersBuilder$default.build(), dMin);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0094, code lost:
    
        if (r2 == r7) goto L73;
     */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0019  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01ed  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fb  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:74:0x01b8 -> B:75:0x01c1). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object handleRoute(io.ktor.server.routing.RoutingNode r23, int r24, java.util.ArrayList<io.ktor.server.routing.RoutingResolveResult.Success> r25, double r26, e9.InterfaceC4014c<? super java.lang.Double> r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 525
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingResolveContext.handleRoute(io.ktor.server.routing.RoutingNode, int, java.util.ArrayList, double, e9.c):java.lang.Object");
    }

    private final boolean isBetterResolve(List<RoutingResolveResult.Success> list) {
        int i10;
        int i11;
        ArrayList<RoutingResolveResult.Success> arrayList = this.resolveResult;
        int i12 = 0;
        int i13 = 0;
        while (i12 < arrayList.size() && i13 < list.size()) {
            double quality = arrayList.get(i12).getQuality();
            double quality2 = list.get(i13).getQuality();
            if (quality == -1.0d) {
                i12++;
            } else {
                if (quality2 != -1.0d) {
                    if (quality != quality2) {
                        return quality2 > quality;
                    }
                    i12++;
                }
                i13++;
            }
        }
        if (arrayList.isEmpty()) {
            i10 = 0;
        } else {
            Iterator<T> it = arrayList.iterator();
            i10 = 0;
            while (it.hasNext()) {
                if (!(((RoutingResolveResult.Success) it.next()).getQuality() == -1.0d) && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        List<RoutingResolveResult.Success> list2 = list;
        if ((list2 instanceof Collection) && list2.isEmpty()) {
            i11 = 0;
        } else {
            Iterator<T> it2 = list2.iterator();
            i11 = 0;
            while (it2.hasNext()) {
                if (!(((RoutingResolveResult.Success) it2.next()).getQuality() == -1.0d) && (i11 = i11 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        return i11 > i10;
    }

    private final List<String> parse(String path) {
        if (path.length() == 0 || kotlin.jvm.internal.p.d(path, "/")) {
            return C1173v.m();
        }
        int length = path.length();
        int i10 = 0;
        for (int i11 = 0; i11 < path.length(); i11++) {
            if (path.charAt(i11) == '/') {
                i10++;
            }
        }
        ArrayList arrayList = new ArrayList(i10);
        int i12 = 0;
        int i13 = 0;
        while (i12 < length) {
            int i14 = i13;
            String str = path;
            int iT0 = H.t0(str, JsonPointer.SEPARATOR, i14, false, 4, null);
            i12 = iT0 == -1 ? length : iT0;
            if (i12 == i14) {
                i13 = i12 + 1;
            } else {
                int i15 = i12;
                arrayList.add(CodecsKt.decodeURLPart$default(str, i14, i15, null, 4, null));
                i13 = i15 + 1;
            }
            path = str;
        }
        String str2 = path;
        if (!IgnoreTrailingSlashKt.getIgnoreTrailingSlash(this.call) && La.D.K(str2, "/", false, 2, null)) {
            arrayList.add("");
        }
        return arrayList;
    }

    private final void updateFailedEvaluation(RouteSelectorEvaluation.Failure failure, ArrayList<RoutingResolveResult.Success> trait) {
        RouteSelectorEvaluation.Failure failure2 = this.failedEvaluation;
        if (failure2 == null) {
            return;
        }
        if (failure2.getQuality() < failure.getQuality() || this.failedEvaluationDepth < trait.size()) {
            if (trait == null || !trait.isEmpty()) {
                for (RoutingResolveResult.Success success : trait) {
                    if (success.getQuality() != -1.0d && success.getQuality() != 1.0d) {
                        return;
                    }
                }
            }
            this.failedEvaluation = failure;
            this.failedEvaluationDepth = trait.size();
        }
    }

    public final PipelineCall getCall() {
        return this.call;
    }

    public final boolean getHasTrailingSlash() {
        return this.hasTrailingSlash;
    }

    public final RoutingNode getRouting() {
        return this.routing;
    }

    public final List<String> getSegments() {
        return this.segments;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object resolve(e9.InterfaceC4014c<? super io.ktor.server.routing.RoutingResolveResult> r9) throws java.lang.Throwable {
        /*
            r8 = this;
            boolean r0 = r9 instanceof io.ktor.server.routing.RoutingResolveContext.C43991
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.server.routing.RoutingResolveContext$resolve$1 r0 = (io.ktor.server.routing.RoutingResolveContext.C43991) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.label = r1
        L12:
            r7 = r0
            goto L1a
        L14:
            io.ktor.server.routing.RoutingResolveContext$resolve$1 r0 = new io.ktor.server.routing.RoutingResolveContext$resolve$1
            r0.<init>(r9)
            goto L12
        L1a:
            java.lang.Object r9 = r7.result
            java.lang.Object r0 = f9.C4063a.g()
            int r1 = r7.label
            r2 = 1
            if (r1 == 0) goto L34
            if (r1 != r2) goto L2c
            kotlin.C4849c.b(r9)
            r1 = r8
            goto L4f
        L2c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L34:
            kotlin.C4849c.b(r9)
            r9 = r2
            io.ktor.server.routing.RoutingNode r2 = r8.routing
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r7.label = r9
            r3 = 0
            r5 = -4503599627370497(0xffefffffffffffff, double:-1.7976931348623157E308)
            r1 = r8
            java.lang.Object r8 = r1.handleRoute(r2, r3, r4, r5, r7)
            if (r8 != r0) goto L4f
            return r0
        L4f:
            io.ktor.server.routing.RoutingResolveResult r8 = r1.findBestRoute()
            io.ktor.server.routing.RoutingResolveTrace r9 = r1.trace
            if (r9 == 0) goto L5a
            r9.registerFinalResult(r8)
        L5a:
            io.ktor.server.routing.RoutingResolveTrace r9 = r1.trace
            if (r9 == 0) goto L76
            java.util.List<p9.l<io.ktor.server.routing.RoutingResolveTrace, Y8.t>> r0 = r1.tracers
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L66:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L76
            java.lang.Object r1 = r0.next()
            p9.l r1 = (p9.InterfaceC5074l) r1
            r1.invoke(r9)
            goto L66
        L76:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.routing.RoutingResolveContext.resolve(e9.c):java.lang.Object");
    }
}
