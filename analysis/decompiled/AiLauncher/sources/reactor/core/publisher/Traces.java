package reactor.core.publisher;

import java.util.function.Supplier;

/* loaded from: classes5.dex */
final class Traces {
    static final String CALL_SITE_GLUE = " ⇢ ";
    static final boolean full = Boolean.parseBoolean(System.getProperty("reactor.trace.assembly.fullstacktrace", "false"));
    static final Supplier<Supplier<String>> callSiteSupplierFactory = new CallSiteSupplierFactory();

    public static /* synthetic */ boolean a(String str) {
        return !str.isEmpty();
    }

    public static String extractOperatorAssemblyInformation(String str) {
        String[] strArrExtractOperatorAssemblyInformationParts = extractOperatorAssemblyInformationParts(str);
        return strArrExtractOperatorAssemblyInformationParts.length != 0 ? String.join(CALL_SITE_GLUE, strArrExtractOperatorAssemblyInformationParts) : "[no operator assembly information]";
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String[] extractOperatorAssemblyInformationParts(java.lang.String r5) {
        /*
            java.lang.String r0 = "\n"
            java.lang.String[] r5 = r5.split(r0)
            java.util.stream.Stream r5 = java.util.stream.Stream.of(r5)
            reactor.core.publisher.J2 r0 = new reactor.core.publisher.J2
            r0.<init>()
            java.util.stream.Stream r5 = r5.map(r0)
            reactor.core.publisher.K2 r0 = new reactor.core.publisher.K2
            r0.<init>()
            java.util.stream.Stream r5 = r5.filter(r0)
            java.util.stream.Collector r0 = java.util.stream.Collectors.toList()
            java.lang.Object r5 = r5.collect(r0)
            java.util.List r5 = (java.util.List) r5
            boolean r0 = r5.isEmpty()
            r1 = 0
            if (r0 == 0) goto L30
            java.lang.String[] r5 = new java.lang.String[r1]
            return r5
        L30:
            r0 = r1
        L31:
            int r2 = r5.size()
            if (r0 >= r2) goto L46
            java.lang.Object r2 = r5.get(r0)
            java.lang.String r2 = (java.lang.String) r2
            boolean r2 = isUserCode(r2)
            if (r2 != 0) goto L46
            int r0 = r0 + 1
            goto L31
        L46:
            java.lang.String r2 = "reactor.core.publisher."
            java.lang.String r3 = ""
            if (r0 != 0) goto L54
            java.lang.Object r5 = r5.get(r1)
            java.lang.String r5 = (java.lang.String) r5
        L52:
            r4 = r3
            goto L75
        L54:
            int r4 = r5.size()
            if (r0 != r4) goto L67
            int r0 = r0 + (-1)
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r5 = r5.replaceFirst(r2, r3)
            goto L52
        L67:
            int r4 = r0 + (-1)
            java.lang.Object r4 = r5.get(r4)
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r5 = r5.get(r0)
            java.lang.String r5 = (java.lang.String) r5
        L75:
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto L80
            java.lang.String[] r5 = new java.lang.String[]{r5}
            return r5
        L80:
            r0 = 40
            int r0 = r4.indexOf(r0)
            if (r0 <= 0) goto L8c
            java.lang.String r4 = r4.substring(r1, r0)
        L8c:
            java.lang.String r0 = r4.replaceFirst(r2, r3)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "at "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            java.lang.String[] r5 = new java.lang.String[]{r0, r5}
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: reactor.core.publisher.Traces.extractOperatorAssemblyInformationParts(java.lang.String):java.lang.String[]");
    }

    public static boolean isUserCode(String str) {
        return !str.startsWith("reactor.core.publisher") || str.contains("Test");
    }

    public static boolean shouldSanitize(String str) {
        return str.startsWith("java.util.function") || str.startsWith("reactor.core.publisher.Mono.onAssembly") || str.equals("reactor.core.publisher.Mono.onAssembly") || str.equals("reactor.core.publisher.Flux.onAssembly") || str.equals("reactor.core.publisher.ParallelFlux.onAssembly") || str.startsWith("reactor.core.publisher.SignalLogger") || str.startsWith("reactor.core.publisher.FluxOnAssembly") || str.startsWith("reactor.core.publisher.MonoOnAssembly.") || str.startsWith("reactor.core.publisher.MonoCallableOnAssembly.") || str.startsWith("reactor.core.publisher.FluxCallableOnAssembly.") || str.startsWith("reactor.core.publisher.Hooks") || str.startsWith("sun.reflect") || str.startsWith("java.util.concurrent.ThreadPoolExecutor") || str.startsWith("java.lang.reflect");
    }
}
