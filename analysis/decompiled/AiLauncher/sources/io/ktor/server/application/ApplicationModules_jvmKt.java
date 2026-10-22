package io.ktor.server.application;

import Ua.C1056g;
import Ua.I;
import Ua.J;
import Ua.M;
import Ua.Y;
import Y8.t;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.InterfaceC4112d;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import p9.p;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\"\u0018\u0010\u0004\u001a\u00020\u0001*\u00020\u00008@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003\"\u001a\u0010\u0005\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u001a\u0010\t\u001a\u00020\u00018\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\t\u0010\u0006\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lio/ktor/server/application/ApplicationEnvironment;", "Lio/ktor/server/application/ApplicationModuleLoader;", "getModuleLoader", "(Lio/ktor/server/application/ApplicationEnvironment;)Lio/ktor/server/application/ApplicationModuleLoader;", "moduleLoader", "LoadSequentially", "Lio/ktor/server/application/ApplicationModuleLoader;", "getLoadSequentially", "()Lio/ktor/server/application/ApplicationModuleLoader;", "LoadConcurrently", "getLoadConcurrently", "ktor-server-core"}, k = 2, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationModules_jvmKt {
    private static final ApplicationModuleLoader LoadSequentially = ApplicationModules_jvmKt$LoadSequentially$1.INSTANCE;
    private static final ApplicationModuleLoader LoadConcurrently = new ApplicationModuleLoader() { // from class: io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 1, 0})
        @InterfaceC4112d(c = "io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1$2", f = "ApplicationModules.jvm.kt", l = {59, 65}, m = "invokeSuspend")
        /* renamed from: io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1$2, reason: invalid class name */
        public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super t>, Object> {
            final /* synthetic */ Application $application;
            final /* synthetic */ ClassLoader $classLoader;
            final /* synthetic */ List<Throwable> $errors;
            final /* synthetic */ List<DynamicApplicationModule> $modules;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(List<DynamicApplicationModule> list, Application application, List<Throwable> list2, ClassLoader classLoader, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
                super(2, interfaceC4014c);
                this.$modules = list;
                this.$application = application;
                this.$errors = list2;
                this.$classLoader = classLoader;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$modules, this.$application, this.$errors, this.$classLoader, interfaceC4014c);
                anonymousClass2.L$0 = obj;
                return anonymousClass2;
            }

            @Override // p9.p
            public final Object invoke(M m10, InterfaceC4014c<? super t> interfaceC4014c) {
                return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
            }

            /* JADX WARN: Code restructure failed: missing block: B:19:0x0085, code lost:
            
                if (kotlinx.coroutines.AwaitKt.b(r1, r13) == r0) goto L20;
             */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
                /*
                    r13 = this;
                    java.lang.Object r0 = f9.C4063a.g()
                    int r1 = r13.label
                    r2 = 0
                    r3 = 2
                    r4 = 1
                    if (r1 == 0) goto L24
                    if (r1 == r4) goto L1c
                    if (r1 != r3) goto L14
                    kotlin.C4849c.b(r14)
                    goto L88
                L14:
                    java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
                    java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
                    r13.<init>(r14)
                    throw r13
                L1c:
                    java.lang.Object r1 = r13.L$0
                    java.util.List r1 = (java.util.List) r1
                    kotlin.C4849c.b(r14)
                    goto L6c
                L24:
                    kotlin.C4849c.b(r14)
                    java.lang.Object r14 = r13.L$0
                    r5 = r14
                    Ua.M r5 = (Ua.M) r5
                    java.util.List<io.ktor.server.application.DynamicApplicationModule> r14 = r13.$modules
                    java.lang.Iterable r14 = (java.lang.Iterable) r14
                    io.ktor.server.application.Application r1 = r13.$application
                    java.lang.ClassLoader r11 = r13.$classLoader
                    java.util.ArrayList r12 = new java.util.ArrayList
                    r6 = 10
                    int r6 = Z8.C1174w.x(r14, r6)
                    r12.<init>(r6)
                    java.util.Iterator r14 = r14.iterator()
                L43:
                    boolean r6 = r14.hasNext()
                    if (r6 == 0) goto L60
                    java.lang.Object r6 = r14.next()
                    io.ktor.server.application.DynamicApplicationModule r6 = (io.ktor.server.application.DynamicApplicationModule) r6
                    io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1 r8 = new io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1$2$jobs$1$1
                    r8.<init>(r6, r1, r11, r2)
                    r9 = 3
                    r10 = 0
                    r6 = 0
                    r7 = 0
                    kotlinx.coroutines.g r6 = Ua.C1056g.d(r5, r6, r7, r8, r9, r10)
                    r12.add(r6)
                    goto L43
                L60:
                    r13.L$0 = r12
                    r13.label = r4
                    java.lang.Object r14 = Ua.W0.a(r13)
                    if (r14 != r0) goto L6b
                    goto L87
                L6b:
                    r1 = r12
                L6c:
                    io.ktor.server.application.Application r14 = r13.$application
                    io.ktor.events.Events r14 = r14.getMonitor()
                    io.ktor.events.EventDefinition r5 = io.ktor.server.application.DefaultApplicationEventsKt.getApplicationModulesLoading()
                    io.ktor.server.application.Application r6 = r13.$application
                    r14.raise(r5, r6)
                    java.util.Collection r1 = (java.util.Collection) r1
                    r13.L$0 = r2
                    r13.label = r3
                    java.lang.Object r14 = kotlinx.coroutines.AwaitKt.b(r1, r13)
                    if (r14 != r0) goto L88
                L87:
                    return r0
                L88:
                    java.util.List<java.lang.Throwable> r14 = r13.$errors
                    java.util.Collection r14 = (java.util.Collection) r14
                    boolean r14 = r14.isEmpty()
                    if (r14 != 0) goto Lb9
                    java.util.List<java.lang.Throwable> r14 = r13.$errors
                    java.lang.Object r14 = Z8.F.q0(r14)
                    java.util.List<java.lang.Throwable> r13 = r13.$errors
                    java.lang.Throwable r14 = (java.lang.Throwable) r14
                    java.lang.Iterable r13 = (java.lang.Iterable) r13
                    java.util.List r13 = Z8.F.h0(r13, r4)
                    java.lang.Iterable r13 = (java.lang.Iterable) r13
                    java.util.Iterator r13 = r13.iterator()
                La8:
                    boolean r0 = r13.hasNext()
                    if (r0 == 0) goto Lb8
                    java.lang.Object r0 = r13.next()
                    java.lang.Throwable r0 = (java.lang.Throwable) r0
                    Y8.d.a(r14, r0)
                    goto La8
                Lb8:
                    throw r14
                Lb9:
                    Y8.t r13 = Y8.t.f7040a
                    return r13
                */
                throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.ApplicationModules_jvmKt$LoadConcurrently$1.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        @Override // io.ktor.server.application.ApplicationModuleLoader
        public final Object loadModules(Application application, ClassLoader classLoader, List<DynamicApplicationModule> list, InterfaceC4014c<? super t> interfaceC4014c) {
            ArrayList arrayList = new ArrayList();
            Object objJ = C1056g.j(application.getCoroutineContext().plus(new ApplicationModules_jvmKt$LoadConcurrently$1$loadModules$$inlined$CoroutineExceptionHandler$1(J.INSTANCE, application, arrayList)).plus(I.t1(Y.a(), 1, null, 2, null)), new AnonymousClass2(list, application, arrayList, classLoader, null), interfaceC4014c);
            return objJ == C4063a.g() ? objJ : t.f7040a;
        }
    };

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ApplicationStartupMode.values().length];
            try {
                iArr[ApplicationStartupMode.SEQUENTIAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ApplicationStartupMode.CONCURRENT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final ApplicationModuleLoader getLoadConcurrently() {
        return LoadConcurrently;
    }

    public static final ApplicationModuleLoader getLoadSequentially() {
        return LoadSequentially;
    }

    public static final ApplicationModuleLoader getModuleLoader(ApplicationEnvironment applicationEnvironment) {
        kotlin.jvm.internal.p.i(applicationEnvironment, "<this>");
        int i10 = WhenMappings.$EnumSwitchMapping$0[ApplicationModulesKt.getStartupMode(applicationEnvironment).ordinal()];
        if (i10 == 1) {
            return LoadSequentially;
        }
        if (i10 == 2) {
            return LoadConcurrently;
        }
        throw new NoWhenBranchMatchedException();
    }
}
