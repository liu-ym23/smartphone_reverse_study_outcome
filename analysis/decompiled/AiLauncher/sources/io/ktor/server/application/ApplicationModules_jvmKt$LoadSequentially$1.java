package io.ktor.server.application;

import kotlin.Metadata;

@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class ApplicationModules_jvmKt$LoadSequentially$1 implements ApplicationModuleLoader {
    public static final ApplicationModules_jvmKt$LoadSequentially$1 INSTANCE = new ApplicationModules_jvmKt$LoadSequentially$1();

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // io.ktor.server.application.ApplicationModuleLoader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object loadModules(io.ktor.server.application.Application r6, java.lang.ClassLoader r7, java.util.List<io.ktor.server.application.DynamicApplicationModule> r8, e9.InterfaceC4014c<? super Y8.t> r9) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r9 instanceof io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1
            if (r0 == 0) goto L13
            r0 = r9
            io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1 r0 = (io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1 r0 = new io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1$loadModules$1
            r0.<init>(r5, r9)
        L18:
            java.lang.Object r5 = r0.result
            java.lang.Object r9 = f9.C4063a.g()
            int r1 = r0.label
            r2 = 1
            if (r1 == 0) goto L3e
            if (r1 != r2) goto L36
            java.lang.Object r6 = r0.L$2
            java.util.Iterator r6 = (java.util.Iterator) r6
            java.lang.Object r7 = r0.L$1
            java.lang.ClassLoader r7 = (java.lang.ClassLoader) r7
            java.lang.Object r8 = r0.L$0
            io.ktor.server.application.Application r8 = (io.ktor.server.application.Application) r8
            kotlin.C4849c.b(r5)
            r5 = r8
            goto L53
        L36:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3e:
            kotlin.C4849c.b(r5)
            io.ktor.events.Events r5 = r6.getMonitor()
            io.ktor.events.EventDefinition r1 = io.ktor.server.application.DefaultApplicationEventsKt.getApplicationModulesLoading()
            r5.raise(r1, r6)
            java.util.Iterator r5 = r8.iterator()
            r4 = r6
            r6 = r5
            r5 = r4
        L53:
            boolean r8 = r6.hasNext()
            if (r8 == 0) goto L72
            java.lang.Object r8 = r6.next()
            io.ktor.server.application.DynamicApplicationModule r8 = (io.ktor.server.application.DynamicApplicationModule) r8
            p9.q r8 = r8.getFunction()
            r0.L$0 = r5
            r0.L$1 = r7
            r0.L$2 = r6
            r0.label = r2
            java.lang.Object r8 = r8.invoke(r5, r7, r0)
            if (r8 != r9) goto L53
            return r9
        L72:
            Y8.t r5 = Y8.t.f7040a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.server.application.ApplicationModules_jvmKt$LoadSequentially$1.loadModules(io.ktor.server.application.Application, java.lang.ClassLoader, java.util.List, e9.c):java.lang.Object");
    }
}
