package B3;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.libpag.BuildConfig;

/* loaded from: classes.dex */
public final class a extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    private final List<Throwable> f208a;

    /* renamed from: b, reason: collision with root package name */
    private final String f209b;

    /* renamed from: c, reason: collision with root package name */
    private Throwable f210c;

    /* renamed from: B3.a$a, reason: collision with other inner class name */
    static final class C0003a extends RuntimeException {
        C0003a() {
        }

        @Override // java.lang.Throwable
        public String getMessage() {
            return "Chain of Causes for CompositeException In Order Received =>";
        }
    }

    static abstract class b {
        b() {
        }

        abstract void a(Object obj);
    }

    static final class c extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintStream f211a;

        c(PrintStream printStream) {
            this.f211a = printStream;
        }

        @Override // B3.a.b
        void a(Object obj) {
            this.f211a.println(obj);
        }
    }

    static final class d extends b {

        /* renamed from: a, reason: collision with root package name */
        private final PrintWriter f212a;

        d(PrintWriter printWriter) {
            this.f212a = printWriter;
        }

        @Override // B3.a.b
        void a(Object obj) {
            this.f212a.println(obj);
        }
    }

    public a(Throwable... thArr) {
        this(thArr == null ? Collections.singletonList(new NullPointerException("exceptions was null")) : Arrays.asList(thArr));
    }

    private void a(StringBuilder sb, Throwable th, String str) {
        sb.append(str);
        sb.append(th);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : th.getStackTrace()) {
            sb.append("\t\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        if (th.getCause() != null) {
            sb.append("\tCaused by: ");
            a(sb, th.getCause(), BuildConfig.FLAVOR);
        }
    }

    private List<Throwable> c(Throwable th) {
        ArrayList arrayList = new ArrayList();
        Throwable cause = th.getCause();
        if (cause != null && cause != th) {
            while (true) {
                arrayList.add(cause);
                Throwable cause2 = cause.getCause();
                if (cause2 == null || cause2 == cause) {
                    break;
                }
                cause = cause2;
            }
        }
        return arrayList;
    }

    private void e(b bVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i5 = 1;
        for (Throwable th : this.f208a) {
            sb.append("  ComposedException ");
            sb.append(i5);
            sb.append(" :\n");
            a(sb, th, "\t");
            i5++;
        }
        bVar.a(sb.toString());
    }

    public List<Throwable> b() {
        return this.f208a;
    }

    Throwable d(Throwable th) {
        Throwable cause = th.getCause();
        if (cause == null || th == cause) {
            return th;
        }
        while (true) {
            Throwable cause2 = cause.getCause();
            if (cause2 == null || cause2 == cause) {
                break;
            }
            cause = cause2;
        }
        return cause;
    }

    @Override // java.lang.Throwable
    public synchronized Throwable getCause() {
        try {
            if (this.f210c == null) {
                C0003a c0003a = new C0003a();
                HashSet hashSet = new HashSet();
                Iterator<Throwable> it = this.f208a.iterator();
                Throwable thD = c0003a;
                while (it.hasNext()) {
                    Throwable next = it.next();
                    if (!hashSet.contains(next)) {
                        hashSet.add(next);
                        for (Throwable th : c(next)) {
                            if (hashSet.contains(th)) {
                                next = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th);
                            }
                        }
                        try {
                            thD.initCause(next);
                        } catch (Throwable unused) {
                        }
                        thD = d(thD);
                    }
                }
                this.f210c = c0003a;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f210c;
    }

    @Override // java.lang.Throwable
    public String getMessage() {
        return this.f209b;
    }

    @Override // java.lang.Throwable
    public void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintStream printStream) {
        e(new c(printStream));
    }

    @Override // java.lang.Throwable
    public void printStackTrace(PrintWriter printWriter) {
        e(new d(printWriter));
    }

    public a(Iterable<? extends Throwable> iterable) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (iterable != null) {
            for (Throwable th : iterable) {
                if (th instanceof a) {
                    linkedHashSet.addAll(((a) th).b());
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException("Throwable was null!"));
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException("errors was null"));
        }
        if (!linkedHashSet.isEmpty()) {
            arrayList.addAll(linkedHashSet);
            List<Throwable> listUnmodifiableList = Collections.unmodifiableList(arrayList);
            this.f208a = listUnmodifiableList;
            this.f209b = listUnmodifiableList.size() + " exceptions occurred. ";
            return;
        }
        throw new IllegalArgumentException("errors is empty");
    }
}
