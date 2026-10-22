package reactor.core.publisher;

import reactor.core.Scannable;
import reactor.util.Logger;
import reactor.util.Loggers;

/* loaded from: classes4.dex */
final class ContextPropagationSupport {
    static final boolean isContextPropagation101OnClasspath;
    static final boolean isContextPropagation103OnClasspath;
    static final boolean isContextPropagationOnClasspath;
    static final Logger LOGGER = Loggers.getLogger((Class<?>) ContextPropagationSupport.class);
    static boolean propagateContextToThreadLocals = false;

    /* JADX WARN: Removed duplicated region for block: B:20:0x0048 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    static {
        /*
            java.lang.Class<reactor.core.publisher.ContextPropagationSupport> r0 = reactor.core.publisher.ContextPropagationSupport.class
            reactor.util.Logger r0 = reactor.util.Loggers.getLogger(r0)
            reactor.core.publisher.ContextPropagationSupport.LOGGER = r0
            r0 = 0
            reactor.core.publisher.ContextPropagationSupport.propagateContextToThreadLocals = r0
            java.lang.String r1 = "io.micrometer.context.ContextRegistry"
            java.lang.Class.forName(r1)     // Catch: java.lang.Throwable -> L34 java.lang.Throwable -> L37
            r1 = 1
            java.lang.String r2 = "io.micrometer.context.ThreadLocalAccessor"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L30
            java.lang.String r3 = "restore"
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            java.lang.Class[] r4 = new java.lang.Class[]{r4}     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L30
            r2.getDeclaredMethod(r3, r4)     // Catch: java.lang.Throwable -> L28 java.lang.Throwable -> L30
            java.lang.String r2 = "io.micrometer.context.ContextSnapshotFactory"
            java.lang.Class.forName(r2)     // Catch: java.lang.Throwable -> L2a java.lang.Throwable -> L2e
            r0 = r1
        L28:
            r2 = r0
            goto L40
        L2a:
            r2 = move-exception
        L2b:
            r3 = r2
            r2 = r1
            goto L39
        L2e:
            r2 = r1
            goto L40
        L30:
            r2 = move-exception
            r3 = r2
            r2 = r0
            goto L39
        L34:
            r2 = move-exception
            r1 = r0
            goto L2b
        L37:
            r1 = r0
            goto L2e
        L39:
            reactor.util.Logger r4 = reactor.core.publisher.ContextPropagationSupport.LOGGER
            java.lang.String r5 = "Unexpected exception while detecting ContextPropagation feature. The feature is considered disabled due to this:"
            r4.error(r5, r3)
        L40:
            reactor.core.publisher.ContextPropagationSupport.isContextPropagationOnClasspath = r1
            reactor.core.publisher.ContextPropagationSupport.isContextPropagation101OnClasspath = r2
            reactor.core.publisher.ContextPropagationSupport.isContextPropagation103OnClasspath = r0
            if (r1 == 0) goto L51
            if (r0 != 0) goto L51
            reactor.util.Logger r0 = reactor.core.publisher.ContextPropagationSupport.LOGGER
            java.lang.String r1 = "context-propagation version below 1.0.3 can cause memory leaks when working with scope-based ThreadLocalAccessors, please upgrade!"
            r0.warn(r1)
        L51:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.ContextPropagationSupport.<clinit>():void");
    }

    public static boolean isContextPropagation101Available() {
        return isContextPropagation101OnClasspath;
    }

    public static boolean isContextPropagation103Available() {
        return isContextPropagation103OnClasspath;
    }

    public static boolean isContextPropagationAvailable() {
        return isContextPropagationOnClasspath;
    }

    public static boolean shouldPropagateContextToThreadLocals() {
        return isContextPropagationOnClasspath && propagateContextToThreadLocals;
    }

    public static boolean shouldRestoreThreadLocalsInSomeOperators() {
        return isContextPropagationOnClasspath && !propagateContextToThreadLocals;
    }

    public static boolean shouldWrapPublisher(Z9.c cVar) {
        return shouldPropagateContextToThreadLocals() && !((Boolean) Scannable.from(cVar).scanOrDefault(InternalProducerAttr.INSTANCE, Boolean.FALSE)).booleanValue();
    }
}
