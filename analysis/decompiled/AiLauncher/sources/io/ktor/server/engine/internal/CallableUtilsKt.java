package io.ktor.server.engine.internal;

import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import io.ktor.http.ContentType;
import io.ktor.server.application.Application;
import io.ktor.server.application.ModuleParametersInjector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.reflect.KParameter;
import w9.InterfaceC5745d;
import w9.InterfaceC5748g;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\t\u001a\u00020\b2\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0080@¢\u0006\u0004\b\t\u0010\n\u001a,\u0010\u000e\u001a\u00020\r2\n\u0010\f\u001a\u0006\u0012\u0002\b\u00030\u000b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u000e\u0010\u000f\u001a>\u0010\u0014\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00028\u00000\u00122\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0082@¢\u0006\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Ljava/lang/ClassLoader;", "classLoader", "", "fqName", "Lio/ktor/server/application/Application;", ContentType.Application.TYPE, "Lio/ktor/server/application/ModuleParametersInjector;", "moduleInjector", "LY8/t;", "executeModuleFunction", "(Ljava/lang/ClassLoader;Ljava/lang/String;Lio/ktor/server/application/Application;Lio/ktor/server/application/ModuleParametersInjector;Le9/c;)Ljava/lang/Object;", "Lw9/d;", "applicationEntryClass", "", "createModuleContainer", "(Lw9/d;Lio/ktor/server/application/Application;Lio/ktor/server/application/ModuleParametersInjector;Le9/c;)Ljava/lang/Object;", "R", "instance", "Lw9/g;", "entryPoint", "callFunctionWithInjection", "(Ljava/lang/Object;Lw9/g;Lio/ktor/server/application/Application;Lio/ktor/server/application/ModuleParametersInjector;Le9/c;)Ljava/lang/Object;", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class CallableUtilsKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @InterfaceC4112d(c = "io.ktor.server.engine.internal.CallableUtilsKt", f = "CallableUtils.kt", l = {112, 138}, m = "callFunctionWithInjection")
    /* renamed from: io.ktor.server.engine.internal.CallableUtilsKt$callFunctionWithInjection$1, reason: invalid class name */
    public static final class AnonymousClass1<R> extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallableUtilsKt.callFunctionWithInjection(null, null, null, null, this);
        }
    }

    @InterfaceC4112d(c = "io.ktor.server.engine.internal.CallableUtilsKt", f = "CallableUtils.kt", l = {42, 73, 74}, m = "executeModuleFunction")
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    /* renamed from: io.ktor.server.engine.internal.CallableUtilsKt$executeModuleFunction$1, reason: invalid class name and case insensitive filesystem */
    public static final class C43621 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C43621(InterfaceC4014c<? super C43621> interfaceC4014c) {
            super(interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return CallableUtilsKt.executeModuleFunction(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Type inference failed for: r14v15 */
    /* JADX WARN: Type inference failed for: r14v17, types: [java.util.Collection] */
    /* JADX WARN: Type inference failed for: r14v18 */
    /* JADX WARN: Type inference failed for: r14v2 */
    /* JADX WARN: Type inference failed for: r14v4 */
    /* JADX WARN: Type inference failed for: r14v5 */
    /* JADX WARN: Type inference failed for: r14v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x0085 -> B:52:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x008e -> B:52:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x009c -> B:52:0x0103). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x00bc -> B:37:0x00c4). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final <R> java.lang.Object callFunctionWithInjection(java.lang.Object r11, w9.InterfaceC5748g<? extends R> r12, io.ktor.server.application.Application r13, io.ktor.server.application.ModuleParametersInjector r14, e9.InterfaceC4014c<? super R> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 480
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.internal.CallableUtilsKt.callFunctionWithInjection(java.lang.Object, w9.g, io.ktor.server.application.Application, io.ktor.server.application.ModuleParametersInjector, e9.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object createModuleContainer(InterfaceC5745d<?> interfaceC5745d, Application application, ModuleParametersInjector moduleParametersInjector, InterfaceC4014c<Object> interfaceC4014c) {
        Object objF = interfaceC5745d.f();
        if (objF != null) {
            return objF;
        }
        Collection<InterfaceC5748g<?>> collectionH = interfaceC5745d.h();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionH) {
            List<KParameter> parameters = ((InterfaceC5748g) obj).getParameters();
            if (!(parameters instanceof Collection) || !parameters.isEmpty()) {
                for (KParameter kParameter : parameters) {
                    if (kParameter.v() || AutoReloadUtilsKt.isApplicationEnvironment(kParameter) || AutoReloadUtilsKt.isApplication(kParameter)) {
                    }
                }
            }
            arrayList.add(obj);
        }
        InterfaceC5748g interfaceC5748gBestFunction = AutoReloadUtilsKt.bestFunction(arrayList);
        if (interfaceC5748gBestFunction != null) {
            return callFunctionWithInjection(null, interfaceC5748gBestFunction, application, moduleParametersInjector, interfaceC4014c);
        }
        throw new RuntimeException("There are no applicable constructors found in class " + interfaceC5745d);
    }

    /* JADX WARN: Code restructure failed: missing block: B:57:0x013a, code lost:
    
        if (callFunctionWithInjection(null, r2, r19, r20, r8) == r9) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x020d, code lost:
    
        if (callFunctionWithInjection(r0, r1, r3, r2, r8) != r9) goto L98;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object executeModuleFunction(java.lang.ClassLoader r17, java.lang.String r18, io.ktor.server.application.Application r19, io.ktor.server.application.ModuleParametersInjector r20, e9.InterfaceC4014c<? super Y8.t> r21) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 627
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.engine.internal.CallableUtilsKt.executeModuleFunction(java.lang.ClassLoader, java.lang.String, io.ktor.server.application.Application, io.ktor.server.application.ModuleParametersInjector, e9.c):java.lang.Object");
    }
}
