package reactor.core.publisher;

import java.util.function.Supplier;
import java.util.stream.Stream;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes2.dex */
class CallSiteSupplierFactory implements Supplier<Supplier<String>> {
    static final Supplier<Supplier<String>> supplier;

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class ExceptionCallSiteSupplierFactory implements Supplier<Supplier<String>> {

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
        public static class TracingException extends Throwable implements Supplier<String> {
            @Override // java.util.function.Supplier
            public String get() {
                StackTraceElement[] stackTrace = getStackTrace();
                StackTraceElement stackTraceElement = null;
                for (int i = 4; i < stackTrace.length; i++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    String className = stackTraceElement2.getClassName();
                    if (Traces.isUserCode(className)) {
                        StringBuilder sb2 = new StringBuilder();
                        if (stackTraceElement != null) {
                            sb2.append("\t");
                            sb2.append(stackTraceElement.toString());
                            sb2.append("\n");
                        }
                        sb2.append("\t");
                        sb2.append(stackTraceElement2.toString());
                        sb2.append("\n");
                        return sb2.toString();
                    }
                    boolean z10 = Traces.full;
                    if (z10 || stackTraceElement2.getLineNumber() > 1) {
                        StringBuilder sbV = k0.a.v(className, ".");
                        sbV.append(stackTraceElement2.getMethodName());
                        String string = sbV.toString();
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

    /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
    public static class SharedSecretsCallSiteSupplierFactory implements Supplier<Supplier<String>> {

        /* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
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
                        StringBuilder sb2 = new StringBuilder();
                        if (stackTraceElement != null) {
                            sb2.append("\t");
                            sb2.append(stackTraceElement.toString());
                            sb2.append("\n");
                        }
                        sb2.append("\t");
                        sb2.append(stackTraceElement2.toString());
                        sb2.append("\n");
                        return sb2.toString();
                    }
                    boolean z10 = Traces.full;
                    if (z10 || stackTraceElement2.getLineNumber() > 1) {
                        StringBuilder sbV = k0.a.v(className, ".");
                        sbV.append(stackTraceElement2.getMethodName());
                        String string = sbV.toString();
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
        supplier = (Supplier) Stream.of((Object[]) new String[]{CallSiteSupplierFactory.class.getName().concat("$SharedSecretsCallSiteSupplierFactory"), CallSiteSupplierFactory.class.getName().concat("$ExceptionCallSiteSupplierFactory")}).flatMap(new a(i)).findFirst().orElseThrow(new b(i));
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
