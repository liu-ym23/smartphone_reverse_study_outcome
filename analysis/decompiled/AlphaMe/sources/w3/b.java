package w3;

import androidx.fragment.app.A;
import ch.qos.logback.classic.net.SyslogAppender;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;

/* loaded from: classes2.dex */
public final class b extends RuntimeException {

    /* renamed from: a, reason: collision with root package name */
    public final List f15863a;

    /* renamed from: b, reason: collision with root package name */
    public final String f15864b;

    /* renamed from: c, reason: collision with root package name */
    public A f15865c;

    public b(List list) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                Throwable th = (Throwable) it.next();
                if (th instanceof b) {
                    linkedHashSet.addAll(((b) th).f15863a);
                } else if (th != null) {
                    linkedHashSet.add(th);
                } else {
                    linkedHashSet.add(new NullPointerException());
                }
            }
        } else {
            linkedHashSet.add(new NullPointerException());
        }
        arrayList.addAll(linkedHashSet);
        List listUnmodifiableList = Collections.unmodifiableList(arrayList);
        this.f15863a = listUnmodifiableList;
        this.f15864b = listUnmodifiableList.size() + " exceptions occurred. ";
    }

    public static void a(StringBuilder sb, Throwable th, String str) {
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
            a(sb, th.getCause(), "");
        }
    }

    public final void b(a aVar) {
        StringBuilder sb = new StringBuilder(128);
        sb.append(this);
        sb.append('\n');
        for (StackTraceElement stackTraceElement : getStackTrace()) {
            sb.append("\tat ");
            sb.append(stackTraceElement);
            sb.append('\n');
        }
        int i4 = 1;
        for (Throwable th : this.f15863a) {
            sb.append("  ComposedException ");
            sb.append(i4);
            sb.append(" :\n");
            a(sb, th, SyslogAppender.DEFAULT_STACKTRACE_PATTERN);
            i4++;
        }
        synchronized (aVar.I0()) {
            aVar.J0(sb.toString());
        }
    }

    @Override // java.lang.Throwable
    public final synchronized Throwable getCause() {
        try {
            if (this.f15865c == null) {
                A a4 = new A();
                HashSet hashSet = new HashSet();
                A a5 = a4;
                for (Throwable runtimeException : this.f15863a) {
                    if (!hashSet.contains(runtimeException)) {
                        hashSet.add(runtimeException);
                        ArrayList arrayList = new ArrayList();
                        Throwable cause = runtimeException.getCause();
                        if (cause != null && cause != runtimeException) {
                            while (true) {
                                arrayList.add(cause);
                                Throwable cause2 = cause.getCause();
                                if (cause2 == null || cause2 == cause) {
                                    break;
                                }
                                cause = cause.getCause();
                            }
                        }
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            Throwable th = (Throwable) it.next();
                            if (hashSet.contains(th)) {
                                runtimeException = new RuntimeException("Duplicate found in causal chain so cropping to prevent loop ...");
                            } else {
                                hashSet.add(th);
                            }
                        }
                        try {
                            a5.initCause(runtimeException);
                        } catch (Throwable unused) {
                        }
                        Throwable cause3 = a5.getCause();
                        if (cause3 != null && cause3 != a5) {
                            while (true) {
                                Throwable cause4 = cause3.getCause();
                                if (cause4 == null || cause4 == cause3) {
                                    break;
                                }
                                cause3 = cause3.getCause();
                            }
                            a5 = cause3;
                        }
                    }
                }
                this.f15865c = a4;
            }
        } catch (Throwable th2) {
            throw th2;
        }
        return this.f15865c;
    }

    @Override // java.lang.Throwable
    public final String getMessage() {
        return this.f15864b;
    }

    @Override // java.lang.Throwable
    public final void printStackTrace() {
        printStackTrace(System.err);
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintStream printStream) {
        b(new a(0, printStream));
    }

    @Override // java.lang.Throwable
    public final void printStackTrace(PrintWriter printWriter) {
        b(new a(1, printWriter));
    }
}
