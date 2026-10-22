package reactor.core.publisher;

import java.util.function.Supplier;
import java.util.stream.Stream;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

/* loaded from: classes4.dex */
class CallSiteSupplierFactory implements Supplier<Supplier<String>> {
    static final Supplier<Supplier<String>> supplier;

    public static class ExceptionCallSiteSupplierFactory implements Supplier<Supplier<String>> {

        public static class TracingException extends Throwable implements Supplier<String> {
            @Override // java.util.function.Supplier
            public String get() {
                StackTraceElement[] stackTrace = getStackTrace();
                StackTraceElement stackTraceElement = null;
                for (int i = 4; i < stackTrace.length; i++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    String className = stackTraceElement2.getClassName();
                    if (Traces.isUserCode(className)) {
                        StringBuilder sb = new StringBuilder();
                        if (stackTraceElement != null) {
                            sb.append("\t");
                            sb.append(stackTraceElement.toString());
                            sb.append("\n");
                        }
                        sb.append("\t");
                        sb.append(stackTraceElement2.toString());
                        sb.append("\n");
                        return sb.toString();
                    }
                    boolean z10 = Traces.full;
                    if (z10 || stackTraceElement2.getLineNumber() > 1) {
                        StringBuilder sbX = androidx.appfunctions.metadata.a.x(className, ".");
                        sbX.append(stackTraceElement2.getMethodName());
                        String string = sbX.toString();
                        if (z10 || !Traces.shouldSanitize(string)) {
                            stackTraceElement = stackTraceElement2;
                        }
                    }
                }
                return "";
            }
        }

        @Override // java.util.function.Supplier
        public Supplier<String> get() {
            return new TracingException();
        }
    }

    public static class SharedSecretsCallSiteSupplierFactory implements Supplier<Supplier<String>> {

        public static class TracingException extends Throwable implements Supplier<String> {
            static final JavaLangAccess javaLangAccess = SharedSecrets.getJavaLangAccess();

            @Override // java.util.function.Supplier
            public String get() {
                int stackTraceDepth = javaLangAccess.getStackTraceDepth(this);
                StackTraceElement stackTraceElement = null;
                for (int i = 4; i < stackTraceDepth; i++) {
                    StackTraceElement stackTraceElement2 = javaLangAccess.getStackTraceElement(this, i);
                    String className = stackTraceElement2.getClassName();
                    if (Traces.isUserCode(className)) {
                        StringBuilder sb = new StringBuilder();
                        if (stackTraceElement != null) {
                            sb.append("\t");
                            sb.append(stackTraceElement.toString());
                            sb.append("\n");
                        }
                        sb.append("\t");
                        sb.append(stackTraceElement2.toString());
                        sb.append("\n");
                        return sb.toString();
                    }
                    boolean z10 = Traces.full;
                    if (z10 || stackTraceElement2.getLineNumber() > 1) {
                        StringBuilder sbX = androidx.appfunctions.metadata.a.x(className, ".");
                        sbX.append(stackTraceElement2.getMethodName());
                        String string = sbX.toString();
                        if (z10 || !Traces.shouldSanitize(string)) {
                            stackTraceElement = stackTraceElement2;
                        }
                    }
                }
                return "";
            }
        }

        static {
            SharedSecrets.getJavaLangAccess();
        }

        @Override // java.util.function.Supplier
        public Supplier<String> get() {
            return new TracingException();
        }
    }

    static {
        int i = 0;
        supplier = (Supplier) Stream.of((Object[]) new String[]{CallSiteSupplierFactory.class.getName().concat("$SharedSecretsCallSiteSupplierFactory"), CallSiteSupplierFactory.class.getName().concat("$ExceptionCallSiteSupplierFactory")}).flatMap(new C1885a(i)).findFirst().orElseThrow(new C1886b(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ Stream lambda$static$0(String str) {
        try {
            return Stream.of((Supplier) Class.forName(str).getDeclaredConstructor(null).newInstance(null));
        } catch (LinkageError unused) {
            return Stream.empty();
        } catch (Throwable unused2) {
            return Stream.empty();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ IllegalStateException lambda$static$1() {
        return new IllegalStateException("Valid strategy not found");
    }

    @Override // java.util.function.Supplier
    public Supplier<String> get() {
        return supplier.get();
    }
}
