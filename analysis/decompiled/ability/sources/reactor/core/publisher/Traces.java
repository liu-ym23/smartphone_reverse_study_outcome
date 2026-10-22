package reactor.core.publisher;

import java.util.function.Supplier;

/* loaded from: classes4.dex */
final class Traces {
    static final String CALL_SITE_GLUE = " ⇢ ";
    static final boolean full = Boolean.parseBoolean(System.getProperty("reactor.trace.assembly.fullstacktrace", "false"));
    static final Supplier<Supplier<String>> callSiteSupplierFactory = new CallSiteSupplierFactory();

    public static String extractOperatorAssemblyInformation(String str) {
        String[] strArrExtractOperatorAssemblyInformationParts = extractOperatorAssemblyInformationParts(str);
        return strArrExtractOperatorAssemblyInformationParts.length != 0 ? String.join(CALL_SITE_GLUE, strArrExtractOperatorAssemblyInformationParts) : "[no operator assembly information]";
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] extractOperatorAssemblyInformationParts(java.lang.String r5) {
        /*
            java.lang.String r0 = "\n"
            java.lang.String[] r5 = r5.split(r0)
            java.util.stream.Stream r5 = java.util.stream.Stream.of(r5)
            reactor.core.publisher.W r0 = new reactor.core.publisher.W
            r1 = 3
            r0.<init>(r1)
            java.util.stream.Stream r5 = r5.map(r0)
            reactor.core.publisher.L r0 = new reactor.core.publisher.L
            r1 = 2
            r0.<init>(r1)
            java.util.stream.Stream r5 = r5.filter(r0)
            java.util.stream.Collector r0 = java.util.stream.Collectors.toList()
            java.lang.Object r5 = r5.collect(r0)
            java.util.List r5 = (java.util.List) r5
            boolean r0 = r5.isEmpty()
            r1 = 0
            if (r0 == 0) goto L32
            java.lang.String[] r5 = new java.lang.String[r1]
            return r5
        L32:
            r0 = r1
        L33:
            int r2 = r5.size()
            if (r0 >= r2) goto L48
            java.lang.Object r2 = r5.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = isUserCode(r2)
            if (r2 != 0) goto L48
            int r0 = r0 + 1
            goto L33
        L48:
            java.lang.String r2 = "reactor.core.publisher."
            java.lang.String r3 = ""
            if (r0 != 0) goto L56
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
        L54:
            r4 = r3
            goto L77
        L56:
            int r4 = r5.size()
            if (r0 != r4) goto L69
            int r0 = r0 + (-1)
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = r5.replaceFirst(r2, r3)
            goto L54
        L69:
            int r4 = r0 + (-1)
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
        L77:
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L82
            java.lang.String[] r5 = new java.lang.String[]{r5}
            return r5
        L82:
            r0 = 40
            int r0 = r4.indexOf(r0)
            if (r0 <= 0) goto L8e
            java.lang.String r4 = r4.substring(r1, r0)
        L8e:
            java.lang.String r0 = r4.replaceFirst(r2, r3)
            java.lang.String r1 = "at "
            java.lang.String r5 = B7.a.k(r1, r5)
            java.lang.String[] r5 = new java.lang.String[]{r0, r5}
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.Traces.extractOperatorAssemblyInformationParts(java.lang.String):java.lang.String[]");
    }

    public static boolean isUserCode(String str) {
        return !str.startsWith("reactor.core.publisher") || str.contains("Test");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$extractOperatorAssemblyInformationParts$0(String str) {
        return !str.isEmpty();
    }

    public static boolean shouldSanitize(String str) {
        return str.startsWith("java.util.function") || str.startsWith("reactor.core.publisher.Mono.onAssembly") || str.equals("reactor.core.publisher.Mono.onAssembly") || str.equals("reactor.core.publisher.Flux.onAssembly") || str.equals("reactor.core.publisher.ParallelFlux.onAssembly") || str.startsWith("reactor.core.publisher.SignalLogger") || str.startsWith("reactor.core.publisher.FluxOnAssembly") || str.startsWith("reactor.core.publisher.MonoOnAssembly.") || str.startsWith("reactor.core.publisher.MonoCallableOnAssembly.") || str.startsWith("reactor.core.publisher.FluxCallableOnAssembly.") || str.startsWith("reactor.core.publisher.Hooks") || str.startsWith("sun.reflect") || str.startsWith("java.util.concurrent.ThreadPoolExecutor") || str.startsWith("java.lang.reflect");
    }
}
