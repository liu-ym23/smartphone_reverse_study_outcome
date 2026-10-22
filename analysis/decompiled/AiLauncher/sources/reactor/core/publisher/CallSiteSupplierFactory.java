package reactor.core.publisher;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;
import sun.misc.JavaLangAccess;
import sun.misc.SharedSecrets;

/* loaded from: classes5.dex */
class CallSiteSupplierFactory implements Supplier<Supplier<String>> {
    static final Supplier<Supplier<String>> supplier = (Supplier) Stream.of((Object[]) new String[]{CallSiteSupplierFactory.class.getName() + "$SharedSecretsCallSiteSupplierFactory", CallSiteSupplierFactory.class.getName() + "$ExceptionCallSiteSupplierFactory"}).flatMap(new Function() { // from class: reactor.core.publisher.a
        @Override // java.util.function.Function
        public final Object apply(Object obj) {
            return CallSiteSupplierFactory.a((String) obj);
        }
    }).findFirst().orElseThrow(new Supplier() { // from class: reactor.core.publisher.b
        @Override // java.util.function.Supplier
        public final Object get() {
            return CallSiteSupplierFactory.b();
        }
    });

    public static class ExceptionCallSiteSupplierFactory implements Supplier<Supplier<String>> {

        public static class TracingException extends Throwable implements Supplier<String> {
            @Override // java.util.function.Supplier
            public String get() {
                StackTraceElement[] stackTrace = getStackTrace();
                StackTraceElement stackTraceElement = null;
                for (int i10 = 4; i10 < stackTrace.length; i10++) {
                    StackTraceElement stackTraceElement2 = stackTrace[i10];
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
                        String str = className + "." + stackTraceElement2.getMethodName();
                        if (z10 || !Traces.shouldSanitize(str)) {
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
                for (int i10 = 4; i10 < stackTraceDepth; i10++) {
                    StackTraceElement stackTraceElement2 = javaLangAccess.getStackTraceElement(this, i10);
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
                        String str = className + "." + stackTraceElement2.getMethodName();
                        if (z10 || !Traces.shouldSanitize(str)) {
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

    public static /* synthetic */ Stream a(String str) {
        try {
            return Stream.of((Supplier) Class.forName(str).getDeclaredConstructor(null).newInstance(null));
        } catch (LinkageError unused) {
            return Stream.empty();
        } catch (Throwable unused2) {
            return Stream.empty();
        }
    }

    public static /* synthetic */ IllegalStateException b() {
        return new IllegalStateException("Valid strategy not found");
    }

    @Override // java.util.function.Supplier
    public Supplier<String> get() {
        return supplier.get();
    }
}
